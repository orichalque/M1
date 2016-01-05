package fr.nantes.cta.two;


import fr.nantes.cta.Airway;
import fr.nantes.cta.VOR;

/**
 * @author Administrateur
 *
 * To change this generated comment edit the template variable "typecomment":
 * Window>Preferences>Java>Templates.
 * To enable and disable the creation of type comments go to
 * Window>Preferences>Java>Code Generation.
 */
public class CouloirAerien implements Airway {
	private VOR vorDeb;

	private VOR vorFin;

	public CouloirAerien(VOR vorDeb, VOR vorFin) {
		this.vorDeb = vorDeb;
		this.vorFin = vorFin;
	}

	public double getDistance() {
		return vorDeb.distanceTo(vorFin);
	}
	public VOR getVor1(){
		return vorDeb;
		
	}
	public VOR getVor2(){
		return vorFin;
		
	}
}
