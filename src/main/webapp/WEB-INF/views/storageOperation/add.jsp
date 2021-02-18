<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Dodaj nową operację</h1>
<form:form method="post" modelAttribute="storageOperation">
<table>
    <tr>Numer faktury:</tr><br>
    <tr>
        <form:input path="invoiceNumber"/><br>
    </tr>
    <tr>Dostawca</tr><br>
    <tr>
        <form:select path="supplier" items="${suppliers}" itemLabel="name" itemValue="id" /><br>
    </tr>
    <tr>Produkt</tr><br>
    <tr>
        <form:select path="ingredient" items="${ingredients}" itemLabel="name" itemValue="id" /><br>
        <input type="submit">
    </tr>
</form:form>
</table>

</body>
</html>