<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- CSS 공통화 -->
<link rel="stylesheet" type="text/css" href="resources/css/common/common.css">
<link rel="stylesheet" type="text/css" href="resources/css/common/footer.css">
<!-- main CSS -->
<link rel="stylesheet" type="text/css" href="resources/css/main/main.css">
<!-- bbs_qna CSS -->
<link rel="stylesheet" type="text/css" href="resources/css/BBS/qna_common.css">
<link rel="stylesheet" type="text/css" href="resources/css/BBS/qna_view.css">
<title>Insert title here</title>

<style type="text/css">


</style>
</head>
<body>

	<!-- Header -->
	<jsp:include page="../common/header.jsp"></jsp:include>

	<div class="common_container">
		<h2>QNA 게시판</h2>


		<c:if test="${q_vo ne null }">
			<div id="bbs_qna">
				<form method="post">
					<table summary="게시판 보기">
						<caption>게시판 글 보기</caption>
						<tbody>
							<tr>
								<th>제목:</th>
								<td>${q_vo.subject }</td>
							</tr>
							<tr>
								<th>이름:</th>
								<td>${u_vo.u_name }</td>
							</tr>
							<tr>
								<th>내용:</th>
								<td><textarea class="content_ta" readonly="readonly">${q_vo.content }</textarea></td>
							</tr>

							<tr>
								<td colspan="2">
								<input type="button" value="수정" onclick="edit()"/>
								<input type="button" value="삭제" onclick="del()"/>
								
								</td>
							</tr>
						</tbody>
					</table>
				</form>
				<form method="post" action="ans_write.inc">
					<table>
						<tbody>
							<tr>
								<th>관리자:</th>
								<td><input type="hidden" name="om_idx" /> 
						  			<input type="text" name="om_id" /> 
						  		</td>
							</tr>
							<tr>
								<th>내용:</th>
								<td>
									<textarea id="c_content_ta" rows="4" cols="55" name="c_content"></textarea>
						  		</td>
							</tr>
							<tr>
								<td colspan="2">
								<input type="submit" value="저장" onclick=""/>
								</td>
							</tr>
						</tbody>
					</table>
					
					<br /> 

					<%-- 원글을 의미하는 원글의 기본키 --%>
					<input type="hidden" name="rb_idx" value="${q_vo.rb_idx }"> <input
						type="hidden" name="cPage" value="${cPage }">
					<%--  ans_write.jsp에서 
					댓글을 저장한 후 다시 view.jsp로 돌아올 때 필요하다. 
					 <input type="hidden" name="ip" value="${ip }"> 
					 <input type="submit" value="저장하기" />  --%>
				</form>
				<p />
				답변
				<hr />
				<c:forEach var="c_vo" items="${vo.c_list }">
					<div>
						이름:${c_vo.u_idx } &nbsp;&nbsp; 날짜:${c_vo.write_date }<br />
						내용:${c_vo.c_content }
					</div>
					<hr />
				</c:forEach>
			</div>

			<form name="frm" method="post">
				<input type="hidden" name="cPage" value="${param.cPage }"> <input
					type="hidden" name="rb_idx" value="${q_vo.rb_idx }"> <input
					type="hidden" name="bname" value="${q_vo.bname }" />
			</form>
			<!-- footer -->
			<jsp:include page="../common/footer.jsp"></jsp:include>
			<script>
				function edit() {

					document.frm.action = "/QNA.edit";
					document.frm.submit();
				}

			 	function goList() {
					
					document.frm.action = "/QNA.list";
					document.frm.submit();
				} 

				function del() {

					if (confirm("삭제하시겠습니까?")) {

						document.frm.action = "/QNA.delete";
						document.frm.submit();
					}
				}

			</script>
		</c:if>
		<c:if test="${q_vo eq null }">
			<script>
				location.href = "/QNA.list";
			</script>
		</c:if>
</body>
</html>