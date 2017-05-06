package com.supinfo.supcrowdfunder.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.supinfo.supcrowdfunder.dao.DaoFactory;
import com.supinfo.supcrowdfunder.dao.ProjectDao;

@SuppressWarnings("serial")
@WebServlet("/auth/DashboardProjectRemove")
public class DashboardProjRemoveServlet extends HttpServlet {

	private ProjectDao projectDao;
	
	@Override
	public void init() throws ServletException {
		projectDao = DaoFactory.getInstance().getProjectDao();
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String projTemp = request.getParameter("projectIdRemove");
		Long projId = Long.valueOf(projTemp);
		
		projectDao.removeProject(projId);
		request.getSession().setAttribute("event", "1");
		request.getSession().setAttribute("message", "Project removed");
		response.sendRedirect(getServletContext().getContextPath() + "/auth/DashboardProject");
	}
}