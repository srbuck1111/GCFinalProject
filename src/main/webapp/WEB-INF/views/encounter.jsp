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
	<!-- this checks if the enemy is alive and redirects to main if it's dead -->
	<form id="enemyAliveCheck" action="get-results">
		<input type="hidden" value="${monster.hp }" id="monsterHp">
		<input type="hidden" value="${userTurn }" id="userTurn">
	</form>
	<div class="jumbotron">
		<div class="row">
		
			<div class="column">
				<h4>UserDeets</h4>
				<h6>${playerCharacter.firstName } ${playerCharacter.lastName }</h6>
				<h6>Hp: ${playerCharacter.hp }</h6>
				<h6>Ac: ${playerCharacter.ac }</h6>
				<a id="attackBtn" class="btn" href="/encounter/attack">Attack</a>
				<a id="fleeBtn" class="btn" href="/encounter/flee">Flee</a>
				<a id="defendBtn" class="btn" href="/encounter/defend">Defend</a>
			</div>

			<div class="column">
				<h4>RollsAndStuf</h4>
				${text }
			</div>

			<div class="column">
				<h4>EnemyDeets</h4>
				<h6>${monster.name }</h6>
			</div>
			
		</div>
	</div>
	
	<script>
	
		function load() {
			if (document.getElementById("monsterHp").value <= 0) {
				document.getElementById("enemyAliveCheck").submit();
			}
			if (document.getElementById("userTurn")) {
				document.getElementById("attackBtn").style.visibility = "visible";
				document.getElementById("fleeBtn").style.visibility = "visible";
				document.getElementById("defendBtn").style.visibility = "hidden";
			} else {
				document.getElementById("attackBtn").style.visibility = "hidden";
				document.getElementById("fleeBtn").style.visibility = "hidden";
				document.getElementById("defendBtn").style.visibility = "visible";
			}
		}
	
	</script>
</body>
</html>