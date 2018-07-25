<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>나도 요리사 - 나요</title>
<link href="css/indexStyle.css" type="text/css" rel="stylesheet" />
</head>
<body>

<!-- header영역 -->
	<jsp:include page="inc/header.jsp"/>
	
	<!-- visual영역 -->	
	<div class="content-container">
		<div id="visual">		
		</div>
	</div>
	
<!-- body영역 -->
	<section id="body">
		<div class="content-container">
			<h1>홈페이지 내용 출력</h1>
			<section id="recommend">
				<h1>추천 레시피</h1>
				<table>
					<tr>
					<c:forEach var="r" items="${list}">
						<td>
							<ul>
								<li><img src="">1</li>
								<li>${r.title}</li>
							</ul>
						</td>
					</c:forEach>
					</tr>
				</table>
			</section>
			<section id="season">
				<h1>여름철 좋은 레시피</h1>
				<table>
					<tr>
					<c:forEach var="r" items="${list}">
						<td>
							<ul>
								<li><img src="">2</li>
								<li>${r.title}</li>
							</ul>
						</td>
					</c:forEach>
					</tr>
				</table>
			</section>
			<section id="repair">
				<h1>알아두면 좋은 손질법</h1>
					<table>
						<tr>
							<td>목록 출력</td>
						</tr>
					</table>
			</section>
		</div>
	</section>

	
	
<!-- footer영역 -->	
	<jsp:include page="inc/footer.jsp"/>
	
</body>
</html>