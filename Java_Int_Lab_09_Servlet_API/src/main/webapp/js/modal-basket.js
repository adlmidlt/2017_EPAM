const modalBasket = document.getElementById('modal-basket');
const btnBasket = document.getElementById('btn-basket');
const spanBasket = document.getElementsByClassName("close-basket")[0];

btnBasket.onclick = function () {
    modalBasket.style.display = "block";
};

spanBasket.onclick = function () {
    modalBasket.style.display = "none";
};

window.onclick = function (event) {
    if(event.target === modalSearch) {
        modalBasket.style.display = "none";
    }
};