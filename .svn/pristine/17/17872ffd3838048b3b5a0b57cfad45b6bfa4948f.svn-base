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

@SuppressWarnings("serial")
@WebServlet("/addUser")
public class AddUserServlet extends HttpServlet {
	
	private UserDao userDao;
	
	@Override
	public void init() throws ServletException {
		userDao = DaoFactory.getInstance().getUserDao();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Creation of a new user
		User user = new User();
		user.setUright(0);
		String username = request.getParameter("username");
		String userLastName = request.getParameter("userlastname");
		String password = request.getParameter("password");
		String confPassword = request.getParameter("confpassword");
		String email = request.getParameter("email");
		User usertmp =userDao.getUserByEmail(email);
		
		// Check the mail
		if (usertmp!=null) {
			response.sendRedirect(request.getServletContext().getContextPath()+"/register.jsp");
			request.getSession().setAttribute("event", "0");
			request.getSession().setAttribute("message", "Mail already exist");
			}
		else {
			user.setName(username);
			user.setLastName(userLastName);
			user.setMailAddress(email);
			// Check existence of password
			if (!password.isEmpty() && !confPassword.isEmpty()) {
				// Check that password equals password confirmation
				if (password.equals(confPassword)) {
					user.setPassword(password);
					userDao.addUser(user);
					request.getSession().setAttribute("userlogged", user);
					request.getSession().setAttribute("event", "1");
					request.getSession().setAttribute("message", "You are logged");
					response.sendRedirect(getServletContext().getContextPath() + "/auth/profile.jsp");
					if(user.getUserId() == 1) {
						user.setUright(1);
						userDao.updateUser(user);
					}
				} else {
					request.getSession().setAttribute("event", "0");
					request.getSession().setAttribute("message", "Password and confirm password are not the same");
					response.sendRedirect(getServletContext().getContextPath() + "/register.jsp");
				}
			}
		}
	}
}