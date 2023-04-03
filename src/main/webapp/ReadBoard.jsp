<%@page import="com.baseball.number.dto.ReplyDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.baseball.number.service.UserService"%>
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
 	ArrayList<ReplyDTO> replyList = (ArrayList<ReplyDTO>)request.getAttribute("replyList");
 	UserService userService = new UserService();
 	
 	
 %>
    
<jsp:include page="/layout/header.jsp"/>


<style>

@import url('https://fonts.googleapis.com/css2?family=Hi+Melody&display=swap');
body{
	min-width:1100px;
}

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
.header-flex-container1{
	display: flex; 
	justify-content: space-between;
	margin-top: 5px;
}
.header-flex-container2{
	display: flex; 
	justify-content: flex-end;
	margin-top: 5px;
}
.header-flex-container div{
	padding-left: 15px;
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
.reply-flex-container .item1{
	flex: 1;
	min-width: 60px;
}
.reply-flex-container .item2{
	flex: 10;
}
.reply-flex-container .item3{
	flex: 2;
	text-align: left;
}
.reply-flex-container .item4{
	flex: 1;
	min-width: 250px;
}
a:hover {
	text-decoration: none;
	color: #ddd;
}
#reply-form{
	display: flex;
	justify-content: space-between;
}
#reply-form :first-child{
	flex: 1;
	min-width: 60px;
}

#reply-form input[type="text"]{
	flex: 10;
	margin-left: 20px;
}

#reply-form :last-child{
	flex: 1;
}

</style>

	<section>
		<div class="header">
			<div class="header-flex-container1">
				<div>제목: <%=boardDTO.getTitle()%></div>
				<div>작성자: <%=userService.searchUserById(boardDTO.getUserId())%></div>
			</div>
			<div class="header-flex-container2">
				<div>조회수: <%=boardDTO.getViews()%> &nbsp;&nbsp;</div>
				<div>작성시간: <%=boardDTO.getCreateTime()%></div>
			</div>
		</div>
		<div class="content">
			<%=boardDTO.getContent().replace("\r\n", "<br>")%>
		</div>
		<div class="buttons">
		<%if(boardDTO.getUserId() == userId){%>
			<form action="readProc?action=update&boardId=<%=boardDTO.getId()%>" method="post">
				<button type="submit" class="btn btn-primary">수정하기</button>
			</form>
		<%}%>
		<%if(boardDTO.getUserId() == userId || "admin".equals(userRole) ){%>
			<form action="readProc?action=delete&boardId=<%=boardDTO.getId()%>" method="post">
				<button type="submit" class="btn btn-primary">삭제</button>
			</form>
		<%}%>
		</div>
		<div class="reply-container">
			<div>
				<form action="replyProc?action=reply&userId=<%=userId%>&boardId=<%=boardDTO.getId()%>" method="post" id="reply-form">
					<label for="reply-box">댓글</label>
					<input type="text" placeholder="내용을 입력하세요." id="reply-box" name="reply">
					<input type="submit" value="댓글 등록">
				</form>  
			</div>
			<c:forEach var="reply" items="${replyList}">
				<div class="reply-flex-container">
					<div class="reply-items item1">${reply.username}</div>
					<div class="reply-items item2">${reply.content}</div>
					<div class="reply-items item3">${reply.createTime}</div>
					<c:set value="${reply.userId}" var="replyUserId"></c:set>
					<%if("admin".equals(userRole) || userId == Integer.parseInt(pageContext.getAttribute("replyUserId").toString()) ){ %>
					<div class="reply-items item4"><button = onclick="location.href='replyProc?action=delete&boardId=<%=boardDTO.getId()%>&replyId=${reply.id}'">삭제하기</button> </div>
					<%} %>
				</div>
			</c:forEach>
		</div>
		
	</section>
	
<jsp:include page="/layout/footer.jsp"/>
