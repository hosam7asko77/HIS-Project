$(document)
		.ready(
				function() {
					$()
							.ready(
									function() {
										$sidebar = $('.sidebar');

										$sidebar_img_container = $sidebar
												.find('.sidebar-background');

										$full_page = $('.full-page');

										$sidebar_responsive = $('body > .navbar-collapse');

										window_width = $(window).width();

										$('.fixed-plugin a')
												.click(
														function(event) {
															// Alex if we click
															// on switch, stop
															// propagation of
															// the event, so the
															// dropdown will not
															// be hide,
															// otherwise we set
															// the section
															// active
															if ($(this)
																	.hasClass(
																			'switch-trigger')) {
																if (event.stopPropagation) {
																	event
																			.stopPropagation();
																} else if (window.event) {
																	window.event.cancelBubble = true;
																}
															}
														});

										$('.fixed-plugin .active-color span')
												.click(
														function() {
															$full_page_background = $('.full-page-background');

															$(this)
																	.siblings()
																	.removeClass(
																			'active');
															$(this).addClass(
																	'active');

															var new_color = $(
																	this).data(
																	'color');

															if ($sidebar.length != 0) {
																$sidebar
																		.attr(
																				'data-color',
																				new_color);
															}

															if ($full_page.length != 0) {
																$full_page
																		.attr(
																				'filter-color',
																				new_color);
															}

															if ($sidebar_responsive.length != 0) {
																$sidebar_responsive
																		.attr(
																				'data-color',
																				new_color);
															}
														});

										$(
												'.fixed-plugin .background-color .badge')
												.click(
														function() {
															$(this)
																	.siblings()
																	.removeClass(
																			'active');
															$(this).addClass(
																	'active');

															var new_color = $(
																	this)
																	.data(
																			'background-color');

															if ($sidebar.length != 0) {
																$sidebar
																		.attr(
																				'data-background-color',
																				new_color);
															}
														});

										$('.fixed-plugin .img-holder')
												.click(
														function() {
															$full_page_background = $('.full-page-background');

															$(this)
																	.parent(
																			'li')
																	.siblings()
																	.removeClass(
																			'active');
															$(this)
																	.parent(
																			'li')
																	.addClass(
																			'active');

															var new_image = $(
																	this)
																	.find("img")
																	.attr('src');

															if ($sidebar_img_container.length != 0
																	&& $('.switch-sidebar-image input:checked').length != 0) {
																$sidebar_img_container
																		.fadeOut(
																				'fast',
																				function() {
																					$sidebar_img_container
																							.css(
																									'background-image',
																									'url("'
																											+ new_image
																											+ '")');
																					$sidebar_img_container
																							.fadeIn('fast');
																				});
															}

															if ($full_page_background.length != 0
																	&& $('.switch-sidebar-image input:checked').length != 0) {
																var new_image_full_page = $(
																		'.fixed-plugin li.active .img-holder')
																		.find(
																				'img')
																		.data(
																				'src');

																$full_page_background
																		.fadeOut(
																				'fast',
																				function() {
																					$full_page_background
																							.css(
																									'background-image',
																									'url("'
																											+ new_image_full_page
																											+ '")');
																					$full_page_background
																							.fadeIn('fast');
																				});
															}

															if ($('.switch-sidebar-image input:checked').length == 0) {
																var new_image = $(
																		'.fixed-plugin li.active .img-holder')
																		.find(
																				"img")
																		.attr(
																				'src');
																var new_image_full_page = $(
																		'.fixed-plugin li.active .img-holder')
																		.find(
																				'img')
																		.data(
																				'src');

																$sidebar_img_container
																		.css(
																				'background-image',
																				'url("'
																						+ new_image
																						+ '")');
																$full_page_background
																		.css(
																				'background-image',
																				'url("'
																						+ new_image_full_page
																						+ '")');
															}

															if ($sidebar_responsive.length != 0) {
																$sidebar_responsive
																		.css(
																				'background-image',
																				'url("'
																						+ new_image
																						+ '")');
															}
														});

										$('.switch-sidebar-image input')
												.change(
														function() {
															$full_page_background = $('.full-page-background');

															$input = $(this);

															if ($input
																	.is(':checked')) {
																if ($sidebar_img_container.length != 0) {
																	$sidebar_img_container
																			.fadeIn('fast');
																	$sidebar
																			.attr(
																					'data-image',
																					'#');
																}

																if ($full_page_background.length != 0) {
																	$full_page_background
																			.fadeIn('fast');
																	$full_page
																			.attr(
																					'data-image',
																					'#');
																}

																background_image = true;
															} else {
																if ($sidebar_img_container.length != 0) {
																	$sidebar
																			.removeAttr('data-image');
																	$sidebar_img_container
																			.fadeOut('fast');
																}

																if ($full_page_background.length != 0) {
																	$full_page
																			.removeAttr(
																					'data-image',
																					'#');
																	$full_page_background
																			.fadeOut('fast');
																}

																background_image = false;
															}
														});

										$('.switch-sidebar-mini input')
												.change(
														function() {
															$body = $('body');

															$input = $(this);

															if (md.misc.sidebar_mini_active == true) {
																$('body')
																		.removeClass(
																				'sidebar-mini');
																md.misc.sidebar_mini_active = false;

																$(
																		'.sidebar .sidebar-wrapper, .main-panel')
																		.perfectScrollbar();

															} else {

																$(
																		'.sidebar .sidebar-wrapper, .main-panel')
																		.perfectScrollbar(
																				'destroy');

																setTimeout(
																		function() {
																			$(
																					'body')
																					.addClass(
																							'sidebar-mini');

																			md.misc.sidebar_mini_active = true;
																		}, 300);
															}

															// we simulate the
															// window Resize so
															// the charts will
															// get updated in
															// realtime.
															var simulateWindowResize = setInterval(
																	function() {
																		window
																				.dispatchEvent(new Event(
																						'resize'));
																	}, 180);

															// we stop the
															// simulation of
															// Window Resize
															// after the
															// animations are
															// completed
															setTimeout(
																	function() {
																		clearInterval(simulateWindowResize);
																	}, 1000);

														});
									});
				});
