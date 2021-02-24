<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:message code="add.costOrder" var="costOrder"/>
<spring:message code="app.input.giveCalories" var="giveCalories"/>
<spring:message code="app.plan.number" var="number"/>

<html>
<head>
    <title><spring:message code="app.order.editTitle"/></title>
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
                        <form:form method="post" modelAttribute="order" action="/admin/orders/edit">
                            <div class="text-center">
                                <h1 class="h4 text-gray-900 mb-4"><spring:message code="add.editOrder"/>:</h1>
                            </div>
                            <form:hidden path="id"/>
<%--                            <div class="form-group row">--%>
<%--                                <div class="col-sm-6 mb-3 mb-sm-0">--%>
<%--                                    <td><spring:message code="add.costOrder"/>:</td>--%>
<%--                                    <form:input path="quantity" placeholder="${costOrder}"--%>
<%--                                                class="form-control form-control-user"/>--%>

<%--                                </div>--%>
<%--                            </div>--%>
                            <div class="form-group row">
                                <div class="col-sm-6 mb-3 mb-sm-0">
                                    <td><spring:message code="add.costOrder"/>:</td>
                                    <form:input path="orderPrice" placeholder="${giveCalories}"
                                                class="form-control form-control-user"/>

                                </div>
                            </div>
                            <div class="form-group row">
                                <div class="col-sm-6 mb-3 mb-sm-0">
                                    <td><spring:message code="add.dateOperation"/>:</td>
                                    <form:input path="operationDate" type="datetime-local"
                                                class="form-control form-control-user"/>

                                </div>
                            </div>
                            <div class="form-group row">
                                <div class="col-sm-6 mb-3 mb-sm-0">
                                    <td><spring:message code="add.fromDate"/>:</td>
                                    <form:input path="fromDate" type="date"/>
                                </div>
                                <div class="col-sm-6 mb-3 mb-sm-0">
                                    <td><spring:message code="add.toDate"/>:</td>
                                    <form:input path="toDate" type="date"/>
                                </div>
                            </div>
                            <div class="form-group row">
                                <div class="col-sm-6 mb-3 mb-sm-0">
                                    <td><spring:message code="add.planId"/>:</td>
                                    <form:input path="plan.id" placeholder="${number}"
                                                class="form-control form-control-user"/>
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


<%--<form:form method="post" modelAttribute="order" action="/orders/edit">--%>
<%--    <form:hidden path="id"/>--%>
<%--    <table>--%>
<%--        <tr>--%>
<%--            <td>Ilość zamówień:</td>--%>
<%--            <td><form:input path="quantity"/></td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td>Cena zamówienia:</td>--%>
<%--            <td><form:input path="orderPrice"/></td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td>Data operacji:</td>--%>
<%--            <td><form:input path="operationDate" type="datetime-local"/></td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td>Data płatności od:</td>--%>
<%--            <td><form:input path="fromDate" type="date"/><br></td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td>Data płatności do:</td>--%>
<%--            <td>--%>
<%--                <form:input path="toDate" type="date"/>--%>
<%--            </td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td>Plan id:</td>--%>
<%--            <td><form:input path="plan.id"/></td>--%>
<%--        </tr>--%>

<%--    </table>--%>
<%--    <input type="submit">--%>
<%--</form:form>--%>

</body>
<%@ include file="../footer.jsp" %>
</html>
