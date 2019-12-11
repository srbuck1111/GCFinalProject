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
	<div class="jumbotron">
		<div class="row">
			<div class="column">
				<h1>User information</h1>
				<h1>Side 1</h1>
				<p style="color: red">${error}</p>
			</div>
			<div class="column">
				<h1>Side 2</h1>
				<c:forEach var="r" items="${listOfResults.result}">
					<h3>${r.name }</h3>
					<form action="/test"> 
						<input type="hidden" name="placeLat" value="${r.geometry.location.lat }" /> 
						<input type="hidden" name="placeLng" value="${r.geometry.location.lng }" />
						<input type="submit" value="im here" />
					</form>
					<br />
				</c:forEach>
			</div>
		</div>
	</div>
</body>
</html>