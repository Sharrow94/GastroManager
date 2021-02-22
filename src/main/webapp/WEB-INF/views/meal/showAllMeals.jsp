<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ include file="../header.jsp" %>

<div class="container-fluid">
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary"><spring:message code="add.mealMenu"/></h6>
            <sec:authorize access="hasRole('ADMIN')">
                <a href='<c:url value="/admin/meal/add"/>'
                   class="btn btn-primary"
                   style="background-color:#f6c23e; color:#3a3b45;position: absolute;  right: 8%;width: 170px;margin:-25px; border: 10px #f6c23e;">
                    <spring:message code="add.addMeal"/></a>
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
                                    aria-label="Position: activate to sort column ascending" style="width:400px;">
                                    <spring:message code="app.name"/></th>
                                <th class="sorting" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1"
                                    aria-label="Salary: activate to sort column ascending" style="width: 250px;">
                                    <spring:message code="app.action"/></th>
                            </thead>
                            <tfoot>
                            <tr>
                                <th rowspan="1" colspan="1"><spring:message code="app.id"/></th>
                                <th rowspan="1" colspan="1"><spring:message code="app.name"/></th>
                                <th rowspan="1" colspan="1"><spring:message code="app.action"/></th>
                            </tr>
                            </tfoot>
                            <tbody>
                            <c:forEach items="${meals}" var="meal">
                                <tr role="row" class="odd">
                                    <td><c:out value="${meal.id}"/></td>
                                    <td><c:out value="${meal.name}"/></td>
                                    <td>
                                        <a href='<c:url value="/app/meal/details/${meal.id}"/>'
                                           class="btn btn-primary"
                                           style="background-color:#f6c23e; border-color:#f6c23e;color:#3a3b45; size: auto"><spring:message
                                                code="app.show"/></a>
                                        <sec:authorize access="hasRole('ADMIN')">
                                            <a href='<c:url value="/admin/meal/edit/${meal.id}"/>'
                                               class="btn btn-primary"
                                               style="background-color:#f6c23e; border-color:#f6c23e;color:#3a3b45"><spring:message
                                                    code="app.edit"/></a>
                                            <a href='<c:url value="/admin/meal/delete/confirm/${meal.id}"/>'
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

<%@ include file="../footer.jsp" %>