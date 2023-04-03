package com.baseball.number.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.baseball.number.dto.ReplyDTO;
import com.baseball.number.service.ReplyService;

@WebServlet("/replyProc")
public class ReplyProc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ReplyProc() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; utf-8");
		System.out.println("doget");
		
		String action = request.getParameter("action");
		if("delete".equals(action)) {
			int replyId = Integer.parseInt(request.getParameter("replyId"));
			int boardId = Integer.parseInt(request.getParameter("boardId"));
			new ReplyService().deleteReply(replyId);
			response.sendRedirect("readProc?boardId=" + boardId);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; utf-8");
		System.out.println("doPost");
		String action = request.getParameter("action");
		System.out.println(action);
		int boardId = Integer.parseInt(request.getParameter("boardId"));
		
		if ("reply".equals(action)) {
			int userId = Integer.parseInt(request.getParameter("userId"));
			String replyContent = request.getParameter("reply");
			ReplyDTO replyDTO = new ReplyDTO(replyContent, userId, boardId);
			System.out.println(replyContent + " " + userId + " " + boardId);
			int a = new ReplyService().insertReply(replyDTO);
			System.out.println(a);
			response.sendRedirect("readProc?boardId=" + boardId);
		}
	}

}
