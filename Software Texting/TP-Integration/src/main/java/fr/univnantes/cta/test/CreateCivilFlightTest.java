package fr.univnantes.cta.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fr.univnantes.cta.Airplane;
import fr.univnantes.cta.Airport;
import fr.univnantes.cta.FlightPlan;
import fr.univnantes.cta.impl.AirplaneImpl;
import fr.univnantes.cta.impl.AirportImpl;
import fr.univnantes.cta.impl.CreateCivilFlight;
import fr.univnantes.cta.impl.FlightPlanImpl;

public class CreateCivilFlightTest {
	CreateCivilFlight ccf;
	Airport d;
	Airport a;
	Airplane p;
	FlightPlan fp;
	
	@Before
	public void setUp() throws Exception {
		d = new AirportImpl("depart");
		a = new AirportImpl("arrive");
		p = new AirplaneImpl(550., 2000, 500, 450);
		fp = new FlightPlanImpl();
		ccf = new CreateCivilFlight(d, a, p, fp, 40);
		//TODO
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
