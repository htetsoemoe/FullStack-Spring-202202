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
		<h3>Add New Class for ${ course.name }</h3>
		
		<div class="row">
		<div class="col-4">
		
			<c:url var="save" value="/class-edit?courseId=${ course.id }"></c:url>
			<form action="${ save }" method="post">
			
				<div class="mb-3">
					<label for="teacherName" class="form-label">Teacher Name</label><br />
					<input type="text" name="teacherName" id="teacherName" placeholder="Enter Teacher Name" required="required"/>
				</div>
				
				<div class="mb-3">
					<label for="startDate" class="form-label">Duration</label><br />
					<input type="date" name="startDate" id="startDate" required="required"/>
				</div>
				
				
				<input type="submit" value="Save New Class" class="btn btn-primary"/>
			</form>
		
		</div>
	</div>
	</div>
	
	

</body>
</html>