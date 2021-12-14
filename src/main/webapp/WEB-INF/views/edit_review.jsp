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
<title>review_edit</title>
<style>
	.edit_back{
		margin-top: 50px;
		text-align: center;
	}
	.review_edit{
		background-color: white;
		color: black;
	}
</style>
</head>
<body>
<div>
<form>
<div class="edit_back">
	<textarea name="content" id="write_area" 
			cols="100" rows="5">${rvo.content }</textarea>
			<input type="button" class="review_edit" value="수정" onclick="review_edit()"/>
</div>
</form>
</div>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
<script>
	function review_edit(){
		var rv_idx = ${rvo.rv_idx};
		var content = $("#write_area").val();
		$.ajax({
			url:"/review_edit_submit",
			type:"post",
			data:{rv_idx:rv_idx, content:content},
			success: window.close()
		});
	}
	
</script>
</body>
</html>