<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Title</title>
</head>
<%@ include file="../header.jsp" %>
<body>
<h1>Danie: ${meal.name}</h1>
<h3>Dieta: ${meal.diet.name}</h3>

<h2>Składniki:</h2>
<ul>
    <c:forEach items="${meal.ingredientsMeals}" var="im">
        <li>${im.ingredient.name} | ilość ${im.quantity} |
            <a href="<c:url value="/meal/ingredient/edit/${im.id}"/>"><spring:message code="app.edit"/> </a> |
            <a href="<c:url value="/meal/ingredient/delete/${im.id}"/>"><spring:message code="app.delete"/> </a>
        </li>
    </c:forEach>
    <a href="<c:url value="/admin/meal/ingredient/add/${meal.id}"/>">Dodaj nowy składnik</a>

    </ul>
    <h2>Sposób przygotowania</h2>
    ${meal.description}<br><br>
    cena: ${meal.price}<br>

    <a href="<c:url value="/app/meal/list"/>">Powrót do listy</a>
</body>
<%@ include file="../footer.jsp" %>
</html>
