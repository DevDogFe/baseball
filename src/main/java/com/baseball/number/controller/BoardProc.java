package com.baseball.number.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.SendResult;

import com.baseball.number.dto.BoardDTO;
import com.baseball.number.dto.UserDTO;
import com.baseball.number.service.BoardService;
import com.baseball.number.service.UserService;

@WebServlet({ "/boardProc", "/board" })
public class BoardProc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardProc() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; utf-8");
		HttpSession session = request.getSession();
		int page = 0;
		if(session.getAttribute("userId") != null) {
			UserDTO userDTO = new UserService().selectUsersPointByUserId((int)session.getAttribute("userId"));
			request.setAttribute("userDTO", userDTO);
		}
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		String action = request.getParameter("action");
		System.out.println("doget");
		System.out.println(action);
		if("prev".equals(action) && page > 0) {
			System.out.println("prev");
			page -= 10;
		}
		if("next".equals(action) && new BoardService().countBoardPage() - page > 10) {
			System.out.println("next");
			page += 10;
		}
		System.out.println(page);
		
		ArrayList<BoardDTO> boardList = new BoardService().showList(page);
		request.setAttribute("boardList", boardList);
		request.setAttribute("page", page);
		request.getRequestDispatcher("freeBoard.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; utf-8");
		HttpSession session = request.getSession();
		String action = request.getParameter("action");
		if("write".equals(action)) {
			System.out.println(action);
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			int a = new BoardService().writeBoardContent(new BoardDTO(title, content, (int)session.getAttribute("userId")));
			System.out.println(a+a+a+a+"");
			doGet(request, response);
		} else if("update".equals(action)) {
			System.out.println(action);
			int boardId = Integer.parseInt(request.getParameter("boardId"));
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			int a = new BoardService().updateBoardContent(new BoardDTO(title, content), boardId);
			System.out.println(a+a+a+a+"");
			doGet(request, response);
		}
	}

}
