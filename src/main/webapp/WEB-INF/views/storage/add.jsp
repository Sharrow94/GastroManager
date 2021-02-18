
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Dodaj składnik w Magazynie:</title>
</head>
<%@ include file="../header.jsp" %>
<body>
<form:form method="post" modelAttribute="storage">
    <table>
        <tr>
            <td>Ilość:</td>
            <td><form:input path="quantity" /></td>
        </tr>
        <tr>
            <td>Jednostka:</td>
            <td><form:input path="unit" /><br></td>
        </tr>
        <tr>
            <td>Id składnika:</td>
            <td><form:input path="ingredient.id" /></td>
        </tr>

    </table>
    <input type="submit">
</form:form>
</body>
<%@ include file="../footer.jsp" %>
</html>
