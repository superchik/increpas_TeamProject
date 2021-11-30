<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- CSS 공통화 -->

<link rel="stylesheet" type="text/css" href="resources/css/common/common.css" />
<link rel="stylesheet" type="text/css" href="resources/css/common/footer.css" />
<!-- main CSS -->
<link rel="stylesheet" type="text/css" href="resources/css/main/main.css" />
<!-- user join css -->
<link rel="stylesheet" type="text/css" href="resources/css/user/user_join.css" />
<title>회원 가입 화면</title>
</head>
<body>
	<!-- Header -->
	<jsp:include page="../common/header.jsp"></jsp:include>
	<div class="common_container">
		<div class="user_join_box">
			<div class="common_area">
				<h4>Sign Up to Increpas...</h4>
				<form action="/login_join" method="post">				
					<input class="user_common" type="text" id="u_id" name="u_id" placeholder="아이디">
					<input class="user_common" type="text" id="u_name" name="u_name" placeholder="이름">
					<input class="user_common" type="email" id="u_email" name="u_email" placeholder="이메일">
					<input class="user_common" type="password" id="u_pwd1" name="u_pwd1" placeholder="비밀번호">
					<input class="user_common" type="password" id="u_pwd2" name="u_pwd2" placeholder="비밀번호확인">					
					<button  class="user_common join_btn" type="submit">회원가입</button>
				</form>
			</div>
			
			<div class="user_common_service">
				<h4><a class="user_common_link" href="login">계정이 있으신가요? 로그인</a></h4>
			</div>
		</div>	
	</div>
	<!-- footer -->
	<jsp:include page="../common/footer.jsp"></jsp:include>
	
	<script>
		alert('${msg}');
	</script>
</body>
</html>