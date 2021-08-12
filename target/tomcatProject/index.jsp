<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
<head>
    <title>homework41</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<form action="pages/authorization.jsp" class="ia">
    <button>Sign in</button>
</form>

<form action="pages/registration.jsp" class="ir">
    <button>Sign up</button>
</form>

<form action="${pageContext.request.contextPath}/listLog" method="get" class="il">
    <button>All Logs</button>
</form>
</body>
</html>