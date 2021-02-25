<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">



    <!-- Custom fonts for this template-->
    <link href="<c:url value="/vendor/fontawesome-free/css/all.min.css"/>" rel="stylesheet" type="text/css">
    <link
            href="<c:url value="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"/>"
            rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="<c:url value="/css/sb-admin-2.min.css"/>" rel="stylesheet">

</head>

<body id="page-top">

<!-- Page Wrapper -->
<div id="wrapper">

    <!-- Sidebar -->
    <ul class="navbar-nav bg-gradient-warning sidebar sidebar-dark accordion" id="accordionSidebar">

        <!-- Sidebar - Brand -->
        <a class="sidebar-brand d-flex align-items-center justify-content-center" href="index.html">
            <div class="sidebar-brand-icon rotate-n-15">
<%--                <i class="fas fa-laugh-wink"></i>--%>
            </div>
            <div class="sidebar-brand-text mx-3">GastoManager </div>
        </a>

        <!-- Divider -->
        <hr class="sidebar-divider my-0">

        <!-- Nav Item - Dashboard -->
        <li class="nav-item">
            <a class="nav-link" href="<c:url value="/home"/>">
                <i class="fas fa-fw fa-tachometer-alt"></i>
                <span>Strona główna</span></a>
        </li>

        <!-- Divider -->
        <hr class="sidebar-divider">

        <!-- Heading -->
        <div class="sidebar-heading">
            Interface
        </div>

        <!-- Nav Item - Pages Collapse Menu -->
        <li class="nav-item">
            <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapsePayments"
               aria-expanded="true" aria-controls="collapsePayments">

                <i class="fas fa-dollar-sign fa-2x"></i>

                <span>Płatności</span>
            </a>
            <div id="collapsePayments" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
                <div class="bg-gray-900 py-2 collapse-inner rounded">
                    <h6 class="collapse-header">Operacje:</h6>
                    <a class="collapse-item text-gray-100" href="<c:url value="/app/payments/all"/>">Lista</a>
                    <sec:authorize access="hasRole('ADMIN')">
                        <a class="collapse-item text-gray-100" href="<c:url value="/admin/payments/add"/>">Dodaj</a>
                    </sec:authorize>


                </div>
            </div>
        </li>
        <li class="nav-item">
            <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseMeal"
               aria-expanded="true" aria-controls="collapseMeal">

                <i class="fas fa-fw fa-utensil-spoon"></i>
                <span>Posiłki</span>
            </a>
            <div id="collapseMeal" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
                <div class="bg-gray-900 py-2 collapse-inner rounded">
                    <h6 class="collapse-header">Operacje:</h6>
                    <a class="collapse-item text-gray-100" href="<c:url value="/app/meal/list"/>">Lista</a>
                    <sec:authorize access="hasRole('ADMIN')">
                        <a class="collapse-item text-gray-100" href="<c:url value="/admin/meal/add"/>">Dodaj</a>
                    </sec:authorize>


                </div>
            </div>
        </li>
        <li class="nav-item">
            <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapsePlan"
               aria-expanded="true" aria-controls="collapsePlan">
                <i class="fas fa-fw fa-calendar"></i>
                <span>Plan </span>
            </a>
            <div id="collapsePlan" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
                <div class="bg-gray-900 py-2 collapse-inner rounded">
                    <h6 class="collapse-header">Operacje:</h6>
                    <a class="collapse-item text-gray-100" href="<c:url value="/app/plan/all"/>">Lista</a>
                    <sec:authorize access="hasRole('ADMIN')">
                        <a class="collapse-item text-gray-100" href="<c:url value="/admin/plan/add"/>">Dodaj</a>
                    </sec:authorize>

                </div>
            </div>
        </li>
        <li class="nav-item">
            <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseOrders"
               aria-expanded="true" aria-controls="collapseOrders">

                <i class="fas fa-fw fa-plus"></i>

                <span>Zamówienia</span>
            </a>
            <div id="collapseOrders" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
                <div class="bg-gray-900 py-2 collapse-inner rounded">
                    <h6 class="collapse-header">Operacje:</h6>
                    <a class="collapse-item text-gray-100" href="<c:url value="/app/orders/user"/>">Twoje zamówienia</a>
                    <sec:authorize access="hasRole('ADMIN')">
                        <a class="collapse-item text-gray-100" href="<c:url value="/admin/orders/all"/>">Wszystkie Zamówienia</a>
                        <a class="collapse-item text-gray-100" href="<c:url value="/admin/orders/add"/>">Dodaj</a>
                    </sec:authorize>

                </div>
            </div>
        </li>
        <sec:authorize access="hasRole('ADMIN')">
        <li class="nav-item">
            <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseStorages"
               aria-expanded="true" aria-controls="collapseStorages">

                <i class="fas fa-fw fa-cubes"></i>

                <span>Magazyn</span>
            </a>
            <div id="collapseStorages" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
                <div class="bg-gray-900 py-2 collapse-inner rounded">
                    <h6 class="collapse-header">Operacje:</h6>
                    <a class="collapse-item text-gray-100" href="<c:url value="/admin/sOi/list"/>">Dokumenty magazynowe</a>
                    <a class="collapse-item text-gray-100" href="<c:url value="/admin/ingredient/all"/>">Stan Magazynowy</a>
                </div>
            </div>
        </li>
        </sec:authorize>
        <sec:authorize access="hasRole('ADMIN')">
            <li class="nav-item">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseSupplier"
                   aria-expanded="true" aria-controls="collapseSupplier">
                    <i class="fas fa-fw fa-truck"></i>
                    <span>Dostawcy</span>
                </a>
                <div id="collapseSupplier" class="collapse" aria-labelledby="headingUtilities"
                     data-parent="#accordionSidebar">
                    <div class="bg-gray-900 py-2 collapse-inner rounded">
                        <h6 class="collapse-header">Operacje:</h6>
                        <a class="collapse-item text-gray-100" href="<c:url value="/admin/supplier/all"/>">Lista</a>
                        <a class="collapse-item text-gray-100" href="<c:url value="/admin/supplier/add"/>">Dodaj</a>
                    </div>
                </div>
            </li>
        </sec:authorize>

        <!-- Nav Item - Utilities Collapse Menu -->
        <sec:authorize access="hasRole('ADMIN')">
        <li class="nav-item">
            <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseUsers"
               aria-expanded="true" aria-controls="collapseUsers">
                <i class="fas fa-fw fa-wrench"></i>
                <span>Użytkownicy</span>
            </a>
            <div id="collapseUsers" class="collapse" aria-labelledby="headingUtilities"
                 data-parent="#accordionSidebar">
                <div class="bg-gray-900 py-2 collapse-inner rounded">
                    <h6 class="collapse-header">Operacje:</h6>
                    <a class="collapse-item text-gray-100" href="<c:url value="/admin/user/all"/>">Lista</a>
                </div>
            </div>
        </li>
        </sec:authorize>

