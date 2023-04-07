<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>숫 자 야 구</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.3/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="css/header.css">

</head>
<body>
	<header>
		<h1><a href="indexProc">숫 자 야 구</a></h1>
		<nav>
			<ul>
				<li><a href="mainProc">게임하기</a></li>
				<li><a href="boardProc">자유게시판</a></li>
				<li><a href="rank">전체 랭킹 보기</a></li>
			</ul>
		</nav>
		<%if(session.getAttribute("email") != null){%>
		<div>
			<div id="login" onclick="location.href='LogoutProc'">Logout</div>
		</div>
		<%} else {%>
		<div>
			<div id="login" onclick="location.href='loginProc'">Login</div>
		</div>
		<%} %>
	</header>