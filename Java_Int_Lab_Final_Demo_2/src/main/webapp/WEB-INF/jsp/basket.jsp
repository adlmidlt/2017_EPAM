<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--Modal Basket-->
<div id="btn-basket"><input type="button" value="Корзина">
    <span id="item-count">0</span>
</div>
<div id="modal-basket" class="modal-basket">
    <div class="modal-content-basket">
        <div class="close-basket">&times;</div>
        <div><h1 id="text-basket-h1">Корзина</h1></div>
        <div id="item-basket-shop"}>
        </div>
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
