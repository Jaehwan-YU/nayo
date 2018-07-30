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

@WebServlet("/notice/list")
public class NoticeList extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ctx = request.getContextPath();
		request.setAttribute("ctx", ctx);
		
		int pageNo = 1;
		String field = "title";
		String query = "";
		
		String pageNo_ = request.getParameter("p");
		String field_ = request.getParameter("f");
		String query_ = request.getParameter("q");
		
		if(pageNo_ != null && !pageNo_.equals(""))
			pageNo = Integer.parseInt(pageNo_);
		if(field_ !=null && !field_.equals(""))
			field = field_;
		if(query_ !=null && !query_.equals(""))
			query = query_;
		
		NoticeService ns = new NoticeService();

		try {
			List<Notice> list = ns.getNoticeList(field, query, pageNo);
			int count_ = ns.getNoticeCount(field, query);
			
			request.setAttribute("list", list);
			request.setAttribute("count", count_);
			request.setAttribute("p", pageNo);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/notice/list.jsp");
			dispatcher.forward(request, response);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
