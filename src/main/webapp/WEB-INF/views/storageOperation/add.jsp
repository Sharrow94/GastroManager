<%--
  Created by IntelliJ IDEA.
  User: maciej
  Date: 18.02.2021
  Time: 22:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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
                <div class="col-lg-5 d-none d-lg-block bg-register-image"></div>
                <div class="col-lg-7">
                    <div class="p-5">
                        <form:form modelAttribute="storageOperation" action="/admin/storageOperation/add" method="post">
                            <div class="text-center">
                                <h1 class="h4 text-gray-900 mb-4"> <spring:message code="app.addStorageOperation"/></h1>
                            </div>
                            <div class="form-group row">
                                <div class="col-sm-6 mb-3 mb-sm-0">
                                    <td><spring:message code="add.selectIngrediends"/></td>
                                    <form:select path="ingredient" items="${ingredients}"
                                                 itemLabel="name" itemValue="id"
                                                 class="form-control form-control-user"/>

                                </div>
                            </div>
                            <div class="form-group row">
                                <div class="col-sm-6 mb-3 mb-sm-0">
                                    <td><spring:message code="add.enterQuantity"/></td>
                                    <form:input path="quantity" class="form-control form-control-user"/>

                                </div>
                            </div>
                            <div class="form-group row">
                                <div class="col-sm-6">
                                    <td><spring:message code="add.unitPrice"/></td>
                                    <form:input path="unitPrice" class="form-control form-control-user"/>

                                </div>
                            </div>

                            <button type="submit" class="btn btn-primary btn-user btn-block">
                                <spring:message code="app.add"/></button>
                        </form:form>
                    </div>
                </div>
            </div>
        </div>
    </div>


<%--<h1>Dodaj pozycję do dokumentu</h1>--%>
<%--<form:form modelAttribute="storageOperation" action="/storageOperation/add" method="post">--%>
<%--    <input type="hidden" value="${sOi.id}" name="storageOperationItem"/>--%>
<%--    Wybierz składnik:<form:select path="ingredient" items="${ingredients}"  itemLabel="name" itemValue="id"/><br>--%>
<%--    Podaj ilość<form:input path="quantity"/><br>--%>
<%--    Podaj cenę jednostkową<form:input path="unitPrice"/><br>--%>
<%--    <input type="submit" value="dodaj">--%>
<%--</form:form>--%>

</body>
<%@ include file="../footer.jsp" %>
</html>
