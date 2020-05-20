$(document).ready(function(){
	//$("#rDetails").hide();
	$(function() {
		  $("form[id='crimeForm']").validate({
		    rules: {

		    	incidentStreet: "required",
		    	incidentCity: "required",
		    	incidentState: "required",
		    	incidentDescribe: "required",
		    	incidentType: "required",
			    incidentDate : {
		    		required : true,
		    		date : true,
		    		
		    	},
		    	peopelInvolved : {
			    	required : true,
			    	number : true,
			    	maxlength : 3,
			    	minlength : 1
			    },
		    },

		    incidentDate : {
		    	date : "Pleace enter you witneesed indcident date",
		    	required : "Pleace enter you witneesed indcident date",
		    	
		    },
		    peopelInvolved : {
		    	required : "Pleace enter number of pepole",
		    	number : "you must enter only digit",
		    	maxlength : "maximum length 1 digits",
		    	minlength : "minimum length 3 digits"
		    },
		    messages: {
		    	inStreet: "Please enter  street",
		    	inState: "Pleace enter state",
		    	inCity: "Please enter city",
		    	inDescribe: "Please enter description",
		    	incidentType : "you must check at least 1 incident type",
		    },
//		    errorPlacement: function(error,element) {
//				if (element.attr("name")=='incidentType') {
//					$("#errorMsg").text(error);
//				} else {
//					error.insertAfter(element);
//				}
//			},
//		    errorElement: 'div',
//		    errorLabelContainer: '.error-msg',

		    submitHandler: function(form) {
		      form.submit();
		    }
		  });
		});
//	$(".custom-file-input").on("change",function(){
//		var fileName = $(this).val().split(\\).pop();
//		$(this).siblings(."custom-file-input").addClass("selected").html(fileName);
//	});
});