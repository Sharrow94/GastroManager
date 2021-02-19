<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Dodaj nową operację na magazynie</h1>
<form:form method="post" modelAttribute="sOi">
    <form:input path="documentNumber"/>Numer dokumentu<br>
    <select name="operationType">
        <option value="WZ">WZ</option>
        <option value="PZ">PZ</option>
    </select>
    <form:select path="supplier" items="${suppliers}" itemLabel="name" itemValue="id" />
    <input type="submit">
</form:form>

</body>
</html>

