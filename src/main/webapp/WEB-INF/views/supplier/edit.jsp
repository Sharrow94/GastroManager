<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
    <title>Edit ingredient in storage:</title>
</head>
<%@ include file="../header.jsp" %>
<body>
<form:form method="post" modelAttribute="payment" action="/storage/edit">
    <form:hidden path="id" />
    <table>
        <tr>
            <td>Quantity:</td>
            <td><form:input path="quantity"/></td>
        </tr>
        <tr>
            <td>Unit:</td>
            <td><form:input path="unit" /><br></td>
        </tr>
        <tr>
            <td>IngredientId:</td>
            <td><form:input path="ingredient.id" /></td>
        </tr>

    </table>
    <input type="submit">
</form:form>
</body>
<%@ include file="../footer.jsp" %>
</html>