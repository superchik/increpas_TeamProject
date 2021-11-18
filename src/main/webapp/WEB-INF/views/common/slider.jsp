<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="now" value="<%=new java.util.Date() %>"/>
	<!-- 전체를 감싸줄 영역 - container -->
	<div class="container">
		<!-- 아이템 영역 --> 
		<div class="slider_items">
		<!-- Test 영역  -->
		
			<!-- 아이템 -->
			<div class="slide_item">
				<c:forEach var="vo" items="${mvo }">
					<c:if test="${vo.openDt > 20211115 && vo.openDt < 20211201 }">
						<div style="color:white; margin-left: 50px; margin-right: 70px; margin-bottom: 20px; width: 30%; float: left; text-align: center; border: 1px solid black; border-radius: 5px;
									background-color: black; padding: 10px;">
							<div style="display:inline; float: left;">${vo.movieNm}</div>
							<div style="display:inline; text-align: center; margin: 0 auto; padding: 0">${vo.repGenreNm}</div>
							
							<fmt:parseDate value="${vo.openDt }" var ="opendate" pattern="yyyyMMdd" />
							<fmt:formatDate value="${now }" pattern="yyyyMMdd" var="today"/>
							<fmt:formatDate value="${opendate }" pattern="yyyyMMdd" var="open"/>
							<c:if test="${(open - today) > 0 }">
								<div style="display:inline; text-align: center; float: right;">D-${open - today }</div>
							</c:if>
							<c:if test="${(open - today) <= 0 }">
								<div style=" display:inline; text-align: center; float: right;">개봉</div>
							</c:if>
						</div>
					</c:if>
				</c:forEach>
			</div>
			<div class="slide_item">
				<div style="float: right; border: 5px solid black; background-color: black; border-radius: 20px;
							margin-top: 5px;">
					<span style="color:white;">개봉 예정</span>
				</div>
			</div>
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