<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>나도 요리사 - 나요</title>
<link href="../css/basic.css" type="text/css" rel="stylesheet" />
</head>
<body>

<!-- header영역 -->
	<jsp:include page="../inc/header.jsp"/>
	
	<!-- visual영역 -->	
	<div class="content-container">
		<div id="visual">		
		</div>
	</div>

	<!-- body영역 -->
	<section id="body">
		<div class="content-container">
			<form>
				<table border="1">
					<tr>
						<td colspan="2">나의 냉장고 재료 조합 레시피</td>
					</tr>
					<tr>
						<td colspan="2">로그인정보 없을 시 : 해당 서비스를 이용하시려면 로그인해주세요</td>
					</tr>
					<tr>
						<td colspan="2">나만의 레시피</td>
					</tr>
					<tr>
						<td colspan="2">로그인정보 없을 시 : 해당 서비스를 이용하시려면 로그인해주세요/
										등록된 요리 없을 시 : 나만의  요리를 사람들과 공유 해보세요</td>
					</tr>
					<tr>
						<td colspan="2">추천 레시피</td>
					</tr>
					<tr>
						<td colspan="2">index 페이지와 같은 추천 레시피 출력</td>
					</tr>
					<tr>
						<td>이주의 HOT 레시피</td>
						<td>따끈따끈한 최신 음식 정보</td>
					</tr>
					<tr>
						<td>한입만 많은 레시피 출력</td>
						<td>최근 등록된 레시피 출력</td>
					</tr>
				</table>
			</form>
		</div>
	</section>
	

<!-- footer영역 -->	
	<jsp:include page="../inc/footer.jsp"/>

</body>
</html>