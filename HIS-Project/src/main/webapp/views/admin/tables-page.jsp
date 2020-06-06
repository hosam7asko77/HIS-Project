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
	href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css">
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
	<div class="wrapper ">
		<%@include file="sidebar.jsp"%>
		<div class="main-panel">
			<%@include file="header.jsp"%>
			<div class="content">
				<div class="container-fluid">
					<div class="row">
						<div class="col-md-12">
							<div class="card">
								<div class="card-header card-header-primary">
									<h4 class="card-title ">Case Table</h4>
									<p class="card-category">Here is a Case for this table</p>
								</div>
								<div class="card-body">
									<div class="table-responsive">
										<table id="example" class="hover" style="width: %100;">
											<thead class="text-primary">
												<tr>
													<th>SNo.</th>
													<th>Case Number</th>
													<th>AR No</th>
													<th>User ID</th>
													<th>Action</th>
												</tr>
											</thead>
											<tbody>
												<c:set var="count" value="0" scope="page" />
												<c:forEach var="tempCase" items="${cases}">
													<c:set var="count" value="${count + 1}" scope="page" />
													<!-- init the update link-->
													<c:url var="moreDetails" value="/DC/moreDetails">
														<c:param name="caseNumber" value="${tempCase.caseNumber}"></c:param>
													</c:url>
													<!-- init the update link-->
													<c:url var="DeleteLink" value="/DC/deleteCase">
														<c:param name="caseNumber" value="${tempCase.caseNumber}"></c:param>
													</c:url>
													<!--  end init link-->
													<tr style="background-color: transparent;">
														<td>${count}</td>
														<td>${tempCase.caseNumber}</td>
														<td>${tempCase.appRegister}</td>
														<td>${tempCase.userId}</td>
														<td><a href="${moreDetails}"
															title="View Full Details" class="fa fa-info"></a>&nbsp;&nbsp;&nbsp;&nbsp;
															<a href="${DeleteLink}" title="Delete Case"><i
																class="fa fa-trash-o" style="color: red;"></i></a></td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
									</div>
								</div>
							</div>
						</div>
						<div class="col-md-12">
							<div class="card">
								<div class="card-header card-header-primary">
									<h4 class="card-title mt-0">Applications Table</h4>
									<p class="card-category">Here is a Applications for this
										table</p>
								</div>
								<div class="card-body">
									<div class="table-responsive">
										<table id="example-1" class="hover" style="width: %100;">
											<thead class="text-primary">
												<tr>
													<th>SNo.</th>
													<th>AR No</th>
													<th>First Name</th>
													<th>Last Name</th>
													<th>Email</th>
													<th>SSN</th>
													<th>Gender</th>
													<th>Phone</th>
													<th>Action</th>
												</tr>
											</thead>
											<tbody>
												<c:set var="count" value="0" scope="page" />
												<c:forEach var="tempApp" items="${applications}">
													<c:set var="count" value="${count + 1}" scope="page" />
													<!-- init the update link-->
													<c:url var="updateLink" value="/AppRegister/showUpdateForm">
														<c:param name="appId" value="${tempApp.appId}"></c:param>
													</c:url>
													<!--  end init link-->
													<!-- init the update link-->
													<c:url var="DeleteLink" value="/AppRegister/deleteApp">
														<c:param name="appId" value="${tempApp.appId}"></c:param>
													</c:url>
													<c:url var="UndoDeleteLink"
														value="/AppRegister/undoDeleteApp">
														<c:param name="appId" value="${tempApp.appId}"></c:param>
													</c:url>
													<!--  end init link-->
													<tr style="background-color: transparent;">
														<td>${count}</td>
														<td>${tempApp.appId}</td>
														<td>${tempApp.firstName}</td>
														<td>${tempApp.lastName}</td>
														<td>${tempApp.email}</td>
														<td>${tempApp.ssn}</td>
														<td>${tempApp.gender}</td>
														<td>${tempApp.phoneNumber}</td>
														<td><a href="${updateLink}" title="View Full Details"
															class="fa fa-edit"></a>&nbsp;&nbsp;&nbsp;&nbsp; <c:choose>
																<c:when test="${tempApp.deleteStatus == true}">
																	<a href="${UndoDeleteLink}"
																		title="Retreive Application"><i
																		class="fa fa-exchange" style="color: green;"></i></a>
																</c:when>
																<c:when test="${tempApp.deleteStatus == false}">
																	<a href="${DeleteLink}" title="Delete Application"><i
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
						</div>
						<div class="col-md-12">
							<div class="card">
								<div class="card-header card-header-primary">
									<h4 class="card-title mt-0">Elg Table</h4>
									<p class="card-category">Here is a Elgs for this table</p>
								</div>
								<div class="card-body">
									<div class="table-responsive">
										<table id="example-2" class="hover" style="width: %100;">
											<thead class=" text-primary">
												<tr>
													<th>SNo.</th>
													<th>Case Number</th>
													<th>Plan Name</th>
													<th>Plan Status</th>
													<th>Plan Start Date</th>
													<th>Plan End Date</th>
													<th>Benefit Amount</th>
													<th>Denial Reson</th>
													<th>Action</th>
												</tr>
											</thead>
											<tbody>
												<c:set var="count" value="0" scope="page" />
												<c:forEach var="tempElg" items="${elgs}">
													<c:set var="count" value="${count + 1}" scope="page" />
													<!-- init the update link-->
													<c:url var="DeleteLink" value="/Admin/deleteElg">
														<c:param name="appId" value="${tempElg.edTraceId}"></c:param>
													</c:url>
													<!--  end init link-->
													<tr style="background-color: transparent;">
														<td>${count}</td>
														<td>${tempElg.caseNumber}</td>
														<td>${tempElg.planName}</td>
														<td>${tempElg.planStatus}</td>
														<c:choose>
															<c:when test="${tempElg.planStartDate!=null}">
																<td>${tempElg.planStartDate}</td>
															</c:when>
															<c:when test="${tempElg.planStartDate==null}">
																<td>None</td>
															</c:when>
														</c:choose>
														<c:choose>
															<c:when test="${tempElg.planEndDate!=null}">
																<td>${tempElg.planEndDate}</td>
															</c:when>
															<c:when test="${tempElg.planEndDate==null}">
																<td>None</td>
															</c:when>
														</c:choose>
														<c:choose>
															<c:when test="${tempElg.benefitAmount!=null}">
																<td>${tempElg.benefitAmount}</td>
															</c:when>
															<c:when test="${tempElg.benefitAmount==null}">
																<td>None</td>
															</c:when>
														</c:choose>
														<td>${tempElg.denialReson}</td>
														<td>&nbsp;&nbsp; <a href="${DeleteLink}"
															title="Delete Application"><i class="fa fa-trash-o"
																style="color: red;"></i></a></td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
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