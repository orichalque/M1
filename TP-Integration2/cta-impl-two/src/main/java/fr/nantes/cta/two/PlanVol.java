package fr.nantes.cta.two;

import fr.nantes.cta.FlightPlan;
import fr.nantes.cta.TakenAirway;
import java.util.ArrayList;
import java.util.List;
/**
 * @author Administrateur
 *
 * To change this generated comment edit the template variable "typecomment":
 * Window>Preferences>Java>Templates.
 * To enable and disable the creation of type comments go to
 * Window>Preferences>Java>Code Generation.
 */
public class PlanVol implements FlightPlan
{
	private final  int MAx=50;
	public int  i=0;
	protected List<TakenAirway> takenAirw;
	
	public PlanVol()
	{	
		takenAirw = new ArrayList<TakenAirway>(MAx);
	}

  /**
     * @return an unmodificable list, containing all airways
     * used in the flight plan.
     * 
     * @see java.util.Collections#unmodifiableList(List)
     */
    public List<TakenAirway> getPath()
    {
    	return takenAirw;
    }
    
    /**
     * Adds an airway to the flight plan
     * @param a the airway
     */
    public void addAirway(TakenAirway a)
    {
    	//System.out.println(takenAirwa.size());
    	if(i<MAx)    		
    	takenAirw.set(i++,a);
    }
    
    /**
     * @return the total distance of the flight plan, the sum
     * of all airways, in km.
     */
    public double distance()
    {
    	double dist=0;
    	double b=0;
    	int i=0;
    	for (;i<MAx;i++) {
    		b=takenAirw.get(i).getAirway().getDistance();
    		dist = dist + b ;
    	}
    	return dist;
    }
    
}
