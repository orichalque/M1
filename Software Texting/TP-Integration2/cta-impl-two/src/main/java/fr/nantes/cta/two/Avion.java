package fr.nantes.cta.two;

/**
 * @author Administrateur
 *
 * To change this generated comment edit the template variable "typecomment":
 * Window>Preferences>Java>Templates.
 * To enable and disable the creation of type comments go to
 * Window>Preferences>Java>Code Generation.
 */

import fr.nantes.cta.Airplane;

public class Avion implements Airplane
{
	private double poidsVide;
	private int capChargement;
	private int consommation;
	private int reservoir;
	
 
 	public Avion(double poidsVide, int capChargement, int consommation, int reservoir) {
		this.poidsVide = poidsVide;
		this.capChargement = capChargement;
		this.consommation = consommation;
		this.reservoir = reservoir;
	}

	/**
     * @return The weight of the airplane (empty). 
     */
    public double weight()
    {
    	return poidsVide;
    }

    /**
     * @return The estimated autonomy, in km.
     */
    public int getAutonomy()
    {
    	 return (consommation*reservoir);
    }
    
    /**
     * @return the loading capacity of the airplane, in kg.
     */
    public int getLoading()
    {
    	return capChargement;
    }
}
