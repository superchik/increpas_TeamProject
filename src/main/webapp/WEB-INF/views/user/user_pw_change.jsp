<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- CSS 공통화 -->

<link rel="stylesheet" type="text/css" href="resources/css/common/common.css" />
<link rel="stylesheet" type="text/css" href="resources/css/common/footer.css" />
<!-- main CSS -->
<link rel="stylesheet" type="text/css" href="resources/css/main/main.css" />

<!-- user common (id/pw find) css -->
<link rel="stylesheet" type="text/css" href="resources/css/user/user_common_find.css" />

<title>비밀번호 변경 화면</title>
</head>
<body>
	<!-- Header -->
	<jsp:include page="../common/header.jsp"></jsp:include>
	<div class="common_container">
		<div class="user_login_box">
			<div class="common_area">
				<h4>회원가입 시 작성하신 비밀번호와 새로운 비밀번호를 작성해주세요</h4>
				<form action="#" method="post">				
					<input class="user_common" type="password" id="u_pw1" name="u_pw1" placeholder="기존 비밀번호" required="required">
					<input class="user_common" type="password" id="u_pw2" name="u_pw2" placeholder="변경할 비밀번호" required="required">
					<input class="user_common" type="password" id="u_pw3" name="u_pw3" placeholder="변경할 비밀번호 확인">
					<button class="user_common get_value">비밀번호 변경</button>
				</form>
			</div>
			
			<div class="user_common_service">
				<h4><a class="user_common_link" href="/idfind">아이디를 잊으셨나요?</a></h4>
			</div>
		</div>	
	</div>
	<!-- footer -->
	<jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>