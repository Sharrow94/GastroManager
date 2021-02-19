<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<%@ include file="../header.jsp" %>
<body>
<c:forEach items="${plans}" var="plan">
    <tr>
        <td>${plan.id}</td>
        <td>${plan.name}</td>
        <td>${plan.price}</td>
        <td>
            <a href="<c:url value="/plan/delete/${plan.id}"/>">usuń</a>
            <a href="<c:url value="/plan/edit/${plan.id}"/>">edit</a>
        </td>
    </tr>
</c:forEach>
</body>
<%@ include file="../footer.jsp" %>
</html>
