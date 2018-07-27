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
import com.nayo.web.entity.Food;
import com.nayo.web.entity.FoodCate;
import com.nayo.web.entity.KeepTip;
import com.nayo.web.entity.Recipe;
import com.nayo.web.member.FoodService;

@WebServlet("/member/shopbag")
public class ShopbagList extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	

		FoodService fs = new FoodService(getServletContext());
		
		List<Food> list; 

		try {
			
			list = fs.getMetaFoodList();
		
			request.setAttribute("list", list);	
		
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		RequestDispatcher dispatcher1 = request.getRequestDispatcher("/WEB-INF/views/member/shopbag.jsp");
		dispatcher1.forward(request, response);
	}

}
