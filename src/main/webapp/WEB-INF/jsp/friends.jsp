<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
</head>
<body>

	<%@ include file="drawer.jsp"%>

	<nav class="navbar navbar-light bg-light"> <a
			class="navbar-brand" href="#"> <img src="apple-touch-icon.png"
												width="30" height="30" class="d-inline-block align-top" alt="">
		Media Library
	</a> </nav>

	<table class="table">
		<thead class="thead-dark">
			<tr>
				<th scope="col">#</th>
				<th scope="col">Name</th>
				<th scope="col">Email</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${friendsList}" var = "friends">
			<tr>
				<th scope="row">1</th>
				<td>"${friends.name}"</td>
				<td>"${friends.email}"</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>

</body>
</html>