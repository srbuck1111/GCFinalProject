<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/cyborg/bootstrap.min.css" rel="stylesheet" integrity="sha384-mtS696VnV9qeIoC8w/PrPoRzJ5gwydRVn0oQ9b+RJOPxE1Z1jXuuJcyeNxvNZhdx" crossorigin="anonymous">
</head>
<body>
<!-- uncomment for working mvp
<h1>A Goblin or something appeared!</h1>
<img src="https://kinggames.dk/images/miniatures/reaper/Goblin%20Warrior-p.jpg" alt="Goblin" width="500" height="500">
<h3>What will you do?</h3>
<form method="get" action="/fight">
<a class="btn btn-danger" href="/fight">Murder that goblin (roll a 10 or above)</a>
</form>
<form method="get" action="/flee">
    <a class = "btn btn-danger" href="/flee" >I am a coward, take me back to the main page</a>
</form>
<form method="get" action="/friend">
<a class = "btn btn-danger" href="/friend">Try to be friends (roll a 6 through 15)</a>
</form>
 -->
 <h3>You ran into ${enemy.firstName }!</h3>
 <a class="btn btn-danger" href="/event/encounter">Don't take chances, fight ${enemy.firstName }</a>
 <a class="btn btn-primary" href="/event/talk">Try to speak to ${enemy.firstName }</a>
 <a class="btn btn-secondary" href="/event/walk">Walk away</a>
</body>
</html>