<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>나도 요리사 - 나요</title>
<script type="text/javascript" src="${ctx}/js/recipeList.js"></script>
<link href="../css/recipeStyle.css" type="text/css" rel="stylesheet" />
</head>
<body>
	<span type="hidden">$</span>
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
			<section id="my-food-recipe">
				<h1>나의 냉장고 재료 조합 레시피</h1>
				<table>
					<tr>
					<%-- <c:forEach var="i" begin="1" end="10"> --%>
						<td>
							<ul>
								<li><a href="/nayo/login">지금 로그인 하시고 냉장고에 있는 재료로 조리 가능한 레시피를 확인해보세요!</a></li>
							</ul>
						</td>
					<%-- </c:forEach> --%>
					</tr>
				</table>
			</section>
			
			<section id="my-recipe">
				<h1>나만의  레시피</h1>
				<table>
					<tr>
					<%-- <c:forEach var="i" begin="1" end="10"> --%>
						<td>
							<ul>
								<li><a href="/nayo/login">어떤 레시피를 등록했을까요? 로그인 해서 확인해보세요.</a></li>
			
							</ul>
						</td>
					<%-- </c:forEach> --%>
					</tr>
				</table>
			</section>
			
			<section id="week">
				<h1>이주의 HOT 레시피</h1>
				<table>
					<tr>
					<%-- <c:forEach var="i" begin="1" end="10"> --%>
						<td>
							<ul>
								<li><img src="">이미지</li>
								<li>주별로 한입만 많은 레시피 출력</li>
							</ul>
						</td>
					<%-- </c:forEach> --%>
					</tr>
				</table>
			</section>
			
			<section id="recently">
				<h1>따끈따끈한 최근 음식 정보</h1>
				<table>
					<tr>
					<%-- <c:forEach var="i" begin="1" end="10"> --%>
						<td>
							<ul>
								<li><img src="">이미지</li>
								<li>최근 일주일 등록된 레시피 출력</li>
							</ul>
						</td>
					<%-- </c:forEach> --%>
					</tr>
				</table>
			</section>
			<a href="reg">새로운 레시피 등록</a>		
		</div>
	</section>
	

<!-- footer영역 -->	
	<jsp:include page="../inc/footer.jsp"/>

</body>
</html>