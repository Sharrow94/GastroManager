<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<%@ include file="../header.jsp" %>
<body>
<h1>Czy na pewno chcesz usunąć?</h1>
<a href="/admin/meal/delete/${id}"><button>Tak</button></a>
<a href="/app/meal/list"><button>Nie</button></a>

</body>
<%@ include file="../footer.jsp" %>
</html>
