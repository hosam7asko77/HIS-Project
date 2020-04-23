<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Admin Register Page</title>
<meta charset="UTF-8">
<meta name="description" content="">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- The above 4 meta tags *must* come first in the head; any other head content must come *after* these tags -->

<!-- Title  -->
<title>HIS System - Health &amp; Medical Template | Contact</title>

<!-- Favicon  -->
<link rel="icon"
	href="${pageContext.request.contextPath}/img/core-img/favicon.ico">

<!-- Style CSS -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/style.css">


</head>

<body>
	<!-- Start Header Area-->
	<%@ include file="header.jsp"%>
	<!-- ***** Header Area End ***** -->

	<!-- ***** Breadcumb Area Start ***** -->
	<section class="breadcumb-area bg-img gradient-background-overlay"
		style="background-image: url(/img/bg-img/family-insurance.jpg);">
		<div class="container h-100">
			<div class="row h-100 align-items-center">
				<div class="col-12">
					<div class="breadcumb-content">
						<h3 class="breadcumb-title">Application Registration Details</h3>
						<p>Add new application</p>
						<p>${Msg}</p>
					</div>
				</div>
			</div>
		</div>
	</section>

	    <div class="container h-100">
      <div class="d-flex justify-content-center h-100">
      <form action="" id="getApp" method="get">
        <div class="searchbar">
          <input class="search_input" type="text" id="textId" placeholder="Search...">
					<button type="submit" class="search_icon"
						style="background-color: transparent; border: none;">
						<i class="fa fa-search"></i>
					</button>
				</div>
				<p id="errorMsg" style="color: red;"></p>
      </form>
      </div>
    </div>
    
    <div class="medilife-application-search-area" id="search-contenar">
		<div class="container">
			<div class="row align-items-center">
				<div class="medilife-app-search-form">
					<div class="col-md-12">
						<div class="medilife-application-form align-center">
							<h2>Application Details</h2>
							<h4>Application Id: <span id="appId"></span></h4>
							<h4>Name: <span id="name"></span></h4>
							<h4>Date Of Birth: <span id="dob"></span></h4>
							<h4>Gender: <span id="gender"></span></h4>
							<h4>SSN: <span id="ssn"></span></h4>
							<h4>Phone Number: <span id="phone"></span></h4>
							<h4>email: <span id="email"></span></h4>
							
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<br>
	<br>
	<!-- ***** Footer Area Start ***** -->
	<%@include file="footer.jsp"%>
	<!-- ***** Footer Area End ***** -->

	<!-- jQuery (Necessary for All JavaScript Plugins) -->
	<script
		src="${pageContext.request.contextPath}/js/jquery/jquery-2.2.4.min.js"></script>
	<!-- Popper js -->
	<script src="${pageContext.request.contextPath}/js/popper.min.js"></script>
	<!-- Bootstrap js -->
	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/js/datepicker/moment.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/js/datepicker/daterangepicker.js"></script>
	<!-- Plugins js -->
	<script src="${pageContext.request.contextPath}/js/plugins.js"></script>
	<!-- Active js -->
	<script src="${pageContext.request.contextPath}/js/active.js"></script>
	<!-- Google Maps -->
	<script
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAwuyLRa1uKNtbgx6xAJVmWy-zADgegA2s"></script>
	<script src="${pageContext.request.contextPath}/js/map-active.js"></script>
	<script src="${pageContext.request.contextPath}/js/global.js"></script>
	<script
		src="${pageContext.request.contextPath}/js/extra/appSearch.js"></script>

</body>
</html>