package fr.nantes.cta.two;

import fr.nantes.cta.Position;
import fr.nantes.cta.VOR;

public class Vors implements VOR {
	protected String nom;
	protected Position  pos;
	public Vors(String no, Position po){
		nom=no;
		pos=po;
	}
    /**
     * @return the name (or code) of the VOR.
     */
    public String getName(){
    	return nom;
    }
    
    /**
     * @return the position of the VOR.
     */
    public Position getPosition(){
    	return pos;
    }
    
    /**
     * @param other
     * @return the distance between two VORs, in kilometers.
     */
    public double distanceTo(VOR other){
    	return pos.distanceTo(other.getPosition());
    }
}
