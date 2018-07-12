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

<link href="../css/menuStyle.css" type="text/css" rel="stylesheet" />

</head>
<body>

<!-- header영역 -->
	<jsp:include page="../inc/header.jsp"/>
	
	<!-- visual영역 -->	
	<div class="content-container">
		<div id="visual">		
		</div>
	</div>
	
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
	
<!-- footer영역 -->	
	<jsp:include page="../inc/footer.jsp"/>
	
</body>
</html>