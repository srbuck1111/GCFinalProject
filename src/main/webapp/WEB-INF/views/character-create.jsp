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
<body>
	<div class="jumbotron">
		<div class="row">
			<div class="column">stuf</div>

			<div class="column">
				<div class="row">
					<form action="/new-character">
						<div class="column">
							<div id="str"></div>
							<div id="con"></div>
							<div id="dex"></div>
						</div>

						<div class="column">
							<div id="int"></div>
							<div id="wis"></div>
							<div id="con"></div>
						</div>
					</form>
				</div>
				<div id="pointsRemaining"></div>
			</div>
		</div>
	</div>

	<script>

	var str = document.getElementById("str");
	var con = document.getElementById("con");
	var dex = document.getElementById("dex");
	var intel = document.getElementById("int");
	var wis = document.getElementById("wis");
	var cha = document.getElementById("cha");
	var pointsRemaining = document.getElementById("pointsRemaining");

		function spendPoint(choice, plus) {
			if (plus) {
				
			}
		}
	</script>
</body>
</html>