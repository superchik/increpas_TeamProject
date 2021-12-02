<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
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

<title>Insert title here</title>
<style>
#up {
	    width:1200px;
	    height:auto;
	    border-radius: 10px;
		border: 1px solid #6b7280;
		box-shadow: 1px 1.5px 8px 3px grey;
		background: #0d121c;
	    float: left;
	    

	}
	
	#left {
		display: block;
		float: left;
	}
	#poster {
		width:220px;
		height:280px;
	}
	#poster > img {
	width: 220px;
	height: 280px;
}
	#starring {
		width: 220px;
		height:auto;
		text-align: center;		
	}
		
	#right{
		width: 970px;
		display: block;
		position: relative;		
		float: left;
	}
	
	#content {
		width: 850px;
		padding-left: 50px;				
	}
	#rate_div {
		width: auto;
		height: 92px;
		text-align: center;	
		font-weight: bold;
		display: inline-block;
		padding-top: 80px;
	}
	#rate{
		width:481px;
		height: 90px;
		float: left;
		border: 1px solid #222;	
		background: #202a38;	
	}
	#rotten{
		width:481px;
		height:90px;
		float: left;
		border: 1px solid #222;	
		background: #202a38;	
	}
	
	#go {
		width:auto;
		height:auto;
	}	
	
	#write_div{
		width: 1050px;
		height:auto;
		float:left;
		display:block;
		padding-top: 80px;
		padding-left: 80px;
		padding-bottom: 40px;
	}
	table{
		width: 1200px;
	    font-size:14px;
	}
	#write_area{
		float: left;
		border: 2px solid #1f2937;
		border-radius: 10px;
	}
	
	
	
	.review_empty{height: 10px; }
	.title{font-size: 30px; font-weight: bold; }
	.starring1{font-size: 14px; font-weight: bold;}
	.starring2{font-size: 14px;}
	.about{font-size: 16px;}
	.story{font-size: 16px;}
	.story_div{ text-align:left;}
	.review_platfrom{
		display:block;
		width:80px;
		height:80px;
		border:1px solid #222;		
		float: left;
	}
	.review_platfrom > img{
		width:80px;
		height: 80px;
	}
	.review_num{
		font-size: 14px;
		float: left;
	}
	.point{
		font-size: 50px;
	}
	.write_nickname{
		float: left;
		font-size: 18px;
		font-weight: bold;
		padding-top: 30px;
		padding-right: 5px;
	}
	.write_star{
		float: left;
		padding-left: 10px;
	}
	.write_btn{
		float: left;
		padding-top: 10px;	
		padding-left: 20px;	
		
	}
	.re_btn{
		margin-left: 11px;
	    display: inline-block;
	    width: 80px;
	    height: 30px;
	    line-height: 30px;
	    border-radius: 7px;
	    border: 1px solid #6b7280;
		box-shadow: 2.5px 2.5px 2.5px 1px grey;
	}
	.list_nickname{
		width:15%;
		background-color: #151923;
	}
	.list_content{
		text-align:left;
		width:75%;
		padding: 15px 30px 30px 30px;
		background: #0e131d;
	}
	.list_recommend{
		width:10%;	
		padding-top: 30px;
		padding-bottom: 30px;
		background-color: #151923;
	}
	.list_nickname{
		font-size: 16px;
		font-weight: bold;
	}
	.list_level{
		font-size:12px;
	}
	.recommend_btn > img{
		width: 18px;
		height: 18px;
		font-size: 12px;
	}
	
	
	
	.star-rating {
  display: flex;
  flex-direction: row-reverse;
  font-size: 30px;
  line-height: 30px;
  justify-content: space-around;
  padding: 0 2px;
  text-align: center;
  width: 150px;
}
 
.star-rating input {
  display: none;
}
 
.star-rating label {
  -webkit-text-fill-color: transparent;
  -webkit-text-stroke-width: 2.3px;
  -webkit-text-stroke-color: gray;
  cursor: pointer;
}
 
.star-rating :checked ~ label {
  -webkit-text-fill-color: gold;
}
 
.star-rating label:hover,
.star-rating label:hover ~ label {
  -webkit-text-fill-color: #fff58c;
}

	
	
	
	
</style>
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
			<img src=${vo.POSTER }>
	</div>
	<div id="starring">
			<div>
				<a class="starring1">staff</a><br/>
				<a class="starring2">${vo.DIRECTOR }</a>
				<br/>
			</div>
			<div>
				<a class="starring1">cast</a><br/>
				<a class="starring2">${vo.CAST }</a>
			</div>
	</div>
	</div>
<div id="right">
	<div id="content">
		<a class="title">${vo.TITLE }</a><br/>
		<br/><br/>
		<div class="story_div">
		<a class="story">${vo.SUMMARY }</a>
		</div>
	</div>
	<div id="rate_div">
			<div id="rate">
			<a>평점</a><br/>
			<a class="point">?.?</a>
			</div>
			<div id="rotten">
			<a>Rotten Tomato</a>
			<br/>
			<c:if test = "${vo.ROTTEN_TOMATO ne null }">
			<a class="point">${vo.ROTTEN_TOMATO }</a>			
			</c:if>
			<c:if test = "${vo.ROTTEN_TOMATO eq null }">
			<a class="point">-</a>			
			</c:if>
			
			</div>
	</div>
	<div id="go">
		<c:if test="${vo.PLATFORM == 'WAVVE'}"> 
		<a><div class="review_platfrom"><img src="resources/images/wavve.png"></div></a>
		</c:if>
		<c:if test="${vo.PLATFORM == 'NETFLIX'}"> 
		<a><div class="review_platfrom"><img src="resources/images/netflix.png"></div></a>		
		</c:if>
		<c:if test="${vo.PLATFORM == 'WATCHA'}"> 		
		<a><div class="review_platfrom"><img src="resources/images/watcha.png"></div></a>		
		</c:if>
		
	</div>
</div>
</div>
<c:if test="${uvo ne null }">
<form action="/review" method="post">
	<div id="write_div">
		<a class="write_nickname">${uvo.u_id }</a>
		<textarea name="CONTENT" id="write_area" 
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
		<input type="hidden" name="OTT_IDX" value="${vo.OTT_IDX }">
		<input type="hidden" name="u_id" value="${uvo.u_id }"> 
		<input type="hidden" name="now_page" value="${vo.OTT_IDX }">
			<p class="write_btn">
				<button type="submit">리뷰등록</button>
			</p>
	</div>
</form>
</c:if>



		
		<table class="review_table">		
			<thead>
				<th><a class="review_num">댓글갯수:?</a></th>
			</thead>				
			<tbody>
			<!-- 반복문 -->
			
			
				<tr>
					<td class="list_nickname"> 
						<a class="list_nickname">글쓴이</a>
						<a class="list_level">LV1</a><br/>
						<a class="list_level">2021-11-16</a>
					</td>
					<td class="list_content">
						<a>★★★★☆</a><br/>
						<a></a>
					</td>
					<td class="list_recommend">
						<a>추천수:10</a><br/><br/>
						<div class="recommend_btn">
							<a>추천</a>  <img src="resources/images/squid_game.png">
						</div>
					</td>
				</tr>
			</tbody>
		</table>
	</div>	

<footer>
<!-- footer -->
<jsp:include page="common/footer.jsp"></jsp:include>
</footer>

<script>

</script>
</c:if>
</body>
</html>