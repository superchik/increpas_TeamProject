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
<form method="post" name=frm>
<div class="edit_back">
	<textarea name="content" id="write_area" 
			cols="100" rows="5">${rvo.content }</textarea>
			<input type="button" class="review_edit" value="수정" onclick="review_edit()"/>
</div>
</form>
</div>
<script>
	
</script>
</body>
</html>