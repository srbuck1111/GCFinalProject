<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inventory List</title>
<link href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/sketchy/bootstrap.min.css" rel="stylesheet" integrity="sha384-N8DsABZCqc1XWbg/bAlIDk7AS/yNzT5fcKzg/TwfmTuUqZhGquVmpb5VvfmLcMzp" crossorigin="anonymous">
</head>
<body>
Inventory List
${inventoryList }


<table class="table">
			<tr>
				<th>Inventory ID</th>
				<th>Equipment ID</th>
				<th>QTY</th>
				<th>Player_ID</th>
			</tr>

			<c:forEach var="inv" items="${inventoryList }">
				<tr>
					<td>${inv.inventoryId }</td>
					<td>${inv.equipmentId }</td>
					<td>${inv.qty }</td>

						
			</c:forEach>

</body>
</html>