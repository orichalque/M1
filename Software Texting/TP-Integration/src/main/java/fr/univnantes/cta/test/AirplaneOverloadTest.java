package fr.univnantes.cta.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import fr.univnantes.cta.AirplaneOverload;

public class AirplaneOverloadTest {

	public AirplaneOverloadTest() {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test (expected = Exception.class)
	public void test() throws AirplaneOverload {
		throw new AirplaneOverload();
	}

}