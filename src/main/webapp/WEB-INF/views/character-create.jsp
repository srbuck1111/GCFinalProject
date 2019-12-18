<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Character</title>
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
body {
  background-image: url("https://wallpaperplay.com/walls/full/8/c/6/102152.jpg");
background-repeat: no-repeat;
background-position: relative;
 background-size: cover;
 opacity: .75;
 

}
h6 {
 font-family: 'Cinzel Decorative'; font-size: 30px; color: black; 
 text-shadow: black 0.3em 0.2em 0.2em
}
h5 {
 font-family: 'Cinzel Decorative'; font-size: 20px; color: black;
 text-shadow: black 0.3em 0.2em 0.2em
}
</style>
</head>
<body onLoad="checkPointBuy()">
<form action="/add-character" onSubmit="checkPointBuy()">
	<div>
		<div class="row">
			<div class="column">
			<input class="btn btn-secondary" placeholder="First Name" type="text" name="firstName" required/><br/><br/>
			<input class="btn btn-secondary"placeholder="Last Name" type="text" name="lastName" required/><br/><br/>
			Need help? Hover over fields for additional details! <br><br>
			<span title = "Click to choose your character class!"><select class = "btn btn-warning" name="classId">
				<c:forEach var="c" items="${classes }">
					<option value="${c.index }">${c.name }</option>
				</c:forEach>
			</select></span>
			</div>
			<div class="column">
				<h6>Strength</h6><span title="Strength increases your damage potential"><input min="8" max="16" class="btn btn-outline-secondary" value="10" id="str" type="number" name="str" oninput="checkPointBuy()"/></Span><br/>
				<h6>Constitution</h6><span title = "Constitution increases your health and endurance"><input min="8" max="16" class="btn btn-outline-secondary" value="10" id="con" type="number" name="con" oninput="checkPointBuy()"/></Span><br/>
				<h6>Dexterity</h6><span title = "Dexterity increases damage with ranged weapons"><input min="8" max="16" class="btn btn-outline-secondary" value="10" id="dex" type="number" name="dex" oninput="checkPointBuy()"/></Span><br/>
				<h6>Intelligence</h6><span title = "Intelligence controls your skill with magic, and stat points per level"><input min="8" max="16" class="btn btn-outline-secondary" value="10" id="int" type="number" name="intel" oninput="checkPointBuy()"/></Span><br/>
				<h6>Wisdom</h6><span title = "Wisdom contributes to your ability to heal and cast certain spells"><input min="8" max="16" class="btn btn-outline-secondary" value="10" id="wis" type="number" name="wis" oninput="checkPointBuy()"/></Span><br/>
				<h6>Charisma</h6><span title = "Charisma is all about talking your way our of tough situations"><input min="8" max="16" class="btn btn-outline-secondary" value="10" id="cha" type="number" name="cha" oninput="checkPointBuy()"/></Span><br/>
				<br/>
				<h5>Points Remaining:</h5>
				<input class="btn btn-secondary" type="text" id="pointsRemaining"/>
				<input class="btn btn-success" type="submit" value="Create"/>
				<div id="alertHigh" style="color:red"></div>
				<div id="alertLow" style="color:red"></div>
			</div>
		</div>
	</div>
</form>

	<script>
		var str = document.getElementById("str");
		var con = document.getElementById("con");
		var dex = document.getElementById("dex");
		var intel = document.getElementById("int");
		var wis = document.getElementById("wis");
		var cha = document.getElementById("cha");
		var pointsRemaining = document.getElementById("pointsRemaining");
		var alertHigh = document.getElementById("alertHigh");
		var alertLow = document.getElementById("alertLow");
		
		function checkPointBuy() {
			pointsRemaining.style = null;
			alertHigh.innerHTML = null;
			alertLow.innerHTML = null;
			pointsRemaining.value = 75 - str.value - con.value - dex.value - intel.value - wis.value - cha.value;
			if (pointsRemaining.value < 0) {
				pointsRemaining.value = "not enough points!";
				pointsRemaining.style = "color:red";
			}
			if (str.value > 20 || con.value > 20 || dex.value > 20 || intel.value > 20 || wis.value > 20 || cha.value > 20) {
				alertHigh.innerHTML = "stats cannot be higher than 20!";
			}
			if (str.value <= 0 || con.value <= 0 || dex.value <= 0 || intel.value <= 0 || wis.value <= 0 || cha.value <= 0) {
				alertLow.innerHTML = "your character will immediately die with those stats!<br/>We suggest at least a 6 in all stats, but a 1 is minimum.";
			}
		}
	</script>
</body>
</html>