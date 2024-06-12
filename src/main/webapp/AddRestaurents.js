function validate1() {
    var un = document.getElementById("name").value.trim();
    var imag_p = document.getElementById("imagePath").value.trim();
    var ra_p = document.getElementById("rating").value.trim();
    var eta_p = document.getElementById("eta").value.trim();
    var cu_p = document.getElementById("cuisinType").value.trim();
    var address_p = document.getElementById("address").value.trim();
    var is_p = document.getElementById("isActive").value.trim();
    var rest_id = document.getElementById("restaurantOwnId").value.trim();

    document.getElementById("msg1").innerHTML = "";
    document.getElementById("msg2").innerHTML = "";
    document.getElementById("msg3").innerHTML = "";
    document.getElementById("msg4").innerHTML = "";
    document.getElementById("msg5").innerHTML = "";
    document.getElementById("msg6").innerHTML = "";
    document.getElementById("msg7").innerHTML = "";
    document.getElementById("msg8").innerHTML = "";
    
    var isValid = true;

    
	 if (username === "") {
        document.getElementById("msg3").innerHTML = "Username can't be empty";
        isValid = false;
    }
	 if (imag_p === "") {
        document.getElementById("msg2").innerHTML = "Image Can't can't be empty";
        isValid = false;
    }
	 if (ra_p === "") {
        document.getElementById("msg3").innerHTML = "rating  can't be empty";
        isValid = false;
    }
	 if (eta_p === "") {
        document.getElementById("msg4").innerHTML = "eta can't be empty";
        isValid = false;
    }
	 if (cu_p === "") {
        document.getElementById("msg5").innerHTML = "Cusin type can't be empty";
        isValid = false;
    }
	 if (address_p === "") {
        document.getElementById("msg6").innerHTML = "address can't be empty";
        isValid = false;
    }
	 if (is_p === "") {
        document.getElementById("msg7").innerHTML = "isAvailable can't be empty";
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
