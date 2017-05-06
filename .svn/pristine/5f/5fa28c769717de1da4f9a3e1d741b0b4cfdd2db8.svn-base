package com.supinfo.supcrowdfunder.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.supinfo.supcrowdfunder.dao.CategoryDao;
import com.supinfo.supcrowdfunder.dao.DaoFactory;
import com.supinfo.supcrowdfunder.dao.ProjectDao;
import com.supinfo.supcrowdfunder.entity.Project;

@SuppressWarnings("serial")
@WebServlet("/auth/DashboardCategoryRemove")
public class DashboardCatRemoveServlet extends HttpServlet {

	private CategoryDao categoryDao;
	private ProjectDao projectDao;
	
	@Override
	public void init() throws ServletException {
		categoryDao = DaoFactory.getInstance().getCategoryDao();
		projectDao = DaoFactory.getInstance().getProjectDao();
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String catTemp = request.getParameter("categoryIdRemove");
		Long catId = Long.valueOf(catTemp);
		List<Project> listProj = projectDao.getProjectsByCategory(catId);
		
		// Check if projects use the category
		if (!listProj.isEmpty()) {
			request.getSession().setAttribute("event", "0");
			request.getSession().setAttribute("message", "Category not empty");
			response.sendRedirect(getServletContext().getContextPath() + "/auth/DashboardCategory");
		} else {
			categoryDao.removeCategory(catId);
			request.getSession().setAttribute("event", "1");
			request.getSession().setAttribute("message", "Category removed");
			response.sendRedirect(getServletContext().getContextPath() + "/auth/DashboardCategory");
		}
	}
}
