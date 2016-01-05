package fr.nantes.cta.two;

//import classe_base.Angle;
import fr.nantes.cta.CompassDirection;
import fr.nantes.cta.Coordinate;

public class Coordonnee implements Coordinate {

	private double degres;
	private double minutes;
	private double secondes;
	private CompassDirection direction;
	

	public Coordonnee(double degres, double minutes, double secondes, CompassDirection direction) {
		this.degres = degres;
		this.minutes = minutes;
		this.secondes = secondes;
		this.direction = direction;
	}

	/**
     * @return the angle, in decimal degrees
     */
    public double degrees() {
    	return degres + minutes/60 + secondes/3600;
    }

    /**
     * @return the angle, in radians
     */
    public double radians() {
    	return Math.toRadians(degrees());
    }

    /**
     * @return the trigonometric cosine of an angle.
     */
    public double cos() {
    	return Math.cos(radians());
    }

    /**
     * @return the trigonometric sine of an angle.
     */
    public double sin() {
    	return Math.sin(radians());
    }

    /**
     * @return the location of the coordinate. North or South, if 
     * it represents a Latitude. East or West, if it represents a
     * Longitude. 
     * @see CompassDirection
     */
	public CompassDirection direction() {
		return direction;
	}

}
