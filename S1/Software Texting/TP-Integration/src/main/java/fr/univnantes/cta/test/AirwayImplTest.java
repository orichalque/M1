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
import fr.univnantes.cta.impl.VORImpl;

public class AirwayImplTest {
	public AirwayImpl awi;
	VORImpl start = new VORImpl("name1", new PositionImpl(new LatitudeImpl(60, 25, 52, CompassDirection.SOUTH), new LongitudeImpl(60, 25, 52, CompassDirection.WEST))); ;
	VORImpl end = new VORImpl("name2", new PositionImpl(new LatitudeImpl(60, 25, 52, CompassDirection.NORTH), new LongitudeImpl(60, 25, 52, CompassDirection.EAST)));
	
	@Before
	public void setUp() throws Exception {
		awi = new AirwayImpl(end, start);
	}

	@After
	public void tearDown() throws Exception {
		awi = null;
		assertNull(awi);
	}

	@Test
	public void testDepart() {
		assertEquals(awi.departure(), start);
	}
	
	@Test
	public void testVORDepart() {
		assertEquals(awi.GetVORDepart(), "name1");
	}
	
	@Test
	public void testVOREnd() {
		assertEquals(awi.GetVORArrive(), "name2");
	}

}
