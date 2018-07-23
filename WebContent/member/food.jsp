<%@page import="com.nayo.web.entity.Recipe"%>
<%@page import="com.nayo.web.RecipeService"%>
<%@page import="com.nayo.web.entity.FoodCate"%>
<%@page import="java.util.List"%>
<%@page import="com.nayo.web.entity.Food"%>
<%@page import="com.nayo.web.member.FoodService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	FoodService fs = new FoodService();
	RecipeService rs = new RecipeService();

	List<FoodCate> list = fs.getFoodCateList();
	List<Recipe> rList = rs.getCookableRecipeList("woghks2045@gmail.com");
	
	List<Food> list1 = fs.getFoodList("woghks2045@gmail.com", 1);
	List<Food> list2 = fs.getFoodList("woghks2045@gmail.com", 2);
	List<Food> list3 = fs.getFoodList("woghks2045@gmail.com", 3);
	
	pageContext.setAttribute("rList", rList);
	pageContext.setAttribute("list1", list1);
	pageContext.setAttribute("list2", list2);
	pageContext.setAttribute("list3", list3);
	pageContext.setAttribute("list", list);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>나도 요리사 - 나요</title>

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
			<h1>서비스 영역</h1>
			<nav id="cookable-recipe">
				<h1 class="area-name">지금 바로 조리 가능한 레시피</h1>
				<ul>
					<c:forEach var="rc" items="${rList}">
						<li>${rc.title}</li>
					</c:forEach>
				</ul>
			</nav>

			<section id="food-cate">
				<h1>식재료 카테고리 영역</h1>
				<form>
					<c:forEach var="fc" items="${list}">
						<input type="checkbox" class="food-cate-${fc.id}" value="${fc.id}" />
						<label for="food-cate-${fc.id}">${fc.name}</label>
					</c:forEach>
				</form>
			</section>

			<section id="food-service">
				<h1>식재료 서비스 버튼</h1>
				<input type="button" value="선택 식재료를 이용한 레시피" /> <input
					type="button" value="선택 식재료 사용완료" /> <input type="button"
					value="선택 식재료 버리기" />
			</section>
			<section>
				<h1>보유 식재료 출력 영역</h1>
				<section class="food-container">
					<h1 class="area-name">냉장</h1>
					<form>
						<table>
								<c:forEach var="f" items="${list1}" varStatus="st">
									<c:if test="${st.index%3 == 0}">
										<tr>
									</c:if>
									<td>
										<ul>
											<li><img alt="" src="../images/ajax-loader.gif"></li>
											<li>${f.name}</li>
										</ul>
									</td>
									<c:if test="${st.index%3 == 2}">
										</tr>
									</c:if>
								</c:forEach>
						</table>
					</form>
					<input type="button" value="보유 식재료 추가" />
				</section>
				<section class="food-container">
					<h1 class="area-name">냉동</h1>
					<form>
						<table>
							<c:forEach var="f" items="${list2}" varStatus="st">
									<c:if test="${st.index%3 == 0}">
										<tr>
									</c:if>
									<td>
										<ul>
											<li><img alt="" src="../images/ajax-loader.gif"></li>
											<li>${f.name}</li>
										</ul>
									</td>
									<c:if test="${st.index%3 == 2}">
										</tr>
									</c:if>
								</c:forEach>
						</table>
					</form>
				</section>
				<section class="food-container">
					<h1 class="area-name">상온</h1>
					<form>
						<table>
							<c:forEach var="f" items="${list3}" varStatus="st">
									<c:if test="${st.index%3 == 0}">
										<tr>
									</c:if>
									<td>
										<ul>
											<li><img alt="" src="../images/ajax-loader.gif"></li>
											<li>${f.name}</li>
										</ul>
									</td>
									<c:if test="${st.index%3 == 2}">
										</tr>
									</c:if>
								</c:forEach>
						</table>
					</form>
					<input type="button" value="보유 식재료 추가" />
				</section>
			</section>
		</div>
	</section>

	<!-- footer영역 -->
	<jsp:include page="../inc/footer.jsp" />

</body>
</html>