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

import com.nayo.web.member.MyInfoService;

@WebServlet("/member/infocheck")
public class InfoCheck extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		MyInfoService mis = new MyInfoService(getServletContext());
		
		String email = (String)session.getAttribute("email");
		
		if(email == null) {
			response.sendRedirect("../login");
			return;
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/member/infocheck.jsp");
		
		dispatcher.forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MyInfoService ms = new MyInfoService(getServletContext());
		String pwd = request.getParameter("pwd");
		HttpSession session = request.getSession();
		String email = (String)session.getAttribute("email");
		
		try {
			if(ms.login(email, pwd)) {
				session.setAttribute("email", email);
				response.sendRedirect("myinfo");
			}
			else {
				response.sendRedirect("infocheck");
				//비밀번호 틀렸엉 알림 띄워주기
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
