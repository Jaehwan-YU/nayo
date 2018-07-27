
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

<link href="../css/shopbagSubStyle.css" type="text/css" rel="stylesheet" />

</head>
<body>

	<!-- header영역 -->
	<jsp:include page="../inc/header.jsp" />

	<!-- visual영역 -->
	<div class="content-container">
		<div id="visual"></div>
	</div>

	<section id="main-food">
		<div class="main-food-container">
			<h1>메인 식재료 목록</h1>
			<nav id="main-food-list">
				<ul>
					<li><a href="">인기</a></li>
					<li><a href="">채소/과일</a></li>
					<li><a href="">육류</a></li>
					<li><a href="">수산물</a></li>
					<li><a href="">곡물/견과류</a></li>
					<li><a href="">양념/소스</a></li>
					<li><a href="">가공 유제품</a></li>
					<li><a href="">기타</a></li>
				</ul>
			</nav>
		</div>
	</section>

	<section id='body'>
		
		
		
		
		

	<!-- footer영역 -->
	<jsp:include page="../inc/footer.jsp" />

</body>
</html>