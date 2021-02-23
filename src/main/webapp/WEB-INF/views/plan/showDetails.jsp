<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div>
<head>
    <title>Title</title>
</head>
<%@ include file="../header.jsp" %>
<body>
<a class="d-none d-sm-inline-block btn btn-sm btn-warning shadow-sm text-gray-900" style="margin-left: 30px; margin-bottom: 20px;" href="/home">Strona główna</a>
<h1 class="text-gray-900" style="margin-left: 30px;">${plan.name}</h1>
<h3 style="margin-left: 30px">Dieta: ${plan.diet.name}</h3>

<c:forEach items="${weekDays}" var="weekDay">
    <form:form name="form${plan.id}-${weekDay.id}" modelAttribute="plansMeals" action="/orders/add/selectPlan/selectDay">
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
                        <a class="card-header" href="#collapseCardMeal${weekDay.id}-${mealName.id}" data-toggle="collapse"
                           role="button" aria-expanded="true" aria-controls="collapseCardMeal${weekDay.id}-${mealName.id}">
                            <span class="text-gray-900"> ${mealName.name} </span>
                            <div class="card-collapsable-arrow">
                                <i class="fas fa-chevron-down"  style="color: #333333;"></i>
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
                   style="width: 250px;background-color:#f6c23e; border-color:#f6c23e;color:#3a3b45; size: auto; z-index:99; border-radius: 0px 0px 13px 13px; margin-left: 30px;" value="Dodaj ${weekDay.name} do koszyka">
            <input type="number" name="quantity" style="max-width: 80px;float: left;" class="form-control form-control-user" placeholder="Ilość" min="0">
        </div>
    </form:form>
</c:forEach>

<%--<h3>Łączna cena:</h3>--%>
<%--<b>${plan.foodCostTotal}zł</b>--%>

<div style="margin-left: 30px;  margin-bottom: 20px;">
<h2 class="text-gray-900">Zamów cały plan</h2>
<form:form action="/orders/add/plan" method="post" modelAttribute="plansMeals" name="formOrderThisPlan">
    <input type="hidden" name="plan" value="${plan.id}">
    <div style="max-width: 90px;">
        Podaj Ilość: <input class="form-control form-control-user" type="number" name="quantity" min="0"><br>
    </div>
    <input type="submit" class="btn btn-primary"
           style="background-color:#f6c23e; border-color:#f6c23e;color:#3a3b45; size: auto" value="Dodaj do koszyka">
</form:form>

<h3>Ustalona cena:</h3>
<b>${plan.price}zł</b>
</div>
</body>
<%@ include file="../footer.jsp" %>
</html>
