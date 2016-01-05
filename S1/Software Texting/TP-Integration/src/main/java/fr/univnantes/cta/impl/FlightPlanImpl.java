package fr.univnantes.cta.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

import fr.univnantes.cta.FlightPlan;
import fr.univnantes.cta.TakenAirway;
import java.util.LinkedList;

public class FlightPlanImpl implements FlightPlan {

    private List<TakenAirway> path = new LinkedList<TakenAirway>();
    private List<TakenAirway> airwayListNonModifiable;

    public FlightPlanImpl() {
        airwayListNonModifiable = Collections.unmodifiableList(path);
    }

    public void addAirway(TakenAirway a) {

        if (path.isEmpty()) {
            path.add(a);
        } else {
            int dernier = (path.size() - 1);
            if (((AirwayImpl) (path.get(dernier).getAirway())).GetVORArrive()
                    != ((AirwayImpl) (a.getAirway())).GetVORDepart()) {

                throw new IllegalArgumentException("Wrong Flight Plan");
            }
            path.add(a);
        }
    }

    public double distance() {
        double total = 0;
        for (TakenAirway ta : path) {
            total = total + ta.distance();
        }
        return total;
    }

    public List<TakenAirway> getPath() {
        return airwayListNonModifiable;
    }
}
