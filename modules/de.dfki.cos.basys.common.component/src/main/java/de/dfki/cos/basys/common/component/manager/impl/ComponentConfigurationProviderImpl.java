package de.dfki.cos.basys.common.component.manager.impl;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.filefilter.SuffixFileFilter;
//import org.eclipse.emf.common.util.URI;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import de.dfki.cos.basys.common.component.Component;
import de.dfki.cos.basys.common.component.ComponentContext;
import de.dfki.cos.basys.common.component.ServiceProvider;
import de.dfki.cos.basys.common.component.StringConstants;
import de.dfki.cos.basys.common.component.manager.ComponentConfigurationProvider;
import de.dfki.cos.basys.common.component.manager.ComponentManager;
import de.dfki.cos.basys.common.component.manager.ComponentManagerException;
import de.dfki.cos.basys.common.component.manager.impl.ComponentManagerEvent.Type;

public class ComponentConfigurationProviderImpl implements ComponentConfigurationProvider, ServiceProvider<ComponentConfigurationProvider> {

	//private URI uri = null;
	private String connectionString = null;
	private boolean recursive, watchFolder = false;

	//private ComponentManager componentManager = null;
	// private ComponentContext context = null;

	private Map<String, ConfigurationFile> map = new HashMap<>();

	public ComponentConfigurationProviderImpl() {
		this(new Properties());
	}

	public ComponentConfigurationProviderImpl(Properties config) {
		if (config.containsKey("recursive")) {
			recursive = Boolean.parseBoolean(config.getProperty("recursive"));
		}
		if (config.containsKey("watchFolder")) {
			watchFolder = Boolean.parseBoolean(config.getProperty("watchFolder"));
		}
	}

//	public void setComponentManager(ComponentManager componentManager) {
//		this.componentManager = componentManager;
//	}

	public void setRecursive(boolean recursive) {
		this.recursive = recursive;
	}

	public boolean isRecursive() {
		return recursive;
	}

	@Override
	public boolean connect(ComponentContext context, String connectionString) {
		//uri = URI.createFileURI(connectionString);
		this.connectionString = connectionString;
		if (watchFolder) {
			try {
				WatchService watcher = FileSystems.getDefault().newWatchService();
				//Path path = Paths.get(uri.toFileString());
				Path path = Paths.get(connectionString);
				WatchKey key = path.register(watcher, StandardWatchEventKinds.ENTRY_CREATE,
						StandardWatchEventKinds.ENTRY_DELETE, StandardWatchEventKinds.ENTRY_MODIFY);
				Runnable run = new Runnable() {

					@Override
					public void run() {
						while (isConnected()) {
							try {
								WatchKey key = watcher.take();
								List<WatchEvent<?>> eventList = key.pollEvents();
								System.out.println("size = " + eventList.size());
								for (WatchEvent<?> e : eventList) {

									System.out.print(e.kind() + " -> ");
									Path name = (Path) e.context();
									Path filePath = path.resolve(name);
									System.out.print(filePath);
									if (Files.isDirectory(filePath)) {
										System.out.println(" <dir>");
									} else {
										System.out.println(" <file>");
										if (e.kind() == StandardWatchEventKinds.ENTRY_CREATE) {
											context.getEventBus().post(new ComponentManagerEvent(Type.CONFIG_FILE_CREATED, filePath.toString()));											
										}
										else if (e.kind() == StandardWatchEventKinds.ENTRY_DELETE) {
											context.getEventBus().post(new ComponentManagerEvent(Type.CONFIG_FILE_DELETED, filePath.toString()));
										} 
										else if (e.kind() == StandardWatchEventKinds.ENTRY_MODIFY) {
											context.getEventBus().post(new ComponentManagerEvent(Type.CONFIG_FILE_MODIFIED, filePath.toString()));
										} 
										else {
											//unknown
										}							

									}
								}
								boolean valid = key.reset();
								if (!valid) {
									break;
								}
							} catch (InterruptedException ex) {
								// TODO Auto-generated catch block
								ex.printStackTrace();
							}
						}
					}
				};
//				CompletableFuture<Void> cf = CompletableFuture.runAsync(run, context.getScheduledExecutorService()).exceptionally(e-> {		    
//					e.printStackTrace();
//					//LOGGER.error(e.getMessage(), e);
//				    return null;
//				});

				context.getScheduledExecutorService().execute(run);

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//File file = new File(uri.toFileString());
		File file = new File(connectionString);
		return file.exists();

	}

	@Override
	public void disconnect() {
		//this.uri = null;
		this.connectionString = null;
	}

	@Override
	public boolean isConnected() {
		//return uri != null;
		return connectionString != null;
	}

	@Override
	public ComponentConfigurationProvider getService() {
		return this;
	}

	
	@Override
	public List<String> getComponentConfigurationPaths() {

		String[] suffixes = { ".json", ".properties" };
		FileFilter filter = new SuffixFileFilter(suffixes);

		List<String> paths = new LinkedList<String>();

		int depth = 1;
		if (recursive)
			depth = Integer.MAX_VALUE;

		try {
			//Files.find(Paths.get(uri.toFileString()), depth, (filePath, fileAttr) -> filter.accept(filePath.toFile())).map(p -> p.toString()).forEach(paths::add);
			Files.find(Paths.get(connectionString), depth, (filePath, fileAttr) -> filter.accept(filePath.toFile())).map(p -> p.toString()).forEach(paths::add);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return paths;
	}

	public Properties getComponentConfigurationForPath(String path) {	
		ConfigurationFile configFile = new ConfigurationFile(path);
		Properties config = configFile.getConfig();
		map.put(path, configFile);
		return config;
	}


}
