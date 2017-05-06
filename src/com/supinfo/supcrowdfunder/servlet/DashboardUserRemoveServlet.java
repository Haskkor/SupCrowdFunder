package com.supinfo.supcrowdfunder.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.supinfo.supcrowdfunder.dao.DaoFactory;
import com.supinfo.supcrowdfunder.dao.UserDao;

@WebServlet("/auth/DashboardUserRemove")
@SuppressWarnings("serial")
public class DashboardUserRemoveServlet extends HttpServlet {

	private UserDao userDao;
	
	@Override
	public void init() throws ServletException {
		userDao = DaoFactory.getInstance().getUserDao();
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userTemp = request.getParameter("userIdRemove");
		Long userId = Long.valueOf(userTemp);

		userDao.removeUser(userId);
		request.getSession().setAttribute("event", "1");
		request.getSession().setAttribute("message", "User removed");
		response.sendRedirect(getServletContext().getContextPath() + "/auth/DashboardUser");
	}
}