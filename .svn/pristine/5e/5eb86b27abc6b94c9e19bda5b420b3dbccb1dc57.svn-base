<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" type="text/css" href="../style/SupCrowdfunder.css" />
		<title>Donate to project</title>
	</head>
	
		<%@ include file="../template/header.jsp" %>
	
		<div class="form ">
		
			<form action="donate" method="post">
			
				<fieldset>
					<legend>Billing for <c:out value="${projectdon.name}"></c:out></legend>
					
			        <label for="cardownername">Card owner name and lastname : </label>
			        <input type="text" id="cardownername" name="cardownername" required/>
			        
			        <label for="cardnumber">Card number <br> (16 digits): </label>
			        <input type="number" id="cardnumber" name="cardnumber" pattern="[0-9]{16}" required/>
			        
	    		    <label for="cardcrypto">Card cryptogram <br>(3 digits):</label>
			        <input type="number" id="cardcrypto" name="cardcrypto" pattern="[0-9]{3}" required/>
		
			        <label for="donationamount">How much do you want to donate : </label>
			        <input type="number" id="donationamount" name="donationamount" required/>
	
			   		<div class="button">
			        	<button type="submit">Add donation</button>
			    	</div>
				</fieldset>
				
			</form>
			
		</div>
		
	</body>
	
	<%@ include file="../template/footer.jsp" %>
	
</html>