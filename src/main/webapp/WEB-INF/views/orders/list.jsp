<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Orders</title>
</head>
<%@ include file="../header.jsp" %>
<body>
<h1>Zamówienia:</h1>
<table border="1px" cellpadding="15px" cellspacing="0px">
    <thead>
    <tr>
        <th>Id:</th>
        <th>Ilość zamówień:</th>
        <th>Płatność za zamówienie:</th>
        <th>Data operacji:</th>
        <th>Data zamówienia od:</th>
        <th>Data zamówienia do:</th>
        <th>Plan id:</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${orders}" var="orders">
        <tr>
            <td>${orders.id}</td>
            <td>${orders.quantity}</td>
            <td>${orders.orderPrice}</td>
            <td>${orders.operationDate}</td>
            <td>${orders.fromDate}</td>
            <td>${orders.toDate}</td>
            <td>${orders.plan.id}</td>
            <td>
                <a href="<c:url value="/orders/edit/${orders.id}"/>">Edycja</a> |
                <a href="<c:url value="/orders/delete/${orders.id}"/>">Usuń</a>
            </td>
        </tr>
    </c:forEach>
    <tr>
        <td colspan="5">
            <a href="/orders/add"><button>+</button></a><em> Dodaj nowe dane o płatności za zamówienie</em>
        </td>
    </tr>
    </tbody>
</table>

</body>
<%@ include file="../footer.jsp" %>
</html>
