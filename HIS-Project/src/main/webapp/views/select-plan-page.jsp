<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="description" content="">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- The above 4 meta tags *must* come first in the head; any other head content must come *after* these tags -->

<!-- Title  -->
<title>Medilife - Health &amp; Medical Template | About Us</title>

<!-- Favicon  -->
<link rel="icon"
	href="${pageContext.request.contextPath}/img/core-img/favicon.ico">

<!-- Style CSS -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/style.css">

</head>

<body>

	<%@ include file="header.jsp"%>
	<!-- ***** Header Area Start ***** -->
	<!-- ***** Breadcumb Area Start ***** -->
	<section class="breadcumb-area bg-img gradient-background-overlay"
		style="background-image: url(/img/bg-img/breadcumb1.jpg);">
		<div class="container h-100">
			<div class="row h-100 align-items-center">
				<div class="col-12">
					<div class="breadcumb-content">
						<h3 class="breadcumb-title">Select Plan</h3>
					</div>
				</div>
			</div>
		</div>
	</section>
	<div class="page-wrapper bg-red p-t-180 p-b-100 font-robo">
		<div class="wrapper wrapper--w960" style="margin-top: -10%">
			<div class="card card-2">
				<div class="card-heading"
					style="background: url(/img/bg-img/case2_img.jpg) top left/cover no-repeat;"></div>
				<div class="card-body">
					<h1 class="title" style="margin-top: -10%">Pleas Select the Plan</h1>
					<br>
					<h3 class="title" >Case Number : ${caseNumber}</h3>
					<form:form action="/DC/processSelectPlanForm"
						modelAttribute="casePlanDetails">
						<div class="input-group">
							<form:hidden path="caseNumber" value="${caseNumber}"/>
							<span>Plan</span>
							<form:select path="planId" id="speciality2"
								cssClass="form-control">
								<c:forEach var="tempPlans" items="${allPlans}">
									<form:option value="${tempPlans.planId}">${tempPlans.planName}</form:option>
								</c:forEach>
							</form:select>
						</div>
						<div class="float-sm-right">
							<button class="btn btn--radius btn--green" type="submit">Next&nbsp;<span class="fa fa-arrow-right"></span></button>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
	<!-- ***** Footer Area Start ***** -->
	<%@include file="footer.jsp"%>
	<!-- ***** Footer Area End ***** -->

	<!-- jQuery (Necessary for All JavaScript Plugins) -->
		<script
		src="${pageContext.request.contextPath}/js/jquery/jquery-3.5.0.js"></script>
	<script
		src="${pageContext.request.contextPath}/js/jquery/jquery-migrate-3.1.0.js"></script>
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
</body>
</html>