<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions" %>    
<%@page import="com.ott.review.vo.ReviewVO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- CSS 공통화 -->
<link rel="stylesheet" type="text/css" href="resources/css/common/common.css">
<link rel="stylesheet" type="text/css" href="resources/css/common/footer.css">
<!-- main CSS -->
<link rel="stylesheet" type="text/css" href="resources/css/main/main.css">
<link rel="stylesheet" type="text/css" href="resources/css/main/review.css">

<title>Review</title>

</head>
<body>

<!-- Header -->
<jsp:include page="common/header.jsp"></jsp:include>

<c:if test="${vo ne null }">
<div class="common_container">
	<!-- 여기다 작업하세요 -->
<div id="up">
<div class="review_empty"></div>	
<div id="left">
	<div id="poster">
			<img src=${vo.poster }>
	</div>
	<div id="starring">
			<div>
				<a class="starring1">staff</a><br/>
				<a class="starring2">${vo.director }</a>
				<br/>
			</div>
			<div>
				<a class="starring1">cast</a><br/>
				<a class="starring2">${vo.cast }</a>
			</div>
	</div>
	</div>
<div id="right">
	<div id="content">
		<a class="title">${vo.title }</a><br/>
		<br/><br/>
		<div class="story_div">
		<a class="story">${vo.summary }</a>
		</div>
	</div>
	<div id="rate_div">
			<div id="rate">
			<a>평점</a><br/>
			<c:if test="${r_cnt > 0 }">
				<a class="point">${rating }</a>
			</c:if>
			
			<c:if test="${r_cnt <= 0 }">
				<a class="point">-</a>
			</c:if>
			</div>
			<div id="rotten">
			<a>Rotten Tomato</a>
			<br/>
			<c:if test = "${vo.rotten_tomato ne null }">
			<a class="point">${vo.rotten_tomato }</a>			
			</c:if>
			<c:if test = "${vo.rotten_tomato eq null }">
			<a class="point">-</a>			
			</c:if>
			
			</div>
	</div>
	<div id="go">
		<c:if test="${vo.platform == 'WAVVE'}"> 
		<a><div class="review_platfrom"><img src="resources/images/wavve.png"></div></a>
		</c:if>
		<c:if test="${vo.platform == 'NETFLIX'}"> 
		<a><div class="review_platfrom"><img src="resources/images/netflix.png"></div></a>		
		</c:if>
		<c:if test="${vo.platform == 'WATCHA'}"> 		
		<a><div class="review_platfrom"><img src="resources/images/watcha.png"></div></a>		
		</c:if>
		
	</div>
</div>
</div>
<c:if test="${uvo ne null }">
<form action="/review" method="post" name="frm">
	<div id="write_div">
		<a class="write_nickname">${uvo.u_id }</a>
		<textarea name="content" id="write_area" 
			cols="100" rows="5"></textarea>
		<div class="write_star">
		<div class="star-rating space-x-4 mx-auto">
		<input type="radio" id="5-stars" name="rating" value="5" v-model="ratings"/>
		<label for="5-stars" class="star pr-4">★</label>
		<input type="radio" id="4-stars" name="rating" value="4" v-model="ratings"/>
		<label for="4-stars" class="star">★</label>
		<input type="radio" id="3-stars" name="rating" value="3" v-model="ratings"/>
		<label for="3-stars" class="star">★</label>
		<input type="radio" id="2-stars" name="rating" value="2" v-model="ratings"/>
		<label for="2-stars" class="star">★</label>
		<input type="radio" id="1-star" name="rating" value="1" v-model="ratings" />
		<label for="1-star" class="star">★</label>
		</div>
		</div>
		<br/>
		<br/>
		<input type="hidden" name="ott_idx" value="${vo.ott_idx }">
		<input type="hidden" name="u_id" value="${uvo.u_id }"> 
		<input type="hidden" name="now_page" value="${vo.ott_idx }">
			<p class="write_btn">
				<input type="button" class="review_add" value="리뷰등록" onclick="review_add()"/>
			</p>
	</div>
</form>
</c:if>

			<c:if test="${r_cnt > 0 }">
				<a class="review_num">리뷰 개수 : ${r_cnt }</a>			
			</c:if>
			
			<c:if test="${r_cnt <= 0 }">
				<a class="review_num">작성된 리뷰가 하나도 없네요!</a>			
			</c:if>
		<table class="review_table">		
							
			<!-- 반복문 -->
			<tbody>
				<c:forEach var="rvo" items="${rvo }">
					<tr>
						<td class="list_nickname"> 
							<a class="list_nickname">${rvo.u_id }</a>
							<a class="list_level">LV1</a><br/>
							<a class="list_level">
							<c:set var="review_date_var" value="${rvo.r_date }"/>
							<c:set var="review_date" value="${f:substring(review_date_var,0,16)}"/>
							${review_date }
							</a>
						</td>
						<td class="list_content">
							<c:if test="${rvo.rating eq 1}">	
							<a>★☆☆☆☆</a><br/><br/>
							</c:if>					
							<c:if test="${rvo.rating eq 2}">	
							<a>★★☆☆☆</a><br/><br/>
							</c:if>					
							<c:if test="${rvo.rating eq 3}">	
							<a>★★★☆☆</a><br/><br/>
							</c:if>					
							<c:if test="${rvo.rating eq 4}">	
							<a>★★★★☆</a><br/><br/>
							</c:if>					
							<c:if test="${rvo.rating eq 5}">	
							<a>★★★★★</a><br/><br/>
							</c:if>
							<a>${rvo.content }</a>
						</td>
						<td class="list_recommend">
						
							<span class="like_text_area">
								<a href="#"><i class="far fa-thumbs-up"></i></a>
									<span>0</span>
							</span>
							<br/><br/>
							<span class="like_text_area">
								<a href="#"><i class="far fa-thumbs-down"></i></a>
									<span>999999</span>
							</span>
							<div class="recommend_btn">
								<!-- <a>추천</a>  <img src="resources/images/squid_game.png"> -->
							</div>
						</td>
						<td class="review_edit_btn">
						<c:if test="${uvo.u_id eq rvo.u_id}">
							<p>
								<input type="button" class="review_edit" value="수정" onclick=""/>
								<br/><br/>
								<input type="button" class="review_edit" value="삭제" onclick=""/>
							</p>
						</c:if>
						</td>
					</tr>
				</c:forEach>
			</tbody>
			<tfoot>
				
				<td colspan="4" >
                	${pageCode }
                </td>
				
                     
			</tfoot>
		</table>
	</div>	

<footer>
<!-- footer -->
<jsp:include page="common/footer.jsp"></jsp:include>
</footer>


<script>
	function review_add(){	
		if(document.frm.content.value.trim().length < 1){
			alert("내용을 입력하세요");
			return;
		}		
		if(document.frm.rating.value < 1){
			alert("평점을 입력하세요");
			return;
		}	
		document.frm.submit();	
	}
</script>
</c:if>
</body>
</html>