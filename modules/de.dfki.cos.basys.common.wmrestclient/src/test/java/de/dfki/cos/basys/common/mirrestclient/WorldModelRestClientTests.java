package de.dfki.cos.basys.common.mirrestclient;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import de.dfki.cos.basys.common.wmrestclient.WorldModelRestClient;
import de.dfki.cos.basys.common.wmrestclient.WorldModelRestClientImpl;
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
