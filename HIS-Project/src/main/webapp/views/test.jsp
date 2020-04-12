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


<link href="https://cdn.datatables.net/1.10.18/css/dataTables.bootstrap4.min.css" rel="stylesheet">

<!-- Bootstrap core JavaScript-->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Page level plugin JavaScript--><script src="https://cdn.datatables.net/1.10.18/js/jquery.dataTables.min.js"></script>

<script src="https://cdn.datatables.net/1.10.18/js/dataTables.bootstrap4.min.js"></script>

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
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- ***** Breadcumb Area End ***** -->

	<!-- ***** Video Area Start ***** -->
	<section
		class="medilife-video-area section-padding-100 bg-overlay bg-img"
		style="background-image: url/(img/bg-img/video.jpg);">
		<div class="container">
			<div class="row align-items-center">
				<h1>Manage users</h1>
				<table id="dHV"
					class="display table table-striped table-bordered table-hover"
					cellspacing="0" width="100%">
					<thead>
						<tr>
							<th>SNo.</th>
							<th>First Name</th>
							<th>Last Name</th>
							<th>Email</th>
							<th>Role</th>
							<th>Action</th>
							<th>Totle Ad</th>
						</tr>
					</thead>
					<tbody>
						<c:set var="count" value="0" scope="page" />
						<c:forEach var="tempAccount" items="${details}">
							<c:set var="count" value="{count + 1}" scope="page" />
							<!-- init the update link-->
							<c:url var="updateLink" value="/customer/showFormForUpdate">
								<c:param name="customerId" value="${tempAccount.publicId}"></c:param>
							</c:url>
							<!--  end init link-->
							<!-- init the update link-->
							<c:url var="deleteLink" value="/customer/deleteCustomer">
								<c:param name="customerId" value="${tempAccount.publicId}"></c:param>
							</c:url>
							<!--  end init link-->
							<tr>
								<td><c:out value="count" /></td>
								<td>${tempAccount.firstName}</td>
								<td>${tempAccount.lastName}</td>
								<td>${tempAccount.email}</td>
								<td>${tempAccount.roleType}</td>
								<td><a
									href="Admin-full-users"
									title="View Full Details" class="fa fa-desktop"></a>&nbsp;&nbsp;
									<a href="Admin-manage-users"
									title="Delete Record" onclick="return confirm(" Do you want todelete");"><i
										class="fa fa-close"></i></a></td>
								<td><div class="stat-panel-number  text-center">
										
									</div></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		</div>
	</section>
	<!-- ***** Video Area End ***** -->

	<!-- ***** Skilss Area Start ***** -->
	<section class="our-skills-area text-center section-padding-100-0">
		<div class="container">
			<div class="row">
				<div class="col-12 col-sm-6 col-md-3 col-lg-2">
					<div class="single-pie-bar" data-percent="90">
						<canvas class="bar-circle" width="100" height="100"></canvas>
						<h5>Donations</h5>
						<p>Dolor sit amet</p>
					</div>
				</div>
				<div class="col-12 col-sm-6 col-md-3 col-lg-2">
					<div class="single-pie-bar" data-percent="65">
						<canvas class="bar-circle" width="100" height="100"></canvas>
						<h5>Ambition</h5>
						<p>Dolor sit amet</p>
					</div>
				</div>
				<div class="col-12 col-sm-6 col-md-3 col-lg-2">
					<div class="single-pie-bar" data-percent="25">
						<canvas class="bar-circle" width="100" height="100"></canvas>
						<h5>Good Luck</h5>
						<p>Dolor sit amet</p>
					</div>
				</div>
				<div class="col-12 col-sm-6 col-md-3 col-lg-2">
					<div class="single-pie-bar" data-percent="69">
						<canvas class="bar-circle" width="100" height="100"></canvas>
						<h5>High Tech</h5>
						<p>Dolor sit amet</p>
					</div>
				</div>
				<div class="col-12 col-sm-6 col-md-3 col-lg-2">
					<div class="single-pie-bar" data-percent="83">
						<canvas class="bar-circle" width="100" height="100"></canvas>
						<h5>Science</h5>
						<p>Dolor sit amet</p>
					</div>
				</div>
				<div class="col-12 col-sm-6 col-md-3 col-lg-2">
					<div class="single-pie-bar" data-percent="38">
						<canvas class="bar-circle" width="100" height="100"></canvas>
						<h5>Creativity</h5>
						<p>Dolor sit amet</p>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- ***** Skills Area End ***** -->

	<!-- ***** Tabs Area Start ***** -->
	<section class="medilife-tabs-area section-padding-100">
		<div class="container">
			<div class="row">
				<div class="col-12">
					<div class="medilife-tabs-content">
						<ul class="nav nav-tabs" id="myTab" role="tablist">
							<li class="nav-item"><a class="nav-link"
								id="institution-tab" data-toggle="tab" href="#institution"
								role="tab" aria-controls="institution" aria-selected="false">Institution</a>
							</li>
							<li class="nav-item"><a class="nav-link" id="faq-tab"
								data-toggle="tab" href="#faq" role="tab" aria-controls="faq"
								aria-selected="false">FAQ</a></li>
							<li class="nav-item"><a class="nav-link active"
								id="specialities-tab" data-toggle="tab" href="#specialities"
								role="tab" aria-controls="specialities" aria-selected="true">Specialities</a>
							</li>
							<li class="nav-item"><a class="nav-link" id="laboratory-tab"
								data-toggle="tab" href="#laboratory" role="tab"
								aria-controls="laboratory" aria-selected="false">Laboratory</a>
							</li>
							<li class="nav-item"><a class="nav-link"
								id="emergencies-tab" data-toggle="tab" href="#emergencies"
								role="tab" aria-controls="emergencies" aria-selected="false">Emergencies</a>
							</li>
							<li class="nav-item"><a class="nav-link" id="scolarship-tab"
								data-toggle="tab" href="#scolarship" role="tab"
								aria-controls="scolarship" aria-selected="false">Scolarship
									Programs</a></li>
						</ul>

						<div class="tab-content" id="myTabContent">
							<div class="tab-pane fade" id="institution" role="tabpanel"
								aria-labelledby="institution-tab">
								<div class="medilife-tab-content d-md-flex align-items-center">
									<!-- Medilife Tab Text  -->
									<div class="medilife-tab-text">
										<h2>Take a look at this</h2>
										<p>Lorem ipsum dolor sit amet, consectetuer adipiscing
											elit, sed diam nonummy nibh euismod tincidunt ut laoreet
											dolore magna aliquam erat volutpat. Lorem ipsum dolor sit
											amet, consectetuer adipiscing eli. Lorem ipsum dolor sit
											amet, consectetuer adipiscing elit, sed diam nonummy nibh
											euismod tincidunt ut laoreet dolore magna aliquam erat
											volutpat. Lorem ipsum dolor sit amet, consectetuer adipiscing
											eli sed diam nonummy nibh euismod tincidunt ut laoreet dolore
											magna aliquam erat volutpat. Lorem ipsum dolor sit amet,
											consectetuer adipiscing eli.</p>
									</div>
									<!-- Medilife Tab Img  -->
									<div class="medilife-tab-img">
										<img src="${pageContext.request.contextPath}/img/bg-img/about1.jpg" alt="">
									</div>
								</div>
							</div>
							<div class="tab-pane fade" id="faq" role="tabpanel"
								aria-labelledby="faq-tab">
								<div class="medilife-tab-content d-md-flex align-items-center">
									<!-- Medilife Tab Text  -->
									<div class="medilife-tab-text">
										<h2>Take a look at this</h2>
										<p>Lorem ipsum dolor sit amet, consectetuer adipiscing
											elit, sed diam nonummy nibh euismod tincidunt ut laoreet
											dolore magna aliquam erat volutpat. Lorem ipsum dolor sit
											amet, consectetuer adipiscing eli. Lorem ipsum dolor sit
											amet, consectetuer adipiscing elit, sed diam nonummy nibh
											euismod tincidunt ut laoreet dolore magna aliquam erat
											volutpat. Lorem ipsum dolor sit amet, consectetuer adipiscing
											eli sed diam nonummy nibh euismod tincidunt ut laoreet dolore
											magna aliquam erat volutpat. Lorem ipsum dolor sit amet,
											consectetuer adipiscing eli.</p>
									</div>
									<!-- Medilife Tab Img  -->
									<div class="medilife-tab-img">
										<img src="${pageContext.request.contextPath}/img/bg-img/medical1.png" alt="">
									</div>
								</div>
							</div>
							<div class="tab-pane fade show active" id="specialities"
								role="tabpanel" aria-labelledby="specialities-tab">
								<div class="medilife-tab-content d-md-flex align-items-center">
									<!-- Medilife Tab Text  -->
									<div class="medilife-tab-text">
										<h2>Take a look at this</h2>
										<p>Lorem ipsum dolor sit amet, consectetuer adipiscing
											elit, sed diam nonummy nibh euismod tincidunt ut laoreet
											dolore magna aliquam erat volutpat. Lorem ipsum dolor sit
											amet, consectetuer adipiscing eli. Lorem ipsum dolor sit
											amet, consectetuer adipiscing elit, sed diam nonummy nibh
											euismod tincidunt ut laoreet dolore magna aliquam erat
											volutpat. Lorem ipsum dolor sit amet, consectetuer adipiscing
											eli sed diam nonummy nibh euismod tincidunt ut laoreet dolore
											magna aliquam erat volutpat. Lorem ipsum dolor sit amet,
											consectetuer adipiscing eli.</p>
									</div>
									<!-- Medilife Tab Img  -->
									<div class="medilife-tab-img">
										<img src="${pageContext.request.contextPath}/img/bg-img/tab.jpg" alt="">
									</div>
								</div>
							</div>
							<div class="tab-pane fade" id="laboratory" role="tabpanel"
								aria-labelledby="laboratory-tab">
								<div class="medilife-tab-content d-md-flex align-items-center">
									<!-- Medilife Tab Text  -->
									<div class="medilife-tab-text">
										<h2>Take a look at this</h2>
										<p>Lorem ipsum dolor sit amet, consectetuer adipiscing
											elit, sed diam nonummy nibh euismod tincidunt ut laoreet
											dolore magna aliquam erat volutpat. Lorem ipsum dolor sit
											amet, consectetuer adipiscing eli. Lorem ipsum dolor sit
											amet, consectetuer adipiscing elit, sed diam nonummy nibh
											euismod tincidunt ut laoreet dolore magna aliquam erat
											volutpat. Lorem ipsum dolor sit amet, consectetuer adipiscing
											eli sed diam nonummy nibh euismod tincidunt ut laoreet dolore
											magna aliquam erat volutpat. Lorem ipsum dolor sit amet,
											consectetuer adipiscing eli.</p>
									</div>
									<!-- Medilife Tab Img  -->
									<div class="medilife-tab-img">
										<img src="${pageContext.request.contextPath}/img/bg-img/medical1.png" alt="">
									</div>
								</div>
							</div>
							<div class="tab-pane fade" id="emergencies" role="tabpanel"
								aria-labelledby="emergencies-tab">
								<div class="medilife-tab-content d-md-flex align-items-center">
									<!-- Medilife Tab Text  -->
									<div class="medilife-tab-text">
										<h2>Take a look at this</h2>
										<p>Lorem ipsum dolor sit amet, consectetuer adipiscing
											elit, sed diam nonummy nibh euismod tincidunt ut laoreet
											dolore magna aliquam erat volutpat. Lorem ipsum dolor sit
											amet, consectetuer adipiscing eli. Lorem ipsum dolor sit
											amet, consectetuer adipiscing elit, sed diam nonummy nibh
											euismod tincidunt ut laoreet dolore magna aliquam erat
											volutpat. Lorem ipsum dolor sit amet, consectetuer adipiscing
											eli sed diam nonummy nibh euismod tincidunt ut laoreet dolore
											magna aliquam erat volutpat. Lorem ipsum dolor sit amet,
											consectetuer adipiscing eli.</p>
									</div>
									<!-- Medilife Tab Img  -->
									<div class="medilife-tab-img">
										<img src="${pageContext.request.contextPath}/img/bg-img/about1.jpg" alt="">
									</div>
								</div>
							</div>
							<div class="tab-pane fade" id="scolarship" role="tabpanel"
								aria-labelledby="scolarship-tab">
								<div class="medilife-tab-content d-md-flex align-items-center">
									<!-- Medilife Tab Text  -->
									<div class="medilife-tab-text">
										<h2>Take a look at this</h2>
										<p>Lorem ipsum dolor sit amet, consectetuer adipiscing
											elit, sed diam nonummy nibh euismod tincidunt ut laoreet
											dolore magna aliquam erat volutpat. Lorem ipsum dolor sit
											amet, consectetuer adipiscing eli. Lorem ipsum dolor sit
											amet, consectetuer adipiscing elit, sed diam nonummy nibh
											euismod tincidunt ut laoreet dolore magna aliquam erat
											volutpat. Lorem ipsum dolor sit amet, consectetuer adipiscing
											eli sed diam nonummy nibh euismod tincidunt ut laoreet dolore
											magna aliquam erat volutpat. Lorem ipsum dolor sit amet,
											consectetuer adipiscing eli.</p>
									</div>
									<!-- Medilife Tab Img  -->
									<div class="medilife-tab-img">
										<img src="${pageContext.request.contextPath}/img/bg-img/medical1.png" alt="">
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- ***** Tabs Area End ***** -->

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
	<script src="${pageContext.request.contextPath}/js/jquery/jquery.dataTables.min.js"></script>
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