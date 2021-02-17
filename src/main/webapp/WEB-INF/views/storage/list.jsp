<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Lista Składników w Magazynie</h1>
<table border="1px" cellpadding="15px" cellspacing="0px">
    <thead>
    <tr>
        <th>Id:</th>
        <th>Quantity:</th>
        <th>Unit:</th>
        <th>Ingredient id:</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${storages}" var="storages">
        <tr>
            <td>${storages.id}</td>
            <td>${storages.quantity}</td>
            <td>${storages.unit}</td>
            <td>${storages.ingredient.id}</td>
            <td>
                <a href="<c:url value="/storage/edit/${storages.id}"/>">Edit</a> |
                <a href="<c:url value="/storage/delete/${storages.id}"/>">Delete</a>
            </td>
        </tr>
    </c:forEach>
    <tr>
        <td colspan="5">
            <a href="/storage/add"><button>+</button></a><em> Dodaj nowy składnik w magazynie</em>
        </td>
    </tr>
    </tbody>
</table>

</body>
</html>
