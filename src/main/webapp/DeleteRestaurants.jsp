<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
<script src="DeleteRestaurents.js"></script>
<style>
table {
        border-collapse: collapse;
        width: 600px;
        margin-left:300px;
    }
    th, td {
        border: 1px solid #dddddd;
        text-align: left;
        padding: 8px;
    }
    th {
        background-color: #f2f2f2;
    }
    input{
    	height:20px;
    	width:200px;
    	font-size:20px;
    }
    input[type="submit"]{
    	height:40px;
    	width:100px;
    	margin-left:300px;
    }
    </style>
</head>
<body>
	<form onsubmit="return validate()" action="CallingDelete_Restaurant" >
    <table>
        <tr>
            <td><label for="restaurantId">RestaurantId*</label></td>
            <td><input type="text" id="restaurantId" name="restaurantId"></td>
        </tr>
        <tr>
            <td colspan="2"><span id="msg1" style="color:red"></span></td>
         </tr>
         </table>
   	 <input type="submit" value="Submit">
</form>
</body>
</html>