<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Fight!</title>
<link
	href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/cyborg/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-mtS696VnV9qeIoC8w/PrPoRzJ5gwydRVn0oQ9b+RJOPxE1Z1jXuuJcyeNxvNZhdx"
	crossorigin="anonymous">
<style>
.column {
	float: left;
	width: 33.33%;
}

.row:after {
	content: "";
	display: table;
	clear: both;
}
</style>
</head>
<body onLoad="load()">
	<!-- this checks if either you or the enemy is alive and redirects to main if either is dead -->
	<form id="aliveCheck" action="get-results">
		<input type="hidden" value="${playerCharacter.hp }" id="playerHp">
		<input type="hidden" value="${monster.hp }" id="monsterHp">
		<input type="hidden" value="${encounterInfo.userTurn }" id="userTurn">
	</form>
	
	<div class="jumbotron">
		<div class="row">
		
			<div class="column">
				<h4>UserDeets</h4>
				<h6>${playerCharacter.firstName } ${playerCharacter.lastName }</h6>
				<h6>Hp: ${playerCharacter.hp }</h6>
				<h6>Ac: ${playerCharacter.ac }</h6>
				<br><br><br>
				<img alt="Player Image" src="${playerCharacter.imageUrl}">
				<a style="visibility:hidden" id="attackBtn" class="btn" href="/encounter/attack">Attack</a><br/>
				<a style="visibility:hidden" id="fleeBtn" class="btn" href="/encounter/flee">Flee</a><br/>
				<a style="visibility:hidden" id="defendBtn" class="btn" href="/encounter/defend">Defend</a><br/>
			</div>

			<div class="column">
				<h4>RollsAndStuf</h4>
				${encounterInfo.text }
			</div>

			<div class="column">
				<h4>EnemyDeets</h4>
				<h6>${monster.name }</h6>
				<h6>Hp: ${monster.hp }</h6>
				<h6>Ac: ${monster.ac }</h6>
				<br>
				<img alt="Enemy Image" src="${monster.imageUrl}">
				
			</div>		
		</div>
	</div>
	
	<script>
	
		var mHp = document.getElementById("monsterHp");
		var pHp = document.getElementById("playerHp");
		
		var userTurn = document.getElementById("userTurn");
		
		var atkBtn = document.getElementById("attackBtn");
		var fleeBtn = document.getElementById("fleeBtn");
		var defBtn = document.getElementById("defendBtn");
		
		function load() {
			//check for either party dead to redirect to main
			if (mHp.value <= 0 || pHp.value <= 0) {
				document.getElementById("aliveCheck").submit();
			}
			//dependent on userTurn value populates correct values
			//if 0, only option is defend
			if (userTurn.value == 0) {
				defBtn.style.visibility = "visible";
			}
			//if 1 or greater populates main actions
			if (userTurn.value >= 1) {
				atkBtn.style.visibility = "visible";
				fleeBtn.style.visibility = "visible";
			} 
			//if greater than 1 poulates bonus actions as well
			if (userTurn.value > 1) {
				//potions and things would go here!
			}
		}
	
	</script>
</body>
</html>