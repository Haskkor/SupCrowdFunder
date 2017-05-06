package com.supinfo.supcrowdfunder.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/auth/profile")
public class ProfileServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getSession().invalidate();
		resp.sendRedirect(getServletContext().getContextPath());
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String password = req.getParameter("password");
		String confPassword = req.getParameter("confpassword");
		
		if (password != confPassword && !password.isEmpty() && !confPassword.isEmpty()) {
			req.setAttribute("event", "0");
			req.getRequestDispatcher("/register.jsp").forward(req, resp);
		}
	}
}