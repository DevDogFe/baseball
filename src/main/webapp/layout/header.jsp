<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">

	@import	url('https://fonts.googleapis.com/css2?family=Nanum+Pen+Script&family=Noto+Sans+KR:wght@300&display=swap');
	@import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap');
	
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
	justify-content: space-between;
	align-items: center;
	padding: 20px;
	color: #fff;
}

header h1 a{
	flex: 1;
	font-family: 'Nanum Pen Script', cursive;
	font-size: 40px;
	padding-left: 30px;
}

header nav {
	flex: 2;
	font-family: 'Noto Sans KR', sans-serif;
}

nav ul {
	display: flex;
	justify-content: space-around;
	align-items: center;
	list-style: none;
}

a {
	text-decoration: none;
	font-size: 20px;
	color: #fff;
}

a:hover {
	color: #ddd;
}

#login {
	background-color: orange;
	color: black;
	font-size: 20px;
	font-weight: bold;
	width: 100px;
	height: 50px;
	cursor: pointer;
	border: 2px solid black;
	display: flex;
	justify-content: center;
	align-items: center;
	box-shadow: 1px 1px 10px rgba(0, 0, 0, 0.5);
}
#login:hover{
	background-color: #b77c00;
}

section {
	flex: 10;
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
		<nav>
			<ul>
				<li><a href="main.jsp">게임하기</a></li>
				<li><a href="rank">전체 랭킹 보기</a></li>
			</ul>
		</nav>
		<%if(session.getAttribute("email") != null){%>
		<div>
			<div id="login" onclick="location.href='LogoutProc'">Logout</div>
		</div>
		<%} else {%>
		<div>
			<div id="login" onclick="location.href='login.jsp;'">Login</div>
		</div>
		<%} %>
	</header>