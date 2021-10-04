<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="../css/authorization.css">
    <script src="../resources/jquery-3.3.1.min.js"></script>
    <script src="../js/validation.js"></script>
    <title>Авторизация</title>
</head>
<body>
<form id="auth" action="auth" method="POST">
    <div id="form-auth">
        <div id="text-auth"><span>Авторизация</span></div>
        <div id="field-login">
            Логин:<br>
            <input type="text" placeholder="login" name="login" id="login" required>
            <div id="valid-login"></div>
        </div>
        <div id="filed-password">
            Пароль:<br>
            <input type="password" placeholder="******" name="password" required>
            <div class="valid-password"></div>
        </div>
        <div id="btn-auth">
            <input type="submit" value="Войти">
        </div>
        <div id="url-reg">
            <a href="registration">Регистрация</a>
        </div>
    </div>
</form>
</body>
</html>
