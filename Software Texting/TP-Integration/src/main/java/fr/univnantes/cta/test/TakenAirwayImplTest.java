package fr.univnantes.cta.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fr.univnantes.cta.CompassDirection;
import fr.univnantes.cta.impl.AirwayImpl;
import fr.univnantes.cta.impl.LatitudeImpl;
import fr.univnantes.cta.impl.LongitudeImpl;
import fr.univnantes.cta.impl.PositionImpl;
import fr.univnantes.cta.impl.TakenAirwayImpl;
import fr.univnantes.cta.impl.VORImpl;

public class TakenAirwayImplTest {
	TakenAirwayImpl taimpl;
	VORImpl start = new VORImpl("name1", new PositionImpl(new LatitudeImpl(60, 25, 52, CompassDirection.SOUTH), new LongitudeImpl(60, 25, 52, CompassDirection.WEST))); ;
	VORImpl end = new VORImpl("name2", new PositionImpl(new LatitudeImpl(60, 25, 52, CompassDirection.NORTH), new LongitudeImpl(60, 25, 52, CompassDirection.EAST)));
	AirwayImpl awi =  new AirwayImpl(end, start);
	
	@Before
	public void setUp() throws Exception {
		taimpl = new TakenAirwayImpl(awi, 5000, CompassDirection.NORTH);
	}

	@After
	public void tearDown() throws Exception {
		taimpl = null;
		assertNull(taimpl);
	}

	
	@Test(expected=UnsupportedOperationException.class)
	public void testDist() {
		taimpl.distance();
	}
	
	@Test
	public void testGetAlt() {
		assertEquals(taimpl.getAltitude(), 5000);
	}
	
	@Test
	public void testAW() {
		assertEquals(taimpl.getAirway(), awi);
	}
	
	@Test
	public void testCD() {
		assertEquals(taimpl.getSense(), CompassDirection.NORTH);
	}

}
