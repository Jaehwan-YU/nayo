package com.nayo.web.controller.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/member/menu")
public class MenuList extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ctx = request.getContextPath();
		request.setAttribute("ctx", ctx);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/member/menu.jsp");
		dispatcher.forward(request, response);
	}

}
