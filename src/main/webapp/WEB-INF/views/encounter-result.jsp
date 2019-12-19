<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Result</title>
<link
	href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/cyborg/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-mtS696VnV9qeIoC8w/PrPoRzJ5gwydRVn0oQ9b+RJOPxE1Z1jXuuJcyeNxvNZhdx"
	crossorigin="anonymous">
<link href='https://fonts.googleapis.com/css?family=Cinzel Decorative'
	rel='stylesheet'>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	<a class="navbar-brand">Dungeon Go!</a>
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
<style>
.column {
	float: left;
	width: 50%;
	margin: 0 auto;
}
h1 {
	font-family: 'Cinzel Decorative';
	font-size: 50px;
	text-shadow: white 0.4em 0.3em 0.3em
}

h2 {
	font-family: 'Cinzel Decorative';
	font-size: 40px;
	text-shadow: white 0.4em 0.3em 0.3em
}

h3 {
	font-family: 'Cinzel Decorative';
	font-size: 20px;
	text-shadow: white 0.4em 0.3em 0.3em
}

body {
	background-image:
		url("http://getwallpapers.com/wallpaper/full/b/6/6/1009929-graveyard-wallpapers-1920x1200-for-windows-7.jpg");
	background-repeat: no-repeat;
	background-position: relative;
	background-size: cover;
	opacity: .75;
}
</style>
</head>
<body>


<div class="column">
	<c:if test="${win }">
		<h2>
			<c:out value="You slayed the ${monster.name }!" />
		</h2>
		<h3>${resultText }</h3>

	</c:if>
	<c:if test="${!win }">
		<h2>
			<c:out value="You were slain by ${monster.name }!" />
		</h2>
	<h3>${resultText }</h3>
	</c:if>
	<br>
	<a href="/get-results" class="btn btn-outline-secondary">Back to
		Home</a>
		</div>
</body>
</html>