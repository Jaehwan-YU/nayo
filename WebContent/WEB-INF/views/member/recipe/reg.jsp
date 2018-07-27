<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>나도 요리사 - 나요</title>
<link href="../../css/basic.css" type="text/css" rel="stylesheet" />
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
						<td><input type="text"></td>
					</tr>
					<tr>
						<th>완성된 요리 사진</th>
						<td><input type="file" accept=".jpg, .gif, .png"><input type="hidden" name="name-1" value="1"/></td>
					</tr>
					<tr>
						<th>주재료</th>
						<td><input type="text" placeholder="재료명 입력 (예)삼겹살"> <input
							type="text" placeholder="필요량 입력 (예)100g"></td>
					</tr>
					<tr>
						<th>부재료</th>
						<td><input type="text" placeholder="재료명 입력 (예)삼겹살"> <input
							type="text" placeholder="필요량 입력 (예)100g"></td>
					</tr>
					<tr>
						<th>카테고리</th>
						<td><select><option>나라 선택</option></select>
						<select><option>상황 선택</option></select>
						<select><option>타입 선택</option></select></td>
					</tr>
					<tr>
						<th>조리과정</th><td><textarea></textarea><input type="file" accept=".jpg, .gif, .png"></td>
					</tr>
					<tr>
						<td colspan="2">
						<input type="submit" value="등록">
						<input type="button" value="취소">
						</td>
					</tr>
				</table>
			</form>
		</div>
	</section>


	<!-- footer영역 -->
	<jsp:include page="../../inc/footer.jsp" />

</body>
</html>