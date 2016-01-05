package fr.nantes.cta.two;

import fr.nantes.cta.Coordinate;
import fr.nantes.cta.Position;


 public class Position_impl implements Position {
	 protected Coordinate lat;
	 protected Coordinate  longe;
	public Position_impl(Coordinate lati,Coordinate longi) {
		lat=lati;
		longe=longi;
		
		// TODO Auto-generated constructor stub
	}
	/* @return the latitude of this position.
    */
   public  Coordinate getLatitude(){
		return lat ;
	}

   /**
    * @return the longitude of this position.
    */
   public  Coordinate getLongitude(){
	return longe;
	}

   /**
    * Finds the distance in kilometers between two positions on earth.
    * 
    * @param other a Position
    * @return the distance between two positions, in km
    */
   public  double distanceTo(Position other){
	   double d;
	   final int  Rayon=640000;
	   Coordinate b= (Coordinate) other.getLatitude(); 
	   Coordinate lo= (Coordinate) other.getLongitude();
	  d= Rayon * Math.acos((lat.cos()*longe.cos()* b.cos()* lo.cos())+(lat.cos()*longe.sin()*b.cos()*lo.sin())+(lat.sin()*b.sin()));
	return d;
   }

}
