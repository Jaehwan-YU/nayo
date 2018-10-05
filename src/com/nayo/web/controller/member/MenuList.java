package com.nayo.web.controller.member;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nayo.web.RecipeService;
import com.nayo.web.entity.Menu;
import com.nayo.web.entity.Recipe;
import com.nayo.web.member.BookmarkService;
import com.nayo.web.member.FoodService;
import com.nayo.web.member.MenuService;


@WebServlet("/member/menu")
public class MenuList extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String regEmail = (String)session.getAttribute("email");
		MenuService ms = new MenuService(getServletContext());
		
		String date_ = request.getParameter("");
		Date date = Date.valueOf(date_);
		String mill_ = request.getParameter("mill");
		int mill = Integer.parseInt(mill_);
		String recipeId_ = request.getParameter("id");
		int recipeId = Integer.parseInt(recipeId_);
		
		Menu menu = new Menu(regEmail, date, mill, recipeId);
		
		try {
			ms.addMenu(menu);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("");
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ctx = request.getContextPath();
		request.setAttribute("ctx", ctx);
		
		HttpSession session = request.getSession();
		BookmarkService bs = new BookmarkService(getServletContext());
		FoodService fs = new FoodService(getServletContext());
		RecipeService rs = new RecipeService(getServletContext());
		MenuService ms = new MenuService(getServletContext());
	
		String email = (String)session.getAttribute("email");
		
		if(email == null) {
			response.sendRedirect("../login");
			return;
		}
		
/*		Calendar tDay = Calendar.getInstance();
		int year = tDay.get(Calendar.YEAR);
		int month = tDay.get(Calendar.MONTH);
		int day = tDay.get(Calendar.DATE);
		
		Calendar dSet = Calendar.getInstance();
		dSet.set(year, month, 1);

		int last_day = tDay.getActualMaximum(Calendar.DATE);*/

		
		try {
			List<Recipe> blist = bs.getBookmarkList(email);
			List<Recipe> rlist = rs.getCookableRecipeList(email);
			List<Recipe> slist = rs.getScoreRecipeList();
			List<Menu> mlist = ms.getMenu(email);
			
			request.setAttribute("blist", blist);
			request.setAttribute("rlist", rlist);
			request.setAttribute("slist", slist);
			request.setAttribute("mlist", mlist);
			/*request.setAttribute("year", year);
			request.setAttribute("month", month);
			request.setAttribute("day", day);
			request.setAttribute("last", last_day);*/
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/member/menu.jsp");
			dispatcher.forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
