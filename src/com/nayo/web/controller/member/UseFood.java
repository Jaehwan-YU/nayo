package com.nayo.web.controller.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nayo.web.member.FoodService;

/**
 * Servlet implementation class UseFood
 */
@WebServlet("/usefood")
public class UseFood extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FoodService fs =  new FoodService(getServletContext());
		
		String[] values = request.getParameterValues("food-check");
		
		if(values == null) {
			response.sendRedirect("/nayo/member/food");
			return;
		}
		
		fs.setFoodUse(values);
		
		response.sendRedirect("/nayo/member/food");
	}

}
