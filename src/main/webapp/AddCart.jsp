<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.tap.model.Menu,java.util.ArrayList,java.util.TreeMap,java.util.Set,java.util.Map,java.util.Map.Entry,com.tap.model.CartItem" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>AddCart page</title>

<style>
	#cart_items{
		height:200px;
		width:100%;
		background-color:#9dd5ec;
		padding-bottom:0px;
		padding-top:70px;
		padding-left:0px;
	}
	#img_of_menu{
		margin-top:-945px;
		margin-left:1020px;
		height:255px;
		width:300px;
		
	}
	img{
		border-radius: 20px;
	}
	#info{
		width:300px;
		height:27px;
		font-size:18px;
	}
	#delet{
		margin-left:925px;
		margin-top:-133px;
	}
	#upd{
		margin-right:0px;
		padding:880px;
		margin-top:-994px;
	}
	#dell{
		background-color:darkred;
		color:white;
		font-size:20px;
		cursor: pointer;
		border-radius: 10px;
	}
	#dell:hover{
		background-color:rgb(255, 24, 24);
	}
	
	#updt{
		background-color:rgb(253, 28, 234);
		color:white;
		font-size:20px;
		cursor: pointer;
		border-radius: 10px;
	}
	#updt:hover{
		background-color:#0af521;
	}
	#a{
	margin-left:50px;
	padding-left:50px;
	}
	#add_more{
		background-color:rgb(230, 163, 9);
		color:white;
		font-size:20px;
		margin-left:110px;
		font-size:25px;
		cursor: pointer;
		border-radius: 15px;
	}
	
	#add_more:hover{
		background-color:rgb(248, 237, 14);
	}
	#proced_to_checkout:hover{
		background-color:#0af521;
	}
	#proced_to_checkout{
		background-color:green;
		color:white;
		font-size:20px;
		margin-left:100px;
		font-size:25px;
		cursor: pointer;
		border-radius: 15px;
	}
	#qnty{
		height:20px;
		width:60px;
		font-size:21px;
		cursor: pointer;
	}
	input[type="number"]{
    width:70px;
    height:25px;
    }
	 table {
        border-collapse: collapse;
        width: 50%;
        margin-left:20px ;
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
    #Addcart_det{
		padding-top:30px;    
		padding-left:440px;    
    	height:150px;
    	width:830px;
    	background-color: #f83f07;
    }
    @keyframes highlight {
   		0% { color: #FFD700; } 
    	50% { color: #FF6347; } 
   		100% { color: #FFD700; } 
	}
		#cart_details{
		margin-top:0px;
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
</style>
</head>
<body>	
	<div id="home_button"><a href="CallinServlet2"><input type="button" value="Home"></button></a></div>
	<div id="log_out"><a href="CallinLogOutServlet1?msg=logout_success"> <button  id = "logout" class="btn btn-danger"  value="Logout">Logout<img src="imgfolder/logout.png" height="35px" width="35px" alt="Logout"></img></button></a></div>
	<div id="cart_details"> <h1 style="text-align:center; text-shadow: 2px 2px 4px #888;">Available Cart Items are </h1></div>
	<%  Map<Integer, CartItem> cart  = (Map<Integer,CartItem>)session.getAttribute("cart"); %>
	<% session.setAttribute("cart", cart);
	Menu singleMenu = (Menu)session.getAttribute("singleMenu");
	%>
	<%   float totalPrice =0;
	Set<Entry<Integer, CartItem>> entrys =  cart.entrySet(); 
		for(Entry<Integer, CartItem> entry :entrys){
			totalPrice = totalPrice + entry.getValue().getPrice();
	%>	
	<div id="cart_items">	
	<form action="UpdateServlet1">
	<input type="hidden" name="menuId_u" value="<%= entry.getValue().getItemId()%>"></input>
	<table>
	<tr>
		<th>Menu name</th>
		<th>Price</th>
		<th>Quantity</th>
	</tr>
	<tr>
	<td><%= entry.getValue().getName() %></td>
	<td>&#8377;<%= entry.getValue().getPrice() %></td>
	<td>
	<button id="minus" type="button" onclick="decrementQuantity(<%= entry.getValue().getItemId() %>)">-</button>
  	<input type="number" name="quantity_cart" id="qnty<%= entry.getValue().getItemId() %>" min="1" value="<%= entry.getValue().getQuantity() %>">
  	<button id="plus" type="button" onclick="incrementQuantity(<%= entry.getValue().getItemId() %>)">+</button>
	</td>
	</tr>
	</table>
	<pre>  	    <div id="info"> </input> <% session.setAttribute("update", "update"); %>   <div id="upd">    <input type="submit" id="updt" name="update_btn" value="update"></input> </div><div id="img_of_menu"><img src="<%= entry.getValue().getImgPath() %>" height="150px" width="200px"></img></div></pre>	
	<br></form>
	<form action="CallingAddCardServlet1">
	<input type="hidden" name="menuId_d" value="<%= entry.getValue().getItemId()%>"></input>
	<pre>  <% session.setAttribute("delete", "delete");%> <div id="delet"><input type="submit" id="dell" value="delete"></input></div> </pre>	
	<br></form>
	<%} %>
	<% session.setAttribute("totalPrice", totalPrice); %>
	<div id="Addcart_det">
	<a href="Menu.jsp?"> <input type="button" id="add_more" value="Add More Iteams"></input></a><br><br>
	<a href="CheckoutValidation.jsp"><input type="button" id="proced_to_checkout" value="Proced to checkout"></input></a>
</div>
  
<script>
  function incrementQuantity(menuId) {
    var quantityInput = document.getElementById('qnty' + menuId);
    var currentValue = parseInt(quantityInput.value);
    quantityInput.value = currentValue + 1;
  }

  function decrementQuantity(menuId) {
    var quantityInput = document.getElementById('qnty' + menuId);
    var currentValue = parseInt(quantityInput.value);
    if (currentValue > 1) {
      quantityInput.value = currentValue - 1;
    }
  }
</script>
	
</body>
</html>


<!-- 
<h1 style="text-align:center; font-size: 40px; font-weight: bold; animation: highlight 2s infinite alternate; text-shadow: 2px 2px 4px #888;">Available Cart Items are </h1>
	< TreeMap<Menu,Integer> cartItems =  (TreeMap<Menu,Integer>)session.getAttribute("cartItems");
	 	float price =0.0f;
	 	int quantity = 0;
	 	Integer quantityObj = (Integer)session.getAttribute("quantity");
		if(quantityObj!=null){
			quantity =  quantityObj.intValue();
		}
		Float priceObj = (Float)session.getAttribute("price");
		if(priceObj!=null){
			price = priceObj.floatValue();
		}
	 	  Set<Entry<Menu,Integer>> entrys =  cartItems.entrySet();
	 	for(Entry<Menu,Integer> e : entrys){
	 		session.setAttribute("quantity1", e.getValue());
	%>
	<form action="UpdateServlet1">
	< session.setAttribute("menuId", e.getKey().getMenuId()); %>
	<pre><= e.getKey().getName() %> &#8377;<= e.getKey().getPrice()%> <label for="quantity" >Quantity</label> <input type="number" name="quantity" ></input> <input type="submit" value="update"></input><input type="button" value="delete"></input></pre>
	<br></form>
	<}
 %>
	<a href="Menu.jsp?"><input type="button" value="Add More Iteams"></input></a><br><br>
	<button onclick="openPopup()">Add to Cart items</button>
	<input type="button" value="Proced to checkout"></input> -->