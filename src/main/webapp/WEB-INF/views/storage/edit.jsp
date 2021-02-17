<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edit ingredient in storage:</title>
</head>
<body>
<form:form method="post" modelAttribute="storage" action="/storage/edit">
    <form:hidden path="id" items="${storage.id}"/>
    <table>
        <tr>
            <td>Quantity:</td>
            <td><form:input path="quantity" items="${storage.quantity}"/></td>
        </tr>
        <tr>
            <td>Unit:</td>
            <td><form:input path="unit" items="${storage.unit}"/><br></td>
        </tr>
        <tr>
            <td>IngredientId:</td>
            <td><form:input path="ingredient.id" items="${storage.ingredient}"/></td>
        </tr>

    </table>
    <input type="submit">
</form:form>
</body>
</html>