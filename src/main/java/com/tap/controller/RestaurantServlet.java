package com.tap.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tap.daoImp.MenuDaoImpl;
import com.tap.daoImp.RestaurantDaoImpl;
import com.tap.model.Menu;
import com.tap.model.Restaurant;
@WebServlet("/CallinServlet1")
public class RestaurantServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String msg = req.getParameter("msg");
		System.out.println(msg);
		req.setAttribute("msg", msg);
		RestaurantDaoImpl r = new RestaurantDaoImpl();
		List<Restaurant> allRestaurant = r.getAllRestaurant();
		req.setAttribute("allRestaurant", allRestaurant);
		RequestDispatcher rd = req.getRequestDispatcher("Restaurant.jsp");
		rd.forward(req,resp);
	}
}
	
//		for(Restaurant restaurant:allRestaurant) {
//			//restaurantId, name, imagePath, rating, eta, cuisinType, address, isActive, restaurantOwnId
//			out.printf("%-10s %-10f %-3d %-15s %-2b \n",restaurant.getName(),restaurant.getRating(),restaurant.getEta(),restaurant.getCuisinType(),restaurant.isActive());
//		}
//		session.setAttribute("allRestaurant", allRestaurant);
//		RequestDispatcher rd = req.getRequestDispatcher("Restaurant.jsp");
//		rd.forward(req, resp);
		
			
