package com.nayo.web.controller.member;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nayo.web.RecipeService;
import com.nayo.web.controller.RecipeList;
import com.nayo.web.entity.Recipe;


@WebServlet("/member/recipe/list")
public class MemberRecipeList extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String memberEmail = "sorastar31@gmail.com";
		
		RecipeService rs = new RecipeService();
		
		List<Recipe> list;
		try {
			list = rs.getRecipeList(memberEmail);
			request.setAttribute("list", list);
			
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/member/recipe/list.jsp");
			
			dispatcher.forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
