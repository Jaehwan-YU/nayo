package com.nayo.web.controller.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nayo.web.member.FoodService;

/**
 * Servlet implementation class AddFood
 */
@WebServlet("/addfood")
public class AddFood extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		FoodService fs =  new FoodService(getServletContext());
		HttpSession session = request.getSession();
		String email = (String)session.getAttribute("email");
		
		String[] values = request.getParameterValues("food-name");
		
		if(values == null) {
			response.sendRedirect("/nayo/member/food");
			return;
		}
		for(String v : values) {
			fs.addFood(email, v);
		}
		response.sendRedirect("/nayo/member/food");
	}

}
