<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.Map,com.tap.model.CartItem,java.util.Set,java.util.Map.Entry" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>View Cart from cart</title>
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
	 #totle1{
	 	text-align:center;
	 	padding-left:50px;
	 }
	  #totle1, #totle2 {
        text-align: center;
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
	div{
    float:right;
    display:flex;
    margin-left:5px;
    margin-bottom:50px;
    }
    #home_button{
    margin-left:0px;
    }
   h1{
        text-align: center;
        padding-top:30px;
        margin-left:200px;
        color:rgb(7, 3, 243);
    }
    h1:hover{
    	color:rgb(248, 5, 248);
    }
    
</style>
</head>
<body>
<div>
<div id="home_button"><a href="CallinServlet2"><input type="button" value="Home"></button></a></div>
<div><a href="CallinLogOutServlet1?msg=logout_success"> <button  id = "logout" class="btn btn-danger"  value="Logout">Logout<img src="imgfolder/logout.png" height="35px" width="35px" alt="Logout"></img></button></a></div>
</div>
	<%  Map<Integer, CartItem> cart  = (Map<Integer,CartItem>)session.getAttribute("cart"); 
		Float  totalPriceFloat = (Float)session.getAttribute("totalPrice");
		float totalPrice = 0.0f;
		if(totalPriceFloat != null){
			totalPrice = totalPriceFloat.floatValue();
		}
		if(cart == null || cart.isEmpty()){ %>
			<% session.setAttribute("alert", "Cart is Empty") ;%>
		<% RequestDispatcher rd = request.getRequestDispatcher("CallinServlet2");
		rd.forward(request, response);
		}
		else if(!cart.isEmpty()){
		%>
			<h1> See the View Cart Items</h1>
			<table>
			<tr>
			<th>ItemId </th>
			<th>RestaurantId</th>
			<th>itemName</th>
			<th> Price</th>
			<th> quantity</th>
			</tr>
		<% Set<Entry<Integer, CartItem>> entrySet = cart.entrySet();
		for(Entry<Integer, CartItem> entry : entrySet){
			%>
			<tr>
				<td><%= entry.getValue().getItemId()%> </td>
				<td><%= entry.getValue().getRestId()%> </td>
				<td><%= entry.getValue().getName()%> </td>
				<td><%= entry.getValue().getPrice() %></td>
				<td><%= entry.getValue().getQuantity() %></td>
			</tr>
		<% } %>
		<tr>
			<td colspan="3" id="totle1"><b>Total Price</b></td>
			<td colspan="2" id="totle2"><b><%= totalPrice %></b></td>
		</tr>
		</table>
   <%}
	%>
</body>
</html>
<!-- <h1  style="text-align:center; font-size: 50px; font-weight: bold; animation: highlight3 2s infinite alternate; text-shadow: 2px 2px 4px #888;"> See the View Cart Items</h1> -->