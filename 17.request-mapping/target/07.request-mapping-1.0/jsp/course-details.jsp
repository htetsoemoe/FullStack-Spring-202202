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
		<h1>Course Edit</h1>

		<div class="row">
			<div class="col-6">
			
				<c:if test="${not empty result}">
					<div class="alert alert-success">
						${result.message}
					</div>
				</c:if>
			
				<form>
					<div class="mb-2">
						<label for="id" class="form-label mb-2">Course ID</label> <input
							type="text" id="id" name="id" value="${course.id}" readonly="readonly"
							class="form-control" />
					</div>

					<div class="mb-2">
						<label for="name" class="form-label mb-2">Course Name</label> <input
							type="text" id="name" name="name" value="${course.name}" readonly="readonly"
							class="form-control" />
					</div>
					
					<div class="mb-2">
						<label for="level" class="form-label mb-2">Course Level</label> <input
							type="text" id="level" name="level" value="${course.level}" 
							class="form-control" />
					</div>
					
					

					<div class="mb-2">
						<label for="duration" class="form-label mb-1">Duration</label>
						<input type="number" name="duration" id="duration" class="form-control" value="${course.duration}"/>
					</div>
					
					<div class="mb-2">
						<label for="fees" class="form-label mb-1">Fees</label>
						<input type="number" name="fees" id="fees" class="form-control" value="${course.fees}"/>
					</div>

				</form>
			</div>
		</div>
	</div>

</body>
</html>