<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<c:url value="/board/list" var="listUrl"></c:url>
<c:url value="/board/register" var="registerUrl"></c:url>
<c:url value="/member/signup" var="signupUrl"></c:url>
<c:url value="/member/login" var="loginUrl"></c:url>
<c:url value="/member/logout" var="logoutUrl"></c:url>
<c:url value="/member/info" var="memberInfoUrl"></c:url>
<c:url value="/member/list" var="memberListUrl"></c:url>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<ul class="navbar-nav mr-auto">
		<li class="nav-item active"><a href="${listUrl }" class="nav-link">목록</a></li>
		<li class="nav-item active"><a href="${registerUrl }" class="nav-link">글쓰기</a></li>
		<c:if test="${empty sessionScope.loggedInMember }">
			<li class="nav-item active"><a href="${signupUrl }" class="nav-link">회원가입</a></li>
			<li class="nav-item active"><a href="${loginUrl }" class="nav-link">로그인</a></li>
		</c:if>
		<c:if test="${not empty sessionScope.loggedInMember }">
			<li class="nav-item active"><a href="${memberInfoUrl }" class="nav-link">회원정보보기</a></li>
			<li class="nav-item active"><a href="${memberListUrl }" class="nav-link">회원목록보기</a></li>
			<li class="nav-item active"><a href="${logoutUrl }" class="nav-link">로그아웃</a></li>
		</c:if>
	</ul>
</nav>