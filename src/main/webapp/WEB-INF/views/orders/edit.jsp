<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edytuj dane o płatności za zamówienie:</title>
</head>
<body>
<form:form method="post" modelAttribute="order" action="/orders/edit">
    <form:hidden path="id"/>
    <table>
        <tr>
            <td>Ilość zamówień:</td>
            <td><form:input path="quantity"/></td>
        </tr>
        <tr>
            <td>Cena zamówienia:</td>
            <td><form:input path="orderPrice"/></td>
        </tr>
        <tr>
            <td>Data operacji:</td>
            <td><form:input path="operationDate" type="datetime-local"/></td>
        </tr>
        <tr>
            <td>Data płatności od:</td>
            <td><form:input path="fromDate" type="date"/><br></td>
        </tr>
        <tr>
            <td>Data płatności do:</td>
            <td>
                <form:input path="toDate" type="date"/>
            </td>
        </tr>
        <tr>
            <td>Plan id:</td>
            <td><form:input path="plan.id"/></td>
        </tr>

    </table>
    <input type="submit">
</form:form>
</body>
</html>
