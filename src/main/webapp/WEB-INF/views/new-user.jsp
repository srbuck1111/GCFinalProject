<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New User</title>
<link
	href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/sketchy/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-N8DsABZCqc1XWbg/bAlIDk7AS/yNzT5fcKzg/TwfmTuUqZhGquVmpb5VvfmLcMzp"
	crossorigin="anonymous">
</head>
<body>

<div class="container">


${userExists }
<form action="/add-user" onSubmit ="return checkPassword(this)">
	
		Username <input type="text" name="userName" size="22" required>
		Password <input type="text" name="userPassword" size="22" required> 
		Confirm Password <input type="text" name="userPassword2" size="22" required> 
		<input class="btn-primary" type="submit" value="Add User">
	<br>
	
	
	</form>

${userInfo}

 <script> 
          
            // Function to check Whether both passwords 
            // are the  same or not. 
            function checkPassword(form) { 
                password1 = form.userPassword.value; 
                password2 = form.userPassword2.value; 
  
                // If password not entered 
                if (password1 == '') 
                    alert ("Please enter Password"); 
                      
                // If confirm password not entered 
                else if (password2 == '') 
                    alert ("Please enter confirm password"); 
                      
                // If Not same return False.     
                else if (password1 != password2) { 
                    alert ("\nPassword did not match: Please try again...") 
                    return false; 
                } 
  
                // If same return True. 
                else{ 
                   
                    return true; 
                } 
            } 
        </script>

</body>
</html>