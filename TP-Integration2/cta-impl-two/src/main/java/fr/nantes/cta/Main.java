package fr.nantes.cta;


/**
 * @author Administrateur
 *
 * To change this generated comment edit the template variable "typecomment":
 * Window>Preferences>Java>Templates.
 * To enable and disable the creation of type comments go to
 * Window>Preferences>Java>Code Generation.
 */
public class Main {
	
	public static void main(String[] args) 
	{
		CTAFactoryImpl fab = new CTAFactoryImpl();
		
		Airport PCG = fab.createAirport("Paris ");
		Airport DAKAR= fab.createAirport("DAKAR");
		
		Airplane plane = fab.createAirplane(50000, 39000, 1, 10000);
		
		FlightPlan fp = fab.createFlightPlan();
		VOR PCG_VOR = fab.createVOR("PCG", fab.createPosition(fab.createLatitude(48, 49, 12, CompassDirection.NORTH),
				fab.createLongitude(2, 29, 32, CompassDirection.EAST)));
		VOR DAK_VOR = fab.createVOR("DAKAR", fab.createPosition(fab.createLatitude(5, 15, 0, CompassDirection.NORTH),
				fab.createLongitude(3, 56, 0, CompassDirection.WEST)));
		fp.addAirway(fab.createTakenAirway(fab.createAirway(PCG_VOR, DAK_VOR), 12000, CompassDirection.SOUTH));
		
		Flight flight = null;
		try {
			flight =fab.createCivilFlight(PCG, DAKAR, plane, fp, 285);
		} catch (IncompatibleAirway e) {
			e.printStackTrace();
		} catch (AirplaneOverload e) {
			e.printStackTrace();
		}
		
		
		
		Airport Oula = fab.createAirport("oula");
		
		Airplane plane2 = fab.createAirplane(50000, 39000, 1, 10000);
		
		FlightPlan fp2 = fab.createFlightPlan();
		VOR OUA_VOR = fab.createVOR("Ouaga", fab.createPosition(fab.createLatitude(12, 21, 0, CompassDirection.NORTH),
				fab.createLongitude(1, 31, 0, CompassDirection.WEST)));
		fp2.addAirway(fab.createTakenAirway(fab.createAirway(PCG_VOR, OUA_VOR), 12000, CompassDirection.SOUTH));
		
		Flight flight2 = null;
		try {
			flight2 = fab.createCivilFlight(PCG, Oula, plane2, fp2, 285);
		} catch (IncompatibleAirway e) {
			e.printStackTrace();
		} catch (AirplaneOverload e) {
			e.printStackTrace();
		}
		
		Airplane plane3 = fab.createAirplane(50000, 39000, 1, 10000);
		
		FlightPlan fp3 = fab.createFlightPlan();
		fp3.addAirway(fab.createTakenAirway(fab.createAirway(PCG_VOR, OUA_VOR), 12000, CompassDirection.SOUTH));
		fp3.addAirway(fab.createTakenAirway(fab.createAirway(OUA_VOR, DAK_VOR), 11000, CompassDirection.SOUTH));
		Flight flight3 = null;
		try {
			flight3 = fab.createCivilFlight(PCG, DAKAR, plane3, fp3, 285);
		} catch (IncompatibleAirway e) {
			e.printStackTrace();
		} catch (AirplaneOverload e) {
			e.printStackTrace();
		}
		
	}	
}
	
	
	
	
	