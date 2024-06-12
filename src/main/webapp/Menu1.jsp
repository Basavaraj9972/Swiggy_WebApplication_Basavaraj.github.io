<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.List,com.tap.model.Menu,com.tap.model.Restaurant,java.lang.Integer" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
</head>
<style>
	.restaurant_info{
	padding-left:270px;
	padding-top:80px;
	}
	.menu_info{
    height:180px;
    padding-left:200px;
	padding-top:20px;
	padding-bottom:20px;
	width:800px;
	margin:20px;
	}
	#menu{
		padding-bottom:40px;
		padding-top:40px;
		background-color:violet;
	}
	.menu_delails{
	margin-left:50px;
	margin-right:250px;
	}
	.menuimg{
	padding-left:600px;
	margin-top:-60px;
	margin-bottom:20px;
	border-radius:15px;
	}
	#add_menu{
	margin-left:660px;
	margin-top:-26px;
	padding:5px 40px;
	}
	#quantity{
	margin-left:400px;
	margin-top:-22px;
	}
        .close {
          color: #aaa;
          float: right;
          font-size: 28px;
          font-weight: bold;
        }
        .close:hover,
        .close:focus {
          color: black;
          text-decoration: none;
          cursor: pointer;
        }
        input[type="number"]{
        width:70px;
        height:22px;
        } 
</style>
<body>
	<div id="menu">
		<% Restaurant restaurant = (Restaurant)session.getAttribute("restaurant"); %>
		<% session.setAttribute("restaurantId", restaurant.getRestaurantId());%>
		<div class ="restaurant_info">
			<span style="font-size:20px;"><b><%= restaurant.getName() %></b></span><br>
			<%= restaurant.getCuisinType() %><br>
			<%= restaurant.getAddress() %><br><br><br>
		</div>
		<% List<Menu> menulist = (List<Menu>)session.getAttribute("allMenu");
		if(menulist!=null){
		 for(Menu menu : menulist){
		%>
			<div class="menu_info">
			<hr>
			<div class="menu_delails">
				<span style="font-size:20px;"><%= menu.getName()%></span><br>
				<%= "₹"+menu.getPrice()%><br>
				<%= menu.getDescription()%><br>
				<img src="<%= menu.getImagepath()%>" class ="menuimg" alter="image not found" height="130px" width="130px">
			</div>
			<form action="CallingAddCardServlet1">
			<input type="hidden" name="menuId" value="<%= menu.getMenuId() %>">
			<div id="quantity"><label for="quantity">Quantity</label>
				<input type="number"   name="quantity_m"></input>
			</div>
			<div id="Add_buttn">
			<input type="hidden" name="menuImag" value="<%= menu.getImagepath() %>">
				<% session.setAttribute("add","add"); %><button  id ="add_menu" >add</button>
			</div><br>
			</form>
			</div>
			<% }} %>
	</div>
</script>
</body>
</html>
