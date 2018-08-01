
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>나도 요리사 - 나요</title>

<link href="../css/shopbagStyle.css" type="text/css" rel="stylesheet" />

</head>
<body>

	<!-- header영역 -->
	<jsp:include page="../inc/header.jsp" />

	<!-- visual영역 -->
	<div class="content-container">
		<div id="visual"></div>
	</div>

	<div class="content-container">
		<section id="food-cate">
			<h1>식재료 카테고리 영역</h1>
			<form>
				<c:forEach var="fc" items="${fclist}">
					<input type="checkbox" class="food-cate-${fc.id}" value="${fc.id}" />
					<label for="food-cate-${fc.id}">${fc.name}</label>
				</c:forEach>
			</form>
		</section>
	
		<section id="body">
			<h1>메인 식재료 이름</h1>
			<section class="table" class="content-container">
				<table id="table-list">
					<tr>
						<td>채소/과일</td>
					</tr>
					<tr>
						<td>
							<ul>
							<c:forEach var="li" items="${list1}">
								<li>${li.name}</li>
							</c:forEach>
							</ul>
						</td>
					</tr>
				</table>
				<table id="table-list">
					<tr>
						<td>육류</td>
					</tr>
					<tr>
						<td>
							<ul>
							<c:forEach var="li" items="${list2}">
								<li>${li.name}</li>
							</c:forEach>
							</ul>
						</td>
					</tr>
				</table>
				<table id="table-list">	
					<tr>
						<td>수산물</td>
					</tr>
					<tr>
						<td>
							<ul>
							<c:forEach var="li" items="${list3}">
								<li>${li.name}</li>
							</c:forEach>
							</ul>
						</td>
					</tr>
				</table>
				<table id="table-list">
					<tr>
						<td>곡물</td>
					</tr>
					<tr>
						<td>
							<ul>
							<c:forEach var="li" items="${list4}">
								<li>${li.name}</li>
							</c:forEach>
							</ul>
						</td>
					</tr>
				</table>
				<table id="table-list">
					<tr>
						<td>양념/소스</td>
					</tr>
					<tr>
						<td>
							<ul>
							<c:forEach var="li" items="${list5}">
								<li>${li.name}</li>
							</c:forEach>
							</ul>
						</td>
					</tr>
				</table>
				<table id="table-list">
					<tr>
						<td>가공식품</td>
					</tr>
					<tr>
						<td>
							<ul>
							<c:forEach var="li" items="${list6}">
								<li>${li.name}</li>
							</c:forEach>
							</ul>
						</td>
					</tr>
				</table>
				<table id="table-list">
					<tr>
						<td>유제품</td>
					</tr>
					<tr>
						<td>
							<ul>
							<c:forEach var="li" items="${list7}">
								<li>${li.name}</li>
							</c:forEach>
							</ul>
						</td>
					</tr>
				</table>
				<table id="table-list">
					<tr>
						<td>기타</td>
					</tr>
					<tr>
						<td>
							<ul>
							<c:forEach var="li" items="${list8}">
								<li>${li.name}</li>
							</c:forEach>
							</ul>
						</td>
					</tr>
				</table>
			</section>
		</section>
	</div>

	<!-- footer영역 -->
	<jsp:include page="../inc/footer.jsp" />

</body>
</html>