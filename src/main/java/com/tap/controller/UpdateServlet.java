package com.tap.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tap.daoImp.MenuDaoImpl;
import com.tap.daoImp.OrderItemsDaoImpl;
import com.tap.model.CartCreator;
import com.tap.model.CartItem;
import com.tap.model.Menu;
import com.tap.model.OrderItems;
@WebServlet("/UpdateServlet1")
public class UpdateServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 HttpSession session = req.getSession();
		 String update = (String)session.getAttribute("update");
			CartCreator cartCreator = (CartCreator)session.getAttribute("cartCreator");
			if(cartCreator == null) {
				cartCreator = new CartCreator();
				session.setAttribute("cartCreator", cartCreator);
			}
		 if( update!=null  && !update.isEmpty() &&  update.equals("update")) {
				System.out.println("Update block");
				String quantity_cartStr = req.getParameter("quantity_cart");
				int quantity_cart =0;
				if(quantity_cartStr!=null && !quantity_cartStr.isEmpty()) {
					quantity_cart = Integer.parseInt(quantity_cartStr);
					System.out.println(quantity_cart);
				}
				String menuIdObj = req.getParameter("menuId_u");
				System.out.println(menuIdObj);
				System.out.println();
				int menuId =0;
				if(menuIdObj!=null && !menuIdObj.isEmpty()) {
					menuId = Integer.parseInt(menuIdObj);
					MenuDaoImpl menuDaoImpl = new MenuDaoImpl();
					Menu menu = menuDaoImpl.getMenu(menuId);
					System.out.println(menuId);
					cartCreator.updateCartItem(menuId,quantity_cart,menu.getPrice());
				}
				Map<Integer, CartItem> cart = cartCreator.getAll();
				session.setAttribute("cart", cart);
				session.setAttribute("update", null);
				RequestDispatcher rd = req.getRequestDispatcher("AddCart.jsp");
				rd.forward(req, resp);
			}
	}
}

//Integer menuIdObj = (Integer)session.getAttribute("menuId");
//int menuId =0;
//if(menuIdObj!=null) {
//	menuId = menuIdObj.intValue();
//}
//System.out.println(menuId);
//String quantityStr = (String)req.getParameter("quantity");
//int quantity =0;
//if(quantityStr!=null) {
//	quantity = Integer.parseInt(quantityStr);
//}
//System.out.println(quantity);
//MenuDaoImpl m = new MenuDaoImpl();
//Menu menu = m.getMenu(menuId);
//String menuName = menu.getName();
// float price = menu.getPrice();
// float updatedBal =  price * quantity;
// 
// OrderItemsDaoImpl orderItemsDaoImpl = new OrderItemsDaoImpl();
// 
// Integer userIdObj = (Integer)session.getAttribute("userId");
// int userId = 0;
// if(userIdObj!=null) {
//	 userId = userIdObj.intValue();
// }
// OrderItems orderItems = new OrderItems(userId,menuId,menuName,quantity,updatedBal,4.5f);
//// orderItemsDaoImpl.addOrderItems(orderItems);
// OrderItems orderItems2 = orderItemsDaoImpl.getOrderItems(menuId);
// session.setAttribute("orderItems2", orderItems2);
// System.out.println(updatedBal);
// session.setAttribute("menuId", menuId);
// session.setAttribute("quantity", quantity);
// session.setAttribute("price", price);
// session.setAttribute("updatedBal", updatedBal);
// RequestDispatcher rd = req.getRequestDispatcher("UpdateServlet.jsp");
// rd.forward(req, resp);
// Integer quantityObj = (Integer)session.getAttribute("quantity1");
// int quantity1 = 0;
// if(quantityObj!=null) {
//	quantity1 = quantityObj.intValue();
// }
// System.out.println(quantity1);

