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
@WebServlet("/loginsv")
public class LoginServlet extends HttpServlet {
	
	private UserDao userDao;
	
	@Override
	public void init() throws ServletException {
		userDao = DaoFactory.getInstance().getUserDao();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			resp.sendRedirect(getServletContext().getContextPath() + "/login.jsp");		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userMailAddress=req.getParameter("testMailAddress");
		
		// Check the mail
		if(userMailAddress == null){	
			resp.sendRedirect(getServletContext().getContextPath() + "/login.jsp");
		}else{
			int isLogged=0;
			String password= req.getParameter("testPassword");
			List<User> users= userDao.getAllUsers() ;
			for (User user : users) {
				if(user.getMailAddress().equals(userMailAddress) && user.getPassword().equals(password)){
					req.getSession().setAttribute("userlogged", user);
					req.getSession().setAttribute("userLastName", user.getLastName());
					isLogged=1;
					if(user.getUserId()==1){
						user.setUright(1);
						userDao.updateUser(user);
					}
				}
			}
			// Check user's login
			if (isLogged==1){
				resp.sendRedirect(getServletContext().getContextPath() + "/auth/profile.jsp");
			} else {req.getSession().setAttribute("event", "0");
			req.getSession().setAttribute("message", "Lastname or password incorrect");
			resp.sendRedirect(getServletContext().getContextPath() + "/login.jsp");
			}
		}
	}
}