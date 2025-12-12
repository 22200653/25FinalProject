<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/views/common/header.jsp"/>

<h2>${recruit.title}</h2>
<p>카테고리: ${recruit.category}</p>
<p>작성자: ${recruit.writerName}</p>
<hr/>
<pre>${recruit.content}</pre>

<hr/>
<c:if test="${not empty sessionScope.user}">
    <form method="post" action="<c:url value='/recruits/${recruit.id}/applications'/>">
        <textarea name="message" placeholder="지원 메시지"></textarea>
        <button type="submit">지원하기</button>
    </form>
</c:if>

<p>
    <a href="<c:url value='/recruits/${recruit.id}/applications'/>">지원서 목록 보기</a>
</p>

<c:if test="${not empty sessionScope.user && sessionScope.user.id == recruit.writerUserId}">
    <a href="<c:url value='/recruits/${recruit.id}/edit'/>">수정</a>
    <form method="post" action="<c:url value='/recruits/${recruit.id}/delete'/>" style="display:inline;">
        <button type="submit" onclick="return confirm('삭제할까요?');">삭제</button>
    </form>
</c:if>
