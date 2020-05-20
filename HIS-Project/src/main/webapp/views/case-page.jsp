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
		style="background-image: url(/img/bg-img/breadcumb3.jpg);">
		<div class="container h-100">
			<div class="row h-100 align-items-center">
				<div class="col-12">
					<div class="breadcumb-content">
						<h3 class="breadcumb-title">User Registration Details</h3>
						<p>Add new user to application</p>
						<p>${Msg}</p>
					</div>
				</div>
			</div>
		</div>
	</section>

	    <div class="page-wrapper bg-red p-t-180 p-b-100 font-robo">
        <div class="wrapper wrapper--w960">
            <div class="card card-2">
                <div class="card-heading" style="background: url(/img/bg-img/family.png) top left/cover no-repeat;"></div>
                <div class="card-body">
                    <h2 class="title">Registration Info</h2>
                    <form method="POST">
                        <div class="input-group">
                            <input cssClass="input--style-2" type="text" placeholder="Name" name="name">
                        </div>
                        <div class="row row-space">
                            <div class="col-2">
                                <div class="input-group">
                                    <input class="input--style-2 js-datepicker" type="text" placeholder="Birthdate" name="birthday">
                                    <i class="zmdi zmdi-calendar-note input-icon js-btn-calendar"></i>
                                </div>
                            </div>
                            <div class="col-2">
                                <div class="input-group">
                                    <div class="rs-select2 js-select-simple select--no-search">
                                        <select name="gender">
                                            <option disabled="disabled" selected="selected">Gender</option>
                                            <option>Male</option>
                                            <option>Female</option>
                                            <option>Other</option>
                                        </select>
                                        <div class="select-dropdown"></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="input-group">
                            <div class="rs-select2 js-select-simple select--no-search">
                                <select name="class">
                                    <option disabled="disabled" selected="selected">Class</option>
                                    <option>Class 1</option>
                                    <option>Class 2</option>
                                    <option>Class 3</option>
                                </select>
                                <div class="select-dropdown"></div>
                            </div>
                        </div>
                        <div class="row row-space">
                            <div class="col-2">
                                <div class="input-group">
                                    <input class="input--style-2" type="text" placeholder="Registration Code" name="res_code">
                                </div>
                            </div>
                        </div>
                        <div class="p-t-30">
                            <button class="btn btn--radius btn--green" type="submit">Search</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
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
	<script src="${pageContext.request.contextPath}/js/select2.min.js"></script>

</body>
</html>