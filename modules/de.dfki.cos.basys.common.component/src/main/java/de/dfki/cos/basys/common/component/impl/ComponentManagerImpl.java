package de.dfki.cos.basys.common.component.impl;

import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import org.apache.commons.io.filefilter.SuffixFileFilter;
import org.eclipse.emf.common.util.URI;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import de.dfki.cos.basys.common.component.Component;
import de.dfki.cos.basys.common.component.ComponentConfiguration;
import de.dfki.cos.basys.common.component.ComponentException;
import de.dfki.cos.basys.common.component.ComponentManager;
import de.dfki.cos.basys.common.component.ComponentManagerException;


public class ComponentManagerImpl extends BaseComponent implements ComponentManager {
	
	private Map<String, Component> components = new HashMap<>();
	private Gson gson = new Gson();
	
	private boolean recursive, async = false;
	
	public ComponentManagerImpl(ComponentConfiguration config) {
		super(config);

		if (config.getProperties().get("recursive") != null) {
			recursive = Boolean.parseBoolean(config.getProperties().get("recursive"));
			LOGGER.info("recursive = " + recursive);
		}
		
		if (config.getProperties().get("async") != null) {
			async = Boolean.parseBoolean(config.getProperties().get("async"));
			LOGGER.info("async = " + async);
		}
	}

	@Override
	protected void doActivate() throws ComponentException {	
		Runnable r = new Runnable() {				
			@Override
			public void run() {
				URI uri = URI.createFileURI(config.getExternalConnectionString());
				if (uri.isFile()) {
					String fileString = uri.toFileString();

					File file = new File(fileString);
					try {
						if (file.isDirectory()) {
							createComponents(file, recursive);
						} else {
							createComponent(file);
						}
					} 
					catch (ComponentManagerException e) {
						// TODO Auto-generated catch block
						//e.printStackTrace();
						throw new RuntimeException(e);
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
	public Component createComponent(ComponentConfiguration config) throws ComponentManagerException {
		//FIXME: actually, we must check globally via the registry
		if (components.containsKey(config.getId())) {
			Component old = components.get(config.getId());
			LOGGER.error("Duplicate component with Id: " + config.getId());
			LOGGER.error("Name of 1st component: " + old.getName());
			LOGGER.error("Name of 2nd component: " + config.getName());
			throw new ComponentManagerException("Duplicate component with Id " + config.getId());
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
			
			c = Class.forName(config.getImplementationJavaClass());
		} catch (ClassNotFoundException e) {
			throw new ComponentManagerException(e);
		}

		Component component = null;

		try {
			Constructor<Component> constructor = c.getConstructor(ComponentConfiguration.class);
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

		LOGGER.debug("addLocalComponent " + component.getName());
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

	@Override
	public Component createComponent(File configFile) throws ComponentManagerException {
		Component component = null;
		try {			
			JsonReader reader = new JsonReader(new FileReader(configFile));		
			ComponentConfiguration config = gson.fromJson(reader, ComponentConfiguration.class);
			component = createComponent(config);
		} catch (IOException e) {
			throw new ComponentManagerException(e);
		}
		return component;
	}

	@Override
	public void createComponents(File configFolder, boolean recursive) throws ComponentManagerException {

		FileFilter filter = new SuffixFileFilter(".json");

		for (File entry : configFolder.listFiles(filter)) {
			createComponent(entry);
		}
		if (recursive) {
			File[] files = configFolder.listFiles(File::isDirectory);
			for (File entry : configFolder.listFiles(File::isDirectory)) {
				createComponents(entry ,recursive);
			}		
		}
	}
	
}
