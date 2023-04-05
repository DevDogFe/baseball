<%@page import="com.baseball.number.utils.BaseballCalculater"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	if(session.getAttribute("userId") == null){
		out.print("<script>alert('로그인이 필요합니다.'); location.href='index.jsp'</script>");
	}
%>
    
<jsp:include page="/layout/header.jsp"/>
<style>

@import url('https://fonts.googleapis.com/css2?family=Hi+Melody&display=swap');
body{
	min-width: 700px;
}
a:hover {
	text-decoration: none;
	color: #ddd;
}
section{
	display: flex;
	flex-direction: column;
	padding: 40px;
	flex: 10;
	font-family: 'Noto Sans KR', sans-serif;
	
}

section h1{
	font-size: 30px;
}

section p {
	font-size: 20px;
	padding: 10px;	
}

input{
	font-size: 20px;
	padding: 5px;
	margin-right: 10px;
}

input[type="submit"]{
	font-size: 19px;
	padding: 5px;
	border: none;
	background-color: #645;
	color: #fff;
	border-radius: 5px;
	
}
.form-container{
	display: flex;
	flex-direction: column;
	align-items: center;
}


form *{
	margin-bottom: 20px;
}

.result-container{
	display: flex;
	margin-top: 20px;
	flex-wrap: wrap;
}
label{
	font-size: 15px;
}
textarea{
	font-size: 15px;
}

.result-item{
	
	padding: 20px;
	margin-right: 30px;
	margin-bottom: 30px;
	background-color: #edc;
	border-radius: 10px;
	font-size: 20px;
	min-width: 193px;
}


</style>

	<section>
		<div class="form-container">
			<h1>숫자야구 게임</h1>
			<p>0 ~ 9의 숫자를 3개 입력해주세요(첫번째 숫자는 0 불가)</p>
			<form action="mainProc" method="post">
					<input type="number" name="guess1" required="required" min="1" max="9"> 
					<input type="number" name="guess2" required="required" min="0" max="9"> 
					<input type="number" name="guess3" required="required" min="0" max="9"> 
					<input type="submit" value="확인하기"><br>
					<label>메모장</label><br>
					<textarea name="memo" rows="7" cols="50"></textarea>
			</form>
		</div>
		<div class="result-container">
		<%if(session.getAttribute("1") != null){
			for(int i = 1; i < 9; i++){
				if(session.getAttribute(i + "") == null) break;%>	
			<div class="result-item">	
				<div><%=(int)session.getAttribute(i + "") %>차시기</div>
				<div>결과: <%=(int)session.getAttribute("strike" + i) %>S <%=(int)session.getAttribute("ball" + i)%>B </div>
				<div>입력한 숫자: <%=(int)session.getAttribute("guess1" + i) %> <%=(int)session.getAttribute("guess2" + i)%> <%=(int)session.getAttribute("guess3" + i)%> </div>
			</div>
		<%}}%>
		</div>
	
	</section>
	
<jsp:include page="/layout/footer.jsp"/>
