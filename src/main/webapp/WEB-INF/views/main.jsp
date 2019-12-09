<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/cyborg/bootstrap.min.css" rel="stylesheet" integrity="sha384-mtS696VnV9qeIoC8w/PrPoRzJ5gwydRVn0oQ9b+RJOPxE1Z1jXuuJcyeNxvNZhdx" crossorigin="anonymous">
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
				
				<button onClick="getLocation()">Update Location</button><br/><br/>
				<c:forEach var="r" items="${listOfResults.result}">
					<h3>${r.name }</h3>
					<form action="/test">
						<input type="hidden" id="userLat" name="userLat" value="${userLat }"/> 
						<input type="hidden" id="userLng" name="userLng" value="${userLng }"/>
						<input type="hidden" name="placeLat" value="${r.geometry.location.lat }"/>
						<input type="hidden" name="placeLng" value="${r.geometry.location.lng }"/>
						<input type="submit" value="im here"/>
					</form>
					<br/>
				</c:forEach>
			</div>
		</div>
	</div>
	
	
	<script>
		var x = document.getElementById("demo");
		var userLat = document.getElementById("userLat");
		var userLng = document.getElementById("userLng");

		function getLocation() {
			if (navigator.geolocation) {
				//navigator.geolocation.getCurrentPosition(showPosition);
				navigator.geolocation.getCurrentPosition(sendPosition);
			} else {
				x.innerHTML = "Geolocation is not supported by this browser.";
			}
		}

		function showPosition(position) {
			x.innerHTML = "Latitude: " + position.coords.latitude
					+ "<br>Longitude: " + position.coords.longitude;
		}
		
		function sendPosition(position) {
			userLat.value = position.coords.latitude;
			userLng.value = position.coords.longitude;
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