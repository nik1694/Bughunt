<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Login</title>
<link rel="stylesheet" href="css/login.css">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body style="background-image: url('img/login_back.jpg');">
<%@ include file="../HTML/menu.html" %>
	<div class="container">
		<hr>
		<div class="row">
			<div class="col-sm-4">
				<div class="form">
					<div class="thumbnail">
						<img src="img/man.png" />
					</div>
					<form class="login-form" action="login" method="get">
						<input type="text" placeholder="username" name="uname"/> <input
							type="password" placeholder="password" name="pass"/>
							<input type="hidden" name="userType"
						value="<%="admin"%>">
						<button type="submit" >Manager login</button>
						<p class="message">
							<br>
						</p>
					</form>
				</div>
			</div>
			<div class="col-sm-4">
				<div class="form">
					<div class="thumbnail">
						<img src="img/dev.svg" />
					</div>

					<form class="login-form" action="login" method="get">
						<input type="text" placeholder="username" name="uname"/> <input
							type="password" placeholder="password" name="pass"/>
							<input type="hidden" name="userType"
						value="<%="2"%>">
						<button type="submit" >Developer login</button>
						<p class="message">
							<br>
						</p>
					</form>
				</div>
			</div>
			<div class="col-sm-4">
				<div class="form">
					<div class="thumbnail">
						<img
							src="img/tst.png" />
					</div>

					<form class="login-form" action="login" method="get">
						<input type="text" placeholder="username" name="uname"/> <input
							type="password" placeholder="password" name="pass"/>
							<input type="hidden" name="userType"
						value="<%="3"%>">
						<button type="submit" >Tester login</button>
						<p class="message">
							<br>
						</p>
					</form>
				</div>
			</div>
		</div>
		<!-- /.row -->

		<hr>
	</div>
</body>
</html>