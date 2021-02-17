<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: robert
  Date: 16.02.2021
  Time: 15:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Wszyscy użytkownicy:</title>
</head>
<body>
<table border="1">
    <thead>

    <th>Id</th>
    <th>User Name</th>
    <th>Emial</th>
    <th>First Name</th>
    <th>Last Name</th>

    </thead>
    <tbody>
    <c:forEach items="${users}" var="user">
        <tr>
            <td><c:out value="${user.id}"/></td>
            <td><c:out value="${user.userName}"/></td>
            <td><c:out value="${user.email}"/></td>
            <td><c:out value="${user.firstName}"/></td>
            <td><c:out value="${user.lastName}"/></td>
            <td>
                <a href="<c:out value="/edit/${user.id}"/> ">Edit</a>
                <a href="<c:out value="/delete/${user.id}"/> ">Delete</a>

            </td>
        </tr>
    </c:forEach>
    <a href="<c:url value="/add?id=${user.id}"/>">Add new book</a>
    </tbody>
</table>
</body>
</html>
