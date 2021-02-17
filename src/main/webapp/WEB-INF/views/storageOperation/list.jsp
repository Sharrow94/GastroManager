<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Lista Operacji</h1>
<table border="1px" cellpadding="15px" cellspacing="0px">
    <thead>
    <tr>
        <th>Dostawca</th>
        <th>Numer faktury</th>
        <th>Składnik</th>
        <th>Data</th>
        <th>Typ operacji</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${storageOperations}" var="storageOperation">
        <tr>
            <td>${storageOperation.supplier.name}</td>
            <td>${storageOperation.invoiceNumber}</td>
            <td>${storageOperation.ingredient.name}</td>
            <td>Tu będzie data</td>
            <td>${storageOperation.operationType}</td>
            <td>
                <a href="<c:url value="/storageOperation/edit/${storageOperation.id}"/>">Edit</a> |
                <a href="<c:url value="/storageOperation/delete/${storageOperation.id}"/>">Delete</a>
            </td>
        </tr>
    </c:forEach>
    <tr>
        <td colspan="5">
            <a href="/storageOperation/add"><button>+</button></a><em> Dodaj nowy wpis</em>
        </td>
    </tr>
    </tbody>
</table>

</body>
</html>