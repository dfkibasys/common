package de.dfki.cos.basys.common.component.manager.impl;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.filefilter.SuffixFileFilter;
import org.eclipse.emf.common.util.URI;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import de.dfki.cos.basys.common.component.Component;
import de.dfki.cos.basys.common.component.ComponentContext;
import de.dfki.cos.basys.common.component.ServiceConnection;
import de.dfki.cos.basys.common.component.StringConstants;
import de.dfki.cos.basys.common.component.manager.ComponentConfigurationProvider;
import de.dfki.cos.basys.common.component.manager.ComponentManagerException;

public class ComponentConfigurationProviderImpl implements ComponentConfigurationProvider, ServiceConnection {

	private URI uri = null;
	private boolean recursive = false;
	private Gson gson = new Gson();

	public ComponentConfigurationProviderImpl() {
		this(new Properties());
	}

	public ComponentConfigurationProviderImpl(Properties config) {
		if (config.containsKey("recursive")) {
			recursive = Boolean.parseBoolean(config.getProperty("recursive"));
		}
	}

	
	public void setRecursive(boolean recursive) {
		this.recursive = recursive;
	}
	
	public boolean isRecursive() {
		return recursive;
	}
	
	@Override
	public boolean connect(ComponentContext context, String connectionString) {
		uri = URI.createFileURI(connectionString);

		File file = new File(uri.toFileString());
		return file.exists();
//		uri = URI.createFileURI(connectionString);
//		if (uri.isFile()) {
//			return true;
//		} else {
//			uri = null;
//			return false;
//		}
	}

	@Override
	public void disconnect() {
		this.uri = null;
	}

	@Override
	public boolean isConnected() {
		return uri != null;
	}

	@Override
	public List<Properties> getComponentConfigurations() {
		List<Properties> configs = new LinkedList<Properties>();

		String[] suffixes = { ".json", ".properties" };
		FileFilter filter = new SuffixFileFilter(suffixes);

		List<Path> paths = new LinkedList<Path>();

		int depth = 1;
		if (recursive)
			depth = Integer.MAX_VALUE;

		try {
			Files.find(Paths.get(uri.toFileString()), 
					depth, 
					(filePath, fileAttr) -> filter.accept(filePath.toFile()))
					.forEach(paths::add);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (Path path : paths) {
			Properties p = readFile(path.toFile());
			configs.add(p);
		}

		return configs;
	}

	public Properties readFile(File configFile) {
		try {
			String ext = FilenameUtils.getExtension(configFile.getName());
			if ("json".equals(ext)) {
				JsonReader reader = new JsonReader(new FileReader(configFile));
				Properties config = gson.fromJson(reader, Properties.class);
				return config;
			} else if ("properties".equals(ext)) {
				Properties config = new Properties();
				InputStream input = new FileInputStream(configFile.getAbsoluteFile());
				config.load(input);
				return config;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Component createComponent(File configFile) throws ComponentManagerException {
		Component component = null;
		try {
			String ext = FilenameUtils.getExtension(configFile.getName());
			if ("json".equals(ext)) {
				JsonReader reader = new JsonReader(new FileReader(configFile));
				// Properties config = gson.fromJson(reader, Properties.class);
				// component = createComponent(config);
			} else if ("properties".equals(ext)) {
				Properties config = new Properties();
				InputStream input = new FileInputStream(configFile.getAbsoluteFile());
				config.load(input);
				// component = createComponent(config);
			}
		} catch (IOException e) {
			throw new ComponentManagerException(e);
		}
		return component;
	}

	public void createComponents(File configFolder, boolean recursive) throws ComponentManagerException {

		String[] suffixes = { ".json", "*.properties" };
		FileFilter filter = new SuffixFileFilter(suffixes);

		for (File entry : configFolder.listFiles(filter)) {
			createComponent(entry);
		}
		if (recursive) {
			File[] files = configFolder.listFiles(File::isDirectory);
			for (File entry : configFolder.listFiles(File::isDirectory)) {
				createComponents(entry, recursive);
			}
		}
	}

}
