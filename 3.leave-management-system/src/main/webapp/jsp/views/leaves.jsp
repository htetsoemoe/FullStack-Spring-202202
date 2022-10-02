<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Leaves | Home</title>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
	crossorigin="anonymous"></script>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
	
<c:url var="commonCss" value="/resources/application.css"></c:url>
<link rel="stylesheet" href="${commonCss}" />
</head>
<body>

	<c:import url="/jsp/include/navbar.jsp">
		<c:param name="view" value="leaves"></c:param>
	</c:import>

	<div class="container">

		<h3 class="my-4">Leaves</h3>

		<!-- Search Form -->
		<form class="row mb-4">
			<!-- Date From -->
			<div class="col-auto">
				<label class="form-label">Date From</label>
				<input type="date" class="form-control" name="from"/>
			</div>

			<!-- Date To -->
			<div class="col-auto">
				<label class="form-label">Date To</label>
				<input type="date" class="form-control" name="to"/>
			</div>

			<!-- Search Button -->
			<div class="col-auto btn-wrapper">
				<button class="btn btn-outline-success">
					<i class="bi bi-search"></i>&nbsp;Search</button>
			</div>
		</form>

		<!-- Search Result -->
		<c:choose>
			<c:when test="${ empty list }">
				<div class="alert alert-info">There is no data.</div>
			</c:when>
			
			<c:otherwise>
				<!-- Table View -->
				<table class="table table-hover">
					<thead>
						<tr>
							<th>Student Name</th>
							<th>Student Phone</th>
							<th>Teacher Name</th>
							<th>Apply Date</th>
							<th>Start Date</th>
							<th>Leave Days</th>
							<th>Reason</th>
						</tr>
					</thead>
					
					<tbody>
						<c:forEach items="${ list }" var="item">
							<tr>
								<td>${ item.student }</td>
								<td>${ item.studentPhone }</td>
								<td>${ item.teacher }</td>
								<td>${ item.applyDate }</td>
								<td>${ item.startDate }</td>
								<td>${ item.days }</td>
								<td>${ item.reason }</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:otherwise>
		</c:choose>

	</div>
</body>
</html>