package de.dfki.cos.basys.common.component.manager.impl;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

import de.dfki.cos.basys.common.component.Component;
import de.dfki.cos.basys.common.component.ComponentException;
import de.dfki.cos.basys.common.component.ServiceConnection;
import de.dfki.cos.basys.common.component.StringConstants;
import de.dfki.cos.basys.common.component.impl.BaseComponent;
import de.dfki.cos.basys.common.component.impl.ServiceManagerImpl;
import de.dfki.cos.basys.common.component.manager.ComponentConfigurationProvider;
import de.dfki.cos.basys.common.component.manager.ComponentManager;
import de.dfki.cos.basys.common.component.manager.ComponentManagerException;


public class ComponentManagerImpl extends BaseComponent implements ComponentManager {
	
	private Map<String, Component> components = new HashMap<>();
	
	private boolean async = false;
	
	public ComponentManagerImpl(Properties config) {
		super(config);
		connectionManager = new ServiceManagerImpl(config, new Supplier<ComponentConfigurationProviderImpl>() {
			@Override
			public ComponentConfigurationProviderImpl get() {
				ComponentConfigurationProviderImpl service = new ComponentConfigurationProviderImpl(config);				
				return service;
			}
		});	
		
		if (config.containsKey("async")) {
			async = Boolean.parseBoolean(config.getProperty("async"));
			LOGGER.info("async = " + async);
		}
	}

	public ComponentManagerImpl(Properties config, ServiceConnection connection) {
		super(config);
		connectionManager = new ServiceManagerImpl(config, new Supplier<ServiceConnection>() {
			@Override
			public ServiceConnection get() {						
				return connection;
			}
		});	
		
		if (config.containsKey("async")) {
			async = Boolean.parseBoolean(config.getProperty("async"));
			LOGGER.info("async = " + async);
		}
	}
	
	@Override
	protected void doActivate() throws ComponentException {	
		if (this.isConnected()) {
		
			Runnable r = new Runnable() {				
				@Override
				public void run() {
					ComponentConfigurationProvider service = connectionManager.getServiceInterface(ComponentConfigurationProvider.class);
					List<String> configs = service.getComponentConfigurationPaths();
										
					for (String path : configs) {
						try {		
							Properties config = service.getComponentConfiguration(path);
							createComponent(config);
						}
						catch (ComponentManagerException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							//throw new RuntimeException(e);
						}												
					} 					
					
					LOGGER.info("component creation complete");
					
				}
			};
			if (async) {
				//scheduledExecutorService.schedule(r, 10, TimeUnit.SECONDS);
					
				CompletableFuture<Void> cf = CompletableFuture.runAsync(r, context.getScheduledExecutorService()).exceptionally(e-> {		    
					e.printStackTrace();
					LOGGER.error(e.getMessage(), e);
				    return null;
				});
			} else {
				r.run();
			}
		}
	}
	
	@Override
	protected void doDeactivate() throws ComponentException {
		for (Component c : components.values()) {
			c.deactivate();
		}		
	}

	@Override
	public List<Component> getComponents() {
		return new ArrayList<Component>(components.values());
	}

	@Override
	public Component getComponentById(String id) {
		return components.get(id);
	}

	@Override
	public Component getComponentByName(String name) {
		for (Component component : components.values()) {
			if (component.getName().equals(name))
				return component;
		}
		return null;
	}

	@Override
	public Component createComponent(Properties config) throws ComponentManagerException {
		//FIXME: actually, we must check globally via the registry
		if (components.containsKey(config.getProperty(StringConstants.id))) {
			Component old = components.get(config.getProperty(StringConstants.id));
			LOGGER.error("Duplicate component with Id: " + config.getProperty(StringConstants.id));
			LOGGER.error("Name of 1st component: " + old.getName());
			LOGGER.error("Name of 2nd component: " + config.getProperty(StringConstants.name));
			throw new ComponentManagerException("Duplicate component with Id " + config.getProperty(StringConstants.id));
		}
		
		Class c = null;
		try {
			
//			ClassLoader cl1 = Thread.currentThread().getContextClassLoader();
//			c = cl1.loadClass(config.getComponentImplementationJavaClass());
//			
//			ClassLoader cl2 = getClass().getClassLoader();
//			c = cl2.loadClass(config.getComponentImplementationJavaClass());
//			
//			c = componentCreationClassLoader.loadClass(config.getComponentImplementationJavaClass());
			LOGGER.debug("Try loading class " + config.getProperty("implementationJavaClass") + " using class loader " + this.getClass().getClassLoader().toString());
			c = Class.forName(config.getProperty("implementationJavaClass"));
		} catch (ClassNotFoundException e) {
			throw new ComponentManagerException(e);
		}

		Component component = null;		
		
		try {
//			Constructor<Module> constructor = c.getConstructor();
//			Module module = constructor.newInstance();
//			Injector injector = Guice.createInjector(module);
//			component = injector.getInstance(Component.class);
			
			Constructor<Component> constructor = c.getConstructor(Properties.class);
			component = constructor.newInstance(config);
			addComponent(component);

		} catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException e) {
			throw new ComponentManagerException(e);
		}
		return component;
	}

	@Override
	public void addComponent(Component component) throws ComponentManagerException {
		LOGGER.debug("addComponent " + component.getName());
		components.put(component.getId(), component);
		try {
			component.activate(context);
		} catch (ComponentException e) {
			throw new ComponentManagerException(e);
		}
		
		notifyChange();
	}

	@Override
	public void deleteComponent(String id) throws ComponentManagerException {
		LOGGER.debug("deleteComponent " + id);
		Component c = components.remove(id);		
		if (c == null)
			throw new ComponentManagerException(String.format("No component registered with id %s", id));
		try {
			c.deactivate();
		} catch (ComponentException e) {
			throw new ComponentManagerException(e);
		}

		notifyChange();
	}


	
}
