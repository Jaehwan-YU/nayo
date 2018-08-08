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
import javax.servlet.http.HttpSession;

import com.nayo.web.RecipeService;
import com.nayo.web.entity.Recipe;
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
		String ctx = request.getContextPath();
		request.setAttribute("ctx", ctx);
		HttpSession session = request.getSession();
		String email = (String)session.getAttribute("email");
		
		if(email == null || !email.equals("")) {
			response.sendRedirect("/nayo/login");
			return;
		}
		
		
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
		
		HttpSession session = request.getSession();
		String regEmail = (String) session.getAttribute("email");
		String savePath = "C:\\Users\\youu\\git\\nayo\\WebContent\\images\\recipe\\processImage";
		int sizeLimit = 1024*1024*15;
		MultipartRequest multi = new MultipartRequest(request, savePath, sizeLimit, "UTF-8", new DefaultFileRenamePolicy());
		RecipeService rs = new RecipeService(getServletContext());
				
		String title = (String) multi.getParameter("title");
		String simpleIntro = (String) multi.getParameter("simple-intro");
		int nationalId = 0;
		String nationalId_= ((String)multi.getParameter("national")).trim();
		if(nationalId_ != null && !nationalId_.equals(""))
			nationalId = Integer.parseInt(nationalId_);
		int situationId = 0;
		String situationId_= ((String)multi.getParameter("situation")).trim();
		if(situationId_ != null && !situationId_.equals(""))
			situationId = Integer.parseInt(situationId_);
		int recipeTypeId = 0; 
		String recipeTypeId_= ((String)multi.getParameter("recipe-type")).trim();
		if(recipeTypeId_ != null && !recipeTypeId_.equals(""))
			recipeTypeId = Integer.parseInt(recipeTypeId_);
				
		int kcalory = 0; 
		String kcalory_= multi.getParameter("kcal").trim();
		if(kcalory_ != null && !kcalory_.equals(""))
			kcalory = Integer.parseInt(kcalory_);
		
		Enumeration<String> names = multi.getParameterNames();
		ArrayList<String[]> mainIngNames = new ArrayList<>();
		ArrayList<String[]> subIngNames = new ArrayList<>();
		ArrayList<String[]> processNames = new ArrayList<>();
		
		ArrayList<String[]> mainIngValues = new ArrayList<>();
		ArrayList<String[]> subIngValues = new ArrayList<>();
		ArrayList<String[]> processValues = new ArrayList<>();
		
		
		while(names.hasMoreElements()) {
			String next = names.nextElement();
			if(next.startsWith("main-name")){
				String mainIngQuatityName = "main-quantity-" + next.replaceAll("[^0-9]", "");
				String[] mainIng = {next,mainIngQuatityName};
				mainIngNames.add(mainIng);
			}
			else if(next.startsWith("sub-name")) {
				String subIngQuatityName = "sub-quantity-" + next.replaceAll("[^0-9]", "");
				String[] subIng = {next,subIngQuatityName};
				subIngNames.add(subIng);
			}
			else if(next.startsWith("process-text")) {
				String processName = "process-img-" + next.replaceAll("[^0-9]", "");
				String[] process = {next,processName};
				processNames.add(process);
			}
			else continue;
		};
		for(String[] s : mainIngNames)
			System.out.println(s[0] + s[1]);
		
		for(String[] s : mainIngNames) {
			String nameValue = (String)multi.getParameter(s[0]);
			String quantityValue = (String)multi.getParameter(s[1]);
			String[] mainIngValue = {nameValue,quantityValue};
			
			mainIngValues.add(mainIngValue);
		}
		for(String[] s : mainIngValues)
			System.out.println(s[0] + s[1]);
		
		for(String[] s : subIngNames) {
			String nameValue = (String)multi.getParameter(s[0]);
			String quantityValue = (String)multi.getParameter(s[1]);
			String[] subIngValue = {nameValue,quantityValue};
			
			subIngValues.add(subIngValue);
		}
		
		
		
		String mainImg = "/nayo/images/recipe/processImage/"+multi.getFilesystemName("main-img");
		
		for(String[] s : processNames) {
			String processText = (String)multi.getParameter(s[0]);
			String processImgDir ="/nayo/images/recipe/processImage/"+multi.getFilesystemName(s[1]);

			String[] process = {processText,processImgDir};
			
			processValues.add(process);
		}
		Recipe recipe = new Recipe(title, simpleIntro, mainImg, regEmail, kcalory, nationalId, situationId, recipeTypeId);
		
		System.out.println(recipe.toString());
		
		rs.addRecipe(recipe, mainIngValues,	subIngValues, processValues);
		
		response.sendRedirect("list");
	}

}
