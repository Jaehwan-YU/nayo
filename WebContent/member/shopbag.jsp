<%@page import="java.util.List"%>
<%@page import="com.nayo.web.entity.Food"%>
<%@page import="com.nayo.web.member.FoodService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	FoodService fs = new FoodService();

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>나도 요리사 - 나요</title>

<link href="../css/shopbag.css" type="text/css" rel="stylesheet" />

</head>


<body>
	<h1>나요</h1>
	<!-- 헤더영역 -->
	<header id="header">
		<section class="content-container">			
			<nav id="logo">
					<img alt= "나요" src = "images/NaYo-Logo.PNG">
			</nav>

			<nav id="finder">
				<h1>검색 창</h1>
				<form>
					<input type="text" placeholder="재료명, 레시피명 검색" /> <input
						type="submit" value="검색" />
				</form>
			</nav>

			<nav id="user-menu">
				<h1>고객 메뉴</h1>
				<ul>
					<li><a href="">로그아웃</a></li>
					<li><a href="../notice/list.jsp">고객센터</a></li>
					<li><a href="recipe/list.jsp">마이페이지</a></li>
				</ul>
			</nav>
		</section>
	</header>
	
	<div id="visual"></div>
	
	<!--메인메뉴 영역-->
	<section id="main-menu">
		<div class="content-container">
			<h1>메인 메뉴</h1>
			<nav id="main-menu-list">
				<h1>메뉴 목록</h1>
				<ul>
					<li><a href="food.jsp">나의 식재료</a></li>
					<li><a href="../recipe/list.jsp">레시피</a></li>
					<li><a href="shopbag.jsp">장바구니</a></li>
					<li><a href="menu.jsp">나의 식단</a></li>
				</ul>
			</nav>
		</div>
	</section>
	
	<section id = "main-food">
		<div class = "main-food-container">
			<h1>메인 식재료 목록</h1>
			<nav id = "main-food-list">
				<ul>	
					<li><a href="">인기</a></li>
					<li><a href="">채소/과일</a></li>
					<li><a href="">육류</a></li>
					<li><a href="">수산물</a></li>
					<li><a href="">곡물/견과류</a></li>
					<li><a href="">양념/소스</a></li>
					<li><a href="">가공 유제품</a></li>
					<li><a href="">기타</a></li>
				</ul>
			</nav>
		</div>
	</section>
		
	<section id = 'body'>	
		
	</section>
	
	<!-- footer 영역 -->
	<footer id="footer"></footer>	
</body>
</html>