<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<html>
<head>
    <title>Edit ingredient in storage:</title>
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
                        <form:form method="post" modelAttribute="payment" action="/admin/storage/edit">
                            <div class="text-center">
                                <h1 class="h4 text-gray-900 mb-4"> <spring:message code="app.supplireEdit"/></h1>
                            </div>
                            <div class="form-group row">
                                <div class="col-sm-6 mb-3 mb-sm-0">
                                    <td><spring:message code="add.enterQuantity"/></td>
                                    <form:input path="quantity" placeholder="Podaj ilość" class="form-control form-control-user"/>

                                </div>
                            </div>
                            <div class="form-group row">
                                <div class="col-sm-6 mb-3 mb-sm-0">
                                    <td><spring:message code="app.unit"/></td>
                                    <form:input path="unit"  placeholder="Podaj jednostke"
                                                class="form-control form-control-user"/>

                                </div>
                            </div>
                            <div class="form-group row">
                                <div class="col-sm-6">
                                    <td><spring:message code="app.ingredientId"/></td>
                                    <form:input path="ingredient.id" placeholder="Podaj składnik"
                                                class="form-control form-control-user"/>
                                </div>


                            <button type="submit" class="btn btn-primary btn-user btn-block">
                                <spring:message code="add.addPayments"/></button>
                        </form:form>
                    </div>
                </div>
            </div>
        </div>
    </div>


<%--<form:form method="post" modelAttribute="payment" action="/storage/edit">--%>
<%--    <form:hidden path="id" />--%>
<%--    <table>--%>
<%--        <tr>--%>
<%--            <td>Quantity:</td>--%>
<%--            <td><form:input path="quantity"/></td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td>Unit:</td>--%>
<%--            <td><form:input path="unit" /><br></td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td>IngredientId:</td>--%>
<%--            <td><form:input path="ingredient.id" /></td>--%>
<%--        </tr>--%>

<%--    </table>--%>
<%--    <input type="submit">--%>
<%--</form:form>--%>
</body>
<%@ include file="../footer.jsp" %>
</html>