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
	<c:if test="${win }">
		<h2><c:out value="You slayed the ${monster.name }!"/></h2>
	</c:if>
	<c:if test="${!win }">
		<h2><c:out value="You were slain."/></h2>
	</c:if>
	<a href="/get-results">back to main</a>
</body>
</html>