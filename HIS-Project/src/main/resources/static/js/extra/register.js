//email validation
/*$(document).ready(function() {
 $("#email").blur(function() {
 $("#emailMsg").text('');
 var enteredEmail = $("#email").val();
 $.ajax({
 type : "GET",
 url : "/Admin/emailValidation",
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

 }) 
 });*/

//email validation
$(document).ready(function() {
	function checkEmailExist(email) {
		$.ajax({
			type : "GET",
			url : "/RestApi/emailValidation",
			data : "email=" + email,
			success : function(result) {
				if (result == "EXIST") {
					$("#emailMsg").text("email alrady exist");
					$("#email").focus();
				} else {

					$("#emailMsg").text('');
				}
			}
		});
	}
	$("#email").blur(function() {
		var email = $("#email").val();
		var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
		if (mailformat.test(email)) {
			$("#emailMsg").text('');
			checkEmailExist(email);
		} else {
			$("#email").focus();
			$("#emailMsg").text("Invalid email format.. !!");
		}
	})
	$('#zzn').keypress(
			function(e) {
				if (e.which != 8 && e.which != 0
						&& (e.which < 48 || e.which > 57)) {
					return false;
				} else if (e.which != 8 && e.which != 0
						&& (e.which <= 57 && e.which >= 48)) {
					var zzn1 = $('#zzn').val();
					if (event.keyCode != '8') {
						console.log("jtkakasm");
						if (zzn1.length == 6) {
							$('#zzn').val(zzn1 + '-');
						} else if (zzn1.length == 3) {
							$('#zzn').val(zzn1 + '-');
						}
					}
				}
			});
	$("#zzn").blur(function() {
		var zzn=$("#zzn").val();
		$.ajax({
			type : "GET",
			url : "/RestApi/SSNVerify",
			data : "ssn=" + zzn,
			success : function(result) {
				if(result["error"]==true) {
					$("#ssnMsg").text("SSN not found.. !!");
					$("#ssnMsg").focus();
				} else {

					$("#ssnMsg").text('');
				}
			}
		});
		
	});

});

