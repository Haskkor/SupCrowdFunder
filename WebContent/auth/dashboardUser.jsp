<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>

<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" type="text/css" href="../style/SupCrowdfunder.css" />
		<link rel="stylesheet" type="text/css" href="../style/CSStable.css" />
		<title>Administration User</title>
	</head>
	
	<%@ include file="../template/header.jsp"%>
	
	<div class="profilDetail" id="nav_admin">
		<nav class="menuTransitionBackground">
			<a href="<%= contextPath %>/auth/DashboardCategory">Administrate Categories</a>
			<a href="<%= contextPath %>/auth/DashboardProject">Administrate Projects</a>
			<a href="<%= contextPath %>/auth/DashboardUser">Administrate Users</a>
		</nav>
	</div>
	
	<div class="form ">
	
		<form action="DashboardUser" method="post">
		
			<fieldset>
				<legend>Create User</legend>
				
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
		        
		        <div> <label for="useright">User type : </label>
		        
				<select id="userUrightVal" name="userUrightVal">
						<option value="0">Simple User</option>
						<option value="1">Admin User</option>
				</select></div>
									
		   		<div class="button">
		        	<button type="submit">Register</button>
		    	</div>
		    	
			</fieldset>
			
		</form>
		
	</div>
	
	<div class="CSStable">
	
			<table>
			
				<caption><h1>User Administration</h1></caption>
				
					<thead>
						<tr>
							<th>User Name</th>
							<th>User Lastname</th>
							<th>User Mail</th>
							<th colspan="2">User Password</th>
							<th>User Type</th>
							<th colspan="2">Action</th>
						</tr>
					</thead>
					
					<tbody>
						<c:forEach items="${user}" var="u">
							<tr>
								<form action="DashboardUserEdit" method="post">
									<input type="hidden" name="userIdEdit" value="${u.userId}">
									<td><input type="text" name="userNameEdit" value="${u.name}"></td>
									<td><input type="text" name="userLastNameEdit" value="${u.lastName}"></td>
									<td><input type="text" name="userMailAddressEdit" value="${u.mailAddress}"></td>
									<td><input type="password" name="userPasswordEdit" value="${u.password}"></td> 
									<td>
										<select id="userRightEdit" name="userRightEdit">
											<option value="${u.uright}"><c:choose>
																			<c:when test="${u.getUright() == 1}">
																				<c:out value="Admin User"></c:out>
																			</c:when>
																			<c:otherwise>
																				<c:out value="Simple User"></c:out>				
																			</c:otherwise>
																		</c:choose></option>
											<option value="0">Simple User</option>
											<option value="1">Admin User</option>
										</select>
									</td>
									<td><button type="submit" name="userEdit">Edit</button></td>
								</form>
		 						<form action="DashboardUserRemove" method="post">
		 							<td><button type="submit" name="applyUserRemove">Remove</button></td>
									<input type="hidden" name="userIdRemove" value="${u.userId}">
								</form>
							</tr>
					</c:forEach>
				</tbody>
				
			</table>
		</div>
		
		<%@ include file="../template/footer.jsp"%>
		
	</body>
	
</html>