<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link href="../css/faqStyle.css" type="text/css" rel="stylesheet" />
</head>
<body>
	<header id="header">
	<div class="content-container">
		<h1>
			<a href="../index.jsp">나요</a>

		</h1>
		<div id="search-engine">
			<h2>강좌검색 폼</h2>
			<form>
				<input type="text" placeholder="재료명, 레시피 검색" />
				<input type="submit" value="검색" />
			</form>
		</div>
		<div id="member-menu">
			<nav id="basic-menu">
				<h2>회원메뉴</h2>
				<ul>
					<li><a href="../login.jsp">로그인</a></li>
					<li><a href="../../notice/list.jsp">고객센터</a></li>
					<li><a href="recipe/list.jsp">마이페이지</a></li>
				</ul>
			</nav>
		</div>
	</div>
		<br />
			<section class="content-container">
				<nav id="main-menu">
					<h2>메인메뉴</h2>
					<ul>
						<li><a href="food.jsp">나의 식재료</a></li>
						<li><a href="../recipe/list.jsp">레시피</a></li>
						<li><a href="shopbag.jsp">장바구니</a></li>
						<li><a href="menu.jsp">나의 식단</a></li>
					</ul>
				</nav>			
			</section>
	</header>
	
	<div class="content-container">
		<div id="visual">		
		</div>
	</div>
	
<!-- body영역 -->
	<section id="body">
		<div class="content-container">
			<!-- aside영역 -->
			<aside id="aside">
				<h1>마이페이지 메뉴</h1>
					<h2>마이페이지</h2>
					<div id="aside-menu">
						<ul>
							<li><a href="../notice/list.jsp">공지사항</a>
							<li><a href="list.jsp">FAQ</a>
						</ul>
					</div>
			</aside>
			<!-- main영역 -->
			<main id="main">
				<h1>FAQ 목록</h1>
					<h2>FAQ</h2>
			</main>
		</div>
	</section>	

</body>
</html>