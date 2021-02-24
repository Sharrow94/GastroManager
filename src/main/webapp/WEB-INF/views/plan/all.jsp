<%-- <%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<%@ taglib prefix="form"--%>
<%--           uri="http://www.springframework.org/tags/form" %>--%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>Title</title>--%>
<%--</head>--%>
<%--<%@ include file="../header.jsp" %>--%>
<%--<body>--%>
<%--<table border="1px" cellpadding="15px" cellspacing="0px">--%>
<%--    <thead>--%>
<%--    <tr>--%>
<%--        <th>id</th>--%>
<%--        <th>Name</th>--%>
<%--        <th>Price</th>--%>
<%--        <th>FoodCost</th>--%>
<%--        <th>Dieta</th>--%>
<%--        <th>Action</th>--%>
<%--    </tr>--%>
<%--    </thead>--%>
<%--    <tbody>--%>
<%--    <sec:authorize access="hasRole('USER')">--%>
<%--    <c:forEach items="${plans}" var="plan">--%>
<%--        <tr>--%>
<%--            <td>${plan.id}</td>--%>
<%--            <td>${plan.name}</td>--%>
<%--            <td>${plan.price}</td>--%>
<%--            <td>${plan.foodCostTotal}</td>--%>
<%--            <td>${plan.diet.name}</td>--%>
<%--            <td>--%>

<%--            </td>--%>
<%--        </tr>--%>
<%--    </c:forEach>--%>
<%--    </sec:authorize>--%>
<%--    <sec:authorize access="hasRole('ADMIN')">--%>
<%--    <c:forEach items="${plans}" var="plan">--%>
<%--        <tr>--%>
<%--            <td>${plan.id}</td>--%>
<%--            <td>${plan.name}</td>--%>
<%--            <td>${plan.price}</td>--%>
<%--            <td>${plan.foodCostTotal}</td>--%>
<%--            <td>${plan.diet.name}</td>--%>
<%--            <td>--%>
<%--                <a href="<c:url value="/plan/edit/${plan.id}"/>">Edit</a> |--%>
<%--                <a href="<c:url value="/plan/delete/${plan.id}"/>">Delete</a> |--%>
<%--                <a href="<c:url value="/plan/${plan.id}"/>">Details</a>--%>
<%--            </td>--%>
<%--        </tr>--%>
<%--    </c:forEach>--%>
<%--    <tr>--%>
<%--        <td colspan="6">--%>
<%--            <a href="/plan/add"><button>+</button></a><em> Dodaj nowy plan</em>--%>
<%--        </td>--%>
<%--    </tr>--%>
<%--    </sec:authorize>--%>
<%--    </tbody>--%>
<%--</table>--%>

<%--</body>--%>
<%--<%@ include file="../footer.jsp" %>--%>
<%--</html>--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ include file="../header.jsp" %>

