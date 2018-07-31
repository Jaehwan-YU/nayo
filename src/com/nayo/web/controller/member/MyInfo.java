package com.nayo.web.controller.member;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nayo.web.entity.Member;
import com.nayo.web.member.MyInfoService;

@WebServlet("/member/myinfo")
public class MyInfo extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ctx = request.getContextPath();
		request.setAttribute("ctx", ctx);
		
		HttpSession session = request.getSession();
		MyInfoService ms = new MyInfoService(getServletContext());
		
		String email = (String)session.getAttribute("email");
		
		try {
			Member m = ms.getMemberInfo(email);
			
			request.setAttribute("pic", m.getProfilepic());
			request.setAttribute("email", email);
			request.setAttribute("nick", m.getNickname());
			request.setAttribute("birth", m.getBirth());
			request.setAttribute("gender", m.getGender());
			request.setAttribute("intro", m.getIntro());
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/member/myinfo.jsp");
			
			dispatcher.forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
