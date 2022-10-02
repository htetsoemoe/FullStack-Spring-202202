<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Course Edit</title>
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
		<h1>${empty course or course.id eq 0 ? 'Add New ' : 'Edit '}Course</h1>

		<div class="row">
			<div class="col-6">
			
				<c:url value="/course" var="saveUrl"></c:url>
				<form method="post" action="${saveUrl}">
				
					<c:if test="${not empty course}">
						<input type="hidden" name="id" value="${course.id}"/>
					</c:if>

					<div class="mb-2">
						<label for="name" class="form-label mb-2">Course Name</label> <input
							type="text" id="name" name="name" value="${course.name}" placeholder="Enter Course Name"
							class="form-control" />
					</div>

					<div class="mb-2">
						<label for="level" class="form-label mb-1">Level</label> <select
							name="level" id="level" class="form-select">
							<option value="">Select One</option>
							
							<c:forEach var="level" items="${levels}">							
								<c:choose>
								
									<c:when test="${course.level eq level}">
										<option selected="selected" value="${level}">${level}</option>									
									</c:when>
									
									<c:otherwise>
										<option value="${level}">${level}</option>
									</c:otherwise>
									
								</c:choose>	
							</c:forEach>
						</select>
					</div>

					<div class="mb-2">
						<label for="duration" class="form-label mb-1">Duration</label>
						<input type="number" value="${course.duration}" name="duration" id="duration" class="form-control" placeholder="Enter Duration"/>
					</div>
					
					<div class="mb-2">
						<label for="fees" class="form-label mb-1">Fees</label>
						<input type="number" value="${course.fees}" name="fees" id="fees" class="form-control" placeholder="Enter Fees"/>
					</div>
					
					<div class="mt-2">
						<button type="submit" class="btn btn-warning">Save Course</button>
					</div>
				</form>
			</div>
		</div>
	</div>

</body>
</html>