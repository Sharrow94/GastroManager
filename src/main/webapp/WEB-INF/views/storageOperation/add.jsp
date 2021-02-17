<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Dodaj nowy posiłek</h1>
<form:form method="post" modelAttribute="storageOperation">
<table>
    <tr>Numer faktury:</tr>
    <tr>
        <form:input path="invoiceNumber"/>
    </tr>
    <tr>Dostawca</tr>
    <tr>
        <form:input path="supplier.name"/>
    </tr>
    <tr>Produkt</tr>
    <tr>
        <form:select path="ingredient" items="${ingredients}" itemLabel="name" itemValue="id" />
        <input type="submit">
    </tr>
</form:form>
</table>

</body>
</html>