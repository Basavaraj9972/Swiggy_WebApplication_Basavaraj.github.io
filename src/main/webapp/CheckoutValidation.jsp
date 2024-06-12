<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.Map,com.tap.model.CartItem" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>checkOut validation</title>
</head>
<body>
	<%  Map<Integer, CartItem> cart  = (Map<Integer,CartItem>)session.getAttribute("cart"); %>
	<% session.setAttribute("cart", cart); 
		if(cart.isEmpty()){ %>
		<script>confirm("Cart is Empty please add items to cart")</script> 
		
		<% RequestDispatcher rd = request.getRequestDispatcher("Menu.jsp");
		rd.include(request, response);
		}else if(!cart.isEmpty()) { %>
			<h1>Cart is available<h1>
		<%	RequestDispatcher rd = request.getRequestDispatcher("CheckOut.jsp");
			rd.forward(request, response);
		}
	%>
</body>
</html>