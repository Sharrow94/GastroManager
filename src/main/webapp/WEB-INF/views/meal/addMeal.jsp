<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Dodaj nowy posiłek</h1>
<form:form method="post" modelAttribute="meal">
    <form:input path="name"/> Nazwa<br>
    <form:textarea path="description"/> Opis przyrządzenia<br>
    <form:select path="diet" itemLabel="name" items="${diets}"/>
    <input type="submit">
</form:form>

</body>
</html>
