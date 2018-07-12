<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nayo!</title>

<link href="../css/bookmarkStyle.css" type="text/css" rel="stylesheet" />

</head>
<body>

<!-- header영역 -->
	<jsp:include page="../inc/header.jsp"/>
	
	
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
							<li><a href="recipe/list.jsp">나의 레시피</a></li>
							<li><a href="bookmark.jsp">즐겨먹기</a></li>
							<li><a href="infocheck.jsp">내 정보</a></li>
						</ul>
					</div>
		</aside>
		<!-- main영역 -->
			<main id="main">
					<h1>즐겨먹기 목록</h1>
						<h2>즐겨먹기</h2>
							<ul>
								<li><a href="../recipe/detail.jsp">레시피 1</a></li>
								<li><a href="../recipe/detail.jsp">레시피 2</a></li>
								<li><a href="../recipe/detail.jsp">레시피 3</a></li>
							</ul>
					<div>이전</div>
					<div>
						<h1>페이저</h1>
								<ul>
									<li>1</li>
									<li>2</li>
								</ul>
					</div>
					<div>다음</div>
			</main>
	</div>
	</section>

<!-- footer영역 -->	
	<jsp:include page="../inc/footer.jsp"/>
	
</body>
</html>