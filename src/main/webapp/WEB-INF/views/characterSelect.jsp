<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link
	href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/cyborg/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-mtS696VnV9qeIoC8w/PrPoRzJ5gwydRVn0oQ9b+RJOPxE1Z1jXuuJcyeNxvNZhdx"
	crossorigin="anonymous">
</head>
<div class="jumbotron">
	<h1 class="display-2">
	
		<center>Welcome, ${loggedUser.username }! Select Your Character!</center>
	</h1>
</div>
<style>
.column {
	float: left;
	width: 50%;
}

.row:after {
	content: "";
	display: table;
	clear: both;
}
</style>
</head>
<body onload="getLocation()">
	<div class="jumbotron">
		<div class="row">
			<div class="column">
				<h2>Character Select</h2>
				<h3></h3>
				<br>
				<form action="/character-select" onSubmit="getLocation()">
					<input type="hidden" id="userLat" name="userLat" value="${userLat }" />
					<input type="hidden" id="userLng" name="userLng" value="${userLng }" />
					<select name="characterId">
						<c:forEach var="c" items="${loggedUser.playerCharacters}">
							<option value="${c.characterId}">${c.getFirstName() }</option>
						</c:forEach>
					</select>
					<input type="submit" value="Choose Character"/>
				</form>
			</div>

			<form action="/new-character">
				<input class="btn-primary" type="submit"
					value="Create a new character!">
			</form>
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