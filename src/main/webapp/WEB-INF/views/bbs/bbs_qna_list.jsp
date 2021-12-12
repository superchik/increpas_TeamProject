<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>  
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
<link rel="stylesheet" type="text/css" href="resources/css/BBS/qna_list.css">
<title>Insert title here</title>

<style type="text/css">

</style>
</head>
<body>

	<!-- Header -->
	<jsp:include page="../common/header.jsp"></jsp:include>

	<div class="common_container">
		<h2>QNA 게시판</h2>
		<div id="bbs_qna">
			<table summary="게시판 목록">
				<caption>게시판 목록</caption>
				<thead>
					<tr class="title">
						<th class="no">번호</th>
						<th class="subject">제목</th>	<!-- 제목 옆에 열쇠 아이콘을 넣어서 공개범위표시 -->
						<th class="u_idx">글쓴이</th>
						<th class="write_date">날짜</th>
						<th class="hit">조회수</th>
					</tr>
				</thead>

				<tfoot>
					<tr>
						<td colspan="4">${pageCode }</td>
						<td><input type="button" value="글쓰기"
							onclick="javascript:location.href='/QNA.write'" />
						</td>
					</tr>
				</tfoot>
				<tbody>
					<c:forEach var="vo" items="${ar }" varStatus="st">
						<tr>
							<td>
								<%--순차적인 번호를 만들어서 표현하자! --%>
								${rowTotal-((nowPage-1)*blockList+st.index) }
							</td>
							<td style="text-align: left"><a
								href="QNA.view?rb_idx=${vo.rb_idx }&cPage=${nowPage}">
									${vo.subject } 
							<c:if test="${fn:length(vo.c_list) > 0}">
								(${fn:length(vo.c_list)})
							</c:if> 
							</a></td>
							<td>${vo.u_name}</td>
							<td>${vo.write_date }</td>
							<td>${vo.hit }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>

		</div>

	</div>

	<!-- footer -->
	<jsp:include page="../common/footer.jsp"></jsp:include>


</body>
</html>