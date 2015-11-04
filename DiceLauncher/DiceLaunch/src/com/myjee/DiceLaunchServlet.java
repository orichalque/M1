package com.myjee;


import javax.servlet.ServletException;
import javax.servlet.http.*;

import JSONParser.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;

@SuppressWarnings("serial")
public class DiceLaunchServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			  throws ServletException, IOException {
		System.out.println("Bonjour");
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
		  System.out.println(jb.toString());
		  JSONObject json = new JSONObject(jb.toString());
		  json.getValue("name");
		  json.getValue("score");
	}
}
