<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<% String date =  String.valueOf(request.getSession().getAttribute("todayDate"));%>

<!DOCTYPE html>

<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" type="text/css" href="../style/SupCrowdfunder.css" />
		<title>Project creation</title>
	</head>
	
	<body>	
	
	<%@ include file="../template/header.jsp"%>
	
		<div class="form" id="content">
		
			<form class="create-form" action="createProject" method="post">
			
				<fieldset>
				
				<legend>Create Project</legend>
				
					<div>
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
					</div>
					
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
	</body>
	
	<%@ include file="../template/footer.jsp"%>
	
</html>