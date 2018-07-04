<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nayo!</title>
</head>
<body>
<h1>Nayo</h1>
	<section>
		<h1>
			<a href="../index.html">상단메뉴</a>
		</h1>

		<nav>
			<h2>메인메뉴</h2>
			<ul>
				<li><a href="food.html">나의 식재료</a></li>
				<li><a href="../recipe/list.html">레시피</a></li>
				<li><a href="shopbag.html">장바구니</a></li>
				<li><a href="menu.html">나의 식단</a></li>
			</ul>
		</nav>


		<section>
			<h2>강좌검색 폼</h2>
			<form>
				<fieldset>
					<legend>전체 검색 창</legend>
					<input type="text" value="재료명, 레시피 검색" /> <input type="button"
						value="검색" />
				</fieldset>
			</form>
		</section>


		<nav>
			<h2>회원메뉴</h2>

			<ul>

				<li><a href="../login.html">로그인</a></li>
				<li><a href="../../notice/list.html">고객센터</a></li>
				<li><a href="recipe/list.html">마이페이지</a></li>
			</ul>
		</nav>
	</section>

	<section>
		<h2>마이페이지</h2>
		<nav>
			<h3>마이페이지 메뉴</h3>
			<ul>
				<li><a href="recipe/list.html">나의 레시피</a></li>
				<li><a href="bookmark.html">즐겨먹기</a></li>
				<li><a href="infocheck.html">내 정보</a></li>
			</ul>
		</nav>
	</section>

	<section>
		<h2>즐겨먹기</h2>
		<nav>
			<h3>즐겨먹기 목록</h3>
			<ol>
				<li><a href="../recipe/detail.html">레시피 1</a></li>
				<li><a href="../recipe/detail.html">레시피 2</a></li>
				<li><a href="../recipe/detail.html">레시피 3</a></li>

			</ol>
		</nav>
	</section>
	<p>
	[즐겨먹기 페이지]
	</p>
</body>

</html>