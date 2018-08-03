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
import javax.servlet.http.HttpSession;

import com.nayo.web.RecipeService;
import com.nayo.web.entity.Recipe;
import com.nayo.web.member.BookmarkService;
import com.nayo.web.member.FoodService;


@WebServlet("/member/menu")
public class MenuList extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ctx = request.getContextPath();
		request.setAttribute("ctx", ctx);
		
		HttpSession session = request.getSession();
		BookmarkService bs = new BookmarkService(getServletContext());
		FoodService fs = new FoodService(getServletContext());
		RecipeService rs = new RecipeService(getServletContext());
	
		String email = (String)session.getAttribute("email");
		
		if(email == null) {
			response.sendRedirect("../login");
			return;
		}
		
		try {
			List<Recipe> blist = bs.getBookmarkList(email);
			List<Recipe> rlist = rs.getCookableRecipeList(email);
			List<Recipe> slist = rs.getScoreRecipeList();
			
			request.setAttribute("blist", blist);
			request.setAttribute("rlist", rlist);
			request.setAttribute("slist", slist);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/member/menu.jsp");
			dispatcher.forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
