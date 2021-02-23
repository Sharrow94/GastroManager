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
<c:forEach items="${ingredients}" var="ingredient">
    <tr>
        <td>${ingredient.id}</td>
        <td>${ingredient.name}</td>
        <td>${ingredient.calories}</td>
        <td>
            <a href="<c:url value="/admin/ingredient/delete/${ingredient.id}"/>">usuń</a>
            <a href="<c:url value="/admin/ingredient/edit/${ingredient.id}"/>">edit</a>
        </td>
    </tr>
</c:forEach>
</body>
<%@ include file="../footer.jsp" %>
</html>