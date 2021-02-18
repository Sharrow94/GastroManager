<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form modelAttribute="plansMeals" method="post" action="/plan/meal/edit">
    <form:hidden path="id"/>
    <input type="hidden" name="plan" value="${plan.id}"><br>
<%--    Wybierz Danie: <form:select path="meal" items="${meals}" itemLabel="name" itemValue="id"/><br>--%>
    Wybierz danie:
    <select name="meal">
        <c:forEach items="${meals}" var="meal">
            <option value="${meal.id}">${meal.name}</option>
        </c:forEach>
    </select><br>
    Wybierz Posiłek: <form:select path="mealName" items="${mealNames}" itemLabel="name" itemValue="id"/><br>
    Wybierz Dzień: <form:select path="weekDays" items="${weekDays}" itemLabel="name" itemValue="id"/><br>
    <input type="submit" value="Edytuj">
</form:form>

</body>
</html>