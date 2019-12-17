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

<style>
* {
	box-sizing: border-box;
}

/* Create two equal columns that floats next to each other */
.column {
	float: left;
	width: 50%;
	padding: 10px;
}

/* Clear floats after the columns */
.row:after {
	content: "";
	display: table;
	clear: both;
}
</style>

</head>
<body>
<h1>Welcome to Dungeon Go!</h1>


<div class="container">
		<div class="jumbotron">
		
<form action="/login">
	
		Username <input type="text" name="userName" size="22" required>
		Password <input type="text" name="userPassword" size="22" required> 
		
		<input class="btn-primary" type="submit" value="Login">
	<br>
	${wrongPassword }
	${noUserName }
	
	</form>

<a href="/new-user" class="btn btn-primary">Create new user</a>

	<!--  <a href="/get-results" class="btn btn-primary">${userInfo } Let's Play!</a>
	<h3></h3> -->
	<a href="/character-select" class="btn btn-primary">Test button for characterSelect!</a>
	<h3></h3>
	<a href="/character-select" class="btn btn-primary">Test button for characterSelect!</a>
	<h3></h3>
	
	</div>
	</div>
</body>
</html>