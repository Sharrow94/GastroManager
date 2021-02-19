 <%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<%@ include file="../header.jsp" %>
<body>
<table border="1px" cellpadding="15px" cellspacing="0px">
    <thead>
    <tr>
        <th>id</th>
        <th>Name</th>
        <th>Price</th>
        <th>FoodCost</th>
        <th>Dieta</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <sec:authorize access="hasRole('USER')">
    <c:forEach items="${plans}" var="plan">
        <tr>
            <td>${plan.id}</td>
            <td>${plan.name}</td>
            <td>${plan.price}</td>
            <td>${plan.foodCostTotal}</td>
            <td>${plan.diet.name}</td>
            <td>

            </td>
        </tr>
    </c:forEach>
    </sec:authorize>
    <sec:authorize access="hasRole('ADMIN')">
    <c:forEach items="${plans}" var="plan">
        <tr>
            <td>${plan.id}</td>
            <td>${plan.name}</td>
            <td>${plan.price}</td>
            <td>${plan.foodCostTotal}</td>
            <td>${plan.diet.name}</td>
            <td>
                <a href="<c:url value="/plan/edit/${plan.id}"/>">Edit</a> |
                <a href="<c:url value="/plan/delete/${plan.id}"/>">Delete</a> |
                <a href="<c:url value="/plan/${plan.id}"/>">Details</a>
            </td>
        </tr>
    </c:forEach>
    <tr>
        <td colspan="6">
            <a href="/plan/add"><button>+</button></a><em> Dodaj nowy plan</em>
        </td>
    </tr>
    </sec:authorize>
    </tbody>
</table>

</body>
<%@ include file="../footer.jsp" %>
</html>
