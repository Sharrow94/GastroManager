<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Dodaj składnik</title>
</head>
<body>
<div>Edycja składnika:${ingredient.name}</div>
<form:form method="post" modelAttribute="ingredient" action="/ingredient/update">
    <table>
        <form:hidden path="id"/>
        <tr>
            <td>Name:</td>
            <td><form:input path="name"/></td>
        </tr>
        <tr>
            <td>Calories:</td>
            <td><form:input path="calories"/><br></td>
        </tr>
        <tr>
            <td>Koszt jednostkowy:</td>
            <td><form:input path="unitPrice"/></td>
        </tr>
        <tr>
            <td>Zawiera gluten:</td>
            <td><form:checkbox path="hasGluten" value="true"/>Zawiera</td>
        </tr>
        <tr>
            <td>Zawiera laktozę:</td>
            <td><form:checkbox path="hasLactose" value="true"/>Zawiera</td>
        </tr>
        <tr>
            <td>Zawiera mięso:</td>
            <td><form:checkbox path="hasMeat" value="true"/>Zawiera</td>
        </tr>
    </table>
    <input type="submit">
</form:form>
</body>
</html>
