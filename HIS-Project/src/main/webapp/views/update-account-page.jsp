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
	<!-- Preloader -->
	<div id="preloader">
		<div class="medilife-load"></div>
	</div>

	<!-- ***** Header Area Start ***** -->
	<header class="header-area">
		<!-- Top Header Area -->
		<div class="top-header-area">
			<div class="container h-100">
				<div class="row h-100">
					<div class="col-12 h-100">
						<div
							class="h-100 d-md-flex justify-content-between align-items-center">
							<p>
								Welcome to <span>Medifile</span> template
							</p>
							<p>
								Opening Hours : Monday to Saturday - 8am to 10pm Contact : <span>+12-823-611-8721</span>
							</p>
						</div>
					</div>
				</div>
			</div>
		</div>

		<!-- Main Header Area -->
		<div class="main-header-area" id="stickyHeader">
			<div class="container h-100">
				<div class="row h-100 align-items-center">
					<div class="col-12 h-100">
						<div class="main-menu h-100">
							<nav class="navbar h-100 navbar-expand-lg">
								<!-- Logo Area  -->
								<a class="navbar-brand" href="index.html"><img
									src="${pageContext.request.contextPath}/img/core-img/logo.png"
									alt="Logo"></a>

								<button class="navbar-toggler" type="button"
									data-toggle="collapse" data-target="#medilifeMenu"
									aria-controls="medilifeMenu" aria-expanded="false"
									aria-label="Toggle navigation">
									<span class="navbar-toggler-icon"></span>
								</button>

								<div class="collapse navbar-collapse" id="medilifeMenu">
									<!-- Menu Area -->
									<ul class="navbar-nav ml-auto">
										<li class="nav-item"><a class="nav-link"
											href="index.html">Home <span class="sr-only">(current)</span></a>
										</li>
										<li class="nav-item dropdown"><a
											class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
											role="button" data-toggle="dropdown" aria-haspopup="true"
											aria-expanded="false">Pages</a>
											<div class="dropdown-menu" aria-labelledby="navbarDropdown">
												<a class="dropdown-item" href="index.html">Home</a> <a
													class="dropdown-item" href="about-us.html">About Us</a> <a
													class="dropdown-item" href="services.html">Services</a> <a
													class="dropdown-item" href="blog.html">News</a> <a
													class="dropdown-item" href="single-blog.html">News
													Details</a> <a class="dropdown-item" href="contact.html">Contact</a>
												<a class="dropdown-item" href="elements.html">Elements</a> <a
													class="dropdown-item" href="index-icons.html">All Icons</a>
											</div></li>
										<li class="nav-item"><a class="nav-link"
											href="about-us.html">About Us</a></li>
										<li class="nav-item"><a class="nav-link"
											href="services.html">Services</a></li>
										<li class="nav-item"><a class="nav-link" href="blog.html">News</a>
										</li>
										<li class="nav-item dropdown"><a
											class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
											role="button" data-toggle="dropdown" aria-haspopup="true"
											aria-expanded="false">Admin</a>
											<div class="dropdown-menu" aria-labelledby="navbarDropdown">
												<a class="dropdown-item" href="index.html">Create Account</a>
												 <a class="dropdown-item" href="viewUsers">View Accounts</a>
												  <a class="dropdown-item" href="viewUsers">Create Plan</a> 
												  <a class="dropdown-item" href="blog.html">View Plan</a>
											</div></li>
									</ul>
									<!-- Appointment Button -->
									<a href="#" class="btn medilife-appoint-btn ml-30">For <span>emergencies</span>
										Click here
									</a>
								</div>
							</nav>
						</div>
					</div>
				</div>
			</div>
		</div>
	</header>
	<!-- ***** Header Area End ***** -->

	<!-- ***** Breadcumb Area Start ***** -->
	<section class="breadcumb-area bg-img gradient-background-overlay"
		style="background-image: url(/img/bg-img/breadcumb3.jpg);">
		<div class="container h-100">
			<div class="row h-100 align-items-center">
				<div class="col-12">
					<div class="breadcumb-content">
						<h3 class="breadcumb-title">User Registration Details</h3>
						<p>Add new user to application</p>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- ***** Breadcumb Area End ***** -->
	<!-- ***** Book An Appoinment Area Start ***** -->
	<div class="medilife-book-an-appoinment-area">
		<div class="container">
			<div class="row">
				<div class="col-12">
					<div class="appointment-form-content">
						<div class="row no-gutters align-items-center">
							<div class="col-12 col-lg-9">
								<div class="medilife-appointment-form">
									<form:form id="userDetails" action="/Admin/Manager/processForm" method="post"
										modelAttribute="details">
										<div class="row align-items-end">
										<form:hidden path="userId"/>
										<form:hidden path="publicId"/>
											<div class="col-12 col-md-4"">
												<div class="form-group">
													<form:input path="firstName"
														cssClass="form-control form-control border-top-0 border-right-0 border-left-0"
														id="name" placeholder="First Name" />
												</div>
											</div>
											<div class="col-12 col-md-4"">
												<div class="form-group">
													<form:input path="lastName"
														cssClass="form-control form-control border-top-0 border-right-0 border-left-0"
														id="name" placeholder="Last Name" />
												</div>
											</div>
											<div class="col-12 col-md-4"">
												<div class="form-group">
													<form:input path="email"
														cssClass="form-control form-control border-top-0 border-right-0 border-left-0"
														id="email" placeholder="Example@gmail.com" />
												</div>
											</div>
											<div class="col-12 col-md-4"">
												<div class="form-group">
													<div class="input-group-icon">
														<form:input path="dob"
															cssClass="input--style-4 js-datepicker form-control border-top-0 border-right-0 border-left-0"
															placeholder="Date of Birth" />
														<i
															class="zmdi zmdi-calendar-note input-icon js-btn-calendar"></i>
													</div>
												</div>
											</div>
											<div class="col-12 col-md-4">
												<div class="form-group">
													<form:select path="gender" cssClass="form-control"
														id="speciality">
														<form:option value="Male">Male</form:option>>
														<form:option value="Female">Female</form:option>
													</form:select>
												</div>
											</div>
											<div class="col-12 col-md-4"">
												<div class="form-group">
													<form:input path="ssn"
														cssClass="form-control form-control border-top-0 border-right-0 border-left-0"
														id="zzn" placeholder="SSN Number" />
												</div>
											</div>
											<div class="col-12 col-md-4">
												<div class="form-group">
													<form:input path="phoneNumber"
														cssClass="form-control border-top-0 border-right-0 border-left-0"
														id="number" placeholder="Phone" />
												</div>
											</div>
											<div class="col-12 col-md-4">
												<div class="form-group">
													<form:select path="roleType" cssClass="form-control"
														id="speciality">
														<form:option value="worker">Case Worker</form:option>
														<form:option value="admin">Admin</form:option>
													</form:select>
												</div>
											</div>

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
		</div>
	</div>
	<br>
	<br>
	<!-- ***** Footer Area Start ***** -->
	<footer class="footer-area section-padding-100">
		<!-- Bottom Footer Area -->
		<div class="bottom-footer-area">
			<div class="container-fluid">
				<div class="row">
					<div class="col-12">
						<div class="bottom-footer-content">
							<!-- Copywrite Text -->
							<div class="copywrite-text">
								<p>
									<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
									Copyright &copy;
									<script>
										document
												.write(new Date().getFullYear());
									</script>
									All rights reserved | This template is made with <i
										class="fa fa-heart-o" aria-hidden="true"></i> by <a
										href="https://colorlib.com" target="_blank">Colorlib</a>
									<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
								</p>
								<p>
									Re-distributed by <a href="https://themewagon.com/"
										target="_blank">Themewagon</a>
								</p>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</footer>
	<!-- ***** Footer Area End ***** -->

	<!-- jQuery (Necessary for All JavaScript Plugins) -->
	<script
		src="${pageContext.request.contextPath}/js/jquery/jquery-2.2.4.min.js"></script>
	<!-- Popper js -->
	<script src="${pageContext.request.contextPath}/js/popper.min.js"></script>
	<!-- Bootstrap js -->
	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
	<!-- Plugins js -->
	<script src="${pageContext.request.contextPath}/js/plugins.js"></script>
	<!-- Active js -->
	<script src="${pageContext.request.contextPath}/js/active.js"></script>
	<!-- Google Maps -->
	<script
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAwuyLRa1uKNtbgx6xAJVmWy-zADgegA2s"></script>
	<script src="${pageContext.request.contextPath}/js/map-active.js"></script>
	<script src="${pageContext.request.contextPath}/js/global.js"></script>
	<script src="${pageContext.request.contextPath}/js/extra/register.js"></script>

</body>
</html>