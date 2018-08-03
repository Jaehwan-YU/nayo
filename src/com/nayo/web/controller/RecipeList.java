package com.nayo.web.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/recipe/list")
public class RecipeList extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ctx = request.getContextPath();
		request.setAttribute("ctx", ctx);
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("email");
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/recipe/list.jsp");
		dispatcher.forward(request, response);
	}

}
