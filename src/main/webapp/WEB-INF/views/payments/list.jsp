<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ include file="../header.jsp" %>

<div class="container-fluid">
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary"><spring:message code="add.paymentsMenu"/></h6>
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
                                    aria-label="Name: activate to sort column descending" style="width: auto;">
                                    <spring:message code="app.id"/></th>
                                <th class="sorting" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1"
                                    aria-label="Position: activate to sort column ascending" style="width: auto;">
                                    <spring:message code="app.cost"/></th>
                                <th class="sorting" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1"
                                    aria-label="Office: activate to sort column ascending" style="width: auto;">
                                    <spring:message code="app.data"/></th>
                                <th class="sorting" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1"
                                    aria-label="Age: activate to sort column ascending" style="width: auto;">
                                    <spring:message code="app.paymentsComplete"/></th>
                                <th class="sorting" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1"
                                    aria-label="Start date: activate to sort column ascending"
                                    style="width: auto;"><spring:message code="app.ordersId"/></th>
                                <th class="sorting" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1"
                                    aria-label="Salary: activate to sort column ascending" style="width: auto; ">
                                    <spring:message code="app.userId"/></th>
                                <sec:authorize access="hasAnyRole('ADMIN')">
                                    <th class="sorting" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1"
                                        aria-label="Salary: activate to sort column ascending" style="width: auto; ">
                                        <spring:message code="app.action"/></th>
                                </sec:authorize>

                            </
                            </thead>
                            <tfoot>

                            <tr>
                                <th rowspan="1" colspan="1"><spring:message code="app.id"/></th>
                                <th rowspan="1" colspan="1"><spring:message code="app.cost"/></th>
                                <th rowspan="1" colspan="1"><spring:message code="app.data"/></th>
                                <th rowspan="1" colspan="1"><spring:message code="app.paymentsComplete"/></th>
                                <th rowspan="1" colspan="1"><spring:message code="app.ordersId"/></th>
                                <th rowspan="1" colspan="1"><spring:message code="app.userId"/></th>
                                <sec:authorize access="hasRole('ADMIN')">
                                    <th rowspan="1" colspan="1"><spring:message code="app.action"/></th>
                                </sec:authorize>
                            </tr>

                            </tfoot>
                            <tbody>
                            <c:forEach items="${payments}" var="payments">
                                <tr role="row" class="odd">
                                    <td><c:out value="${payments.id}"/></td>
                                    <td><c:out value="${payments.summaryPrice}"/></td>
                                    <td><c:out value="${payments.finalPayDate}"/></td>
                                    <c:if test="${payments.payed}">
                                        <td><spring:message code="app.payed"/></td>
                                    </c:if>
                                    <c:if test="${!payments.payed}">
                                        <td><spring:message code="app.unPayed"/></td>
                                    </c:if>
                                    <td><c:out value="${payments.orders.id}"/></td>
                                    <td><c:out value="${payments.users.id}"/></td>
                                    <sec:authorize access="hasRole('ADMIN')">
                                        <td>
                                            <a href='<c:url value="/admin/payments/${payments.id}"/>'
                                               class="btn btn-primary"
                                               style="background-color:#f6c23e; border-color:#f6c23e;color:#3a3b45"><spring:message
                                                    code="app.show"/></a>
                                            <a href='<c:url value="/admin/payments/edit/${payments.id}"/>'
                                               class="btn btn-primary"
                                               style="background-color:#f6c23e; border-color:#f6c23e;color:#3a3b45"><spring:message
                                                    code="app.edit"/></a>
                                            <a href='<c:url value="/admin/payments/delete/${payments.id}"/>'
                                               class="btn btn-primary"
                                               style="background-color:#f6c23e; border-color:#f6c23e;color:#3a3b45"><spring:message
                                                    code="app.delete"/></a>
                                        </td>
                                    </sec:authorize>
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