<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<link href="${ctx}/css/recipeDetailStyle.css" type="text/css"
	rel="stylesheet" />
<script src="${ctx}/js/recipeDetail.js" type="text/javascript"></script>
<title>나도 요리사 - 나요</title>
<meta charset="UTF-8">
</head>
<body>

	<!-- header영역 -->
	<jsp:include page="../inc/header.jsp" />

	<!-- visual영역 -->
	<div class="content-container">
		<div id="visual"></div>
	</div>

	<!-- body영역 -->
	<section id="body">
		<div class="content-container">
			<section id="main">
				<h1>레시피 디테일 페이지</h1>
				<section id="recipe-info">
					<table>
						<tr>
							<th>요리명</th>
							<td colspan="3">${recipe.title}</td>
						</tr>
						<tr>
							<th>작성자</th>
							<td>${recipe.regEmail}</td>
							<th>조회수</th>
							<td></td>
						</tr>
						<tr>
							<th>한줄 설명</th>
							<td colspan="3">${recipe.simpleIntro}</td>
						</tr>
						<tr>
							<th>메인 사진</th>
							<td colspan="3"><img src="${recipe.mainImg}" /></td>
						</tr>
						<tr>
							<th>요리 주제</th>
							<td colspan="3">
								<ul style="display: flex;">
									<c:if test="${recipe.national != null}">
										<li>${recipe.national}</li>
									</c:if>
									<c:if test="${recipe.situation != null}">
										<li>${recipe.situation}</li>
									</c:if>
									<c:if test="${recipe.recipeType != null}">
										<li>${recipe.recipeType}</li>
									</c:if>
								</ul>
							</td>
						</tr>
						<c:forEach var="m" items="${mainIng}" varStatus="st">
							<c:if test="${st.index == 0}">
								<tr class="main-ing">
									<th id="main-ing-th" rowspan="">주재료</th>
							</c:if>
							<c:if test="${st.index != 0}">
								<tr class="main-ing">
							</c:if>
							<td>${m.name}</td>
							<td>${m.quantity}</td>
							<td><input type="button" /></td>
							</tr>
						</c:forEach>
						<c:forEach var="s" items="${subIng}" varStatus="st">
							<c:if test="${st.index == 0}">
								<tr class="sub-ing">
									<th id="sub-ing-th" rowspan="">부재료</th>
							</c:if>
							<c:if test="${st.index != 0}">
								<tr class="sub-ing">
							</c:if>
							<td>${s.name}</td>
							<td>${s.quantity}</td>
							<td><input type="button" /></td>
							</tr>
						</c:forEach>
					</table>

					<section class="process">
						<h1>조리과정</h1>
						<table class="process-detail">
							<c:forEach var="p" items="${process}">
								<tr>
									<th>${p.processNumber}</th>
									<td>${p.content}</td>
									<td><img src="${p.img}" /></td>
								</tr>
							</c:forEach>
						</table>
					</section>
				</section>
				<section id="reply"></section>
			</section>
		</div>
	</section>

	<!-- footer영역 -->
	<jsp:include page="../inc/footer.jsp" />

</body>
</html>