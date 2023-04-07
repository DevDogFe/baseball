package com.baseball.number.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import javax.websocket.SendResult;

import com.baseball.number.dto.BoardDTO;
import com.baseball.number.dto.UserDTO;
import com.baseball.number.service.BoardService;
import com.baseball.number.service.UserService;

@WebServlet({ "/boardProc", "/board" })
@MultipartConfig
public class BoardProc extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BoardProc() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; utf-8");
		HttpSession session = request.getSession();
		int page = 0;
		if (session.getAttribute("userId") != null) {
			UserDTO userDTO = new UserService().selectUsersPointByUserId((int) session.getAttribute("userId"));
			request.setAttribute("userDTO", userDTO);
		}
		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		String action = request.getParameter("action");
		if ("prev".equals(action) && page > 0) {
			page -= 10;
		}
		if ("next".equals(action) && new BoardService().countBoardPage() - page > 10) {
			page += 10;
		}

		ArrayList<BoardDTO> boardList = new BoardService().showList(page);
		request.setAttribute("boardList", boardList);
		request.setAttribute("page", page);
		request.getRequestDispatcher("freeBoard.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; utf-8");
		HttpSession session = request.getSession();
		String action = request.getParameter("action");
		if ("write".equals(action)) {
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			System.out.println(title);
			// 파일 받기
			if (!request.getPart("file").getSubmittedFileName().equals("")) {
				Part filePart = request.getPart("file");
				filePart.getSubmittedFileName();

				String tempFileName = filePart.getSubmittedFileName().trim(); 
				System.out.println("tempFileName : " + tempFileName);
				// tempFileName.indexOf(".");
				String[] extention = tempFileName.split("\\.");
				
				if (!extention[1].equals("png") && !extention[1].equals("jpg") && !extention[1].equals("jpeg")
						&& !extention[1].equals("gif")) {
					System.out.println("dddddddddd");
					
					response.getWriter().write(
							"<script>alert('지원하지않는 확장자입니다.지원하는 파일: .png, .jpg, .jpeg, .gif'); location.href='writingBoard.jsp';</script>\n");
					
					return;
				}

				InputStream fileContent = filePart.getInputStream();
				OutputStream outputStream = null;

				try {
					UUID uuid = UUID.randomUUID();
					String fileName = uuid + "_" + filePart.getSubmittedFileName();
					int a = new BoardService().writeBoardContent(
							new BoardDTO(title, content, (int) session.getAttribute("userId"), fileName));
					String saveDirectory = "C:/java_web/baseball/src/main/webapp/files";
					File dir = new File(saveDirectory);
					if (!dir.exists()) {
						dir.mkdirs();
					}
					File file = new File("C:/java_web/baseball/src/main/webapp/files/", fileName);
					outputStream = new FileOutputStream(file);
					byte[] buffer = new byte[1024];
					int length;
					while ((length = fileContent.read(buffer)) != -1) {
						outputStream.write(buffer, 0, length);
					}
				} catch (Exception e) {
					fileContent.close();
					if (outputStream != null) {
						outputStream.flush();
						outputStream.close();
					}
				}
			} else {
				new BoardService().writeBoardContent(new BoardDTO(title, content, (int) session.getAttribute("userId"), ""));
			}
			doGet(request, response);
		} else if ("update".equals(action)) {
			int boardId = Integer.parseInt(request.getParameter("boardId"));
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			int a = new BoardService().updateBoardContent(new BoardDTO(title, content), boardId);
			doGet(request, response);
		}
	}

}
