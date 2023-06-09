package com.baseball.number.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.baseball.number.service.MainService;

/**
 * Servlet implementation class LogoutProc
 */
@WebServlet("/LogoutProc")
public class LogoutProc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LogoutProc() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		new MainService().deleteNumbers((int)session.getAttribute("userId"));
		session.invalidate();
		
		response.sendRedirect("indexProc");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
