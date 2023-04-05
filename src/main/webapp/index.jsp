<%@page import="com.baseball.number.service.UserService"%>
<%@page import="com.baseball.number.dto.UserDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%
 	int userId = 0;
 	String email = "";
 	String username = "";
 	String userRole = "";
 	UserDTO userDTO = null;
 	if(session.getAttribute("userId") != null){
	 	userId = (int)session.getAttribute("userId");
	 	email = (String)session.getAttribute("email");
	 	username = (String)session.getAttribute("username");
	 	userRole = (String)session.getAttribute("userRole");
	 	userDTO = new UserService().selectUsersPointByUserId((int)session.getAttribute("userId"));
		request.setAttribute("userDTO", userDTO);
 	}
 	
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
	justify-content: center;
	padding: 20px;
	font-weight: bold;
}

a:hover {
	text-decoration: none;
	color: #ddd;
}

article h1{
	font-size: 30px;
	padding: 15px;
	font-weight: bolder;
}
article p {
	font-size: 20px;
	padding: 10px;	
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
button{
	font-size: 16px;
	padding:5px;
	margin-top:5px;
}

#information-box{
	margin-bottom: 30px;
}
.rank-container{
	display: flex;
	justify-content: center;
}
</style>

	<section>
		<article>
			<h1>⚾ 숫자야구 규칙 ⚾</h1>
			<p>1.숫자는 1부터 9까지 사용한다.</p>
			<p>2.정해진 3개의 중복되지 않은 숫자를 맞추는 게임이다.</p>
			<p>3.숫자를 3개씩 제시하여 값을 받아 판단한다.</p>
			<p>4.숫자는 맞지만 위치가 틀렸을 때는 볼(B)로 표시된다.</p>
			<p>5.숫자와 위치가 전부 맞으면 스트라이크로 표시된다.</p>
			<p>6.정해진 숫자와 위치를 모두 맞추면 3스트라이크가 되어 게임에서 승리한다.</p>
		</article>
		<aside>
			<%if(username.equals("")){ %>
			<div id="information-box">
				<h4>게임을 시작하려면 로그인이 필요합니다.</h4>
			</div>
			<%} else{%>
			<div id="information-box">
				<h4><%=username%>님 환영합니다. <br><button onclick="location.href='updateProc'">정보수정</button></h4>
				<p>주간 포인트: <%=userDTO.getWeekPoint() %></p>
				<p>포인트: <%=userDTO.getTotalPoint() %></p>
			</div>
			<%}%>
			<div>
				<h2>👑주간 순위👑</h2>
				<div class="rank-container">
				<table>
				<tr>
					<th>순위</th>
					<th>이름</th>
					<th>포인트</th>
				</tr>
				<c:set var="countWeek" value="1"></c:set>
				<c:forEach var="weekPoint" items="${weekList}" end="10">
				<tr>
					<th><c:out value="${countWeek}"/></th>
					<th>${weekPoint.username}</th>
					<th>${weekPoint.weekPoint}</th>
				</tr>
				<c:set var="countWeek" value="${countWeek +1}"/>
				</c:forEach>
				</table>
				</div>
			</div>
		</aside>
	</section>
	
<jsp:include page="/layout/footer.jsp"/>
