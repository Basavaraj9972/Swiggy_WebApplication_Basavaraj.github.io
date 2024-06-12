package com.tap.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tap.daoImp.OrderDaoImpl;
import com.tap.daoImp.OrderHistoryDaoImpl;
import com.tap.daoImp.OrderItemsDaoImpl;
import com.tap.model.CartItem;
import com.tap.model.Order;
import com.tap.model.OrderHistory;
import com.tap.model.OrderItems;
@WebServlet("/CallingCheckOut")
public class CheckOutServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		HttpSession session = req.getSession();
		String address = (String)session.getAttribute("address");
		String PaymentMode = (String)session.getAttribute("PaymentMode");
		float totalAmount = (float)session.getAttribute("totalPrice");
		Integer userIdIng = (Integer)session.getAttribute("userId");
		int userId =0;
		if(userIdIng!=null) {
			userId = userIdIng.intValue();
		}
		int restaurantId = (int)session.getAttribute("restaurantId");
		
		OrderDaoImpl orderDaoImpl = new OrderDaoImpl();
//		public Order(int restaurantId_och, int userId, float totalAmount, String modeOfPayment, String status,
//				String address)
		
		LocalDateTime ldt = LocalDateTime.now();
	     String localDateToStr =ldt.toString();
	     String[] ar = localDateToStr.split("-");
	     String t ="";
	     for(int i =0;i<ar.length;i++) {
	    	 if(i==0) {
	    		 String year = ar[i];
	    		 for(int j=2;j<year.length();j++) {
	    			 t = t + year.charAt(j);
	    		 }
	    	 }
	    	 if(i==1) {
	    		 t = t + ldt.getMonth().toString().charAt(0);
	    	 }
	    	 if(i==2) {
	    		 String[] DayTime = ar[i].split("T");
	    		 for(int k=0;k<DayTime.length;k++) {
	    			 if(k==0) {
	    				 int day = Integer.parseInt(DayTime[k]);
	    				 t = t + day;
	    			 }
	    			 if(k==1) {
	    				 String[] Times = DayTime[k].split(":");
	    				 for(int l=0;l<Times.length;l++) {
	    					 if(l!=2){
	    						 int hms = Integer.parseInt(Times[l]);
	    						 t = t + hms;
	    					 }
	    					else if(l==2) {
	    						String secondnano = Times[l];
	    						String[] secnano = secondnano.split(".");
	    						for(int q =0;q<secondnano.length()-7;q++) {
	    							if(q==2) {
	    								continue;
	    							}
	    							t = t + secondnano.charAt(q);
	    						}
	    					}
	    				 }
	    			 }
	    		 }
	    	 }
	     }
	     System.out.println(t);
		String orderId = t;
		session.setAttribute("orderId", orderId);
		String orderId_item =orderId;
		String orderId_oh = orderId;
		Order order = new Order(orderId,restaurantId,userId,totalAmount,PaymentMode,"Confirmed",address);
		orderDaoImpl.addOrder(order);
//		public OrderItems(int userId, int menuId, String itemName, int quantity, float price)	
//		public CartItem(int itemId, int restId, String name, float price, int quantity) {
		OrderItemsDaoImpl orderItemsDaoImpl = new OrderItemsDaoImpl();
		Map<Integer,CartItem> cart = (Map<Integer,CartItem>)session.getAttribute("cart");
		if(cart!=null && !cart.isEmpty()) {
			Set<Entry<Integer, CartItem>> entrySet = cart.entrySet();
			for( Entry<Integer, CartItem> entry:entrySet) {
				OrderItems orderItems = new OrderItems(userId,entry.getValue().getItemId(),entry.getValue().getName(),entry.getValue().getQuantity(),entry.getValue().getPrice(),orderId_item);
				orderItemsDaoImpl.addOrderItems(orderItems);
			}
		}
		OrderHistoryDaoImpl orderHistoryDaoImpl = new OrderHistoryDaoImpl();
//		orderHistoryId, userId_oh, orderId_oh
		OrderHistory orderHistory = new OrderHistory(userId,orderId_oh);
		orderHistoryDaoImpl.addOrderHistory(orderHistory);
		session.setAttribute("cart",null);
		cart.clear();
		RequestDispatcher rd = req.getRequestDispatcher("SuccessfullyOrder.jsp");
		rd.forward(req, resp);
	}
}
