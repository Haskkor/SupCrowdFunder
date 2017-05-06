<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<% String date =  String.valueOf(request.getSession().getAttribute("todayDate"));%>

<!DOCTYPE html>

<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" type="text/css" href="../style/CSStable.css" />
			<link rel="stylesheet" type="text/css" href="../style/SupCrowdfunder.css" />
		<title>Dashboard</title>
	</head>
	
		<%@ include file="../template/header.jsp"%>
		
		<div class="contain" id="nav_admin">
			<nav class="menuTransitionBackground">
				<a href="<%= contextPath %>/auth/DashboardCategory">Administrate Categories</a>
				<a href="<%= contextPath %>/auth/DashboardProject">Administrate Projects</a>
				<a href="<%= contextPath %>/auth/DashboardUser">Administrate Users</a>
			</nav>
		</div>
		</br>
		
		<div class="CSStable">
			<fieldset>
				<legend>Total Donation</legend>
				<h1>${total} $</h1>
			</fieldset>
		</div>
		
		<div class="form" >
			<form action="dashboard" method="POST">
				<fieldset>
					<legend>Project Display by date</legend>
		    		<label for="firstDate">Select 1st Date </label>
		    		<input type="date" id="firstDate" name="firstDate" value="<%= date %>"/>
		        
		   			<label for="secondDate">Select 2nd Date </label>
		    		<input type="date" id="secondDate" name="secondDate" value="<%= date %>"/>
		        
		    		<div class="button">
		        		<button type="submit">Sort</button>
		    		</div>
				</fieldset>
			</form>
			</br>
			<c:choose>
				<c:when test="${empty listProjectSorted}">
					<h1>No Date Selected<h1>
				</c:when>
				
				<c:otherwise>
					<div class="CSStable">
						<table>
							<caption><h1>${numberProjectSorted} Project(s) created between ${firstDate} and ${secondDate }</h1></caption>
							<tbody>
								<tr>
									<th>Creator</th>
									<th>Category</th>
									<th>Name</th>
									<th>Creation date</th>
									<th>Completion date</th>
									<th>Completion percentage</th>
									<th>Donations</th>
								</tr>					
								<c:forEach items="${listProjectSorted}" var="c">
								<tr>
									<td>${c.creator}</td>
									<td>${c.category.cname}</td>
									<td>${c.name}</td>
									<td>${c.creationDate}</td>
									<td>${c.completionDate}</td>
									<td>${project.donationAmount div project.amountNeeded * 100} %</td>
									<td>${c.donationAmount}</td>
								</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</c:otherwise>
			</c:choose>
		</div>
		
	</body>
	
	<%@ include file="../template/footer.jsp"%>
	
</html>