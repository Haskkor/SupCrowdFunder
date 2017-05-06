package com.supinfo.supcrowdfunder.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.supinfo.supcrowdfunder.dao.DaoFactory;
import com.supinfo.supcrowdfunder.dao.UserDao;
import com.supinfo.supcrowdfunder.entity.User;

@SuppressWarnings("serial")
@WebServlet("/auth/DashboardUser")
public class DashboardUserServlet extends HttpServlet {

	private UserDao userDao;

	@Override
	public void init() throws ServletException {
		userDao = DaoFactory.getInstance().getUserDao();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<User> user = userDao.getAllUsers();
		req.setAttribute("user", user);
		req.getRequestDispatcher("/auth/dashboardUser.jsp").forward(req, resp);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = new User();
		String username = request.getParameter("username");
		String userLastName = request.getParameter("userlastname");
		String password = request.getParameter("password");
		String confPassword = request.getParameter("confpassword");
		String email = request.getParameter("email");
		int uright =Integer.parseInt(request.getParameter("userUrightVal"));
		User usertmp =userDao.getUserByEmail(email);
		
		// Creation of a user
		if (usertmp!=null){
			response.sendRedirect(request.getServletContext().getContextPath()+"/auth/DashboardUser");
			request.getSession().setAttribute("event", "0");
			request.getSession().setAttribute("message", "Mail already exist");
		} else {
			user.setName(username);
			user.setLastName(userLastName);
			user.setMailAddress(email);
			user.setUright(uright);
			if (!password.isEmpty() && !confPassword.isEmpty()) {
				if (password.equals(confPassword)) {
					user.setPassword(password);
					userDao.addUser(user);
					request.getSession().setAttribute("event", "1");
					request.getSession().setAttribute("message", "User created");
					response.sendRedirect(getServletContext().getContextPath() + "/auth/DashboardUser");
				} else {
					request.getSession().setAttribute("event", "0");
					request.getSession().setAttribute("message", "Password and confirm password are not the same");
					response.sendRedirect(getServletContext().getContextPath() + "/auth/DashboardUser");
				}
			}
		}
	}
}