<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="../css/registration.css">
    <script src="../resources/jquery-3.3.1.min.js"></script>
    <script src="../js/validation.js"></script>
    <title>Registration</title>
</head>
<body>
<form id="reg" action="registration" method="post">
    <div id="form-reg">
        <div id="text-reg"><span>Регистрация</span></div>
        <div id="field-last_name">
            Фамилия:<br>
            <input type="text" placeholder="Фамилия" id="family" name="lastName" required>
            <div id="valid-last-name"></div>
        </div>
        <div id="field-first_name">
            Имя:<br>
            <input type="text" placeholder="Имя" id="name" name="firstName" required>
            <div id="valid-first-name"></div>
        </div>
        <div id="field-login">
            Логин:<br>
            <input type="text" placeholder="Login" id="login" name="login" required>
            <div id="valid-login"></div>
        </div>
        <div class="filed-password">
            Пароль:<br>
            <input type="password" placeholder="p*a*s*s*w*o*r*d" class="passw" name="password" required>
            <div class="valid-password"></div>
        </div>
        <div class="filed-password">
            Повторите пароль:<br>
            <input type="password" placeholder="p*a*s*s*w*o*r*d" class="passw" required>
            <div class="valid-password"></div>
        </div>
        <div id="btn-auth">
            <input type="submit" value="Зарегистрироваться">
        </div>
        <div id="url-reg">
            <a href="auth">Авторизоваться</a>
        </div>
    </div>
</form>
</body>
</html>
