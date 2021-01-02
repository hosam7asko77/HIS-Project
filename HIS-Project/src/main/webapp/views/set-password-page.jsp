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
<title>HIS System - Health &amp; </title>

<!-- Favicon  -->
<link rel="icon"
	href="${pageContext.request.contextPath}/img/core-img/favicon.ico">

<!-- Style CSS -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/style.css">
</head>
<body>
	<%@ include file="header.jsp"%>
	<!-- ***** Breadcumb Area Start ***** -->
	<section class="breadcumb-area bg-img gradient-background-overlay"
		style="background-image: url(/img/bg-img/breadcumb3.jpg);">
		<div class="container h-100">
			<div class="row h-100 align-items-center">
				<div class="col-12">
					<div class="breadcumb-content">
						<h3 class="breadcumb-title">Create Password</h3>
						<p id="text"></p>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- ***** Breadcumb Area End ***** -->
	<!-- ***** Book An Appoinment Area Start ***** -->
	<div class="medilife-book-an-appoinment-area">
		<div class="container">
			<div class="row align-items-center">
				<div class="col-md-12">
					<div class="medilife-appointment-form">
						<form:form action="/Admin/setPasswordProcess"
							modelAttribute="passwordRequest" method="POST">
							<div class="form-group">
								<form:hidden path="email"
									cssClass="form-control form-control border-top-1 border-right-1 border-left-1"
									id="email" placeholder="Email" />
								<form:password path="oldPassword"
									cssClass="form-control form-control border-top-1 border-right-1 border-left-1"
									id="oldPass" placeholder="Temp Password" />
								<h6 style="color: red;" id="msg"></h6>
								<form:password path="password" 
									cssClass="form-control form-control border-top-1 border-right-1 border-left-1"
									id="newPass" placeholder="New Password" />
								<input type="password" id="config"
									class="form-control form-control border-top-1 border-right-1 border-left-1"
									placeholder="Confirm password">
								<span id="configMsg" style="color: red;"></span>
							</div>

							<div class="col-12 col-md-5 mb-0">
								<div class="form-group mb-0">
									<button type="submit" class="btn medilife-btn"  id="add">
										Create Password <span>+</span>
									</button>
								</div>
							</div>
						</form:form>

					</div>
				</div>
			</div>
		</div>
	</div>
	<br>
	<br>

	<%@include file="footer.jsp"%>
	<!-- jQuery (Necessary for All JavaScript Plugins) -->
	<script
		src="${pageContext.request.contextPath}/js/jquery/jquery-2.2.4.min.js"></script>
	<!-- Popper js -->
	<script src="${pageContext.request.contextPath}/js/popper.min.js"></script>
	<!-- Bootstrap js -->
	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/js/datepicker/moment.min.js"></script>
	<!-- Plugins js -->
	<script src="${pageContext.request.contextPath}/js/plugins.js"></script>
	<!-- Active js -->
	<script src="${pageContext.request.contextPath}/js/active.js"></script>
	<script src="${pageContext.request.contextPath}/js/extra/setPassword.js"></script>

</body>
</html>