$(document).ready(function(){
	$("#rDetails").hide();
	$(function() {
		  $("form[id='familyDetails']").validate({
		    rules: {

		    	fatherName: "required",
		    	matherName: "required",
		    	wifeName: "required",
			    wifeAge : {
			    	required : true,
			    	number : true,
			    	maxlength : 3,
			    },

		    },

		    wifeAge : {
		    	required : "Pleace enter wife age",
		    	number : "Enter only number",
		    	maxlength : "The max length is 3 digit",
		    	
		    },
		    messages: {
		    	fatherName: "Please enter father name",
		    	matherName: "Pleace enter mather name",
		    	wifeName: "Please enter wife name",
		    },

		    submitHandler: function(form) {
		      form.submit();
		    }
		  });
		});
});
$(document).on("change","#relation",function(){
	$("#rDetails").hide();
	var selectRelation=$("#relation").val();
	var married="married"
	if (selectRelation==married) {
		$("#rDetails").show();
	}else{
		$("#rDetails").hide();
	}
});
function check() {
	var m=document.getElementById();
}
$(function(){
	$("#btnSubmit").click(function(){
		var brother=$("#noBrother");
		var relation=$("#relation");
		var kids=$("#kids");
		var sister=$("#noSister");
		if (brother.val() == "") {
			$("#bMsg").text("Plase select brother number ");
			return false
		}else if (sister.val()=="") {
			$("#sMsg").text("Plase select sister number ");
			return false
		}else if (relation.val()=="") {
			$("#sMsg").text("Plase select  RelationShip ");
			return false
		}else if (relation.val()=="married") {
			if (kids.val()=="") {
				$("#kMsg").text("Plase select Kids");
				return false
			}
			$("#kMsg").hide();
			
		}
		
		$("#bMsg").hide();
		$("#sMsg").hide();
		
		return true;
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
// Wait for the DOM to be ready
