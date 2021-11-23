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
	        <div class="Boxp p1"><p>Level:</p></div>
	        <div class="Boxp p2"><p>ID:</p></div>
	        <div class="Boxp p3"><p>가입한 이메일:</p></div>
	        <div class="Boxp p4"><p>내가 쓴 글수</p></div>
	        <div class="Boxp p5"><p>Adout_me</p></div>
    	</div>
		<div class="BBox butter">프로필 이미지 변경</div>
	</div>
</div>
<!-- footer -->
<jsp:include page="../common/footer.jsp"></jsp:include>


</body>
</html>