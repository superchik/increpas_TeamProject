<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 찾기 화면</title>
<link rel="stylesheet" type="text/css" href="resources/css/login/style.css"/>
</head>
<body>
	<div id="main_frame">
		<form action="#" method="post" class="id_find">
			<p></p>
			<fieldset>
				<br><br>
				<div id="content">이름, 이메일을 작성하세요.</div><br><br>
				<input type="text" id="name" name="name" size=38 placeholder="이름"><br><br>
				<input type="text" id="email" name="email" size=38 placeholder="이메일(kim@example.com)"><br><br><br><br>
				<input type="button" value="아이디 찾기" class="submit">
			</fieldset>
			<br>
			<div>처음이신가요? <a href="join">회원가입</a>
			 · <a href="pwreissue">비밀번호를 잊으셨나요?</a></div>
		</form>
	</div>
</body>
</html>