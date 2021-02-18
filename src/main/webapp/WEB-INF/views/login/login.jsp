<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Logowanie</title>
</head>
<body>

<section class="dashboard-section">
    <div class="container pt-4 pb-4">
        <div class="border-dashed view-height">
            <div class="container w-25">

                    <h1>Login: </h1>
                <form method="post">
                    <div><label> User Name : <input type="text" name="username"/> </label></div>
                    <div><label> Password: <input type="password" name="password"/> </label></div>
                    <div><input type="submit" value="Sign In"/></div>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                </form>
            </div>
        </div>
    </div>
</section>


</body>
</html>
