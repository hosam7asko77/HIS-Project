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
	<p id="email">
		<security:authentication property="principal.username" />
	</p>
	<p>${msg}</p>



	<section class="medilife-benefits-area section-padding-100-50">
		<div class="container">
			<div class="row">
				<div class="col-12">
					<div class="section-heading">

						<h2>
							We always put <br>our pacients first
						</h2>

					</div>
				</div>
			</div>

			<div class="row align-items-center">
				<div class="col-12 col-md-4">
					<div class="single-benefits-area mb-50 text-right">
						<div
							class="single-benefits-title d-flex align-items-end row-reverse">
							<i class="icon-teeth"></i>
							<h5>Safe tests</h5>
						</div>
						<p>Ipsum dolor sit amet, consectetuer adipiscing eli. Lorem
							ipsum dolor sit amet, adip iscing.</p>
					</div>
					<div class="single-benefits-area mb-50 text-right">
						<div
							class="single-benefits-title d-flex align-items-end row-reverse">
							<i class="icon-hospital-bed-1"></i>
							<h5>Online results</h5>
						</div>
						<p>Ipsum dolor sit amet, consectetuer adipiscing eli. Lorem
							ipsum dolor sit amet, adip iscing.</p>
					</div>
					<div class="single-benefits-area mb-50 text-right">
						<div
							class="single-benefits-title d-flex align-items-end row-reverse">
							<i class="icon-hospital-2"></i>
							<h5>Imagistic tests</h5>
						</div>
						<p>Ipsum dolor sit amet, consectetuer adipiscing eli. Lorem
							ipsum dolor sit amet, adip iscing.</p>
					</div>
				</div>
				<div class="col-12 col-md-4">
					<div class="single-benefits-thumb">
						<img src="img/bg-img/benefits.png" alt="">
					</div>
				</div>
				<div class="col-12 col-md-4">
					<div class="single-benefits-area mb-50">
						<div class="single-benefits-title d-flex align-items-end">
							<i class="icon-flask-1"></i>
							<h5>Safe tests</h5>
						</div>
						<p>Ipsum dolor sit amet, consectetuer adipiscing eli. Lorem
							ipsum dolor sit amet, adip iscing.</p>
					</div>
					<div class="single-benefits-area mb-50">
						<div class="single-benefits-title d-flex align-items-end">
							<i class="icon-smartphone-1"></i>
							<h5>Online results</h5>
						</div>
						<p>Ipsum dolor sit amet, consectetuer adipiscing eli. Lorem
							ipsum dolor sit amet, adip iscing.</p>
					</div>
					<div class="single-benefits-area mb-50">
						<div class="single-benefits-title d-flex align-items-end">
							<i class="icon-nuclear"></i>
							<h5>Imagistic tests</h5>
						</div>
						<p>Ipsum dolor sit amet, consectetuer adipiscing eli. Lorem
							ipsum dolor sit amet, adip iscing.</p>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- ***** Footer Area Start ***** -->
	<%@include file="footer.jsp"%>
	<!-- ***** Footer Area End ***** -->

	<!-- jQuery (Necessary for All JavaScript Plugins) -->
	<script
		src="${pageContext.request.contextPath}/js/jquery/jquery-3.5.0.js"></script>
	<script
		src="${pageContext.request.contextPath}/js/jquery/jquery.validate.min.js"></script>

	<script
		src="${pageContext.request.contextPath}/js/jquery/additional-methods.min.js"></script>
	<!-- Popper js -->
	<script src="${pageContext.request.contextPath}/js/popper.min.js"></script>
	<!-- Bootstrap js -->
	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/js/datepicker/moment.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/js/datepicker/daterangepicker.js"></script>
	<script src="${pageContext.request.contextPath}/js/select2.min.js"></script>
	<!-- Plugins js -->
	<script src="${pageContext.request.contextPath}/js/plugins.js"></script>
	<!-- Active js -->
	<script src="${pageContext.request.contextPath}/js/active.js"></script>
	<script src="${pageContext.request.contextPath}/js/extra/family.js"></script>

</body>
</html>