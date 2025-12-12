<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="<c:url value='/resources/css/style.css'/>">

<div class="nav">
    <a href="<c:url value='/recruits'/>">ClubList</a>

    <div style="margin-left:auto;">
        <c:choose>
            <c:when test="${not empty sessionScope.user}">
                <span>${sessionScope.user.name} 님</span>
                <a href="<c:url value='/auth/logout'/>">로그아웃</a>
            </c:when>
            <c:otherwise>
                <a href="<c:url value='/auth/login'/>">로그인</a>
            </c:otherwise>
        </c:choose>
    </div>
</div>
<hr/>
