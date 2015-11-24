package com.launcher;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.BufferedReader;
import java.io.IOException;

@SuppressWarnings("serial")
public class DiceLauncherServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			  throws ServletException, IOException {
		System.out.println("Bonjour");
		StringBuffer sb = new StringBuffer();
		
		try {
			BufferedReader reader = request.getReader();
			String line = null;
 			while ((line = reader.readLine()) != null) {
				sb.append(line);
			}
		} catch (Exception e){
			e.printStackTrace();
		}
		 
		JSONParser parser = new JSONParser();
		JSONObject joUser = null; 
		try { 
			joUser = (JSONObject) parser.parse(sb.toString());
		} catch (Exception e) { e.printStackTrace(); }
		
		Person p = new Person();
		p.setName( (String) joUser.get("name"));
		p.setScore( (int) joUser.get("score"));
		System.out.println(p.getName());
			  // you can handle jsonString by parsing it to a Java object. 
			  // For this purpose, you can use one of the Json-Java parsers like gson**.
	}
}