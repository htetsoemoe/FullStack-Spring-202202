<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Using Path Variable</title>
</head>
<body>
	<h1>User Inputs</h1>
	
	<div>
		<c:if test="${ not empty type and not empty id }">
			<h3>${ type } | ${ id }</h3>
		</c:if>
		
		<c:if test="${ not empty date }">
			<h3>${ date }</h3>
		</c:if>
		
		<c:if test="${ not empty level }">
			<h3>${ level }</h3>
		</c:if>
	</div>
	
	<ul>
		<c:url value="/inputs/Path Type/search/88242" var="pathLink"></c:url>
		<li><a href="${ pathLink }">Path Variable</a></li>
		
		<c:url value="/inputs/2022-06-28" var="dateLink"></c:url>
		<li><a href="${ dateLink }">Date Link</a></li>
		
		<c:url value="/inputs/Advance" var="enumLink"></c:url>
		<li><a href="${ enumLink }">Enum Link</a></li>
		
		<c:url value="/inputs/request?p=Jeans&w=34&l=29" var="requestLink"></c:url>
		<li><a href="${ requestLink }">Request Link</a></li>
	</ul>
</body>
</html>