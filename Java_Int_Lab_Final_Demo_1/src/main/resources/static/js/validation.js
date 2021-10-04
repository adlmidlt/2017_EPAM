$(document).ready(function () {

    /*Validation for last_name*/
    $("#family").blur(function () {
        if ($(this).val() !== ' ') {
            let pattern = /^[а-яА-Я-]{3,16}$/;
            if (pattern.test($(this).val())) {
                $(this).css({'border': '1px solid #569b44'});
                $('#valid-last-name').text('Верно');
            } else {
                $(this).css({'border': '1px solid #ff0000'});
                $('#valid-last-name').text('Введите от 3 до 16 символов' +
                    ' или поменяется раскладку на русский');
            }
        }
    });

    /*Validation for first_name*/
    $("#name").blur(function () {
        if ($(this).val() !== ' ') {
            let pattern = /^[а-яА-Я-]{3,16}$/;
            if (pattern.test($(this).val())) {
                $(this).css({'border': '1px solid #569b44'});
                $('#valid-first-name').text('Верно');
            } else {
                $(this).css({'border': '1px solid #ff0000'});
                $('#valid-first-name').text('Введите от 3 до 16 символов' +
                    ' или поменяется раскладку на русский');
            }
        }
    });

    /*Validation for login*/
    $("#login").blur(function () {
        if ($(this).val() !== ' ') {
            let pattern = /^[a-z0-9_-]{3,16}$/;
            if (pattern.test($(this).val())) {
                $(this).css({'border': '1px solid #569b44'});
                $('#valid-login').hide();
            } else {
                $(this).css({'border': '1px solid #ff0000'});
                $('#valid-login').text('Введите от 3 до 16 символов' +
                    ' или поменяется раскладку на английский');
            }
        }
    });

    /*Validation for password*/
    $(".passw").blur(function () {
        if ($(this).val() !== ' ') {
            let pattern = /^[a-z0-9_-]{6,18}$/;
            if (pattern.test($(this).val())) {
                $(this).css({'border': '1px solid #569b44'});
                $('.valid-password').hide();
            } else {
                $(this).css({'border': '1px solid #ff0000'});
                $('.valid-password').text('Введите от 3 до 16 символов' +
                    ' или поменяется раскладку на английский');
            }
        }
    });
});