//email validation
$(document).ready(function() {
	//get email from url
	var urlParams = new URLSearchParams(location.search);
	if (urlParams.has('email')) {
		verifyEmail = urlParams.get('email');
		var element = document.getElementById("text");
		$("#email").val(verifyEmail);
		element.innerHTML = verifyEmail;
	}
	$("#email").blur(function() {
		$("#emailMsg").text('');
		var enteredEmail = $("#email").val();
		$.ajax({
			type : "GET",
			url : "/RestApi/emailValidation",
			data : "email=" + enteredEmail,
			success : function(result) {
				if (result == "EXIST") {
					$("#emailMsg").text("email alrady exist");
					$("#email").focus();
				} else {
					$("#emailMsg").text('');
				}
			}
		});

	});
	$("#oldPass").blur(function() {
		var enteredTemp = $("#oldPass").val();
		var getEmail = $("#text").text();
		$.ajax({
			type : "GET",
			url : "/RestApi/emailAndPasswordValidation",
			data : "password=" + enteredTemp + "&email=" + getEmail,
			success : function(result) {
				if (result == "INVALID") {
					$("#msg").text("Wrong Temp Password entred");
					$("#oldPass").focus();
				} else {
					$("#msg").text("");
				}
			}
		});

	});
	$("#config").blur(function() {
		$("#add").show();
		$("#add").show();
		var enteredPassword = $("#newPass").val();
		var entredConfig = $('#config').val();
		if (enteredPassword == entredConfig) {
			$("#configMsg").text("");
			$("#add").show();
		} else {

			$("#configMsg").text("Wrong Temp Password Entred");
			$("#add").hide();
		}
	});

});