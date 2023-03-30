<%@page import="com.baseball.number.utils.BaseballCalculater"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	if(session.getAttribute("email") == null){
		out.print("<script>alert('로그인이 필요합니다.'); location.href='index.jsp'</script>");
	}
%>
    
<jsp:include page="/layout/header.jsp"/>
<style>

@import url('https://fonts.googleapis.com/css2?family=Hi+Melody&display=swap');

section{
	display: flex;
	flex-direction: column;
	
}
article {
	flex: 5;
	height: 100%;
	display: flex;
	flex-direction: column;
	justify-content: center;
	padding: 20px;
	font-family: 'Hi Melody', cursive;
	font-weight: bold;
}

article h1{
	font-size: 30px;
	padding: 15px;
}
p {
	font-size: 20px;
	padding: 10px;	
}

aside{
	flex: 2;
	background-color: #ddd;
	text-align: center;
	padding: 20px;
}
</style>

	<section>
			<h1>숫자야구 게임</h1>
	

	<p>1 ~ 9의 숫자를 3개 입력해주세요</p>
	<form action="MainProc" method="post">
			<input type="number" name="guess1" required="required" min="1" max="9"> 
			<input type="number" name="guess2" required="required" min="1" max="9"> 
			<input type="number" name="guess3" required="required" min="1" max="9"> 
			<input type="submit" value="확인하기">
	</form>
	<%if(session.getAttribute("1") != null){
		for(int i = 1; i < 9; i++){
			if(session.getAttribute(i + "") == null) break;%>	
			
		<div>tryCount: <%=(int)session.getAttribute(i + "") %></div>
		<div>결과: <%=(int)session.getAttribute("strike" + i) %>S <%=(int)session.getAttribute("ball" + i)%>B </div>
		<div>입력한 숫자: <%=(int)session.getAttribute("guess1" + i) %> <%=(int)session.getAttribute("guess2" + i)%> <%=(int)session.getAttribute("guess3" + i)%> </div>
		
			
		
	<%}}%>
	
	
	</section>
	
<jsp:include page="/layout/footer.jsp"/>
