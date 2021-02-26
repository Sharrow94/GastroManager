<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<spring:message code="app.plan.giveName" var="giveName"/>
<spring:message code="app.payments.giveNumber" var="giveNumber"/>
<spring:message code="app.storage.giveCity" var="giveCity"/>
<spring:message code="app.storage.givePostCode" var="givePostCode"/>
<spring:message code="app.storage.giveStreet" var="giveStreet"/>

<html>
<head>
    <title>Add Supplier</title>
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
                        <form:form method="post" modelAttribute="ingredient" >
                            <div class="text-center">
                                <h1 class="h4 text-gray-900 mb-4"> <spring:message code="add.details"/></h1>
                            </div>
                            <div class="form-group row">
                                <div class="col-sm-6 mb-3 mb-sm-0">
                                    <td><spring:message code="app.name"/>:</td>
                                    <h3>${ingredient.name}</h3>
                                </div>
                            </div>
                            <div class="form-group row">
                                <div class="col-sm-6 mb-3 mb-sm-0">
                                    <td><spring:message code="add.calories"/>:</td>
                                    <h3>${ingredient.calories}</h3>
                                </div>
                            </div>
                            <div class="form-group row">
                                <div class="col-sm-6 mb-3 mb-sm-0">
                                    <td><spring:message code="add.unitPrice"/>:</td>
                                    <h3>${ingredient.unitPrice}</h3>
                                </div>
                            </div>
                            <div class="form-group row">
                                <div class="col-sm-6 mb-3 mb-sm-0">
                                    <td><spring:message code="add.currentQuantity"/></td>
                                    <h3>${ingredient.currentQuantity}</h3>
                                </div>
                                <div class="col-sm-6 mb-3 mb-sm-0">
                                    <td><spring:message code="add.unit"/></td>
                                    <h3>${ingredient.unit}</h3>
                                </div>
                            </div>
                            <div class="form-group row">
                                <div class="col-sm-6 mb-3 mb-sm-0">
                                    <td><spring:message code="add.hasLactose"/>:</td>
                                    <h3>${ingredient.hasLactose}</h3>
                                </div>
                            </div>
                            <div class="form-group row">
                                <div class="col-sm-6 mb-3 mb-sm-0">
                                    <td><spring:message code="add.hasMeat"/>:</td>
                                    <h3>${ingredient.hasMeat}</h3>
                                </div>
                            </div>
                            <div class="form-group row">
                                <div class="col-sm-6 mb-3 mb-sm-0">
                                    <td><spring:message code="add.hasMeat"/>:</td>
                                    <h3>${ingredient.hasMeat}</h3>
                                </div>
                            </div>
                            <div style="margin-top: 10px">
                                <a href="/admin/ingredient/all" class="btn btn-primary btn-user btn-block">
                                    <spring:message code="app.back"/></a>
                            </div>
                        </form:form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
<%@ include file="../footer.jsp" %>
</html>
