package com.nayo.web.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nayo.web.RecipeService;
import com.nayo.web.entity.Ingredients;
import com.nayo.web.entity.Process;
import com.nayo.web.entity.Recipe;


@WebServlet("/recipe/detail")
public class RecipeDetail extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RecipeService rs = new RecipeService(getServletContext());
		
		String ctx = request.getContextPath();
		request.setAttribute("ctx", ctx);
		
		int recipeId = Integer.parseInt(request.getParameter("id"));
		
		Recipe recipe = rs.getRecipe(recipeId);
		ArrayList<Ingredients> ingredients = rs.getIgredients(recipeId);
		ArrayList<Ingredients> mainIng = new ArrayList<>();
		ArrayList<Ingredients> subIng = new ArrayList<>();
		ArrayList<Process> process = rs.getProcess(recipeId);
		
		for(Ingredients i : ingredients) {
			if(i.getMainOrSub() == 1)
				mainIng.add(i);
			else if(i.getMainOrSub() == 2)
				subIng.add(i);
		}
		
		request.setAttribute("recipe", recipe);
		request.setAttribute("mainIng", mainIng);
		request.setAttribute("subIng", subIng);		
		request.setAttribute("process", process);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/recipe/detail.jsp");
		dispatcher.forward(request, response);
	}

}
