package  fr.nantes.cta.two;

/**
 * @author Administrateur
 *
 * To change this generated comment edit the template variable "typecomment":
 * Window>Preferences>Java>Templates.
 * To enable and disable the creation of type comments go to
 * Window>Preferences>Java>Code Generation.
 */

import fr.nantes.cta.Airport;

public class Aeroport implements Airport
{
     private String name;
     
     public Aeroport(String n)
     {
     	name=n;	
     }
	
	 public String getName()
	 {
	 	return name;	
	 }

}
