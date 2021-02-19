<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../header.jsp" %>
            <div class="container w-25">
                <form:form method="post" modelAttribute="user"  >
                    <div>
                            <%--                        <h2><spring:message code="app.registration"/>: </h2>--%>
                        <h2>Edit User: </h2>
                        <div>
                            <h4>Nick Name:</h4>
                            <form:hidden path="id"/>
                            <form:input path="userName"/>
                            <form:errors path="userName"/>
                        </div>
                        <div>
                            <h4>First Name:</h4>
                            <form:input path="firstName"/>
                            <form:errors path="firstName"/>
                        </div>
                        <div>
                            <h4>Last Name:</h4>
                            <form:input path="lastName"/>
                            <form:errors path="lastName"/>
                        </div>
                        <div>
                            <h4>Email:</h4>
                            <form:input path="email"/>
                            <form:errors path="email"/>
                        </div>
                        <div>
                            <h4>Password:</h4>
                            <form:input path="password"/>
                            <form:errors path="password"/>
                        </div>
                    </div>
                    <input type="submit" name="Save">

                </form:form>

            </div>
<%@ include file="../footer.jsp" %>