package com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db.Model;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	
	Model model = null;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		model = new Model();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if(model.isValidUser(username, password)) {
			response.getWriter().append("Served at: ").append("Login Success ");
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			int userId = model.getUserId(username);
			session.setAttribute("userId", userId);
			request.getRequestDispatcher("/LinkShorter").forward(request, response);
		}else {
			response.getWriter().append("Served at: ").append("Login Failed ");
		}
	}

}
