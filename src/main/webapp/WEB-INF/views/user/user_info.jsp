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
				<img class="profileImg"/>
				<p>profile_img</p>
			</div>
			<div class="MBox profile">
				<div class="Boxp p1">
					<p>Level:${vo.u_level }</p>
				</div>
				<div class="Boxp p2">
					<p>ID:${vo.u_id }</p>
				</div>
				<div class="Boxp p3">
					<p>가입한 이메일:${vo.u_email }</p>
				</div>
				<div class="Boxp p4">
					<p>내가 쓴 리뷰 수:${voList }</p>
				</div>
				<div class="Boxp p5">
					<p>Adout_me</p>
				</div>
			</div>
			<button class="BBox butter" type="button">프로필 이미지 변경</button>
		</div>
	</div>
	<div id="dialog" title="다이얼로그 테스트" style=" border: 1px solid red;">
		<form action="" method="post" enctype="" name="">
   			<div><img id="preImage"/></div>
	        <input type='file' id="filename" name="filename"/>
	        <input type="hidden" id="u_user" name="u_idx" value="${u_idx }"/>
	        
	        <!--                           현재프로젝트.경로요청/saveFIle이라는 폴더안에/객체.변수명 ( 지금은 없는관계로.. 에러가 발생하는것 같음 --> 
	        <!-- <img id="preImage" src="${pageContext.request.contextPath}/saveFile/${noticeVO.filename}" alt="image_title" onerror='this.src="${pageContext.request.contextPath}/images/no_img.jpg"'/> -->
   			<!--  Error: src="${pageContext.request.contextPath}/saveFile/${noticeVO.filename}" alt="image_title" onerror='this.src="${pageContext.request.contextPath}/images/no_img.jpg" -->
	    			    	
			<div class="logBtn">
				<button class="logBtn0" type="button">확인</button>
				<button class="logBtn" type="button">최소</button>
			</div>
    	</form>
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

		$('.logBtn').on('click', function () {
			$( "#dialog" ).dialog('close');
		});
		
        $("#filename").on('change', function(){
            readURL(this);
     
    	});
        $(".logBtn0").on("click", function () {
        	
        	var u_idx = $("#u_user").val();
        	var file = $("#filename").val();
        	
        	if( file != null){
        		alert(file);
        		sendImage(file, u_idx);
        	}else
        		alert("파일을 선텍 하세요!");
        	
        	console.log(u_idx);
        	console.log(typeof(file));
        	
		})
			
	});
	function readURL(input) {
        if (input.files && input.files[0]) {
           var reader = new FileReader();
           reader.onload = function (e) {
              $('#preImage').attr('src', e.target.result);
           }
           reader.readAsDataURL(input.files[0]);
        }
       
    }
	function sendImage(file, u_idx){
		
		var frm = new FormData();
		//파일을 보내야할때는 폼에 담아서 보내야한다.
		
		console.log(u_idx);
       	console.log(typeof(file));
		
		//보내고자 하는 자원을 위해서 만든 폼객체에 파라미터로 넣어준다.
		frm.append("s_file", file);
		frm.append("u_idx", u_idx);
		
		//비동기식 통신
		$.ajax({
			url: "saveImage.inc",
			data: frm,
			type: "post",
			contentType: false, //파일의형식 - enpType으로 가기 위해서 파일의 형식을 없애버렸다.
			processData: false,
			cache: false,
			dataType: "json", // 서버로부터 받을 데이터 형식
		}).done(function(data){
			$( "#dialog" ).dialog('close');
			var path = data.path; //이미지가 저장된 경로
			var fname = data.fname; // 파일명
			$('.profileImg').attr('src', path);
			console.log(path);
			console.log(fname);
		}).fail(function(err){
			//서버에서 오류가 발생 시
			console.log(err);
		});
	}

</script>
</body>
</html>