<%@page import="com.baseball.number.dto.UserDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%
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
 	UserDTO userDTO = (UserDTO)request.getAttribute("userDTO");
 %>
    
<jsp:include page="/layout/header.jsp"/>


<style>

@import url('https://fonts.googleapis.com/css2?family=Hi+Melody&display=swap');


section{
	display: flex;
	flex: 10;
	font-family: 'Noto Sans KR', sans-serif;
	
}
article {
	flex: 5;
	height: 100%;
	display: flex;
	flex-direction: column;
	justify-content: flex-start;
	padding: 20px;
	font-family: 'Hi Melody', cursive;
	font-weight: bold;
}

article h1{
	font-size: 30px;
	padding: 15px;
}

.board-container{
	display: flex; 
	width: 1000px;
	
}

.board-items{
	background-color: #345;
	text-align: center;
	padding: 5px;
	border-radius: 5px;
	margin: 3px;
	color: #def;
}
.item1{
	flex: 1;
}
.item2{
	flex: 10;
}
.item3{
	flex: 1;
}
.item4{
	flex: 2;
}

aside{
	flex: 2;
	background-color: #ddd;
	text-align: center;
	padding: 20px;
	
	display: flex;
	
	flex-direction: column;
	align-items: center;
}

#information-box{
	margin-bottom: 30px;
}
</style>

	<section>
		<article>
			<h1>📌게시판📌</h1>
			<div class=board-background>
				<div class="board-container">
					<div class="board-items item1">번호</div>
					<div class="board-items item2" onclick="">제 목</div>
					<div class="board-items item3">조회수</div>
					<div class="board-items item4">글쓴이</div>
				</div>
				<c:forEach var="board" items="${boardList}">
				<div class="board-container">
					<div class="board-items item1">${board.id}</div>
					<div class="board-items item2">${board.title}</div>
					<div class="board-items item3">${board.views}</div>
					<div class="board-items item4">${board.userId}</div>
				</div>
				</c:forEach>
			</div>
			<div>
				<a href="writingBoard.jsp">글쓰기</a>
				<button>이전 글</button>
				<button>다음 글</button>
			</div>
		</article>
		<aside>
			<%if(username.equals("")){ %>
			<div id="information-box">
				<h4>게임을 시작하려면 로그인이 필요합니다.</h4>
			</div>
			<%} else{%>
			<div id="information-box">
				<h4><%=username%>님 환영합니다. <button onclick="location.href='update.jsp'">정보수정</button></h4>
				<p>주간 포인트: <%=userDTO.getWeekPoint() %></p>
				<p>포인트: <%=userDTO.getTotalPoint() %></p>
			</div>
			<%}%>
		</aside>
	</section>
	
<jsp:include page="/layout/footer.jsp"/>
