<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Using IoC Container Project</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
</head>
<body>
	<div class="container mt-4">
		<h1>Using IoC Container</h1>

		<h3>Course</h3>

		<a href="course-edit" class="btn btn-primary">Add New Course</a>

		<div class="mt-4">
			<c:choose>
				<c:when test="${ empty courses }">
					<div class="alert alert-warning">There is no course. Please
						create a new course.</div>
				</c:when>

				<c:otherwise>
					<table class="table table-striped">
						<thead>
							<tr>
								<th>ID</th>
								<th>Name</th>
								<th>Duration</th>
								<th>Fees</th>
								<th>Description</th>
								<th></th>
							</tr>
						</thead>

						<tbody>
							<c:forEach var="c" items="${ courses }">
								<tr>
									<td>${c.id}</td>
									<td>${c.name}</td>
									<td>${c.duration} Months</td>
									<td>${c.fees} MMK</td>
									<td>${c.description}</td>
									<td>
										<c:url var="classes" value="/classes">
											<c:param name="courseId" value="${c.id}"></c:param>
										</c:url>
										<a href="${classes}" class="btn btn-outline-primary">Open Classes</a>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</c:otherwise>
			</c:choose>
		</div>
	</div>

</body>
</html>