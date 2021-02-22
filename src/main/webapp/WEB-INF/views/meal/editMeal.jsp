<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<%@ include file="../header.jsp" %>
<body>
<h1>Edytuj ${meal.name}</h1>
<form:form method="post" modelAttribute="meal" action="/admin/meal/edit">
    <form:hidden path="id"/>
    <form:hidden path="diet"/>
    <form:hidden path="price"/>
    <form:input path="name"/> Nazwa<br>
    <form:textarea path="description"/> Opis przyrządzenia<br>
    <input type="submit">
</form:form>

</body>
<%@ include file="../footer.jsp" %>
</html>
