<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8" />
<link rel="apple-touch-icon" sizes="76x76"
	href="${pageContext.request.contextPath}/img/core-img/logo.png">
<link rel="icon" type="image/png"
	href="${pageContext.request.contextPath}/img/core-img/logo.png">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<title>Material Dashboard Dark Edition by Creative Tim</title>
<meta
	content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0, shrink-to-fit=no'
	name='viewport' />
<!--     Fonts and icons     -->
<link rel="stylesheet" type="text/css"
	href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Roboto+Slab:400,700|Material+Icons" />
<!-- CSS Files -->
<link
	href="${pageContext.request.contextPath}/css/material-dashboard.css?v=2.1.0"
	rel="stylesheet" />
<!-- CSS Just for demo purpose, don't include it in your project -->
<link href="${pageContext.request.contextPath}/css/demo.css"
	rel="stylesheet" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/style.css">
</head>

<body class="dark-edition">
	<div class="wrapper ">
		<%@include file="sidebar.jsp"%>
		<div class="main-panel">
			<!-- Navbar -->
			<%@include file="header.jsp"%>
			<!-- End Navbar -->
			<div class="content">
				<div class="container-fluid">
					<div class="row">
						<div class="col-md-8">
							<div class="card">
								<div class="card-header card-header-primary">
									<h4 class="card-title" style="margin-top: 3%;">New Profile</h4>
									<p class="card-category">Add new Profile</p>
								</div>
								<div class="card-body">
									<form:form id="register"
										action="/Admin/Manager/${processHandel}" method="post"
										modelAttribute="details">
										<form:hidden path="publicId" />
										<form:hidden path="userId" />
										<div class="row">
											<div class="col-md-6">
												<div class="form-group">
													<label class="bmd-label-floating">First Name</label>
													<form:input path="firstName"
														class="form-control border-top-0 border-right-0 border-left-0" />
												</div>
											</div>
											<div class="col-md-6">
												<div class="form-group">
													<label class="bmd-label-floating">Last Name</label>
													<form:input path="lastName"
														class="form-control border-top-0 border-right-0 border-left-0" />
												</div>
											</div>
											<div class="col-md-5">
												<div class="form-group">
													<label class="bmd-label-floating">Email address</label>
													<form:input path="email"
														class="form-control border-top-0 border-right-0 border-left-0"
														id="email" />
												</div>
												<span id="emailMsg" style="color: red;"></span>
											</div>
											<div class="col-md-6">

												<div class="form-group">
													<label class="bmd-label-floating">Date OF Birth</label>
													<form:input path="dob" id="datepicker"
														cssClass="form-control border-top-0 border-right-0 border-left-0" />
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col-md-6">
												<div class="form-group">
													<label class="bmd-label-floating">Phone Number</label>
													<form:input path="phoneNumber"
														cssClass="form-control border-top-0 border-right-0 border-left-0"
														maxlength="10" />
												</div>
											</div>
											<div class="col-md-6">
												<div class="form-group">
													<label class="bmd-label-floating">SSN Number</label>
													<form:input path="ssn"
														cssClass="form-control border-top-0 border-right-0 border-left-0"
														id="ssn" maxlength="12" />
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col-md-4">
												<div class="form-group rs-select2" style="color: gray;">
													<div class="rs-select2 js-select-simple select--no-search">
														<form:select path="gender" cssClass="form-control"
															cssStyle="background-color: transprent;" id="gender">
															<form:option value="" cssStyle="color: gray;">Gender</form:option>
															<form:option value="Male" cssStyle="color: gray;">Male</form:option>
															<form:option value="Female" cssStyle="color: gray;">Female</form:option>
														</form:select>
														<div class="select-dropdown"></div>
														<br> <br>
													</div>

													<span id="gMsg"></span>
												</div>
											</div>
											<div class="col-md-4">
												<div class="form-group rs-select2" style="color: gray;">
													<div class="rs-select2 js-select-simple select--no-search">
														<form:select path="roleType" cssClass="form-control"
															id="role" cssStyle="background-color: transprent;">
															<form:option value="" cssStyle="color: gray;">Role Type</form:option>
															<form:option value="worker" cssStyle="color: gray;">Case Worker</form:option>
															<form:option value="admin" cssStyle="color: gray;">Admin</form:option>
														</form:select>
														<div class="select-dropdown"></div>
														<span id="rMsg"></span>
													</div>
												</div>
											</div>
										</div>
										<button type="submit" class="btn btn-primary pull-right"
											id="btnSubmit">Add Profile</button>
										<div class="clearfix"></div>
									</form:form>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<%@include file="footer.jsp"%>
		</div>
	</div>
	<%@ include file="settings.jsp"%>
	<script
		src="${pageContext.request.contextPath}/js/jquery/jquery-3.5.1.js"></script>
	<script src="${pageContext.request.contextPath}/js/popper.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/js/bootstrap-material-design.min.js"></script>
	<script src="https://unpkg.com/default-passive-events"></script>
	<script
		src="${pageContext.request.contextPath}/js/perfect-scrollbar.jquery.min.js"></script>
	
	<script src="${pageContext.request.contextPath}/js/select2.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/js/jquery/jquery.validate.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/plugins.js"></script>
	<script src="${pageContext.request.contextPath}/js/datepicker/js/gijgo.min.js" type="text/javascript"></script>
	<script
		src="${pageContext.request.contextPath}/js/jquery/additional-methods.min.js"></script>
	<!-- Place this tag in your head or just before your close body tag. -->
	<script async defer src="https://buttons.github.io/buttons.js"></script>
	<!--  Google Maps Plugin    -->
	<!--   <script src="https://maps.googleapis.com/maps/api/js?key=YOUR_KEY_HERE"></script>
 -->
	<!-- Chartist JS -->
	<script src="${pageContext.request.contextPath}/js/chartist.min.js"></script>
	<!--  Notifications Plugin    -->
	<script src="${pageContext.request.contextPath}/js/bootstrap-notify.js"></script>
	<!-- Control Center for Material Dashboard: parallax effects, scripts for the example pages etc -->
	<script
		src="${pageContext.request.contextPath}/js/material-dashboard.js?v=2.1.0"></script>
	<!-- Material Dashboard DEMO methods, don't include it in your project! -->
	<script src="${pageContext.request.contextPath}/js/demo.js"></script>
	<!-- 	extra javaScript file-->
	<script src="${pageContext.request.contextPath}/js/extra/dashboard.js"></script>
	<script src="${pageContext.request.contextPath}/js/extra/register.js"></script>

</body>

</html>