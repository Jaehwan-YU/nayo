package com.nayo.web.controller.member;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nayo.web.RecipeService;
import com.nayo.web.entity.RecipeCate;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class RecipeReg
 */
@WebServlet("/recipe/reg")
public class RecipeReg extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		RecipeService rs = new RecipeService(getServletContext());
		
		try {
			
			List<ArrayList<RecipeCate>> cateList = rs.getRecipeCateList();
			
			request.setAttribute("nationalCate", cateList.get(0));
			request.setAttribute("situationCate", cateList.get(1));
			request.setAttribute("recipeTypeCate", cateList.get(2));
			
		} catch (ClassNotFoundException | SQLException e) {
		
			e.printStackTrace();
		}
		
		
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/member/recipe/reg.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Enumeration<String> names = request.getAttributeNames();
		List<String> mainIngNames = new ArrayList<>();
		List<String> subIngNames = new ArrayList<>();
		List<String> processNames = new ArrayList<>();
		
		while(names.hasMoreElements()) {
			String next = names.nextElement();
			if(next.substring(0,9)=="main-name")
				mainIngNames.add(next);
			else if(next.substring(0,8)=="sub-name")
				subIngNames.add(next);
			else if(next.substring(0,12)=="process-text")
				processNames.add(next);
			else continue;
		};
		
		
		
		
		
		String savePath = request.getServletContext().getRealPath("\\images\\recipe\\processImage");
		int sizeLimit = 1024*1024*15;
		MultipartRequest multi = new MultipartRequest(request, savePath, sizeLimit, "UTF-8", new DefaultFileRenamePolicy());
		
		
		response.sendRedirect("list");
	}

}
