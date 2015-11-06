package fr.nantes.cta.two;

import fr.nantes.cta.Airway;
import fr.nantes.cta.CompassDirection;
import fr.nantes.cta.TakenAirway;

 public class takenAirwy_imp implements TakenAirway {
	 public takenAirwy_imp(Airway airw ,int alti,CompassDirection dire){
		 couloir=airw;
		 alt=alti;
		 dir=dire;
	 }
	public Airway getAirway() {
		// TODO Auto-generated method stub
		return couloir;
	}

	public int getAltitude() {
		// TODO Auto-generated method stub
		return  alt;
	}

	public CompassDirection getSense() {
		// TODO Auto-generated method stub
		return dir;
	}

	public double distance() {
		// TODO Auto-generated method stub
		return couloir.getDistance();
	}
	private Airway couloir;
	private int alt;
	private CompassDirection dir;

}
