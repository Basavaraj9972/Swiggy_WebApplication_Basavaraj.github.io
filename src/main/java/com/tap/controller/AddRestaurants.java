package com.tap.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tap.daoImp.RestaurantDaoImpl;
import com.tap.model.Restaurant;
@WebServlet("/CallingAdd_Restaurant_Servlet1")
public class AddRestaurants extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String imagePath = req.getParameter("imagePath");
		float rating = Float.parseFloat(req.getParameter("rating"));
		int eta = Integer.parseInt(req.getParameter("eta"));
		String cuisinType = req.getParameter("cuisinType");
		String address = req.getParameter("address");
		Boolean isActive = Boolean.parseBoolean(req.getParameter("isActive"));
		int restaurantOwnId = Integer.parseInt(req.getParameter("restaurantOwnId"));
		int available = 0;
//		if(isActive.equals("true")) {
//			available =1;
//		}
//		else {
//			available =0;
//		}
		System.out.println(name);
		System.out.println(imagePath);
		System.out.println(rating);
		System.out.println(cuisinType);
		System.out.println(address);
		System.out.println(isActive);
		System.out.println(restaurantOwnId);
		RestaurantDaoImpl r = new RestaurantDaoImpl();
		Restaurant restaurant = new Restaurant(name,imagePath,rating,eta,cuisinType,address,isActive,restaurantOwnId);
		r.addRestaurant(restaurant);
	}
}
//private String name;
//private String imagePath;
//private float rating;
//private int eta;
//private String cuisinType;
//private String address;
//private boolean isActive;
//private int restaurantOwnId;
