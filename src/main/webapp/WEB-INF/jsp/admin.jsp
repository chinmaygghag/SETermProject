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
</head>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<body>

<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script
        src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<%@ include file="drawer.jsp"%>
<!-- Image and text -->
<nav class="navbar navbar-light bg-light"> <a
        class="navbar-brand" href="#"> <img src="apple-touch-icon.png"
                                            width="30" height="30" class="d-inline-block align-top" alt="">
    Media Library
</a> </nav>


<div class="row" style="borderTop: 5px; padding: 15px;">
    <h6>List Of Users</h6>
    <c:forEach var="i" items="${admin.username}">
        <label>${i}</label>
    </c:forEach>

</div>



<table class="table" >
    <thead class="thead-dark">
    <tr>
        <th scope="col">Post Image</th>
        <th scope="col">Delete</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${admin.postList}" var="i">
        <tr>
            <td>${i.imageUrl}</td>
            <td><a  href="/deletePost?postId=${i.id}"><button type="button" class="mdl-button mdl-js-button mdl-button--raised" >Delete</button></a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>




</body>
</html>