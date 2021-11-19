<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 재발급 화면</title>
<link rel="stylesheet" type="text/css" href="resources/css/login/style.css"/>
</head>
<body>
	<div id="main_frame">
		<form action="#" method="post" class="pw_reissue">
			<p></p>
			<fieldset>
				<br><br>
				<div id="content">아이디, 이메일을 작성하세요.</div><br><br>
				<input type="text" id="id" name="id" size=38 placeholder="아이디"><br><br>
				<input type="text" id="email" name="email" size=38 placeholder="이메일(kim@example.com)"><br><br><br><br>
				<input type="button" value="비밀번호 재발급" class="submit">
			</fieldset>
			<br>
			<div>처음이신가요? <a href="join">회원가입</a>
			 · <a href="idfind">아이디를 잊으셨나요?</a></div>
		</form>
	</div>
</body>
</html>