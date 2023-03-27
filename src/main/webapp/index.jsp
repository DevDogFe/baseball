<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:include page="/layout/header.jsp"/>
<style>

@import url('https://fonts.googleapis.com/css2?family=Hi+Melody&display=swap');

section{
	display: flex;
	
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
		<article>
			<h1>※ 숫자야구 규칙</h1>
			<p>1.숫자는 1부터 9까지 사용한다.</p>
			<p>2.정해진 3개의 중복되지 않은 숫자를 맞추는 게임이다.</p>
			<p>3.숫자를 3개씩 제시하여 값을 받아 판단한다.</p>
			<p>4.숫자는 맞지만 위치가 틀렸을 때는 볼(B)로 표시된다.</p>
			<p>5.숫자와 위치가 전부 맞으면 스트라이크로 표시된다.</p>
			<p>6.정해진 숫자와 위치를 모두 맞추면 3스트라이크가 되어 게임에서 승리한다.</p>
		</article>
		<aside>
			<h1>👑주간 랭킹👑</h1>
		</aside>
	</section>
	
<jsp:include page="/layout/footer.jsp"/>
