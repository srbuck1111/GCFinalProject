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
</style>

</head>
<body>
	<div class="jumbotron">
		<div class="row">
			<div class="column">
				<h1>Side 1</h1>
				
				<p style="color: red">${error}</p>
			</div>
			<div class="column">
				<h1>Side 2</h1>
				<button onClick="getLocation()">Get Location</button>
				<div id="demo"></div>
			</div>
		</div>
	</div>
	
	<script>
		var x = document.getElementById("demo");

		function distance(lat1, lon1, lat2, lon2) {

			var p = 0.017453292519943295; // Math.PI / 180
			var c = Math.cos;
			var a = 0.5 - c((lat2 - lat1) * p) / 2 + c(lat1 * p) * c(lat2 * p)
					* (1 - c((lon2 - lon1) * p)) / 2;

			return 12742 * Math.asin(Math.sqrt(a)); // 2 * R; R = 6371 km
		}

		function getLocation() {
			if (navigator.geolocation) {
				navigator.geolocation.getCurrentPosition(showPosition);
			} else {
				x.innerHTML = "Geolocation is not supported by this browser.";
			}
		}

		function showPosition(position) {
			x.innerHTML = "Latitude: " + position.coords.latitude
					+ "<br>Longitude: " + position.coords.longitude;
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