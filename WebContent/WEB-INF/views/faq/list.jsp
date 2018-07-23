<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link href="../css/faqStyle.css" type="text/css" rel="stylesheet" />
</head>
<body>

<!-- header영역 -->
	<jsp:include page="../inc/header.jsp"/>	

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
							<li><a href="../notice/list">공지사항</a>
							<li><a href="faq/list">FAQ</a>
						</ul>
					</div>
			</aside>
			<!-- main영역 -->
			<main id="main">
				<h1>FAQ 목록</h1>
					<h2>FAQ</h2>
			</main>
		</div>
	</section>	

<!-- footer영역 -->	
	<jsp:include page="../inc/footer.jsp"/>

</body>
</html>