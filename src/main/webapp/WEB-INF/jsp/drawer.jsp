<!DOCTYPE html>
<html lang="en" >

<head>
  <meta charset="UTF-8">
  <title>Home</title>
  	<link rel="stylesheet" href="../../css/home.css">
</head>

<body>

  <html>
  <head>
    <!-- Material Design Lite -->
    <script src="https://storage.googleapis.com/code.getmdl.io/1.0.0/material.min.js"></script>
    <link rel="stylesheet" href="https://storage.googleapis.com/code.getmdl.io/1.0.0/material.indigo-pink.min.css">
    <!-- Material Design icon font -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
  </head>
  <body>
    <!-- Uses a transparent header that draws on top of the layout's background -->
    <div class="layout-transparent mdl-layout mdl-js-layout">
      <header class="mdl-layout__header mdl-layout__header" >
        <div class="mdl-layout__header-row" >
          <!-- Title -->
          <span class="mdl-layout-title">Title</span>
          <!-- Add spacer, to align navigation to the right -->
          <div class="mdl-layout-spacer"></div>
          <!-- Navigation -->
          <nav class="mdl-navigation">
            <a class="mdl-navigation__link" href="/captureImage">Create Post</a>
            <a class="mdl-navigation__link" href="">Logout</a>
          </nav>
        </div>
      </header>
      <div class="mdl-layout__drawer" id="drawer">
        <span class="mdl-layout-title">Title</span>
        <nav class="mdl-navigation">
          <a class="mdl-navigation__link" href="#" id="clickme">Home</a>
          <a class="mdl-navigation__link" href="/friends">Friends</a>
          <a class="mdl-navigation__link" href="/getProfile">Profile</a>
          <a class="mdl-navigation__link" href="/myPosts">Posts</a>
          <a class="mdl-navigation__link" href="/showNotifications">Notifications</a>
        </nav>
      </div>
      <main style="margin-top: 500px" class="mdl-layout__content" >
      </main>
    </div>
  </body>
</html>
  
<script  src="../../js/home.js"></script>




</body>

</html>
