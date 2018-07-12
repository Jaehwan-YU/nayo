<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>나도 요리사 - 나요</title>
<link href="../css/style.css" type="text/css" rel="stylesheet" />
</head>
<body>
	<h1>나요</h1>
	<!-- 헤더영역 -->
	<header id="header">
		<section class="content-container">
			<h1>상단 메뉴</h1>
			<nav id="logo">
				<h1>로고</h1>
				<a href="../index.jsp">나요</a>
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
					<li><a href="../member/recipe/list.jsp">마이페이지</a></li>
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
					<li><a href="../member/food.jsp">나의 식재료</a></li>
					<li><a href="list.jsp">레시피</a></li>
					<li><a href="../member/shopbag.jsp">장바구니</a></li>
					<li><a href="../member/menu.jsp">나의 식단</a></li>
				</ul>
			</nav>
		</div>
	</section>

</body>
</html>