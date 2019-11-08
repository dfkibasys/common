package de.dfki.cos.basys.common.component;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Properties;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;

public class ComponentConfigurationTest {
	
	Properties config;
	
	@Before
	public void setUp() throws Exception {
		Properties config = new Properties();
		config.put(StringConstants.id, "component-manager");
		config.put(StringConstants.name, "component-manager");
		config.put(StringConstants.serviceConnectionString, "src/test/resources/components");
		config.put("recursive", "true");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testToJson() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(config);		
		System.out.println(json);
	}
	
	@Test
	public void testFromJson() {		
		String filename = "src/test/resources/components/component-1.json";
		Gson gson = new Gson();
		JsonReader reader;
		try {
			reader = new JsonReader(new FileReader(filename));		
			Properties config2 = gson.fromJson(reader, Properties.class);
			System.out.println(config2);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
