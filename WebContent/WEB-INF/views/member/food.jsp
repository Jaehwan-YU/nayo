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
						<input type="checkbox" id="food-cate-${fc.id}" value="${fc.id}" />
						<label for="food-cate-${fc.id}">${fc.name}</label>
					</c:forEach>
				</form>
			</section>

			<section id="food-service">
				<h1 class="hidden-head">식재료 서비스 버튼</h1>
				<input type="button" value="식재료 다중선택" class="multiple-button" /> <input
					type="submit" value="선택 식재료를 이용한 레시피" class="recipe-button" /> <input
					type="submit" value="선택 식재료 사용완료" class="use-button" /> <input
					type="submit" value="선택 식재료 버리기" class="del-button" />
			</section>
			<div class="black-overlay"></div>
			<div class="food-overlay">
				<section class="food-add-section">
					<img src="../images/overlay_x_button.png"/>
					<h1>식재료 추가</h1>
					<div>
						<label for="food-name-input">식재료명 입력</label> <input
							id="food-name-input" type="text" placeholder="식재료명을 입력하세요." /> <input
							type="button" value="추가" />
					</div>
					<form action="/nayo/addfood" method="post">
						<ul>
						</ul>
						<input type="submit" value="저장">
					</form>
				</section>
				<section class="food-show-section">
					<h1>식재료 정보 확인</h1>
				</section>
				<section class="food-set-section">
					<h1>식재료 정보 수정</h1>
				</section>
			</div>
			<section id="food-show-area">
				<h1 class="hidden-head">보유 식재료 출력 영역</h1>
				<form method="post">
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
										<li><input type="checkbox" name="food-check"
											value="${f.id}" /></li>
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
										<li><input type="checkbox" name="food-check"
											value="${f.id}" /></li>
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
										<li><input type="checkbox" name="food-check"
											value="${f.id}" /></li>
									</ul>
								</td>
								<c:if test="${st.index%3 == 2}">
									</tr>
								</c:if>
							</c:forEach>
						</table>
					</section>
				</form>
				<input type="button" class="food-overlay-block" value="새로운 식재료 등록" />
			</section>
		</div>
	</section>

	<!-- footer영역 -->
	<jsp:include page="../inc/footer.jsp" />

</body>
</html>