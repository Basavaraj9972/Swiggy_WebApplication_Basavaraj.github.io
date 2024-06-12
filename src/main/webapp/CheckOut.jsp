<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.Map,com.tap.model.CartItem" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>CheckOut page</title>
<style>
#checkout_container {
		margin: 100px auto;
		padding: 30px;
		width: 500px;
		background-color: #f9f9f9;
		border-radius: 10px;
		box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.2);
	}
	#checkout{
		width: 100%;
		height:600px;
		padding: 30px;
		background-color: hsl(182, 78%, 66%);
		border-radius: 10px;
		box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.2);
	}
	input, select, option, button {
		padding: 10px;
		font-size: 20px;
		width: 100%;
		margin-bottom: 20px;
		border: 1px solid #ccc;
		border-radius: 5px;
	}
	lable{
		font-size:25px;
	}
	button {
		background-color: #4CAF50; /* Green */
		color: white;
		border: none;
		cursor: pointer;
	}
	button:hover {
		background-color:#0af521;
	}
	#address{
	font-size: 25px;
	}
	@keyframes highlight {
   			 0% { color: #FFD700; } 
   			 50% { color: #FF6347; } 
   			 100% { color: #FFD700; } 
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
      margin-left:1000px;
      margin-right:170px;
    }
    #logout{
   	background-color:rgba(215, 3, 3, 0.778);
    }
    #home_logout{
    	
    }
    #log_out{
    	margin-left:1130px;
    	margin-right:50px;
    	margin-top:-69px;
    	height:0px;
    	padding:20x;
    }
</style>
</head>
<body>
<div id="home_logout">
<div id="home_button"><a href="CallinServlet2"><input type="button" style="height:50px; width:120px" value="Home"></button></a></div>
<div id="log_out"><a href="CallinLogOutServlet1?msg=logout_success"> <button style="height:50px; width:120px"  id = "logout" class="btn btn-danger"  value="Logout">Logout<img src="imgfolder/logout.png" height="35px" width="35px" alt="Logout"></img></button></a>
</div>
<div>
<div id="checkout">
<div id="checkout_container">
	<div><h1 style="text-align:center; font-size: 27px; font-weight: bold; animation: highlight3 2s infinite alternate; text-shadow: 2px 2px 4px #888;">Enter the Address and Select the Payment mode option and click on confirm </h1></div>
	<form action="CallingOrderDetails">
		<table>
			<tr> 
				<td><lable for="Address">Address</lable></td>
				<td><textarea rows="3" cols="20" name="address" id="address"></textarea></td>	
			</tr>
			<tr>
				<td><lable for="PaymentMode">PaymentMode</lable></td>
				<td>
					<select name="PaymentMode" id="PaymentMode">
						<option value="Cash on Delivery">Cash on Delivery</option>
						<option value="UPI">UPI</option>
						<option value="Debit Card">Debit Card</option>
						<option value="Credit Card">Creadit Card</option>
					</select>
				</td>
			</tr>
			<tr>
				<td><button name="confirm">Confirm</button></td>
			</tr>
		</table>
	</form>
</div>
</div>
</body>
</html>