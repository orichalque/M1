
package com.myjee;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import com.googlecode.objectify.ObjectifyService;

import JSONParser.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@SuppressWarnings("serial")
public class DiceLaunchServlet extends HttpServlet {
	static {
		ObjectifyService.register(Person.class);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			  throws ServletException, IOException {
		StringBuffer jb = new StringBuffer();
		  String line = null;
		  try {
		    BufferedReader reader = request.getReader();
		    while ((line = reader.readLine()) != null)
		      jb.append(line);
		  } catch (Exception e) { /*report an error*/ 
			  // you can handle jsonString by parsing it to a Java object. 
			  // For this purpose, you can use one of the Json-Java parsers like gson**.
		  }
		  
		  JSONObject json = new JSONObject(jb.toString());
		  System.out.println(jb.toString());
		  Person p = new Person();
		  p.setName(json.getValue("name"));
		  p.setScore(Integer.parseInt(json.getValue("score")));
		  System.out.println(p.toString());
		  
		  UserService userService = UserServiceFactory.getUserService();
		  User user = userService.getCurrentUser();
		  if (user != null) {
			  System.out.println(user.toString());
		  } else {
			  System.out.println("user null");
		  }
		   
		  ObjectifyService.ofy().save().entities(p).now();
	}
}
