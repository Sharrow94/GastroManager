<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Dodaj dane o płatności za zamówienie:</title>
</head>
<%@ include file="../header.jsp" %>
<body>
<form:form method="post" modelAttribute="plansMeals" action="/orders/add/selectPlan/selectDay">
    <input type="hidden" name="plan" value="${plan.id}">
    <table>
        <tr>
            <td>Wybierz dzień tygodnia</td>
            <td><form:select path="weekDays" items="${weekDays}" itemLabel="name" itemValue="id"/></td>
        </tr>
        <tr>
            <td>Podaj ilość</td>
            <td><input type="number" name="quantity"></td>
        </tr>
    </table>
    <input type="submit">
</form:form>
</body>
<%@ include file="../footer.jsp" %>
</html>
