<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>D&D Go!</title>
<link
	href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/cyborg/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-mtS696VnV9qeIoC8w/PrPoRzJ5gwydRVn0oQ9b+RJOPxE1Z1jXuuJcyeNxvNZhdx"
	crossorigin="anonymous">
	<link href='https://fonts.googleapis.com/css?family=Cinzel Decorative' rel='stylesheet'>
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
	h1 {
 font-family: 'Cinzel Decorative'; font-size: 45px;
 text-shadow: black 0.3em 0.2em 0.2em
}
h2 {
 font-family: 'Cinzel Decorative'; font-size: 35px;
 text-shadow: black 0.3em 0.2em 0.2em
}
h3 {
 font-family: 'Cinzel Decorative'; font-size: 17px;
 text-shadow: black 0.3em 0.2em 0.2em
}
	</style>
</head>
<body onload="getLocation()">
	<div class="jumbotron">
		<div class="row">
			<div class="column">
			 	<h1>Welcome, ${playerCharacter.firstName } ${playerCharacter.lastName }</h1>
				<h2>Current gold: ${playerCharacter.gold}</h2>
				<h3>Player stats: <br> HP: ${playerCharacter.hp} / ${playerCharacter.hpMax}<br> 
				Armor Class: ${playerCharacter.ac}<br>
				Strength: ${playerCharacter.str}<br>
				Dexterity: ${playerCharacter.dex}<br>
				Constitution: ${playerCharacter.con}<br>
				Intelligence: ${playerCharacter.intel}<br>
				Wisdom: ${playerCharacter.wis}<br>
				Charisma: ${playerCharacter.cha}<br><br>
				Victories: ${playerCharacter.wins } <br>
				Defeats: ${playerCharacter.losses } <br>
				You fled from combat ${playerCharacter.flees} times
				</h3>
				<br>
				
				<form action="/new-character"> 		
		<input class="btn btn-outline-primary" type="submit" value="Create another character">
				<h4></h4>
				</form>	
				<br>
				
				<form action="/inventory-list"> 		
		<input class="btn btn-outline-primary" type="submit" value="View Your Inventory">
				</form>	<br>
				
				<form action="/buy-potion"> 		
		<span title = "Exchange your hard earned gold for goods. Potions are 15 gold each, but perhaps your charisma will influence the price..."><input class="btn btn-outline-primary" type="submit" value="Buy Potions"></span>
				</form>	<!-- Checks your inventory for gold. Allows you to buy one potion at a time whenever your gold is sufficient. -->
				
			</div>
			<div class="column">
				<h1>Current Location</h1>
				<br/><div id="demo"></div><br/>
				<h1>Dungeons</h1>
				<p style="color: red">${error}</p>
				
				<c:forEach var="r" items="${listOfResults.result}">
					<h3>${r.name }</h3>
					<form action="/test">
						<span title = "Click to enter a dungeon when you are withing range. If you are not within range, you will be returned to this page."><input class = "btn btn-outline-success"type="hidden" id="userLat" name="userLat"
							value="${userLat }" /> <input type="hidden" id="userLng"
							name="userLng" value="${userLng }" /> <input type="hidden"
							name="placeLat" value="${r.geometry.location.lat }" /> <input
							type="hidden" name="placeLng" value="${r.geometry.location.lng }" />
						<input type="submit" class="btn btn-outline-success" value="Enter this dungeon" /></span>
					</form>
					<br />
				</c:forEach>
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
				navigator.geolocation.watchPosition(showPosition, error, options);
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