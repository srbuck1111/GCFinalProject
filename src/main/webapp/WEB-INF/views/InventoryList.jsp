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
	<link href='https://fonts.googleapis.com/css?family=Cinzel Decorative' rel='stylesheet'>
	<style>
* h1 {
 font-family: 'Cinzel Decorative'; font-size: 75px;
 text-shadow: white 0.3em 0.2em 0.2em
}

h4 {
 font-family: 'Cinzel Decorative'; font-size: 45px; 
 text-shadow: white 0.3em 0.2em 0.2em
}

td {
font-size: 20px; 
 
}

</style>
</head>



<body>
<div class="container">
	
		<center><h1>Inventory</h1></center>
	<table width="75%" class="table" >
		<tr>
			<th><h4>Item Name</h4></th>
			<th><h4>Equip?</h4></th>
			
		</tr>

		<c:forEach var="inv" varStatus="loop" items="${equipmentList }">
			<tr>
				<td>${inv.name }</td>
			<td><input class="btn btn-outline-primary" type="submit" value="Equip"></td>
		</c:forEach> 
	</table> 
	</div></div>
</body>
</html>