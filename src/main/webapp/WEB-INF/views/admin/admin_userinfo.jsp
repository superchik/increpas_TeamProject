<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- CSS 공통화 -->
<link rel="stylesheet" type="text/css" href="resources/css/common/common.css">
<link rel="stylesheet" type="text/css" href="resources/css/common/footer.css">
<!-- main CSS -->
<link rel="stylesheet" type="text/css" href="resources/css/main/main.css">
<!-- paging_admin CSS  -->
<link rel="stylesheet" type="text/css" href="resources/css/admin/paging_admin.css">
	<title>Insert title here</title>
	<style>
		
	.user_board{
		display: inline-block;
	    position: static;
	    border: 1px solid #6b7280;
	    background-color: #1f2937;
	    box-shadow: 1px 1.5px 8px 3px grey;
	    border-radius: 10px;

	}
	
	span {
   		    float: left;
    color: white;
    margin-bottom: 20px;
	}
	table{
			width : auto;
			border: solid 1px gray;
		    border-spacing: 0px;
		    border-style: none;
		    padding: 0px;
	}
	table thead{
		background-color: #4C4C4C;
		color: white;
	    display: table-header-group;
	    vertical-align: middle;
	    border-color: inherit;
	}
	table tbody{
	    display: table-row-group;
	    vertical-align: middle;
	    border-color: inherit;
	}
	tbody>tr {
    	color: white;
	}
	tr {
	    display: table-row;
	    vertical-align: inherit;
	    border-color: inherit;
	}
	.user_search_ta{
	    background-color: white;
   	    border: 1px solid black;
	}
	.user_search_btn{
	    background-color: gray;
  	    color: black;
  	    border-radius: 6px;
	}
	.user_search_btn:active {
    box-shadow: inset -2px -2px 3px rgba(255, 255, 255, .6),
           inset 2px 2px 3px rgba(0, 0, 0, .6);

	}
	</style>
</head>
<body>

<!-- Header -->
<jsp:include page="../common/header.jsp"></jsp:include>

<div class="common_container">
	<div class="user_board">
		<h1>회원관리 게시판</h1>
		<h2>회원 검색</h2>
		<div>
			<span>회원 검색</span>
				<input class="user_search_ta" type="text" name="user_search_ta"/>
				<input class="user_search_btn" type="button" name="user_search_btn" value="검색"/>
		</div>
		<table summary="회원 목록">
			<caption>
				<span>총 회원수 : ${rowTotal }명</span>
			</caption>
			<colgroup>
				<col width="80x">
				<col width="150px">
				<col width="150px">
				<col width="100px">
				<col width="100px">
				<col width="100px">
				
			
			</colgroup>
			<!-- 게시판 상단영역 -->
			<thead>
				<tr>
					<th>번호</th>
					<th>u_idx</th>
					<th>아이디</th>
					<th>이름</th>
					<th>이메일</th>
					
				</tr>
			</thead> 
			
			<!-- 게시판 바디영역 -->
			<tbody>
			<c:forEach var="vo" items="${ar }" varStatus="st">
				<tr>
					<td> <%--순차적인 번호를 만들어서 표현하자! --%>
						${rowTotal-((nowPage-1)*blockList+st.index) }
					</td>
					<td>${vo.u_idx }</td>
					<td>${vo.u_id }</td>
					<td>${vo.u_name }</td>
					<td>${vo.u_email }</td>
					
				</tr>
			</c:forEach>
			<!-- 게시판 풋터영역 -->
			<tfoot>
                      <tr>
                          <td colspan="10">
                              ${pageCode }
                          </td>
                      </tr>
            </tfoot>
			</tbody>
		</table>
		
	</div>
	
</div>

<!-- footer -->
<jsp:include page="../common/footer.jsp"></jsp:include>


</body>
</html>