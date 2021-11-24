<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="nav_menu">

	<nav class="clearfix">
		<ul class="clearfix">
			<li><span><a href="/">Logo</a></span></li>
			<li><span><a href="/bbs">전체</a></span></li>
			<li>
				<form class="search_form" action="/search" method="POST">
					<input class="search_movie" type="text" id="s_movie" name="s_movie"
						placeholder="영화검색(테스트용)">
				</form>
			</li>
			<li>
			<c:if test="${empty uvo }">
				<span><a href="/login">
					로그인 / 회원가입
				</a></span>
			</c:if>
			<c:if test="${!empty uvo }">
				<span><a href="/logout">
					로그아웃
				</a></span>
			</c:if>
			</li>
		</ul>
	</nav>

</div>

<!--  

-->