<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String ctx = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>나도 요리사 - 나요</title>
</head>
<body>

<header id="header">
	<div class="content-container">
		<h1>
			<a href="<%= ctx %>/index"><img scr="" alt="">나요</a>
		</h1>
			
		<nav id="search-engine">
			<h1>검색 폼</h1>
				<form>
					<input type="text" placeholder="재료명, 레시피 검색" />
					<input type="submit" value="검색" />
				</form>
		</nav>
	
		<nav id="basic-menu">
			<h1>회원메뉴</h1>
				<ul>
					<li><a href="<%= ctx %>/login">로그인</a></li>
					<li><a href="<%= ctx %>/notice/list">고객센터</a></li>
					<li><a href="<%= ctx %>/member/bookmark">마이페이지</a></li>
				</ul>
		</nav>		
	</div>
</header>
	
<section class="content-container">
	<nav id="main-menu">
		<h1>메인메뉴</h1>
			<ul>
				<li><a href="<%= ctx %>/member/food">나의 식재료</a></li>
				<li><a href="<%= ctx %>/recipe/list">레시피</a></li>
				<li><a href="<%= ctx %>/member/shopbag">장바구니</a></li>
				<li><a href="<%= ctx %>/member/menu">나의 식단</a></li>
			</ul>
	</nav>			
</section>
	
</body>
</html>