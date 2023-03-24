<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">

@import url('https://fonts.googleapis.com/css2?family=Nanum+Pen+Script&family=Noto+Sans+KR:wght@300&display=swap');

*{
	margin: 0;
	padding: 0;
	box-sizing: border-box;
}
body{
	height: 100vh;
	display: flex;
	flex-direction: column;
}
header{
	flex: 1;
	background-color: #7a0929;
	display: flex;
	justify-content: space-between;
	align-items: center;
	padding: 20px;
	color: #fff;
	
}

header h1{
	flex: 1;
	font-family: 'Nanum Pen Script', cursive;
	padding-left: 30px;
}

header nav{
	flex: 2;
	font-family: 'Noto Sans KR', sans-serif;
}

nav ul{
	display: flex;
	justify-content: space-around;
	align-items: center;
	list-style: none;
}

a{
	text-decoration: none;
	font-size: 20px;
	color: #fff;
}

a:hover{
	color: #ddd;
}

section{
	flex: 10;

}

footer{
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
		<h1>숫 자 야 구</h1>
		<nav>
			<ul>
				<li><a href="#">게임하기</a></li>
				<li><a href="login.jsp">로그인</a></li>
			</ul>
		</nav>
	</header>