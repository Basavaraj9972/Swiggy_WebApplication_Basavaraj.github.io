<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
<script src="UpdateRestaurant.js"></script>
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
	<form onsubmit="return validate()" action="CallingUpdate_Restaurant" >
    <table>
        <tr>
            <td><label for="restaurantId">RestaurantId*</label></td>
            <td><input type="text" id="restaurantId" name="restaurantId"></td>
        </tr>
        <tr>
            <td colspan="2"><span id="msg1" style="color:red"></span></td>
         </tr>
        <tr>
            <td><label for="name">Name*</label></td>
            <td><input type="text" id="name" name="name"></td>
        </tr>
        <tr>
            <td colspan="2"><span id="msg2" style="color:red"></span></td>
         </tr>
        <tr>
            <td><label for="imagePath">Image Path*</label></td>
            <td><input type="text" id="imagePath" name="imagePath"></td>
        </tr>
        <tr>
            <td colspan="2"><span id="msg3" style="color:red"></span></td>
         </tr>
        <tr>
            <td><label for="rating">Rating*</label></td>
            <td><input type="number" id="rating" name="rating" step="0.01"></td>
        </tr>
        <tr>
            <td colspan="2"><span id="msg4" style="color:red"></span></td>
         </tr>
        <tr>
            <td><label for="eta">ETA*</label></td>
            <td><input type="number" id="eta" name="eta"></td>
        </tr>
        <tr>
            <td colspan="2"><span id="msg5" style="color:red"></span></td>
         </tr>
        <tr>
            <td><label for="cuisinType">Cuisine Type*</label></td>
            <td><input type="text" id="cuisinType" name="cuisinType"></td>
        </tr>
        <tr>
            <td colspan="2"><span id="msg6" style="color:red"></span></td>
         </tr>
        <tr>
            <td><label for="address">Address*</label></td>
            <td><input type="text" id="address" name="address"></td>
        </tr>
        <tr>
            <td colspan="2"><span id="msg7" style="color:red"></span></td>
         </tr>
        <tr>
            <td><label for="isActive">Is Active*</label></td>
            <td>
                <select id="isActive" name="isActive">
                    <option value="true">Yes</option>
                    <option value="false">No</option>
                </select>
            </td>
        </tr>
        <tr>
            <td colspan="2"><span id="msg8" style="color:red"></span></td>
         </tr>
        <tr>
            <td><label for="restaurantOwnId">Restaurant Owner ID*</label></td>
            <td><input type="number" id="restaurantOwnId" name="restaurantOwnId"></td>
        </tr>
        <tr>
            <td colspan="2"><span id="msg9" style="color:red"></span></td>
         </tr>
    </table>
    <input type="submit" value="Submit">
</form>
</body>
</html>