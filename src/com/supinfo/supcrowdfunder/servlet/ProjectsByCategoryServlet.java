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
import com.supinfo.supcrowdfunder.entity.Category;
import com.supinfo.supcrowdfunder.entity.Project;

@SuppressWarnings("serial")
@WebServlet("/projectsByCategory")
public class ProjectsByCategoryServlet extends HttpServlet{
	
	private ProjectDao projectDao;
	private CategoryDao categoryDao;
	
	@Override
	public void init() throws ServletException {
		projectDao = DaoFactory.getInstance().getProjectDao();
		categoryDao = DaoFactory.getInstance().getCategoryDao();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Category> categories = categoryDao.getAllCategories();
		request.setAttribute("categories", categories);
		request.getRequestDispatcher("/projectsByCategory.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Category> categories = categoryDao.getAllCategories();
		req.setAttribute("categories", categories);
		String categoryIdParam = req.getParameter("categoryId");
		Long categoryId = Long.valueOf(categoryIdParam);
		List<Project> project = projectDao.getProjectsByCategory(categoryId);
		req.setAttribute("project", project);
		req.getRequestDispatcher("/projectsByCategory.jsp").forward(req, resp);
	}
}
