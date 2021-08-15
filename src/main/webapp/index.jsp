<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
<body>
<form action="${pageContext.request.contextPath}/user" method="post">
    <input type="text" name="login" placeholder="Введите ваш логин:" style="margin-left: 5% ; margin-top: 1%;">
    <input type="password" name="password" placeholder="Введите ваш пароль:" style="margin-left: 5% ; margin-top: 1%;">
    <input type="email" name="email" placeholder="Введите ваш email:" style="margin-left: 5% ; margin-top: 1%;">
    <input type="text" name="gender" placeholder="Введите ваш пол:" style="margin-left: 5% ; margin-top: 1%;">
    <input type="submit" name="submit" value="Выполнить">
</form>
</body>
</html>
