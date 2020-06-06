<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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


	<!-- ***** View Data  Area Start ***** -->
	<section class="medica-about-us-area section-padding-100-20">
		<div class="container" style="margin-top: 7%;">
			<div class="row">
				<div class="col-12 col-lg-4">
					<div class="medica-about-content">
						<h2>Case Details</h2>
						<p>Case Number : ${caseDetails.caseNumber}</p>
						<p>Application Number : ${caseDetails.appRegister}</p>
						<a href="/DC/sendEdDetails?caseNumber=${caseDetails.caseNumber} "
							class="btn medilife-btn mt-50">Done<span>+</span></a>
					</div>
				</div>
				<div class="col-12 col-lg-8">
					<div class="row">
						<!-- Single Service Area -->
						<div class="col-12 col-sm-6">
							<div class="single-service-area d-flex"
								style="margin-left: -30%;">
								<div class="service-icon">
									<i class="fa fa-users"></i>
								</div>
								<div class="service-content">
									<h5>Family Details</h5>
									<p class="dtl-p">
										Father Name : <span class="dtl-span">${familyDetails.fatherName}</span>
									</p>
									<p class="dtl-p">
										Mother Name : <span class="dtl-span">${familyDetails.matherName}</span>
									</p>
									<p class="dtl-p">
										Number of Brother : <span class="dtl-span">${familyDetails.numberBrather}</span>
									</p>
									<p class="dtl-p">
										Number of Sister : <span class="dtl-span">${familyDetails.numberSester}</span>
									</p>
									<p class="dtl-p">
										Relationship : <span class="dtl-span">${familyDetails.relationship}</span>
									</p>
									<c:if test="${familyDetails.relationship == 'Married'}">
										<p class="dtl-p">
											Wife/Husband Name : <span class="dtl-span">${familyDetails.wifeName}</span>
										</p>
										<p class="dtl-p">
											Wife/Husband Age : <span class="dtl-span">${familyDetails.wifeAge}</span>
										</p>
									</c:if>
									<div class="float-sm-laft">
										<a
											href="/DC/showEditFamily?caseNumber=${caseDetails.caseNumber}"
											class="btn btn-primary">Edit <i class="fa fa-edit"></i></a>
									</div>
								</div>
							</div>
						</div>
						<!-- Single Service Area -->
						<c:if test="${familyDetails.haveChild}">
							<div class="col-12 col-sm-6">
								<div class="single-service-area d-flex"
									style="margin-left: -50%;">
									<div class="service-icon">
										<i class="fa fa-child"></i>
									</div>
									<div class="service-content">
										<h5>Kids Details</h5>
										<div class="panel panel-default" style="margin-top: 1%;">
											<div class="panel-heading">All Kids Details</div>
											<div class="table-responsive">
												<table id="example" class="display" style="width: %100;" >
													<thead class=" text-primary">
														<tr>
															<th>SNo.</th>
															<th>Child Name</th>
															<th>Date of Birth</th>
															<th>Gender</th>
															<th>SSN</th>
														</tr>
													</thead>
													<tbody>
														<c:set var="count" value="0" scope="page" />
														<c:forEach var="tempKids" items="${kidsDetailsList}">
															<c:set var="count" value="${count + 1}" scope="page" />
															<tr>
																<td>${count}</td>
																<td>${tempKids.childName}</td>
																<td>${tempKids.dob}</td>
																<td>${tempKids.gender}</td>
																<td>${tempKids.ssn}</td>
															</tr>
														</c:forEach>
													</tbody>
												</table>
											</div>
										</div>
										<div class="float-sm-laft">
											<a
												href="/DC/showEditKids?caseNumber=${caseDetails.caseNumber}"
												class="btn btn-primary">Edit <i class="fa fa-edit"></i></a>
										</div>
									</div>
								</div>
							</div>
						</c:if>
						<!-- Single Service Area -->
						<c:if test="${jobDetails!=null}">
							<div class="col-12 col-sm-6">
								<div class="single-service-area d-flex">
									<div class="service-icon">
										<i class="fa fa-briefcase"></i>
									</div>
									<div class="service-content">
										<h5>Job Details</h5>
										<p class="dtl-p">
											Occupation : <span class="dtl-span">${jobDetails.occupation}</span>
										</p>
										<p class="dtl-p">
											Organization : <span class="dtl-span">${jobDetails.orgName}</span>
										</p>
										<p class="dtl-p">
											Job Type : <span class="dtl-span">${jobDetails.jobType}</span>
										</p>
										<p class="dtl-p">
											Job Position : <span class="dtl-span">${jobDetails.jobPosition}</span>
										</p>
										<p class="dtl-p">
											Started Date : <span class="dtl-span">${jobDetails.startJob}</span>
										</p>
										<p class="dtl-p">
											Income <span class="dtl-span">$${jobDetails.income}</span>
										</p>
										<p class="dtl-p">
											Income Tax From Salary : <span class="dtl-span">$${jobDetails.incomeTFS}</span>
										</p>
										<p class="dtl-p">
											Income Type : <span class="dtl-span">${jobDetails.incomeType}</span>
										</p>
										<c:if test="${jobDetails.incomeFOR !=null}">
											<p class="dtl-p">
												Income From Other Resource : <span class="dtl-span">${jobDetails.incomeFOR}</span>
											</p>
											<p class="dtl-p">
												Income From Other Resource Type : <span class="dtl-span">${jobDetails.incomeFORType}</span>
											</p>
											<p class="dtl-p">
												Tax From Other Resource : <span class="dtl-span">${jobDetails.incomeTFOR}</span>
											</p>
										</c:if>
										<div class="float-sm-laft">
											<a
												href="/DC/showEditjobForm?caseNumber=${caseDetails.caseNumber}"
												class="btn btn-primary">Edit <i class="fa fa-edit"></i></a>
										</div>
									</div>
								</div>
							</div>
						</c:if>
						<!-- Single Service Area -->
						<div class="col-12 col-sm-6">
							<div class="single-service-area d-flex">
								<div class="service-icon">
									<i class="fa fa-user-secret"></i>
								</div>
								<div class="service-content">
									<h5>Crime Report Details</h5>
									<h6 style="font-size: 18px">Incident Type:</h6>
									<c:forEach var="type" items="${crimeDetails.incidentType}">
										<span class="dtl-span" style="margin-left: 20px">*
											${type}</span>
										<br>
									</c:forEach>
									<hr>
									<h6 style="font-size: 18px">Incident Location Details</h6>
									<p class="dtl-p" style="margin-left: 20px">
										* Street : <span class="dtl-span">
											${crimeDetails.incidentStreet}</span>
									</p>
									<p class="dtl-p" style="margin-left: 20px">
										* City : <span class="dtl-span">
											${crimeDetails.incidentCity}</span>
									</p>
									<p class="dtl-p" style="margin-left: 20px">
										* State : <span class="dtl-span">${crimeDetails.incidentState}</span>
									</p>
									<hr>
									<p class="dtl-p">
										Incident Date : <span>${crimeDetails.incidentDate}</span>
									</p>
									<p class="dtl-p">
										Description : <span class="dtl-span">${crimeDetails.incidentDescribe}</span>
									</p>
									<p class="dtl-p">
										Number of people involved : <span class="dtl-span">${crimeDetails.peopelInvolved}</span>
									</p>
									<%-- this code for image report<img src="data:image/jpg;base64,${crimeDetails.reportImage}"
										width="240" height="300"> --%>
									<div class="float-sm-laft">
										<a
											href="/DC/showEditCrime?caseNumber=${caseDetails.caseNumber}"
											class="btn btn-primary">Edit <i class="fa fa-edit"></i></a>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- ***** Footer Area Start ***** -->
	<%@include file="footer.jsp"%>
	<!-- ***** Footer Area End ***** -->

	<!-- jQuery (Necessary for All JavaScript Plugins) -->
	<script
		src="${pageContext.request.contextPath}/js/jquery/jquery-3.5.1.js"></script>
	<script
		src="${pageContext.request.contextPath}/js/jquery/jquery.dataTables.min.js"></script>
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