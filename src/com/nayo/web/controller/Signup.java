package com.nayo.web.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nayo.web.entity.Member;
import com.nayo.web.member.MyInfoService;


@WebServlet("/signup")
public class Signup extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ctx = request.getContextPath();
		request.setAttribute("ctx", ctx);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/signup.jsp");
		
		dispatcher.forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		MyInfoService ms = new MyInfoService(getServletContext());
		Member m = new Member();
		String email = request.getParameter("email");
		String pwd = request.getParameter("password");
		String nick = request.getParameter("nickname");
		
		try {
			ms.SignUp(email, pwd, nick);
			response.sendRedirect("login");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*m.setEmail(email);
		m.setPwd(pwd);
		m.setNickname(nick);*/
	}
}
