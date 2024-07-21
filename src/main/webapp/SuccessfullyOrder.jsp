<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Delivered page </title>
</head> 
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
<style>
video{
	
}
#first{
	padding:20px;
}
#second{
	padding:20px;
}
@keyframes highlight3 {
    		0% { color: #FF4500; } 
    		50% { color: rgb(17, 253, 5); } 
    		100% { color: rgb(5, 253, 253); } 
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
    h1{
        text-align: center;
        padding-top:30px;
        margin-left:200px;
        color:rgb(7, 3, 243);
    }
    #home_button{
    margin-left:0px;
    }
    div{
    float:right;
    display:flex;
    margin-left:10px;
    }
</style>
<body>
<div>
<div id="home_button"><a href="CallinServlet2"><input type="button" value="Home"></button></a></div>
<div><a href="CallinLogOutServlet1?msg=logout_success"> <button  id = "logout" class="btn btn-danger"  value="Logout">Logout<img src="imgfolder/logout.png" height="35px" width="35px" alt="Logout"></img></button></a></div>
</div>	
<div>
	<h1> CHILL RELAX, FOOD IS ON YOUR WAY </h1>
</div>
	<video width="90%" height="500px" controls autoplay>
  <source src="imgfolder/Food_Delivery.mp4" type="video/mp4">
  Your browser does not support the video tag.
</video>
</body>
</html>
<!--
</div>
<div id="first">
	<img src="imgfolder/swiggy_img1.png" alter="Image not found" height="600px" width="100%" ></img>
</div>
<div id="second">
	<img src="imgfolder/swiggyImg2.png" alter="Image not found" height="600px" width="100%"></img>
</div>
  -->