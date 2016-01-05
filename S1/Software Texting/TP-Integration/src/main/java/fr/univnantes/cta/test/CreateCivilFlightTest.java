package fr.univnantes.cta.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fr.univnantes.cta.Airplane;
import fr.univnantes.cta.AirplaneOverload;
import fr.univnantes.cta.Airport;
import fr.univnantes.cta.CompassDirection;
import fr.univnantes.cta.FlightPlan;
import fr.univnantes.cta.IncompatibleAirway;
import fr.univnantes.cta.impl.AirplaneImpl;
import fr.univnantes.cta.impl.AirportImpl;
import fr.univnantes.cta.impl.AirwayImpl;
import fr.univnantes.cta.impl.CreateCivilFlight;
import fr.univnantes.cta.impl.FlightPlanImpl;
import fr.univnantes.cta.impl.LatitudeImpl;
import fr.univnantes.cta.impl.LongitudeImpl;
import fr.univnantes.cta.impl.PositionImpl;
import fr.univnantes.cta.impl.TakenAirwayImpl;
import fr.univnantes.cta.impl.VORImpl;

public class CreateCivilFlightTest {
	CreateCivilFlight ccf;
	Airport d;
	Airport a;
	Airplane p;
	Airplane p2;
	FlightPlan fp;
	TakenAirwayImpl ta1;
	AirwayImpl awi;
	
	@Before
	public void setUp() throws Exception {
		d = new AirportImpl("depart");
		a = new AirportImpl("arrive");
		p = new AirplaneImpl(550., 200, 500, 450);
		p2 = new AirplaneImpl(550., 200000, 500, 450);
		fp = new FlightPlanImpl();
		TakenAirwayImpl taimpl;
		VORImpl start = new VORImpl("name1", new PositionImpl(new LatitudeImpl(60, 25, 52, CompassDirection.SOUTH), new LongitudeImpl(60, 25, 52, CompassDirection.WEST))); ;
		VORImpl end = new VORImpl("name2", new PositionImpl(new LatitudeImpl(60, 25, 52, CompassDirection.NORTH), new LongitudeImpl(60, 25, 52, CompassDirection.EAST)));
		awi =  new AirwayImpl(end, start);
	}

	@After
	public void tearDown() throws Exception {
		ccf = null;
		assertNull(ccf);
	}

	@Test(expected=AirplaneOverload.class)
	public void testConstru1() throws IncompatibleAirway, AirplaneOverload {
		ccf = new CreateCivilFlight(d, a, p, fp, 40); //overload
	}
	
	@Test(expected=UnsupportedOperationException.class)
	public void testConstru2() throws IncompatibleAirway, AirplaneOverload, UnsupportedOperationException {
		ta1 = new TakenAirwayImpl(awi, 0, CompassDirection.NORTH);
		fp.addAirway(ta1);
		ccf = new CreateCivilFlight(d, a, p2, fp, 40); 
	}
	
	@Test
	public void testNormalConstructor() throws IncompatibleAirway, AirplaneOverload{
		ccf = new CreateCivilFlight(d, a, p2, fp, 40);
	}
	
	@Test
	public void testLoadingWeight() throws IncompatibleAirway, AirplaneOverload{
		ccf = new CreateCivilFlight(d, a, p2, fp, 40);
		assertEquals("LoadingOverload?", (40*(70+60)),ccf.loadingWeight(), 0);
	}
	
	@Test
	public void testTotalWeight() throws IncompatibleAirway, AirplaneOverload{
		ccf = new CreateCivilFlight(d, a, p2, fp, 40);
		assertEquals("AirPlane Weight?", (550.+ 40*(70+60)),ccf.totalWeight(), 0);
	}
}
