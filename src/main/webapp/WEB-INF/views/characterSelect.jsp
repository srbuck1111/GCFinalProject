<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
<link
	href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/cyborg/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-mtS696VnV9qeIoC8w/PrPoRzJ5gwydRVn0oQ9b+RJOPxE1Z1jXuuJcyeNxvNZhdx"
	crossorigin="anonymous">
<link href='https://fonts.googleapis.com/css?family=Cinzel Decorative'
	rel='stylesheet'>

<style>
* h1 {
	font-family: 'Cinzel Decorative';
	font-size: 65px;
	text-shadow: white 0.3em 0.2em 0.2em;
	color: black;
}

h4 {
	font-family: 'Cinzel Decorative';
	font-size: 45px;
	text-shadow: white 0.3em 0.2em 0.2em;
	color: black;
}

option {
	font-size: 20px;
}
body {
	background-image:
		url("https://www.tokkoro.com/picsup/5466774-fantasy-waterfall-wallpapers.jpg");
	background-repeat: no-repeat;
	background-position: relative;
	background-size: cover;
	opacity: .75;
}
</style>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	<a class="navbar-brand">Dungeon Go!</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarColor02" aria-controls="navbarColor02"
		aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarColor02">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item"><a class="nav-link" href="#">About</a></li>
		</ul>
		<button class="btn btn-secondary my-2 my-sm-0" type="submit">
			<a href="/">Logout</a>
		</button>


	</div>
</nav>
</head>
<div>
	<h1>
		<center>Welcome, ${loggedUser.username }! Select Your
			Character! <form class="form-inline" action="/new-character">
							<center><input class="btn btn-primary" type="submit"
								value="Create a new character!"></center>
						</form></center>
			
	</h1>
</div>
<style>
.column {
	float: left;
	width: 50%;
}

.column2 {
	float: right;
	width: 50%
}

.row:after {
	content: "";
	display: table;
	clear: both;
}
</style>

<body onload="getLocation()">
		<div class="container">
			<div class="row">
				<div class="column">
					<center><h4>Character Select</h4></center>

					<br>
					<center>
						<form action="/character-select" onSubmit="getLocation()">
							<input type="hidden" id="userLat" name="userLat"
								value="${userLat }" /> <input type="hidden" id="userLng"
								name="userLng" value="${userLng }" /> <select
								class="btn btn-primary" name="characterId">
								<c:forEach var="c" items="${loggedUser.playerCharacters}">
									<option value="${c.characterId}">${c.getFirstName() }
										${c.getLastName()}</option>
								</c:forEach>
							</select> <input type="submit" class="btn btn-primary"
								value="Select This Character" /></center>
						</form>
						<br><br><br>
						
					

				</div>
					
			</div>
			
		</div>
		


	<script>
		var x = document.getElementById("demo");
		var userLat = document.getElementById("userLat");
		var userLng = document.getElementById("userLng");

		var options = {
			enableHighAccuracy : true,
			timeout : 5000,
			maximumAge : 0
		};

		function getLocation() {
			if (navigator.geolocation) {
				navigator.geolocation.watchPosition(showPosition, error,
						options);
				//navigator.geolocation.getCurrentPosition(sendPosition);
				navigator.geolocation.watchPosition(success, error, options);
			} else {
				x.innerHTML = "Geolocation is not supported by this browser.";
			}
		}

		function showPosition(position) {
			x.innerHTML = "Latitude: " + position.coords.latitude
					+ "<br>Longitude: " + position.coords.longitude;
		}

		function success(position) {

			console.log("High Accuracy works?");

			userLat.value = position.coords.latitude;
			userLng.value = position.coords.longitude;
		}

		function error() {
			console.log("failed");
		}

		function checkNear(lat1, lng1, lat2, lng2) {
			if (distance(lat1, lng1, lat2, lng2) <= 50) {
				return true;
			}
			return false;
		}
	</script>
</body>
</html>