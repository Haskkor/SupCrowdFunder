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

@WebServlet("/auth/modifUser")
public class ModifUserServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private UserDao userDao;
	
	@Override
	public void init() throws ServletException {
		userDao = DaoFactory.getInstance().getUserDao();
	}   
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User userlogged= (User) request.getSession().getAttribute("userlogged");
		String username = request.getParameter("username");
		String userLastName = request.getParameter("userlastname");
		String password = request.getParameter("password");
		String mailAddress = request.getParameter("email");
		userlogged.setName(username);
		userlogged.setLastName(userLastName);
		userlogged.setPassword(password);
		userlogged.setMailAddress(mailAddress);
		userDao.updateUser(userlogged);
		request.getSession().setAttribute("userlogged", userlogged);
		request.getSession().setAttribute("event", "1");
		request.getSession().setAttribute("message", "Profile modified");
		response.sendRedirect(getServletContext().getContextPath()+"/auth/profile.jsp");
	}
}