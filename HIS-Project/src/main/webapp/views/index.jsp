<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
<p id="email"><security:authentication property="principal.username"/></p>



<form:form action="${pageContext.request.contextPath}/logout" method="post">
<input type="submit" vlaue="Logout"/>
</form:form>
</body>
</html>