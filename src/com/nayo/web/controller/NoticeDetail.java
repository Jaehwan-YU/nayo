package com.nayo.web.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nayo.web.NoticeService;
import com.nayo.web.entity.Notice;

@WebServlet("/notice/detail")
public class NoticeDetail extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		NoticeService ns = new NoticeService();
		
		try {
			Notice notice = ns.getNotice(id);
			request.setAttribute("n", notice);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/notice/detail.jsp");
			
			dispatcher.forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
