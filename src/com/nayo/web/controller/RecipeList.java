package com.nayo.web.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nayo.web.RecipeService;
import com.nayo.web.entity.Recipe;
import com.nayo.web.member.BookmarkService;
import com.nayo.web.member.FoodService;

@WebServlet("/recipe/list")
public class RecipeList extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ctx = request.getContextPath();
		request.setAttribute("ctx", ctx);

		
		BookmarkService bs = new BookmarkService(getServletContext());
		FoodService fs = new FoodService(getServletContext());
		RecipeService rs = new RecipeService(getServletContext());
		
		try {
			List<Recipe> slist = rs.getScoreRecipeList();
			List<Recipe> dlist = rs.getDateRecipeList();
			
			request.setAttribute("slist", slist);
			request.setAttribute("dlist", dlist);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/recipe/list.jsp");
			dispatcher.forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
