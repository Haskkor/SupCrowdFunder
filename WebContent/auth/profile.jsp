<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" type="text/css" href="../style/SupCrowdfunder.css" />
		<title>My profile</title>
	</head>
	
	<%@ include file="../template/header.jsp"%>
		<div>
			<c:choose>
				<c:when test="${userlogged.getUright() == 1}">
					<h1> ${userlogged.getName()} ${userlogged.getLastName()}</h1><h4>(Admin)</h4>
				</c:when>
				<c:otherwise>
					<h1>${userlogged.getName()} ${userlogged.getLastName()}</h1>
				</c:otherwise>
			</c:choose>	
			<div class="form">
				<form action="modifUser" method="post">
					<fieldset>
					<legend>Current informations, you can modify your settings</legend>
						<label for="username">Name : </label> 
							<input type="text" id="username" name="username" value="${userlogged.getName()}" />
						<label for="username">LastName : </label> 
							<input type="text" id="userlastname" name="userlastname" value="${userlogged.getLastName()}"  />
						<label>E-mail : </label> 
							<input type="text" id="email" name="email" value="${userlogged.getMailAddress()}" /> 
						<label>Password : </label>
							<input class="mypass" type="password"	id="password" value="${userlogged.getPassword()}" name="password"  />
							<input id="check" type="checkbox" onchange="document.getElementById('password').type = this.checked ? 'text' : 'password'">
						<div class="button"> 
								<button type="submit">Modify Profile</button> 
						</div>
					</fieldset>
					<div class="info"><p><h4>For the teacher </h4>: </br> The first user created is an administrator</p></div>
				</form>
			</div>
		</div>
	</body>
	
	<%@ include file="../template/footer.jsp"%>
	
</html>