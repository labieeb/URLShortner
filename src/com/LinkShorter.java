package com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.TinyURLBean;

import java.util.List;
import java.util.ArrayList;

import db.Model;

/**
 * Servlet implementation class LinkShorter
 */
@WebServlet("/LinkShorter")
public class LinkShorter extends HttpServlet {
	
	URLShortener urlShortener = null;
	HttpSession session = null;
	Model model = null;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		session = request.getSession();
		model = new Model();
		
		int userId = (int) session.getAttribute("userId");
		
		urlShortener = new URLShortener();
		String url = request.getParameter("link");
		String tinyURL = urlShortener.shortenURL(url);
		
		model.addTinyURL(userId, url, tinyURL);
		request.setAttribute("tinyURL", tinyURL);
		
		List<TinyURLBean> tinyUrlList = model.getTinyUrls(userId);
		request.setAttribute("tinyURLList", tinyUrlList);
		
		request.getRequestDispatcher("./home.jsp").forward(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		session = request.getSession();
		model = new Model();
		
		int userId = (int) session.getAttribute("userId");
		
		List<TinyURLBean> tinyUrlList = model.getTinyUrls(userId);
		request.setAttribute("tinyURLList", tinyUrlList);
		
		request.getRequestDispatcher("./home.jsp").forward(request, response);
		
	}

}
