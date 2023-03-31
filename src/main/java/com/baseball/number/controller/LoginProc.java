package com.baseball.number.controller;

import java.io.IOException;
import java.nio.file.attribute.GroupPrincipal;
import java.nio.file.attribute.UserPrincipal;
import java.nio.file.attribute.UserPrincipalLookupService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.baseball.number.dto.UserDTO;
import com.baseball.number.repository.UserDAO;
import com.baseball.number.service.UserService;

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
//		response.setCharacterEncoding("utf-8");
//		response.setContentType("text/html");
//		request.setCharacterEncoding("utf-8");
//		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
//		dispatcher.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		String email = request.getParameter("email");
		String pswd = request.getParameter("pswd");
		UserDTO user = new UserService().loginUserByEmailAndPassword(email, pswd);
		
		
		if(user != null) {
			HttpSession session = request.getSession();
			session.setAttribute("userId", user.getUserId());
			session.setAttribute("email", user.getEmail());
			session.setAttribute("username", user.getUsername());
			session.setAttribute("userRole", user.getUserRole());
			
			System.out.println("로그인성공");
			response.sendRedirect("/baseball/indexProc");
			// doGet(request, response);
		} else {
			response.getWriter().write("<script> alert('로그인에 실패하였습니다.'); location.href='login.jsp' </script>");
			System.out.println("로그인실패");
		}
	}

}
