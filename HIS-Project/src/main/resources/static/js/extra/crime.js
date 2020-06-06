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


		    submitHandler: function(form) {
		      form.submit();
		    }
		  });
		});
	$(function () {
	    $('#incidentDate').datepicker({
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
