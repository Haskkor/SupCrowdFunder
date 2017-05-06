package com.supinfo.supcrowdfunder.servlet;

import java.io.IOException;

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
@WebServlet("/auth/DashboardProjectEdit")
public class DashboardProjEditServlet extends HttpServlet {
	
	private ProjectDao projectDao;
	private CategoryDao categoryDao;
	
	@Override
	public void init() throws ServletException {
		projectDao = DaoFactory.getInstance().getProjectDao();
		categoryDao = DaoFactory.getInstance().getCategoryDao();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String projTemp = request.getParameter("projectIdEdit");
		String projCreator = request.getParameter("projectCreatorEdit");
		String projName = request.getParameter("projectNameEdit");
		String projComplDate = request.getParameter("projectCompletionDateEdit");
		
		String tempAmountNeeded = request.getParameter("projectAmountNeededEdit");
		float projAmountNeeded = Float.valueOf(tempAmountNeeded);
		
		String projDecription = request.getParameter("projectDescriptionEdit");
		String projCategory = request.getParameter("projectCategoryIdEdit");
		Long catId= Long.valueOf(projCategory);
		Long projId = Long.valueOf(projTemp);
		
		Project projedited = projectDao.getProjectById(projId);
		Category category = categoryDao.getCategoryById(catId);
		
		projedited.setCreator(projCreator);
		projedited.setName(projName);
		projedited.setCompletionDate(projComplDate);
		projedited.setAmountNeeded(projAmountNeeded);
		projedited.setDescription(projDecription);
		projedited.setCategory(category);
		
		projectDao.updateProject(projedited);
		request.getSession().setAttribute("event", "1");
		request.getSession().setAttribute("message", "Project modified");
		response.sendRedirect(getServletContext().getContextPath()+"/auth/DashboardProject");	
	}
}