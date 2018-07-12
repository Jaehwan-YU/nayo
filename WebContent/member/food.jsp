<%@page import="java.util.List"%>
<%@page import="com.nayo.web.entity.Food"%>
<%@page import="com.nayo.web.member.FoodService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	FoodService fs = new FoodService();

	List<Food> list1 = fs.getFoodList("woghks2045@gmail.com", 1);
	List<Food> list2 = fs.getFoodList("woghks2045@gmail.com", 2);
	List<Food> list3 = fs.getFoodList("woghks2045@gmail.com", 3);
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
	<jsp:include page="../inc/header.jsp"/>
	
	<!-- visual영역 -->	
	<div class="content-container">
		<div id="visual">		
		</div>
	</div>

	<!-- 메인영역 -->

	<section id="body" class="clearfix">
		<div class="content-container">
			<h1>서비스 영역</h1>
			<nav id="cookable-recipe">
				<h1 class="area-name">지금 바로 조리 가능한 레시피</h1>
				<ul>
					<li>콩나물국</li>
					<li>삼겹살 볶음밥</li>
					<li>닭 김치찜</li>
				</ul>
			</nav>

			<section id="food-cate">
				<h1>식재료 카테고리 영역</h1>
				<h2>목록</h2>
				<form>
					<input type="checkbox" id="food-cate-1" value="채소/과일" /> <label
						for="food-cate-1">채소/과일</label> <input type="checkbox"
						id="food-cate-2" value="육류" /> <label for="food-cate-2">육류</label>
					<input type="checkbox" id="food-cate-3" value="수산물" /> <label
						for="food-cate-3">수산물</label> <input type="checkbox"
						id="food-cate-4" value="곡물/견과류" /> <label for="food-cate-4">곡물/견과류</label>
					<input type="checkbox" id="food-cate-5" value="양념소스" /> <label
						for="food-cate-5">양념소스</label> <input type="checkbox"
						id="food-cate-6" value="가공식품" /> <label for="food-cate-6">가공식품</label>
					<input type="checkbox" id="food-cate-7" value="유제품" /> <label
						for="food-cate-7">유제품</label> <input type="checkbox"
						id="food-cate-8" value="기타" /> <label for="food-cate-8">기타</label>
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
							<%
								int count = 0;
								for (Food f : list1) {
									if (count == 0)
							%><tr>
								<%
									;
								%>
								<td>
									<ul>
										<li><img alt="" src="../images/ajax-loader.gif"></li>
										<li><%=f.getName()%></li>
									</ul>
								</td>
								<%
									count++;
										if (count == 3) {
								%>
							</tr>
							<%
								;
										count = 0;
									}
							%>
							<%
								}
							%>
						</table>
					</form>
					<input type="button" value="보유 식재료 추가" />
				</section>
				<section class="food-container">
					<h1 class="area-name">냉동</h1>
					<form>
						<table>
							<%
								count = 0;
								for (Food f : list2) {
									if (count == 0)
							%><tr>
								<%
									;
								%>
								<td>
									<ul>
										<li><img alt="" src="../images/ajax-loader.gif"></li>
										<li><%=f.getName()%></li>
									</ul>
								</td>
								<%
									count++;
										if (count == 3) {
								%>
							</tr>
							<%
								;
										count = 0;
									}
							%>
							<%
								}
							%>
						</table>
					</form>
				</section>
				<section class="food-container">
					<h1 class="area-name">상온</h1>
					<form>
						<table>
							<%
								count = 0;
								for (Food f : list3) {
									if (count == 0)
							%><tr>
								<%
									;
								%>
								<td>
									<ul>
										<li><img alt="" src="../images/ajax-loader.gif"></li>
										<li><%=f.getName()%></li>
									</ul>
								</td>
								<%
									count++;
										if (count == 3) {
								%>
							</tr>
							<%
								;
										count = 0;
									}
							%>
							<%
								}
							%>
						</table>
					</form>
					<input type="button" value="보유 식재료 추가" />
				</section>
			</section>
		</div>
	</section>

<!-- footer영역 -->	
	<jsp:include page="../inc/footer.jsp"/>
	
</body>
</html>