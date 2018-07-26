<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String ctx = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>나도 요리사 - 나요</title>
<link href="css/loginStyle.css" type="text/css" rel="stylesheet" />
</head>
<body>

	<!-- header영역 -->
	<jsp:include page="inc/header.jsp" />

	<!-- visual영역 -->
	<div class="content-container">
		<div id="visual"></div>
	</div>

	<!-- body영역 -->
	<section id="body">
		<div class="content-container">
			<h1>
				<a href="<%=ctx%>/index"><img scr="" alt="">나요</a>
			</h1>

			<section id="login-text">
				<h1>로그인정보입력</h1>
				<form method="post">
					<table>
						<tbody>
							<tr>
								<td><input type="text" placeholder="아이디" name="email"/></td>
							</tr>
							<tr>
								<td><input type="password" placeholder="비밀번호" name="pwd"/></td>
							</tr>
							<tr>
								<td><input type="submit" value="로그인" /></td>
							</tr>
						</tbody>
					</table>
				</form>
			</section>

			<section id="search-login">
				<h1>로그인정보 찾기</h1>
				<ul>
					<li><a href="">아이디 찾기</a></li>
					<li><a href="">비밀번호 찾기</a></li>
					<li><a href="signup">회원가입</a></li>
				</ul>
			</section>

			<section id="another-login">
				<h1>타매체 로그인</h1>
				<ul>
					<li><a href="">카카오톡 로그인</a></li>
					<li><a href="">페이스북 로그인</a></li>
				</ul>
			</section>

		</div>
	</section>



	<!-- footer영역 -->
	<%-- <jsp:include page="inc/footer.jsp"/> --%>

</body>
</html>