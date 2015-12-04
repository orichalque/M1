package fr.univnantes.cta.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fr.univnantes.cta.AirplaneOverload;
import fr.univnantes.cta.CompassDirection;
import fr.univnantes.cta.IncompatibleAirway;
import fr.univnantes.cta.Position;
import fr.univnantes.cta.impl.AirplaneImpl;
import fr.univnantes.cta.impl.AirportImpl;
import fr.univnantes.cta.impl.AirwayImpl;
import fr.univnantes.cta.impl.CTAFactoryImpl;
import fr.univnantes.cta.impl.CreateMilitarFlight;
import fr.univnantes.cta.impl.FlightPlanImpl;
import fr.univnantes.cta.impl.LatitudeImpl;
import fr.univnantes.cta.impl.LongitudeImpl;
import fr.univnantes.cta.impl.PositionImpl;
import fr.univnantes.cta.impl.TakenAirwayImpl;
import fr.univnantes.cta.impl.VORImpl;

public class CTAFactoryImplTest {
	CTAFactoryImpl cta;
	LongitudeImpl longi;
	LatitudeImpl lati;
	Position posi;
	VORImpl start;
	VORImpl end;
	AirwayImpl awi;
	TakenAirwayImpl ta;
	
	@Before
	public void setUp() throws Exception {
		cta = new CTAFactoryImpl();
		lati = new LatitudeImpl(50, 50, 25, CompassDirection.NORTH);
		longi = new LongitudeImpl(50, 25, 52, CompassDirection.EAST);
		posi = new PositionImpl(lati,  longi);
		start = new VORImpl("name1", new PositionImpl(new LatitudeImpl(60, 25, 52, CompassDirection.SOUTH), new LongitudeImpl(60, 25, 52, CompassDirection.WEST))); ;
		end = new VORImpl("name2", new PositionImpl(new LatitudeImpl(60, 25, 52, CompassDirection.NORTH), new LongitudeImpl(60, 25, 52, CompassDirection.EAST)));
		awi =  new AirwayImpl(end, start);
		ta = new TakenAirwayImpl(awi, 0, CompassDirection.NORTH); 
	}

	@After
	public void tearDown() throws Exception {
		cta = null;
		assertNull(cta);
	}

	@Test
	public void testCreateL() {
		assertEquals(cta.createLatitude(50, 50, 25, CompassDirection.NORTH).getClass(), LatitudeImpl.class);
	}
	
	@Test
	public void testCreateL2() {
		assertEquals(cta.createLongitude(50, 50, 25, CompassDirection.EAST).getClass(), LongitudeImpl.class);
	}
	
	@Test
	public void testCreateFlightPlan(){
		assertEquals(cta.createFlightPlan().getClass(), FlightPlanImpl.class);
	}
	
	@Test 
	public void testcreatePosition() {
		assertEquals(cta.createPosition(lati, longi), PositionImpl.class);
	}
	
	@Test 
	public void testcreateAirport() {
		assertEquals(cta.createAirport("ap").getClass(), AirportImpl.class);
	}
	
	@Test 
	public void testcreateAirplane() {
		assertEquals(cta.createAirplane(5000., 2, 2, 50).getClass(), AirplaneImpl.class);
	}
	
	@Test
	public void testcreateVOR() {
		assertEquals(cta.createVOR("name", posi).getClass(), VORImpl.class);
	}
	
	@Test
	public void testCreateAirWay() {
		assertEquals(cta.createAirway(start, end).getClass(), AirwayImpl.class);
	}
	
	@Test
	public void testcreateTakenAirway() {
		assertEquals(cta.createTakenAirway(awi, 0, CompassDirection.EAST), TakenAirwayImpl.class);
	}
	
	@Test
	public void testcreateMF() throws IncompatibleAirway, AirplaneOverload {
		assertEquals(cta.createMilitarFlight(new AirportImpl("osef"), new AirportImpl("osef2"), new AirplaneImpl(5000., 2, 2, 50), new FlightPlanImpl(), 50).getClass(), CreateMilitarFlight.class);
	}
}
