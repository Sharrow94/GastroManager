<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<%@ include file="../header.jsp" %>
<body>
<h1>Lista operacji na magazynie</h1>
<table border="1px" cellpadding="15px" cellspacing="0px">
    <thead>
    <tr>
        <th>id</th>
        <th>Numer dokumentu</th>
        <th>Typ dokumentu</th>
        <th>Dostawca</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${storageOperationItems}" var="sOi">
        <tr>
            <td>${sOi.id}</td>
            <td>${sOi.documentNumber}</td>
            <th>${sOi.operationType}</th>
            <td>${sOi.supplier.name}</td>
            <td>
                <a href="<c:url value="/sOi/edit/${sOi.id}"/>">Edit</a> |
                <a href="<c:url value="/sOi/delete/${sOi.id}"/>">Delete</a> |
                <a href="<c:url value="/sOi/details/${sOi.id}"/>">Details</a>
            </td>
        </tr>
    </c:forEach>
    <tr>
        <td colspan="3">
            <a href="/sOi/add/"><button>+</button></a><em> Dodaj nowy wpis</em>
        </td>
    </tr>
    </tbody>
</table>

</body>
<%@ include file="../footer.jsp" %>
</html>
