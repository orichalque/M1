package com.TPWebNCloud;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import com.googlecode.objectify.ObjectifyService;

@SuppressWarnings("serial")
public class createPetitionServlet extends HttpServlet {
	static {
		ObjectifyService.register(Petition.class);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			  throws ServletException, IOException {
		StringBuffer jb = new StringBuffer();
		  String line = null;
		  try {
		    BufferedReader reader = request.getReader();
		    while ((line = reader.readLine()) != null)
		      jb.append(line);
		  } catch (Exception e) { 
			  System.out.println("Erreur");
		  }		  
		  JSONObject json = new JSONObject(jb.toString());
		  System.out.println(jb.toString());
		   
		  Petition p = new Petition();
		  
		  p.setTitle(json.getValue("title"));
		  p.setDescription(json.getValue("text"));
		  response.getWriter().println(p.toString());
		  
		  UserService userService = UserServiceFactory.getUserService();
		  User user = userService.getCurrentUser();
		  //Récupération de l'utilisateur google courant
		  
		  if (user != null) {
			  System.out.println(user.toString());
		  } else {
			  System.out.println("user null");
		  }		   
		  
		  ObjectifyService.ofy().save().entities(p).now();
		  response.getWriter().println("Ajout effectué");
	}

}