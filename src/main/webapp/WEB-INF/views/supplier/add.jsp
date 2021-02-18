<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Add Supplier</title>
</head>
<body>
<form:form method="post" modelAttribute="supplier" >

    <p>Name:</p>
    <form:input path="name"/>
    <p>Phone number:</p>
    <form:input path="phoneNumber"  />
    <p>City:</p>
    <form:input path="city"  />
    <p>Street:</p>
    <form:input path="street" />
    <p>Nr:</p>
    <form:input path="nr"/>
    <p>Post Number:</p>
    <form:input path="postNumber"/>
    <input type="submit" value="Update">
</form:form>

</body>
</html>