<div class="container-fluid">
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary"><spring:message code="app.planMenu"/></h6>
            <sec:authorize access="hasRole('ADMIN')">
                <a href='<c:url value="/admin/plan/add"/>'
                   class="btn btn-primary"
                   style="background-color:#f6c23e; color:#3a3b45;position: absolute;  right: 8%;width: 170px;margin:-25px; border: 10px #f6c23e;">
                    <spring:message code="app.addPlan"/></a>
            </sec:authorize>
        </div>
        <div class="card-body">
            <div class="table-responsive">
                <div id="dataTable_wrapper" class="dataTables_wrapper dt-bootstrap4">

                    <div class="row">
                        <div class="col-sm-12 col-md-6">
                            <div class="dataTables_length" id="dataTable_length"><label><spring:message
                                    code="app.show"/>
                                <select
                                        name="dataTable_length" aria-controls="dataTable"
                                        class="custom-select custom-select-sm form-control form-control-sm">
                                    <option value="10">10 <spring:message code="app.pages"/></option>
                                    <option value="25">25 <spring:message code="app.pages"/></option>
                                    <option value="50">50 <spring:message code="app.pages"/></option>
                                    <option value="100">100 <spring:message code="app.pages"/></option>

                                </select>
                            </label>
                            </div>
                        </div>
                        <div class="col-sm-12 col-md-6">
                            <div id="dataTable_filter" class="dataTables_filter"
                                 style="position: absolute;  right: 0;width: 250px;">
                                <label><spring:message code="app.search"/>:<input type="search"
                                                                                  class="form-control form-control-sm"
                                                                                  placeholder=""
                                                                                  aria-controls="dataTable"></label>
                            </div>
                        </div>
                    </div>


                    <div class="col-sm-12">
                        <table class="table table-bordered dataTable" id="dataTable" width="100%" cellspacing="0"
                               role="grid" aria-describedby="dataTable_info" style="width: 100%;">
                            <thead>
                            <tr role="row">
                                <th class="sorting_asc" tabindex="0" aria-controls="dataTable" rowspan="1"
                                    colspan="1" aria-sort="ascending"
                                    aria-label="Name: activate to sort column descending" style="width: 60px;">
                                    <spring:message code="app.id"/></th>
                                <th class="sorting" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1"
                                    aria-label="Position: activate to sort column ascending" style="width:250px;">
                                    <spring:message code="app.name"/></th>
                                <th class="sorting" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1"
                                    aria-label="Position: activate to sort column ascending" style="width:200px;">
                                    <spring:message code="app.diet"/></th>
                                <th class="sorting" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1"
                                    aria-label="Position: activate to sort column ascending" style="width:150px;">
                                    <spring:message code="app.costPlan"/></th>
                                <sec:authorize access="hasRole('ADMIN')">
                                <th class="sorting" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1"
                                    aria-label="Position: activate to sort column ascending" style="width:150px;">
                                    <spring:message code="app.foodCost"/></th>
                                </sec:authorize>
                                <th class="sorting" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1"
                                <th class="sorting" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1"
                                    aria-label="Salary: activate to sort column ascending" style="width: 250px;">
                                    <spring:message code="app.action"/></th>


                            </thead>
                            <tfoot>
                            <tr>
                                <th rowspan="1" colspan="1"><spring:message code="app.id"/></th>
                                <th rowspan="1" colspan="1"><spring:message code="app.name"/></th>
                                <th rowspan="1" colspan="1"><spring:message code="app.diet"/></th>
                                <th rowspan="1" colspan="1"><spring:message code="app.costPlan"/></th>
                                <sec:authorize access="hasRole('ADMIN')">
                                    <th rowspan="1" colspan="1"><spring:message code="app.foodCost"/></th>
                                </sec:authorize>
                                <th rowspan="1" colspan="1"><spring:message code="app.action"/></th>
                            </tr>
                            </tfoot>
                            <tbody>
                            <c:forEach items="${plans}" var="plan">
                                <tr role="row" class="odd">
                                    <td><c:out value="${plan.id}"/></td>
                                    <td><c:out value="${plan.name}"/></td>
                                    <td><c:out value="${plan.diet.name}"/></td>
                                    <td><c:out value="${plan.price}"/></td>
                                    <sec:authorize access="hasRole('ADMIN')">
                                        <td><c:out value="${plan.foodCostTotal}"/></td>
                                    </sec:authorize>
                                    <td>
                                        <a href='<c:url value="/app/plan/${plan.id}"/>'
                                           class="btn btn-primary"
                                           style="background-color:#f6c23e; border-color:#f6c23e;color:#3a3b45; size: auto"><spring:message
                                                code="app.show"/></a>
                                        <sec:authorize access="hasRole('ADMIN')">
                                            <a href='<c:url value="/admin/plan/edit/${plan.id}"/>'
                                               class="btn btn-primary"
                                               style="background-color:#f6c23e; border-color:#f6c23e;color:#3a3b45"><spring:message
                                                    code="app.edit"/></a>
                                            <a href='<c:url value="/admin/plan/delete/${plan.id}"/>'
                                               class="btn btn-primary"
                                               style="background-color:#f6c23e; border-color:#f6c23e;color:#3a3b45"><spring:message
                                                    code="app.delete"/></a>
                                        </sec:authorize>
                                    </td>

                                </tr>
                            </c:forEach>

                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<%@ include file="../footer.jsp" %>
