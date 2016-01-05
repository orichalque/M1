package fr.nantes.cta.two;

import fr.nantes.cta.Coordinate;
import fr.nantes.cta.CompassDirection;


 public class  Longitude  implements Coordinate{
	
	public Longitude (int degre,int minute,int seconde,CompassDirection loc){
	deg=degre;
	min=minute;
	sec=seconde;
	location=loc;
	}
    /**
     * @return the angle, in decimal degrees
     */
    public  double degrees(){
	return deg + min / 60 + sec / 3600; 
    }

    /**
     * @return the angle, in radians
     */
    public double radians(){
	return Math.toRadians(degrees()) ;

	}

    /**
     * @return the trigonometric cosine of an angle.
     */
    public double cos(){
	return Math.cos(radians());
	}

    /**
     * @return the trigonometric sine of an angle.
     */
    public  double sin(){
	return Math.sin(radians());
}

    /**
     * @return the location of the coordinate. North or South, if 
     * it represents a Latitude. East or West, if it represents a
     * Longitude. 
     * @see CompassDirection
     */
   public  CompassDirection direction(){
	   return location;
   }
private CompassDirection location;
private int deg;
private int min ;
private int sec;
	
}                                       