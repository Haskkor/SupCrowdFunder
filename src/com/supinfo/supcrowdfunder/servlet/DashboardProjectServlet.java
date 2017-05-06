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
import com.supinfo.supcrowdfunder.entity.User;

@SuppressWarnings("serial")
@WebServlet("/auth/DashboardProject")
public class DashboardProjectServlet extends HttpServlet {

	private ProjectDao projectDao;
	private CategoryDao categoryDao;
	
	@Override
	public void init() throws ServletException {
		projectDao = DaoFactory.getInstance().getProjectDao();
		categoryDao = DaoFactory.getInstance().getCategoryDao();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		List<Category> categories = categoryDao.getAllCategories();
		List<Project> project = projectDao.getAllProjects();
		req.setAttribute("categories", categories);
		req.setAttribute("project", project);
		req.getRequestDispatcher("/auth/dashboardProject.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User tempUser = (User) request.getSession().getAttribute("userlogged");
		String creatorParam = tempUser.getName() + " " + tempUser.getLastName();
		String nameParam = request.getParameter("name");
		String creationDateParam = String.valueOf(request.getSession().getAttribute("todayDate"));
		String completionDateParam = request.getParameter("completionDate");
		String descriptionParam = request.getParameter("description");
		String categoryIdParam = request.getParameter("categoryId");
		Float amountNeeded = Float.valueOf(request.getParameter("amountNeeded"));
		
		// Creation of a new project
		Project project = new Project();
		project.setCreator(creatorParam);
		project.setName(nameParam);
		project.setCreationDate(creationDateParam);
		project.setCompletionDate(completionDateParam);
		project.setDescription(descriptionParam);
		project.setAmountNeeded(amountNeeded);
		
		// Check id
		if(categoryIdParam != null && !categoryIdParam.isEmpty()) {
			Long categoryId = Long.valueOf(categoryIdParam);
			Category category = categoryDao.getCategoryById(categoryId);
			project.setCategory(category);
		}
		request.setAttribute("project", project);
		projectDao.addProject(project);
		request.getSession().setAttribute("event", "1");
		request.getSession().setAttribute("message", "Project Created");
		
		response.sendRedirect(getServletContext().getContextPath()+"/auth/DashboardProject");
	}
}