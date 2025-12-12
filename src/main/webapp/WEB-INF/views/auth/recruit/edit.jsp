<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/views/common/header.jsp"/>

<h2>모집글 수정</h2>

<form method="post" action="<c:url value='/recruits/${recruit.id}/edit'/>">
    <div><input name="title" value="${recruit.title}"/></div>
    <div>
        <select name="category">
            <option value="club" ${recruit.category=='club'?'selected':''}>동아리</option>
            <option value="study" ${recruit.category=='study'?'selected':''}>스터디</option>
        </select>
    </div>
    <div><textarea name="content">${recruit.content}</textarea></div>
    <button type="submit">수정 저장</button>
</form>
