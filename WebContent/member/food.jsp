<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>나도 요리사 - 나요</title>

<link href="../css/style.css" type="text/css" rel="stylesheet" />

</head>


<body>
	<h1>나요</h1>
	<!-- 헤더영역 -->
	<header id="header">
		<section class="content-container">
			<h1>상단 메뉴</h1>
			<nav id="logo">
				<h1>로고</h1>
				<a href="../index.jsp">home</a>
			</nav>

			<nav id="finder">
				<h1>검색 창</h1>
				<form>
					<input type="text" placeholder="재료명, 레시피명 검색" /> <input
						type="submit" value="검색" />
				</form>
			</nav>

			<nav id="user-menu">
				<h1>고객 메뉴</h1>
				<ul>
					<li><a href="">로그아웃</a></li>
					<li><a href="../notice/list.jsp">고객센터</a></li>
					<li><a href="recipe/list.jsp">마이페이지</a></li>
				</ul>
			</nav>
		</section>
	</header>
	<div id="visual"></div>
	<!--메인메뉴 영역-->
	<section id="main-menu">
		<div class="content-container">
			<h1>메인 메뉴</h1>
			<nav id="main-menu-list">
				<h1>메뉴 목록</h1>
				<ul>
					<li><a href="food.jsp">나의 식재료</a></li>
					<li><a href="../recipe/list.jsp">레시피</a></li>
					<li><a href="shopbag.jsp">장바구니</a></li>
					<li><a href="menu.jsp">나의 식단</a></li>
				</ul>
			</nav>
		</div>
	</section>
	
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
					<input type="checkbox" id="food-cate-1" value="채소/과일"/>
					<label for="food-cate-1">채소/과일</label>
					<input type="checkbox" id="food-cate-2" value="육류"/>
					<label for="food-cate-2">육류</label>
					<input type="checkbox" id="food-cate-3" value="수산물"/>
					<label for="food-cate-3">수산물</label>
					<input type="checkbox" id="food-cate-4" value="곡물/견과류"/>
					<label for="food-cate-4">곡물/견과류</label>
					<input type="checkbox" id="food-cate-5" value="양념소스"/>
					<label for="food-cate-5">양념소스</label>
					<input type="checkbox" id="food-cate-6" value="가공식품"/>
					<label for="food-cate-6">가공식품</label>
					<input type="checkbox" id="food-cate-7" value="유제품"/>
					<label for="food-cate-7">유제품</label>
					<input type="checkbox" id="food-cate-8" value="기타"/>
					<label for="food-cate-8">기타</label>
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
					<ul>
						<li>삼겹살</li>
						<li>닭고기 볶음용</li>
						<li>콩나물</li>
						<li>대파</li>
						<li>양파</li>
						<li>마늘</li>
						<li>배추김치</li>
					</ul>
					<input type="button" value="보유 식재료 추가" />
				</section>
				<section class="food-container">
					<h1 class="area-name">냉동</h1>
					<ul>
						<li>등록된 식재료가 없습니다. <br /> 식재료를 등록해주세요.
						</li>
					</ul>
				</section>
				<section class="food-container">
					<h1 class="area-name">상온</h1>
					<ul>
						<li>감자</li>
						<li>소금</li>
						<li>굴소스</li>
						<li>설탕</li>
						<li>간장</li>
					</ul>
					<input type="button" value="보유 식재료 추가" />
				</section>
			</section>
		</div>
	</section>

	<footer id="footer">
		<p>준비중</p>
	</footer>
</body>

</html>