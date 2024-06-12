package com.tap.controller;

import java.io.IOException;
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
@WebServlet("/MenuServlet")
public class MenuServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	   HttpSession session = req.getSession();
//	   String restaurantId = req.getParameter("restaurantId");
	   int restaurantId  = Integer.parseInt(req.getParameter("restaurantId"));
		MenuDaoImpl m = new MenuDaoImpl();
	    List<Menu> byRestauarantIdlist = m.getByRestauarantId(restaurantId);
		session.setAttribute("allMenu", byRestauarantIdlist);
		RestaurantDaoImpl r = new RestaurantDaoImpl();
		Restaurant restaurant = r.getRestaurant(restaurantId);
		session.setAttribute("restaurant", restaurant);
		RequestDispatcher rd = req.getRequestDispatcher("Menu.jsp");
		rd.forward(req, resp);
	}
}
