package com.baseball.number.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.baseball.number.dto.BoardDTO;
import com.baseball.number.service.BoardService;

@WebServlet({ "/readProc", "/read" })
public class ReadProc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ReadProc() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; utf-8");
		int boardId = Integer.parseInt(request.getParameter("boardId"));
		System.out.println(boardId);
		BoardDTO boardDTO = new BoardService().showBoardContent(boardId);
		System.out.println(boardDTO.getTitle());
		request.setAttribute("boardDTO", boardDTO);
		request.getRequestDispatcher("readBoard.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
