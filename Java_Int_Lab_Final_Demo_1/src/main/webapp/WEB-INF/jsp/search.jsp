<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                    <img class="size-img-search" src="../category/kalyan/Kalayn Black Stone.JPG"
                         alt="Black Stone">
                </div>
                <div class="item-name-search">Black Stone</div>
            </div>
        </div>
    </div>
</div>
