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
<style type="text/css">
.error {
	border:;
	color: red;
	min-height: 20px;
	background-color: #808080;
	border-radius: 10px;
}
</style>

</head>

<body>

	<%@ include file="header.jsp"%>
	<!-- ***** Header Area Start ***** -->
	<!-- ***** Breadcumb Area Start ***** -->
	<section class="breadcumb-area bg-img gradient-background-overlay"
		style="background-image: url(/img/bg-img/crime-report.jpg);">
		<div class="container h-100">
			<div class="row h-100 align-items-center">
				<div class="col-12">
					<div class="breadcumb-content">
						<h3 class="breadcumb-title">Family Details</h3>
						<p>Add Family Details</p>
					</div>
				</div>
			</div>
		</div>
	</section>
	<div class="page-wrapper bg-red p-t-180 p-b-100 font-robo">
		<div class="wrapper wrapper--w960" style="margin-top: -10%">
			<div class="card card-2">
				<div class="card-heading"
					style="background: url(/img/bg-img/family3.jpg) top left/cover no-repeat;"></div>
				<div class="card-body">
					<h1 class="title" style="margin-top: -10%">Add Crime Details</h1>
					<br>

					<form:form action="/DC/${processHandel}" method="post"
						modelAttribute="crimeDetails" enctype="multipart/form-data"
						id="crimeForm">
						<h3 class="title">Case Number : ${caseNumber}</h3>
						<form:hidden path="crimeId" />
						<br>
						<form:hidden path="caseNumber" value="${caseNumber}" />
						<div class="input-group">
							<br> <label style="font-size: 15px" for="incidentType">Incident
								Type</label> <br> Collision
							<form:checkbox path="incidentType" value="Collision"
								cssStyle="cursor: pointer;" />
							Theft
							<form:checkbox path="incidentType" value="Theft"
								cssStyle="cursor: pointer;" />
							Fraud
							<form:checkbox path="incidentType" value="Fraud"
								cssStyle="cursor: pointer;" />
							Crime
							<form:checkbox path="incidentType" value="Crime"
								cssStyle="cursor: pointer;" />
							<span id="errorMsg"></span>
						</div>
						<div class="input-group">
							<div class="input-group-icon">
								<i class="zmdi zmdi-calendar-note input-icon js-btn-calendar"
									style="color: white;"></i>
								<form:input path="incidentDate" id="incidentDate"
									cssStyle="cursor: pointer;"
									cssClass="input--style-4 js-datepicker form-control border-top-0 border-right-0 border-left-0"
									placeholder="Date when  you witnessed the incident" />
								<!-- 									<div class="error-msg"></div>
 -->
							</div>
						</div>
						<div class="input-group">
							<label style="font-size: 15px">Location of the incident</label>
							<div class="input-group">
								<form:input path="incidentStreet"
									cssClass="form-control form-control border-top-0 border-right-0 border-left-0"
									placeholder="Street Address" id="incidentStreet" />
							</div>
							<div class="input-group">
								<form:input path="incidentCity"
									cssClass="form-control form-control border-top-0 border-right-0 border-left-0"
									placeholder="City" id="incidentCity" />
							</div>
							<div class="input-group">
								<form:input path="incidentState"
									cssClass="form-control form-control border-top-0 border-right-0 border-left-0"
									placeholder="State" id="incidentState" />
							</div>
							<div class="input-group">
								<form:textarea path="incidentDescribe"
									cssClass="form-control form-control border-top-0 border-right-0 border-left-0"
									id="incidentDescribe" placeholder="Please descibe the incident" />
							</div>
						</div>
						<div class="input-group">
							<form:input path="peopelInvolved"
								cssClass="form-control form-control border-top-0 border-right-0 border-left-0"
								id="peopelInvolved" placeholder="How many people were involved" />
						</div>
						<div class="input-group">
							<span>Choose Report File</span>
							<div class="custom-file mb-3">
								<form:input path="crimeReport" type="file"
									cssStyle="background-color: #4ea5ff;border-radius: 10px;"
									value="upload report" id="custom-file" />
							</div>
						</div>

						<div class="float-sm-right">
							<input class="btn btn--radius btn--green" type="submit"
								value="Next >">
						</div>
						<c:if test="${processHandel=='processCrimeForm'}">
							<div class="float-sm-left">
								<a href="/DC/showJobForm?caseNumber=${caseNumber}${backTo}"
									class="btn btn-danger"><span class="fa fa-long-arrow-left"></span>&nbsp;Back</a>
							</div>
						</c:if>
					</form:form>
				</div>
			</div>
		</div>
	</div>



	<!-- ***** Footer Area Start ***** -->
	<%@include file="footer.jsp"%>
	<!-- ***** Footer Area End ***** -->

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
	<script src="${pageContext.request.contextPath}/js/extra/crime.js"></script>
</body>
</html>