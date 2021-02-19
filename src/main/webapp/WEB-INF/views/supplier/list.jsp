<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Supplier All List</title>
</head>
<%@ include file="../header.jsp" %>
<body>

<table>
    <tr>
        <th>Id:</th>
        <th>Name:</th>
        <th>Phone number:</th>
        <th>City:</th>
        <th>Street:</th>
        <th>Nr:</th>
        <th>Post Number:</th>
<%--        <th>Action:</th>--%>

    </tr>
    <c:forEach items="${suppliers}" var="supplier">
        <tr>
            <td><c:out value="${supplier.id}"/></td>
            <td><c:out value="${supplier.name}"/></td>
            <td><c:out value="${supplier.phoneNumber}"/></td>
            <td><c:out value="${supplier.city}"/></td>
            <td><c:out value="${supplier.street}"/></td>
            <td><c:out value="${supplier.nr}"/></td>
            <td><c:out value="${supplier.postNumber}"/></td>
            <td>
                <a href="<c:url value="/supplier/delete/${supplier.id}"/>">Delete</a>
                <a href="<c:url value="/supplier/edit/${supplier.id}"/>">Edit</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
<%@ include file="../footer.jsp" %>
</html>
