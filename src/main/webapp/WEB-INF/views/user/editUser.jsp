<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<%@ include file="../header.jsp" %>
<header class="page-header page-header-compact page-header-light border-bottom bg-white mb-4">
    <div class="container-fluid">
        <div class="page-header-content">
            <div class="row align-items-center justify-content-between pt-3">
                <div class="col-auto mb-3">
                    <h1 class="page-header-title">
                        <div class="page-header-icon">
                            <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"
                                 fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round"
                                 stroke-linejoin="round" class="feather feather-user">
                                <path d="M20 21v-2a4 4 0 0 0-4-4H8a4 4 0 0 0-4 4v2"></path>
                                <circle cx="12" cy="7" r="4"></circle>
                            </svg>
                        </div>
                        Account Settings - Profile
                    </h1>
                </div>
            </div>
        </div>
    </div>
</header>
<body>
<div class="container mt-4">
    <!-- Account page navigation-->
    <nav class="nav nav-borders">
        <a class="nav-link active ml-0" href="<c:url value="/app/user/edit"/>">Profile</a>
        <a class="nav-link" href="<c:url value="/app/user/biling"/>">Billing</a>
        <a class="nav-link" href="<c:url value="/app/user/security"/>">Security</a>
    </nav>
    <hr class="mt-0 mb-4">
    <div class="row">
        <%--        <div class="col-xl-4">--%>
        <%--            <!-- Profile picture card-->--%>
        <%--            <div class="card">--%>
        <%--                <div class="card-header">Profile Picture</div>--%>
        <%--                <div class="card-body text-center">--%>
        <%--                    <!-- Profile picture image-->--%>
        <%--                    <img class="img-account-profile rounded-circle mb-2" src="assets/img/illustrations/profiles/profile-1.png" alt="">--%>
        <%--                    <!-- Profile picture help block-->--%>
        <%--                    <div class="small font-italic text-muted mb-4">JPG or PNG no larger than 5 MB</div>--%>
        <%--                    <!-- Profile picture upload button-->--%>
        <%--                    <button class="btn btn-primary" type="button">Upload new image</button>--%>
        <%--                </div>--%>
        <%--            </div>--%>
        <%--        </div>--%>
        <div class="col-xl-8">
            <!-- Account details card-->
            <div class="card mb-4">
                <div class="card-header">Account Details</div>
                <div class="card-body">
                    <form:form method="post" modelAttribute="user" action="/app/user/update">
                        <!-- Form Group (username)-->
                        <form:hidden path="id"/>
                        <form:hidden path="password"></form:hidden>
                        <form:hidden path="roles"></form:hidden>
                        <div class="form-group">
<%--                            <label class="small mb-1" for="inputUsername">Username (how your name will appear to other--%>
<%--                                users on the site)</label>--%>
<%--                            <input class="form-control" id="inputUsername" type="text" placeholder="Enter your username"--%>
<%--                                   value="username">--%>
                            <td><spring:message code="app.nickName"/></td>
                            <form:input path="userName" class="form-control"/>
                            <form:errors path="userName"/>
                        </div>
                        <!-- Form Row-->
                        <div class="form-row">
                            <!-- Form Group (first name)-->
                            <div class="form-group col-md-6">
<%--                                <label class="small mb-1" for="inputFirstName">First name</label>--%>
<%--                                <input class="form-control" id="inputFirstName" type="text"--%>
<%--                                       placeholder="Enter your first name" value="Valerie">--%>
                                <td><spring:message code="app.firstName"/></td>
                                <form:input path="firstName" class="form-control"/>
                                <form:errors path="firstName"/>
                            </div>
                            <!-- Form Group (last name)-->
                            <div class="form-group col-md-6">
<%--                                <label class="small mb-1" for="inputLastName">Last name</label>--%>
<%--                                <input class="form-control" id="inputLastName" type="text"--%>
<%--                                       placeholder="Enter your last name" value="Luna">--%>
                                <td><spring:message code="app.lastName"/></td>
                                <form:input path="lastName" class="form-control"/>
                                <form:errors path="lastName"/>
                            </div>
                        </div>
                        <!-- Form Row -->
                        <div class="form-row">
                            <!-- Form Group (organization name)-->
                            <div class="form-group col-md-6">
                                <td><spring:message code="app.city"/></td>
                                <form:input path="city" class="form-control "/>
                                <form:errors path="city"/>
                            </div>
                            <div class="form-group col-md-6">
                                <td><spring:message code="app.postNumber"/></td>
                                <form:input path="postNumber" class="form-control "/>
                                <form:errors path="postNumber"/>
                            </div>
                            <div class="form-group col-md-6">
                                <td><spring:message code="app.street"/></td>
                                <form:input path="street" class="form-control "/>
                                <form:errors path="street"/>
                            </div>
                            <div class="form-group col-md-6">
                                <td><spring:message code="app.nr"/></td>
                                <form:input path="nr" class="form-control "/>
                                <form:errors path="nr"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <td><spring:message code="app.email"/></td>
                            <form:input path="email" class="form-control "/>
                            <form:errors path="email"/>
                        </div>
                        <div class="form-row">
                            <div class="form-group col-md-6">
                                <td><spring:message code="app.phoneNumber"/></td>
                                <form:input path="phoneNumber" class="form-control "/>
                                <form:errors path="phoneNumber"/>
                            </div>
                        </div>
                        <!-- Save changes button-->
                        <button type="submit" class="btn btn-primary">
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


