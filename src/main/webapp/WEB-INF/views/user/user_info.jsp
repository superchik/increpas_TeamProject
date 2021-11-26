<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- CSS 공통화 -->
<link rel="stylesheet" type="text/css" href="resources/css/common/common.css">
<link rel="stylesheet" type="text/css" href="resources/css/common/footer.css">
<!-- main CSS -->
<link rel="stylesheet" type="text/css" href="resources/css/main/main.css">
<link rel="stylesheet" href="//code.jquery.com/ui/1.13.0/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">

<!-- user_info CSS -->
<link rel="stylesheet" type="text/css" href="resources/css/user/user_info.css">


<title>Insert title here</title>
</head>
<body>

	<!-- Header -->
	<jsp:include page="../common/header.jsp"></jsp:include>
	<div class="common_container">
		<!-- 여기다 작업하세요 -->
		<h2>User</h2>
		<div class="com">
			<div class="TBox img">
				<p>profile_img</p>
			</div>
			<div class="MBox profile">
				<div class="Boxp p1">
					<p>Level:</p>
				</div>
				<div class="Boxp p2">
					<p>ID:</p>
				</div>
				<div class="Boxp p3">
					<p>가입한 이메일:</p>
				</div>
				<div class="Boxp p4">
					<p>내가 쓴 글수</p>
				</div>
				<div class="Boxp p5">
					<p>Adout_me</p>
				</div>
			</div>
			<button class="BBox butter" type="button">프로필 이미지 변경</button>
		</div>
	</div>
	<div id="dialog" title="다이얼로그 테스트" style=" border: 1px solid red;">
		<form action="${pageContext.request.contextPath}/updatetNoticePro.do" method="post" enctype="multipart/form-data" name="noticeForm">
		        <input type='file' id="filename" name="filename"/>
		        
		        <!--                           현재프로젝트.경로요청/saveFIle이라는 폴더안에/객체.변수명 ( 지금은 없는관계로.. 에러가 발생하는것 같음 --> 
		        <!-- <img id="preImage" src="${pageContext.request.contextPath}/saveFile/${noticeVO.filename}" alt="image_title" onerror='this.src="${pageContext.request.contextPath}/images/no_img.jpg"'/> -->
    			<!--  Error: src="${pageContext.request.contextPath}/saveFile/${noticeVO.filename}" alt="image_title" onerror='this.src="${pageContext.request.contextPath}/images/no_img.jpg" -->
    			<img id="preImage"/>
    			    	
    	</form>
		<div class="logBtn">
			<button class="logBtn0" type="button">확인</button>
			<button class="logBtn" type="button">최소</button>
		</div>
	</div>
	<!-- footer -->
	<jsp:include page="../common/footer.jsp"></jsp:include>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/ui/1.13.0/jquery-ui.js"></script>
<script type="text/javascript">
	$(function() {
		console.log('Ready');
		$('.BBox').on('click', function() {
			console.log('BBox Ready');
			$( "#dialog" ).dialog();
		});

        $("#filename").on('change', function(){
            readURL(this);
     
    	});
			
	});
	function readURL(input) {
		// 어제 작업한곳맞죠?
        if (input.files && input.files[0]) {
           var reader = new FileReader();
           reader.onload = function (e) {
              $('#preImage').attr('src', e.target.result);
           }
           reader.readAsDataURL(input.files[0]);
        }
       
    }


</script>
</body>
</html>