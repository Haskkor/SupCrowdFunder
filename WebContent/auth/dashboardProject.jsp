<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<% String date =  String.valueOf(request.getSession().getAttribute("todayDate"));%>

<!DOCTYPE html>

<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" type="text/css" href="../style/SupCrowdfunder.css" />
		<link rel="stylesheet" type="text/css" href="../style/CSStable.css" />
		<title>Administration Project</title>
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
	
		<form action="DashboardProject" method="post">
			<fieldset>
				<legend>Create Project</legend>
					<label for="creator">Creator : </label>
					<input type="text" id="creator" name="creator" value="${userlogged.getName()}" disabled/>

					<label for="name">Project's name : </label>
					<input type="text" id="name" name="name" required/>

					<label for="creationDate">Creation Date : </label>
					<input type="text" id="creationDate" name="creationDate" value=<%= date %> disabled/>

					<label for="completionDate">Completion Date : </label>
					<input type="date" id="completionDate" name="completionDate" min=<%= date %> required/>
					
					<label for="amountNeeded">Amount Needed : </label>
					<input type="number" id="amountNeeded" name="amountNeeded" required/>$					

					<label for="description">Description : </label>
					<textarea name="description" id="description" required></textarea>
				<div>
					<label for="category">Category : </label> 
					<select id="category" name="categoryId" required>
						<option value="">-- Select Category --</option>
						<c:forEach items="${categories}" var="c">
							<option value="${c.catId}"><c:out value="${c.cname}"></c:out></option>
						</c:forEach>
					</select>
				</div>
				
				<input type="submit" value="Submit" />
			</fieldset>
		</form>
		
	</div>
	
	<div class="CSStable">
		<table>
			<caption><h1>Project Administration</h1></caption>
			
				<thead>
					<tr>
						<th>Creator</th>
						<th>Project Name</th>
						<th>Completion Date</th>
						<th>Amount Needed</th>
						<th>Description</th>
						<th>Category</th>
						<th colspan="2">Action</th>
					</tr>
				</thead>
				
				<tbody>
					<c:forEach items="${project}" var="p">
						<tr>
							<form action="DashboardProjectEdit" method="post">
								<input type="hidden" name="projectIdEdit" value="${p.projectId}">
								<td><input type="text" name="projectCreatorEdit" value="${p.creator}"></td>
								<td><input type="text" name="projectNameEdit" value="${p.name}"></td>
								<td><input type="text" name="projectCompletionDateEdit" value="${p.completionDate}"></td>
								<td><input type="number" name="projectAmountNeededEdit" value="${p.amountNeeded}"></td>
								<td ><input type="text" name="projectDescriptionEdit" value="${p.description}"></td>
								<td>
									<select "id="projectCategoryNameEdit" name="projectCategoryIdEdit">
										<option value="${p.category.catId}">${p.category.cname}</option>
										<c:forEach items="${categories}" var="c">
											<option value="${c.catId}"><c:out value="${c.cname}"></c:out></option>
										</c:forEach>
									</select>
								</td>														
								<td><button type="submit" name="projectEdit">Edit</button></td>
							</form>
							<form action="DashboardProjectRemove" method="post">
	 							<td><button type="submit" name="applyProjectRemove">Remove</button></td>
								<input type="hidden" name="projectIdRemove" value="${p.projectId}">
							</form>
						</tr>
					</c:forEach>
				</tbody>
				
		</table>
	</div>
	
		<%@ include file="../template/footer.jsp"%>
		
</body>

</html>