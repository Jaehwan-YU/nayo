<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String ctx = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>나도 요리사 - 나요</title>
<script type="text/javascript" src="<%= ctx %>/js/faqList.js"></script>
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
			<main class="main">
				<h1>FAQ</h1>
				<div>
					<h2>제목1</h2>
					<p style="display:none">내용</p>
					<h2>제목2</h2>
					<p style="display:none">내용</p>
					<h2>제목3</h2>
					<p style="display:none">내용</p>
				</div>
			</main>
		</div>
	</section>	

<!-- footer영역 -->	
	<jsp:include page="../inc/footer.jsp"/>

</body>
</html>