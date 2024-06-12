package com.tap.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/CallingOrderDetails")
public class CheckoutOrderDetails  extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String address = req.getParameter("address");
		String PaymentMode = req.getParameter("PaymentMode");
		session.setAttribute("address", address);
		session.setAttribute("PaymentMode", PaymentMode);
		RequestDispatcher rd = req.getRequestDispatcher("OrderConfirmation.jsp");
		rd.forward(req, resp);
	}
}
