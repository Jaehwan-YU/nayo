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
			<section id="main">
				<h1>레시피 디테일 페이지</h1>
				<section id="recipe-info">
					<table>
						<thead>
							<tr>
								<th>요리명</th>
								<td colspan="3"></td>
							</tr>
							<tr>
								<th>작성자</th>
								<td></td>
								<th>조회수</th>
								<td></td>
							</tr>
						</thead>
						<tbody>
							<tr>main사진</tr>
							<tr>한줄 설명</tr>
							<tr>
								<td>주재료</td>
								<td></td>
							</tr>
							<tr>
								<td>부재료</td>
								<td></td>
							</tr>
							<tr>
								<td>해당 사진</td>
								<td>조리과정</td>
							</tr>
						</tbody>	
					</table>
				</section>
				<section id="recipe-main">
				</section>
			</section>
		</div>
	</section>

<!-- footer영역 -->	
	<jsp:include page="../inc/footer.jsp"/>	
	
</body>
</html>