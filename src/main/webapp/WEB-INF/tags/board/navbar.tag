<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<c:url value="/board/list" var="listUrl"></c:url>
<c:url value="/board/register" var="registerUrl"></c:url>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<ul class="navbar-nav mr-auto">
		<li class="nav-item active"><a href="${listUrl }" class="nav-link">목록</a></li>
		<li class="nav-item active"><a href="${registerUrl }" class="nav-link">글쓰기</a></li>
	</ul>
</nav>