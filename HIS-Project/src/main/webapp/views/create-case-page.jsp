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
<c:set var="publicId" value="${sessionScope['PUBLIC_ID_SESSION']}"></c:set>
	<!-- Start Header Area-->
	<%@ include file="header.jsp"%>
	<!-- ***** Header Area End ***** -->

	<!-- ***** Breadcumb Area Start ***** -->
	<section class="breadcumb-area bg-img gradient-background-overlay"
		style="background-image: url(/img/bg-img/case_img.png);">
		<div class="container h-100">
			<div class="row h-100 align-items-center">
				<div class="col-12">
					<div class="breadcumb-content">
						<h3 class="breadcumb-title">Create Case</h3>
					</div>
				</div>
			</div>
		</div>
	</section>

	<div class="container h-100">
		<div class="d-flex justify-content-center h-100">
			<form action="" id="getApp" method="get">
				<div class="searchbar">
					<input class="search_input" type="text" id="textId"
						placeholder="Search...">
					<button type="submit" class="search_icon"
						style="background-color: transparent; border: none;">
						<i class="fa fa-search"></i>
					</button>
				</div>
				<p id="errorMsg" style="color: red;"></p>
			</form>
		</div>
	</div>
	<div class="page-wrapper bg-red p-t-180 p-b-100 font-robo">
		<div class="wrapper wrapper--w960" style="margin-top: -10%">
			<div class="card card-2">
				<div class="card-heading"
					style="background: url(/img/bg-img/case2_img.jpg) top left/cover no-repeat;"></div>
				<div class="card-body" id="caseBody">
					<h1 class="title" style="margin-top: -10%">Create Case</h1>
					<h3 style="margin-top: -5%">Application Details</h3>
					<br>

					<h4>
						Application Id: <span id="appId"></span>
					</h4>
					<h4>
						Name: <span id="name"></span>
					</h4>
					<h4>
						Date Of Birth: <span id="dob"></span>
					</h4>
					<h4>
						Gender: <span id="gender"></span>
					</h4>
					<h4>
						SSN: <span id="ssn"></span>
					</h4>
					<h4>
						Phone Number: <span id="phone"></span>
					</h4>
					<h4>
						email: <span id="email"></span>
					</h4>
					<form:form action="/DC/processCaseForm"
						modelAttribute="caseDetails">
						<form:hidden path="userId" value="${publicId}"/>
						<form:hidden path="appRegister" id="appRegisterID" />
						<div class="float-sm-right">
							<button class="btn btn-success" type="submit" id="createBtn">
								Create Case&nbsp;<span class="fa fa-arrow-right"></span>
							</button>
						</div>
						<p style="color: red;" id="caseMsg">
							<span class="fa fa-warning"></span>${Msg}</p>
					</form:form>
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
		src="${pageContext.request.contextPath}/js/jquery/jquery-3.5.1.js"></script>
	<script src="${pageContext.request.contextPath}/js/popper.min.js"></script>
	<!-- Bootstrap js -->
	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
	<!-- Plugins js -->
	<script src="${pageContext.request.contextPath}/js/plugins.js"></script>
	<!-- Active js -->
	<script src="${pageContext.request.contextPath}/js/active.js"></script>
	<!-- Google Maps -->
	
	<script src="${pageContext.request.contextPath}/js/map-active.js"></script>
	<script src="${pageContext.request.contextPath}/js/extra/createCase.js"></script>

</body>
</html>