<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<sec:authentication property="principal.authorities" var="authorities" />
<c:forEach items="${authorities}" var="authority" varStatus="vs">
	<c:set var="auth" value="${authority.authority}"></c:set>
</c:forEach>
<c:set var="publicId" value="${sessionScope['PUBLIC_ID_SESSION']}"></c:set>
<c:if test="${publicId ==null}">
	<c:redirect url="/"></c:redirect>
</c:if>
<header class="header-area">
	<!-- Main Header Area -->
	<div class="main-header-area" id="stickyHeader">
		<div class="container h-50">
			<div class="row h-100 align-items-center">
				<div class="col-12 h-100">
					<div class="main-menu h-100">
						<nav class="navbar h-100 navbar-expand-lg">
							<!-- Logo Area  -->
							<a class="navbar-brand" href="index.html"><img
								src="${pageContext.request.contextPath}/img/core-img/logo.png"
								alt="Logo" height="50" width="100" style="margin-top: -18px;"></a>

							<button class="navbar-toggler" type="button"
								data-toggle="collapse" data-target="#medilifeMenu"
								aria-controls="medilifeMenu" aria-expanded="false"
								aria-label="Toggle navigation">
								<span class="navbar-toggler-icon"></span>
							</button>

							<div class="collapse navbar-collapse" id="medilifeMenu">
								<!-- Menu Area -->
								<ul class="navbar-nav ml-auto">
									<li class="nav-item"><a class="nav-link" href="/">Home
											<span class="sr-only">(current)</span>
									</a></li>
									<li class="nav-item dropdown"><a
										class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
										role="button" data-toggle="dropdown" aria-haspopup="true"
										aria-expanded="false">Application Registration</a>
										<div class="dropdown-menu" aria-labelledby="navbarDropdown">
											<a class="dropdown-item" href="/AppRegister/showRegisterForm">New
												Application</a> <a class="dropdown-item"
												href="/AppRegister/showSearchPage">Search</a> <a
												class="dropdown-item" href="/AppRegister/getAllApp">All
												Applications</a>
										</div></li>
									<li class="nav-item dropdown"><a
										class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
										role="button" data-toggle="dropdown" aria-haspopup="true"
										aria-expanded="false">Data Collection</a>
										<div class="dropdown-menu" aria-labelledby="navbarDropdown">
											<a class="dropdown-item" href="/DC/showCaseForm">Create
												Case</a> <a class="dropdown-item"
												href="/AppRegister/showSearchPage">Search For Case </a> <a
												class="dropdown-item" href="/DC/viewAllCases">View
												Case</a>
											<li class="nav-item"><a class="nav-link"
												href="services.html">Services</a></li>
											<li class="nav-item"><a class="nav-link"
												href="blog.html">News</a></li>
											<c:if test="${auth=='ROLE_Admin'}">
												<li class="nav-item dropdown"><a
													class="nav-link dropdown-toggle" href="#"
													id="navbarDropdown" role="button" data-toggle="dropdown"
													aria-haspopup="true" aria-expanded="false">Admin</a>
													<div class="dropdown-menu" aria-labelledby="navbarDropdown">
														<a class="dropdown-item" href="/Admin/Manager/showForm">Create
															Account</a> <a class="dropdown-item"
															href="/Admin/Manager/viewUsers">View Accounts</a> <a
															class="dropdown-item" href="/Admin/Plan/showPlanForm">Create
															Plan</a> <a class="dropdown-item"
															href="/Admin/Plan/viewPlans">View Plan</a>
													</div></li>
											</c:if>
											<li class="nav-item"><form:form
													action="${pageContext.request.contextPath}/logout"
													method="post">
													<button type="submit" class="nav-link">
														Logout <i class="fa fa-sign-out"></i>
													</button>
												</form:form></li>
								</ul>
							</div>
						</nav>
					</div>
				</div>
			</div>
		</div>
	</div>
</header>