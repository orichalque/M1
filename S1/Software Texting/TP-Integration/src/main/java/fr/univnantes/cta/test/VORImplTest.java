package fr.univnantes.cta.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fr.univnantes.cta.CompassDirection;
import fr.univnantes.cta.impl.LatitudeImpl;
import fr.univnantes.cta.impl.LongitudeImpl;
import fr.univnantes.cta.impl.PositionImpl;
import fr.univnantes.cta.impl.VORImpl;

public class VORImplTest {
	VORImpl vor;
	
	@Before
	public void setUp() throws Exception {	
		vor = new VORImpl("name", new PositionImpl(new LatitudeImpl(60, 25, 52, CompassDirection.NORTH), new LongitudeImpl(60, 25, 52, CompassDirection.EAST)));
	}

	@After
	public void tearDown() throws Exception {
		vor = null;
		assertNull(vor);
	}
	
	@Test
	public void testGetName() {
		assertEquals(vor.getName(), "name");
	}
	
	@Test(expected=UnsupportedOperationException.class)
	public void testDIstanceTo() {
		vor.distanceTo(new VORImpl("name2",  new PositionImpl(new LatitudeImpl(60, 25, 52, CompassDirection.NORTH), new LongitudeImpl(60, 25, 52, CompassDirection.EAST))));
	}

}
