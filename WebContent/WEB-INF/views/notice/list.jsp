<%@page import="com.nayo.web.entity.Notice"%>
<%@page import="java.util.List"%>
<%@page import="com.nayo.web.NoticeService"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
	String ctx = request.getContextPath();
	/* int countList = 10;
	int count = 1;
	
	if(count_ / countList == 0)
		count = 1;
	else if(count_ % countList > 0){
		count = count_ / countList;
		count++;
	}else
		count = count_ / countList; */
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>나요</title>
<link href="<%=ctx %>/css/noticeStyle.css" type="text/css" rel="stylesheet" />
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
							<li><a href="list">공지사항</a>
							<li><a href="../faq/list">FAQ</a>
						</ul>
					</div>
			</aside>
			<!-- main영역 -->
			<main id="main">
				<h1>공지사항 목록</h1>
					<h2>공지사항</h2>
						<section id="notice-search">
							<h1>공지사항 검색폼</h1>
							<form method="get">
								<select name="f">
									<option value="title">제목</option>
									<option value="content">내용</option>
								</select>
								<input type="text" name="q" placeholder="검색어를 입력하세요." value="${param.q}"/>
								<input type="submit" value="검색"/>
							</form>
						</section>
	
						<section id="notice-table">
					 		<h1>공지사항표</h1>
					 		<table class="table">
					 			<thead>
					 				<tr>
					 					<td class="td-sm">분류</td>
					 					<td class="td-md">번호</td>
					 					<td class="title">제목</td>
					 					<td class="td-md">작성자</td>
					 					<td class="td-md">작성일</td>
					 				</tr>
					 			</thead>
					 			<tbody>
					 			<c:forEach var="n" items="${list}"> 
					 				<tr>
						 				<td class="td-sm">${n.noticeCate}</td>
						 				<td class="td-md">${n.id}</td>
						 				<td class="title"><a href="detail?id=${n.id}">${n.title}</a></td>		
						 				<td class="td-md">${n.regId}</td>
						 				<td class="td-md">${n.regDate}</td>
					 				</tr>
					 			</c:forEach>
					 			</tbody>
					 		</table>
					 	</section>
					 	
					 	<section id="page-index">
					 	<c:if test="${not empty p}">
								<c:set var="page" value="${p}"/>
						</c:if>
						<c:set var="startNum" value="${(page-1)/5}"/>
						<c:set var="startNum" value="${startNum - (startNum%1)}"/>
						<c:set var="startNum" value="${startNum*5+1}"/>
						
						<c:set var="lastNum" value="${(count+9)/10}"/>
						<c:set var="lastNum" value="${lastNum-(lastNum%1)}"/>
						<c:set var="lastNum" value="${fn:replace(lastNum,'.0','')}"/>
						 	
					 	<c:if test="${lastNum < startNum+4}">
							<c:set var="lastNum" value="${lastNum}" />
						</c:if>
							<h1>페이지 인덱스</h1>
					
							<div>${p} / ${lastNum} pages</div>
						</section>
						
						<section id="pager">
							<h1>페이저</h1>
								<ul>
								<c:forEach var="i" begin="${startNum}" end="${lastNum}">
									<li><a href="?p=${i}&f=${param.f}&q=${param.q}">${i}</a></li>
								</c:forEach>
								</ul>
						</section>
						
					</main>
				</div>
			</section>
			
<!-- footer영역 -->	
	<jsp:include page="../inc/footer.jsp"/>
	
</body>
</html>