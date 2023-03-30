<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">

<jsp:include page="/layout/header.jsp" />

<style>

@import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap');

section{
	padding: 60px;
	font-family: 'Noto Sans KR', sans-serif;
}
form {
	margin-top: 20px;
	width: 70%;
}


.form-group{
	margin-bottom: 30px;
}
</style>

<section>
	<h1>회 원 정 보 수 정</h1>
	<form action="updateProc" class="was-validated" method="post">
		<div class="form-group">
			<label for="username">닉네임 *</label> <input type="username"
				class="form-control" id="username" placeholder="Enter username"
				name="username" required>
			<div class="valid-feedback">Valid.</div>
		</div>
		<div class="form-group">
			<label for="pwd">비밀번호 *</label> <input type="password"
				class="form-control" id="pwd" placeholder="Enter password"
				name="pswd" minlength="6" maxlength="12" required>
			<div class="valid-feedback">Valid.</div>
		</div>
		<div class="form-group">
			<label for="pwdCheck">비밀번호확인 *</label> <input type="password"
				class="form-control" id="pswdCheck" placeholder="Enter password again"
				name="pswdCheck" minlength="6" maxlength="12" required>
			<div class="valid-feedback">Valid.</div>
		</div>
		
		<button type="submit" class="btn btn-primary">수정하기</button>
		<button type="reset" class="btn btn-primary">다시작성</button>
		<button class="btn btn-primary" onclick="delete">회원탈퇴</button>
	</form>
</section>

<jsp:include page="/layout/footer.jsp" />
