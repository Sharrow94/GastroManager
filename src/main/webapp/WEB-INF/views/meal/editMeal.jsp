<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Edytuj ${meal.name}</h1>
<form:form method="post" modelAttribute="meal" action="/meal/edit">
    <form:hidden path="id"/>
    <form:input path="name"/> Nazwa<br>
    <form:textarea path="description"/> Opis przyrządzenia<br>
    <input type="submit">
</form:form>

</body>
</html>
