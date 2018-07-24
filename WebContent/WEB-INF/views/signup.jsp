<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>나도 요리사 - 나요</title>
</head>
<body>
	<header>
		<ul>
			<li><a href="index">home</a></li>
		</ul>
	</header>

	<main>

	<h1>회원가입 페이지 입니다</h1>
	<div>
		<h2>회원 가입 폼</h2>
		<form action="singup" method="post">
			<table border="1">
				<tr>
					<th>이메일</th>
					<td><input type="text" required="required"
						placeholder="ex)E-mail@nayo.com" 
						pattern="^[0-9a-zA-Z][0-9a-zA-Z\_\-\.\+]+[0-9a-zA-Z]@[0-9a-zA-Z][0-9a-zA-Z\_\-]*[0-9a-zA-Z](\.[a-zA-Z]{2,6}){1,2}$"/> 
						<input type="button" value="중복확인" />
						</td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="password" required="required"
						placeholder="영문,숫자,특수문자가 전부 한 번씩 들어가며 8자 이상" /></td>
				</tr>
				<tr>
					<th>비밀번호 확인</th>
					<td><input type="password" required="required" /></td>
				</tr>
				<tr>
					<th>닉네임</th>
					<td><input type="text" required="required" /> <input
						type="button" value="중복확인" /></td>
				</tr>
				
				<tr>
					<td colspan = "2"><input type="submit" value="확인" /></td>
				</tr>

			</table>
		</form>
	</div>
	</main>

</body>
</html>