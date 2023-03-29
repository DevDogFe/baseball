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
@WebServlet("/JoinProc")
public class JoinProc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoinProc() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.sendRedirect("/baseball/login.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		String email = request.getParameter("email");
		String username = request.getParameter("username");
		String pswd = request.getParameter("pswd");
		String pswdCheck = request.getParameter("pswdCheck");
		
		if(pswd.equals(pswdCheck)) {
			UserDTO userDTO = new UserDTO(email, pswd, username);
			int resultRowCount = new UserService().joinUserByInformation(userDTO);
			if(resultRowCount == 1) {
				response.sendRedirect("index.jsp");
			} else {
				response.getWriter().write("<script>alert('회원가입에 실패하였습니다.'); location.href='join.jsp'</script>");
			}
			
				
		}
		
		
		
		
	}

}
