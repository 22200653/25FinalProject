<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/views/common/header.jsp"/>

<h2>지원서 목록 (recruitId=${recruitId})</h2>

<ul>
    <c:forEach var="a" items="${list}">
        <li>${a.applicantName} : ${a.message} (${a.createdAt})</li>
    </c:forEach>
</ul>

<p><a href="<c:url value='/recruits/${recruitId}'/>">상세로 돌아가기</a></p>
