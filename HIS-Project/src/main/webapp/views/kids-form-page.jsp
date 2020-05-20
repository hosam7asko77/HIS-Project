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
		style="background-image: url(/img/bg-img/kidsImage.jpg);">
		<div class="container h-100">
			<div class="row h-100 align-items-center">
				<div class="col-12">
					<div class="breadcumb-content">
						<h3 class="breadcumb-title">Kids Details</h3>
						<p>Add new Kids to Case</p>
						<p>${Msg}</p>
					</div>
				</div>
			</div>
		</div>
	</section>

	<section class="page-wrapper bg-red p-t-180 p-b-100 font-robo">
		<div class="wrapper wrapper--w960" style="margin-top: -10%">
			<div class="card card-2">
				<div class="card-heading"
					style="background: url(/img/bg-img/family3.jpg) top left/cover no-repeat;"></div>
				<div class="card-body">
					<h1 class="title" style="margin-top: -10%">Add new Child</h1>
					<br>
					<div class="medilife-appointment-form align-center">
						<form:form id="kidsform" action="/DC/${processHandel}"
							method="post" modelAttribute="kidsDetails">
							<h3 class="title">Case Number : ${caseNumber}</h3>
							<form:hidden path="childId" />
							<form:hidden path="caseNumber" value="${caseNumber}" />
							<div class="input-group">
								<form:input path="childName"
									cssClass="form-control form-control border-top-0 border-right-0 border-left-0"
									id="childName" placeholder="Child Name" />
							</div>
							<div class="input-group">
								<div class="input-group-icon">
									<i class="zmdi zmdi-calendar-note input-icon js-btn-calendar"></i>
									<form:input path="dob"
										cssClass="input--style-4 js-datepicker form-control border-top-0 border-right-0 border-left-0"
										placeholder="Date of barth" />
								</div>
							</div>
							<div class="input-group">
								<h5 style="margin-bottom: 20px; margin-left: -5px;">Gender</h5>
								<div class="row row-space">
									<div class="col-co-2">
										<div class="input-group">
											<span style="font-size: 15px; color: white">Male</span>
											<form:radiobutton path="gender" value="Male"
												placeholder="Male" />
										</div>
									</div>
									<div class="col-co-2">
										<div class="input-group">
											<span style="font-size: 15px; color: white">Female</span>
											<form:radiobutton path="gender" value="Female" />
										</div>
									</div>
								</div>
							</div>
							<div class="input-group">
								<form:input path="ssn"
									cssClass="form-control form-control border-top-0 border-right-0 border-left-0"
									id="ssn" placeholder="Child SSN Number" maxlength="12" />
								<span id="ssnMsg" style="color: red;"></span>
							</div>
							<div class="col-12 col-md-5 mb-0">
								<div class="form-group mb-0">
									<input type="submit" class="btn  btn-primary" value="Add Child">
								</div>
							</div>
						</form:form>
					</div>
					<div class="panel panel-default" style="margin-top: 16%">
						<div class="panel-heading">All Kids Details</div>
						<div class="panel-body">
							<table id="dHV"
								class="display table table-striped table-bordered table-hover"
								cellspacing="0" width="100%">
								<thead>
									<tr>
										<th>SNo.</th>
										<th>Child Name</th>
										<th>Date of Birth</th>
										<th>Gender</th>
										<th>SSN</th>
										<th>Action</th>
									</tr>
								</thead>
								<tbody>
									<c:set var="count" value="0" scope="page" />
									<c:forEach var="tempKids" items="${kidsDetailsList}">
										<c:set var="count" value="${count + 1}" scope="page" />
										<!-- init the update link-->
										<c:choose>
										<c:when test="${processHandel =='processKidsForm'}">processEditKids
										<c:set var="formChoise" value="processKidsForm" scope="page" />
										</c:when>
										<c:when test="${processHandel =='processEditKids'}">
										<c:set var="formChoise" value="processEditKids" scope="page" />
										</c:when>
										</c:choose>
										<c:url var="updateLink" value="/DC/updateKids">
											<c:param name="childId" value="${tempKids.childId}"></c:param>

											<c:param name="from" value="${formChoise}"></c:param>
											<c:param name="caseNumber" value="${caseNumber}"></c:param>
										</c:url>
										<!--  end init link-->
										<!-- init the update link-->
										<c:url var="deleteLink" value="/DC/deleteKids">
											<c:param name="childId" value="${tempKids.childId}"></c:param>
											<c:param name="from" value="${formChoise}"></c:param>
											<c:param name="caseNumber" value="${caseNumber}"></c:param>
										</c:url>
										<!--  end init link-->
										<tr>
											<td>${count}</td>
											<td>${tempKids.childName}</td>
											<td>${tempKids.dob}</td>
											<td>${tempKids.gender}</td>
											<td>${tempKids.ssn}</td>
											<td><a href="${updateLink}" title="Update Plan Details"
												class="fa fa-edit"></a>&nbsp;&nbsp;&nbsp;&nbsp; <a
												href="${deleteLink}" title="Delete Child"><i
													class="fa fa-trash-o" style="color: red;"></i></a></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
					<c:if test="${processHandel =='processKidsForm'}">

						<div class="float-sm-left">
							<a href="/DC/showFamilyForm?caseNumber=${caseNumber}"
								class="btn btn-danger" type="submit"><span
								class="fa fa-long-arrow-left"></span>&nbsp;Back</a>
						</div>
						<c:if test="${kidsDetailsList.size() > 0}">
							<div class="float-sm-right">
								<a href="/DC/showJobForm?caseNumber=${caseNumber}${backTo}"
									class="btn btn-success">Next&nbsp;<span
									class="fa fa-arrow-right"></span></a>
							</div>
						</c:if>
					</c:if>
					<c:if test="${processHandel =='processEditKids'}">
						<div class="float-sm-right">
							<a
								href="/DC/showCaseCreated?caseNumber=${caseDetails.caseNumber}"
								class="btn btn-success">Done</a>
						</div>
					</c:if>
				</div>
			</div>
		</div>
	</section>

	<br>
	<br>

	<!-- ***** Footer Area Start ***** -->
	<%@include file="footer.jsp"%>
	<!-- ***** Footer Area End ***** -->

	<!-- jQuery (Necessary for All JavaScript Plugins) -->
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
	<script src="${pageContext.request.contextPath}/js/global.js"></script>
	<script src="${pageContext.request.contextPath}/js/extra/kids.js"></script>

</body>
</html>