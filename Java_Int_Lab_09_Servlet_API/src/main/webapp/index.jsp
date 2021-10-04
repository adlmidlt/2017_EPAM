
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored ="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="../css/header.css">
    <link rel="stylesheet" href="../css/section.css">
    <link rel="stylesheet" href="../css/footer.css">
    <link rel="stylesheet" href="../css/modal.css">
    <link rel="stylesheet" href="../css/search.css">
    <link rel="stylesheet" href="../css/basket.css">
    <script src="../resources/jquery-3.3.1.min.js"></script>
    <title>Shop Smoke</title>
</head>
<body>
    <div id="container">
        <header id="main-header">
            <div id="name-user"> Ларионов Анатолий</div>
            <div id="a-exit"><a href="authorization">Exit</a></div>
            <!--Modal window search-->
            <div id="btn-search"><input type="button" value="Поиск"></div>
            <div id="search-modal" class="modal-search">
                <div class="modal-content-search">
                    <div class="close-search">&times;</div>
                    <h1 id="text-search-h1">Поиск</h1>
                    <div id="text-search">
                        <input id="search-list" type="search" placeholder="Поиск">
                        <input id="btn-search-click" type="button" value="Поиск" onclick="search()">
                    </div>
                    <div id="wrapper-search">
                        <div class="item-view-hidden">
                            <div class="item-img">
                                <img class="size-img-search" src="../img/category/kalyan/Kalayn Black Stone.JPG" alt="Black Stone">
                            </div>
                            <div class="item-name-search">Black Stone</div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!--Modal Basket-->
            <div id="btn-basket"><input type="button" value="Корзина">
                <span id="item-count">0</span>
            </div>
            <div id="modal-basket" class="modal-basket">
                <div class="modal-content-basket">
                    <div class="close-basket">&times;</div>
                    <div><h1 id="text-basket-h1">Корзина</h1></div>
                    <div id="item-basket-shop"></div>
                <div id="item-basket-count-items">
                    <span>Сумма товаров: </span>
                    <span id="sum">0 </span>$<br>
                    <span id="discount">0</span>
                    <span id="discSum">0</span>$<br>
                    <span id="final-sum-descr">Итого:</span>
                    <span id="final-sum">0</span>$
                </div>
                </div>
            </div>
        </header>
        <section class="main-section">
            <div class="items-wrapper">
                <div class="name-category">Кальян</div>
                <c:forEach items="${products}" var="product">
                    <div class="item">
                        <div class="item-view">
                            <div class="item-img">
                                <img class="size-img" src="../img/category/kalyan/Kalayn Black Stone.JPG" alt="Black Stone">
                            </div>
                            <div class="item-name">${product.name}</div>
                        </div>
                        <div class="item-details">
                            <div class="item-description">${product.description}</div>
                            <div>Цена: <span class="item-price">${product.price}</span>$</div>
                            <div class="put-basket"><input class="add-basket" type="button" value="Положить в корзину"></div>
                        </div>
                    </div>
                </c:forEach>
                </div>
        </section>
        <footer id="main-footer">
            <div class="name-address-web"><address>smoke-shop.ru</address></div>
            <div class="name-production">Student Production &copy;</div>
        </footer>
        </div>
    <script src="../js/extension-item.js"></script>
    <script src="../js/modal-search.js"></script>
    <script src="../js/modal-basket.js"></script>
    <script src="../js/search.js"></script>
    <script src="../js/basket.js"></script>
</body>
</html>
