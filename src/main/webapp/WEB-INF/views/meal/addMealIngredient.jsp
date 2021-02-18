<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<%@ include file="../header.jsp" %>
<body>
<%--<h1>Dodaj Składniki do ${ingredientsMeals.meal.name}</h1>--%>
<h1>Dodaj Składniki</h1>
<form:form modelAttribute="ingredientsMeals" action="/meal/ingredient/add" method="post">
    <input type="hidden" value="${meal.id}" name="meal"/>
    Wybierz składnik:<form:select path="ingredient" items="${ingredients}"  itemLabel="name" itemValue="id"/><br>
    Podaj Ilość<form:input path="quantity"/><br>
    <input type="submit" value="dodaj">
</form:form>

</body>
<%@ include file="../footer.jsp" %>
</html>
