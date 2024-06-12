<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.List,com.tap.model.Menu,com.tap.model.Restaurant,java.lang.Integer,java.util.Map,com.tap.model.CartItem" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Menu page</title>
<style>
	.restaurant_info{
	padding-left:270px;
	padding-top:0px;
	background-color:white:
	border: 2px solid black;
	}
	.menu_info{
    height:180px;
    padding-left:10px;
	padding-top:20px;
	padding-bottom:20px;
	width:100px;
	margin:20px;
	}
	#menu{
		padding-bottom:40px;
		padding-top:40px;
		background-color:violet;
	}
	#add_menu{
	margin-left:910px;
	margin-top:-25px;
	padding:5px 40px;
	cursor: pointer;
	}
	#quantity{
	margin-left:670px;
	margin-top:-7px;
	}
    input[type="number"]{
    width:70px;
    height:25px;
    cursor: pointer;
    }
    img{
		border-radius: 5px;
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
    margin-left:1050px;
    margin-top:20px;
    }
    #logout{
   	 background-color:rgba(215, 3, 3, 0.778);
     font-size: 18px;
     color: white;
     border: none;
     border-radius: 5px;
     cursor: pointer;
    }
    #log_out{
    	margin-left:1150px;
    	margin-top:-40px;
    }
    #plus{
    	background-color:rgba(9, 246, 13, 0.778);
    	cursor: pointer;
    }
    #minus{
    	background-color:rgba(9, 246, 13, 0.778);
    	cursor: pointer;
    }
    .menu_info{
    width:1100px;
    margin-left:85px;
    background-color:#9dd5ec;
    }
    span{
    	font-size:20px;
    }
    #menu_info_sub{
    	padding-right:300px;
    	padding-left:100px;
    }
    #image_div{
    	margin-left:900px;
    	margin-top:-70px;
    }
</style>
 </head>
<body>
	<div id="home_button"><a href="CallinServlet2"><input type="button" value="Home"></button></a></div>
	<div id="log_out"><a href="CallinLogOutServlet1?msg=logout_success"> <button  id = "logout" class="btn btn-danger"  value="Logout">Logout<img src="imgfolder/logout.png" height="35px" width="35px" alt="Logout"></img></button></a></div>
	<div><h1 style="text-align:center;  text-shadow: 2px 2px 4px #888;">Available menus in the Restaurants</h1></div>
	<% Restaurant restaurant = (Restaurant)session.getAttribute("restaurant"); %>
		<% session.setAttribute("restaurantId", restaurant.getRestaurantId());%>
		<div  class ="restaurant_info">
			<div>
				<h1 style="font-size: 25px; "><%= restaurant.getName() %></h1>
				<span><img src="https://th.bing.com/th/id/OIP.S3qinUY9mFxFcufBsjO1XAHaHa?rs=1&pid=ImgDetMain" height="16px"; width="16px"> <%= restaurant.getRating() %> </span><br>
    			<span style="color:orange;"><%= restaurant.getCuisinType() %></span><br>
    			<span> <%= restaurant.getAddress() %></span><br>
    			<span> <%= restaurant.getEta() %>-<%= restaurant.getEta()+5 %> mins</span><br>
			</div>
		</div>
	<div id="menu_Restaurant">
	<div id="menu">
		<% List<Menu> menulist = (List<Menu>)session.getAttribute("allMenu");
		if(menulist != null){
		 for(Menu menu : menulist){
		%>
			<div class="menu_info">
			<div class="menu_delails">
				<div id="menu_info_sub">
				<span style="font-size:20px;"><%= menu.getName()%></span><br>
				<%= "₹"+menu.getPrice()%><br>
				<%= menu.getDescription()%><br>
				</div>
				<div id="image_div"><img src="<%= menu.getImagepath()%>" class ="menuimg" alter="image not found" height="130px" width="130px"></div>
			</div>
			<form action="CallingAddCardServlet1">
			<input type="hidden" name="menuId" value="<%= menu.getMenuId() %>">
  <div id="quantity">
  <label for="quantity_m">Quantity</label>
  <button id="minus" type="button" onclick="decrementQuantity(<%= menu.getMenuId() %>)">-</button>
  <input type="number" name="quantity_m" id="quantity_m<%= menu.getMenuId() %>" value="0">
  <button id="plus" type="button" onclick="incrementQuantity(<%= menu.getMenuId() %>)">+</button>
</div>
	<div id="Add_buttn">
		<% session.setAttribute("add","add"); %><button  id ="add_menu" >add</button>
		</div><br>
		</form>
		</div>
		<% }} %>		
	</div>
	<div>
	<% Map<Integer, CartItem> cart = (Map<Integer, CartItem>)session.getAttribute("cart");
	Boolean  showConfirmation = (Boolean)request.getAttribute("showConfirmation");
	Integer prev_restaurantIdObj  = (Integer)session.getAttribute("prev_restaurantId");
	int prev_restaurantId = 0;
	if(prev_restaurantIdObj!=null){
		prev_restaurantId = prev_restaurantIdObj.intValue();
	}
	 if(prev_restaurantId != 0 && restaurant.getRestaurantId()!= prev_restaurantId && cart != null){ %>
    <script>
        var resetCart = confirm("Your cart contains items from another restaurant. Would you like to reset your cart for adding items from this restaurant?");
        if (resetCart) {
        	<% if(cart!=null){
        		cart.clear();
        	}%>
            var menuId = document.getElementById('menuId').value; // Get the menuId from the hidden input field
       	    window.location.href = "CallingAddCardServlet1?menuId=" + menuId;
        } else {
            window.location.href = "Menu.jsp";
        }
   
<%}else if(prev_restaurantId != 0){%>
	window.location.href = "CallingAddCardServlet1";
<%}%>
</script>
	<script>
  function incrementQuantity(menuId) {
    var quantityInput = document.getElementById('quantity_m' + menuId);
    var currentValue = parseInt(quantityInput.value);
    quantityInput.value = currentValue + 1;
  }
  function decrementQuantity(menuId) {
    var quantityInput = document.getElementById('quantity_m' + menuId);
    var currentValue = parseInt(quantityInput.value);
    if (currentValue > 0) {
      quantityInput.value = currentValue - 1;
    }
  }
</script>
</body>
</html>
<!-- 
else {
        	<
        	cart.clear();
        	RequestDispatcher rd = request.getRequestDispatcher("CallingAddCardServlet1");
    		rd.forward(request, response);%>
            // Handle "No" option - maybe continue with the current operation
        }
.menu_delails{
	margin-left:100px;
	margin-right:300px;
	margin-bottom:-50px;
	}
	.menuimg{
	padding-bottom:10px;
	padding-left:800px;
	margin-bottom:-80px;
	margin-top:-80px;
	}




<div id="quantity"><label for="quantity">Quantity</label>
				<input type="number"   name="quantity_m" min="1"></input>
			</div> 
			<h1 style="text-align:center; font-size: 50px; font-weight: bold; animation: highlight 2s infinite alternate; text-shadow: 2px 2px 4px #888;">All menus in the below Restaurants</h1>
			-->
