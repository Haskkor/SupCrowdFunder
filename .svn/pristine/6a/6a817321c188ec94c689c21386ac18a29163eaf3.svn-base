package com.supinfo.supcrowdfunder.servlet;

import java.io.IOException;

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
import com.supinfo.supcrowdfunder.entity.User;

@SuppressWarnings("serial")
@WebServlet("/auth/donate")
public class DonationServlet extends HttpServlet {
	
	private DonateDao donateDao;
	private ProjectDao projectDao;

	@Override
	public void init() throws ServletException {
		donateDao = DaoFactory.getInstance().getDonateDao();
		projectDao = DaoFactory.getInstance().getProjectDao();
	}   
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long projid=Long.valueOf(request.getParameter("projectid"));
		Project projdonate=projectDao.getProjectById(projid);
		request.getSession().setAttribute("projectdon", projdonate);
		request.getRequestDispatcher("/auth/donate.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Donate donate=new Donate();
		
		// Donation creation
		Project projdonate=(Project) request.getSession().getAttribute("projectdon");
		long projid=projdonate.getProjectId();
		User userlogged=(User) request.getSession().getAttribute("userlogged");
		float donateamount=Float.valueOf(request.getParameter("donationamount"));
		donate.setAmount(donateamount);
		donate.setProject(projdonate);
		donate.setUser(userlogged);
		donateDao.addDonate(donate);
		
		// Update the project
		Float amountdonated=donateamount+projdonate.getDonationAmount();
		projdonate.setDonationAmount(amountdonated);
		projectDao.updateProject(projdonate);
		
		// Redirect to the projectDetails.jsp
		request.getSession().setAttribute("event", "1");
		request.getSession().setAttribute("message", "Donation registered");
		response.sendRedirect(getServletContext().getContextPath() + "/projectDetails?projectId="+projid);
	}

}
