<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<%@ include file="../header.jsp" %>
<body>

    ${ingredientInStorage.id}
    ${ingredientInStorage.quantity}
    ${ingredientInStorage.unit}
    ${ingredientInStorage.ingredientId}

</body>
<%@ include file="../footer.jsp" %>
</html>
