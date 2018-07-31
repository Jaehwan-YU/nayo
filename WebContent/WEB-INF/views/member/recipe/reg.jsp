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
<script type="text/javascript" src="<%= ctx %>/js/regRecipe.js"></script>
<meta charset="UTF-8">
<title>나도 요리사 - 나요</title>
<link href="<%=ctx%>/css/regRecipeStyle.css" type="text/css" rel="stylesheet" />
</head>
<body>

	<!-- header영역 -->
	<jsp:include page="../../inc/header.jsp" />

	<!-- visual영역 -->
	<div class="content-container">
		<div id="visual"></div>
	</div>

	<section id="body">
		<div class="content-container">
			<form method="post" enctype="multipart/form-data">
				<table>
					<tr>
						<th>제목</th>
						<td colspan="2"><input type="text" name="title"></td>
					</tr>
					<tr>
						<th>한 줄 소개</th>
						<td colspan="2"><input type="text" name="simple-intro"></td>
					</tr>
					<tr>
						<th>완성된 요리 사진</th>
						<td><input type="file" accept=".jpg, .gif, .png"
							name="main-img"></td>
					</tr>
					<tr>
						<th>열량</th>
						<td><input type="text" name="kcal" /></td>
					</tr>
					<tr>
						<th>주재료</th>
						<td id = "main-ing">
							<div>
							<input type="text" placeholder="재료명 입력 (예)삼겹살" name="main-name-1"/> 
							<input type="text" placeholder="필요량 입력 (예)100g" name="main-quantity-1"/>
							<br/>
							</div>
							<input type="button" value="주재료 추가"/>
						</td>
					</tr>
					<tr>
						<th>부재료</th>
						<td id = "sub-ing">
							<div>
							<input type="text" placeholder="재료명 입력 (예)굴소스" name="sub-name-1"/> 
							<input type="text" placeholder="필요량 입력 (예)100g" name="sub-quantity-1"/>
							<br/>
							</div>
							<input type="button" value="부재료 추가"/>
						</td>
					</tr>
					<tr>
						<th>카테고리</th>
						<td>
							<select name="national">
								<option>나라 선택</option>
								<c:forEach var="nc" items="${nationalCate}">
								<option value="${nc.id}">${nc.name}</option>
								</c:forEach>
							</select>
						 	<select name="situation">
						 		<option>상황 선택</option>
						 		<c:forEach var="sc" items="${situationCate}">
								<option value="${sc.id}">${sc.name}</option>
								</c:forEach>
						 	</select> 
						 	<select name="recipe-type">
						 		<option>타입 선택</option>
						 		<c:forEach var="tc" items="${recipeTypeCate}">
								<option value="${tc.id}">${tc.name}</option>
								</c:forEach>
						 	</select>
						 	</td>
					</tr>
					<tr>
						<th>조리과정</th>
						<td id="process">
							<div>
							<textarea name="process-text-1"></textarea><input type="file"
							accept=".jpg, .gif, .png" name="process-img-1">
							<br/>
							</div>
							<input type="button" value="조리과정 추가"/>
						</td>
					</tr>
				</table>
				<input type="submit" value="등록"/> 
				<input type="button" value="취소" id="cancel-button"/>
			</form>
		</div>
	</section>


	<!-- footer영역 -->
	<jsp:include page="../../inc/footer.jsp" />

</body>
</html>