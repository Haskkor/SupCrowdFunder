package com.supinfo.supcrowdfunder.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.supinfo.supcrowdfunder.dao.CategoryDao;
import com.supinfo.supcrowdfunder.dao.DaoFactory;
import com.supinfo.supcrowdfunder.entity.Category;

@WebServlet("/auth/DashboardCategoryEdit")
@SuppressWarnings("serial")
public class DashboardCatEditServlet extends HttpServlet {
	
	private CategoryDao categoryDao;
	
	@Override
	public void init() throws ServletException {
		categoryDao = DaoFactory.getInstance().getCategoryDao();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String catTemp = request.getParameter("categoryIdEdit");
		String catname = request.getParameter("categoryNameEdit");
		String catdesc = request.getParameter("categoryDescriptionEdit");
		Long catId = Long.valueOf(catTemp);
		
		Category catedited = categoryDao.getCategoryById(catId);
		
		catedited.setCname(catname);
		catedited.setCdesc(catdesc);
		
		categoryDao.updateCategory(catedited);
		
		request.getSession().setAttribute("event", "1");
		request.getSession().setAttribute("message", "Category modified");
		response.sendRedirect(getServletContext().getContextPath()+"/auth/DashboardCategory");	
	}
}
