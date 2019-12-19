<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome!</title>
<link
	href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/cyborg/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-mtS696VnV9qeIoC8w/PrPoRzJ5gwydRVn0oQ9b+RJOPxE1Z1jXuuJcyeNxvNZhdx"
	crossorigin="anonymous">
<link href='https://fonts.googleapis.com/css?family=Cinzel Decorative'
	rel='stylesheet'>
<style>
* {
	box-sizing: border-box;
}

/* Create two equal columns that floats next to each other */
.column {
	float: left;
	width: 50%;
	padding: 10px;
}

/* Clear floats after the columns */
.row:after {
	content: "";
	display: table;
	clear: both;
}

body {
	background-image:
		url("https://rpgrunkleplaysgames.files.wordpress.com/2017/06/65_header_dmscreen2017.jpg?w=1440");
	background-repeat: no-repeat;
	background-position: relative;
	background-size: cover;
	opacity: .85;
}

h1 {
	font-family: 'Cinzel Decorative';
	font-size: 75px;
	text-shadow: black 0.3em 0.2em 0.2em
}
audio { display:none;}
</style>

</head>
<body>
<audio controls autoplay>
   <source src="http://www.ffmages.com/ffvii/ost/disc-1/01-prelude.mp3" type="audio/mpeg">
</audio>
	<br>
	<br>
	<br>
	<center>
		<h1>Welcome to Dungeon Go!</h1>
	</center>



	<div class="container">
		<div class="jumbotron">
			<center>
				<form method="post" action="/login">

					Username <input type="text" name="userName" size="22" required>
					Password <input type="password" name="userPassword" size="22"
						required> <input class="btn btn-outline-primary"
						type="submit" value="Login"> <a href="/new-user"
						class="btn btn-outline-primary">Create new user</a> <br>
					${wrongPassword } ${noUserName }

				</form>
				<br>

			</center>

		</div>
	</div>
</body>
</html>