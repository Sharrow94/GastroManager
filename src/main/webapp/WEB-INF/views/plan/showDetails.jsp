<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<%@ include file="../header.jsp" %>
<body>
<h1>Nazwa Planu: ${plan.name}</h1>
<h3>Dieta: ${plan.diet.name}</h3>

<h2>Posilki:</h2>
<%--    <c:forEach items="${plan.plansMeals}" var="pm">--%>
<%--        ${pm.meal.name} | ${pm.weekDays.name} | ${pm.mealName.name} |--%>
<%--        <a href="<c:url value="/plan/meal/edit/${pm.id}"/>">Edytuj</a>--%>
<%--        <a href="<c:url value="/plan/meal/delete/${pm.id}"/>">Usuń</a> <br>--%>
<%--    </c:forEach><br><br>--%>

<table border="1px" cellpadding="15px" cellspacing="0px">
    <thead>
    <tr>
        <th>Dish Name</th>
        <th>Weekday</th>
        <th>Meal Name</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${plan.plansMeals}" var="pm">
        <tr>
            <td>${pm.meal.name}</td>
            <td>${pm.weekDays.name}</td>
            <td>${pm.mealName.name}</td>
            <td>
                <a href="<c:url value="/plan/meal/edit/${pm.id}"/>">Edytuj</a> |
                <a href="<c:url value="/plan/meal/delete/${pm.id}"/>">Usuń</a>
            </td>
        </tr>
    </c:forEach>
    <tr>
        <td colspan="4">
            <a href="<c:url value="/plan/meal/add/${plan.id}"/>"><button>+</button></a><em> Dodaj posiłek do planu</em>
        </td>
    </tr>
    </tbody>
</table>

<h3>Łączna cena:</h3>
<b>${plan.foodCostTotal}zł</b>

<h3>Ustalona cena:</h3>
<b>${plan.price}zł</b>
</body>
<%@ include file="../footer.jsp" %>
</html>
