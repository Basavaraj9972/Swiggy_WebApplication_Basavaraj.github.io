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

import com.tap.daoImp.OrderDaoImpl;
import com.tap.daoImp.OrderItemsDaoImpl;
import com.tap.model.Order;
import com.tap.model.OrderItems;
@WebServlet("/CallingViewCartServlet")
public class ViewCartServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String orderId = (String)session.getAttribute("orderId");
		if(orderId!=null && !orderId.isEmpty()) {
			OrderDaoImpl orderDaoImpl = new OrderDaoImpl();
			Order order = orderDaoImpl.getOrder(orderId);
			session.setAttribute("order", order);
			OrderItemsDaoImpl orderItemsDaoImpl = new OrderItemsDaoImpl();
			List<OrderItems> allOrderItemsThroughOrderId = orderItemsDaoImpl.getAllOrderItemsThroughOrderId(orderId);
			session.setAttribute("allOrderItemsThroughOrderId", allOrderItemsThroughOrderId);
		}
		RequestDispatcher rd = req.getRequestDispatcher("ViewCart1.jsp");
		rd.forward(req, resp);
	}
}
