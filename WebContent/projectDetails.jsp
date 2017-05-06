<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>

<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Project details</title>
		<link rel="stylesheet" type="text/css" href="style/SupCrowdfunder.css" />
		<link rel="stylesheet" type="text/css" href="style/CSStable.css" />
		<link rel="stylesheet" type="text/css" href="../style/SupCrowdfunder.css" />
		<link rel="stylesheet" type="text/css" href="../style/CSStable.css" />
	</head>
	
		<%@ include file="/template/header.jsp"%>
		
		<div class="form" id="projectDetails">
			<c:choose>
				<c:when test="${empty project}">
					<h1>No projects to display.</h1>
				</c:when>
				<c:otherwise>
				<div class="CSStable">
					<table>
						<caption><h1>${project.name}</h1></caption>
							<thead>
								<tr>
									<th>Creator</th>
									<th>Category</th>
									<th>Description</th>
									<th>Creation date</th>
									<th>Completion date</th>
									<th>Completion percentage</th>
									<th>Donations</th>
		
								</tr>
							</thead>
							<tbody>
							<tr>
								<td>${project.creator}</td>
								<td>${project.category.cname}</td>
								<td class="tdDesc">${project.description}</td>
								<td>${project.creationDate}</td>
								<td>${project.completionDate}</td>
								<td>${project.donationAmount div project.amountNeeded * 100} %</td>
								<td>${project.donationAmount}</td>
							</tr>
						</tbody>
					</table>
				</div>
				<div>
				<form action="/SupCrowdfunder/auth/donate" method="get">
					<input type="hidden" value="${project.projectId}"  name="projectid" />
					<input type="submit" value="Donate" />
				</form>
				</div>
				</c:otherwise>
			</c:choose>
		</div>
	</body>
	
	<%@ include file="template/footer.jsp"%>
	
</html>