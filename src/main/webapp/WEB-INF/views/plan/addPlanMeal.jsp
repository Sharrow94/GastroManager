<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form modelAttribute="plansMeals" method="post" action="/plan/meal/add">
    <input type="hidden" name="plan" value="${plan.id}">
    Wybierz Danie: <form:select path="meal" items="${meals}" itemLabel="name" itemValue="id"/><br>
    Wybierz Posiłek: <form:select path="mealName" items="${mealNames}" itemLabel="name" itemValue="id"/><br>
    Wybierz Dzień: <form:select path="weekDays" items="${weekDays}" itemLabel="name" itemValue="id"/><br>
    <input type="submit" value="Dodaj">
</form:form>

</body>
</html>
