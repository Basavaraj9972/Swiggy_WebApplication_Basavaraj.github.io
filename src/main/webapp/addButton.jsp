<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title>Popup Example</title>
<style>
/* The Modal (background) */
.modal {
	display: none; /* Hidden by default */
	position: fixed; /* Stay in place */
	z-index: 1; /* Sit on top */
	left: 0;
	top: 0;
	width: 100%; /* Full width */
	height: 100%; /* Full height */
	overflow: auto; /* Enable scroll if needed */
	background-color: rgba(0, 0, 0, 0.4); /* Black w/ opacity */
}

.modal-content {
	background-color: #fefefe;
	margin: 15% auto; /* 15% from the top and centered */
	padding: 30px;
	margin-bottom: -20px;
	margin-left: 300px;
	border: 1px solid #888;
	width: 50%; /* Could be more or less, depending on screen size */
	max-height: 40vh; /* Set maximum height for the modal content */
	overflow-y: auto; /* Enable vertical scrolling */
	position: fixed;
	/* Position relative for absolute positioning inside */
}

.connect-text {
	position: fixed;
	top: 77.91px;
	width: 53.09%;
	margin-left: -30px;
	background-color: #fefefe; /* Match the background color */
	padding: 9.9px;
	text-align: center;
	z-index: 2; /* Ensure it's above the scrollable content */
}

.scrollable-content {
	padding-top: 0; /* Adjust according to the height of the fixed header */
	padding-bottom: 0;
	/* Adjust according to the height of the fixed footer */
	width: 50%;
}

.add-to-cart-btn {
	position: relative;
	bottom: 0;
	left: 0;
	width: 50%;
	background-color: #fefefe; /* Match the background color */
	padding: 5px;
	text-align: center;
	z-index: 2; /* Ensure it's above the scrollable content */
}

/* Close Button */
.close {
	color: #aaa;
	float: right;
	font-size: 28px;
	font-weight: bold;
}

.close:hover, .close:focus {
	color: black;
	text-decoration: none;
	cursor: pointer;
}
</style>
</head>
<body>

	<button onclick="openPopup()">Add to Cart items</button>

	<!-- The Modal -->
	<div id="myModal" class="modal">

		<!-- Modal content -->
		<div class="modal-content">

			<div class="connect-text">
				<span class="close" onclick="closePopup()">&times;</span>
				<h2>Add to Cart</h2>
				<p>This is the item you're adding to your cart.</p>
			</div>

			<div class="scrollable-content">
				<label for="item1">Items</label> <input type="button" name="item1"><br><br>
							<label for="item1">Items</label> <input type="button"
							name="item1"><br><br> <label for="item1">Items</label>
										<input type="button" name="item1"><br><br> <label
													for="item1">Items</label> <input type="button" name="item1"><br><br>
																<label for="item1">Items</label> <input type="button"
																name="item1"><br><br> <label
																			for="item1">Items</label> <input type="button"
																			name="item1"><br><br> <label
																						for="item1">Items</label> <input type="button"
																						name="item1"><br><br> <label
																									for="item1">Items</label> <input type="button"
																									name="item1"><br><br> <label
																												for="item1">Items</label> <input
																												type="button" name="item1"><br><br>
																															<label for="item1">Items</label> <input
																															type="button" name="item1"><br><br>
																																		<label for="item1">Items</label> <input
																																		type="button" name="item1"><br><br>
																																					<label for="item1">Items</label> <input
																																					type="button" name="item1"><br><br>
																																								<label for="item1">Items</label>
																																								<input type="button"
																																								name="item1"><br><br>
																																											<label for="item1">Items</label>
																																											<input type="button"
																																											name="item1"><br><br>
																																														<!-- Add your items here -->
																																														<button
																																															class="add-to-cart-btn"
																																															onclick="closePopup()">Add
																																															to Cart</button>
			</div>

			<script>
				// When the user clicks the button, open the modal 
				function openPopup() {
					document.getElementById("myModal").style.display = "block";
				}

				// When the user clicks on <span> (x), close the modal
				function closePopup() {
					document.getElementById("myModal").style.display = "none";
				}

				// When the user clicks anywhere outside of the modal, close it
				window.onclick = function(event) {
					var modal = document.getElementById("myModal");
					if (event.target == modal) {
						modal.style.display = "none";
					}
				}
			</script>
</body>
</html>
