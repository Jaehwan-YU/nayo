<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../../css/basic.css" type="text/css" rel="stylesheet" />
</head>
<body>

<!-- header영역 -->
	<jsp:include page="../../inc/header.jsp"/>

	<!-- visual영역 -->	
	<div class="content-container">
		<div id="visual">		
		</div>
	</div>
	
	<div>
		<ul>
			<li><a href="list.jsp">나의 레시피</a></li>
			<li><a href="../bookmark.jsp">즐겨먹기</a></li>
			<li><a href="../infocheck.jsp">내 정보</a></li>
			<li><a href="../../recipe/detail.jsp">레시피 1</a></li>
		</ul>
	</div>
	[마이페이지 (마이 레시피)]
	
<!-- footer영역 -->	
	<jsp:include page="../../inc/footer.jsp"/>
	
</body>
</html>