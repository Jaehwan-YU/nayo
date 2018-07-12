<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<header id="header">
	<div class="content-container">
		<h1>
			<a href="../index.jsp"><img scr="" alt="">나요</a>
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
					<li><a href="../login.jsp">로그인</a></li>
					<li><a href="../../notice/list.jsp">고객센터</a></li>
					<li><a href="recipe/list.jsp">마이페이지</a></li>
				</ul>
		</nav>		
	</div>
</header>
	
<section class="content-container">
	<nav id="main-menu">
		<h1>메인메뉴</h1>
			<ul>
				<li><a href="food.jsp">나의 식재료</a></li>
				<li><a href="../recipe/list.jsp">레시피</a></li>
				<li><a href="shopbag.jsp">장바구니</a></li>
				<li><a href="menu.jsp">나의 식단</a></li>
			</ul>
	</nav>			
</section>
	
</body>
</html>