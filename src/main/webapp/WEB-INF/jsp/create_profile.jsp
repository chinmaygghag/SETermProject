<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<title>Create Profile</title>
</head>
<body>
	<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>

	<!-- Image and text -->
	<nav class="navbar navbar-light bg-light"> <a
		class="navbar-brand" href="#"> <img src="apple-touch-icon.png"
		width="30" height="30" class="d-inline-block align-top" alt="">
		Create Profile
	</a> </nav>
	<form action="createProfile" method="POST" enctype="multipart/form-data">
		<input type="file" name="file"> 
		<input type="text" name="name">
		<input type="text" name="desc">
		<input type="submit" name="Submit">
	</form>
	
	
</body>
</html>


