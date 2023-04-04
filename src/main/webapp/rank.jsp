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
body{
	min-width:1300px;
}
a:hover {
	text-decoration: none;
	color: #ddd;
}
section{
	display: flex;
	align-items: center;
	justify-content: flex-start;
	flex: 10;
	
}
article {
	flex: 4;
	height: 100%;
	display: flex;
	flex-direction: column;
	justify-content: flex-start;
	align-items: center;
	padding: 20px;
	font-family: 'Hi Melody', cursive;
	font-weight: bold;
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
	height: 100%;
	flex: 3;
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

td, th{
	padding-left: 5px;
	font-size: 17px;
	text-align: center;
}

.table-third {
}
button{
	font-size: 16px;
}
</style>

	
	<section>
		<article>
			<h1>👑주간 순위👑</h1>
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
		</article>
		<article>
			<h1>👑월간 순위👑</h1>
			<table>
			<tr>
				<th>순위</th>
				<th>이름</th>
				<th>포인트</th>
			</tr>
			<c:set var="countMonth" value="1"></c:set>
			<c:forEach var="monthPoint" items="${monthList}" end="10">
			<tr>
				<th><c:out value="${countMonth}"/></th>
				<th>${monthPoint.username}</th>
				<th>${monthPoint.monthPoint}</th>
			</tr>
			<c:set var="countMonth" value="${countMonth +1}"/>
			</c:forEach>
			</table>
		</article>
		<article>
			<h1>👑총 포인트 순위👑</h1>
			<table>
			<tr>
				<th>순위</th>
				<th>이름</th>
				<th>포인트</th>
			</tr>
			<c:set var="countTotal" value="1"></c:set>
			<c:forEach var="totalPoint" items="${totalList}">
			<tr>
				<th><c:out value="${countTotal}"/></th>
				<th>${totalPoint.username}</th>
				<th>${totalPoint.totalPoint}</th>
			</tr>
			<c:set var="countTotal" value="${countTotal +1}"/>
			</c:forEach>
			</table>
		</article>
		<aside>
		<%if(username.equals("")){ %>
			<div id="information-box">
				<h4>게임을 시작하려면 로그인이 필요합니다.</h4>
			</div>
			<%} else{%>
			<div id="information-box">
				<h4><%=username%>님 환영합니다.<br> <button onclick="location.href='updateProc'">정보수정</button></h4>
				<p>주간 포인트: <%=userDTO.getWeekPoint() %></p>
				<p>포인트: <%=userDTO.getTotalPoint() %></p>
			</div>
			<%}%>
			<%if("admin".equals((String)session.getAttribute("userRole"))){ %>
			<div>
				<form action="rank?action=weekUpdate" method="post">
					<input type="submit" value="주간 포인트 초기화">
				</form>
				<form action="rank?action=monthUpdate" method="post">
					<input type="submit" value="월간 포인트 초기화">
				</form>
			</div>
			<%}%>
		</aside>
		
	</section>
	
<jsp:include page="/layout/footer.jsp"/>
