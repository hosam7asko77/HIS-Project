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
									<h4 class="card-title" style="margin-top: 3%;">New Batch</h4>

								</div>
								<div class="card-body">
									<button type="submit" class="btn btn-primary pull-right"
										id="btnSubmit">Batch Start Running</button>
									<p id="msg"  class="card-category">Batch Start Running</p>
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

	<!-- Place this tag in your head or just before your close body tag. -->
	<!--  Google Maps Plugin    -->
	<!--   <script src="https://maps.googleapis.com/maps/api/js?key=YOUR_KEY_HERE"></script>
 -->
	<!-- Chartist JS -->
	<!--  Notifications Plugin    -->
	<script src="${pageContext.request.contextPath}/js/bootstrap-notify.js"></script>
	<!-- Control Center for Material Dashboard: parallax effects, scripts for the example pages etc -->
	<script
		src="${pageContext.request.contextPath}/js/material-dashboard.js?v=2.1.0"></script>
	<!-- Material Dashboard DEMO methods, don't include it in your project! -->
	<script src="${pageContext.request.contextPath}/js/demo.js"></script>
	<!-- 	extra javaScript file-->
	<script src="${pageContext.request.contextPath}/js/extra/dashboard.js"></script>
	<script >
	$(document).ready(function(){
		$("#msg").text('');
		$("#btnSubmit").click(function(){
			$.ajax({
			    type : "GET",
			    url : "/RestApi/runBatch",
			    success: function(result){
						$("#msg").text(result['message']);			
			    }
			});

			})

	});</script>

</body>

</html>