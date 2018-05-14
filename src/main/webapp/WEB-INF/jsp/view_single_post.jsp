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

    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <script
            src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>


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

    <div class="container">
    <div class="row">
        <img src="${postAndComment.imageUrl}">

        <audio autoplay>
            <source src="${postAndComment.audioUrl}" type="audio/webm"></source>
        </audio>
    </div>
    <div class="row">
        <div class="row">
            <c:if test="${postAndComment.comments.size() > 0}">

                <c:forEach items="${postAndComment.comments}" var="i">
                    <label>${i.userName}: ${i.comments}</label>
                </c:forEach>
            </c:if>
            <div class="row">
            <form action="addComment" method="POST">
                <input type="text" name="comment">
                <input type="hidden" value="${postAndComment.postId}" name="postId">

                <input type="submit" name="Comment">

            </form>
            </div>
        </div>
        <div>


        </div>
    </div>
    </div>


</body>
</html>