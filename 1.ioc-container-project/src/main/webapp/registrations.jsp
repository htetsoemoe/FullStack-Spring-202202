<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
</head>
<body>

	<div class="container mt-4">
		<h1>Using IoC Container</h1>
		<h3>Students of ${ course.name } Class</h3>

		<div>
			<c:url var="addNew" value="/registration-edit">
				<c:param name="courseId" value="${ course.id }"></c:param>
			</c:url>
			<a class="btn btn-primary" href="${ addNew }">Student
				Registration</a>
		</div>

		<c:choose>
			<c:when test="${ empty registrations }">
				<div class="alert alert-warning mt-4">There is no student for
					${ course.name }. Please add a new student.</div>
			</c:when>
			<c:otherwise>
				<table class="table table-striped">
					<thead>
						<tr>
							<th>Registration ID</th>
							<th>Student</th>
							<th>Phone</th>
							<th>Email</th>
							<th>Course</th>
							<th>Start Date</th>
							<th>Teacher</th>
							<th>Fees</th>
							<th>Duration</th>
							<th>Description</th>
						</tr>
					</thead>

					<tbody>

						<c:forEach var="reg" items="${ registrations }">
							<tr>
								<td>${ reg.id }</td>
								<td>${ reg.student }</td>
								<td>${ reg.phone }</td>
								<td>${ reg.email }</td>
								<td>${ reg.openClass.course.name }</td>
								<td>${ reg.openClass.startDate }</td>
								<td>${ reg.openClass.teacher }</td>
								<td>${ reg.openClass.course.fees } MMK</td>
								<td>${ reg.openClass.course.duration } Months</td>
								<td>${ reg.openClass.course.description }</td> 
							</tr>
						</c:forEach>

					</tbody>
				</table>
			</c:otherwise>

		</c:choose>

	</div>

</body>
</html>