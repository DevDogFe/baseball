package com.baseball.number.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.baseball.number.dao.UserDAO;
import com.baseball.number.dto.UserDTO;

/**
 * Servlet implementation class LoginProc
 */
@WebServlet("/LoginProc")
public class LoginProc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginProc() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		String email = request.getParameter("email");
		String pswd = request.getParameter("pswd");
		UserDTO user = new UserDAO().login(email, pswd);
		
		if(user != null) {
			HttpSession userSession = request.getSession();
			userSession.setAttribute("userId", user.getUserId());
			userSession.setAttribute("email", user.getEmail());
			userSession.setAttribute("username", user.getUsername());
			userSession.setAttribute("userRole", user.getUserRole());
			userSession.setAttribute("joinDate", user.getJoinDate());
			System.out.println("로그인성공");
			response.sendRedirect("/baseball/index.jsp");
		} else {
			response.getWriter().write("<script> alert('로그인에 실패하였습니다.'); location.href='login.jsp' </script>");
			System.out.println("로그인실패");
		}
		doGet(request, response);
	}

}
