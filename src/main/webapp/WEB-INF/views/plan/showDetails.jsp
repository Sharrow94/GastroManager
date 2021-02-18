<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Nazwa Planu: ${plan.name}</h1>
<h2>Posilki:</h2>
    <c:forEach items="${plan.plansMeals}" var="pm">
        ${pm.meal.name} | ${pm.weekDays.name} | ${pm.mealName.name} |
        <a href="<c:url value="/plan/meal/edit/${pm.id}"/>">Edytuj</a>
        <a href="<c:url value="/plan/meal/delete/${pm.id}"/>">Usuń</a> <br>
    </c:forEach><br><br>
<a href="<c:url value="/plan/meal/add/${plan.id}" />">Dodaj posiłek do planu</a><br>
cena: ${plan.price}
</body>
</html>
