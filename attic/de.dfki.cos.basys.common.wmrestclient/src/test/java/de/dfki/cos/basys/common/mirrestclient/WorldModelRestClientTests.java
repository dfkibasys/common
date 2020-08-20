package de.dfki.cos.basys.common.mirrestclient;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import de.dfki.cos.basys.common.wmrestclient.WorldModelCreator;
import de.dfki.cos.basys.common.wmrestclient.WorldModelRestClient;
import de.dfki.cos.basys.common.wmrestclient.WorldModelRestClientImpl;
import de.dfki.cos.basys.common.wmrestclient.dto.Hull;
import junit.framework.Assert;


public class WorldModelRestClientTests {

	WorldModelRestClient client;
	String host = "http://---";
	
	@Before
	public void setUp() throws Exception {		
		client = new WorldModelRestClientImpl(host);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	//@Ignore
	public void testCreateHull() {
		Hull hull = WorldModelCreator.createHullHMI();
		assertTrue(hull.getFrames().size() == 57);
	}
	
	@Test
	//@Ignore
	public void testCreateHullHorizontalAndSerialize() {
		Hull hull = WorldModelCreator.createHullHorizontalHMI();
		assertTrue(hull.getFrames().size() == 45);
		ObjectMapper mapper = new ObjectMapper();
		try {
			String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(hull);
			System.out.println(json);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	//@Ignore
	public void testGetHull() {
		assertTrue(true);
	}
	
	@Test
	//@Ignore
	public void testGetFrame() {
		assertTrue(true);
	}
	
	// further test methods
}
