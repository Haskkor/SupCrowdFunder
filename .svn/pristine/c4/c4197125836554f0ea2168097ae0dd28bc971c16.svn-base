<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>

<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" type="text/css" href="../style/SupCrowdfunder.css" />
		<link rel="stylesheet" type="text/css" href="../style/CSStable.css" />
		<title>Administration Category</title>
	</head>
	
		<%@ include file="../template/header.jsp"%>
		
		<div class="profilDetail" id="nav_admin">
		
			<nav  class="menuTransitionBackground">
				<a href="<%= contextPath %>/auth/DashboardCategory">Administrate Categories</a>
				<a href="<%= contextPath %>/auth/DashboardProject">Administrate Projects</a>
				<a href="<%= contextPath %>/auth/DashboardUser">Administrate Users</a>
			</nav>
			
		</div>
		
		<div class="form ">
			<form action="DashboardCategory" method="post">
				<fieldset>
					<legend>Create Category</legend>
				
		    	    <label for="nameCategory">Name Category : </label>
		        	<input type="text" id="nameCategory" name="nameCategory"/>
		        
		       		<label for="descCategory">Content Category : </label>
		        	<input type="text" id="descCategory" name="descCategory"/>
		        
		   			<div class="button">
		        		<button type="submit">Create Category</button>
		    		</div>
				</fieldset>
			</form>
		</div>
		
		<div class="CSStable">
			<table>
				<caption><h1>Category Administration</h1></caption>
					<thead>
						<tr>
							<th>Category Name</th>
							<th>Category Description</th>
							<th colspan="2">Action</th>
						</tr>
					</thead>
				<tbody>
					<c:forEach items="${category}" var="c">
							<tr>
								<form action="DashboardCategoryEdit" method="post">
									<input type="hidden" name="categoryIdEdit" value="${c.catId}">
									<td><input type="text" name="categoryNameEdit" value="${c.cname}"></td>
									<td><input type="text" name="categoryDescriptionEdit" value="${c.cdesc}"></td>
									<td><button type="submit" name="applyCategoryEdit">Edit</button></td>
								</form>
	 							<form action="DashboardCategoryRemove" method="post">
	 								<td><button type="submit" name="applyCategoryRemove">Remove</button></td>
									<input type="hidden" name="categoryIdRemove" value="${c.catId}">
								</form>
							</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		
		<%@ include file="../template/footer.jsp"%>
		
	</body>
</html>