<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:message code="app.payments.giveNumber" var="giveNumber"/>

<html>
<head>
    <title>Title</title>
</head>
<%@ include file="../header.jsp" %>
<body>

<div class="card o-hidden border-0 shadow-lg my-5">
    <div class="card-body p-0">
        <!-- Nested Row within Card Body -->
        <div class="row">
            <div class="col-lg-5 d-none d-lg-block bg-register-image"></div>
            <div class="col-lg-7">
                <div class="p-5">
                    <form:form method="post" modelAttribute="storageOperation">
                        <div class="text-center">
                            <h1 class="h4 text-gray-900 mb-4"> <spring:message code="app.storageOperationItem"/></h1>
                        </div>
                        <div class="form-group row">
                            <div class="col-sm-6 mb-3 mb-sm-0">
                                <td><spring:message code="app.documentNumber"/></td>
                                <form:input path="documentNumber" placeholder="${giveNumber}"
                                            class="form-control form-control-user"/>

                            </div>
                        </div>
                        <div class="form-group row">
                            <div class="col-sm-6 mb-3 mb-sm-0">
                                <td><spring:message code="app.operationType"/></td>
                                <select name="operationType" class="form-control form-control-user">
                                    <option value="WZ">WZ</option>
                                    <option value="PZ">PZ</option>
                                </select>

                            </div>
                        </div>
                        <div class="form-group row">
                            <div class="col-sm-6">
                                <td><spring:message code="app.supplireMenu"/></td>
                                <form:select path="supplier" items="${suppliers}"
                                             itemLabel="name" itemValue="id"
                                             class="form-control form-control-user"/>
                            </div>
                        </div>

                        <button type="submit" class="btn btn-primary btn-user btn-block">
                            <spring:message code="app.add"/></button>
                        <div style="margin-top: 10px">
                            <a href="/admin/sOi/details/${sOi.id}" class="btn btn-primary btn-user btn-block">
                                <spring:message code="app.cancel"/></a>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
<%@ include file="../footer.jsp" %>
</html>
