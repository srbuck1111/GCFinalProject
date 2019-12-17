<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inventory List</title>
<link
	href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/sketchy/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-N8DsABZCqc1XWbg/bAlIDk7AS/yNzT5fcKzg/TwfmTuUqZhGquVmpb5VvfmLcMzp"
	crossorigin="anonymous">
</head>
<body>
	<table class="table">
		<tr>
			<th>Item Name</th>
			<th>Hi</th>
			<th>QTY</th>
			
		</tr>

		<c:forEach var="inv" varStatus="loop" items="${equipmentList }">
			<tr>
				<td>${inv.name }</td>
			<td>Hi</td>
				<td>Hi</td>
		</c:forEach> 
	</table> 
</body>
</html>