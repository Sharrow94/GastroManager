<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="../header.jsp" %>
<body>
<form:form method="post" modelAttribute="mealName">
<div style="max-width: 600px; margin-left: 100px; margin-bottom: 200px;">
    <div class="card">
        <div class="card-header">
            <h1>Wybierz rodzaj posiłku: </h1>
        </div>
        <div class="card-body">
            <c:forEach items="${mealNames}" var="tmp">
                <div class="custom-control custom-radio">
                    <input class="custom-control-input" id="${tmp.id}" type="radio" name="id" value="${tmp.id}">
                    <label class="custom-control-label" for="${tmp.id}">${tmp.name}</label>
                </div>
            </c:forEach>
            <input type="submit" class="btn btn-primary"
                   style="background-color:#f6c23e; border-color:#f6c23e;color:#3a3b45; size: auto"
                   value="Dalej">
        </div>
    </div>
</div>
</form:form>

<%@ include file="../footer.jsp" %>