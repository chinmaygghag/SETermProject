<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
	<script
			src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<title>Profile</title>
</head>
<body>


	<%@ include file="drawer.jsp"%>
	<!-- Image and text -->
	<nav class="navbar navbar-light bg-light"> <a
		class="navbar-brand" href="#"> <img src="apple-touch-icon.png"
		width="30" height="30" class="d-inline-block align-top" alt="">
		Media Library
	</a> </nav>


	<div class="row" style="margin-left: 500px">
		<div class="col-md-3">
			<img alt="Profile Page Image" src="${profileImageName}" height="300"
				width="300" class="img-fluid img-thumbnail">
		</div>
		<div class="col-md-8">
			<div class="container">
				<h3>"${name}"</h3>
				<h5>
					${description}<br>
				</h5>
			</div>
		</div>
		<div>
		</div>
		<a  href="/updateProfile"><button type="button" class="mdl-button mdl-js-button mdl-button--raised">Update Profile</button></a>
	</div>




</body>
</html>