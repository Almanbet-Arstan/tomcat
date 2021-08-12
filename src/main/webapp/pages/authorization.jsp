<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<head>
    <meta charset="utf-8">
    <title>Authorization</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<form action="${pageContext.request.contextPath}/authorization" method="post" class="login" style="text-align: center;
    font-size: 25px;
    font-family: monospace;">
    <p>
        <label for="login">Логин:</label>
        <input type="text" name="login" id="login">
    </p>
    <p>
        <label for="password">Пароль:</label>
        <input type="password" name="password" id="password">
    </p>
    <p class="login-submit">
        <button type="submit" class="login-button" style="font-size: 25px;font-family: cursive;width: 20%;border-radius: 10px;">Войти</button>
    </p>

    <p class="forgot-password"><a href="https://i.ytimg.com/vi/TgxCjxOgZSU/maxresdefault.jpg" style="text-decoration: none;
    color: red;">Забыл пароль?</a></p>
</form>
</body>
</html>
