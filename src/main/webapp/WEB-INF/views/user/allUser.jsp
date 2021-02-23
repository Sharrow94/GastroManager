<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="../header.jsp" %>


        <sec:authorize access="isAuthenticated()">
            <p>Zalogowany jako: <sec:authentication property="name"/></p>
            <p>Posiada role: <sec:authentication property="authorities"/></p>
        </sec:authorize>
        <sec:authorize access="isAuthenticated()">
            <form action="<c:url value="/logout"/>" method="post">
                <input type="submit" value="Wyloguj">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            </form>
        </sec:authorize>
        <table border="1">
            <h2>Wszyscy użytkownicy:</h2>
            <thead>

            <th>Id</th>
            <th>User Name</th>
            <th>Emial</th>
            <th>First Name</th>
            <th>Last Name</th>

            </thead>
            <tbody>
            <c:forEach items="${users}" var="user">
                <tr>
                    <td><c:out value="${user.id}"/></td>
                    <td><c:out value="${user.userName}"/></td>
                    <td><c:out value="${user.email}"/></td>
                    <td><c:out value="${user.firstName}"/></td>
                    <td><c:out value="${user.lastName}"/></td>
                    <td>
                        <a href="<c:out value="/user/edit/${user.id}"/> ">Edit</a>
                        <a href="<c:out value="/user/delete/${user.id}"/> ">Delete</a>
                    </td>
                </tr>
            </c:forEach>
            <a href="<c:url value="/user/add?id=${user.id}"/>">Add new book</a>
            </tbody>
        </table>
<%@ include file="../footer.jsp" %>
