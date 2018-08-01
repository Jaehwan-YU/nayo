<%@page import="java.util.List"%>
<%@page import="com.nayo.web.entity.Food"%>
<%@page import="com.nayo.web.member.FoodService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7/jquery.min.js"></script>
<script
	src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"></script>
<script src="${ctx}/js/menu.js" type="text/javascript"></script>
<meta charset="UTF-8">
<title>나도 요리사 - 나요</title>

<link href="../css/menuStyle.css" type="text/css" rel="stylesheet" />

</head>
<body>

	<!-- header영역 -->
	<jsp:include page="../inc/header.jsp" />

	<!-- visual영역 -->
	<div class="content-container">
		<div id="visual"></div>
	</div>

	<section id='body'>
		<div class="menu-container">
			<section id="daily-menu">
				<table border="0">
					<tr>
						<td><input name="fromDt" type="text" id="fromDt" size="8"
							maxlength="8" value=""></td>
					</tr>
				</table>
				<table id="calendar">
					<thead>
						<tr>
							<td>일</td>
							<td>월</td>
							<td>화</td>
							<td>수</td>
							<td>목</td>
							<td>금</td>
							<td>토</td>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>일</td>
							<td>월</td>
							<td>화</td>
							<td>수</td>
							<td>목</td>
							<td>금</td>
							<td>토</td>
						</tr>
					</tbody>
				</table>
			</section>
		</div>

		<div class="cook-container">
			<nav id="cook">
				<h4>바로 조리 가능</h4>
				<ul>
					<li><img alt="" src="../images/ajax-loader.gif"><br>두부조림</li>
					<br>
					<li><img alt="" src="../images/ajax-loader.gif"><br>김치찌개</li>
					<br>
					<li><img alt="" src="../images/ajax-loader.gif"><br>어묵볶음</li>
					<br>
					<li><img alt="" src="../images/ajax-loader.gif"><br>김치볶음밥</li>
				</ul>
			</nav>
		</div>

		<div class="recommend-container">
			<nav id="recommend">
				<h4>이번주 추천</h4>
				<ul>
					<li><img alt="" src="../images/ajax-loader.gif"><br>닭볶음탕</li>
					<br>
					<li><img alt="" src="../images/ajax-loader.gif"><br>장어구이</li>
					<br>
					<li><img alt="" src="../images/ajax-loader.gif"><br>미역국</li>
					<br>
					<li><img alt="" src="../images/ajax-loader.gif"><br>순두부찌개</li>
				</ul>
			</nav>
		</div>

		<div class="bookmark-container">
			<nav id="bookmark">
				<h4>즐겨먹기</h4>
				<ul>
					<li><img alt="" src="../images/ajax-loader.gif"><br>회덮밥</li>
					<br>
					<li><img alt="" src="../images/ajax-loader.gif"><br>김치볶음밥</li>
					<br>
					<li><img alt="" src="../images/ajax-loader.gif"><br>콩국수</li>
					<br>
					<li><img alt="" src="../images/ajax-loader.gif"><br>소고기
						스테이크</li>
				</ul>
			</nav>
		</div>
	</section>

	<!-- footer영역 -->
	<jsp:include page="../inc/footer.jsp" />

</body>
</html>