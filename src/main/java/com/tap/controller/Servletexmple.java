package com.tap.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/callingServletExample")
public class Servletexmple extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String lastname = req.getParameter("lastname");
		PrintWriter out = resp.getWriter();
		if(name==null) {
			out.println("");
			
		}
		out.println("Last Name : "+lastname);
	}
}
