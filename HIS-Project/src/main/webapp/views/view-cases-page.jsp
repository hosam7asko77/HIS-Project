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

	<!-- ***** Header Area Start ***** -->
	<%@ include file="header.jsp"%>
	<!-- ***** Header Area End ***** -->

	<!-- ***** Breadcumb Area Start ***** -->
	<section class="breadcumb-area bg-img gradient-background-overlay"
		style="background-image: url(/img/bg-img/breadcumb1.jpg);">
		<div class="container h-100">
			<div class="row h-100 align-items-center">
				<div class="col-12">
					<div class="breadcumb-content">
						<h3 class="breadcumb-title">View Cases</h3>
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
				<div class="col-md-8">
					<div class="panel panel-default">
						<div class="panel-heading">All Cases Details</div>
						<div class="panel-body">
							<table id="example"
								class="display" style="width:100%">
								<thead>
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
									<c:forEach var="tempCase" items="${allCases}">
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
										<tr>
											<td>${count}</td>
											<td>${tempCase.caseNumber}</td>
											<td>${tempCase.appRegister}</td>
											<td>${tempCase.userId}</td>
											<td><a href="${moreDetails}" title="View Full Details"
												class="fa fa-info"></a>&nbsp;&nbsp;&nbsp;&nbsp; <a
												href="${DeleteLink}" title="Delete Case"><i
													class="fa fa-trash-o" style="color: red;"></i></a></td>
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

	<!-- Bottom Footer Area -->
	<%@include file="footer.jsp"%>
	<!-- ***** Footer Area End ***** -->
	<!-- jQuery (Necessary for All JavaScript Plugins) -->
	<script
		src="${pageContext.request.contextPath}/js/jquery/jquery-3.5.1.js"></script>

	<script
		src="${pageContext.request.contextPath}/js/jquery/jquery.dataTables.min.js"></script>
			<script
		src="${pageContext.request.contextPath}/js/jquery/dataTables.jqueryui.min.js"></script>
		
	<!-- Popper js -->
	<script src="${pageContext.request.contextPath}/js/popper.min.js"></script>
	<!-- Bootstrap js -->

	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
	<!-- Plugins js -->
	<script src="${pageContext.request.contextPath}/js/plugins.js"></script>
	<!-- Active js -->
	<script src="${pageContext.request.contextPath}/js/active.js"></script>
	<script src="${pageContext.request.contextPath}/js/table.js"></script>
</body>

</html>