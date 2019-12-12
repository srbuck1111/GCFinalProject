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
<h3>Fight!</h3>
You roll to hit ${encounter.getEnemies().get(0).getFirstName() }<br/>
You got a ${playerDieRoll } to hit.<br/>
<c:if test="${playerDmg > 0}">
<c:out value="It hits for ${playerDmg } damage!"/>
</c:if>
${playerMissed }<br/><br/>
But, ${encounter.getEnemies().get(0).getFirstName() } tries to hit you back!<br/>
${encounter.getEnemies().get(0).getFirstName() } got a ${enemyDieRoll } to hit.<br/>
<c:if test="${enemyDmg > 0}">
<c:out value="It hits for ${enemyDmg } damage!"/>
</c:if>
${enemyMissed }<br/><br/>
You have ${encounter.getPlayer().getHp() } hp left.<br/><br/>
<a class="btn-primary" href="/encounter/fight">Next round of combat!</a>
</body>
</html>