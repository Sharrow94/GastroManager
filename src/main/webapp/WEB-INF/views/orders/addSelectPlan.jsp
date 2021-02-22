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
<form method="post">
    <table>
        <tr>
            <td>Wybierz plan:</td>
            <td><select name="id">
                <c:forEach items="${plans}" var="plan">
                    <option id="${plan.id}">${plan.name}</option>
                </c:forEach>
            </select></td>
        </tr>
    </table>
    <input type="submit">
</form>
</body>
<%@ include file="../footer.jsp" %>
</html>
