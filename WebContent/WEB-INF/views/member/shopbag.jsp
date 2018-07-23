<%@page import="java.util.List"%>
<%@page import="com.nayo.web.entity.Food"%>
<%@page import="com.nayo.web.member.FoodService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	FoodService fs = new FoodService();
%>
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
				<ul>
					<li>
						<figure>
							<img alt="" src="../images/ajax-loader.gif">
							<figcaption>
								<a href="">감자</a>
							</figcaption>
						</figure>
					</li>

					<li>
						<figure>
							<img alt="" src="../images/ajax-loader.gif">
							<figcaption>
								<a href="">버섯</a>
							</figcaption>
						</figure>
					</li>

					<li>
						<figure>
							<img alt="" src="../images/ajax-loader.gif">
							<figcaption>
								<a href="">양파</a>
							</figcaption>
						</figure>
					</li>

					<li>
						<figure>
							<img alt="" src="../images/ajax-loader.gif">
							<figcaption>
								<a href="">대파</a>
							</figcaption>
						</figure>
					</li>

					<li>
						<figure>
							<img alt="" src="../images/ajax-loader.gif">
							<figcaption>
								<a href="">마늘</a>
							</figcaption>
						</figure>
					</li>

					<li>
						<figure>
							<img alt="" src="../images/ajax-loader.gif">
							<figcaption>
								<a href="">애호박</a>
							</figcaption>
						</figure>
					</li>

					<section>
						<input type="button" value="채소/과일 인기재료 더보기" />
					</section>
				</ul>
			</nav>

			<h2>육류</h2>
			<nav class="meat-food"">
				<ul>
					<li>
						<figure>
							<img alt="" src="../images/ajax-loader.gif">
							<figcaption>
								<a href="">소고기 구이용</a>
							</figcaption>
						</figure>
					</li>

					<li>
						<figure>
							<img alt="" src="../images/ajax-loader.gif">
							<figcaption>
								<a href="">소고기 국거리용</a>
							</figcaption>
						</figure>
					</li>

					<li>
						<figure>
							<img alt="" src="../images/ajax-loader.gif">
							<figcaption>
								<a href="">돼지고기 구이용</a>
							</figcaption>
						</figure>
					</li>

					<li>
						<figure>
							<img alt="" src="../images/ajax-loader.gif">
							<figcaption>
								<a href="">돼지고기 찌개용</a>
							</figcaption>
						</figure>
					</li>

					<li>
						<figure>
							<img alt="" src="../images/ajax-loader.gif">
							<figcaption>
								<a href="">돼지고기 다짐육</a>
							</figcaption>
						</figure>
					</li>

					<li>
						<figure>
							<img alt="" src="../images/ajax-loader.gif">
							<figcaption>
								<a href="">닭다리살</a>
							</figcaption>
						</figure>
					</li>

					<li>
						<figure>
							<img alt="" src="../images/ajax-loader.gif">
							<figcaption>
								<a href="">오리고기</a>
							</figcaption>
						</figure>
					</li>

					<li>
						<figure>
							<img alt="" src="../images/ajax-loader.gif">
							<figcaption>
								<a href="">양고기</a>
							</figcaption>
						</figure>
					</li>

					<section>
						<input type="button" value="육류 인기재료 더보기" />
					</section>
				</ul>
			</nav>


			<h2>수산물</h2>
			<nav class="fish-food">
				<ul>
					<li>
						<figure>
							<img alt="" src="../images/ajax-loader.gif">
							<figcaption>
								<a href="">전복</a>
							</figcaption>
						</figure>
					</li>

					<li>
						<figure>
							<img alt="" src="../images/ajax-loader.gif">
							<figcaption>
								<a href="">오징어</a>
							</figcaption>
						</figure>
					</li>

					<li>
						<figure>
							<img alt="" src="../images/ajax-loader.gif">
							<figcaption>
								<a href="">문어</a>
							</figcaption>
						</figure>
					</li>

					<li>
						<figure>
							<img alt="" src="../images/ajax-loader.gif">
							<figcaption>
								<a href="">새우</a>
							</figcaption>
						</figure>
					</li>

					<li>
						<figure>
							<img alt="" src="../images/ajax-loader.gif">
							<figcaption>
								<a href="">고등어</a>
							</figcaption>
						</figure>
					</li>

					<li>
						<figure>
							<img alt="" src="../images/ajax-loader.gif">
							<figcaption>
								<a href="">갈치</a>
							</figcaption>
						</figure>
					</li>

					<li>
						<figure>
							<img alt="" src="../images/ajax-loader.gif">
							<figcaption>
								<a href="">옥돔</a>
							</figcaption>
						</figure>
					</li>

					<li>
						<figure>
							<img alt="" src="../images/ajax-loader.gif">
							<figcaption>
								<a href="">굴</a>
							</figcaption>
						</figure>
					</li>

					<section>
						<input type="button" value="수산물 인기재료 더보기" />
					</section>
				</ul>
			</nav>

			<h2>곡물/견과류</h2>
			<nav class="cereal-food">
				<ul>
					<li>
						<figure>
							<img alt="" src="../images/ajax-loader.gif">
							<figcaption>
								<a href="">아몬드</a>
							</figcaption>
						</figure>
					</li>

					<li>
						<figure>
							<img alt="" src="../images/ajax-loader.gif">
							<figcaption>
								<a href="">호두</a>
							</figcaption>
						</figure>
					</li>

					<li>
						<figure>
							<img alt="" src="../images/ajax-loader.gif">
							<figcaption>
								<a href="">땅콩</a>
							</figcaption>
						</figure>
					</li>

					<li>
						<figure>
							<img alt="" src="../images/ajax-loader.gif">
							<figcaption>
								<a href="">잣</a>
							</figcaption>
						</figure>
					</li>

					<li>
						<figure>
							<img alt="" src="../images/ajax-loader.gif">
							<figcaption>
								<a href="">밤</a>
							</figcaption>
						</figure>
					</li>

					<li>
						<figure>
							<img alt="" src="../images/ajax-loader.gif">
							<figcaption>
								<a href="">대추</a>
							</figcaption>
						</figure>
					</li>

					<li>
						<figure>
							<img alt="" src="../images/ajax-loader.gif">
							<figcaption>
								<a href="">브라질너트</a>
							</figcaption>
						</figure>
					</li>

					<li>
						<figure>
							<img alt="" src="../images/ajax-loader.gif">
							<figcaption>
								<a href="">강낭콩</a>
							</figcaption>
						</figure>
					</li>
					<section>
						<input type="button" value="곡물/견과류 인기재료 더보기" />
					</section>

				</ul>
			</nav>
			
			<h2>양념/소스</h2>
			<nav class="sauce-food">
				<ul>
					<li>
						<figure>
							<img alt="" src="../images/ajax-loader.gif">
							<figcaption>
								<a href="">간장</a>
							</figcaption>
						</figure>
					</li>

					<li>
						<figure>
							<img alt="" src="../images/ajax-loader.gif">
							<figcaption>
								<a href="">고추장</a>
							</figcaption>
						</figure>
					</li>

					<li>
						<figure>
							<img alt="" src="../images/ajax-loader.gif">
							<figcaption>
								<a href="">된장</a>
							</figcaption>
						</figure>
					</li>

					<li>
						<figure>
							<img alt="" src="../images/ajax-loader.gif">
							<figcaption>
								<a href="">청국장</a>
							</figcaption>
						</figure>
					</li>

					<li>
						<figure>
							<img alt="" src="../images/ajax-loader.gif">
							<figcaption>
								<a href="">쌈장</a>
							</figcaption>
						</figure>
					</li>

					<li>
						<figure>
							<img alt="" src="../images/ajax-loader.gif">
							<figcaption>
								<a href="">식용유</a>
							</figcaption>
						</figure>
					</li>

					<li>
						<figure>
							<img alt="" src="../images/ajax-loader.gif">
							<figcaption>
								<a href="">참기름</a>
							</figcaption>
						</figure>
					</li>

					<li>
						<figure>
							<img alt="" src="../images/ajax-loader.gif">
							<figcaption>
								<a href="">올리브유</a>
							</figcaption>
						</figure>
					</li>
					<section>
						<input type="button" value="양념/소스 인기재료 더보기" />
					</section>

				</ul>
			</nav>

			<h2>가공/유제품</h2>
			<nav class="manufacture-food">
				<ul>
					<li>
						<figure>
							<img alt="" src="../images/ajax-loader.gif">
							<figcaption>
								<a href="">국수</a>
							</figcaption>
						</figure>
					</li>

					<li>
						<figure>
							<img alt="" src="../images/ajax-loader.gif">
							<figcaption>
								<a href="">스파게티면</a>
							</figcaption>
						</figure>
					</li>

					<li>
						<figure>
							<img alt="" src="../images/ajax-loader.gif">
							<figcaption>
								<a href="">만두</a>
							</figcaption>
						</figure>
					</li>

					<li>
						<figure>
							<img alt="" src="../images/ajax-loader.gif">
							<figcaption>
								<a href="">라면</a>
							</figcaption>
						</figure>
					</li>

					<li>
						<figure>
							<img alt="" src="../images/ajax-loader.gif">
							<figcaption>
								<a href="">우유</a>
							</figcaption>
						</figure>
					</li>

					<li>
						<figure>
							<img alt="" src="../images/ajax-loader.gif">
							<figcaption>
								<a href="">요거트</a>
							</figcaption>
						</figure>
					</li>

					<li>
						<figure>
							<img alt="" src="../images/ajax-loader.gif">
							<figcaption>
								<a href="">생크림</a>
							</figcaption>
						</figure>
					</li>

					<li>
						<figure>
							<img alt="" src="../images/ajax-loader.gif">
							<figcaption>
								<a href="">치즈</a>
							</figcaption>
						</figure>
					</li>
					<section>
						<input type="button" value="가공/유제품 인기재료 더보기" />
					</section>

				</ul>
			</nav>

			<h2 class="etc-food">기타</h2>
			
		</div>
	</section>

	<!-- footer영역 -->
	<jsp:include page="../inc/footer.jsp" />

</body>
</html>