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
	<!-- 헤더영역 -->
	<header id="header">
		<div class="content-container">
			<section>
				<h1>나요</h1>
				<h2>상단 메뉴</h2>
				<nav>
					<h1>로고</h1>
					<a href="../index.html">home</a>
				</nav>

				<div>
					<h1>검색 창</h1>
					<form>
						<fieldset>
							<legend> 전체 검색 창 </legend>
							<input type="text" placeholder="재료명, 레시피명 검색" /> <input
								type="button" value="검색" />
						</fieldset>
					</form>
				</div>

				<nav>
					<h1>고객 메뉴</h1>
					<ul>
						<li class="first">로그아웃</li>
						<li><a href="../notice/list.html">고객센터</a></li>
						<li class="last"><a href="recipe/list.html">마이페이지</a></li>
					</ul>
				</nav>
			</section>
		</div>
	</header>
	<!--메인메뉴 영역-->
	<div id="visual"></div>
	<section id="main-menu">
		<div class="content-container">
			<h1>메인 메뉴</h1>
			<nav>
				<h1>메뉴 목록</h1>
				<ul>
					<li><a href="recipe/reg.html">나의 식재료</a></li>
					<li><a href="../recipe/list.html">레시피</a></li>
					<li><a href="shopbag.html">장바구니</a></li>
					<li><a href="menu.html">나의 식단</a></li>
				</ul>
			</nav>
		</div>
	</section>
	<!-- 메인영역 -->
	
	<main id="body" class="clearfix">
	<div class="content-container">
		<h1>서비스 영역</h1>
		<nav>
			<h1>지금 바로 조리 가능한 레시피</h1>
			<fieldset>
				<ul>
					<li>콩나물국</li>
					<li>삼겹살 볶음밥</li>
					<li>닭 김치찜</li>
				</ul>
			</fieldset>
		</nav>

		<nav>
			<h3>식재료 서비스 버튼</h3>
			<input type="button" value="선택 식재료를 이용한 레시피" /> <input type="button"
				value="선택 식재료 사용완료" /> <input type="button" value="선택 식재료 버리기" />
		</nav>
		<div>
			<h3>식재료 카테고리 영역</h3>
			<form>
				<fieldset>
					<h4>목록</h4>
					<ul>
						<li>채소/과일</li>
						<li>육류</li>
						<li>수산물</li>
						<li>곡물/견과류</li>
						<li>양념소스</li>
						<li>가공식품</li>
						<li>유제품</li>
						<li>기타</li>
					</ul>
				</fieldset>
			</form>
		</div>
		<div>
			<h3>보유 식재료 출력 영역</h3>
			<div class="food-container">
				<form>
					<fieldset>
						<h4>냉장</h4>
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
					</fieldset>
				</form>
			</div>
			<div class="food-container">
				<form>
					<fieldset>
						<h4>냉동</h4>
						<ul>
							<li>등록된 식재료가 없습니다. 식재료를 등록해주세요.</li>
						</ul>
					</fieldset>
				</form>
			</div>
			<div class="food-container">
				<form>
					<fieldset>
						<h4>상온</h4>
						<ul>
							<li>감자</li>
							<li>소금</li>
							<li>굴소스</li>
							<li>설탕</li>
							<li>간장</li>
						</ul>
						<input type="button" value="보유 식재료 추가" />
					</fieldset>
				</form>
			</div>
		</div>
	</div>
	</main>

	<footer id="footer">
		<p>준비중</p>
	</footer>
</body>

</html>