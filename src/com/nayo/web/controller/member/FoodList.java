package com.nayo.web.controller.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nayo.web.RecipeService;
import com.nayo.web.entity.Food;
import com.nayo.web.entity.FoodCate;
import com.nayo.web.entity.Recipe;
import com.nayo.web.member.FoodService;

/**
 * Servlet implementation class FoodList
 */
@WebServlet("/member/food")
public class FoodList extends HttpServlet {

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		FoodService fs = new FoodService(getServletContext());
		RecipeService rs = new RecipeService(getServletContext());
	/*	PrintWriter out = response.getWriter();*/
		String email = (String) session.getAttribute("email");
		
		if(session.getAttribute("email") == null) {
			response.sendRedirect("../login");
			return;
		}
		
		Enumeration<String> name = request.getAttributeNames();
		
		List<Recipe> rList;
		List<FoodCate> list;
		
		List<Food> list1;
		List<Food> list2;
		List<Food> list3;
		
		try {
			list = fs.getFoodCateList();
			rList = rs.getCookableRecipeList(email);
			list1 = fs.getFoodList(email, 1);
			list2 = fs.getFoodList(email, 2);
			list3 = fs.getFoodList(email, 3);
			request.setAttribute("rList", rList);
			request.setAttribute("list", list);
			request.setAttribute("list1", list1);
			request.setAttribute("list2", list2);
			request.setAttribute("list3", list3);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/member/food.jsp");
		dispatcher.forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
