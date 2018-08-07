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
<script src="${ctx}/js/food.js" type="text/javascript"></script>
<link href="../css/foodStyle.css" type="text/css" rel="stylesheet" />
</head>
<body>

	<!-- header영역 -->
	<jsp:include page="../inc/header.jsp" />

	<!-- visual영역 -->
	<div class="content-container">
		<div id="visual"></div>
	</div>

	<!-- 메인영역 -->

	<section id="body" class="clearfix">
		<div class="content-container">
			<h1 class="hidden-head">서비스 영역</h1>
			<nav id="cookable-recipe">
				<h1 class="area-name">지금 바로 조리 가능한 레시피</h1>
				<ul>
					<c:forEach var="rc" items="${rList}">
						<li>${rc.title}</li>
					</c:forEach>
				</ul>
			</nav>

			<section id="food-cate">
				<h1 class="hidden-head">식재료 카테고리 영역</h1>
				<form>
					<c:forEach var="fc" items="${list}">
						<input type="checkbox" class="food-cate-${fc.id}" value="${fc.id}" />
						<label for="food-cate-${fc.id}">${fc.name}</label>
					</c:forEach>
				</form>
			</section>

			<section id="food-service">
				<h1 class="hidden-head">식재료 서비스 버튼</h1>
				<input type="button" value="식재료 다중선택"/>
				<input type="button" value="선택 식재료를 이용한 레시피" /> <input
					type="button" value="선택 식재료 사용완료" /> <input type="button"
					value="선택 식재료 버리기" />
			</section>
			<section class="food-show-area">
				<h1 class="hidden-head">보유 식재료 출력 영역</h1>
				<form>
				<section class="food-container">
					<h1 class="area-name">냉장</h1>
					<table>
						<c:forEach var="f" items="${list1}" varStatus="st">
							<c:if test="${st.index%3 == 0}">
								<tr>
							</c:if>
							<td>
								<ul>
									<li class="rest-life">${f.restLife}</li>
									<li><img alt="" src="../images/ajax-loader.gif"></li>
									<li>${f.name}</li>
									<li><input type="checkbox" class="food-check" value="${f.id}" /></li>
								</ul>
							</td>
							<c:if test="${st.index%3 == 2}">
								</tr>
							</c:if>
						</c:forEach>
					</table>
				</section>
				<section class="food-container">
					<h1 class="area-name">냉동</h1>
					<table>
						<c:forEach var="f" items="${list2}" varStatus="st">
							<c:if test="${st.index%3 == 0}">
								<tr>
							</c:if>
							<td>
								<ul>
									<li class="rest-life">${f.restLife}</li>
									<li><img alt="" src="../images/ajax-loader.gif"></li>
									<li>${f.name}</li>
									<li><input type="checkbox" class="food-check" value="${f.id}" /></li>
								</ul>
							</td>
							<c:if test="${st.index%3 == 2}">
								</tr>
							</c:if>
						</c:forEach>
					</table>
				</section>
				<section class="food-container">
					<h1 class="area-name">상온</h1>
					<table>
						<c:forEach var="f" items="${list3}" varStatus="st">
							<c:if test="${st.index%3 == 0}">
								<tr>
							</c:if>
							<td>
								<ul>
									<li class="rest-life">${f.restLife}</li>
									<li><img alt="" src="../images/ajax-loader.gif"></li>
									<li>${f.name}</li>
									<li><input type="checkbox" class="food-check" value="${f.id}"/></li>
								</ul>
							</td>
							<c:if test="${st.index%3 == 2}">
								</tr>
							</c:if>
						</c:forEach>
					</table>
				</section>
			</form>
			</section>
		</div>
	</section>

	<!-- footer영역 -->
	<jsp:include page="../inc/footer.jsp" />

</body>
</html>