$(document).ready(function() {
	// Javascript method's body can be found in assets/js/demos.js
	md.initDashboardPageCharts();
	
	
	$("#search-contenar").hide();
	$("#errorMsg").hide();
	$("#getPlan").submit(function(event){
		var planName=document.getElementById("searchPlan").value;
		event.stopPropagation();
		event.preventDefault();
		$.ajax({
			type : "GET",
			url :  "/RestApi/getPlan",
			data : "planName=" + planName,
			success : function(result){
				$("#search-contenar").show();
				$("#up-planId").val(result["planId"]);
				$("#up-planName").val(result["planName"]);
				$("#up-planDiscript").val(result["discript"]);
				$("#up-palnStartDate").val(result["startDate"]);
				$("#up-planEndDate").val(result["endDate"]);
				
			},
		error: function(jqXHR,textStatus, errorThrown) {
			$("#search-contenar").hide();
			$("#errorMsg").show();
			$("#errorMsg").text("Plan not found");
		}
		});
	});
    var today = new Date(new Date().getFullYear(), new Date().getMonth(), new Date().getDate());
    $('#startDate').datepicker({
        minDate: today,
        format: "mm/dd/yyyy",
        maxDate: function () {
            return $('#endDate').val();
        }
    });
    $('#endDate').datepicker({
        format: "mm/dd/yyyy",
        minDate: function () {
            return $('#startDate').val();
        }
    });
    $('#up-palnStartDate').datepicker({
        minDate: today,
        format: "mm/dd/yyyy",
        maxDate: function () {
            return $('#endDate').val();
        }
    });
    $('#up-planEndDate').datepicker({
        format: "mm/dd/yyyy",
        minDate: function () {
            return $('#startDate').val();
        }
    });
    $(function() {
		  $("form[id='planForm']").validate({
		    rules: {
		    	planName: "required",
		    	discript: "required",
		    	startDate : {
			    	required : true,
			    	date : true,
			    	
			    },
			    endDate : {
			    	required : true,
			    	date : true,
			    	
			    },
		    },
		    startDate : {
		    	required : "Pleace enter staet date",
		    	date : "Pleace enter vaild date ",
		    	
		    },
		    endDate : {
		    	required : "Pleace enter endd ate",
		    	date : "Pleace enter vaild date ",
		    	
		    },
		    messages: {
		    	planName: "Please enter plan name",
		    	discript: "Pleace enter plan description",
		    },

		    submitHandler: function(form) {
		      form.submit();
		    }
		  });
		});
    $(function() {
		  $("form[id='search-contenar']").validate({
		    rules: {
		    	planName: "required",
		    	discript: "required",
		    	startDate : {
			    	required : true,
			    	date : true,
			    	
			    },
			    endDate : {
			    	required : true,
			    	date : true,
			    	
			    },
		    },
		    startDate : {
		    	required : "Pleace enter staet date",
		    	date : "Pleace enter vaild date ",
		    	
		    },
		    endDate : {
		    	required : "Pleace enter endd ate",
		    	date : "Pleace enter vaild date ",
		    	
		    },
		    messages: {
		    	planName: "Please enter plan name",
		    	discript: "Pleace enter plan description",
		    },

		    submitHandler: function(form) {
		      form.submit();
		    }
		  });
		});
	
});