<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Title</title>
</head>
<%@ include file="../header.jsp" %>
<body>
<h1>Czy na pewno chcesz usunąć?</h1>
<a href="/admin/meal/delete/${id}"><button><spring:message code="app.yes"/></button></a>
<a href="/app/meal/list"><button><spring:message code="app.no"/></button></a>

</body>
<%@ include file="../footer.jsp" %>
</html>
