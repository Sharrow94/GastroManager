<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Dodaj dane o płatności za zamówienie:</title>
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
                        <div class="text-center">
                            <h1 class="h4 text-gray-900 mb-4">${user.firstName} ${user.lastName}</h1>
                            <h1 class="h5 text-gray-800 mb-4">Zamówienie nr #${payment.orders.id}</h1>
                        </div>
                        <div class="row">
                            <div class="col-md-12">
                                <div class="card card-header-actions shadow border-primary">
                                    <div class="card-header">
                                            <span class="text-gray-900">
                                                Data: ${payment.orders.operationDate}zł
                                            </span>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <br><br>

                        <c:forEach items="${payment.orders.orderMeals}" var="shoppingItem">
                            <c:if test="${!orderTypeMeal.equals(shoppingItem.getOrderType())}">
                                <c:set var="index"
                                       value="${payment.orders.orderMeals.indexOf(shoppingItem)}"/>
                                <div class="card card-collapsable shadow">
                                    <a class="card-header" href="#collapseCardMeal${index}" data-toggle="collapse"
                                       role="button" aria-expanded="false" aria-controls="collapseCardMeal${index}">
                                        <span class="text-gray-900">
                                                <div class="row">
                                                    <div class="col-md-7">
                                                            ${shoppingItem.name}
                                                    </div>
                                                    <div class="col-md-2">
                                                            x${shoppingItem.quantity}
                                                    </div>
                                                    <div class="col-md-3">
                                                            ${shoppingItem.price} zł
                                                    </div>
                                                </div>
                                        </span>
                                        <div class="card-collapsable-arrow">
                                            <i class="fas fa-chevron-down" style="color: #333333;"></i>
                                        </div>
                                    </a>
                                    <div class="collapse" id="collapseCardMeal${index}">
                                        <div class="card-body">
                                            <c:forEach items="${shoppingItem.plansMeals}" var="pm">
                                                <div class="form-group row">
                                                    <div class="col-sm-10 mb-3 mb-sm-0">
                                                            ${pm.meal.name}
                                                    </div>
                                                    <div class="col-sm-2 mb-3 mb-sm-0">
                                                            ${pm.meal.price} zł
                                                    </div>
                                                </div>
                                            </c:forEach>

                                        </div>
                                    </div>
                                </div>

                                <%--                                <table>--%>
                                <%--                                <tr>--%>
                                <%--                                    <th>${shoppingItem.name}</th>--%>
                                <%--                                </tr>--%>
                                <%--                                    <c:forEach items="${shoppingItem.plansMeals}" var="pm">--%>
                                <%--                                        <tr>--%>
                                <%--                                            <td>${pm.meal.name}</td>--%>
                                <%--                                        </tr>--%>
                                <%--                                    </c:forEach>--%>
                                <%--                                </table>--%>
                            </c:if>
                            <c:if test="${orderTypeMeal.equals(shoppingItem.getOrderType())}">
                                <div class="card card-header-actions shadow">
                                    <div class="card-header">
                                            <span class="text-gray-900">
                                                <div class="row">
                                                    <div class="col-md-11">
                                                        <div class="form-group row">
                                                            <div class="col-md-7">
                                                                    ${shoppingItem.name}
                                                            </div>
                                                            <div class="col-md-2">
                                                                    x${shoppingItem.quantity}
                                                            </div>
                                                            <div class="col-md-3">
                                                                    ${shoppingItem.price} zł
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-1">
                                                    </div>
                                                </div>
                                            </span>
                                    </div>
                                </div>
                            </c:if>
                        </c:forEach>
                        <br><br>
                        <%--                            <div class="form-group row">--%>
                        <%--                                <div class="col-sm-6 mb-3 mb-sm-0">--%>
                        <%--                                    <td>Od:</td>--%>
                        <%--                                    ${payment.orders.toDate}--%>
                        <%--                                </div>--%>
                        <%--                                <div class="col-sm-6 mb-3 mb-sm-0">--%>
                        <%--                                    <td>Do:</td>--%>
                        <%--                                    ${payment.orders.toDate}--%>
                        <%--                                </div>--%>
                        <%--                            </div>--%>

                        <div class="row">
                            <div class="col-md-6">
                                <div class="card card-header-actions shadow border-warning">
                                    <div class="card-header">
                                            <span class="text-gray-900">
                                                Od ${payment.orders.fromDate}
                                            </span>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="card card-header-actions shadow border-warning">
                                    <div class="card-header">
                                            <span class="text-gray-900">
                                                Do ${payment.orders.toDate}
                                            </span>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <br><br>
                        <div class="row">
                            <div class="col-md-4">
                                <div class="card card-header-actions shadow border-primary">
                                    <div class="card-header">
                                            <span class="text-gray-900">
                                                Łączna cena: ${payment.summaryPrice}zł
                                            </span>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <c:if test="${payment.payed}">
                                    <div class="card card-header-actions shadow border-success text-success">
                                        <div class="card-header">
                                            Status: Zapłacony
                                        </div>
                                    </div>
                                </c:if>
                                <c:if test="${!payment.payed}">
                                    <div class="card card-header-actions shadow border-danger text-danger">
                                        <div class="card-header">
                                            Status: Nie zapłacony
                                        </div>
                                    </div>
                                </c:if>
                            </div>
                            <div class="col-md-4">
                                <div class="card card-header-actions shadow border-primary">
                                    <div class="card-header">
                                            <span class="text-gray-900">
                                                Dzienna cena: ${payment.orders.orderPrice}zł
                                            </span>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <br><br>

                        <a href="<c:url value="/app/user/${user.id}/orders/all"/> "
                           class="btn btn-primary btn-user btn-block">
                            Powrót <sec:authorize access="hasRole('ADMIN')">do zamówień ${user.email}</sec:authorize>
                        </a>
                        <sec:authorize access="hasRole('ADMIN')">
                            <a href="<c:url value="/admin/orders/all"/> "
                               class="btn btn-primary btn-user btn-block">
                                Powrót na liste wszystikich zamówień
                            </a>
                        </sec:authorize>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
<%@ include file="../footer.jsp" %>
</html>
