<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Dodaj składnik</title>
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
                        <form:form method="post" modelAttribute="ingredient" action="/admin/ingredient/update">
                            <div class="text-center">
                                <h1 class="h4 text-gray-900 mb-4"><spring:message code="add.editIngredient"/>
                                    :${ingredient.name}</h1>
                            </div>
                            <form:hidden path="id"/>
                            <div class="form-group row">
                                <div class="col-sm-6 mb-3 mb-sm-0">
                                    <td><spring:message code="add.names"/>:</td>
                                    <form:input path="name" placeholder="Napisz nazwe Składniku"
                                                class="form-control form-control-user"/>
                                </div>
                            </div>
                            <div class="form-group row">
                                <div class="col-sm-6 mb-3 mb-sm-0">
                                    <td><spring:message code="add.calories"/>:</td>
                                    <form:input path="calories" placeholder="Ilość kalorii"
                                                class="form-control form-control-user"/>
                                </div>
                            </div>
                            <div class="form-group row">
                                <div class="col-sm-6 mb-3 mb-sm-0">
                                    <td><spring:message code="add.unitPrice"/>:</td>
                                    <form:input path="unitPrice" placeholder="Podaj cene"
                                                class="form-control form-control-user"/>
                                </div>
                            </div>
                            <div class="form-group row">
                                <div class="col-sm-6 mb-3 mb-sm-0">
                                    <td><spring:message code="add.hasGluten"/>:</td>
                                    <form:checkbox path="hasGluten" value="true"/>
                                </div>
                                <div class="col-sm-6 mb-3 mb-sm-0">
                                    <td><spring:message code="add.hasLactose"/>:</td>
                                    <form:checkbox path="hasGluten" value="true"/>
                                </div>
                                <div class="col-sm-6 mb-3 mb-sm-0">
                                    <td><spring:message code="add.hasMeat"/>:</td>
                                    <form:checkbox path="hasGluten" value="true"/>
                                </div>
                            </div>

                            <button type="submit" class="btn btn-primary btn-user btn-block">
                                <spring:message code="app.add"/></button>
                        </form:form>
                    </div>
                </div>
            </div>
        </div>
    </div>

<%--<div>Edycja składnika:${ingredient.name}</div>--%>
<%--<form:form method="post" modelAttribute="ingredient" action="/ingredient/update">--%>
<%--    <table>--%>
<%--        <form:hidden path="id"/>--%>
<%--        <tr>--%>
<%--            <td>Name:</td>--%>
<%--            <td><form:input path="name"/></td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td>Calories:</td>--%>
<%--            <td><form:input path="calories"/><br></td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td>Koszt jednostkowy:</td>--%>
<%--            <td><form:input path="unitPrice"/></td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td>Zawiera gluten:</td>--%>
<%--            <td><form:checkbox path="hasGluten" value="true"/>Zawiera</td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td>Zawiera laktozę:</td>--%>
<%--            <td><form:checkbox path="hasLactose" value="true"/>Zawiera</td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td>Zawiera mięso:</td>--%>
<%--            <td><form:checkbox path="hasMeat" value="true"/>Zawiera</td>--%>
<%--        </tr>--%>
<%--    </table>--%>
<%--    <input type="submit">--%>
<%--</form:form>--%>
</body>
<%@ include file="../footer.jsp" %>
</html>
