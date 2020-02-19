package de.dfki.cos.basys.common.component.manager.impl;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

import com.google.common.eventbus.Subscribe;

import de.dfki.cos.basys.common.component.Component;
import de.dfki.cos.basys.common.component.ComponentException;
import de.dfki.cos.basys.common.component.ServiceProvider;
import de.dfki.cos.basys.common.component.StringConstants;
import de.dfki.cos.basys.common.component.impl.ServiceComponent;
import de.dfki.cos.basys.common.component.impl.ServiceManagerImpl;
import de.dfki.cos.basys.common.component.manager.ComponentConfigurationProvider;
import de.dfki.cos.basys.common.component.manager.ComponentManager;
import de.dfki.cos.basys.common.component.manager.ComponentManagerException;
import de.dfki.cos.basys.common.component.manager.impl.ComponentManagerEvent.Type;


public class ComponentManagerImpl extends ServiceComponent<ComponentConfigurationProvider> implements ComponentManager {
	
	private Map<String, Component> components = new HashMap<>();
	
	private boolean async = false;
	
	public ComponentManagerImpl(Properties config) {
		super(config);
			
		if (serviceManager == null) {
			ComponentConfigurationProviderImpl serviceProvider = new ComponentConfigurationProviderImpl(config);
			serviceManager = new ServiceManagerImpl<ComponentConfigurationProvider>(config, serviceProvider);	
		}
		
		if (config.containsKey("async")) {
			async = Boolean.parseBoolean(config.getProperty("async"));
		}
	}

	public ComponentManagerImpl(Properties config, ServiceProvider serviceProvider) {
		super(config, serviceProvider);
		serviceManager = new ServiceManagerImpl<ComponentConfigurationProvider>(config, serviceProvider);	

		if (config.containsKey("async")) {
			async = Boolean.parseBoolean(config.getProperty("async"));
		}
	}
	
	@Override
	protected void doActivate() throws ComponentException {	
		if (this.isConnected()) {			
			ComponentConfigurationProvider service = getService();
			Runnable r = new Runnable() {				
				@Override
				public void run() {
					List<String> configs = service.getComponentConfigurationPaths();									
					for (String path : configs) {
						Component component = createComponentForPath(path);
						try {
							addComponent(component);
						} catch (ComponentManagerException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			};
			if (async) {				
				CompletableFuture<Void> cf = CompletableFuture.runAsync(r, context.getScheduledExecutorService()).exceptionally(e-> {		    
					e.printStackTrace();
					//LOGGER.error(e.getMessage(), e);
				    return null;
				});
			} else {
				r.run();
			}
		}
	}
	
	@Override
	protected void doDeactivate() throws ComponentException {
		//copy the ids into a new list in order to avoid a concurrent modification exception in line 184cd ..
		List<String> ids = new ArrayList<String>(components.keySet());
		for (String id : ids) {
			try {
				deleteComponent(id);
			} catch (ComponentManagerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
		} catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException e) {
			throw new ComponentManagerException(e);
		}
		
		
		return component;
	}

	@Override
	public void addComponent(Properties config) throws ComponentManagerException {
		Component component = createComponent(config);
		if (component != null) {
			addComponent(component);
		}			
	}
	
	@Override
	public void addComponent(Component component) throws ComponentManagerException {
		LOGGER.debug("addComponent " + component.getName());
		components.put(component.getId(), component);
		try {
			component.activate(context);
			context.getEventBus().post(new ComponentManagerEvent(Type.COMPONENT_ADDED, component.getId(), component));
		} catch (ComponentException e) {
			throw new ComponentManagerException(e);
		}
	}

	@Override
	public void deleteComponent(String id) throws ComponentManagerException {
		LOGGER.debug("deleteComponent " + id);
		Component c = components.remove(id);		
		if (c == null)
			throw new ComponentManagerException(String.format("No component registered with id %s", id));
		try {
			c.deactivate();
			context.getEventBus().post(new ComponentManagerEvent(Type.COMPONENT_DELETED, c.getId()));
		} catch (ComponentException e) {
			throw new ComponentManagerException(e);
		}
	}

	private Component createComponentForPath(String path) {
		ComponentConfigurationProvider service = getService();
		Properties config = service.getComponentConfigurationForPath(path);
		try {
			return createComponent(config);
		} catch (ComponentManagerException e) {
			e.printStackTrace();
		}	
		return null;
	}
	
	private Component getComponentForPath(String path) {
		ComponentConfigurationProvider service = getService();
		
		for (Component c : components.values()) {
			String cPath = c.getInfo().getProperty("path");
			if (path.equals(cPath)) {
				return c;
			}
		}
		
		return null;
		
		
	}
	
	@Subscribe
	public void onComponentManagerEvent(ComponentManagerEvent ev) {
		LOGGER.info("onComponentManagerEvent " + ev);
		if (ev.getType() == Type.CONFIG_FILE_CREATED) {
			Component component = createComponentForPath(ev.getValue());
			try {
				addComponent(component);
			} catch (ComponentManagerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if (ev.getType() == Type.CONFIG_FILE_DELETED) {
			Component component = getComponentForPath(ev.getValue());
			if (component != null) {
				try {
					deleteComponent(component.getId());
				} catch (ComponentManagerException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		else if (ev.getType() == Type.CONFIG_FILE_MODIFIED) {
			Component component = getComponentForPath(ev.getValue());
			//ComponentConfigurationProvider service = getService();
			//Properties config = service.getComponentConfigurationForPath(ev.getValue());
			//component.update(config)
		}
	}
	
}
