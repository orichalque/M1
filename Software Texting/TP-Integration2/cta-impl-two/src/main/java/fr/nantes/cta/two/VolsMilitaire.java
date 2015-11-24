package fr.nantes.cta.two;


import fr.nantes.cta.FlightPlan;
import fr.nantes.cta.Airport;
import fr.nantes.cta.Airplane;
import fr.nantes.cta.Flight;
/*
 * @author Administrateur
 *
 * To change this generated comment edit the template variable "typecomment":
 * Window>Preferences>Java>Templates.
 * To enable and disable the creation of type comments go to
 * Window>Preferences>Java>Code Generation.
 */



public class VolsMilitaire implements Flight {
	private Airplane avion;

	private Airport aeroportDep;

	private Airport aeroportArr;

	private FlightPlan planVol;

	private int nbPassager;
	
		public  VolsMilitaire(Airplane avion, Airport aeroportDep, Airport aeroportArr, FlightPlan planVol, int nbPassager) {
		this.avion = avion;
		this.aeroportDep = aeroportDep;
		this.aeroportArr = aeroportArr;
		this.planVol = planVol;
		this.nbPassager = nbPassager;
		
	}

	/**
	 * Returns the avion.
	 * 
	 * @return Airplane
	 */
	public Airplane getAirplane() {
		return avion;
	}

	/**
	 * Returns the planVol.
	 * 
	 * @return FlightPlan
	 */
	public FlightPlan getFlightPlan() {
		return planVol;
	}

	/**
	 * Returns the aeroportDep.
	 * 
	 * @return Airport
	 */
	public Airport getDeparture() {
		return aeroportDep;
	}

	/**
	 * Returns the aeroportArr.
	 * 
	 * @return Airport
	 */
	public Airport getArrival() {
		return aeroportArr;
	}

	/**
	 * Returns the nbPassager.
	 * 
	 * @return int
	 */
	public int getNbPassager() {
		return nbPassager;
	}
	
    /**
     * @return the weight of the loading, that depends on the kind of flight.
     */
	public double loadingWeight() {
		return nbPassager * 170;
	}

    /**
     * @return the total weight of this flight: the weight of the empty airplane, plus
     * the weight of the passengers.
     */
	public double totalWeight() {
		return avion.weight() + loadingWeight();
	}
}

