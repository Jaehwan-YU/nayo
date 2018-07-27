<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>나도 요리사 - 나요</title>
<link href="../css/infoCheckStyle.css" type="text/css" rel="stylesheet" />
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
							<li><a href="bookmark">즐겨먹기</a></li>
							<li><a href="recipe/list">나의 레시피</a></li>
							<li><a href="infocheck">내 정보</a></li>
						</ul>
					</div>
		</aside>
		
		
	<!-- main영역 -->
			<main id="main">
				<h1>비밀번호 재확인</h1>
					<p>본인확인을 위해 한번 더 비밀번호를 입력해주세요.<br /> 비밀번호는 타인에게 노출되지 않도록 주의해 주세요</p>
					<ul>
						<li>아이디 : <Input type="text"></li><br> 
						<li>비밀번호 재확인 : <Input type="text"></li>
					</ul>
			</main>
	</div>
	</section>
	
	
<!-- footer영역 -->	
	<jsp:include page="../inc/footer.jsp"/>
		
</body>
</html>