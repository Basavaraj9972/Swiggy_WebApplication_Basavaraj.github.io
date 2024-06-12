<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.tap.model.Restaurant,java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
<style>
    #wel_Section{
        height:200px;
        width:100%; 
    }
    #unp{
        padding-top:50px;
        padding-left:470px;
        font-size:25px;
    }
    .restaurant{
        margin-left:18px;
        margin-right:0px;
        padding:10px;    
        float:left;
        background-color: white;
        box-sizing: border-box;
        
    }
    .restaurant1{
    	margin-left:18px;
        margin-right:0px;
        padding:10px;    
        background-color: white;
        border-radius: 20px;
        box-sizing: border-box;
    }
    img{
        border-radius:15px;
    }
    #restaurant_name{
        font-size:20px;
    }
 	.restaurant:hover{
        transform :scale(0.95);
    }
    .restaurant1:hover{
    	transform :scale(0.95);
    }
    .first_line{
        display :flex;
        margin-left:450px;
        font-size:50px;
    }
    #wel_Tap{
        margin-left:450px;
        font-size:50px;
        animation-name:ani;
      	animation-duration:20s;
       	position:relative;
    }
    button{
        font-size:25px;
         margin-left:30px;
    }
    #name{
    font-size:25px;
    margin-left:300px;
    padding-left:20px;
    text-align:center;
    }
    #logout{
    	margin-left:200px;
    }
  	#prevBtn,#nextBtn
    {
    	border-radius: 30%;
    	
    }
     @keyframes ani {
            10%{background-color: red; left:50px;top:90px}
            20%{background-color: blueviolet;left:80px;right:20px}
            30%{background-color: green;bottom:40px;}
            100%{background-color: yellow;left:0}
            /* 30%{background-color:blue;}
            20%{background-color:chartreuse;} */
        }
        @keyframes highlight1 {
    		0% { color: #FF4500; } 
    		50% { color: #4169E1; } 
    		100% { color: #FF4500; } 
		}
		@keyframes highlight3 {
    		0% { color: #FF4500; } 
    		50% { color: rgb(253, 5, 212); } 
    		100% { color: rgb(5, 253, 253); } 
		}
        @keyframes highlight {
   			 0% { color: #FFD700; } 
    		50% { color: #FF6347; } 
   			 100% { color: #FFD700; } 
		}
     #home_Buttons{
     	background-color:rgb(5, 253, 92);
     	height:180px;
     }
    </style>
</head>
<body>
<div>
<div id="home_Buttons">
  <span id="wel_Tap" style="text-align:center; font-size: 50px; font-weight: bold; animation: highlight 2s infinite alternate; text-shadow: 2px 2px 4px #888;"> Welcome to TapFoods</span>
         <a href="CallinLogOutServlet1?msg=logout_success"> <button  id = "logout" class="btn btn-danger"  value="Logout">Logout<img src="imgfolder/logout.png" height="35px" width="35px" alt="Logout"></img></button></a><br><br>
    <span id ="name" style="text-align:center; font-size: 25px; font-weight: bold; animation: highlight1 2s infinite alternate; text-shadow: 2px 2px 4px #888;"> <%= "Hello "+" "+session.getAttribute("userName")+" Welcome to TapFoods " %></span>
          <a href="ViewCart.jsp"> <button type="button" class="btn btn-info">View Cart</button></a>
          <a href="CallingOrderHistory"><button type="button" class="btn btn-info">View Order History</button></a>
   </div>
    <br>        
    <div><h1 style="text-align:center; font-size: 30px; font-weight: bold; animation: highlight3 2s infinite alternate; text-shadow: 2px 2px 4px #888;">Top Restaurants in Bengaluru</h1></div>
  <button id="prevBtn">&#9664;</button>
  <button id="nextBtn">&#9654;</button>
  <div id="restaurantContainer" style="overflow-x: auto; white-space: nowrap;">
<% 
    List<Restaurant> all_Top_Restaurant = (List<Restaurant>)request.getAttribute("all_Top_Restaurant"); 
    for(Restaurant restaurant : all_Top_Restaurant){
%>
<div class = "restaurant1" style="display: inline-block">
    <a href="MenuServlet?restaurantId=<%= restaurant.getRestaurantId() %>"><img src = "<%= restaurant.getImagePath() %>" alter = "image not found" height="190px" width="270px" ></a> <br>
    <span id="restaurant_name"><%= restaurant.getName() %></span><br>
    <span><img src="https://th.bing.com/th/id/OIP.S3qinUY9mFxFcufBsjO1XAHaHa?rs=1&pid=ImgDetMain" height="16px"; width="16px"> <%= restaurant.getRating() %> .</span>
    <span><%= restaurant.getEta() %>-<%= restaurant.getEta()+5 %></span><br>
    <span><%= restaurant.getCuisinType() %></span><br>
    <span><%= restaurant.getAddress() %></span><br>
</div>
<% }%>
</div><br><br>
<div><h1 style="text-align:center; font-size: 30px; font-weight: bold; animation: highlight3 2s infinite alternate; text-shadow: 2px 2px 4px #888;">All Restaurants in Bengaluru</h1></div>
 <div class = "restaurant" style="display: inline-block">
<% 
    List<Restaurant> restaurantlist = (List<Restaurant>)request.getAttribute("allRestaurant"); 
    for(Restaurant restaurant : restaurantlist){
%>
<div class = "restaurant" style="display: inline-block">
    <a href="MenuServlet?restaurantId=<%= restaurant.getRestaurantId() %>"><img src = "<%= restaurant.getImagePath() %>" alter = "image not found" height="190px" width="270px" ></a> <br>
    <span id="restaurant_name"><%= restaurant.getName() %></span><br>
    <span><img src="https://th.bing.com/th/id/OIP.S3qinUY9mFxFcufBsjO1XAHaHa?rs=1&pid=ImgDetMain" height="16px"; width="16px"> <%= restaurant.getRating() %> .</span>
    <% int max_time = restaurant.getEta();
    max_time = max_time + 5; 
    %>
    <span><%= restaurant.getEta() +"-"+max_time %></span><br>
    <span><%= restaurant.getCuisinType() %></span><br>
    <span><%= restaurant.getAddress() %></span><br>
</div>
<% 
    }
%>
</div>

<% String login_msg = (String)session.getAttribute("login_success");
	if(login_msg != null && login_msg.equals("login_success")){ %>
		<script> alert("Login Success")</script>
		<% login_msg = null; %>
<%} session.removeAttribute("login_success");%>

<% String alertMessage_cart = (String)session.getAttribute("alert"); 
   if(alertMessage_cart!=null && alertMessage_cart.equals("Cart is Empty")){ %>
   <script> alert("Cart is Empty")</script>
 <%} session.removeAttribute("alert");%>
 
 <% String alertMessage_history = (String)session.getAttribute("alert_history"); 
   if(alertMessage_history!=null && alertMessage_history.equals("no Order History Available")){ %>
   <script> alert("Order History is not Available")</script>
 <%} session.removeAttribute("alert_history");%>
 
 
    <script>
        const restaurantContainer = document.getElementById('restaurantContainer');
        const prevBtn = document.getElementById('prevBtn');
        const nextBtn = document.getElementById('nextBtn');

        prevBtn.addEventListener('click', function() {
            restaurantContainer.scrollLeft -= 100; 
        });

        nextBtn.addEventListener('click', function() {
            restaurantContainer.scrollLeft += 100; 
        });
    </script>
 
 </div>
</body>
</html>

                <!-- 
                <button type="button" class="btn btn-primary">Primary Button</button>
                <button type="button" class="btn btn-danger">Danger Button</button>
                <button type="button" class="btn btn-success">Success Button</button>
                <button type="button" class="btn btn-secondary">Secondary Button</button>
                <button type="button" class="btn btn-warning">Warning Button</button>
                <button type="button" class="btn btn-light">Light Button</button>
                <button type="button" class="btn btn-dark">Dark Button</button>
                <button type="button" class="btn btn-link">Link Button</button> -->