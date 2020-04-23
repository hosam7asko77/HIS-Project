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

	<div class="medilife-book-an-appoinment-area">
		<div class="container">
			<div class="row align-items-center">
				<div class="medilife-application-form">
					<div class="col-md-12">
						<div class="medilife-application-form align-center">
							<form:form id="userDetails" action="/AppRegister/${processHandel}"
								method="post" modelAttribute="appRegister">
								<div class="form-group">
									<form:input path="firstName"
										cssClass="form-control form-control border-top-0 border-right-0 border-left-0"
										id="fname" placeholder="First Name" />
									<form:input path="lastName"
										cssClass="form-control form-control border-top-0 border-right-0 border-left-0"
										id="lname" placeholder="Last Name" />
									<form:input path="email"
										cssClass="form-control form-control border-top-0 border-right-0 border-left-0"
										id="email" placeholder="Example@gmail.com" size="5"/>
									<p id="emailMsg" style="color: red;"></p>
									<div class="input-group-icon">
										<form:input path="dob"
											cssClass="input--style-4 js-datepicker form-control border-top-0 border-right-0 border-left-0"
											placeholder="Date of Birth" />
										<i class="zmdi zmdi-calendar-note input-icon js-btn-calendar"></i>
									</div>
											<form:select path="gender" cssClass="form-control"
												id="speciality2">
												<form:option value="Male">Male</form:option>>
														<form:option value="Female">Female</form:option>
											</form:select>
									<form:input path="ssn"
										cssClass="form-control form-control border-top-0 border-right-0 border-left-0"
										id="zzn" placeholder="SSN Number" maxlength="12" />
										<span id="ssnMsg" style="color: red;"></span>
									<form:input path="phoneNumber"
										cssClass="form-control border-top-0 border-right-0 border-left-0"
										id="phno" placeholder="Phone" maxlength="10"/>
										<form:hidden path="appId"/>
										<form:hidden path="deleteStatus"/>
									<div class="col-12 col-md-5 mb-0">
										<div class="form-group mb-0">
											<button type="submit" class="btn medilife-btn">
												Register <span>+</span>
											</button>
										</div>
									</div>
								</div>
							</form:form>
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
	<script src="${pageContext.request.contextPath}/js/extra/appRegister.js"></script>

</body>
</html>