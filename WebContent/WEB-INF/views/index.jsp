<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>나도 요리사 - 나요</title>
<link href="css/indexStyle.css" type="text/css" rel="stylesheet" />
</head>
<body>

<!-- header영역 -->
	<jsp:include page="inc/header.jsp"/>
	
	<!-- visual영역 -->	
	<div class="content-container">
		<div id="visual">		
		</div>
	</div>
	
<!-- body영역 -->
	<section id="body">
		<div class="content-container">
			<h1>홈페이지 내용 출력</h1>
			<section id="recommend">
				<h1>추천 레시피</h1>
				<table>
				<c:forEach var="i" begin="1" end="5">
					<tr>
						<ul>
							<li><img src="">${i}</li>
							<li>메뉴명</li>
						</ul>
					</tr>
				</c:forEach>
				</table>
			</section>
			<section id="season">
				<h1>여름철 좋은 레시피</h1>
				<form>
					<table>
						<tr>
							<td>목록 출력</td>
						</tr>
					</table>
			</section>
			<section id="repair">
				<h1>알아두면 좋은 손질법</h1>
				<form>
					<table>
						<tr>
							<td>목록 출력</td>
						</tr>
					</table>
			</section>
		</div>
	</section>

	<!-- <section class="content-container">
		<section id="recommend">
			<h1>추천 레시피</h1>
		</section>
		<section id="season">
			<h1>여름철 좋은 레시피</h1>
		</section>
		<section id="repair">
			<h1>알아두면 좋은 손질법</h1>
		</section>
	</section> -->
	
<!-- footer영역 -->	
	<jsp:include page="inc/footer.jsp"/>
	
</body>
</html>