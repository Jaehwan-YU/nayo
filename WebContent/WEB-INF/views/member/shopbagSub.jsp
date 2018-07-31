
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

	<!-- <section id="main-food">
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
	</section> -->

	<section id='body'>
		
		<div id = "shopbag-container">
		<h1>재료명</h1>
			<nav id = "food-name">
				<h2>채소/과일</h2><br/>
					<ul>
												
						<li><a href=""><input type = "checkbox"/>상추<input type = "button" value = "x 이미지 추가할거"/></a></li>						
						<li><a href=""><input type = "checkbox"/>배추<input type = "button"/></a></li>					
						<li><a href=""><input type = "checkbox"/>마늘<input type = "button"/></a></li>				
						<li><a href=""><input type = "checkbox"/>사과<input type = "button"/></a></li>					
					</ul><br/>
					
				<h2>육류</h2><br/>
					<ul>
						<li><a href=""><input type = "checkbox"/>돼지고기 앞다리살<input type = "button"/></a></li>
						<li><a href=""><input type = "checkbox"/>돼지고기 구이용<input type = "button"/></a></li>
						<li><a href=""><input type = "checkbox"/>소고기 구이용<input type = "button"/></a></li>
						<li><a href=""><input type = "checkbox"/>소고기 국거리용<input type = "button"/></a></li>					
					</ul><br/>	
				
				<h2>수산물</h2><br/>
					<ul>
						<li><a href=""><input type = "checkbox"/>조개<input type = "button"/></a></li>
						<li><a href=""><input type = "checkbox"/>고등어<input type = "button"/></a></li>
						<li><a href=""><input type = "checkbox"/>옥돔<input type = "button"/></a></li>
						<li><a href=""><input type = "checkbox"/>갈치<input type = "button"/></a></li>					
					</ul><br/>	
					
				<h2>곡물/견과류</h2><br/>
					<ul>
						<li><a href=""><input type = "checkbox"/>땅콩<input type = "button"/></a></li>
						<li><a href=""><input type = "checkbox"/>호두<input type = "button"/></a></li>
						<li><a href=""><input type = "checkbox"/>잡곡<input type = "button"/></a></li>
						<li><a href=""><input type = "checkbox"/>아몬드<input type = "button"/></a></li>					
					</ul>		
			</nav>	
		
		</div>		
	</section>	

	<!-- footer영역 -->
	<jsp:include page="../inc/footer.jsp" />

</body>
</html>