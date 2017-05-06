<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" type="text/css" href="style/SupCrowdfunder.css" />
		<link rel="stylesheet" type="text/css" href="style/CSStable.css" />
		<title>Categories</title>
	</head>
	
		<%@ include file="/template/header.jsp" %>
		
		<div id="content">
			<div class="form ">
				<form action="projectsByCategory" method="post">
					<fieldset>
						<legend>Project By Category</legend>
						<label for="category">Category : </label> 
						<select id="category" name="categoryId">
							<option value="1">-- Select Category --</option>
							<c:forEach items="${categories}" var="c">
								<option value="${c.catId}"><c:out value="${c.cname}"></c:out></option>
							</c:forEach>
						</select>
						<div class="button">
							<button type="submit">Display projects</button>
						</div>
					</fieldset>
				</form>
			</div>
			<c:choose>
				<c:when test="${empty project}">
					<h1>No Category Selected</h1>
				</c:when>
				<c:otherwise>
				<div class="CSStable">
					<table>
						<caption>
							<h1>Project's list by category</h1>
						</caption>
						<tbody>
							<tr>
								<th>Project's name</th>
								<th>Creator</th>
								<th>Category</th>
								<th>Description</th>
								<th>Creation date</th>
								<th>Completion date</th>
								<th>Completion percentage</th>
								<th>Funding needed</th>
								<th>Donations</th>
								<th></th>
							</tr>
							<c:forEach items="${project}" var="project">
								<tr>
									<td>${project.name}</td>
									<td>${project.creator}</td>
									<td>${project.category.cname}</td>
									<td>${project.description}</td>
									<td>${project.creationDate}</td>
									<td>${project.completionDate}</td>
									<td>${project.donationAmount div project.amountNeeded * 100}  %</td>
									<td>${project.amountNeeded}</td>
									<td>${project.donationAmount}</td>
									<td><a href="<%= contextPath %>/projectDetails?projectId=${project.projectId}"><c:out value="View project details" /></a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				</c:otherwise>
			</c:choose>
		</div>
	</body>
	
	<%@ include file="/template/footer.jsp" %>

</html>