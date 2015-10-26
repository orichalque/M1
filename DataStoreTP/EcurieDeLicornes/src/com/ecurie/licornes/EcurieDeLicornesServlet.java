package com.ecurie.licornes;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.*;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.*;
import com.google.appengine.api.datastore.Query.CompositeFilter;
import com.google.appengine.api.datastore.Query.CompositeFilterOperator;



@SuppressWarnings("serial")
public class EcurieDeLicornesServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		
		
		
		resp.setContentType("text/plain");
		resp.getWriter().println("Hello, world");
		
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		
		Filter tailleMin = new FilterPredicate("taille", FilterOperator.GREATER_THAN, 100.0);
		Filter tailleMax = new FilterPredicate("taille", FilterOperator.LESS_THAN, 120.0);
		Filter compositeFilter = CompositeFilterOperator.and(tailleMin, tailleMax); 
		Query q = new Query("Licorne").setFilter(compositeFilter);
		PreparedQuery pq = datastore.prepare(q); 

		resp.getWriter().println(pq.countEntities());
	} 
}
 