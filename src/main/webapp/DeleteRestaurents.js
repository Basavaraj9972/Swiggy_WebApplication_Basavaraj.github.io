function validate() {
	var restaurant_Id = document.getElementById("restaurantId").value.trim();
	 document.getElementById("msg1").innerHTML = "";
	  var isValid = true;


    if (restaurant_Id === "") {
        document.getElementById("msg1").innerHTML = "restaurant_Id can't be empty";
        isValid = false;
    }
    if (isValid) {
        
        document.getElementById("msg1").innerHTML = "";
    }

    return isValid;
}