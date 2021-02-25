<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.jsp" %>
<head>
    <title>Home</title>
</head>

            <!-- End of Topbar -->
<style>
    .containerTwo{
        width: 90%;
        height: 70%;
        margin: 80px auto;
    }
</style>
<div class="containerTwo">


    <section class="pricing py-5" style="width: 100%;height: 100%" >
        <div class="container">
            <div class="row">
                <!-- Zamów dzień z planu -->
                <div class="col-lg-4" style="display: block;
    margin-left: auto;
    margin-right: 20px">
                    <div class="card mb-5 mb-lg-0" >
                        <div class="card-body">
                            <h5 class="card-title text-muted text-uppercase text-center">od:</h5>
                            <h6 class="card-price text-center"><strong>12zł</strong><span class="period">/dzień</span></h6>
                            <hr>
                            <ul class="fa-ul">
                                <li><span class="fa-li"><i class="fas fa-check"></i></span>Zdrowo i świeżo </li>
                                <li><span class="fa-li"><i class="fas fa-check"></i></span>Zróżnicowane diety</li>
                                <li><span class="fa-li"><i class="fas fa-check"></i></span>Codziennie coś nowego</li>
                                <li><span class="fa-li"><i class="fas fa-check"></i></span>Codziennie 5 posiłków</li>
                            </ul>
                            <a href="/app/plan/all" class="btn btn-block btn-primary text-uppercase" style="color: black"><strong> <spring:message code="app.order.plan"/></strong></a>
                        </div>
                    </div>
                </div>
                <%--    <!-- Zamów posiłek -->--%>
                <div class="col-lg-4" style="display: block;
                     margin-left: 20px;
                     margin-right: auto">
                    <div class="card">
                        <div class="card-body">
                            <h5 class="card-title text-muted text-uppercase text-center">od:</h5>
                            <h6 class="card-price text-center"><strong>5zł</strong><span class="period">/posiłek</span></h6>
                            <hr>
                            <ul class="fa-ul">
                                <li><span class="fa-li"><i class="fas fa-check"></i></span>Zdrowo i świeżo</li>
                                <li><span class="fa-li"><i class="fas fa-check"></i></span>Tanio</li>
                                <li><span class="fa-li"><i class="fas fa-check"></i></span>Codziennie coś nowego</li>
                                <li><span class="fa-li"><i class="fas fa-check"></i></span>Do wyboru wiele diet i posiłków</li>

                            </ul>
                            <a href="/app/orders/addCart/mealName" class="btn btn-block btn-primary text-uppercase" style="color:black;"> <strong><spring:message code="app.order.meal"/></strong></a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
</div>

<%@ include file="footer.jsp" %>