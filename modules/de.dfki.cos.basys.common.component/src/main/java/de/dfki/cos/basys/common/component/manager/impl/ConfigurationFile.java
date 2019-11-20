package de.dfki.cos.basys.common.component.manager.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.io.FilenameUtils;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import de.dfki.cos.basys.common.component.StringConstants;


public class ConfigurationFile {
	private final String path;
	private Properties config = null;
	
	public ConfigurationFile(String path) {		
		this.path = path;		
	}
	
	public Properties getConfig() {
		if (config != null) {
			return config;
		}
		
		
			String ext = FilenameUtils.getExtension(path);
			if ("json".equals(ext)) {
				try (JsonReader reader = new JsonReader(new FileReader(path))) {			
					Gson gson = new Gson();
					config = gson.fromJson(reader, Properties.class);	
					config.setProperty(StringConstants.path, path);
					return config;
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if ("properties".equals(ext)) {
				try (InputStream input = new FileInputStream(path)) {
					config = new Properties();
					config.load(input);
					config.setProperty(StringConstants.path, path);
					return config;
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
		return null;
	}
}
