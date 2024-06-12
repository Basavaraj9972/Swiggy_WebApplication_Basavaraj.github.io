<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.List,com.tap.model.OrderItems" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Order History page</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
<style>
	table{
	border-collapse : collapse;
	width:100%;
	}
	 table th,table td {
	 border:2px solid black;
     padding: 20px;
     font-size:22px;
	 }
	  h1{
  		margin-top:40px;
  		color: #5508fa;
  		text-align:center;
  		cursor: pointer;
 	 }
  	h1:hover{
  		color: #fa5908;
  }
  td{
    background-color: #6fefe2; 
  }
  th {
    background-color: #07f60f; 
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
    margin-left:1050px;
    }
   #log_out{
    margin-left:1150px;
    margin-top:-46px;
    }
</style>
</head>
<body>
<div id="home_button"><a href="CallinServlet2"><input type="button" value="Home"></button></a></div>
<div id="log_out"><a href="CallinLogOutServlet1?msg=logout_success"> <button  id = "logout" class="btn btn-danger"  value="Logout">Logout<img src="imgfolder/logout.png" height="35px" width="35px" alt="Logout"></img></button></a></div>
	<% List<OrderItems>  allOrderItemsThroughUserId = (List<OrderItems>)session.getAttribute("allOrderItemsThroughUserId"); 
	if(allOrderItemsThroughUserId == null || allOrderItemsThroughUserId.isEmpty()){ %>
		<% session.setAttribute("alert_history", "no Order History Available") ;%>
		<% RequestDispatcher rd = request.getRequestDispatcher("CallinServlet2");
		rd.forward(request, response);
		}
		else if(!allOrderItemsThroughUserId.isEmpty()){
		%>
		<div>
			<h1  style="text-align:center"> See the Order History Items are </h1>
		</div>
			<table>
			<tr>
			<th>OrderItemId </th>
			<th>UserId </th>
			<th>MenuId</th>
			<th>itemName</th>
			<th> quantity</th>
			<th> Price</th>
			<th> OrderId_Item</th>
			</tr>
		<% 
		for(OrderItems orderItems : allOrderItemsThroughUserId){
			%>
			<tr>
				<td><%= orderItems.getOrderItemId()%> </td>
				<td><%= orderItems.getUserId()%> </td>
				<td><%= orderItems.getMenuId()%> </td>
				<td><%= orderItems.getItemName()%> </td>
				<td><%= orderItems.getQuantity()%> </td>
				<td><%= orderItems.getPrice()%> </td>
				<td><%= orderItems.getOrderId_item()%> </td>
			</tr>
		<% } %>
			 </table>
   <%}
	%>
</body>
</html>
<!-- <h1  style="text-align:center; font-size: 50px; font-weight: bold; animation: highlight3 2s infinite alternate; text-shadow: 2px 2px 4px #888;"> Order History Items are displayed from the OrderItem table </h1> -->