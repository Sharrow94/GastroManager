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
                        <form:form method="post" modelAttribute="meal" action="/admin/meal/edit">
                            <form:hidden path="id"/>
                            <form:hidden path="diet"/>
                            <form:hidden path="price"/>
                            <div class="text-center">
                                <h1 class="h4 text-gray-900 mb-4"><spring:message code="add.editMeal"/>: ${meal.name}</h1>
                            </div>
                            <div class="form-group row">
                                <div class="col-sm-6 mb-3 mb-sm-0">
                                    <td><spring:message code="add.names"/>:</td>
                                    <form:input path="name"  placeholder="Write name meal"
                                                class="form-control form-control-user"/>
                                </div>
                            </div>
                            <div class="form-group row">
                                <div class="col-sm-6 mb-3 mb-sm-0">
                                    <td><spring:message code="add.description"/>:</td>
                                    <form:textarea path="description" placeholder="Description of the meal"
                                                   class="form-control form-control-user"/>
                                </div>
                            </div>

                            <button type="submit" class="btn btn-primary btn-user btn-block">
                                <spring:message code="add.editMeal"/></button>
                        </form:form>
                    </div>
                </div>
            </div>
        </div>
    </div>

<%--<h1>Edytuj ${meal.name}</h1>--%>
<%--<form:form method="post" modelAttribute="meal" action="/meal/edit">--%>
<%--    <form:hidden path="id"/>--%>
<%--    <form:hidden path="diet"/>--%>
<%--    <form:hidden path="price"/>--%>
<%--    <form:input path="name"/> Nazwa<br>--%>
<%--    <form:textarea path="description"/> Opis przyrządzenia<br>--%>
<%--    <input type="submit">--%>
<%--</form:form>--%>

</body>
<%@ include file="../footer.jsp" %>
</html>
