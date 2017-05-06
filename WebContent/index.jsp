<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" type="text/css" href="style/SupCrowdfunder.css" />
		<title>SupCrowdfunder</title>
	</head>
									
		<%@ include file="template/header.jsp"%>
	
		<div>
			<h1>SupCrowdfunder projects</h1>
				
			<c:choose>
				<c:when test="${empty project}">
					<h2>No project to display.</h2>
				</c:when>
			<c:otherwise>
			<div class="container">
				<c:forEach items="${project}" var="project">
					<section>
						<article>
							<h2>
								<a href="<%= contextPath %>/projectDetails?projectId=${project.projectId}"><c:out value="${project.name}" /></a>
							</h2>
							<h3>
								Creator :
								<c:out value="${project.creator}" />
							</h3>
							<h4>
								Project category :
								<c:out value="${project.category.cname}" />
							</h4>
							<p class="content">
								<c:out value="${project.description}" />
							</p>
							<p>
								Creation date :
								<c:out value="${project.creationDate}" />
							</p>
							<p>
								Completion date :
								<c:out value="${project.completionDate}" />
							</p>
							<p>
								Completion percentage :
								<c:out value="${project.donationAmount div project.amountNeeded * 100}" />%
							</p>
							<p>
								Funding needed :
								<c:out value="${project.amountNeeded}" />$
							</p>
							<p>
								Donations :
								<c:out value="${project.donationAmount}" />
							</p>
						</article>
					</section>
				</c:forEach>
			</div>
			</c:otherwise>
			</c:choose>
		</div>
		
	</body>
	
	<%@ include file="template/footer.jsp"%>
	
</html>