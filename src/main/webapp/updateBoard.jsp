<%@page import="com.baseball.number.dto.BoardDTO"%>
<%@page import="com.baseball.number.dto.UserDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%
 	if(session.getAttribute("userId") == null){
		out.print("<script>alert('로그인이 필요합니다.'); location.href='index.jsp'</script>");
	}
 	int userId = 0;
 	String email = "";
 	String username = "";
 	String userRole = "";
 	if(session.getAttribute("userId") != null){
	 	userId = (int)session.getAttribute("userId");
	 	email = (String)session.getAttribute("email");
	 	username = (String)session.getAttribute("username");
	 	userRole = (String)session.getAttribute("userRole");
 	}
 	BoardDTO boardDTO = (BoardDTO)request.getAttribute("boardDTO");
 %>
    
<jsp:include page="/layout/header.jsp"/>


<style>

@import url('https://fonts.googleapis.com/css2?family=Hi+Melody&display=swap');
section{
	padding: 30px;
	flex: 10;
	font-family: 'Noto Sans KR', sans-serif;
}
a:hover {
	text-decoration: none;
	color: #ddd;
}

</style>

	<section>
		<form action="boardProc?action=update&boardId=<%=boardDTO.getId()%>" method="post" class="was-validated">
		  <div class="form-group">
		    <label for="title">제목:</label>
		    <input type="text" class="form-control" id="title" placeholder="제목을 입력하세요." name="title" value="<%=boardDTO.getTitle() %>" required>
		    <div class="invalid-feedback">제목을 반드시 입력해야 합니다.</div>
		  </div>
			<div class="form-group">
				<label for="comment">내용:</label>
				<textarea class="form-control" rows="20" id="comment" name="content" value="<%=boardDTO.getContent()%>"></textarea>
			</div>
		  <button type="submit" class="btn btn-primary">수정하기</button>
		  <button type="reset" class="btn btn-primary">다시 작성</button>
		</form>
		
	</section>
	
<jsp:include page="/layout/footer.jsp"/>
