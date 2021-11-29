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
<!-- user login CSS -->
<link rel="stylesheet" type="text/css" href="resources/css/user/user_login.css"/>
<!-- Jquery CND -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<title>로그인 화면</title>
</head>
<body>
	<!-- Header -->
	<jsp:include page="../common/header.jsp"></jsp:include>
	<div class="common_container">
		<div class="user_login_box">
			<div class="common_area">
				<h4>로그인</h4>
				<form action="#" method="post">				
					<input class="user_common" type="text" id="u_id" name="u_id" placeholder="아이디">
					<input class="user_common" type="password" id="u_pwd1" name="u_pwd1" placeholder="비밀번호">
					<button class="user_common login_btn">로그인</button>
				</form>
			</div>
			
			<div class="user_common_service">
				<h4><a class="user_common_link" href="join">처음이신가요? 회원가입</a></h4>
				<h4><a class="user_common_link" href="/pwreissue">비밀번호를 잊으셨나요?</a></h4>
			</div>
			
			<div class="social_intro">
				<h3>소셜로그인</h3>
				<div class="social_login_area">
					<a class="user_common_link" href="https://kauth.kakao.com/oauth/authorize?client_id=0e09d7075cdcfb52a838e17f991e64b0&redirect_uri=kakaojs&response_type=code">
				   	<img class="social_img" src="resources/images/kakao_login.png">
					</a> 
					<a class="user_common_link" href="/naver_login"><img class="naver_img" src="resources/images/naver_login.png"></a>
				</div>
			</div>
			
		</div>	
	</div>
	
	<!-- footer -->
	<jsp:include page="../common/footer.jsp"></jsp:include>

	<script>
		$(function() {
			$("#naver").bind("click", function() {
				location.href = "/naver_login";
			});
		});
	</script>
</body>
</html>


<!-- <script>
			$(function(){
				//아이디가 btn인 요소가 클릭할 때
				$("#login_btn").bind("click",function(){
					//사용자가 입력한 아이디 및 비밀번호를 가져온다.
					var id = $("#id").val();
					var pw = $("#pw").val();
					
					if(id.trim().length <= 0){
						alert("아이디를 입력하세요");
						$("#id").val(""); //청소
						$("#id").focus();
						return;
					}
					if(pw.trim().length <= 0){
						alert("비밀번호를 입력하세요");
						$("#pw").val(""); //청소
						$("#pw").focus();
						return;
					}
					//현재 문서에서 가장 첫번째 폼을 서버경로를 변경한다.
					//document.forms[0].action = "Ex3_Login";
					//document.forms[0].submit();//서버로 보낸다.
					var param = "id="+encodeURIComponent(id)+
							"&pw="+encodeURIComponent(pw);
					$.ajax({
						url: "Login", //서버 요청 URL
						data: param, //전달하고자 하는 파라미터들
						type: "post" //전송 방식
					}).done(function(data){
						if(data == 0)
							alert("아이디 또는 비밀번호가 다릅니다.");
						else
							location.href="Main";
					});
				});
			});
</script> -->