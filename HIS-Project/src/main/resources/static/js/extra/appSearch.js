

//search for appliction
$(document).ready(function() {
	$("#search-contenar").hide();
	$("#errorMsg").hide();
	$("#getApp").submit(function(event){
		var appId=document.getElementById("textId").value;
		event.stopPropagation();
		event.preventDefault();
		$.ajax({
			type : "GET",
			url :  "/RestApi/getApplication",
			data : "appId=" + appId,
			success : function(result){
				$("#search-contenar").show();
				$("#appId").text(result["appId"])
				$("#name").text(result["firstName"])
				$("#dob").text(result["dob"])
				$("#gender").text(result["gender"])
				$("#ssn").text(result["ssn"])
				$("#phone").text(result["phoneNumber"])
				$("#email").text(result["email"])
				
			},
		error: function(jqXHR,textStatus, errorThrown) {
			$("#search-contenar").hide();
			$("#errorMsg").show();
			$("#errorMsg").text("Appliction not found");
		}
		});
	});

});
