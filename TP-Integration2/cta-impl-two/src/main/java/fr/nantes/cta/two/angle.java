package fr.nantes.cta.two;


import fr.nantes.cta.Angle;

//import classe_base.CompassDirection;

	 class Angleimp implements Angle{

		private double degres;
		private double minutes;
		private double secondes;
		
	public Angleimp(double degres, double minutes, double secondes) {
		this.degres = degres;
		this.minutes = minutes;
		this.secondes = secondes;
		
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
}
