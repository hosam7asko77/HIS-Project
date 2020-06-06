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
	$(function() {
		  $("form[id='register']").validate({
		    rules: {

		    	firstName: "required",
		    	lastName: "required",
		    	gender: "required",
		    	ssn: "required",
		    	dob : {
			    	required : true,
			    	date : true,
			    	
			    },
			    phoneNumber : {
			    	required : true,
			    	number : true,
			    	maxlength : 10,
			    	minlength : 10
			    },
		    },
		    dob : {
		    	required : "Pleace enter Date",
		    	date : "Pleace enter vaild date ",
		    	
		    },

		    phoneNumber : {
		    	required : "Pleace enter phone number",
		    	number : "Enter only number",
		    	maxlength : "The max length is 10 digit",
		    	minlength : "The max length is 10 digit",
		    	
		    },
		    messages: {
		    	firstName: "Please enter frist name",
		    	lastName: "Pleace enter last name",
		    	ssn: "Please enter SSN number",
		    	phoneNumber:  "Pleace enter phone number",
		    	dob: "Pleace enter Date",
		    	gender: "Please select the gender"
		    },

		    submitHandler: function(form) {
		      form.submit();
		    }
		  });
		});
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
    $(function () {
        $('#datepicker').datepicker({
            format: "mm/dd/yyyy",
        });
    });

    (function ($) {
        'use strict';
        /*[ Select 2 Config ]
            ===========================================================*/
        
        try {
            var selectSimple = $('.js-select-simple');
        
            selectSimple.each(function () {
                var that = $(this);
                var selectBox = that.find('select');
                var selectDropdown = that.find('.select-dropdown');
                selectBox.select2({
                    dropdownParent: selectDropdown
                });
            });
        
        } catch (err) {
            console.log(err);
        }
        

    })(jQuery);

});

