<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Multi Request</title>
</head>
<body>
	<h1>Multi Request</h1>
	
	<p>${not empty message ? message : 'Default Action'}</p>
	
	<ul>
		<li>
			<c:url value="/multi/action1" var="action1"></c:url>
			<a href="${action1}">Action 1</a>
		</li>
		<li>
			<c:url value="/multi/action1?id=11" var="action11"></c:url>
			<a href="${action11}">Action 1 with Parameter</a>
		</li>
		<li>
			<c:url value="/multi/asdf/jkl;" var="wildcard"></c:url>
			<a href="${wildcard}">Wild-Card</a>
		</li>
		<li>
			<c:url value="/multi/112" var="digit"></c:url>
			<a href="${digit}">Digit</a>
		</li>
	</ul>
</body>
</html>