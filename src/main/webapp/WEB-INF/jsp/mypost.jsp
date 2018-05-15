<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <link rel="stylesheet" href="https://storage.googleapis.com/code.getmdl.io/1.0.0/material.indigo-pink.min.css">
    <!-- Material Design icon font -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">

    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
</head>
<body>

<%@ include file="drawer.jsp"%>
<nav class="navbar navbar-light bg-light"> <a
        class="navbar-brand" href="#"> <img src="apple-touch-icon.png"
                                            width="30" height="30" class="d-inline-block align-top" alt="">
    Media Library
</a> </nav>

<div class="container">
    <div class="row">
        <div class="col-md-4">
            <c:forEach items="${postList}" var = "posts">

                <a href="/viewSinglePost?postId=${posts.id}">
                    <div class="card" style="width: 18rem;">

                    <img   class="card-img-top" src="${posts.imageUrl}"
                     alt="Card image cap">
                    <div class="card-body">
                        <h5 class="card-title">${posts.textCaption}</h5>
                        <a class="btn btn-primary">View Post</a>
                    </div>
                    </div>
                </a>
            </c:forEach>
        </div>
    </div>
</div>


</body>
</html>