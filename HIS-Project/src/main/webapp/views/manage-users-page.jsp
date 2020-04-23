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
										<li class="nav-item active"><a class="nav-link"
											href="about-us.html">About Us</a></li>
										<li class="nav-item"><a class="nav-link"
											href="services.html">Services</a></li>
										<li class="nav-item"><a class="nav-link" href="blog.html">News</a>
										</li>
										<li class="nav-item"><a class="nav-link"
											href="contact.html">Contact</a></li>
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
		style="background-image: url(/img/bg-img/breadcumb1.jpg);">
		<div class="container h-100">
			<div class="row h-100 align-items-center">
				<div class="col-12">
					<div class="breadcumb-content">
						<h3 class="breadcumb-title">View Accounts</h3>
						<p>All Accounts Details</p>
						<p>${Msg}</p>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- ***** Breadcumb Area End ***** -->

	<!-- ***** Video Area Start ***** -->
	<section
		class="medilife-video-area section-padding-100 bg-overlay bg-img">
		<div class="container">
			<div class="row h-100 align-items-center">
				<div class="col-md-12">
					<div class="panel panel-default">
						<div class="panel-heading">All Account Details</div>
						<div class="panel-body">
							<table id="dHV"
								class="display table table-striped table-bordered table-hover"
								cellspacing="0" width="100%" >
								<thead>
									<tr>
										<th>SNo.</th>
										<th>First Name</th>
										<th>Last Name</th>
										<th>Email</th>
										<th>Role</th>
										<th>Action</th>
									</tr>
								</thead>
								<tbody>
									<c:set var="count" value="0" scope="page" />
									<c:forEach var="tempAccount" items="${details}">
										<c:set var="count" value="${count + 1}" scope="page" />
										<!-- init the update link-->
										<c:url var="updateLink" value="/Admin/showFormForUpdate">
											<c:param name="publicId" value="${tempAccount.publicId}"></c:param>
										</c:url>
										<!--  end init link-->
										<!-- init the update link-->
										<c:url var="inActiveLink" value="/Admin/makeInactive">
											<c:param name="publicId" value="${tempAccount.publicId}"></c:param>
										</c:url>
										<c:url var="activeLink" value="/Admin/makeActive">
											<c:param name="publicId" value="${tempAccount.publicId}"></c:param>
										</c:url>
										<!--  end init link-->
										<tr>
											<td>${count}</td>
											<td>${tempAccount.firstName}</td>
											<td>${tempAccount.lastName}</td>
											<td>${tempAccount.email}</td>
											<td>${tempAccount.roleType}</td>
											<td><a href="${updateLink}" title="View Full Details"
												class="fa fa-edit"></a>&nbsp;&nbsp;&nbsp;&nbsp; 
											<c:choose>
													<c:when test="${tempAccount.activeSwitch == 'N'}">
														<a href="${activeLink}" title="chang to active"
															onclick="return confirm("Doyouwanttodelete");"><i
															class="fa fa-exchange" style="color: green;"></i></a></td>
											</c:when>
											<c:when test="${tempAccount.activeSwitch == 'Y'}">
												<a href="${inActiveLink}" title="chang to Unactive"
													onclick="return confirm("Doyouwanttodelete");"><i
													class="fa fa-trash-o" style="color: red;"></i></a>
												</td>
											</c:when>
											</c:choose>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>

	</section>
	<!-- ***** Table Area End ***** -->

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
	<script
		src="${pageContext.request.contextPath}/js/jquery/jquery.dataTables.min.js"></script>
	<!-- Popper js -->
	<script src="${pageContext.request.contextPath}/js/popper.min.js"></script>
	<!-- Bootstrap js -->
	<script
		src="${pageContext.request.contextPath}/js/dataTables.bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
	<!-- Plugins js -->
	<script src="${pageContext.request.contextPath}/js/plugins.js"></script>
	<!-- Active js -->
	<script src="${pageContext.request.contextPath}/js/active.js"></script>
	<script src="${pageContext.request.contextPath}/js/table.js"></script>

</body>

</html>