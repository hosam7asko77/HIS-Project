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
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/font-awesome-4.7/css/font-awesome.min.css">
<!-- CSS Files -->
<link
	href="${pageContext.request.contextPath}/css/material-dashboard.css?v=2.1.0"
	rel="stylesheet" />
<!-- CSS Just for demo purpose, don't include it in your project -->
<link href="${pageContext.request.contextPath}/css/demo.css"
	rel="stylesheet" />
<link href="${pageContext.request.contextPath}/css/table.css"
	rel="stylesheet" />
<link
	href="${pageContext.request.contextPath}/css/jquery.dataTables.min.css"
	rel="stylesheet" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/style.css">

</head>

<body class="dark-edition">
	<c:set var="publicUserId" value="${sessionScope['PUBLIC_ID_SESSION']}"></c:set>
	<div class="wrapper ">
		<%@include file="sidebar.jsp"%>
		<div class="main-panel">
			<%@include file="header.jsp"%>
			<div class="content">
				<div class="container-fluid">
					<div class="row">
						<div class="col-xl-4 col-lg-12">
							<div class="card card-chart">
								<div class="card-header card-header-success">
									<div class="ct-chart" id="dailySalesChart"></div>
								</div>
								<div class="card-body">
									<h4 class="card-title">Daily Sales</h4>
									<p class="card-category">
										<span class="text-success"><i
											class="fa fa-long-arrow-up"></i> 55% </span> increase in today
										sales.
									</p>
								</div>
								<div class="card-footer">
									<div class="stats">
										<i class="material-icons">access_time</i> updated 4 minutes
										ago
									</div>
								</div>
							</div>
						</div>
						<div class="col-xl-4 col-lg-12">
							<div class="card card-chart">
								<div class="card-header card-header-warning">
									<div class="ct-chart" id="websiteViewsChart"></div>
								</div>
								<div class="card-body">
									<h4 class="card-title">Email Subscriptions</h4>
									<p class="card-category">Last Campaign Performance</p>
								</div>
								<div class="card-footer">
									<div class="stats">
										<i class="material-icons">access_time</i> campaign sent 2 days
										ago
									</div>
								</div>
							</div>
						</div>
						<div class="col-xl-4 col-lg-12">
							<div class="card card-chart">
								<div class="card-header card-header-danger">
									<div class="ct-chart" id="completedTasksChart"></div>
								</div>
								<div class="card-body">
									<h4 class="card-title">Completed Tasks</h4>
									<p class="card-category">Last Campaign Performance</p>
								</div>
								<div class="card-footer">
									<div class="stats">
										<i class="material-icons">access_time</i> campaign sent 2 days
										ago
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-xl-3 col-lg-6 col-md-6 col-sm-6">
							<div class="card card-stats">
								<div class="card-header card-header-warning card-header-icon">
									<div class="card-icon">
										<i class="material-icons">content_copy</i>
									</div>
									<p class="card-category">No Of Apps</p>
									<h3 class="card-title">
										${appNo} <small>App</small>
									</h3>
								</div>
								<div class="card-footer">
									<div class="stats">
										<i class="material-icons text-warning">warning</i> <a
											href="#pablo" class="warning-link">Get More Info</a>
									</div>
								</div>
							</div>
						</div>
						<div class="col-xl-3 col-lg-6 col-md-6 col-sm-6">
							<div class="card card-stats">
								<div class="card-header card-header-success card-header-icon">
									<div class="card-icon">
										<i class="material-icons">store</i>
									</div>
									<p class="card-category">No Of Case</p>
									<h3 class="card-title">${caseNo}</h3>
								</div>
								<div class="card-footer">
									<div class="stats">
										<i class="material-icons text-warning">warning</i> <a
											href="#pablo" class="warning-link">Get More Info</a>
									</div>
								</div>
							</div>
						</div>
						<div class="col-xl-3 col-lg-6 col-md-6 col-sm-6">
							<div class="card card-stats">
								<div class="card-header card-header-danger card-header-icon">
									<div class="card-icon">
										<i class="material-icons">info_outline</i>
									</div>
									<p class="card-category">No Of Case Denial</p>
									<h3 class="card-title">${elgDnNo}</h3>
								</div>
								<div class="card-footer">
									<div class="stats">
										<i class="material-icons">local_offer</i> Tracked from Github
									</div>
								</div>
							</div>
						</div>
						<div class="col-xl-3 col-lg-6 col-md-6 col-sm-6">
							<div class="card card-stats">
								<div class="card-header card-header-info card-header-icon">
									<div class="card-icon">
										<i class="fa fa-trash-o"></i>
									</div>
									<p class="card-category">No of Case Approved</p>
									<h3 class="card-title">${elgApNo}</h3>
								</div>
								<div class="card-footer">
									<div class="stats">
										<i class="material-icons">update</i> Just Updated
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-lg-6 col-md-12">
							<div class="card">
								<div class="card-header card-header-primary">
									<h4 class="card-title" style="margin-top: 3%">Employees
										Stats</h4>
									<p class="card-category">List of employees</p>
								</div>
								<div class="card-body table-responsive">
									<table id="example" class="hover" style="width: %100;">
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
												<tr style="background-color: transparent;">
													<td>${count}</td>
													<td>${tempAccount.firstName}</td>
													<td>${tempAccount.lastName}</td>
													<td>${tempAccount.email}</td>
													<td>${tempAccount.roleType}</td>
													<td><a href="${updateLink}" title="View Full Details"
														class="fa fa-edit"></a>&nbsp;&nbsp;&nbsp;&nbsp; <c:choose>
															<c:when test="${tempAccount.activeSwitch == 'N'}">
																<a href="${activeLink}" title="chang to active"><i
																	class="fa fa-exchange" style="color: green;"></i></a>
															</c:when>
															<c:when test="${tempAccount.activeSwitch == 'Y'}">
																<a href="${inActiveLink}" title="chang to Unactive"><i
																	class="fa fa-trash-o" style="color: red;"></i></a>
															</c:when>
														</c:choose></td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
							</div>
						</div>
						<div class="col-lg-6 col-md-12">
							<div class="card">
								<div class="card-header card-header-tabs card-header-warning">
									<div class="nav-tabs-navigation">
										<div class="nav-tabs-wrapper">
											<span class="nav-tabs-title">Plan:</span>
											<ul class="nav nav-tabs" data-tabs="tabs">
												<li class="nav-item"><a class="nav-link active"
													href="#addPaln" data-toggle="tab"> <i
														class="fa fa-th-list"></i>&nbsp;&nbsp;Add Plan
														<div class="ripple-container"></div>
												</a></li>
												<li class="nav-item"><a class="nav-link" href="#manage"
													data-toggle="tab"> <i class="fa fa-wrench"></i>
														&nbsp;&nbsp;Manage Plan
														<div class="ripple-container"></div>
												</a></li>
												<li class="nav-item"><a class="nav-link"
													href="#settings" data-toggle="tab"> <i
														class="fa fa-search"></i>&nbsp;&nbsp;Search Plan
														<div class="ripple-container"></div>
												</a></li>
											</ul>
										</div>
									</div>
								</div>
								<div class="card-body">
									<div class="tab-content">
										<div class="tab-pane active" id="addPaln">
											<form:form action="/Admin/planFormProcess"
												modelAttribute="planDetails" id="planForm" method="POST">
												<form:hidden path="publicId" value="${publicUserId}" />
												<div class="form-group">
													<div class="form-group">
														<label class="bmd-label-floating">Plan Name</label>
														<form:input path="planName"
															cssClass="form-control border-top-0 border-right-0 border-left-0" />
													</div>
													<div class="form-group">
														<label class="bmd-label-floating">Description</label>
														<form:textarea path="discript"
															cssClass="form-control border-top-0 border-right-0 border-left-0" />
													</div>
													<div class="form-group">
														<label class="bmd-label-floating">Plan Start Date</label>
														<form:input path="startDate" id="startDate"
															cssClass="form-control border-top-0 border-right-0 border-left-0" />
													</div>
													<div class="form-group">
														<label class="bmd-label-floating">End Date</label>
														<form:input path="endDate" id="endDate"
															cssClass="form-control border-top-0 border-right-0 border-left-0 " />
													</div>
												</div>
												<div class="col-12 col-md-5 mb-0">
													<div class="form-group mb-0">
														<button type="submit" class="btn btn-success">
															Create Plan <span>+</span>
														</button>
													</div>
												</div>

											</form:form>
										</div>
										<div class="tab-pane" id="manage">
											<div class="card-body table-responsive">
												<table id="example-1" class="hover" style="width: %100;">
													<thead class="text-warning">
														<tr>
															<th>SNo.</th>
															<th>Plan Name</th>
															<th>Plan Description</th>
															<th>Start Date</th>
															<th>End Date</th>
															<th>Action</th>
														</tr>
													</thead>
													<tbody>
														<c:set var="count" value="0" scope="page" />
														<c:forEach var="tempPlan" items="${plans}">
															<c:set var="count" value="${count + 1}" scope="page" />
															<!-- init the delete link-->
															<c:url var="deleteLink" value="/Admin/deletePlan">
																<c:param name="planId" value="${tempPlan.planId}"></c:param>
															</c:url>
															<!--  end init link-->
															<tr style="background-color: transparent;">
																<td>${count}</td>
																<td>${tempPlan.planName}</td>
																<td>${tempPlan.discript}</td>
																<td>${tempPlan.startDate}</td>
																<td>${tempPlan.endDate}</td>
																<td>&nbsp;&nbsp;<a href="${deleteLink}"
																	title="Delete Plan"><i class="fa fa-trash-o"
																		style="color: red;"></i></a></td>
															</tr>
														</c:forEach>
													</tbody>
												</table>
											</div>
										</div>
										<div class="tab-pane" id="settings">

											<form id="getPlan" method="get">
												<div class="input-group no-border">
													<input type="text" value=""
														class="form-control border-top-0 border-right-0 border-left-0"
														placeholder="Enter Plan Name For Search..."
														id="searchPlan">
													<button type="submit" class="btn btn-round" id="btnSearch">
														<i class="fa fa-search"></i>
														<div class="ripple-container"></div>
													</button>
												</div>
												<span id="errorMsg" style="color: red;"></span>
											</form>
											<p class="card-category">Plan Details</p>
											<form:form action="/Admin/updatePlanFormProcess"
												modelAttribute="planDetails" method="POST"
												id="search-contenar">
												<div class="form-group">
													<form:hidden path="planId" id="up-planId" />
													<form:hidden path="publicId" value="${publicUserId}" />
													<div class="form-group">

														<form:input path="planName" id="up-planName"
															cssClass="form-control border-top-0 border-right-0 border-left-0" />
													</div>
													<div class="form-group">

														<form:textarea path="discript" id="up-planDiscript"
															cssClass="form-control border-top-0 border-right-0 border-left-0" />
													</div>
													<div class="form-group">

														<form:input path="startDate" id="up-palnStartDate"
															cssClass="form-control border-top-0 border-right-0 border-left-0" />
													</div>
													<div class="form-group">

														<form:input path="endDate" id="up-planEndDate"
															cssClass="form-control border-top-0 border-right-0 border-left-0 " />
													</div>
												</div>
												<div class="col-12 col-md-5 mb-0">
													<div class="form-group mb-0">
														<button type="submit" class="btn btn-warning">
															Update Plan&nbsp;<i class="fa fa-edit"></i>
														</button>
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
		</div>
		<%@include file="footer.jsp"%>
	</div>
	</div>
	<%@ include file="settings.jsp"%>
	<!--   Core JS Files   -->
	<script
		src="${pageContext.request.contextPath}/js/jquery/jquery-3.5.1.js"></script>
	<script src="${pageContext.request.contextPath}/js/popper.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/js/bootstrap-material-design.min.js"></script>
	<script src="https://unpkg.com/default-passive-events"></script>
	<script
		src="${pageContext.request.contextPath}/js/datepicker/js/gijgo.min.js"
		type="text/javascript"></script>
	<script
		src="${pageContext.request.contextPath}/js/jquery/jquery.validate.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/js/jquery/additional-methods.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/js/jquery/jquery.dataTables.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/js/perfect-scrollbar.jquery.min.js"></script>
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
	<script src="${pageContext.request.contextPath}/js/table.js"></script>
</body>

</html>