<%--        <!-- Divider -->--%>
<%--        <hr class="sidebar-divider">--%>

<%--        <!-- Heading -->--%>
<%--        <div class="sidebar-heading">--%>
<%--            Addons--%>
<%--        </div>--%>

<%--        <!-- Nav Item - Pages Collapse Menu -->--%>
<%--        <li class="nav-item">--%>
<%--            <a class="nav-link" href="#"--%>
<%--               data-toggle="collapse"--%>
<%--               data-target="#collapsePages"--%>
<%--               aria-expanded="false"--%>
<%--               aria-controls="collapsePages">--%>
<%--                <i class="fas fa-fw fa-folder">--%>

<%--                </i>--%>
<%--                <span>Pages</span>--%>
<%--            </a>--%>
<%--            <div id="collapsePages" class="collapse show" aria-labelledby="headingPages"--%>
<%--                 data-parent="#accordionSidebar" style>--%>
<%--                <div class="bg-gray-900 py-2 collapse-inner rounded">--%>
<%--                    <h6 class="collapse-header">Login Screens:</h6>--%>
<%--                    <a class="collapse-item text-gray-100" href="login.html">Login</a>--%>
<%--                    <a class="collapse-item text-gray-100" href="register.html">Register</a>--%>
<%--                    <a class="collapse-item text-gray-100" href="forgot-password.html">Forgot Password</a>--%>
<%--                    <div class="collapse-divider"></div>--%>
<%--                    <h6 class="collapse-header">Other Pages:</h6>--%>
<%--                    <a class="collapse-item text-gray-100" href="404.html">404 Page</a>--%>
<%--                    <a class="collapse-item active" href="blank.html">Blank Page</a>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </li>--%>

