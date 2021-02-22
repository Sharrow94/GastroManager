<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Add payments:</title>
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
                        <form:form method="post" modelAttribute="payment" action="/admin/payments/add">
                            <div class="text-center">
                                <h1 class="h4 text-gray-900 mb-4"> <spring:message code="add.addPayments"/></h1>
                            </div>
                            <div class="form-group row">
                                <div class="col-sm-6 mb-3 mb-sm-0">
                                    <td><spring:message code="add.cost"/></td>
                                    <form:input path="cost"
                                                    class="form-control form-control-user"/>
                                </div>
                            </div>
                            <div class="form-group row">
                                <div class="col-sm-6 mb-3 mb-sm-0">
                                    <td><spring:message code="add.data"/></td>
                                    <form:input path="date" type="datetime-local"
                                                class="form-control form-control-user"/>
                                </div>
                            </div>
                            <div class="form-group row">
                                <div class="col-sm-6">
                                    <td><spring:message code="add.paymentsStatus"/></td>
                                        <form:checkbox path="payed" value="true"/>
                                </div>
                            </div>
                            <div class="form-group row">
                                <div class="col-sm-6 mb-3 mb-sm-0">
                                <td><spring:message code="add.orderId"/></td>
                                <form:input path="orders.id" placeholder="Podaj nume"
                                                class="form-control form-control-user"/>
                                </div>
                            </div>
                            <div class="form-group row">
                                <div class="col-sm-6 mb-3 mb-sm-0">
                                <td><spring:message code="add.orderId"/></td>
                                <form:input path="users.id" placeholder="write number"
                                                class="form-control form-control-user"/>
                                </div>
                            </div>

                            <button type="submit" class="btn btn-primary btn-user btn-block">
                                <spring:message code="add.addPayments"/></button>
                        </form:form>
                    </div>
                </div>
            </div>
        </div>
    </div>

<%--</div>--%>
<%--<form:form method="post" modelAttribute="payment" action="/payments/add">--%>
<%--    <table>--%>
<%--        <tr>--%>
<%--&lt;%&ndash;            <td>Cost:</td>&ndash;%&gt;--%>
<%--&lt;%&ndash;            <td><form:input path="cost"/></td>&ndash;%&gt;--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--&lt;%&ndash;            <td>Data:</td>&ndash;%&gt;--%>
<%--&lt;%&ndash;            <td><form:input path="date" type="datetime-local"/><br></td>&ndash;%&gt;--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--&lt;%&ndash;            <td>Payments status:</td>&ndash;%&gt;--%>
<%--&lt;%&ndash;            <td>&ndash;%&gt;--%>
<%--&lt;%&ndash;                <form:checkbox path="payed" value="true"/>Payed&ndash;%&gt;--%>
<%--&lt;%&ndash;            </td>&ndash;%&gt;--%>
<%--        </tr>--%>
<%--&lt;%&ndash;        <tr>&ndash;%&gt;--%>
<%--&lt;%&ndash;            <td>Orders id:</td>&ndash;%&gt;--%>
<%--&lt;%&ndash;            <td><form:input path="orders.id"/></td>&ndash;%&gt;--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--&lt;%&ndash;            <td>User id:</td>&ndash;%&gt;--%>
<%--&lt;%&ndash;            <td><form:input path="users.id"/></td>&ndash;%&gt;--%>
<%--        </tr>--%>

<%--    </table>--%>
<%--    <input type="submit">--%>
<%--</form:form>--%>
</body>
<%@ include file="../footer.jsp" %>
</html>
