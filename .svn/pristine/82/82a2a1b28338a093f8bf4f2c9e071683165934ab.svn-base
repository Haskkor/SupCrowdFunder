<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%	
	boolean logged = request.getSession().getAttribute("userlogged") != null;
	String contextPath = getServletContext().getContextPath();
	
	// Format the date and send it to session
	java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
	String todayDate = sdf.format(new java.util.Date());
	request.getSession().setAttribute("todayDate", todayDate);
%>

<header>

	<h1>SupCrowdfunder</h1>
	<nav class="menuTransitionBackground">
		<ul style="list-style: none;">
			<li><a href="<%= contextPath %>/index">Homepage</a></li>
			<li><a href="<%= contextPath %>/projectsByCategory">Browse project</a></li>
			<% if(logged) { %>
				<li><a href="<%= contextPath %>/auth/createProject">Add Project</a></li>
				<c:choose>
					<c:when test="${userlogged.getUright() == 1}">
						<li><a href="<%= contextPath %>/auth/profile.jsp">Hi ${userlogged.getName()} (admin)</a></li>
						<li><a href="<%= contextPath %>/auth/dashboard">Dashboard</a></li>
					</c:when>
					<c:otherwise>
						<li><a href="<%= contextPath %>/auth/profile.jsp">Hi ${userlogged.getName()}</a></li>				
					</c:otherwise>
				</c:choose>
				<li><a href="<%= contextPath %>/logout">Logout</a></li>
			<% } else { %>
			<li><a href="<%= contextPath %>/register.jsp">Register</a></li>
			<li><a href="<%= contextPath %>/login.jsp">Login</a></li>
			<% } %>
		</ul>
	</nav>
</header>

<body>
	<div class="message">
		<c:choose>
			<c:when test="${event == 1}">
				<div class="message-ok">
					<p id="message">${message}</p>
					<%request.getSession().setAttribute("event", null); %>
				</div>
			</c:when>
				<c:when test="${event == 0}">
					<div class="message-ko">
						<p id="message">${message}</p>
						<%request.getSession().setAttribute("event", null); %>
					</div>
				</c:when>
		</c:choose>
	</div>