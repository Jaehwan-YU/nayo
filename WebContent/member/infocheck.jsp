<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nayo!</title>
</head>
<body>
	<header>


		<h1>
			<a href="../index.html">Nayo로고</a>
		</h1>

		<div>
			<h2>MainMenu</h2>
			<h3>목록</h3>
			<ul>
				<li><a href="food.jsp">나의 식재료</a></li>
				<li><a href="../recipe/list.jsp">레시피</a></li>
				<li><a href="shopbag.jsp">장바구니</a></li>
				<li><a href="menu.jsp">나의 식단</a></li>
			</ul>
		</div>

		<div>
			<ul>
				<li><a href="../login.jsp">로그인</a></li>
				<li><a href="../../notice/list.jsp">고객센터</a></li>
				<li><a href="recipe/list.jsp">마이페이지</a></li>
			</ul>
		</div>
	</header>

	<div>

		<h3>마이페이지</h3>
		<ul>
			<li><a href="recipe/list.jsp">나의 레시피</a></li>
			<li><a href="bookmark.jsp">즐겨먹기</a></li>
			<li><a href="infocheck.jsp">내 정보</a></li>
		</ul>
	</div>
	<div>
		<h3>비밀번호 재확인</h3>
		<p>
			본인확인을 위해 한번 더 비밀번호를 입력해주세요.<br /> 비밀번호는 타인에게 노출되지 않도록 주의해 주세요
		</p>
		<hr />
		<ol>
		<ul>
		<li>아이디 : <Input type="text"></li><br> 
		<li>비밀번호 재확인 : <Input type="text"></li><br>
		</ol>
	</div>
</body>
</html>