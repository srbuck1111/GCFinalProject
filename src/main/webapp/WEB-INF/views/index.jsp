<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<body>

<p>Click the button to get your coordinates.</p>

<button onclick="getLocation()">Try It</button>

<button onClick="checkNear()">

<p id="demo"></p>

<script>
var x = document.getElementById("demo");

function distance(lat1, lon1, lat2, lon2) {
	  var p = 0.017453292519943295;    // Math.PI / 180
	  var c = Math.cos;
	  var a = 0.5 - c((lat2 - lat1) * p)/2 + 
	          c(lat1 * p) * c(lat2 * p) * 
	          (1 - c((lon2 - lon1) * p))/2;

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
  x.innerHTML = "Latitude: " + position.coords.latitude + 
  "<br>Longitude: " + position.coords.longitude;
}

function checkNear(lat, lng) {
	if ()
}
</script>

</body>
</html>