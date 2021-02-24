<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<%@ include file="../header.jsp" %>
<body>
<h1>${soi.operationType}|${soi.documentNumber}</h1>
<table border="1px" cellpadding="15px" cellspacing="0px">
    <thead>
    <tr>
        <th colspan="2">Numer dokumentu</th>
        <th>Typ dokumentu</th>
        <th colspan="3">Dostawca</th>
    </tr>
    </thead>
    <tbody>
        <tr>
            <td colspan="2">${soi.documentNumber}</td>
            <th>${soi.operationType}</th>
            <td colspan="3">${soi.supplier.name}</td>
        </tr>
    <tr>
        <td colspan="6">
            <a href="/admin/storageOperation/add/${soi.id}"><button>+</button></a><em> Dodaj nową pozycję do dokumentu</em>
        </td>
    </tr>
    <tr>
        <td>ID</td>
        <td>Produkt</td>
        <td>Ilość (KG / L / SZT)</td>
        <td>Cena jednostkowa</td>
        <td colspan="2">Akcja</td>
    </tr>
    <c:forEach items="${operations}" var="operation">
        <tr>
            <td>${operation.id}</td>
            <td>${operation.ingredient.name}</td>
            <td>${operation.quantity}</td>
            <td>${operation.unitPrice}</td>
            <td><a href="/admin/storageOperation/delete/${operation.id}">Usuń</a></td>
            <td><a href="/admin/storageOperation/edit/${operation.id}">Edytuj</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
<%@ include file="../footer.jsp" %>
</html>
