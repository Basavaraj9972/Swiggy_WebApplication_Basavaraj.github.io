<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page import="com.tap.model.Menu,java.util.ArrayList,java.util.TreeMap,java.util.Set,java.util.Map,java.util.Map.Entry,com.tap.model.OrderItems" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Update Page</title>
</head>

<body>
</body>
</html>
<!-- 
	< TreeMap<Menu,Integer> cartItems =  (TreeMap<Menu,Integer>)session.getAttribute("cartItems");
	 		//ArrayList<Menu> menuList = new ArrayList<Menu>();
	 		//menuList.add(menu1);
	 		OrderItems orderItems = (OrderItems)session.getAttribute("orderItems2");
	 		Integer menuIdObj = (Integer)session.getAttribute("menuId");
	 		int menuId =0;
	 		if(menuIdObj!=null){
	 			menuId = menuIdObj.intValue();
	 		}
	 		Float priceObj = (Float)session.getAttribute("price");
	 		float price = 0;
	 		if(priceObj != null){
	 			price = priceObj.floatValue();
	 		}
	 		Integer quantityObj = (Integer)session.getAttribute("quantity");
	 		int quantity =0;
	 		if(quantityObj != null){
	 			quantity = quantityObj.intValue();
	 		}
	 	 
	 		Float updatedBalObj = (Float)session.getAttribute("updatedBal");
	 		float updatedBal = 0.0f; // Default value if parameter is null
	 		if (updatedBalObj != 0 ) {
	 		    updatedBal = updatedBalObj.floatValue();
	 		}
	 		
	 		Set<Entry<Menu,Integer>> entrys =  cartItems.entrySet();
	 	for(Entry<Menu,Integer> e : entrys){
	 		session.setAttribute("entry", e);
	 		if(menuId == e.getKey().getMenuId()){
	%>
	<form action="UpdateServlet1">
	< session.setAttribute("menuId", e.getKey().getMenuId()); %>
	<pre><= e.getKey().getName() %> &#8377;<= updatedBal %> <label for="quantity" >Quantity</label> <input type="number" name="quantity" value="<%= quantity %>" ></input> <input type="submit" value="update"></input><input type="button" value="delete"></input></pre>
	<br></form>
	<} else{
	%>
	<form action="UpdateServlet1">
	< session.setAttribute("menuId", e.getKey().getMenuId()); %>
	<pre><= e.getKey().getName() %> &#8377;<= e.getKey().getPrice() %> <label for="quantity" >Quantity</label> <input type="number" name="quantity"  ></input>   <input type="submit" value="update"></input><input type="button" value="delete"></input></pre>
	<br></form>
	< }
		}%>
		< session.setAttribute("quantity",quantity); %>
		< session.setAttribute("price",price); %>
	<a href="Menu.jsp?"><input type="button" value="Add More Iteams"></input></a><br><br>
	<button onclick="openPopup()">Add to Cart items</button>
	<input type="button" value="Proced to checkout"></input>

 -->