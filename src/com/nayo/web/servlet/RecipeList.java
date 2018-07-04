package com.nayo.web.servlet;

import java.io.*;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nayo.web.RecipeService;
import com.nayo.web.entity.Recipe;

@WebServlet("/test")
public class RecipeList extends HttpServlet{
   
   @Override
   protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
      OutputStream os = response.getOutputStream();
      PrintWriter out = new PrintWriter(os, true);
      
      RecipeService recipelist = new RecipeService();
      
      List<Recipe> list = recipelist.getRecipeList(); 
      
      System.out.println(list.get(0).getId());
      
      out.println(list.get(0).getId());
      
   }
   
}