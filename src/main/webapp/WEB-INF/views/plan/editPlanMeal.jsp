<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="container">

    <div class="card o-hidden border-0 shadow-lg my-5">
        <div class="card-body p-0">
            <!-- Nested Row within Card Body -->
            <div class="row">
                <div class="col-lg-5 d-none d-lg-block bg-register-image"></div>
                <div class="col-lg-7">
                    <div class="p-5">
                        <form:form modelAttribute="plansMeals" method="post" action="/admin/plan/meal/add">
                            <div class="text-center">
                                <h1 class="h4 text-gray-900 mb-4"><spring:message code="add.editPlanMeals"/></h1>
                            </div>
                            <input type="hidden" name="plan" value="${plan.id}">
                            <div class="form-group row">
                                <div class="col-sm-6 mb-3 mb-sm-0">
                                    <td><spring:message code="add.selectDish"/>:</td>
                                    <form:select path="meal" items="${meals}" itemLabel="name" itemValue="id"
                                                 class="form-control form-control-user"/>

                                </div>
                            </div>
                            <div class="form-group row">
                                <div class="col-sm-6 mb-3 mb-sm-0">
                                    <td><spring:message code="add.selectMeal"/>:</td>
                                    <form:select path="mealName" items="${mealNames}" itemLabel="name" itemValue="id"
                                                 class="form-control form-control-user"/>

                                </div>
                            </div>
                            <div class="form-group row">
                                <div class="col-sm-6 mb-3 mb-sm-0">
                                    <td><spring:message code="add.selectDays"/>:</td>
                                    <form:select path="weekDays" items="${weekDays}" itemLabel="name"
                                                 itemValue="id" class="form-control form-control-user"/>
                                </div>
                            </div>

                            <button type="submit" class="btn btn-primary btn-user btn-block">
                                <spring:message code="app.edit"/></button>
                        </form:form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>