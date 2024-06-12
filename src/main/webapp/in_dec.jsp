<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
<style>
  .quantity-selector {
    display: flex;
    align-items: center;
  }

  .quantity-input {
    width: 60px; /* Adjust width to accommodate buttons */
   height: 30px;
    text-align: center;
  }

  .quantity-button {
    cursor: pointer;
    padding: 0 5px;
    height: 21px; /* Align buttons with input field */
   width:20px;
    border: 1px solid rgb(17, 18, 17); /* Remove default button styling */
    background-color: #1cd56f; /* Add some background color for better visibility */
    display: flex;
    justify-content: center;
    align-items: center;
  }

  .quantity-button:hover {
    background-color: #1ee6d9; /* Change background color on hover */
    
  }
</style>
</head>
<body>

<div class="quantity-selector">
  <!-- Minus Button -->
  <button type="button" class="quantity-button" onclick="decreaseQuantity()">-</button>
  <!-- Quantity Input Field -->
  <input type="number" class="quantity-input" id="quantity" value="1" min="1">
  <!-- Plus Button -->
  <button type="button" class="quantity-button" onclick="increaseQuantity()">+</button>
</div>

<script>
  function increaseQuantity() {
    var quantityInput = document.getElementById('quantity');
    var currentValue = parseInt(quantityInput.value);
    quantityInput.value = currentValue + 1;
  }

  function decreaseQuantity() {
    var quantityInput = document.getElementById('quantity');
    var currentValue = parseInt(quantityInput.value);
    if (currentValue > 1) {
      quantityInput.value = currentValue - 1;
    }
  }
</script>

</body>
</html>