<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.List,com.tap.model.Restaurant,javax.servlet.RequestDispatcher,javax.servlet.http.HttpSession" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Restaurant page</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
<style>
	#wel_Section #wel_Tap{
		height:200px;
		width:100%;
		
	}
	#siu{
	margin-top:36px;
	text-align:center;
	font-size:25px;
	}
	a[href="SignIn.jsp"],a[href="SignUp.jsp"]{
	margin-left:20px;
	
	}
	.restaurant{
	margin-left:30px;
	margin-right:30px;
	padding:5px; 	
	float :left;
	}
	img{
	border-radius:15px;
	}
	#restaurant_name{
	font-size:20px;
	}
	restaurant:hover{
	transform :scale(0.95);
	}
	button{
	 font-size:35px;
	 padding:50px;
     margin-left:30px;
	}
	#wel_Tap{
		text-align:center;
		padding-left:400px;
	}
	.all_restaurants{
		background-color: rgb(215, 238, 186);
	}
	@keyframes highlight {
   		0% { color: red; } /* Start with gold color */
    	50% { color: blueviolet; } /* Transition to a coral color halfway */
   		100% { color: yellow; } /* Return to gold color */
	}
</style>
</head>
<body>

<div id="wel_Section">
	<div id="wel_Sec">
	<span id="wel_Tap" style="text-align:center; font-size: 50px; font-weight: bold; animation: highlight 2s infinite alternate; text-shadow: 2px 2px 4px #888;"> Welcome to TapFoods</span>
	</div>
	<div id="siu">
		<span ><a href="SignIn.jsp"> <button type="button" class="btn btn-success">Login</button></a></span> <span><a  href="SignUp.jsp"><button type="button" class="btn btn-success">Register</button></a></span>
	</div>
</div>
<div class = "all_restaurants">
<% 
	List<Restaurant> restaurantlist = (List<Restaurant>)request.getAttribute("allRestaurant"); 
		
		for(Restaurant restaurant : restaurantlist){
			%>
		<div class = "restaurant">
		<img src = "<%= restaurant.getImagePath() %>" alter = "image not found" height="220px" width="350px" > <br>
		<span id="restaurant_name"><%= restaurant.getName() %></span><br>
		<span><img src="https://th.bing.com/th/id/OIP.S3qinUY9mFxFcufBsjO1XAHaHa?rs=1&pid=ImgDetMain" height="16px"; width="16px"> <%= restaurant.getRating() %> .</span>
		<!-- < int max_time = restaurant.getEta();
			max_time = max_time + 5; 
		%> -->
		<span><%= restaurant.getEta() +"-"+restaurant.getEta()+5 %></span><br>
		<span><%= restaurant.getCuisinType() %></span><br>
		<span><%= restaurant.getAddress() %></span><br>
		</div>
		<% 
		}
		%>
</div>
		<% String msg = request.getParameter("msg"); 
			if(msg!=null && msg.equals("logout_success")){
				%>
				<script>alert("Logout Successfully")</script>
			<% 
			}
		%>
	
</body>
</html>


<!-- 
<a href="Menu.jsp?id="<= restaurant.getRestaurantId()%>">
<a href="Menu.jsp?id=rid">
//< RequestDispatcher rd = request.getRequestDispatcher("Menu.jsp");
	 	   rd.forward(request,response);
		 %> -->

<!-- <div class="imgicon1">
	<img src="https://media-assets.swiggy.com/swiggy/image/upload/fl_lossy,f_auto,q_auto,w_660/2b4f62d606d1b2bfba9ba9e5386fabb7"></img>
  new pizza
</div>
<div class="imgicon1">
	<img src="https://media-assets.swiggy.com/swiggy/image/upload/fl_lossy,f_auto,q_auto,w_660/64fd45fd9f44c1737bc446e470bed666"></img>
	
</div>
<div class="imgicon1">
	<img src="https://media-assets.swiggy.com/swiggy/image/upload/fl_lossy,f_auto,q_auto,w_660/f62564e14944753903849c4ef673af4d"></img>
	
</div>
<div class="imgicon2">
<img src="https://media-assets.swiggy.com/swiggy/image/upload/fl_lossy,f_auto,q_auto,w_660/f01666ac73626461d7455d9c24005cd4"></img>
</div>
<div class="imgicon2">
<img src="https://media-assets.swiggy.com/swiggy/image/upload/fl_lossy,f_auto,q_auto,w_660/d0450ce1a6ba19ea60cd724471ed54a8"></img>
</div>
<div class="imgicon2">
	<img src="https://media-assets.swiggy.com/swiggy/image/upload/fl_lossy,f_auto,q_auto,w_660/85ccae4e3576f9330af102c46ca85395"></img>
</div> 



h4{
	marging:-1px;
	padding:-10px;	
	}
-->