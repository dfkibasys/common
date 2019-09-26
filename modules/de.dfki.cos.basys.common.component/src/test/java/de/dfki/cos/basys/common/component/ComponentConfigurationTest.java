package de.dfki.cos.basys.common.component;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.FileReader;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;

public class ComponentConfigurationTest {
	
	ComponentConfiguration config;
	
	@Before
	public void setUp() throws Exception {
		config = new ComponentConfiguration.Builder()
				.id("id")
				.name("name")
				.externalConnectionString("externalConnectionString")
				.implementationJavaClass("implementationJavaClass")
				.addProperty("key1", "value1")
				.addProperty("key2", "value2")
				.addProperty("key3", "value3")
				.build();
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
		String filename = "src/test/resources/config.json";
		Gson gson = new Gson();
		JsonReader reader;
		try {
			reader = new JsonReader(new FileReader(filename));		
			ComponentConfiguration config2 = gson.fromJson(reader, ComponentConfiguration.class);
			System.out.println(config2);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
