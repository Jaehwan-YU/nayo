
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

<link href="../css/shopbagMainStyle.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src = "../js/shopbagMain.js"></script>
</head>
<body>

	<!-- header영역 -->
	<jsp:include page="../inc/header.jsp" />

	<!-- visual영역 -->
	<div class="content-container">
		<div id="visual"></div>
	</div>

	<section id="body" style = "cursor:pointer">		
		<div id = "shopbag-container">
		
			
			<li>장바구니가 비어 있습니다. 빈 공간을 클릭하여 식재료를 등록해주세요.</li>	
		
		
		</div>		
	</section>	

	<!-- footer영역 -->
	<jsp:include page="../inc/footer.jsp" />

</body>
</html>