<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link
	href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/cyborg/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-mtS696VnV9qeIoC8w/PrPoRzJ5gwydRVn0oQ9b+RJOPxE1Z1jXuuJcyeNxvNZhdx"
	crossorigin="anonymous">
</head>
<body>
<style>
h2 {color:green;}
h3 {color:gold;}
</style>
	<h2>${combatMessage}</h2>
	<br>
	<img alt="resultImage" src="${URL}">
	<br>
	<br>
	<h3> Your loot is: ${lootMessage}</h3>
	
	<br> ${dieTotal } ${fightWin } ${fightLose }
	
	<br>${gold }
	
	<form method="get" action="/event-end">
		<button type="submit">event-end test button</button>
	</form>

	<form method="get" action="/get-results">
		<button type="submit" >Back To Home</button>
	</form>


</body>
</html>