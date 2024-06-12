package com.tap.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tap.daoImp.RestaurantDaoImpl;
import com.tap.model.Restaurant;
@WebServlet("/CallingUpdate_Restaurant")
public class UpadateRestaurant extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int restaurantId = Integer.parseInt(req.getParameter("restaurantId"));
		String name = req.getParameter("name");
		String imagePath = req.getParameter("imagePath");
		float rating = Float.parseFloat(req.getParameter("rating"));
		int eta = Integer.parseInt(req.getParameter("eta"));
		String cuisinType = req.getParameter("cuisinType");
		String address = req.getParameter("address");
		Boolean isActive = Boolean.parseBoolean(req.getParameter("isActive"));
		int restaurantOwnId = Integer.parseInt(req.getParameter("restaurantOwnId"));
		
		System.out.println(restaurantId);
		System.out.println(name);
		System.out.println(imagePath);
		System.out.println(rating);
		System.out.println(eta);
		System.out.println(cuisinType);
		System.out.println(address);
		System.out.println(isActive);
		System.out.println(restaurantOwnId);
		
		RestaurantDaoImpl r = new RestaurantDaoImpl();
		Restaurant restaurant = new Restaurant(restaurantId,name,imagePath,rating,eta,cuisinType,address,isActive,restaurantOwnId);
		r.updateRestaurant(restaurant);
	}
}
