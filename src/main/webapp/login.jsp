<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
Cookie[] cookies = request.getCookies();
String userEmail = "";
if(cookies != null){
	for(Cookie cookie : cookies) {
		if(cookie.getName().equals("email")){
			userEmail = cookie.getValue();
			break;
		}
	}
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>숫자야구 로그인</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<style type="text/css">
@import
	url('https://fonts.googleapis.com/css2?family=Nanum+Pen+Script&family=Noto+Sans+KR:wght@300&display=swap')
	;

* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
	
}

body {
	height: 100vh;
	display: flex;
	flex-direction: column;
}

header {
	flex: 1;
	background-color: #7a0929;
	display: flex;
	justify-content: center;
	align-items: center;
	padding: 20px;
	color: #fff;
}

header h1 {
	flex: 1;
	font-family: 'Nanum Pen Script', cursive;
	padding-left: 30px;
}

header nav {
	flex: 2;
	
}

nav ul {
	display: flex;
	justify-content: space-around;
	align-items: center;
	list-style: none;
}

a {
	text-decoration: none;
	font-size: 35px;
	color: #fff;
}

a:hover {
	text-decoration: none;
	color: #ddd;
}

section {
	flex: 10;
	display: flex;
	justify-content: center;
	align-items: center;
}

section div{
	flex: 1;
}

section form{
	flex: 2;
}
.button-box{
	display: flex;
	justify-content: space-between;
	font-family: 'Noto Sans KR', sans-serif;
}

footer {
	flex: 1;
	text-align: center;
	background-color: #7a0929;
	padding: 20px;
	color: #fff;
	font-family: 'Noto Sans KR', sans-serif;
}
</style>
</head>
<body>
	<header>
		<h1><a href="indexProc">숫 자 야 구</a></h1>

	</header>
	<section>
		<div></div>
		<form action="/baseball/loginProc" method="post">
			<div class="form-group">
				<label for="email">Email address</label> <input type="email"
					class="form-control" placeholder="Enter email" id="email" name="email" value="<%=userEmail%>">
			</div>
			<div class="form-group">
				<label for="pwd">Password</label> <input type="password"
					class="form-control" placeholder="Enter password" id="pwd" name="pswd">
			</div>
			<div class="form-group form-check">
				<label class="form-check-label"> <input
					class="form-check-input" type="checkbox" name="remember"> Remember me
				</label>
			</div>
			<div class="button-box">
			<button type="submit" class="btn btn-secondary">로그인</button>
			<button type="button" class="btn btn-secondary" onclick="location.href='joinProc'">회원가입</button>
			</div>
		</form>
		<div></div>
	</section>
	<jsp:include page="/layout/footer.jsp" />