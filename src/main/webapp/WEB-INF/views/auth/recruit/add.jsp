<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/views/common/header.jsp"/>

<h2>모집글 작성</h2>

<form method="post" action="<c:url value='/recruits/add'/>">
    <div><input name="title" placeholder="제목"/></div>
    <div>
        <select name="category">
            <option value="club">동아리</option>
            <option value="study">스터디</option>
        </select>
    </div>
    <div><textarea name="content" placeholder="내용"></textarea></div>
    <button type="submit">등록</button>
</form>
