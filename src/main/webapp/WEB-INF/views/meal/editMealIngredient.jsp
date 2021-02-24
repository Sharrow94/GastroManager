<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:message code="add.enterQuantity" var="enterQuantity"/>
<html>
<head>
    <title>Title</title>
</head>
<%@ include file="../header.jsp" %>
<body>
<div class="container">

    <div class="card o-hidden border-0 shadow-lg my-5">
        <div class="card-body p-0">
            <!-- Nested Row within Card Body -->
            <div class="row">
                <div class="col-lg-5 d-none d-lg-block bg-register-image"></div>
                <div class="col-lg-7">
                    <div class="p-5">
                        <form:form modelAttribute="ingredientsMeals" action="/admin/meal/ingredient/edit" method="post">
                            <div class="text-center">
                                <h1 class="h4 text-gray-900 mb-4">
                                    <spring:message code="add.editMealIngredients"/> <spring:message code="app.from"/> ${ingredientsMeals.meal.name}</h1>
                                <form:hidden path="id"/>
                                <input type="hidden" value="${meal.id}" name="meal">
                            </div>
                            <div class="form-group row">
                                <div class="col-sm-6 mb-3 mb-sm-0">
                                    <td><spring:message code="add.selectIngrediends"/>:</td>
                                    <form:select path="ingredient" items="${ingredients}"
                                                 itemLabel="name" itemValue="id"
                                                 class="form-control form-control-user"/>
                                </div>
                            </div>
                            <div class="form-group row">
                                <div class="col-sm-6 mb-3 mb-sm-0">
                                    <td><spring:message code="add.enterQuantity"/>:</td>
                                    <form:input path="quantity" placeholder="${enterQuantity}"
                                                class="form-control form-control-user"/>
                                </div>
                            </div>

                            <button type="submit" class="btn btn-primary btn-user btn-block">
                                <spring:message code="add.editMealIngredients"/></button>
                        </form:form>
                    </div>
                </div>
            </div>
        </div>
    </div>

<%--<h1>Edytuj składnik z ${ingredientsMeals.meal.name}</h1>--%>
<%--&lt;%&ndash;<h1>Edytuj Składnik</h1>&ndash;%&gt;--%>
<%--<form:form modelAttribute="ingredientsMeals" action="/meal/ingredient/edit" method="post">--%>

<%--    <form:hidden path="id"/>--%>
<%--    <input type="hidden" value="${meal.id}" name="meal">--%>

<%--    Wybierz składnik:--%>
<%--    <form:select path="ingredient" items="${ingredients}"  itemLabel="name" itemValue="id"/><br>--%>
<%--    Podaj Ilość:--%>
<%--    <form:input path="quantity"/><br>--%>
<%--    <input type="submit" value="edytuj">--%>

<%--</form:form>--%>

</body>
<%@ include file="../footer.jsp" %>
</html>
