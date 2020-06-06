<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
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


</head>
<body>
	<%@ include file="header.jsp"%>
	<!-- ***** Features Area Start ***** -->
	<div class="section-padding-100">
		<div class="container" style="margin-top: 10%">
			<div class="row align-items-center">
				<div class="col-12 col-lg-6">
					<div class="features-content">
						<h2>Worried About Affording Your Medicine? HIS is Here to
							help</h2>
						<p>You have enough to worry about right now. Figuring out how
							to pay for your prescriptions shouldn’t be another stressor. For
							decades, PhRMA has been committed to advocating for policies that
							help patients access the medicines they need, but today,
							America’s biopharmaceutical companies are individually expanding
							their programs to help more patients during these uncertain
							times. HIS, the Medicine Assistance Tool, matches patients like
							you with resources and cost-sharing programs that may help lower
							your out-of-pocket costs, whether or not you have insurance.

							PhRMA’s Medicine Assistance Tool (HIS) is a search engine
							designed to help patients, caregivers and health care providers
							learn more about the resources available through the various
							biopharmaceutical industry programs. HIS is not its own patient
							assistance program, but rather a search engine for many of the
							patient assistance resources that the biopharmaceutical industry
							offers.</p>
					</div>
				</div>
				<div class="col-12 col-lg-6">
					<div class="features-thumbnail">
						<img src="/img/core-img/logo.png" alt="">
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- ***** Features Area End ***** -->
	<!-- ***** Cool Facts Area Start ***** -->
	<section class="medilife-cool-facts-area section-padding-100-0">
		<div class="container">
			<div class="row">
				<!-- Single Cool Fact-->
				<div class="col-12 col-sm-6 col-lg-3">
					<div class="single-cool-fact-area text-center mb-100">
						<i class="fa fa-hospital-o"></i>
						<h6>Medicare</h6>
						<p>Medicare Coverage for Prescription Drugs</p>
					</div>
				</div>
				<!-- Single Cool Fact-->
				<div class="col-12 col-sm-6 col-lg-3">
					<div class="single-cool-fact-area text-center mb-100">
						<i class="fa fa-heart-o"></i>
						<h6>Medicaid</h6>
						<p>Medicaid and Children’s Health Insurance Program (CHIP)</p>
					</div>
				</div>
				<!-- Single Cool Fact-->
				<div class="col-12 col-sm-6 col-lg-3">
					<div class="single-cool-fact-area text-center mb-100">
						<i class="fa fa-shopping-cart"></i>
						<h6>Health Insurance Marketplaces</h6>
						<p>Help for getting affordable insurance from health insurance
							marketplace</p>
					</div>
				</div>
				<!-- Single Cool Fact-->
				<div class="col-12 col-sm-6 col-lg-3">
					<div class="single-cool-fact-area text-center mb-100">
						<i class="fa fa-cutlery"></i>
						<h6>SNAP</h6>
						<p>SNAP provides nutrition benefits to supplement the food
							budget of needy families so they can purchase healthy food and
							move towards self-sufficiency.</p>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- ***** Cool Facts Area End ***** -->
	<!-- ***** Footer Area Start ***** -->
	<%@include file="footer.jsp"%>
	<!-- ***** Footer Area End ***** -->

	<!-- jQuery (Necessary for All JavaScript Plugins) -->
	<script
		src="${pageContext.request.contextPath}/js/jquery/jquery-3.5.1.js"></script>
	<!-- Popper js -->
	<script src="${pageContext.request.contextPath}/js/popper.min.js"></script>
	<!-- Bootstrap js -->
	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
	<!-- Plugins js -->
	<script src="${pageContext.request.contextPath}/js/plugins.js"></script>
	<!-- Active js -->
	<script src="${pageContext.request.contextPath}/js/active.js"></script>

</body>
</html>