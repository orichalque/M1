package fr.univnantes.cta.test;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fr.univnantes.cta.CompassDirection;
import fr.univnantes.cta.TakenAirway;
import fr.univnantes.cta.impl.AirwayImpl;
import fr.univnantes.cta.impl.FlightPlanImpl;
import fr.univnantes.cta.impl.LatitudeImpl;
import fr.univnantes.cta.impl.LongitudeImpl;
import fr.univnantes.cta.impl.PositionImpl;
import fr.univnantes.cta.impl.TakenAirwayImpl;
import fr.univnantes.cta.impl.VORImpl;

public class FlightPlanImplTest {
	FlightPlanImpl fpi;
	TakenAirwayImpl tai;
	VORImpl start = new VORImpl("name1", new PositionImpl(new LatitudeImpl(60, 25, 52, CompassDirection.SOUTH), new LongitudeImpl(60, 25, 52, CompassDirection.WEST))); ;
	VORImpl end = new VORImpl("name2", new PositionImpl(new LatitudeImpl(60, 25, 52, CompassDirection.NORTH), new LongitudeImpl(60, 25, 52, CompassDirection.EAST)));
	AirwayImpl awi =  new AirwayImpl(end, start);
	
	@Before
	public void setUp() throws Exception {
		fpi = new FlightPlanImpl();
		tai = new TakenAirwayImpl(awi, 5000, CompassDirection.NORTH);
	}

	@After
	public void tearDown() throws Exception {
		fpi = null;
		assertNull(fpi);
	}

	@Test
	public void TestDistance1() {
		assertEquals(fpi.distance(), 0., 0);
	}

	@Test(expected=UnsupportedOperationException.class)
	public void TestDistance2() {
		fpi.addAirway(tai);
		fpi.distance();
	}
	
	@Test
	public void testGetPath1() {
		fpi.addAirway(tai);
		List<TakenAirway> taiList = new LinkedList<TakenAirway>();
		taiList.add(tai);
		assertEquals(taiList, fpi.getPath());
	}
	
	@Test                                                                  
	public void testAddAirway() {
		fpi.addAirway(tai);
		assertTrue(fpi.getPath().contains(tai));
	}

}
