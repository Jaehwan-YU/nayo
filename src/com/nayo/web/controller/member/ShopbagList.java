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
import com.nayo.web.entity.Food;
import com.nayo.web.entity.FoodCate;
import com.nayo.web.entity.KeepTip;
import com.nayo.web.entity.Recipe;
import com.nayo.web.entity.Shopbag;
import com.nayo.web.member.FoodService;
import com.nayo.web.member.ShopbagService;

@WebServlet("/member/shopbag")
public class ShopbagList extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		String email = (String)session.getAttribute("email");
		
		if(session.getAttribute("email") == null) {
			response.sendRedirect("../login");
			return;
		}
		
		FoodService fs = new FoodService(getServletContext());
		ShopbagService ss = new ShopbagService(getServletContext());
		List<FoodCate> fclist;
		List<Shopbag> list1;
		List<Shopbag> list2;
		List<Shopbag> list3;
		List<Shopbag> list4;
		List<Shopbag> list5;
		List<Shopbag> list6;
		List<Shopbag> list7;
		List<Shopbag> list8;
		

		try {
			fclist = fs.getFoodCateList();
			list1 = ss.getShopbagList(email, 1);
			list2 = ss.getShopbagList(email, 2);
			list3 = ss.getShopbagList(email, 3);
			list4 = ss.getShopbagList(email, 4);
			list5 = ss.getShopbagList(email, 5);
			list6 = ss.getShopbagList(email, 6);
			list7 = ss.getShopbagList(email, 7);
			list8 = ss.getShopbagList(email, 8);
			request.setAttribute("fclist", fclist);
			request.setAttribute("list1", list1);
			request.setAttribute("list2", list2);
			request.setAttribute("list3", list3);
			request.setAttribute("list4", list4);
			request.setAttribute("list5", list5);
			request.setAttribute("list6", list6);
			request.setAttribute("list7", list7);
			request.setAttribute("list8", list8);
			
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
