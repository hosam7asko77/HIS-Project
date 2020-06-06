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
						<c:set var="process" value="${sessionScope['caseProcess']}"></c:set>
						<c:if test="${process ==null}">
							<c:redirect url="/DC/showCaseForm"></c:redirect> 
						</c:if>

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
					<h1 class="title" style="margin-top: -10%">Form for Family
						Details</h1>
					<br>

					<form:form action="/DC/${processHandel}"
						modelAttribute="familyDetails" id="familyDetails">

						<h3 class="title">Case Number : ${caseNumber}</h3>
						<form:hidden path="caseNumber" value="${caseNumber}" />
						<div class="input-group">
						<form:hidden path="caseFamilyId" />		
							<form:input path="fatherName"
								cssClass="form-control form-control border-top-0 border-right-0 border-left-0"
								id="father" placeholder="Father Name" />
						</div>
						<div class="input-group">
							<form:input path="matherName"
								cssClass="form-control form-control border-top-0 border-right-0 border-left-0"
								id="mather" placeholder="Mather Name" />
						</div>
						<div class="row row-space">
							<div class="col-co-2">
								<div class="form-group rs-select2">
									<c:set var="count" value="0" scope="page" />
									<div class="js-select-simple select--no-search">
										<form:select path="numberBrather" cssClass="form-control"
											id="noBrother">
											<form:option value="" disabled="disabled" selected="selected">Select Number of Brother</form:option>
											<c:forEach var="i" begin="0" end="10">
												<form:option value="${i}">${i}</form:option>
											</c:forEach>
										</form:select>
										<div class="select-dropdown"></div>
									</div>
									<span id="bMsg"></span>
								</div>
							</div>
							<div class="col-co-2">
								<div class="form-group rs-select2">
									<div class="js-select-simple select--no-search">
										<form:select path="numberSester" id="noSister"
											cssClass="form-control">
											<form:option value="" disabled="disabled" selected="selected">Select Number Sister</form:option>
											<c:forEach var="i" begin="0" end="10">
												<form:option value="${i}">${i}</form:option>
											</c:forEach>
										</form:select>
										<div class="select-dropdown"></div>
									</div>
									<span id="sMsg"></span>
								</div>

							</div>
						</div>
						<div class="form-group rs-select2">
							<div class="js-select-simple select--no-search">
								<form:select path="relationship" id="relation"
									cssClass="form-control">
									<form:option value="">Select Relationship</form:option>
									<form:option value="single">Single</form:option>
									<form:option value="married">Married</form:option>
								</form:select>
								<div class="select-dropdown"></div>
							</div>
							<span id="sMsg"></span>
						</div>
						<div id="rDetails">
							<form:input path="wifeName"
								cssClass="form-control form-control border-top-0 border-right-0 border-left-0"
								id="wifeName" placeholder="Wife/Husband Name" />
									<div class="input-group">
										<form:input path="wifeAge"
											cssClass="form-control form-control border-top-0 border-right-0 border-left-0"
											id="fname" placeholder="Wife/Husband Age" />
									</div>
									<div class="form-group rs-select2">
									<div class="js-select-simple select--no-search">
									<form:select path="haveChild" id="kids"
										cssClass="form-control">
										<form:option value="">Select Kids</form:option>
										<form:option value="true">Yes</form:option>
										<form:option value="false">No</form:option>
									</form:select>
									<div class="select-dropdown"></div>
								</div>
								<span id="kMsg"></span>
							</div>
						</div>
						<div class="float-sm-right">
							<input class="btn btn--radius btn--green" value="Next >"
								type="submit" id="btnSubmit">
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
	<!-- Popper js -->
	<script src="${pageContext.request.contextPath}/js/popper.min.js"></script>
	<!-- Bootstrap js -->
	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/select2.min.js"></script>
	<!-- Plugins js -->
	<script src="${pageContext.request.contextPath}/js/plugins.js"></script>
	<!-- Active js -->
	<script src="${pageContext.request.contextPath}/js/active.js"></script>
	<script src="${pageContext.request.contextPath}/js/extra/family.js"></script>
</body>
</html>