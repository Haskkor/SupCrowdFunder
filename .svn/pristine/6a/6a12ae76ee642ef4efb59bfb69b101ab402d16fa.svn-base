package com.supinfo.supcrowdfunder.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.supinfo.supcrowdfunder.dao.DaoFactory;
import com.supinfo.supcrowdfunder.dao.DonateDao;
import com.supinfo.supcrowdfunder.dao.ProjectDao;
import com.supinfo.supcrowdfunder.entity.Donate;
import com.supinfo.supcrowdfunder.entity.Project;

@SuppressWarnings("serial")
@WebServlet("/auth/dashboard")
public class DashboardServlet extends HttpServlet {
	
	private ProjectDao projectDao;
	private DonateDao donateDao;
	
	@Override
	public void init() throws ServletException {
		projectDao = DaoFactory.getInstance().getProjectDao();
		donateDao = DaoFactory.getInstance().getDonateDao();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Donate> donations = donateDao.getAllDonates();
		Float total = 0f;
		for (Donate donate : donations) {
			total += donate.getAmount();
		}
		req.setAttribute("total", total);
		req.getRequestDispatcher("/auth/dashboard.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Project> listProjects = projectDao.getAllProjects();
		Date firstDate = java.sql.Date.valueOf(request.getParameter("firstDate"));
		Date secondDate = java.sql.Date.valueOf(request.getParameter("secondDate"));		
		List<Project> listProjectSorted = new ArrayList<>();
		for (Project project : listProjects) {
			Date dateParsed = java.sql.Date.valueOf(project.getCreationDate());
			if ((dateParsed.after(firstDate) || dateParsed.equals(firstDate)) && (dateParsed.before(secondDate) || dateParsed.equals(secondDate))) {
				listProjectSorted.add(project);
			}
		}
		
		request.setAttribute("numberProjectSorted", listProjectSorted.size());
		request.setAttribute("firstDate", firstDate);
		request.setAttribute("secondDate", secondDate);
		request.setAttribute("listProjectSorted", listProjectSorted);
		request.setAttribute("listProjects", listProjects);
		doGet(request, response);
	}
}