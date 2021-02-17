<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Edit Supplier</title>
</head>
<body>

<div>Edit:${supplier.name}</div>
<form:form method="post" modelAttribute="supplier" action="/supplier/edit">
    <form:hidden path="id" items="${supplier.id}"/>
    <p>Name:</p>
    <form:input path="name" items="${supplier.name}"/>
    <p>Phone number:</p>
    <form:input path="phoneNumber" items="${supplier.phoneNumber}" />
    <p>City:</p>
    <form:input path="city" items="${supplier.city}" />
    <p>Street:</p>
    <form:input path="street" items="${supplier.street}" />
    <p>Nr:</p>
    <form:input path="nr" items="${supplier.nr}"/>
    <p>Post Number:</p>
    <form:input path="postNumber" items="${supplier.postNumber}"/>
    <input type="submit" value="Update">
</form:form>
</body>
</html>