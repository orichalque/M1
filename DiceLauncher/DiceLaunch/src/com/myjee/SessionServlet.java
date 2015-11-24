package com.myjee;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;

public class SessionServlet extends javax.servlet.http.HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res)
		    throws ServletException, IOException {
		
		HttpSession session = req.getSession(true);
		double sessionId = Math.random();
		session.setAttribute("session", Math.random());
	}
}
