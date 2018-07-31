<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Insert title here</title>
<link href="../css/myinfo.css" type="text/css" rel="stylesheet" />

<title>나도 요리사 - 나요</title>
<link href="../css/basic.css" type="text/css" rel="stylesheet" />
</head>
<body>

	<!-- header영역 -->
	<jsp:include page="../inc/header.jsp" />

	<!-- visual영역 -->
	<div class="content-container">
		<h2>프로필 수정</h2>
		<div id="visual"></div>
	</div>

	<!-- aside 영역 -->
	<aside class ="aside">
		<h1>마이페이지</h1>
		<nav class="content-container">
			<h1>마이페이지 메뉴</h1>
			<ul>
				<li><a href="recipe/list.jsp">나의 레시피</a></li>
				<li><a href="bookmark.jsp">즐겨먹기</a></li>
				<li><a href="infocheck.jsp">내 정보</a></li>
			</ul>
	</nav>
	</section>
	</aside>


	<!-- body 영역 -->
	<fieldset id = "main">
		<legend>프로필 수정</legend>
		<table border="1">
			<td>프로필 사진</td>
			<tr />
			<th>이메일 주소</th>
			<td><input type="text"></td>
			<tr />

			<th>비밀번호 확인</th>
			<td><input type="text"></td>
			<tr />
			<th>비밀번호 변경</th>
			<td><input type="text"></td>
			<tr />
			<th>닉네임</th>
			<td><input type="text"> <input type="button"
				value="중복확인" /></td>
			</tr>


			<th>휴대폰 전화</th>
			<td><input type="text"></td>
			<tr />
			<th>자기소개</th>
			<td><input type="text"></td>
			</tr>
		</table>
	</fieldset>
</body>
<!-- footer영역 -->
<jsp:include page="../inc/footer.jsp" />

</body>
</html>