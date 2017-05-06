package com.supinfo.supcrowdfunder.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.supinfo.supcrowdfunder.dao.DaoFactory;
import com.supinfo.supcrowdfunder.dao.UserDao;
import com.supinfo.supcrowdfunder.entity.User;

@WebServlet("/auth/DashboardUserEdit")
@SuppressWarnings("serial")
public class DashboardUserEditServlet extends HttpServlet {
	
	private UserDao userDao;
	
	@Override
	public void init() throws ServletException {
		userDao = DaoFactory.getInstance().getUserDao();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userTemp = request.getParameter("userIdEdit");
		String userName = request.getParameter("userNameEdit");
		String userLastName = request.getParameter("userLastNameEdit");
		String userMailAddress = request.getParameter("userMailAddressEdit");
		String userPasswd = request.getParameter("userPasswordEdit");
		int uright =Integer.parseInt(request.getParameter("userRightEdit"));
		
		Long userId = Long.valueOf(userTemp);
		User useredited = userDao.getUserById(userId);
		
		useredited.setUright(uright);
		useredited.setName(userName);
		useredited.setLastName(userLastName);
		useredited.setMailAddress(userMailAddress);
		useredited.setPassword(userPasswd);
		userDao.updateUser(useredited);
		request.getSession().setAttribute("event", "1");
		request.getSession().setAttribute("message", "User modified");
		response.sendRedirect(getServletContext().getContextPath()+"/auth/DashboardUser");	
	}
}
