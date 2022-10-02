<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Request Mapping</title>
</head>
<body>
	<h1>Request Mapping</h1>
	
	<ul>
		<li>
			<c:url value="/multi" var="multi"></c:url>
			<a href="${multi}">Multi Action</a>
		</li>
		<li>
			<c:url value="/inputs" var="inputs"></c:url>
			<a href="${inputs}">User Inputs</a>
		</li>
		<li>
			<c:url value="/course" var="course"></c:url>
			<a href="${course}">Return Type Demo</a>
		</li>
	</ul>
	
</body>
</html>