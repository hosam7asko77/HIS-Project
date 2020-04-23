//email validation
$(document).ready(function(){
	
	$("#email").blur(function(){
		$("#emailMsg").text('');
		var enteredEmail=$("#email").val();
		$.ajax({
		    type : "GET",
		    url : "/Admin/emailValidation",
		    data : "email="+enteredEmail,
		    success: function(result){
		    	if(result == "EXIST"){
					$("#emailMsg").text("email alrady exist");
					$("#email").focus();
			    }else{
			    	$("#emailMsg").text('');
				}
		    }
		});

		})

});
//get email id for password update
$(document).ready(function(){
	var urlParams=new URLSearchParams(location.search);
	if (urlParams.has('email')) {
		verifyEmail=urlParams.get('email');
		var element = document.getElementById("text");
		$("#email").val(verifyEmail);
		element.innerHTML = verifyEmail;


	}
});
//validation temp password
$(document).ready(function(){
	$("#oldPass").blur(function(){
		var enteredTemp=$("#oldPass").val();
		var getEmail=$("#text").text();
		$.ajax({
		    type : "GET",
		    url : "/Admin/emailAndPasswordValidation",
		    data : "password="+enteredTemp+"&email="+getEmail,
		    success: function(result){
		    	if(result == "INVALID"){
					$("#msg").text("Wrong Temp Password entred");
					$("#oldPass").focus();
			    }else{
			    	$("#msg").text("");
				}
		    }
		});

		})
});
//validation password and conform password
$(document).ready(function(){
	$("#add").show();
	$("#config").blur(function(){
		$("#add").show();
		var enteredPassword=$("#newPass").val();
		var entredConfig=$('#config').val();
			if (enteredPassword==entredConfig) {
				$("#configMsg").text("");
				$("#add").show();
			}else{

			$("#configMsg").text("Wrong Temp Password entred");
			$("#add").hide();
			}
		})
});
//SSN verify enterd ssn if it match 1234-56-12345
$(document).ready(function(){
	$('#zzn').keypress(function(e){
		if (e.which != 8 && e.which != 0 && (e.which < 48 || e.which > 57)) {
			return false;
		 }	
		else  if (e.which != 8 && e.which != 0 && (e.which <= 57 &&  e.which >= 48)) {
		var zzn1=$('#zzn').val();
			if(event.keyCode!='8'){
				console.log("jtkakasm");
				if(zzn1.length==6){
					$('#zzn').val(zzn1+'-');
					}
				else if(zzn1.length==3){
					$('#zzn').val(zzn1+'-');
				}
			}
		}
	})
});
