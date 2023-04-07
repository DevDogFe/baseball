package com.baseball.number.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.SendResult;

import com.baseball.number.dto.UserDTO;
import com.baseball.number.service.UserService;
import com.baseball.number.dto.UserDTO.Builder;
@WebServlet("/updateProc")
public class UpdateProc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateProc() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; utf-8");
		request.getRequestDispatcher("update.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		String username = request.getParameter("username");
		String pswd = request.getParameter("pswd");
		String pswdCheck = request.getParameter("pswdCheck");
		HttpSession session = request.getSession();
		
		if(pswd.equals(pswdCheck)) {
			Builder builder = new Builder();
			UserDTO userDTO = builder.setUsername(username).setPassword(pswd).build();
			int resultRowCount = new UserService().updateUserInfo(userDTO, (int)session.getAttribute("userId"));
			if(resultRowCount == 1) {
				session.setAttribute("username", username);
				response.sendRedirect("indexProc");
			} else {
				response.getWriter().write("<script>alert('회원정보 수정에 실패하였습니다.'); location.href='join.jsp';</script>");
			}
				
		}
		
	}

}
