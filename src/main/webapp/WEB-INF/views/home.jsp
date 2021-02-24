
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.jsp" %>
<head>
    <title>Home</title>
</head>
            </nav>
            <!-- End of Topbar -->
<div class="row-for-orders align-items-center">


    <!-- Zamów dzień z planu -->
    <div class="col-xl-3 col-md-6 mb-4">
        <div class="card border-left-primary shadow h-100 py-2 align-items-center">
            <div class="card-body">
                <div class="row no-gutters align-items-center">
                    <div class="col mr-2">
                        <div class="h5 mb-0 font-weight-bold text-gray-800"><a class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm" href="/app/plan/all">Zamów plan</a></div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- Zamów posiłek -->
    <div class="col-xl-3 col-md-6 mb-4">
        <div class="card border-left-primary shadow h-100 py-2 align-items-center">
            <div class="card-body">
                <div class="row no-gutters">
                    <div class="col mr-2">
                        <div class="h5 mb-0 font-weight-bold text-gray-800"><a class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm" href="/orders/add/mealName">Zamów posiłek</a></div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<%@ include file="footer.jsp" %>