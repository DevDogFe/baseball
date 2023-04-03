package com.baseball.number.controller;

import java.io.IOException;
import java.nio.file.attribute.GroupPrincipal;
import java.nio.file.attribute.UserPrincipal;
import java.nio.file.attribute.UserPrincipalLookupService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
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
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		String email = request.getParameter("email");
		String pswd = request.getParameter("pswd");
		String remember = request.getParameter("remember");
		UserDTO user = new UserService().loginUserByEmailAndPassword(email, pswd);
		if("on".equals(remember)) {
			Cookie cookie = new Cookie("email", email);
			cookie.setMaxAge(60 * 60 * 24 * 7);
			response.addCookie(cookie);
		} else {
			Cookie[] cookies = request.getCookies();
			if(cookies != null){
				for(Cookie c : cookies){
					if(c.getName().equals("email")){
						c.setMaxAge(0);
						response.addCookie(c);
						break;
					}
				}
			}
		}
		
		if(user != null) {
			HttpSession session = request.getSession();
			session.setAttribute("userId", user.getUserId());
			session.setAttribute("email", user.getEmail());
			session.setAttribute("username", user.getUsername());
			session.setAttribute("userRole", user.getUserRole());
			
			response.sendRedirect("/baseball/indexProc");
			// doGet(request, response);
		} else if(new UserService().checkEmail(email) < 1){
			response.getWriter().write("<script> alert('없는 아이디(이메일주소)입니다.'); location.href='login.jsp' </script>");
		} else {
			response.getWriter().write("<script> alert('비밀번호가 틀렸습니다.'); location.href='login.jsp' </script>");
		}
	}

}
