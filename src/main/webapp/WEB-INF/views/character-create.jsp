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
<body onLoad="checkPointBuy()">
<form action="/new-character" onSubmit="checkPointBuy()">
	<div class="jumbotron">
		<div class="row">
			<div class="column">
			<input placeholder="First Name" type="text" name="firstName"/><br/><br/>
			<input placeholder="Last Name" type="text" name="lastName"/><br/><br/>
			<select name="classIndex">
				<c:forEach var="c" items="${classes }">
					<option value="${c.index }">${c.name }</option>
				</c:forEach>
			</select>
			</div>
			<div class="column">
				<h6>STR</h6><input value="10" id="str" type="number" name="str" oninput="checkPointBuy()"/><br/>
				<h6>CON</h6><input value="10" id="con" type="number" name="con" oninput="checkPointBuy()"/><br/>
				<h6>DEX</h6><input value="10" id="dex" type="number" name="dex" oninput="checkPointBuy()"/><br/>
				<h6>INT</h6><input value="10" id="int" type="number" name="intel" oninput="checkPointBuy()"/><br/>
				<h6>WIS</h6><input value="10" id="wis" type="number" name="wis" oninput="checkPointBuy()"/><br/>
				<h6>CHA</h6><input value="10" id="cha" type="number" name="cha" oninput="checkPointBuy()"/><br/>
				<br/>
				Points Remaining:<br/>
				<input type="text" id="pointsRemaining"/>
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