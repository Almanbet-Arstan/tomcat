<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/style.css">
    <title>Registration</title>
</head>
<body>
<main style="text-align: center;
    font-size: 25px;
    font-family: cursive;">
    <div class="register-form-container">
        <form action="${pageContext.request.contextPath}/registration" method="post">
            <h1 class="form-title">
                Регистрация
            </h1>
            <div class="form-fields">
                <div class="form-field">
                    <input type="text" name="login" placeholder="Login" style="font-size: 25px;
    border-radius: 10px;
    margin-bottom: 10px;">
                </div>
                <div class="form-field">
                    <input type="email" name="email" placeholder="Email" style="font-size: 25px;
    border-radius: 10px;
    margin-bottom: 10px;">
                </div>
                <div class="form-field">
                    <input type="password" name="password" placeholder="Password" required minlength="5" maxlength="128" style="font-size: 25px;
    border-radius: 10px;
    margin-bottom: 10px;">
                </div>
            </div>
            <div class="form-buttons">
                <input type="submit" name="submit" value="Registration" style="font-size: 25px;
    width: 24%;
    background: blueviolet;
    color: black;">
            </div>
        </form>
    </div>
</main>
</body>
</html>
