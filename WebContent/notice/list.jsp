<%@page import="com.nayo.web.entity.Notice"%>
<%@page import="java.util.List"%>
<%@page import="com.nayo.web.NoticeService"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int pageNo = 1;
	String field = "title";
	String query = "";
	
	String pageNo_ = request.getParameter("p");
	String field_ = request.getParameter("f");
	String query_ = request.getParameter("q");
	
	if(pageNo_ != null && !pageNo_.equals(""))
		pageNo = Integer.parseInt(pageNo_);
	if(field_ !=null && !field_.equals(""))
		field = field_;
	if(query_ !=null && !query_.equals(""))
		query = query_;
	
	NoticeService ns = new NoticeService();

	List<Notice> list = ns.getNoticeList(field, query, pageNo);
	
	int count_ = ns.getNoticeCount(field, query);
	int countList = 10;
	int count = 1;
	
	if(count_ / countList == 0)
		count = 1;
	else if(count_ % countList > 0){
		count = count_ / countList;
		count++;
	}else
		count = count_ / countList;
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>나요</title>
<link href="../css/noticeStyle.css" type="text/css" rel="stylesheet" />
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
				<h1>공지사항 목록</h1>
					<h2>공지사항</h2>
						<section>
							<h1>공지사항 검색폼</h1>
							<form method="get">
								<select name="f">
									<option value="title">제목</option>
									<option value="content">내용</option>
								</select>
								<input type="text" name="q" placeholder="검색어를 입력하세요." value="<%= query%>"/>
								<input type="submit" value="검색"/>
							</form>
						</section>
	
						<section>
					 		<h1>공지사항표</h1>
					 		<table>
					 			<thead>
					 				<tr>
					 					<td>분류</td>
					 					<td>번호</td>
					 					<td>제목</td>
					 					<td>내용</td>
					 					<td>작성자</td>
					 					<td>작성일</td>
					 				</tr>
					 			</thead>
					 			<tbody>
					 			<% for(Notice n : list){ %>
					 				<tr>
						 				<td><%= n.getNoticeCate() %></td>
						 				<td><%= n.getId() %></td>
						 				<td><%= n.getTitle() %></td>
						 				<td><%= n.getContent() %></td>
						 				<td><%= n.getRegId() %></td>
						 				<td><%= n.getRegDate() %></td>
					 				</tr>
					 			<% } %>
					 			
					 			</tbody>
					 		</table>
					 	</section>
					 	
					 	<section>
							<h1>페이지 인덱스</h1>
					
							<div>1 / <%= count %> pages</div>
							<section>
								<h1>페이저</h1>
									<ul>
									<% for(int i=1; i<count+1; i++){ %>
										<li><a href="?p=<%= i %>&f=<%= field %>&q=<%= query %>"><%= i %></a></li>
									<% } %>
									</ul>
							</section>
						</section>
					</main>
				</div>
			</section>
			
<!-- footer영역 -->	
	<jsp:include page="../inc/footer.jsp"/>
	
</body>
</html>