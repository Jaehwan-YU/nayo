<%@page import="com.nayo.web.entity.Notice"%>
<%@page import="java.util.List"%>
<%@page import="com.nayo.web.NoticeService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int id = Integer.parseInt(request.getParameter("id"));
	NoticeService ns = new NoticeService();
	
	Notice notice = ns.getNotice(id);
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>나요</title>
<link href="../css/detailStyle.css" type="text/css" rel="stylesheet" />
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
			<!-- aside영역 -->
			<aside id="aside">
				<h1>마이페이지 메뉴</h1>
					<h2>마이페이지</h2>
					<div id="aside-menu">
						<ul>
							<li><a href="list.jsp">공지사항</a>
							<li><a href="../faq/list.jsp">FAQ</a>
						</ul>
					</div>
			</aside>
			<!-- main영역 -->
			<main id="main">
				<h1>공지사항</h1>
					<section id="notice-table">
						<h1>공지사항 내용</h1>
						<table class="table">
							<tbody>
								<tr>
									<th>제목</th>
									<td colspan="3"><%= notice.getTitle() %></td>
								</tr>
								<tr>
									<th>작성일</th>
									<td><%= notice.getRegDate() %></td>
									<th>작성자</th>
									<td><%= notice.getRegId() %></td>
								</tr>
							</tbody>
						</table>
					</section>
					
					<section id="detail-content">
						<div><%= notice.getContent() %></div>
					</section>
						
			</main>
		</div>
	</section>
			
<!-- footer영역 -->	
	<jsp:include page="../inc/footer.jsp"/>
	
</body>
</html>