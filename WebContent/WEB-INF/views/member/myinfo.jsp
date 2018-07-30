<%@page import="com.nayo.web.entity.Member" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
	String ctx = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Insert title here</title>
<title>나도 요리사 - 나요</title>
<link href="<%=ctx %>/css/myinfo.css" type="text/css" rel="stylesheet" />
</head>
<body>

	<!-- header영역 -->
	<jsp:include page="../inc/header.jsp" />

	<!-- visual영역 -->
	<div class="content-container">
		<h2>프로필 수정</h2>
		<div id="visual"></div>
	</div>

	
	<!-- body 영역 -->
	<section id="body">
	<div class="content-container">
		<!-- aside 영역 -->
		<aside id="aside">
				<h1>마이페이지 메뉴</h1>
					<h2>마이페이지</h2>
					<div id="aside-menu">
						<ul>
							<li><a href="bookmark">즐겨먹기</a></li>
							<li><a href="recipe/list">나의 레시피</a></li>
							<li><a href="infocheck">내 정보</a></li>
						</ul>
					</div>
		</aside>
	
		<fieldset id = "main">
			<legend>프로필 수정</legend>
			<table border="1">
				<tr>
					<td colspan="2">프로필 사진</td>
				</tr>
				<tr>
					<th>이메일</th>
					<td><input type="text" name="email" value="${email}"/></td>
				</tr>
				<tr>
					<th>닉네임</th>
					<td><input type="text" name="nick" value="${nick}"/>
						<input type="button" value="중복확인" />
					</td>
				</tr>
				<tr>
					<th>비밀번호 변경</th>
					<td><input type="password" name="pwd1" /></td>
				</tr>
				<tr>
					<th>비밀번호 확인</th>
					<td><input type="password" name="pwd2" /></td>
				</tr>
				<tr>
					<th>생일</th>
					<td>
						<input type="date">
						<input type="radio" name="solar"><label>양력</label>
						<input type="radio" name="solar"><label>음력</label>
					</td>
				</tr>
				<tr>
					<th>성별</th>
					<td>
						<select>
							<option>선택</option>
							<option selected="selected">남성</option>
							<option>여성</option>
						</select>
					</td>
				</tr>
				<tr>
					<th>자기소개</th>
					<td><textarea></textarea></td>
				</tr>
			</table>
		</fieldset>
	</div>
	</section>
</body>
<!-- footer영역 -->
<jsp:include page="../inc/footer.jsp" />

</body>
</html>