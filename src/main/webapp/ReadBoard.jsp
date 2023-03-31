<%@page import="com.baseball.number.dto.BoardDTO"%>
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
	min-height: 800px;
}
.header{
	margin: 10px;
	background-color: #ecc;
	border-radius: 20px;
	padding: 20px;
}
.header-flex-container{
	display: flex; 
	justify-content: space-between;
	margin-top: 5px;
}
.content{
	min-height: 400px;
	margin: 10px;
	background-color: #ecc;
	border-radius: 20px;
	padding: 20px;
}
.buttons{
	margin: 10px;
	display: flex;
	justify-content: flex-end;
}
.buttons button{
	margin-left: 20px;
	border: none;
	background-color: 
}
.reply-container{
	margin: 10px;
	background-color: #ecc;
	border-radius: 20px;
	padding: 20px;
}
.reply-flex-container{
	display: flex; 
	justify-content: space-between;
	margin-top: 5px;
}

</style>

	<section>
		<div class="header">
			<div>제목: <%=boardDTO.getTitle()%></div>
			<div class="header-flex-container">
				<div>작성자: <%=boardDTO.getUserId()%></div>
				<div>조회수: <%=boardDTO.getViews()%></div>
				<div>작성시간: <%=boardDTO.getCreateTime()%></div>
			</div>
		</div>
		<div class="content">
			<%=boardDTO.getContent()%>
		</div>
		<div class="buttons">
			<button class="btn btn-primary">수정하기</button>
			<button class="btn btn-primary">삭제</button>
		</div>
		<div class="reply-container">
			<div>
				<form action="">
					<label for="reply-box">댓글</label>
					<input type="text" placeholder="내용을 입력하세요." id="reply-box">
					<input type="submit" value="댓글 등록">
				</form>  
			</div>
			<div class="reply-flex-container">
				<div>댓글 글쓴이</div>
				<div>댓글 내용</div>
				<div>작성 시간</div>
			</div>
		</div>
		
	</section>
	
<jsp:include page="/layout/footer.jsp"/>