<%--        <!-- Nav Item - Charts -->--%>
<%--        <li class="nav-item">--%>
<%--            <a class="nav-link" href="charts.html">--%>
<%--                <i class="fas fa-fw fa-chart-area"></i>--%>
<%--                <span>Charts</span></a>--%>
<%--        </li>--%>

<%--        <!-- Nav Item - Tables -->--%>
<%--        <li class="nav-item">--%>
<%--            <a class="nav-link" href="tables.html">--%>
<%--                <i class="fas fa-fw fa-table"></i>--%>
<%--                <span>Tables</span></a>--%>
<%--        </li>--%>

        <!-- Divider -->
        <hr class="sidebar-divider d-none d-md-block">

        <!-- Sidebar Toggler (Sidebar) -->
        <div class="text-center d-none d-md-inline">
            <button class="rounded-circle border-0" id="sidebarToggle"></button>
        </div>

    </ul>
    <!-- End of Sidebar -->

    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">

        <!-- Main Content -->
        <div id="content">

            <!-- Topbar -->
            <nav class="navbar navbar-expand navbar-light bg-gray-900 topbar mb-4 static-top shadow">

                <!-- Sidebar Toggle (Topbar) -->
                <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
                    <i class="fa fa-bars"></i>
                </button>

                <!-- Topbar Search -->
                <form
                        class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search">
                    <div class="input-group">
                        <input type="text" class="form-control bg-light border-0 small" placeholder="Search for..."
                               aria-label="Search" aria-describedby="basic-addon2">
                        <div class="input-group-append">
                            <button class="btn btn-primary" type="button">
                                <i class="fas fa-search fa-sm"></i>
                            </button>
                        </div>
                    </div>
                </form>

                <!-- Topbar Navbar -->
                <ul class="navbar-nav ml-auto">

                    <!-- Nav Item - Search Dropdown (Visible Only XS) -->
                    <li class="nav-item dropdown no-arrow d-sm-none">
                        <a class="nav-link dropdown-toggle" href="#" id="searchDropdown" role="button"
                           data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <i class="fas fa-search fa-fw"></i>
                        </a>
                        <!-- Dropdown - Messages -->
                        <div class="dropdown-menu dropdown-menu-right p-3 shadow animated--grow-in"
                             aria-labelledby="searchDropdown">
                            <form class="form-inline mr-auto w-100 navbar-search">
                                <div class="input-group">
                                    <input type="text" class="form-control bg-light border-0 small"
                                           placeholder="Search for..." aria-label="Search"
                                           aria-describedby="basic-addon2">
                                    <div class="input-group-append">
                                        <button class="btn btn-primary" type="button">
                                            <i class="fas fa-search fa-sm"></i>
                                        </button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </li>

                    <!-- Nav Item - Alerts -->
                    <li class="nav-item dropdown no-arrow mx-1">
                        <a class="nav-link dropdown-toggle" href="#" id="alertsDropdown" role="button"
                           data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <i class="fas fa-bell fa-fw"></i>
                            <!-- Counter - Alerts -->
                            <span class="badge badge-danger badge-counter">3+</span>
                        </a>
                        <!-- Dropdown - Alerts -->
                        <div class="dropdown-list dropdown-menu dropdown-menu-right shadow animated--grow-in"
                             aria-labelledby="alertsDropdown">
                            <h6 class="dropdown-header">
                                Alerts Center
                            </h6>
                            <a class="dropdown-item d-flex align-items-center" href="#">
                                <div class="mr-3">
                                    <div class="icon-circle bg-primary">
                                        <i class="fas fa-file-alt text-white"></i>
                                    </div>
                                </div>
                                <div>
                                    <div class="small text-gray-500">December 12, 2019</div>
                                    <span class="font-weight-bold">A new monthly report is ready to download!</span>
                                </div>
                            </a>
                            <a class="dropdown-item d-flex align-items-center" href="#">
                                <div class="mr-3">
                                    <div class="icon-circle bg-success">
                                        <i class="fas fa-donate text-white"></i>
                                    </div>
                                </div>
                                <div>
                                    <div class="small text-gray-500">December 7, 2019</div>
                                    $290.29 has been deposited into your account!
                                </div>
                            </a>
                            <a class="dropdown-item d-flex align-items-center" href="#">
                                <div class="mr-3">
                                    <div class="icon-circle bg-warning">
                                        <i class="fas fa-exclamation-triangle text-white"></i>
                                    </div>
                                </div>
                                <div>
                                    <div class="small text-gray-500">December 2, 2019</div>
                                    Spending Alert: We've noticed unusually high spending for your account.
                                </div>
                            </a>
                            <a class="dropdown-item text-center small text-gray-500" href="#">Show All Alerts</a>
                        </div>
                    </li>

                    <!-- Nav Item - Messages -->
                    <li class="nav-item dropdown no-arrow mx-1">
                        <a class="nav-link dropdown-toggle" href="#" id="messagesDropdown" role="button"
                           data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <i class="fas fa-shopping-cart fa-fw"></i>
                            <!-- Counter - Messages -->
                            <c:if test="${sessionScope.shoppingCart.getOrderMeals().size() != 0}">
                            <span class="badge badge-danger badge-counter">
                                    ${sessionScope.shoppingCart.getOrderMeals().size()}
                            </span>
                            </c:if>
                        </a>
                        <!-- Dropdown - Messages -->
                        <c:if test="${sessionScope.shoppingCart.getOrderMeals().size() != 0}">
                        <div class="dropdown-list dropdown-menu dropdown-menu-right shadow animated--grow-in"
                             aria-labelledby="messagesDropdown">
                            <h6 class="dropdown-header">
                                Twój Koszyk
                            </h6>
                            <c:forEach items="${sessionScope.shoppingCart.getOrderMeals()}" var="cartItem">
                            <div class="dropdown-item d-flex align-items-center">
                                <div class="dropdown-list-image mr-3">
                                    <a class="btn btn-danger btn-circle" href="<c:url value="/app/shoppingCartDropItem/${sessionScope.shoppingCart.getOrderMeals().indexOf(cartItem)}"/> ">
                                        <i class="fas fa-trash ">
                                        </i>
                                    </a>
                                        <%--                                    <div class="status-indicator bg-success"></div>--%>
                                </div>
                                <div class="font-weight-bold">
                                    <div class="text-truncate">
                                        ${cartItem.name} ${cartItem.price} zł
                                    </div>
                                    <div class="small text-gray-500">x${cartItem.quantity}</div>
                                </div>
                            </div>
                            </c:forEach>
                            <a class="dropdown-item text-center small text-gray-500" href="#">Zobacz swój Koszyk (${sessionScope.shoppingCart.getOrderPrice()} zł)</a>
                        </div>
                        </c:if>
                    </li>

                    <div class="topbar-divider d-none d-sm-block"></div>

                    <!-- Nav Item - User Information -->
                    <li class="nav-item dropdown no-arrow">
                        <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button"
                           data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
<%--                            <span class="mr-2 d-none d-lg-inline text-gray-600 small">Douglas McGee</span>--%>
                            <sec:authorize access="isAuthenticated()">
                                <p>Zalogowany jako: <sec:authentication property="name"/></p>
<%--                                <p> <sec:authentication property="authorities"/></p>--%>
                            </sec:authorize>
                            <img class="img-profile rounded-circle"
                                 src="<c:url value="/img/undraw_profile.svg"/>">
                        </a>
                        <!-- Dropdown - User Information -->
                        <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
                             aria-labelledby="userDropdown">
                            <a class="dropdown-item" href="#">
                                <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
                                Profile
                            </a>
                            <a class="dropdown-item" href="#">
                                <i class="fas fa-cogs fa-sm fa-fw mr-2 text-gray-400"></i>
                                Settings
                            </a>
                            <a class="dropdown-item" href="#">
                                <i class="fas fa-list fa-sm fa-fw mr-2 text-gray-400"></i>
                                Activity Log
                            </a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">
                                <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                                Logout
                            </a>
                        </div>
                    </li>

                </ul>

            </nav>
            <!-- End of Topbar -->


