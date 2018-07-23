<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nayo!</title>
<link href="../css/basic.css" type="text/css" rel="stylesheet" />
</head>
<body>

<!-- header영역 -->
	<jsp:include page="../inc/header.jsp"/>

	<!-- visual영역 -->	
	<div class="content-container">
		<div id="visual">		
		</div>
	</div>
	
	<div>
		<h3>마이페이지</h3>
		<ul>
			<li><a href="recipe/list">나의 레시피</a></li>
			<li><a href="bookmark">즐겨먹기</a></li>
			<li><a href="infocheck">내 정보</a></li>
		</ul>
	</div>
	<div>
		<h3>비밀번호 재확인</h3>
		<p>
			본인확인을 위해 한번 더 비밀번호를 입력해주세요.<br /> 비밀번호는 타인에게 노출되지 않도록 주의해 주세요
		</p>
		<hr />
		<ol>
		<ul>
		<li>아이디 : <Input type="text"></li><br> 
		<li>비밀번호 재확인 : <Input type="text"></li><br>
		</ol>
	</div>
	
<!-- footer영역 -->	
	<jsp:include page="../inc/footer.jsp"/>
		
</body>
</html>