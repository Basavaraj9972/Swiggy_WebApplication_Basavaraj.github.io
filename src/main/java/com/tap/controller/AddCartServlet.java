package com.tap.controller;

import java.io.IOException;
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

import com.tap.daoImp.MenuDaoImpl;
import com.tap.model.CartCreator;
import com.tap.model.CartItem;
import com.tap.model.Menu;
@WebServlet("/CallingAddCardServlet1")
public class AddCartServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		Integer restaurantIdObj = (Integer)session.getAttribute("restaurantId");
		int restaurantId = 0;
		if(restaurantIdObj != null) {
			restaurantId = restaurantIdObj.intValue();
		}
		String menuIdStr = req.getParameter("menuId");
		int menuId = 0;
		if(menuIdStr!=null && !menuIdStr.isEmpty()) {
			menuId = Integer.parseInt(menuIdStr);
		}
		
		System.out.println("menuId :"+menuId);
		int prev_restaurantId=0;
		Integer preRet_id = (Integer)session.getAttribute("prev_restaurantId");
		if(preRet_id != null) {
			prev_restaurantId = preRet_id.intValue();
		}
			MenuDaoImpl menuDaoImpl = new MenuDaoImpl();
			Menu singleMenu = menuDaoImpl.getMenu(menuId);
			if(singleMenu!=null) {
				prev_restaurantId = singleMenu.getRestaurantId();
			}
			if(singleMenu!=null) {
				System.out.println("singleMenu.getRestaurantId() : "+singleMenu.getRestaurantId());
			}
			session.setAttribute("prev_restaurantId", prev_restaurantId);
			session.setAttribute("singleMenu", singleMenu);
			int qauntity = 0;
			String qauntityStr = req.getParameter("quantity_m");
			System.out.println(qauntityStr+" Quantity String");
			 if(qauntityStr != null && !qauntityStr.isEmpty()) {
				qauntity = Integer.parseInt(qauntityStr);
				System.out.println(qauntity);
			}
			String add = (String)session.getAttribute("add");
			String delete = (String)session.getAttribute("delete");
//		 CartCreator cartCreator = new CartCreator();
			CartCreator cartCreator = (CartCreator)session.getAttribute("cartCreator");
			if(cartCreator == null) {
				cartCreator = new CartCreator();
				session.setAttribute("cartCreator", cartCreator);
			}
			if(add!=null && !add.isEmpty() && add.equals("add")) {
			System.out.println("Add block");
			if(singleMenu!=null) {
				CartItem cartItem = new CartItem(menuId,restaurantId,singleMenu.getName(),singleMenu.getPrice(),qauntity,singleMenu.getImagepath());
				Map<Integer, CartItem> cart = cartCreator.addcartCartItem(cartItem);
				session.setAttribute("cart", cart);
				session.setAttribute("add", null);
			}
			else {
				System.out.println("Single menu is unable to creat cart item");
			}
//			RequestDispatcher rd = req.getRequestDispatcher("AddCart.jsp");
//			rd.forward(req, resp);
			}
			else if( delete!=null  && !delete.isEmpty() && delete.equals("delete")) {
				System.out.println("Delete block");
				String menuIdObj = req.getParameter("menuId_d");
				System.out.println(menuIdObj+"string");
				System.out.println();
				int menuId_d =0;
				if(menuIdObj!=null && !menuIdObj.isEmpty()) {
					menuId_d = Integer.parseInt(menuIdObj);
					System.out.println(menuId_d+"Int");
					cartCreator.deletCartItem(menuId_d);
				}
				Map<Integer, CartItem> cart = cartCreator.getAll();
				Set<Entry<Integer, CartItem>> entrySet = cart.entrySet();
				for(Entry<Integer, CartItem> entry:entrySet) {
					System.out.println(entry.getValue().getItemId());
				}
				session.setAttribute("cart", cart);
				session.setAttribute("delete", null);
			}
		RequestDispatcher rd = req.getRequestDispatcher("AddCart.jsp");
		rd.forward(req, resp);
//		ArrayList<Menu> SinglemenuList = new ArrayList<Menu>(); 
//		System.out.println(menuId);
//		 TreeMap<Menu, Integer> cartItems = (TreeMap<Menu,Integer>)session.getAttribute("cartItems");
//		 if (cartItems == null) {
//	            // If the cart is null, create a new one
//	            cartItems = new TreeMap<Menu,Integer>();
//	            session.setAttribute("cartItems", cartItems);
//	        }
//		Integer menuIdObj = (Integer)session.getAttribute("menuId");
//		int menuId =0;
//		if(menuIdObj != null) {
//			menuId = menuIdObj.intValue();
		//}
//		if(cartItems.containsKey(singleMenu)) {
//			cartItems.put(singleMenu, cartItems.get(singleMenu)+1);
//		}
//		else {
//			cartItems.put(singleMenu, 1);
//		}
//		RequestDispatcher rd = req.getRequestDispatcher("AddCart.jsp");
//		rd.forward(req, resp);
	}
}
