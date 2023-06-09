package com.baseball.number.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.baseball.number.dto.UserDTO;
import com.baseball.number.repository.PointDAO;
import com.baseball.number.service.UserService;

@WebServlet("/rank")
public class RankProc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RankProc() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; utf-8");
		response.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		if(session.getAttribute("userId") != null) {
			UserDTO userDTO = new UserService().selectUsersPointByUserId((int)session.getAttribute("userId"));
			request.setAttribute("userDTO", userDTO);
		}
		ArrayList<UserDTO> weekList = new UserService().selectAllUsersPoint("weekPoint");
		ArrayList<UserDTO> monthList = new UserService().selectAllUsersPoint("monthPoint");
		ArrayList<UserDTO> totalList = new UserService().selectAllUsersPoint("totalPoint");
		request.setAttribute("weekList", weekList);
		request.setAttribute("monthList", monthList);
		request.setAttribute("totalList", totalList);
		request.getRequestDispatcher("rank.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; utf-8");
		response.setCharacterEncoding("utf-8");
		String action = request.getParameter("action");
		if(action.equals("weekUpdate")) {
			new PointDAO().updateWeekpoint();
		} else if(action.equals("monthUpdate")) {
			new PointDAO().updateMonthPoint();
		}
		doGet(request, response);
	}

}
