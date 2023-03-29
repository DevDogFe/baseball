package com.baseball.number.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

import com.baseball.number.utils.BaseballCalculater;

@WebServlet("/MainProc")
public class MainProc extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
    public MainProc() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; utf-8");
		response.setCharacterEncoding("utf-8");
		RequestDispatcher dispatcher = request.getRequestDispatcher("main.jsp");
		
		
		dispatcher.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; utf-8");
		response.setCharacterEncoding("utf-8");
		int tryCount = 0;
		int[] guesses;
		int[] result;
		BaseballCalculater calculater = new BaseballCalculater();
		tryCount++;
		guesses = new int[3];
		guesses[0] = Integer.parseInt(request.getParameter("guess1"));
		guesses[1] = Integer.parseInt(request.getParameter("guess2"));
		guesses[2] = Integer.parseInt(request.getParameter("guess3"));
		result = calculater.checkNumbers(guesses);
		if(result[0] == 3) {
			request.setAttribute("point", 11 - tryCount);
			RequestDispatcher dispatcher = request.getRequestDispatcher("win.jsp");
			dispatcher.forward(request, response);
			
		}else if(tryCount <9) {
			doGet(request, response);
		} else {
			response.sendRedirect("gameover.jsp");
		}
		
		
	}

}
