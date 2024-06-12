package com.tap.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tap.daoImp.RestaurantDaoImpl;
import com.tap.model.Restaurant;
@WebServlet("/CallinServlet2")
public class RestaurantServlet1 extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		RestaurantDaoImpl r = new RestaurantDaoImpl();
		List<Restaurant> allRestaurant = r.getAllRestaurant();
		req.setAttribute("allRestaurant", allRestaurant);
		List<Restaurant> all_Top_Restaurant = r.getAll_Top_Restaurant();
		req.setAttribute("all_Top_Restaurant", all_Top_Restaurant);
		RequestDispatcher rd = req.getRequestDispatcher("Restaurant1.jsp");
		rd.forward(req,resp);
	}
}