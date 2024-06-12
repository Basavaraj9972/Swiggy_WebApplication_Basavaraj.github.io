<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.Map,com.tap.model.CartItem,java.util.Set,java.util.Map.Entry" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Order Confirmation</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
<style>
    table {
        border-collapse: collapse;
        width: 50%;
        margin: auto;
        align:center;
    }
    th, td {
        border: 1px solid black;
        padding: 8px;
        text-align: left;
    }
    td{
    	background-color: rgb(244, 221, 207);
    }
    th {
        background-color: rgb(248, 5, 199);
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
    form {
        text-align: center;
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
    #totle1{
    text-align: center;
    background-color:#64e7de;
   }
  	#totle2{
   		background-color:#64e7de;
  	}
  	@keyframes highlight {
   			 0% { color: #FFD700; } 
    		50% { color: #FF6347; } 
   			 100% { color: #FFD700; } 
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
    margin-left:0px;
    }
    div{
    float:right;
    display:flex;
    margin-left:5px;
    }
</style>
</head>
<body>
<div>
<div id="home_button"><a href="CallinServlet2"><input type="button" value="Home"></button></a></div>
<div><a href="CallinLogOutServlet1?msg=logout_success"> <button  id = "logout" class="btn btn-danger"  value="Logout">Logout<img src="imgfolder/logout.png" height="35px" width="35px" alt="Logout"></img></button></a></div>
</div>	
	<%  Map<Integer, CartItem> cart  = (Map<Integer,CartItem>)session.getAttribute("cart"); %>
		 <% float totalAmount = (float)session.getAttribute("totalPrice"); %>
	<h1> Thank you for your Order</h1>
	<table>
		<tr>
		<th>Item Name </th>
		<th> Price</th>
		<th>Quantity</th>
		</tr>
	<% Set<Entry<Integer, CartItem>> entrySet = cart.entrySet();
	for(Entry<Integer, CartItem> entry : entrySet){
		%>
		<tr>
			<td><%= entry.getValue().getName()%> </td>
			<td><%= entry.getValue().getPrice() %></td>
			<td><%= entry.getValue().getQuantity() %></td>
		</tr>
	<% } %>
		<tr>
			<td id="totle1" colspan="2"><b>Total Price</b></td>
			<td id="totle2"><b><%= totalAmount %></b></td>
		</tr>
		 </table>
		 <form action="CallingCheckOut">
			<input type="button" name="confirm" value="Confirm"  onclick="window.location.href='CallingCheckOut'"/>

		</form>
</body>
</html>
<!-- <h1  style="text-align:center; font-size: 50px; font-weight: bold; animation: highlight 2s infinite alternate; text-shadow: 2px 2px 4px #888;"> Thank you for your Order</h1>
 -->