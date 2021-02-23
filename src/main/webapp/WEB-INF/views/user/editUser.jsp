<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>



<html>
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
                        <form:form method="post" modelAttribute="user" >
                            <div class="text-center">
                                <h1 class="h4 text-gray-900 mb-4"> <spring:message code="app.editUser"/></h1>
                            </div>
                            <form:hidden path="id"/>
                            <div class="form-group row">
                                <div class="col-sm-6 mb-3 mb-sm-0">
                                    <td><spring:message code="app.nickName"/></td>
                                    <form:input path="userName" class="form-control form-control-user"/>
                                    <form:errors path="userName"/>

                                </div>
                            </div>
                            <div class="form-group row">
                                <div class="col-sm-6 mb-3 mb-sm-0">
                                    <td><spring:message code="app.firstName"/></td>
                                    <form:input path="firstName" class="form-control form-control-user"/>
                                    <form:errors path="firstName"/>

                                </div>
                            </div>
                            <div class="form-group row">
                                <div class="col-sm-6">
                                    <td><spring:message code="app.lastName"/></td>
                                    <form:input path="lastName" class="form-control form-control-user"/>
                                    <form:errors path="lastName"/>

                                </div>
                            </div>
                            <div class="form-group row">
                                <div class="col-sm-6 mb-3 mb-sm-0">
                                    <td><spring:message code="app.email"/></td>
                                    <form:input path="email" class="form-control form-control-user"/>
                                    <form:errors path="email"/>

                                </div>
                            </div>
                            <div class="form-group row">
                                <div class="col-sm-6 mb-3 mb-sm-0">
                                    <td><spring:message code="app.password"/></td>
                                    <form:input path="password" class="form-control form-control-user"/>
                                    <form:errors path="password"/>

                                </div>
                            </div>

                            <button type="submit" class="btn btn-primary btn-user btn-block">
                                <spring:message code="app.edit"/></button>
                        </form:form>
                    </div>
                </div>
            </div>
        </div>
    </div>

<%--<div class="container w-25">--%>
<%--    <form:form method="post" modelAttribute="user"  >--%>
<%--        <div>--%>
<%--                &lt;%&ndash;                        <h2><spring:message code="app.registration"/>: </h2>&ndash;%&gt;--%>
<%--            <h2>Edit User: </h2>--%>
<%--            <div>--%>
<%--                <h4>Nick Name:</h4>--%>
<%--                <form:hidden path="id"/>--%>
<%--                <form:input path="userName"/>--%>
<%--                <form:errors path="userName"/>--%>
<%--            </div>--%>
<%--            <div>--%>
<%--                <h4>First Name:</h4>--%>
<%--                <form:input path="firstName"/>--%>
<%--                <form:errors path="firstName"/>--%>
<%--            </div>--%>
<%--            <div>--%>
<%--                <h4>Last Name:</h4>--%>
<%--                <form:input path="lastName"/>--%>
<%--                <form:errors path="lastName"/>--%>
<%--            </div>--%>
<%--            <div>--%>
<%--                <h4>Email:</h4>--%>
<%--                <form:input path="email"/>--%>
<%--                <form:errors path="email"/>--%>
<%--            </div>--%>
<%--            <div>--%>
<%--                <h4>Password:</h4>--%>
<%--                <form:input path="password"/>--%>
<%--                <form:errors path="password"/>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--        <input type="submit" name="Save">--%>

<%--    </form:form>--%>

<%--</div>--%>
</body>
<%@ include file="../footer.jsp" %>
</html>


