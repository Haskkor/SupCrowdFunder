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
@WebServlet("/auth/createProject")
public class CreateProjectServlet extends HttpServlet{
	
	private ProjectDao projectDao;
	private CategoryDao categoryDao;
	
	@Override
	public void init() throws ServletException {
		projectDao = DaoFactory.getInstance().getProjectDao();
		categoryDao = DaoFactory.getInstance().getCategoryDao();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			List<Category> categories = categoryDao.getAllCategories();
			req.setAttribute("categories", categories);
			req.getRequestDispatcher("/auth/createProject.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User tempUser = (User) req.getSession().getAttribute("userlogged");
		String creatorParam = tempUser.getName() + " " + tempUser.getLastName();
		String nameParam = req.getParameter("name");
		String creationDateParam = String.valueOf(req.getSession().getAttribute("todayDate"));
		String completionDateParam = req.getParameter("completionDate");
		String descriptionParam = req.getParameter("description");
		String categoryIdParam = req.getParameter("categoryId");
		Float amountNeeded = Float.valueOf(req.getParameter("amountNeeded"));
		
		// Creation of a new project
		Project project = new Project();
		project.setCreator(creatorParam);
		project.setName(nameParam);
		project.setCreationDate(creationDateParam);
		project.setCompletionDate(completionDateParam);
		project.setDescription(descriptionParam);
		project.setAmountNeeded(amountNeeded);
		
		// Check id existence
		if(categoryIdParam != null && !categoryIdParam.isEmpty()) {
			Long categoryId = Long.valueOf(categoryIdParam);
			Category category = categoryDao.getCategoryById(categoryId);
			project.setCategory(category);
		}
		req.setAttribute("project", project);
		projectDao.addProject(project);
		
		req.getRequestDispatcher("/projectDetails.jsp").forward(req, resp);
	}
}
