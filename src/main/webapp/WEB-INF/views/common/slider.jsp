<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

	<!-- 전체를 감싸줄 영역 - container -->
	<div class="container">
		<!-- 아이템 영역 --> 
		<div class="slider_items">
		<!-- Test 영역  -->
		
			<!-- 아이템 -->
			<div class="slide_item">
				<c:forEach var="vo" items="${mvo }">
			<div style="color: white;">
				<span>${vo.movieNm}</span>
				<span>${vo.prdtStatNm}</span>
				<span><fmt:parseDate value="${vo.openDt }" var ="opendate" pattern="yyyyMMdd" /></span>
				<span><fmt:formatDate value="${opendate }" pattern="yyyy/MM/dd" /></span>
				<span>${vo.genreAlt}</span>
				<span>${vo.repGenreNm}</span>
			</div>
		</c:forEach>
			</div>
			<div class="slide_item"></div>
			<div class="slide_item"></div>
			<div class="slide_item"></div>
			<div class="slide_item"></div>		
			<div class="slide_item"></div>		
		</div>
		<!-- end of slider_items -->
	
	<!-- 다음 버튼 -->
	<!--   <button type="button" class="nextButton">▶</button>-->
	<!-- 이전 버튼 -->
	<!-- <button type="button" class="prevButton">◀</button>-->
	
	
	
   </div>
   <!-- end of container -->