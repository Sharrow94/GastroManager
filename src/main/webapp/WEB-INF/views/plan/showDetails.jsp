<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:message code="app.add" var="add"/>
<spring:message code="app.toCart" var="toCart"/>
<spring:message code="app.addToCart" var="addToCart"/>
<spring:message code="app.quantity" var="quantity"/>

<head>
    <title>Title</title>
</head>
<%@ include file="../header.jsp" %>
<body>
<div class="row">
    <div class="col-md-6">
        <a class="d-none d-sm-inline-block btn btn-sm btn-warning shadow-sm text-gray-900"
           style="margin-left: 30px; margin-bottom: 20px;" href="/home"><spring:message code="app.dashboard"/> </a>
        <h1 class="text-gray-900" style="margin-left: 30px;">${plan.name}</h1>
        <h3 style="margin-left: 30px"><spring:message code="app.diet"/>: ${plan.diet.name}</h3>
    </div>
    <div class="col-md-6">
        <h2 class="text-gray-900">Zamów cały plan</h2>
        <form:form action="/app/orders/addCart/plan" method="post" modelAttribute="plansMeals" name="formOrderThisPlan">
            <input type="hidden" name="plan" value="${plan.id}">
            <div style="max-width: 90px;">
                <spring:message code="add.enterQuantity"/>: <input class="form-control form-control-user" type="number"
                                                                   name="quantity" min="0"><br>
            </div>
            <input type="submit" class="btn btn-primary"
                   style="background-color:#f6c23e; border-color:#f6c23e;color:#3a3b45; size: auto"
                   value="${addToCart}">
        </form:form>
        <div class="col-md-6">
            <div class="card shadow border-warning">
                <div class="card-header">
                    <div class="row">
                        <div class="col-md-3"></div>
                        <div class="col-md-7 h5">
                            <b>Cena: ${plan.price}zł/dzień</b>
                        </div>
                        <div class="col-md-2"></div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<c:forEach items="${weekDays}" var="weekDay">
    <form:form name="form${plan.id}-${weekDay.id}" modelAttribute="plansMeals"
               action="/app/orders/addCart/selectPlan/selectDay">
        <div class="card card-collapsable border-bottom-warning">
            <a class="card-header collapsed" href="#collapseCard${weekDay.id}" data-toggle="collapse" role="button"
               aria-expanded="false" aria-controls="collapseCard${weekDay.id}">
                <span class="text-gray-900">${weekDay.name}</span>

                <input type="hidden" name="plan" value="${plan.id}">
                <input type="hidden" name="weekDays" value="${weekDay.id}">

                <div class="card-collapsable-arrow">
                    <i class="fas fa-chevron-down" style="color: #333333;"></i>
                </div>
            </a>
            <div class="collapse" id="collapseCard${weekDay.id}">
                <div class="card-body">
                    <c:forEach items="${mealNames}" var="mealName">
                        <div class="card card-collapsable">
                            <a class="card-header" href="#collapseCardMeal${weekDay.id}-${mealName.id}"
                               data-toggle="collapse"
                               role="button" aria-expanded="true"
                               aria-controls="collapseCardMeal${weekDay.id}-${mealName.id}">
                                <span class="text-gray-900"> ${mealName.name} </span>
                                <div class="card-collapsable-arrow">
                                    <i class="fas fa-chevron-down" style="color: #333333;"></i>
                                </div>
                            </a>
                            <div class="collapse show" id="collapseCardMeal${weekDay.id}-${mealName.id}">
                                <div class="card-body">
                                    <c:forEach items="${plan.plansMeals}" var="pm">
                                        <c:if test="${pm.weekDays==weekDay and pm.mealName==mealName}">
                                            <span class="text-gray-900">${pm.meal.name}</span><br>
                                        </c:if>
                                    </c:forEach>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>
        <div style="margin-left: 100px;">
            <input type="submit" class="btn btn-primary"
                   style="width: 250px;background-color:#f6c23e; border-color:#f6c23e;color:#3a3b45; size: auto; z-index:99; border-radius: 0px 0px 13px 13px; margin-left: 30px;"
                   value="${add} ${weekDay.name} ${toCart}">
            <input type="number" name="quantity" style="max-width: 80px;float: left;"
                   class="form-control form-control-user" placeholder="${quantity}" min="0">
        </div>
    </form:form>
</c:forEach>

<%--<h3>Łączna cena:</h3>--%>
<%--<b>${plan.foodCostTotal}zł</b>--%>
</body>
<%@ include file="../footer.jsp" %>
</html>
