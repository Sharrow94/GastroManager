<%--
  Created by IntelliJ IDEA.
  User: maciej
  Date: 17.02.2021
  Time: 11:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Edytuj pozycję</h1>
<form:form modelAttribute="storageOperation" action="/storageOperation/update" method="post">
    <form:hidden path="storageOperationItem"></form:hidden>
    <form:hidden path="id"></form:hidden>
    Wybierz składnik:<form:select path="ingredient" items="${ingredients}"  itemLabel="name" itemValue="id"/><br>
    Podaj ilość<form:input path="quantity"/><br>
    Podaj cenę jednostkową<form:input path="unitPrice"/><br>
    <input type="submit" value="Edytuj">
</form:form>

</body>
</html>
