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

import com.tap.daoImp.OrderItemsDaoImpl;
import com.tap.model.OrderItems;
@WebServlet("/CallingOrderHistory")
public class ViewOrderHistory  extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		Integer userIdstr = (Integer)session.getAttribute("userId");
		if(userIdstr!=0) {
			int userId = userIdstr.intValue();
			OrderItemsDaoImpl orderItemsDaoImpl = new OrderItemsDaoImpl();
			List<OrderItems> allOrderItemsThroughUserId = orderItemsDaoImpl.getAllOrderItemsThroughUserId(userId);
			session.setAttribute("allOrderItemsThroughUserId", allOrderItemsThroughUserId);
			RequestDispatcher rd = req.getRequestDispatcher("ViewOrderHistory.jsp");
			rd.forward(req, resp);
		}
	}
}
