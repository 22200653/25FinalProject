<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/views/common/header.jsp"/>

<h2>로그인</h2>

<c:if test="${param.msg == 'fail'}">
    <p class="error">로그인 실패</p>
</c:if>

<form method="post" action="<c:url value='/auth/login'/>">
    <div><input name="userid" placeholder="userid"/></div>
    <div><input type="password" name="password" placeholder="password"/></div>
    <button type="submit">로그인</button>
</form>
