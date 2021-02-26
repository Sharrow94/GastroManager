<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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
                <div class="col-lg-7 d-none d-lg-block">
                    <div class="p-5">
                        <div>
                            <h3 class="text-gray-900">${meal.name}</h3>
                        </div>
                        <div class="card">
                            <div class="card-header">Składniki</div>
                            <div class="card-body">
                            <ul>
                                <c:forEach items="${meal.ingredientsMeals}" var="im">
                                    <li>
                                        <div class="row">
                                            <div class="col-md-4">${im.ingredient.name}</div>
                                            <div class="col-md-4">ilość ${im.quantity} ${im.ingredient.unit}</div>
                                        <sec:authorize access="hasRole('ADMIN')">
                                            <div class="col-md-4">
                                            <a class="btn btn-primary btn-sm" href="<c:url value="/admin/meal/ingredient/edit/${im.id}"/>">Edytuj</a>
                                            <a class="btn btn-danger btn-sm" href="<c:url value="/admin/meal/ingredient/delete/${im.id}"/>">Usuń</a>
                                            </div>
                                        </sec:authorize>
                                        </div>
                                    </li>
                                </c:forEach>
                                <br><br>
                                <a class="btn btn-primary btn-user btn-block" href="<c:url value="/admin/meal/ingredient/add/${meal.id}"/>">Dodaj nowy składnik</a>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>


                <div class="col-lg-5 d-none d-lg-block">
                    <div class="p-5">
                        <div>
                            <h3>Dieta: ${meal.diet.name}</h3>
                        </div>
                        <div class="card">
                            <div class="card-header">Sposób przygotowania</div>
                            <div class="card-body">${meal.description}</div>
                        </div>
                        <div class="card shadow border-warning">
                            <div class="card-header">
                                <div class="row">
                                    <div class="col-md-3"></div>
                                    <div class="col-md-7 h5">
                                        <b>Cena: ${meal.price}zł</b>
                                    </div>
                                    <div class="col-md-2"></div>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>
                <a class="btn btn-primary btn-user btn-block" href="<c:url value="/app/meal/list"/>">Powrót</a>
            </div>
        </div>
    </div>
</div>
</body>
<%@ include file="../footer.jsp" %>
</html>
