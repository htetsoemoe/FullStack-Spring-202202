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
</head>
<body>

	<div class="container mt-4">
		<h1>Using IoC Container</h1>
		<h3>Add New Course</h3>
		
		<div class="row">
		<div class="col-4">
		
			<c:url var="save" value="/course-edit" ></c:url>
			<form action="${ save }" method="post">
			
				<div class="mb-3">
					<label for="name" class="form-label">Name</label><br />
					<input type="text" name="name" id="name" placeholder="Enter Course Name" required="required"/>
				</div>
				
				<div class="mb-3">
					<label for="duration" class="form-label">Duration</label><br />
					<input type="number" name="duration" id="duration" placeholder="Enter Duration" required="required"/>
				</div>
				
				<div class="mb-3">
					<label for="fees" class="form-label">Fees</label><br />
					<input type="number" name="fees" id="fees" placeholder="Enter Fees" required="required"/>
				</div>
				
				<div class="mb-3">
					<label for="descripton" class="form-label">Description</label><br />
					<textarea name="description" id="description" cols="40" rows="5"></textarea>
				</div>
				
				<input type="submit" value="Save Course" class="btn btn-primary"/>
			</form>
		
		</div>
	</div>
	</div>
	
	

</body>
</html>