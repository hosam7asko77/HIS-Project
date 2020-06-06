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

	<%@ include file="header.jsp"%>
	<!-- ***** Header Area Start ***** -->
	<!-- ***** Breadcumb Area Start ***** -->
	<section class="breadcumb-area bg-img gradient-background-overlay"
		style="background-image: url(/img/bg-img/Inaurance.jpg);">
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
					<h1 class="title" style="margin-top: -10%">Add Job Details</h1>
					<br>
					<form:form action="/DC/${processHandel}"
						modelAttribute="jobDetails" id="jobform">
						<h3 class="title">Case Number : ${caseNumber}</h3>
						<form:hidden path="jobId" />
						<br>
						<form:hidden path="caseNumber" value="${caseNumber}" />
						<div class="form-group">
							<form:input path="occupation"
								cssClass="form-control form-control border-top-0 border-right-0 border-left-0"
								id="occupation" placeholder="Occupation" />
						</div>
						<div class="form-group">
							<form:input path="orgName"
								cssClass="form-control form-control border-top-0 border-right-0 border-left-0"
								id="orgName" placeholder="Orginaizetion Name" />
						</div>

						<div class="form-group">
							<h5 style="margin-bottom: 20px; margin-left: -5px;">Job Type</h5>
							<div class="row row-space">
								<div class="col-co-2">
									<div class="input-group">
										<span style="font-size: 15px; color: white">Full time</span>
										<form:radiobutton path="jobType" value="full time" />
									</div>
								</div>
								<div class="col-co-2">
									<div class="input-group">
										<span style="font-size: 15px; color: white">Part time</span>
										<form:radiobutton path="jobType" value="part time" />
									</div>
								</div>
							</div>
						</div>
						<div class="input-group">
							<form:input path="jobPosition"
								cssClass="form-control form-control border-top-0 border-right-0 border-left-0"
								id="jobPosition" placeholder="Job Position" />
						</div>
						<div class="form-group">
							<form:input path="startJob" id="datepicker"
								cssClass="form-control border-top-0 border-right-0 border-left-0"
								placeholder="Started Job Date" />
						</div>
						<div class="row row-space">
							<div class="col-co-2">
								<div class="input-group">
									<form:input path="income"
										cssClass="form-control form-control border-top-0 border-right-0 border-left-0"
										id="income" placeholder="Income Salary" />
								</div>
							</div>
							<div class="col-co-2">
								<div class="input-group">
									<form:input path="incomeTFS"
										cssClass="form-control form-control border-top-0 border-right-0 border-left-0"
										id="incomeTFS" placeholder="Income Tax From Salary" />
								</div>
							</div>
						</div>
						<div class="form-group">
							<span>Income Type</span>
							<div class="rs-select2 js-select-simple select--no-search">
								<form:select path="incomeType" id="incomeType"
									cssClass="form-control">
									<form:option value="" disabled="disabled" selected="selected">Select Income Type</form:option>
									<form:option value="per Week">Per WeeK</form:option>
									<form:option value="fortNight">FortNight</form:option>
									<form:option value="fortNight">Month</form:option>
								</form:select>
								<div class="select-dropdown"></div>
							</div>
							<span id="sMsg"></span>
						</div>
						<div class="form-group">
							<span class="title">optional</span><br> <span>Income
								From Other Resource Type</span>
							<div class="rs-select2 js-select-simple select--no-search">
								<form:select path="incomeFORType" id="incomeFORType"
									cssClass="form-control">
									<form:option value="">Select Income From Other Resource Type</form:option>
									<form:option value="per Week">Per WeeK</form:option>
									<form:option value="fortNight">FortNight</form:option>
									<form:option value="fortNight">Month</form:option>
								</form:select>
								<div class="select-dropdown"></div>
							</div>
						</div>
						<div id="otherResource">
							<div class="row row-space">
								<div class="col-co-2">
									<div class="input-group">
										<form:input path="incomeFOR"
											cssClass="form-control form-control border-top-0 border-right-0 border-left-0"
											id="incomeFOR" placeholder="Income Tax From Salary" />
									</div>
								</div>
								<div class="col-co-2">
									<div class="input-group">
										<form:input path="incomeTFOR"
											cssClass="form-control form-control border-top-0 border-right-0 border-left-0"
											id="incomeTFOR" placeholder="Income Tax From Other Resource" />
									</div>
								</div>
							</div>
						</div>
						<c:if test="${processHandel == 'processJobForm'}">
							<div class="float-sm-left">
								<a href="/DC/${backTo}?caseNumber=${caseNumber}"
									class="btn btn-danger"><span class="fa fa-long-arrow-left"></span>&nbsp;Back</a>
							</div>
						</c:if>
						<div class="float-sm-right">
							<input class="btn btn--radius btn--green" type="submit"
								value="Next >">
						</div>

					</form:form>
				</div>
			</div>
		</div>
	</div>
	<!-- ***** Footer Area Start ***** -->
	<%@include file="footer.jsp"%>
	<!-- ***** Footer Area End ***** -->

	<!-- jQuery (Necessary for All JavaScript Plugins) -->
	<script
		src="${pageContext.request.contextPath}/js/jquery/jquery-3.5.1.js"></script>
	<script
		src="${pageContext.request.contextPath}/js/jquery/jquery.validate.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/js/jquery/additional-methods.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/js/datepicker/js/gijgo.min.js"
		type="text/javascript"></script>
	<!-- Popper js -->
	<script src="${pageContext.request.contextPath}/js/popper.min.js"></script>
	<!-- Bootstrap js -->
	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

	<script src="${pageContext.request.contextPath}/js/select2.min.js"></script>
	<!-- Plugins js -->
	<script src="${pageContext.request.contextPath}/js/plugins.js"></script>
	<!-- Active js -->
	<script src="${pageContext.request.contextPath}/js/active.js"></script>
	<script src="${pageContext.request.contextPath}/js/extra/job.js"></script>
</body>
</html>