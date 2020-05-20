

//search for appliction
$(document).ready(function() {
	$("#search-contenar").hide();
	$("#caseBody").hide();
	$("#errorMsg").hide();
	$("#caseMsg").hide();
	$("#createBtn").hide();
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
				$("#caseBody").show();
				$("#appId").text(result["appId"]);
				$("#name").text(result["firstName"]);
				$("#dob").text(result["dob"]);
				$("#gender").text(result["gender"]);
				$("#ssn").text(result["ssn"]);
				$("#phone").text(result["phoneNumber"]);
				$("#email").text(result["email"]);
				$("#appRegisterID").val(result["appId"]);
				$.ajax({
					type : "GET",
					url :  "/RestApi/isCaseExist",
					data : "appId=" + appId,
					success : function(result){
						if (result["error"]==true) {
							$("#caseMsg").show();
							$("#caseMsg").text(result["message"])
							$("#createBtn").hide();
						} else {
							$("#caseMsg").hide();
							$("#createBtn").show();
						}
					}
				});
				
			},
		error: function(jqXHR,textStatus, errorThrown) {
			$("#caseBody").hide();
			$("#search-contenar").hide();
			$("#errorMsg").show();
			$("#errorMsg").text("Appliction not found");
		}
		});
	});
	

});
