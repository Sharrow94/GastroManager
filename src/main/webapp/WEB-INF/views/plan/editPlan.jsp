<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edytuj plan</title>
</head>
<%@ include file="../header.jsp" %>
<body>
<div>Edycja planu:${plan.name}</div>
<form:form method="post" modelAttribute="plan" action="/admin/plan/update">
    <table>
        <form:hidden path="id"/>
        <tr>
            <td>Name:</td>
            <td><form:input path="name"/></td>
        </tr>
        <tr>
            <td>Cena:</td>
            <td><form:input path="price"/><br></td>
        </tr>
    </table>
    <input type="submit">
</form:form>
</body>
<%@ include file="../footer.jsp" %>
</html>

