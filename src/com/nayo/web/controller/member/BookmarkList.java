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

import com.nayo.web.entity.Bookmark;
import com.nayo.web.entity.Recipe;
import com.nayo.web.member.BookmarkService;


@WebServlet("/member/bookmark")
public class BookmarkList extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ctx = request.getContextPath();
		request.setAttribute("ctx", ctx);
		
		HttpSession session = request.getSession();
		BookmarkService bs = new BookmarkService(getServletContext());
	
		String memberEmail = (String)session.getAttribute("email");
		
		if(memberEmail == null) {
			response.sendRedirect("../login");
			return;
		}
		
		try {
			List<Recipe> list = bs.getBookmarkList(memberEmail);
			
			request.setAttribute("list", list);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/member/bookmark.jsp");
			
			dispatcher.forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
