<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inventory</title>
<link
	href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/cyborg/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-mtS696VnV9qeIoC8w/PrPoRzJ5gwydRVn0oQ9b+RJOPxE1Z1jXuuJcyeNxvNZhdx"
	crossorigin="anonymous">
<link href='https://fonts.googleapis.com/css?family=Cinzel Decorative'
	rel='stylesheet'>
<style>
h1 {
	font-family: 'Cinzel Decorative';
	font-size: 75px;
	text-shadow: white 0.3em 0.2em 0.2em
}

h4 {
	font-family: 'Cinzel Decorative';
	font-size: 45px;
	text-shadow: white 0.3em 0.2em 0.2em
}

td {
	font-size: 20px;
}

.btn-wide {
	width: 250px;
}
</style>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	<a class="navbar-brand" href="/get-results">Dungeon Go!</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarColor02" aria-controls="navbarColor02"
		aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarColor02">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item active"><a class="nav-link" href="/get-results">Home
					<span class="sr-only">(current)</span>
			</a></li>
			<li class="nav-item"><a class="nav-link" href="/characterSelect">Select Character</a></li>
			<li class="nav-item"><a class="nav-link" href=""></a></li>
			<li class="nav-item"><a class="nav-link" href="#">About</a></li>
		</ul>
		<button class="btn btn-secondary my-2 my-sm-0" type="submit"><a href="/">Logout</a></button>
		

	</div>
</nav>
</head>



<body>
	<div class="container">

		<h1 align="center">Inventory</h1>

		${weaponSet }
		<table class="table">
			<tr>
				<th><h4>Item Name</h4></th>
				<th><h4>Equip Weapon?</h4></th>

			</tr>
			<c:forEach var="inv" varStatus="loop" items="${equipmentList }">
				<tr>
					<td>${inv.name }</td>

					<td><c:if
							test="${inv.equipmentCategory=='Weapon' and playerCharacter.weaponId!=inv.index}">
							<a
								href='/equip?eCategory=${inv.equipmentCategory }&eId=${inv.index}'
								class='btn btn-outline-primary btn-wide'><c:out
									value="Equip Weapon"></c:out></a>
						</c:if> <c:if test="${playerCharacter.weaponId==inv.index }">
							<c:out value="Equipped"></c:out>
						</c:if></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	</div>


</body>
</html>