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

    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts for this template -->
    <link href="vendor/font-awesome/css/font-awesome.min.css"
          rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700"
          rel="stylesheet" type="text/css">
    <link href='https://fonts.googleapis.com/css?family=Kaushan+Script'
          rel='stylesheet' type='text/css'>
    <link
            href='https://fonts.googleapis.com/css?family=Droid+Serif:400,700,400italic,700italic'
            rel='stylesheet' type='text/css'>
    <link
            href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700'
            rel='stylesheet' type='text/css'>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons"
          rel="stylesheet">
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.4.5/css/mdb.min.css" />

    <script type="text/javascript"
            src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>

    <!-- Propeller ripple effect js -->
    <script type="text/javascript"
            src="http://propeller.in/components/button/js/ripple-effect.js"></script>


    <script type="text/javascript"
            src="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.4.5/js/mdb.min.js"></script>


    <!-- Custom styles for this template -->
    <link rel="stylesheet" href="css/bootsrap.css" />



    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


</head>
<body>

    <%@ include file="drawer.jsp"%>
    <nav class="navbar navbar-light bg-light"> <a
            class="navbar-brand" href="#"> <img src="apple-touch-icon.png"
                                                width="30" height="30" class="d-inline-block align-top" alt="">
        Media Library
    </a> </nav>

    <div class="container" style="margin: 15px">

        <div class="row">
            <c:forEach var="i" items="${postList}">
            <div class="col-md-4">
                <div class="card" style="width: 18rem;">
                    <img class="card-img-top" src="${i.imageUrl}"
                         alt="Card image cap">
                    <div class="card-body">
                        <h5 class="card-title">Captions</h5>
                        <p class="card-text">${i.textCaption}</p>
                    </div>
                </div>
            </div>
            </c:forEach>
        </div>
    </div>


</body>
</html>