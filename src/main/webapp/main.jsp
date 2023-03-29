<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
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
	<%
	int[] nums = new int[3];
	while ((nums[0] == nums[1]) || (nums[0] == nums[2]) || (nums[1] == nums[2])) {
		nums[0] = (int) (Math.random() * 9) + 1;
		nums[1] = (int) (Math.random() * 9) + 1;
		nums[2] = (int) (Math.random() * 9) + 1;
	}
	System.out.println(nums[0] + " " + nums[1] + " " + nums[2]);
	%>

	<p>1 ~ 9의 숫자를 3개 입력해주세요</p>
	<form action="main.jsp?state=1" method="post">
		<input type="hidden" name="answer1" value="<%=nums[0]%>"> <input
			type="hidden" name="answer2" value="<%=nums[1]%>"> <input
			type="hidden" name="answer3" value="<%=nums[2]%>"> <input
			type="number" name="guess1" required="required" min="1" max="9"> <input
			type="number" name="guess2" required="required" min="1" max="9"> <input
			type="number" name="guess3" required="required" min="1" max="9"> <input
			type="submit" value="정답제출">
	</form>
	<form action="" id="answer1">
	<%
		if(Integer.parseInt(request.getParameter("state")) == 1){
			int[] guesses = new int[3];
			boolean isRight = false;
			guesses[0] = Integer.parseInt(request.getParameter("guess1"));
			guesses[1] = Integer.parseInt(request.getParameter("guess2"));
			guesses[2] = Integer.parseInt(request.getParameter("guess3"));
		if (nums == guesses) {
			out.println("<p>정답입니다!</p>" + "<p>정답 숫자: " + nums[0] + ", " + nums[1] + ", " + nums[2] + "</p>");
		} else {
			int strikeCount = 0;
			int ballCount = 0;
			for (int i = 0; i < nums.length; i++) {
				if (nums[i] == guesses[i])
					strikeCount++;
				isRight = true;
			}
			for (int i = 0; i < nums.length; i++) {
				for (int j = 0; j < guesses.length; j++) {
					if (i != j && nums[i] == guesses[j])
						ballCount++;
				}
			}
			out.println("<p>오답입니다! " + strikeCount + "S" + ballCount + "B</p>" + "<p>입력된 숫자: " + guesses[0] + ", "
					+ guesses[1] + ", " + guesses[2] + "</p>");
				}
		}
	%>
	</form>
	</section>
	
<jsp:include page="/layout/footer.jsp"/>
