<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Payments</title>
</head>
<%@ include file="../header.jsp" %>
<body>
<h1>Płatności:</h1>
<table border="1px" cellpadding="15px" cellspacing="0px">
    <thead>
    <tr>
        <th>Id:</th>
        <th>Cost:</th>
        <th>Data:</th>
        <th>Payments complete:</th>
        <th>Orders id:</th>
        <th>User id:</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${payments}" var="payments">
        <tr>
            <td>${payments.id}</td>
            <td>${payments.cost}</td>
            <td>${payments.date}</td>
            <td>${payments.payed}</td>
            <td>${payments.orders.id}</td>
            <td>${payments.users.id}</td>
            <td>
                <a href="<c:url value="/payments/edit/${payments.id}"/>">Edit</a> |
                <a href="<c:url value="/payments/delete/${payments.id}"/>">Delete</a>
            </td>
        </tr>
    </c:forEach>
    <tr>
        <td colspan="5">
            <a href="/payments/add"><button>+</button></a><em> Add new payment</em>
        </td>
    </tr>
    </tbody>
</table>

</body>
<%@ include file="../footer.jsp" %>
</html>
