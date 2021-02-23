
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edit supplier:</title>
</head>
<%@ include file="../header.jsp" %>
<body>
<form:form method="post" modelAttribute="supplier" action="/admin/supplier/edit">
    <form:hidden path="id"/>
    <table>
        <tr>
            <td>Name:</td>
            <td><form:input path="name"/></td>
        </tr>
        <tr>
            <td>Phone number:</td>
            <td><form:input path="phoneNumber" type="datetime-local"/><br></td>
        </tr>
        <tr>
            <td>City:</td>
            <td><form:checkbox path="city" value=""/>Payed</td>
        </tr>
        <tr>
            <td>Street:</td>
            <td><form:input path="street"/></td>
        </tr>
        <tr>
            <td>Nr:</td>
            <td><form:input path="nr"/></td>
        </tr>
        <tr>
            <td>Post Number:</td>
            <td><form:input path="postNumber"/></td>
        </tr>
    </table>
    <input type="submit">
</form:form>
</body>
<%@ include file="../footer.jsp" %>
</html>