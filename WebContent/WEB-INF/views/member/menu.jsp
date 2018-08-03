<%@page import="java.util.List"%>
<%@page import="com.nayo.web.entity.Food"%>
<%@page import="com.nayo.web.member.FoodService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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

	<section id="body">
		<div class="main-container">
			<section id="daily-menu">
				<div class="select-monthly">
					<div class ="monthly-head">
						<select class="select-type" name="sel-year">
							<option value="2018">년도</option>
						</select>년
						<select class="select-type" name="sel-month">
							<option value="01">월</option>
						</select>월
					</div>
				</div>
				<table id="table">
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
							<td><div></div></td>
							<td><div></div></td>
							<td><div></div></td>
							<td><div></div></td>
							<td><div></div></td>
							<td><div></div></td>
							<td><div></div></td>	
						</tr>
						<tr>
							<td><div></div></td>
							<td><div></div></td>
							<td><div></div></td>
							<td><div></div></td>
							<td><div></div></td>
							<td><div></div></td>
							<td><div></div></td>	
						</tr>
						<tr>
							<td><div></div></td>
							<td><div></div></td>
							<td><div></div></td>
							<td><div></div></td>
							<td><div></div></td>
							<td><div></div></td>
							<td><div></div></td>	
						</tr>
						<tr>
							<td><div></div></td>
							<td><div></div></td>
							<td><div></div></td>
							<td><div></div></td>
							<td><div></div></td>
							<td><div></div></td>
							<td><div></div></td>	
						</tr>
						<tr>
							<td><div></div></td>
							<td><div></div></td>
							<td><div></div></td>
							<td><div></div></td>
							<td><div></div></td>
							<td><div></div></td>
							<td><div></div></td>	
						</tr>
					</tbody>
				</table>
				<!-- <table>
					<tr>
						<td><input name="fromDt" type="text" id="fromDt" size="8"
							maxlength="8" value=""></td>
					</tr>
				</table>
				<table id="calendar">
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
				</table> -->
			</section>
			<input type="submit" value="저장" />
		</div>

		<div class="menu-container">
				<h4>바로 조리 가능</h4>
				<ul>
				<c:forEach var="r" items="${rlist}">
					<li><img src="${r.mainImg}"></li>
					<li>${r.title}</li>
				</c:forEach>
				</ul>
		</div>

		<div class="menu-container">
				<h4>이번주 추천</h4>
				<ul>
				<c:forEach var="s" items="${slist}">
					<li><img src="${s.mainImg}">}</li>
					<li>${s.title}</li>
				</c:forEach>
				</ul>
		</div>

		<div class="menu-container">
				<h4>즐겨먹기</h4>
				<ul draggable="true">
				<c:forEach var="b" items="${blist}">
					<li><img src="${b.mainImg}"></li>
					<li>${b.title}</li>
				</c:forEach>
				</ul>
		</div>
	</section>

	<!-- footer영역 -->
	<jsp:include page="../inc/footer.jsp" />

</body>
</html>