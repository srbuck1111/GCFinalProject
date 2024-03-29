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
<link href='https://fonts.googleapis.com/css?family=Cinzel Decorative'
	rel='stylesheet'>
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

h6 {
	font-family: 'Cinzel Decorative';
	font-size: 30px;
	text-shadow: black 0.3em 0.2em 0.2em
}

h4 {
	font-family: 'Cinzel Decorative';
	font-size: 45px;
	text-shadow: black 0.3em 0.2em 0.2em
}

h3 {
	font-family: 'Cinzel Decorative';
	font-size: 20px;
	text-shadow: black 0.3em 0.2em 0.2em
}

body {
	background-image:
		url("http://getwallpapers.com/wallpaper/full/a/d/f/373564.jpg");
	background-repeat: no-repeat;
	background-position: relative;
	background-size: cover;
	opacity: .75;
}
audio { display:none;}
</style>
<!-- On click for combat buttons sound https://www.shockwave-sound.com/sound-effects/fighting-sounds/sword%20clank%20with%20scrape%20MP3.mp3
 -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	<a class="navbar-brand">Dungeon Go!</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarColor02" aria-controls="navbarColor02"
		aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarColor02">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item"><a class="nav-link"> </a></li>
			<li class="nav-item"><a class="nav-link"></a></li>
			<li class="nav-item"><a class="nav-link"></a></li>
		</ul>
		<button class="btn btn-secondary my-2 my-sm-0" type="submit">
			<a href="/">Logout</a>
		</button>


	</div>
</nav>
</head>
<body onLoad="load()">
<audio controls autoplay>
   <source src="http://www.ffmages.com/ffvii/ost/disc-1/10-let-the-battles-begin.mp3" type="audio/mpeg">
</audio>
	
	<!-- this checks if either you or the enemy is alive and redirects to main if either is dead -->
	<form id="aliveCheck" action="get-results">
		<input type="hidden" value="${playerCharacter.hp }" id="playerHp">
		<input type="hidden" value="${monster.hp }" id="monsterHp"> 
		<input type="hidden" value="${encounterInfo.userTurn }" id="userTurn">
		<input type="hidden" value="${encounterInfo.potions }" id="potions">	
	</form>

	<div>
		<div class="row">

			<div class="column">
				<center>
					<h4>${playerCharacter.firstName }${playerCharacter.lastName }</h4>
					<h6>Hp: ${playerCharacter.hp }</h6>
					<h6>Ac: ${playerCharacter.ac }</h6>
					<br> <img alt="Player Image" src="${playerCharacter.imageUrl}"><br />
				</center>
			</div>

			<div class="column">
				<center>
					<h4>Combat Info</h4>
					<br> <br> <a style="visibility: hidden" id="attackBtn"
						class="btn btn-secondary" href="/encounter/attack">Attack</a><br />
					<br> <a style="visibility: hidden" id="fleeBtn"
						class="btn btn-secondary" href="/encounter/flee">Flee</a><br /> <br>
					<a style="visibility: hidden" id="potionBtn"
						class="btn btn-secondary" href="/encounter/drink-potion">Drink Potion</a><br />
					<a style="visibility: hidden" id="defendBtn"
						class="btn btn-secondary" href="/encounter/defend">Defend</a>
					<br> <br> <br> <br> <br> <br> <br>
					<br>
					<h3>${encounterInfo.getText() }</h3>
				</center>
			</div>

			<div class="column">
				<center>
					<h4>${monster.name }</h4>
					<h6>Hp: ${monster.hp }</h6>
					<h6>Ac: ${monster.ac }</h6>
					<br> <img alt="Enemy Image" src="${monster.imageUrl}">
				</center>

			</div>
		</div>
	</div>

	<script>
		var mHp = document.getElementById("monsterHp");
		var pHp = document.getElementById("playerHp");

		var userTurn = document.getElementById("userTurn");
		var pots = document.getElementById("potions");
		
		var atkBtn = document.getElementById("attackBtn");
		var fleeBtn = document.getElementById("fleeBtn");
		var defBtn = document.getElementById("defendBtn");
		var potBtn = document.getElementById("potionBtn");

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
				if (pots.value > 0) {
					potBtn.style.visibility = "visible";
				}
			}
		}
	</script>
</body>
</html>