package fr.univnantes.cta.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fr.univnantes.cta.CompassDirection;
import fr.univnantes.cta.impl.LatitudeImpl;
import fr.univnantes.cta.impl.LongitudeImpl;
import fr.univnantes.cta.impl.PositionImpl;

public class PositionImplTest {
	public PositionImpl pos;
	public LatitudeImpl lat;
	public LongitudeImpl longi;
	
	@Before
	public void setUp() throws Exception {
		lat = new LatitudeImpl(60, 25, 52, CompassDirection.NORTH);
		
		longi = new LongitudeImpl(60, 25, 52, CompassDirection.EAST);
		pos = new PositionImpl(lat, longi);
	}

	@After
	public void tearDown() throws Exception {
		pos = null;
		assertNull(pos);
	}

	@Test
	public void testGetLat() {
		assertEquals(pos.getLatitude(), lat);
		
	}
	
	@Test
	public void testGetLong(){
		assertEquals(pos.getLongitude(), longi);
	}
	
	@Test(expected=UnsupportedOperationException.class)
	public void testDistanceTo() {
		pos.distanceTo(null);
	}

}
