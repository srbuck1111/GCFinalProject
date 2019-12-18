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

h4 {
	font-family: 'Cinzel Decorative';
	font-size: 45px;
	text-shadow: white 0.3em 0.2em 0.2em
}
</style>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	<a class="navbar-brand" href="/get-results">Dungeon Go!</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarColor02" aria-controls="navbarColor02"
		aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarColor02">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item"><a class="nav-link" href="/get-results">Home
			</a></li>
			<li class="nav-item"><a class="nav-link" href="/characterSelect">Select
					Character</a></li>
			<li class="nav-item"><a class="nav-link" href=""></a></li>
			<li class="nav-item"><a class="nav-link" href="#">About</a></li>
		</ul>
		<button class="btn btn-secondary my-2 my-sm-0" type="submit">
			<a href="/">Logout</a>
		</button>


	</div>
</nav>

</head>
<body>

	<div class="container">
		<div class="jumbotron">
			<h4>Create your user</h4>
			<br> ${userExists }
			<form action="/add-user" method="post"
				onSubmit="return checkPassword(this)">

				Username <input type="text" name="userName" size="22" required>
				Password <input type="password" name="userPassword" size="22"
					required> Confirm Password <input type="password"
					name="userPassword2" size="22" required> <input
					class="btn btn-outline-primary" type="submit" value="Add User">
				<br>


			</form>

		</div>
	</div>
	<script>
		// Function to check Whether both passwords 
		// are the  same or not. 
		function checkPassword(form) {
			password1 = form.userPassword.value;
			password2 = form.userPassword2.value;

			// If password not entered 
			if (password1 == '')
				alert("Please enter Password");

			// If confirm password not entered 
			else if (password2 == '')
				alert("Please enter confirm password");

			// If Not same return False.     
			else if (password1 != password2) {
				alert("\nPassword did not match: Please try again...")
				return false;
			}

			// If same return True. 
			else {

				return true;
			}
		}
	</script>

</body>
</html>
