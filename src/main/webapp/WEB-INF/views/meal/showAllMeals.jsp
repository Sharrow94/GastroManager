<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Lista Posiłków</h1>
<table border="1px" cellpadding="15px" cellspacing="0px">
    <thead>
        <tr>
            <th>id</th>
            <th>Name</th>
            <th>Action</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${meals}" var="meal">
            <tr>
                <td>${meal.id}</td>
                <td>${meal.name}</td>
                <td>
                    <a href="<c:url value="/meal/edit/${meal.id}"/>">Edit</a> |
                    <a href="<c:url value="/meal/delete/confirm/${meal.id}"/>">Delete</a> |
                    <a href="<c:url value="/meal/details/${meal.id}"/>">Details</a>
                </td>
            </tr>
        </c:forEach>
        <tr>
            <td colspan="3">
                <a href="/meal/add"><button>+</button></a><em> Dodaj nowy posiłek</em>
            </td>
        </tr>
    </tbody>
</table>

</body>
</html>
