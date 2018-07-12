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
	<header id="header">
	<div class="content-container">
		<h1>
			<a href="../index.jsp">나요</a>

		</h1>
		<div id="search-engine">
			<h2>검색 폼</h2>
			<form>
				<input type="text" placeholder="재료명, 레시피 검색" />
				<input type="submit" value="검색" />
			</form>
		</div>
		<div id="member-menu">
			<nav id="basic-menu">
				<h2>회원메뉴</h2>
				<ul>
					<li><a href="../login.jsp">로그인</a></li>
					<li><a href="../../notice/list.jsp">고객센터</a></li>
					<li><a href="recipe/list.jsp">마이페이지</a></li>
				</ul>
			</nav>
		</div>
	</div>
		<br />
			<section class="content-container">
				<nav id="main-menu">
					<h2>메인메뉴</h2>
					<ul>
						<li><a href="../member/food.jsp">나의 식재료</a></li>
						<li><a href="../recipe/list.jsp">레시피</a></li>
						<li><a href="shopbag.jsp">장바구니</a></li>
						<li><a href="menu.jsp">나의 식단</a></li>
					</ul>
				</nav>			
			</section>
	</header>
	
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
					 		<table border="1">
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
							<div>1 / 1 pages</div>
							<section>
								<h1>페이저</h1>
									<ul>
									<% for(int i=1; i<=count; i++){ %>
										<li><a href="?p=<%= i %>&f=<%= field %>&q=<%= query %>"><%= i %></a></li>
									<% } %>
									</ul>
							</section>
						</section>
					</main>
				</div>
			</section>
	
</body>
</html>