<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/views/common/header.jsp"/>

<h2>모집글 리스트</h2>

<div>
    <a href="<c:url value='/recruits?category=club'/>">동아리</a> |
    <a href="<c:url value='/recruits?category=study'/>">스터디</a> |
    <a href="<c:url value='/recruits'/>">전체</a>
</div>

<c:if test="${not empty sessionScope.user}">
    <p><a href="<c:url value='/recruits/add'/>">+ 모집글 작성</a></p>
</c:if>

<ul>
    <c:forEach var="r" items="${list}">
        <li>
            [${r.category}]
            <a href="<c:url value='/recruits/${r.id}'/>">${r.title}</a>
            - ${r.writerName}
        </li>
    </c:forEach>
</ul>
