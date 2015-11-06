package fr.nantes.cta;

import fr.nantes.cta.two.*;


 class CTAFactoryImpl implements CTAFactory {
	/*
	 * Created on 23 oct. 06
	 *
	 */
	


	/**
	     * @param weight
	     * @param loading
	     * @param consumption
	     * @param tank
	     * @return a new airplane
	     */
	public CTAFactoryImpl(){
		
	}
	    public Airplane createAirplane(double weight, int loading, int consumption, int tank){
		Avion a=new Avion(weight,loading,consumption,tank);
		return a;
		}    
	    /**
	     * @param name
	     * @return a new airport
	     */
	    public Airport createAirport(String nam){
	    Aeroport ap=new Aeroport(nam);
	    return ap;
	    }
	    /**
	     * @param start
	     * @param stop
	     * @return a new airway
	     */
	    public Airway createAirway(VOR start, VOR stop){
		CouloirAerien coul=new CouloirAerien(start,stop);
		return coul;
		}
	    
	    public FlightPlan createFlightPlan(){
		PlanVol pl=new PlanVol();
		return pl;
		}
	    
	    
	    /**
	     * @param departure
	     * @param arrrival
	     * @param plane
	     * @param fp
	     * @param passengers
	     * @return
	     * @throws IncompatibleAirway
	     */
	   /* public Flight createMilitarFlight(Airport departure, Airport arrival,
	            Airplane plane, FlightPlan fp, int passengers)
	            throws IncompatibleAirway, AirplaneOverload;*/

	    public Flight createCivilFlight(Airplane plan,Airport departure, Airport arrival,  FlightPlan fp, int passengers)
	            throws IncompatibleAirway,AirplaneOverload
	        {
	 	    VolsCivil  vc=new VolsCivil(plan,departure, arrival , fp,passengers );
	 	    int in=0;
	    	int m=vc.getFlightPlan().getPath().size();
	    	CouloirAerien a;
	    	TakenAirway[] t=vc.getFlightPlan().getPath().toArray(new TakenAirway[0]);
	    	if(vc.totalWeight()>(vc.getAirplane().weight()+ vc.getAirplane().getLoading())) throw  new AirplaneOverload ();
	    	for(;in<m ; in++){
	    		a=(CouloirAerien)t[in].getAirway();
	    		if(a.getVor1().getPosition().getLatitude().degrees()>90) throw new IncompatibleAirway();
	    		if(a.getVor1().getPosition().getLatitude().degrees()>180) throw new IncompatibleAirway();
	    	}	    	
		return vc;
		    }
	            //throws IncompatibleAirway, AirplaneOverload;
	    
	    /**
	     * @param departure
	     * @param arrrival
	     * @param plane
	     * @param fp
	     * @param passengers
	     * @return
	     * @throws IncompatibleAirway
	     */
	    public Flight createMilitarFlight(Airplane plan,Airport departure, Airport arrival, FlightPlan fp, int passengers)
	    throws IncompatibleAirway, AirplaneOverload{
	VolsMilitaire vm=new  VolsMilitaire (plan,departure,arrival,fp,passengers);
	int in=0;
	int m=vm.getFlightPlan().getPath().size();
	CouloirAerien a;
	TakenAirway[] t=vm.getFlightPlan().getPath().toArray(new TakenAirway[0]);
	if(vm.totalWeight()>(vm.getAirplane().weight()+ vm.getAirplane().getLoading())) throw  new AirplaneOverload ();
	for(;in<m ; in++){
		a= (CouloirAerien) t[in].getAirway();
		if(a.getVor1().getPosition().getLatitude().degrees()>90) throw new IncompatibleAirway();
		if(a.getVor1().getPosition().getLatitude().degrees()>180) throw new IncompatibleAirway();
	}	    	
		return vm;
	            //
	    }

	    
	    /**
	     * @param degrees
	     * @param minutes
	     * @param seconds
	     * @param dir
	     * @return
	     */
	    public Coordinate createLatitude(int degrees, int minutes, int seconds, CompassDirection dir){
		latittude lat=new latittude(degrees , minutes ,seconds, dir);
		return lat;
		}
	    
	    /**
	     * @param degrees
	     * @param minutes
	     * @param seconds
	     * @param dir
	     * @return
	     */
	    public Coordinate createLongitude(int degrees, int minutes,
	            int seconds, CompassDirection dir){
	    	Longitude lon=new Longitude(degrees , minutes ,seconds, dir);
			return lon;
	           
	 }

	    /**
	     * @param latitude
	     * @param longitude
	     * @return
	     */
	    public Position createPosition(Coordinate latitude, Coordinate longitude){
	    	Position_impl pi = new Position_impl(latitude,longitude);
		return pi;
	}
	    
	    /**
	     * @param airway
	     * @param altitude
	     * @param dir
	     * @return
	     */
	    public TakenAirway createTakenAirway(Airway airway, int altitude, CompassDirection dir){
	    	takenAirwy_imp  pv=new takenAirwy_imp  (airway,altitude, dir);
	return pv;
	}
	    
	    /**
	     * @param name
	     * @param position
	     * @return
	     */
	    public VOR createVOR(String name, Position position){
	Vors v=new Vors(name,position);
	return v;
	}
		public Flight createCivilFlight(Airport departure, Airport arrival, Airplane plane, FlightPlan fp, int passengers) throws IncompatibleAirway, AirplaneOverload {
			// TODO Auto-generated method stub
			return null;
		}
		public Flight createMilitarFlight(Airport departure, Airport arrival, Airplane plane, FlightPlan fp, int passengers) throws IncompatibleAirway, AirplaneOverload {
			// TODO Auto-generated method stub
			return null;
		}
	


}
