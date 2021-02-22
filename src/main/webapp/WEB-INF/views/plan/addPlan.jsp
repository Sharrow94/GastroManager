<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Dodaj składnik</title>
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
                        <form:form method="post" modelAttribute="plan">
                            <div class="text-center">
                                <h1 class="h4 text-gray-900 mb-4"><spring:message code="add.addPlan"/></h1>
                            </div>
                            <div class="form-group row">
                                <div class="col-sm-6 mb-3 mb-sm-0">
                                    <td><spring:message code="add.names"/>:</td>
                                    <form:input path="name" placeholder="Podaj nazwe"
                                                class="form-control form-control-user"/>

                                </div>
                            </div>
                            <div class="form-group row">
                                <div class="col-sm-6 mb-3 mb-sm-0">
                                    <td><spring:message code="add.price"/>:</td>
                                    <form:input path="price" placeholder="Ustalona dcena"
                                                class="form-control form-control-user"/>
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


<%--<form:form method="post" modelAttribute="plan">--%>
<%--    <table>--%>
<%--        <tr>--%>
<%--            <td>Name:</td>--%>
<%--            <td><form:input path="name"/></td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td>Ustalona cena:</td>--%>
<%--            <td><form:input path="price"/><br></td>--%>
<%--        </tr>--%>
<%--    </table>--%>
<%--    <input type="submit">--%>
<%--</form:form>--%>
</body>
<%@ include file="../footer.jsp" %>
</html>
