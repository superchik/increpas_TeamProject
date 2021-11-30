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
					<input class="user_common" type="text" id="u_id" name="u_id" placeholder="아이디" required="required" oninput="checkId()">
					<span class="id_ok">사용 가능한 아이디 입니다.</span>
					<span class="id_not">사용 불가능한 아이디 입니다.</span>
					<input class="user_common" type="text" id="u_name" name="u_name" placeholder="이름" required="required">
					<input class="user_common" type="email" id="u_email" name="u_email" placeholder="이메일" required="required" oninput="checkEmail()">
					<span class="email_ok">사용 가능한 이메일 입니다.</span>
					<span class="email_not">사용 불가능한 이메일 입니다.</span>
					<input class="user_common" type="password" id="u_pwd1" name="u_pwd1" placeholder="비밀번호" required="required">
					<input class="user_common" type="password" id="u_pwd2" name="u_pwd2" placeholder="비밀번호확인">					
					<button id="join_btn" class="user_common join_btn" type="submit">회원가입</button>
				</form>
			</div>
			
			<div class="user_common_service">
				<h4><a class="user_common_link" href="login">계정이 있으신가요? 로그인</a></h4>
			</div>
		</div>	
	</div>
	<!-- footer -->
	<jsp:include page="../common/footer.jsp"></jsp:include>
	
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>			
	<script>
		$(function(){
			//아이디가 btn인 요소가 클릭할 때
			$("#join_btn").bind("click",function(){
				//사용자가 입력한 아이디 및 비밀번호를 가져온다.
				var id = $("#u_id").val();
				var name = $("#u_name").val();
				var email = $("#u_email").val();
				var reg_email = /^([0-9a-zA-Z_\.-]+)@([0-9a-zA-Z_-]+)(\.[0-9a-zA-Z_-]+){1,2}$/;
				var pw = $("#u_pwd1").val();
				var pw2 = $("#u_pwd2").val();
				
				if(id.trim().length <= 0){
					alert("아이디를 입력하세요");
					$("#u_id").val(""); //청소
					$("#u_id").focus();
					return;
				}
				if(name.trim().length <= 0){
					alert("이름을 입력하세요");
					$("#u_name").val(""); //청소
					$("#u_name").focus();
					return;
				}
				if(email.trim().length <= 0){
					alert("이메일을 입력하세요");
					$("#u_email").val(""); //청소
					$("#u_email").focus();
					return;
				}
				if(!reg_email.test(email)){
					alert("이메일을 다시 입력하세요");
					$("#u_email").val(""); //청소
					$("#u_email").focus();
					return;
				}
				if(pw.trim().length <= 0){
					alert("비밀번호를 입력하세요");
					$("#u_pwd1").val(""); //청소
					$("#u_pwd1").focus();
					return;
				}
				if(pw2.trim().length <= 0){
					alert("확인 비밀번호를 입력하세요");
					$("#u_pwd2").val(""); //청소
					$("#u_pwd2").focus();
					return;
					}
				if(pw.trim() != pw2.trim()){
					alert("비밀번호와 확인 비밀번호가 다릅니다");
					$("#u_pwd2").val(""); //청소
					$("#u_pwd2").focus();
					return;
				}
				
			});
		});
		
		function checkId(){
			var u_id = $("#u_id").val();
			$.ajax({
				url:"/idCheck",
				type:"post",
				data:{id:u_id}
			}).done(function(cnt){
				if(cnt != 1){
					$(".id_ok").css("display","block");
					$(".id_not").css("display","none");
					$("#join_btn").attr("disabled", false);
				}else{
					$(".id_ok").css("display","none");
					$(".id_not").css("display","block");
					$("#join_btn").attr("disabled", true);
				}
			}).fail(function(err){
				alert("에러났음");
			});
		};
		
		function checkEmail(){
			var u_email = $("#u_email").val();
			$.ajax({
				url:"/emailCheck",
				type:"post",
				data:{email:u_email}
			}).done(function(cnt){
				if(cnt != 1){
					$(".email_ok").css("display","block");
					$(".email_not").css("display","none");
					$("#join_btn").attr("disabled", false);
				}else{
					$(".email_ok").css("display","none");
					$(".email_not").css("display","block");
					$("#join_btn").attr("disabled", true);
				}
			}).fail(function(err){
				alert("에러났음");
			});
		};
		
	</script>
</body>
</html>