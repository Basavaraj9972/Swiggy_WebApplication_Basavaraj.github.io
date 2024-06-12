function validate() {
    var menu_Id = document.getElementById("menuId").value.trim();
    var name_p = document.getElementById("name").value.trim();
    var price_p = document.getElementById("price").value.trim();
    var description_p = document.getElementById("description").value.trim();
    var imag_p = document.getElementById("imagePath").value.trim();
    var is_p = document.getElementById("isActive").value.trim();
    var ra_p = document.getElementById("rating").value.trim();
    var rest_id = document.getElementById("restaurantId").value.trim();
    
    document.getElementById("msg1").innerHTML = "";
    document.getElementById("msg2").innerHTML = "";
    document.getElementById("msg3").innerHTML = "";
    document.getElementById("msg4").innerHTML = "";
    document.getElementById("msg5").innerHTML = "";
    document.getElementById("msg6").innerHTML = "";
    document.getElementById("msg7").innerHTML = "";
    document.getElementById("msg8").innerHTML = "";
    
    var isValid = true;

	 if (menu_Id === "") {
        document.getElementById("msg1").innerHTML = "Username can't be empty";
        isValid = false;
    }
	 if (name_p === "") {
        document.getElementById("msg2").innerHTML = "Username can't be empty";
        isValid = false;
    }
	 if (price_p === "") {
        document.getElementById("msg3").innerHTML = "Username can't be empty";
        isValid = false;
    }
	 if (description_p === "") {
        document.getElementById("msg4").innerHTML = "Username can't be empty";
        isValid = false;
    }
	 if (imag_p === "") {
        document.getElementById("msg5").innerHTML = "Image Can't can't be empty";
        isValid = false;
    }
	 if (is_p === "") {
        document.getElementById("msg6").innerHTML = "isAvailable can't be empty";
        isValid = false;
    }
	 if (ra_p === "") {
        document.getElementById("msg7").innerHTML = "rating  can't be empty";
        isValid = false;
    }
	 
	 if (rest_id === "") {
        document.getElementById("msg8").innerHTML = "restaurant can't be empty";
        isValid = false;
    }
   
    // Clear all error messages if the form is valid
    if (isValid) {
       	document.getElementById("msg1").innerHTML = "";
    	document.getElementById("msg2").innerHTML = "";
    	document.getElementById("msg3").innerHTML = "";
    	document.getElementById("msg4").innerHTML = "";
    	document.getElementById("msg5").innerHTML = "";
    	document.getElementById("msg6").innerHTML = "";
    	document.getElementById("msg7").innerHTML = "";
    	document.getElementById("msg8").innerHTML = "";
    }

    return isValid;
}
