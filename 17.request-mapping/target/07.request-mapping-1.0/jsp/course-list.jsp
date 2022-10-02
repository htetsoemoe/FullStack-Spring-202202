<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Course List</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>
</head>
<body>

	<div class="container pt-4">
		<h1>Course List</h1>

		<div class="mt-4">
		
			<div>
				<c:url value="/course/edit" var="courseEdit"></c:url>
				<a href="${courseEdit}" class="btn btn-primary">Add New Course</a>
			</div>
			
			<table class="table">
				<thead>
					<tr>
						<th>ID</th>
						<th>Name</th>
						<th>Level</th>
						<th>Duration</th>
						<th>Fees</th>
					</tr>
				</thead>

				<tbody>
					<c:forEach var="c" items="${ list }">
						<tr>
							<td>${c.id}</td>
							<td>
								<c:url value="/course/${c.id}" var="detailsUrl"></c:url>
								<a href="${detailsUrl}">${c.name}</a> 
							</td>
							<td>${c.level }</td>
							<td>${c.duration }</td>
							<td>${c.fees }</td>
						</tr>
					</c:forEach>

				</tbody>
			</table>
		</div>
	</div>


</body>
</html>