
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

<link href="../css/shopbagStyle.css" type="text/css" rel="stylesheet" />

</head>
<body>

	<!-- header영역 -->
	<jsp:include page="../inc/header.jsp" />

	<!-- visual영역 -->
	<div class="content-container">
		<div id="visual"></div>
	</div>

	<section id="main-food">
		<div class="main-food-container">
			<h1>메인 식재료 목록</h1>
			<nav id="main-food-list">
				<ul>
					<li><a href="">인기</a></li>
					<li><a href="">채소/과일</a></li>
					<li><a href="">육류</a></li>
					<li><a href="">수산물</a></li>
					<li><a href="">곡물/견과류</a></li>
					<li><a href="">양념/소스</a></li>
					<li><a href="">가공 유제품</a></li>
					<li><a href="">기타</a></li>
				</ul>
			</nav>
		</div>
	</section>

	<section id='body'>
		<h1>메인 식재료 이름</h1>


		<div class="shopbag-container">
			<h2>채소/과일</h2>
			<nav class="vegetable-food">
				<form>
					<table>
						<c:forEach var="f" items="${list}" varStatus="st">
							<c:if test="${st.index%6 == 0}">
								<tr>
							</c:if>
							<td>
								<ul>
									<li><img alt="" src="../images/ajax-loader.gif"></li>
									<li>${f.name}</li>
								</ul>
							</td>
							<c:if test="${st.index%6 == 5}">
								</tr>
							</c:if>
						</c:forEach>
					</table>
				</form>

				<section>
					<input id = "veg_button" type="button" value="채소/과일 인기재료 더보기" />
					
				</section>
				
				
			</nav>

			<h2>육류</h2>
			<nav class="meat-food"">
				
					<section>
						<input type="button" value="육류 인기재료 더보기" />
					</section>
				
			</nav>


			<h2>수산물</h2>
			<nav class="fish-food">
				

					<section>
						<input type="button" value="수산물 인기재료 더보기" />
					</section>
				</ul>
			</nav>

			<h2>곡물/견과류</h2>
			<nav class="cereal-food">
				
					<section>
						<input type="button" value="곡물/견과류 인기재료 더보기" />
					</section>

				
			</nav>

			<h2>양념/소스</h2>
			<nav class="sauce-food">
				
					<section>
						<input type="button" value="양념/소스 인기재료 더보기" />
					</section>

				
			</nav>

			<h2>가공/유제품</h2>
			<nav class="manufacture-food">
				
					<section>
						<input type="button" value="가공/유제품 인기재료 더보기" />
					</section>

				
			</nav>

			<h2 class="etc-food">기타</h2>

		</div>
	</section>

	<!-- footer영역 -->
	<jsp:include page="../inc/footer.jsp" />

</body>
</html>