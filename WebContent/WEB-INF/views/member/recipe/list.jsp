<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>나도 요리사 - 나요</title>
<link href="${ctx}/css/myRecipeStyle.css" type="text/css" rel="stylesheet" />
</head>
<body>

<!-- header영역 -->
	<jsp:include page="../../inc/header.jsp"/>

	<!-- visual영역 -->	
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
							<li><a href="../bookmark">즐겨먹기</a></li>
							<li><a href="list">나의 레시피</a></li>
							<li><a href="../infocheck">내 정보</a></li>
						</ul>
					</div>
		</aside>
		
		<!-- main영역 -->
			<main id="main">
					<h1>나의 레시피 목록</h1>
						<h2>나의 레시피</h2>
						<c:forEach var="r" items="${list}">
							<ul>
								<li><a href="../recipe/detail">${r.title}</a></li>
							</ul>
						</c:forEach>

			</main>
	</div>
	</section>
	
<!-- footer영역 -->	
	<jsp:include page="../../inc/footer.jsp"/>
	
</body>
</html>