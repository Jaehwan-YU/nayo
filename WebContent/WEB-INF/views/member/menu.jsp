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

						<select class="sel-year">
						</select>년
						<select class="sel-month">
							<option>월</option>
						</select>월

				</div>
				<h1>${year}년 ${month}월</h1>
				<form method="post">
				<table id="menu-table">
					<thead>
						<tr>
							<th>일</th>
							<td>아침</td>
							<td>점심</td>
							<td>저녁</td>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="d" begin="1" end="${last}">	
						<c:forEach var="m" items="${mlist}">
							<c:set var="md" value="${fn:split(m.menuDate,'-')}"/>
							<tr>
								<th>${d}</th>
								<td value="${d}" name="1" ondrop="drop(event)" ondragover="dragover(event)"><c:if test="${md[2]==d}"><c:if test="${m.mill==1}">${m.title}</c:if></c:if></td>
								<td value="${d}" name="2" ondrop="drop(event)" ondragover="dragover(event)"><c:if test="${md[2]==d}"><c:if test="${m.mill==2}">${m.title}</c:if></c:if></td>
								<td value="${d}" name="3" ondrop="drop(event)" ondragover="dragover(event)"><c:if test="${md[2]==d}"><c:if test="${m.mill==3}">${m.title}</c:if></c:if></td>
							</tr>
						</c:forEach>
						</c:forEach>
					</tbody>
					<%-- <tbody>
					<c:if test="${mill}==1"></c:if>
					<c:forEach var="m" items="${mlist}">
						<tr>
							<th>${m.menuDate}</th>
							<td>${m.title}</td>
						</tr>
					</c:forEach>
					</tbody> --%>
				</table>
			<input type="submit" value="저장" />
			</form>
			</section>
		</div>

		<div class="menu-container">
				<h4>바로 조리 가능</h4>
				<ul>
				<c:forEach var="r" items="${rlist}">
					<li><img src="${r.mainImg}"></li>
					<li draggable="true" ondragstart="drag(event)" data-name="${r.id}">${r.title}</li>
				</c:forEach>
				</ul>
		</div>

		<div class="menu-container">
				<h4>이번주 추천</h4>
				<ul>
				<c:forEach var="s" items="${slist}">
					<li><img src="${s.mainImg}">}</li>
					<li draggable="true" ondragstart="drag(event)" data-name="${s.id}">${s.title}</li>
				</c:forEach>
				</ul>
		</div>

		<div class="menu-container">
				<h4>즐겨먹기</h4>
				<ul>
				<c:forEach var="b" items="${blist}">
					<li><img src="${b.mainImg}"></li>
					<li draggable="true" ondragstart="drag(event)" data-name="${b.id}">${b.title}</li>
				</c:forEach>
				</ul>
		</div>
	</section>

	<!-- footer영역 -->
	<jsp:include page="../inc/footer.jsp" />

</body>
</html>