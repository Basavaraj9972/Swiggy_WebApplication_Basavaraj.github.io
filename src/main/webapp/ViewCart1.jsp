<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.tap.model.Order,com.tap.model.OrderItems,java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>View Cart page from database</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
<style>
  table {
    border-collapse: collapse;
    width: 100%;
  }
  th, td {
    border: 1px solid #ddd; 
    padding: 15px;
    text-align: left;
    font-size:25px;
  }
  td{
    background-color: #ebc4c0; 
  }
  th {
    background-color: #fe07c5; 
  }
  #totle1{
    text-align: center;
    background-color:#64e7de;
   }
  #totle2{
   background-color:#64e7de;
  }
  .total-row {
    font-weight: bold;
  }
  h1{
  	margin-top:40px;
  	color: #5508fa;
  	text-align:center;
  }
  h1:hover{
  	color: #fa5908;
  }
  @keyframes highlight3 {
    		0% { color: #FF4500; } 
    		50% { color: rgb(17, 253, 5); } 
    		100% { color: rgb(5, 253, 253); } 
		}
		input[type="button"] {
        padding: 10px 20px;
        font-size: 18px;
        background-color: #4CAF50;
        color: white;
        border: none;
        border-radius: 5px;
        cursor: pointer;
    }
    
    input[type="button"]:hover {
       background-color:#0af521;
    }
    
    #home_button{
    margin-left:1150px;
    }
</style>
</head>
<body>
<div id="home_button"><a href="CallinServlet2"><input type="button" value="Home"></button></a>
	<a href="CallinLogOutServlet1?msg=logout_success"> <button  id = "logout" class="btn btn-danger"  value="Logout">Logout<img src="imgfolder/logout.png" height="35px" width="35px" alt="Logout"></img></button></a>
</div>
<%Order order  = (Order)session.getAttribute("order");
List<OrderItems> orderItemslist  = (List<OrderItems>)session.getAttribute("allOrderItemsThroughOrderId");
%>
		<%
		if(orderItemslist==null && order == null ){ 
			session.setAttribute("alert", "Cart is Empty") ;
		 	RequestDispatcher rd = request.getRequestDispatcher("CallinServlet2");
			rd.forward(request, response);
		}
		else if(order != null && !orderItemslist.isEmpty()) {
		%>
		<div>
			<h1  style="text-align:center; font-size: 50px; font-weight: bold; animation: highlight3 2s infinite alternate; text-shadow: 2px 2px 4px #888;"> View Cart Items are displayed from the Order and OrderItems table</h1>
		</div>
			<table>
			<tr>
			<th>ItemId </th>
			<th>itemName</th>
			<th>RestaurantId</th>
			<th> Price</th>
			<th> quantity</th>
			</tr>
		<% 
		for(OrderItems orderItems : orderItemslist){
			%>
			<tr>
				<td><%= orderItems.getMenuId()%> </td>
				<td><%= orderItems.getItemName()%> </td>
				<td><%= order.getRestaurantId_och()%> </td>
				<td><%= orderItems.getPrice() %></td>
				<td><%= orderItems.getQuantity() %></td>
			</tr>
		<% } %>
			<tr>
			<td colspan="3" id="totle1"><b>Total Price</b></td>
			<td colspan="2" id="totle2"><b><%= order.getTotalAmount()%></b></td>
		</tr>
	</table>
   <%}
	%>
</body>
</html>