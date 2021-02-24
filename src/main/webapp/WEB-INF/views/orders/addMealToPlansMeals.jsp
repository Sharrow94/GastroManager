<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:message code="app.addToCart" var="addToCart"/>

<html>
<head>
    <title>Dodaj dane o płatności za zamówienie:</title>
</head>
<%@ include file="../header.jsp" %>
<body>
<div class="container-fluid">
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary"><spring:message code="add.mealMenu"/></h6>
        </div>
        <table class="table table-bordered dataTable" id="dataTable" width="100%" cellspacing="0"
               role="grid" aria-describedby="dataTable_info" style="width: 100%;">
            <thead>
            <tr role="row">
                <th class="sorting" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1"
                    aria-label="Position: activate to sort column ascending" style="width:400px;">
                    <spring:message code="app.name"/></th>
                <th class="sorting_asc" tabindex="0" aria-controls="dataTable" rowspan="1"
                    colspan="1" aria-sort="ascending"
                    aria-label="Name: activate to sort column descending" style="width: 60px;">
                    Dieta
                </th>
                <th class="sorting" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1"
                    aria-label="Position: activate to sort column ascending" style="width:400px;">
                    Ilość
                </th>
                <th class="sorting" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1"
                    aria-label="Salary: activate to sort column ascending" style="width: 250px;">
                    <spring:message code="app.action"/></th>
            </thead>
            <tfoot>
            <tr>
                <th rowspan="1" colspan="1"><spring:message code="app.name"/></th>
                <th rowspan="1" colspan="1"><spring:message code="app.diet"/></th>
                <th rowspan="1" colspan="1"><spring:message code="app.quantity"/></th>
                <th rowspan="1" colspan="1"><spring:message code="app.action"/></th>
            </tr>
            </tfoot>
            <tbody>
            <c:forEach items="${meals}" var="meal">
                <tr role="row" class="odd">
                    <td><c:out value="${meal.name}"/></td>
                    <td><c:out value="${meal.diet.name}"/></td>
                    <form:form name="form${meal.id}" modelAttribute="plansMeals" action="/app/orders/addCart/mealName/meal"
                               method="post">
                        <input type="hidden" name="mealName" value="${mealName.id}">
                        <input type="hidden" name="meal" value="${meal.id}">
                        <td>
                            <div style="max-width: 70px;">
                                <input class="form-control form-control-user" type="number" min="0" name="quantity">
                            </div>
                        </td>
                        <td>
                            <input type="submit" class="btn btn-primary"
                                   style="background-color:#f6c23e; border-color:#f6c23e;color:#3a3b45; size: auto"
                                   value="${addToCart}">
                        </td>
                    </form:form>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <a href='<c:url value="/home"/>'
           class="btn btn-primary"
           style="background-color:#f6c23e; border-color:#f6c23e;color:#3a3b45; size: auto"><spring:message code="app.dashboard"/> </a>
    </div>
</div>
</body>
<%@ include file="../footer.jsp" %>
</html>
