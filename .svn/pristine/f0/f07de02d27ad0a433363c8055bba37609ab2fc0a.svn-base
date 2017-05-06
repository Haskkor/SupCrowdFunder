package com.supinfo.supcrowdfunder.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.supinfo.supcrowdfunder.dao.CategoryDao;
import com.supinfo.supcrowdfunder.dao.DaoFactory;
import com.supinfo.supcrowdfunder.entity.Category;
import com.supinfo.supcrowdfunder.entity.Project;

@SuppressWarnings("serial")
@WebServlet("/auth/DashboardCategory")
public class DashboardCategoryServlet extends HttpServlet {

	private CategoryDao categoryDao;
	
	@Override
	public void init() throws ServletException {
		categoryDao = DaoFactory.getInstance().getCategoryDao();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		List<Category> category = categoryDao.getAllCategories();
		req.setAttribute("category", category);
		req.getRequestDispatcher("/auth/dashboardCategory.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nameCategory = request.getParameter("nameCategory");
		String descCategory = request.getParameter("descCategory");
		
		// Check datas in variables
		if (!nameCategory.isEmpty() && !descCategory.isEmpty()) {
			Category testCname = categoryDao.getCategoryByName(nameCategory);
			
			if (testCname != null) {
				request.getSession().setAttribute("event", "0");
				request.getSession().setAttribute("message", "Category Creation : name alread present in database");
				response.sendRedirect(getServletContext().getContextPath() + "/auth/DashboardCategory");
			} else {
				// Creation of a new category
				Category category = new Category();
				List<Project> listProjects = new ArrayList<Project>();
				category.setListProjects(listProjects);
				category.setCname(nameCategory);
				category.setCdesc(descCategory);
				categoryDao.addCategory(category);
				request.getSession().setAttribute("event", "1");
				request.getSession().setAttribute("message", "Category Creation : success");
				response.sendRedirect(getServletContext().getContextPath() + "/auth/DashboardCategory");
			}
		} else {
			if (!nameCategory.isEmpty()) {
				request.getSession().setAttribute("event", "0");
				request.getSession().setAttribute("message", "Category Creation : content category is empty");
				response.sendRedirect(getServletContext().getContextPath() + "/auth/DashboardCategory");
			} else {
				request.getSession().setAttribute("event", "0");
				request.getSession().setAttribute("message", "Category Creation : name category is empty");
				response.sendRedirect(getServletContext().getContextPath() + "/auth/DashboardCategory");
			}
		}
	}
}