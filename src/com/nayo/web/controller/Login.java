package com.nayo.web.controller;

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

import com.nayo.web.member.MyInfoService;

@WebServlet("/login")
public class Login extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String ctx = request.getContextPath();
		request.setAttribute("ctx", ctx);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/login.jsp");

		dispatcher.forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MyInfoService ms = new MyInfoService(getServletContext());
		String email = request.getParameter("email");
		String pwd = request.getParameter("pwd");
		HttpSession session = request.getSession();
		
		try {
			if(ms.login(email, pwd)) {
				session.setAttribute("email", email);
				response.sendRedirect("member/food");
			}
			else {
				response.sendRedirect("login");
				//로그인 다시해 알림 띄워주기
			}
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}
		
		
	}
}
