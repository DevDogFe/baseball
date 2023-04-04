package com.baseball.number.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

import com.baseball.number.service.MainService;
import com.baseball.number.service.UserService;
import com.baseball.number.utils.BaseballCalculater;

@WebServlet("/mainProc")
public class MainProc extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MainProc() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; utf-8");
		response.setCharacterEncoding("utf-8");
		RequestDispatcher dispatcher = request.getRequestDispatcher("main.jsp");

		dispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; utf-8");
		response.setCharacterEncoding("utf-8");
		int[] guesses;
		int[] result;
		BaseballCalculater calculater = new BaseballCalculater();
		guesses = new int[3];
		guesses[0] = Integer.parseInt(request.getParameter("guess1"));
		guesses[1] = Integer.parseInt(request.getParameter("guess2"));
		guesses[2] = Integer.parseInt(request.getParameter("guess3"));
		if(guesses[0] == guesses[1] || guesses[0] == guesses[2] || guesses[1] == guesses[2]) {
			response.getWriter().write("<script>alert('같은 숫자를 사용할 수 없습니다.'); location.href='.jsp'</script>");
		}

		HttpSession session = request.getSession();
		int userId = (int) session.getAttribute("userId");
		int[] nums = new int[3];
		int tryCount = 0;

		int[] dbNums = new MainService().selectNumbers(userId);
		if (dbNums[0] != 0) {
			nums[0] = dbNums[0];
			nums[1] = dbNums[1];
			nums[2] = dbNums[2];
			tryCount = dbNums[3];
			session.setAttribute(tryCount + "", tryCount);
		} else {
			dbNums = new MainService().insertNumbers(userId);
			nums[0] = dbNums[0];
			nums[1] = dbNums[1];
			nums[2] = dbNums[2];
			tryCount = dbNums[3];
			session.setAttribute(tryCount + "", tryCount);
		}

		result = calculater.checkNumbers(nums, guesses);
		if (result[0] == 3) {
			request.setAttribute("point", 11 - tryCount);
			RequestDispatcher dispatcher = request.getRequestDispatcher("win.jsp");
			dispatcher.forward(request, response);

		} else if (tryCount < 9) {
			session.setAttribute("strike" + tryCount, result[0]);
			session.setAttribute("ball" + tryCount, result[1]);
			session.setAttribute("guess1" + tryCount, guesses[0]);
			session.setAttribute("guess2" + tryCount, guesses[1]);
			session.setAttribute("guess3" + tryCount, guesses[2]);
			
			doGet(request, response);
		} else {
			response.sendRedirect("gameover.jsp");
		}

	}

} // end of class
