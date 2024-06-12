package com.tap.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/CallingAdd_Menu")
public class AddMenu extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String menuId = req.getParameter("menuId");
		String name = req.getParameter("name");
		String price = req.getParameter("price");
		String description = req.getParameter("description");
		String imagePath = req.getParameter("imagePath");
		String isActive = req.getParameter("isActive");
		String rating = req.getParameter("rating");
		String restaurantId = req.getParameter("restaurantId");
		System.out.println(menuId);
		System.out.println(name);
		System.out.println(price);
		System.out.println(description);
		System.out.println(imagePath);
		System.out.println(isActive);
		System.out.println(rating);
		System.out.println(restaurantId);
	}
}
