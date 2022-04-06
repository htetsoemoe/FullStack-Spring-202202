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
		<h3>Student Registration for ${ course.name } Course</h3>
		<div class="row">
			<div class="col-4">

				<c:url var="save" value="/registration-edit?courseId=${ course.id }"></c:url>
				<form action="${ save }" method="post">

					<div class="mb-3">
						<label for="teacherName" class="form-label">Select Teacher Name (Required)</label><br />
						
					    <select name="openClassId" id="openClassId">
					    <c:forEach items="${openClassIds}" var="opId">
					        <option value="${opId.key}">${opId.value}</option>
					    </c:forEach>
					    </select>
					</div>

					<div class="mb-3">
						<label for="student" class="form-label">Student Name</label><br />
						<input type="text" name="student" id="student"
							required="required" placeholder="Enter Student Name"/>
					</div>
					
					<div class="mb-3">
						<label for="phone" class="form-label">Phone Number</label><br />
						<input type="text" name="phone" id="phone"
							required="required" placeholder="Enter Phone Number"/>
					</div>
					
					<div class="mb-3">
						<label for="email" class="form-label">Email</label><br />
						<input type="text" name="email" id="emial"
							required="required" placeholder="Enter Email"/>
					</div>


					<input type="submit" value="Save New Student" class="btn btn-primary" />
				</form>

			</div>
		</div>
	</div>

</body>
</html>