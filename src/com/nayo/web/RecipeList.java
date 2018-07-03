package com.nayo.web;

import java.io.*;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nayo.web.entity.Recipe;
import com.nayo.web.member.ShopbagService;

public class RecipeList extends HttpServlet{
	

		
	@Override
	public void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		RecipeService service = new RecipeService();
		
		OutputStream os = arg1.getOutputStream();
		PrintWriter out = new PrintWriter(os,true);
		
		List<Recipe> tempList = service.getRecipeList();
		for (Recipe recipe : tempList) {
			out.println(recipe.getId()+"\n");
			out.println(recipe.getKcalory());
		}
		
		/*try {

			for(int i=0; i<service.getRecipeList().size(); i++) {
				out.print(service.getRecipeList().get(i).getId());
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		*/
	
	}
	
}
