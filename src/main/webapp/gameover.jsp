<%@page import="com.baseball.number.service.MainService"%>
<%@page import="com.baseball.number.utils.BaseballCalculater"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	if(session.getAttribute("email") == null){
		out.print("<script>alert('로그인이 필요합니다.'); location.href='index.jsp'</script>");
	}
	int userId = (int)session.getAttribute("userId");
	new MainService().deleteNumbers(userId);
	if (session.getAttribute("1") != null){
		for(int i = 1; i < 9; i++){
			if(session.getAttribute(i+"")==null) break;
			session.removeAttribute(i+"");
		}
	}
		
%>
    
<jsp:include page="/layout/header.jsp"/>
<style>

@import url('https://fonts.googleapis.com/css2?family=Hi+Melody&display=swap');
a:hover {
	text-decoration: none;
	color: #ddd;
}
section{
	display: flex;
	flex-direction: column;
	flex: 10;
	font-family: 'Noto Sans KR', sans-serif;
	padding: 40px;
	text-align: center;
}

</style>

	<section>
		<h1>숫자야구 게임</h1>
	

		<p>게임에서 패배하였습니다. 다시 도전해보세요.</p>
	
	</section>
	
<jsp:include page="/layout/footer.jsp"/>
