<%--
  Created by IntelliJ IDEA.
  User: maciej
  Date: 18.02.2021
  Time: 22:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Dodaj pozycję do dokumentu</h1>
<form:form modelAttribute="storageOperation" action="/storageOperation/add" method="post">
    <input type="hidden" value="${sOi.id}" name="storageOperationItem"/>
    Wybierz składnik:<form:select path="ingredient" items="${ingredients}"  itemLabel="name" itemValue="id"/><br>
    Podaj ilość<form:input path="quantity"/><br>
    Podaj cenę jednostkową<form:input path="unitPrice"/><br>
    <input type="submit" value="dodaj">
</form:form>

</body>
</html>
