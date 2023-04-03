package com.baseball.number.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.baseball.number.dto.BoardDTO;
import com.baseball.number.dto.ReplyDTO;
import com.baseball.number.repository.ReplyDAO;
import com.baseball.number.service.BoardService;
import com.baseball.number.service.ReplyService;

@WebServlet({ "/readProc", "/read" })
public class ReadProc extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ReadProc() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; utf-8");
		int boardId = Integer.parseInt(request.getParameter("boardId"));
		HttpSession session = request.getSession();
		int userId = (int)session.getAttribute("userId");
		BoardDTO boardDTO = new BoardService().showBoardContent(boardId, userId);
		ArrayList<ReplyDTO> replyList = new ReplyDAO().select(boardId);
		request.setAttribute("replyList", replyList);
		request.setAttribute("boardDTO", boardDTO);
		request.getRequestDispatcher("readBoard.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; utf-8");
		String action = request.getParameter("action");
		System.out.println(action);
		int boardId = Integer.parseInt(request.getParameter("boardId"));

		if ("delete".equals(action)) {
			new BoardService().deleteBoardContent(boardId);
			response.sendRedirect("boardProc");
		} else if ("update".equals(action)) {
			HttpSession session = request.getSession();
			int userId = (int)session.getAttribute("userId");
			request.setAttribute("boardDTO", new BoardService().showBoardContent(boardId, userId));
			request.getRequestDispatcher("updateBoard.jsp").forward(request, response);
		}

	}

}
