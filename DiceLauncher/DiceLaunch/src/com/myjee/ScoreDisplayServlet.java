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
public class ScoreDisplayServlet extends HttpServlet {
	static {
		ObjectifyService.register(Person.class);
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			  throws ServletException, IOException {
		List<Person> liste = ObjectifyService.ofy().load().type(Person.class).list();
		PrintWriter out = response.getWriter();
		out.println(liste.toString());
		out.println("<form action=\"/\" ng-show=\"diceCtrl.submited == true\"><input type=\"submit\" value=\"Play Again\"></form>");
		
	}
}
