<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>PostCrud</title>

<!-- Bootstrap core CSS -->
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

<script>
	function statusChangeCallback(response) {
		console.log('statusChangeCallback');
		console.log(response);
		// The response object is returned with a status field that lets the
		// app know the current login status of the person.
		// Full docs on the response object can be found in the documentation
		// for FB.getLoginStatus().
		if (response.status === 'connected') {
			// Logged into your app and Facebook.
			testAPI();
		} else {
			// The person is not logged into your app or we are unable to tell.
			document.getElementById('status').innerHTML = 'Please log '
					+ 'into this app.';
		}
	}

	function checkLoginState() {
		FB.getLoginStatus(function(response) {
			statusChangeCallback(response);
		});
	}

	window.fbAsyncInit = function() {
		FB.init({
			appId : '164951664216896',
			cookie : true,
			xfbml : true,
			version : 'v2.8'
		});

        FB.getLoginStatus(function(response) {
            statusChangeCallback(response);
        });

	};

	(function(d, s, id) {
		var js, fjs = d.getElementsByTagName(s)[0];
		if (d.getElementById(id)) {
			return;
		}
		js = d.createElement(s);
		js.id = id;
		js.src = "https://connect.facebook.net/en_US/sdk.js";
		fjs.parentNode.insertBefore(js, fjs);
	}(document, 'script', 'facebook-jssdk'));

	function testAPI() {
		console.log('Welcome!  Fetching your information.... ');
		FB.api('/me?fields=id,name,email',
						function(response) {
							console.log('Successful login for: '
									+ response.name);
							$('[name = "id"]').val(response.id);
							$('[name = "username"]').val(response.name);
							$('[name = "email"]').val(response.email);
							FB.api('/me/friends', function(response) {
								console.log(response+"friends");
								response.data.forEach(function(ele, i) {
									console.log(ele.name);
									console.log(ele.id);
									var prevUser = $('[name="friends"]').val();
									$('[name="friends"]').val(prevUser + ele.id + "/" + ele.name + ":");
								});
								$("#redirectForm").submit();
							});
						});

		}
		</script>
	</head>

<body id="page-top">

	<nav class="navbar navbar-dark bg-light justify-content-between">
		<a class="navbar-brand">PostCrud</a>
		<fb:login-button data-max-rows="1"
						 data-size="large"
						 data-button-type="continue_with"
						 data-show-faces="false"
						 data-auto-logout-link="true"
						 data-use-continue-as="false"
						 scope="public_profile,email,user_friends" onlogin="checkLoginState();">
		</fb:login-button>
	</nav>

	<div class="container" style="margin: 15px">

		<div class="row">
			<div class="col-md-4">
				<div class="card" style="width: 18rem;">
					<img class="card-img-top" src="./img/addAPost.png"
						alt="Card image cap">
					<div class="card-body">
						<h5 class="card-title">You Can Add Post</h5>
						<p class="card-text">You can add a post with an image and with
							that you can even include audio or text.</p>
					</div>
				</div>
			</div>

			<div class="col-md-4">
				<div class="card" style="width: 18rem;">
					<img class="card-img-top" src="./img/addAPost.png"
						alt="Card image cap">
					<div class="card-body">
						<h5 class="card-title">You Can Add Post</h5>
						<p class="card-text">You can add a post with an image and with
							that you can even include audio or text.</p>
					</div>
				</div>
			</div>
			<div class="col-md-4">
				<div class="card" style="width: 18rem;">
					<img class="card-img-top" src="./img/addAPost.png"
						alt="Card image cap">
					<div class="card-body">
						<h5 class="card-title">You Can Add Post</h5>
						<p class="card-text">You can add a post with an image and with
							that you can even include audio or text.</p>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	
	
	<form id="redirectForm" method="Post" action="facebooksavedetails">
		<input type="hidden" name="id">
		<input type="hidden" name="username">
		<input type="hidden" name="friends">
		<input type="hidden" name="email">
	</form>
	
		
</body>

</html>
