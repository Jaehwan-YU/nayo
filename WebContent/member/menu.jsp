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

<link href="../css/menu.css" type="text/css" rel="stylesheet" />

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


	<section id = 'body'>
		<div class="menu-container">
			<nav id="daily-menu">
				<table border="1">
					<h3>2018년 6월</h3>
					<tr>
						<th>오늘</th>
						<td>18 아침<br>점심 <br>저녁<br></td>
					</tr>
					<tr>
						<th>화</th>
						<td>19 아침<br>점심 <br>저녁</td>
					</tr>
					<tr>
						<th>수</th>
						<td>20 아침<br>점심 <br>저녁</td>
					</tr>
					<tr>
						<th>목</th>
						<td>21 아침<br>점심 <br>저녁</td>
					</tr>
					<tr>
						<th>금</th>
						<td>22 아침<br>점심 <br>저녁</td>
					</tr>
					<tr>
						<th>토</th>
						<td>23 아침<br>점심<br>저녁</td>
					</tr>
					<tr>
						<th>일</th>
						<td>24 아침<br>점심<br>저녁</td>
					</tr>
				</table>
			</nav>
		</div>

		<div class="cook-container">
			<nav id="cook">
				<h4>바로 조리 가능</h4>
				<ul>
					<li>두부조림</li>
					<li>김치찌개</li>
					<li>어묵볶음</li>
					<li>김치볶음밥</li>
				</ul>
			</nav>	
		</div>
			
		<div class = "recommend-container">	
			<nav id = "recommend">	
				<h4>이번주 추천</h4>
				<ul>
					<li>닭볶음탕</li>
					<li>장어구이</li>
					<li>미역국</li>
					<li>순두부찌개</li>
				</ul>
			</nav>
		</div>
		
		<div class="bookmark-container">
			<nav id="bookmark">
				<h4>즐겨먹기</h4>
				<ul>
					<li>회덮밥</li>
					<li>김치볶음밥</li>
					<li>콩국수</li>
					<li>소고기 스테이크</li>
				</ul>
			</nav>
		</div>				
	</section>
	
	<!-- footer 영역 -->
	<footer id="footer"></footer>	
</body>
</html>