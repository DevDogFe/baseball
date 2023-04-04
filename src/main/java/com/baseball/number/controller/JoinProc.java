package com.baseball.number.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.SendResult;

import com.baseball.number.dto.UserDTO;
import com.baseball.number.service.UserService;

/**
 * Servlet implementation class JoinProc
 */
@WebServlet("/joinProc")
public class JoinProc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public JoinProc() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		request.getRequestDispatcher("join.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		String email = request.getParameter("email");
		String username = request.getParameter("username");
		String pswd = request.getParameter("pswd");
		String pswdCheck = request.getParameter("pswdCheck");
		if(new UserService().checkEmail(email) == 1) {
			response.getWriter().write("<script>alert('이미 존재하는 이메일입니다.'); location.href='join.jsp'</script>");
		} else if(new UserService().checkUsername(username) == 1) {
			response.getWriter().write("<script>alert('이미 존재하는 닉네임입니다.'); location.href='join.jsp'</script>");
		}
		
		if(pswd.equals(pswdCheck)) {
			UserDTO userDTO = new UserDTO(email, pswd, username);
			int resultRowCount = new UserService().joinUserByInformation(userDTO);
			if(resultRowCount == 2) {
				response.sendRedirect("index.jsp");
			} else {
				response.getWriter().write("<script>alert('회원가입에 실패하였습니다.'); location.href='join.jsp'</script>");
			}
		} else {
			response.getWriter().write("<script>alert('비밀번호와 비밀번호 확인의 값이 같아야합니다.'); location.href='join.jsp'</script>");
		}
		
		
		
		
	}

}
