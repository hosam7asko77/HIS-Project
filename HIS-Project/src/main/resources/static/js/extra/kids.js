$(document).ready(function(){
	$(function() {
		  $("form[id='kidsform']").validate({
		    rules: {

		    	childName: "required",
		    	gender: "required",
		    	ssn: "required",
		    	dob : {
			    	required : true,
			    	date : true,
			    },

		    },

		    dob : {
		    	required : "Pleace enter Date",
		    	date : "Pleace enter vaild date ",
		    	
		    },
		    messages: {
		    	childName: "Please enter Child name",
		    	//gender: "Pleace Choice  gender",
		    	ssn: "Please enter ssn",
		    },

		    submitHandler: function(form) {
		      form.submit();
		    }
		  });
		});
	$('#ssn').keypress(
			function(e) {
				if (e.which != 8 && e.which != 0
						&& (e.which < 48 || e.which > 57)) {
					return false;
				} else if (e.which != 8 && e.which != 0
						&& (e.which <= 57 && e.which >= 48)) {
					var zzn1 = $('#ssn').val();
					if (event.keyCode != '8') {
						console.log("jtkakasm");
						if (zzn1.length == 6) {
							$('#ssn').val(zzn1 + '-');
						} else if (zzn1.length == 3) {
							$('#ssn').val(zzn1 + '-');
						}
					}
				}
			});
	$("#ssn").blur(function() {
		var zzn=$("#ssn").val();
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