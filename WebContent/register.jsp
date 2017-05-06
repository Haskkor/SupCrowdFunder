<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>

	<head>
		<link rel="stylesheet" type="text/css" href="style/SupCrowdfunder.css" />
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Register user</title>
	</head>
	
		<%@ include file="template/header.jsp"%>
		
		<div class="form ">
		
			<form action="addUser" method="post">
				<fieldset>
					<legend>Sign In</legend>
					
			        <label for="username">Name : </label>
			        <input type="text" id="username" name="username" required/>
			        
			        <label for="userlastname">Last name : </label>
			        <input type="text" id="userlastname" name="userlastname" required/>
			        
	    		    <label for="email">E-mail:</label>
			        <input type="email" id="email" name="email" required/>
		
			        <label for="password">Password : </label>
			        <input type="password" id="password" name="password" required/>
		
			        <label for="password">Confirm password : </label>
			        <input type="password" id="confpassword" name="confpassword" required/>
			        
			   		<div class="button">
			        	<button type="submit">Register</button>
			    	</div>
				</fieldset>
			</form>
		</div>
		
	</body>

	<%@ include file="template/footer.jsp"%>
	
</html>