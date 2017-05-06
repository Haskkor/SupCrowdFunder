package com.supinfo.supcrowdfunder.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.supinfo.supcrowdfunder.dao.DaoFactory;
import com.supinfo.supcrowdfunder.dao.ProjectDao;
import com.supinfo.supcrowdfunder.entity.Project;

@SuppressWarnings("serial")
@WebServlet("/index")
public class IndexServlet extends HttpServlet {

	private ProjectDao projectDao;

	@Override
	public void init() throws ServletException {
		projectDao = DaoFactory.getInstance().getProjectDao();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		List<Project> project = projectDao.getAllProjects();
		if (project.isEmpty()) {
			resp.sendRedirect(getServletContext().getContextPath()+"/index.jsp");
		}else{
			req.setAttribute("project", project);
			req.getRequestDispatcher("/index.jsp").forward(req, resp);
		}
	}
}