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
    <title>Profile</title>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
</head>
<body>

<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script
        src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>

<%@ include file="drawer.jsp"%>
<nav class="navbar navbar-light bg-light"> <a
        class="navbar-brand" href="#"> <img src="apple-touch-icon.png"
                                            width="30" height="30" class="d-inline-block align-top" alt="">
    Media Library
</a> </nav>

<table class="table">
    <thead class="thead-dark">
    <tr>
        <th scope="col">Message</th>
        <th scope="col">View</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${list}" var="i">
    <tr>
        <td>${i.message}</td>
        <td><a><button type="button" class="btn btn-primary" href="/view_post_from_notification?postId=${i.postId}&notificationId=${i.id}>View</button></a></td>
    </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
