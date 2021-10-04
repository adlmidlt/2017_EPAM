
let countItem = 0;
let countBinItem = 0;
const percent = Math.floor((Math.random() * 15) + 1);


$(".put-basket").click(function () {
    countItem++;
    let item = this.parentElement.parentElement.cloneNode(true);

    $("#item-basket-shop").append(item);
    $("#item-basket-shop input").remove();
    $("#item-basket-shop .item-name").remove();
    $("#item-count").html(countItem);
    $("#item-basket-shop .put-basket").append("<input class='delete' type='button' value='Удалить товар' " +
        "onClick='deleteItem(this)'>");
    item.setAttribute("id", countBinItem++);

    let sum = 0;
    item = document.querySelectorAll("#item-basket-shop .item-price");
    item.forEach(el => {
        sum += Number(el.innerText);
        $("#sum").text(sum);
        $("#discount").text('Скидка ' + percent + '%:');
        let discSum = sum * percent / 100;
        $("#discSum").text(discSum);
        $("#final-sum").text(sum - discSum);
    });
});

let deleteItem = function (param) { 
    let deleteBasket = param.parentElement.parentElement.parentElement.getAttribute("id");
    $("#" + deleteBasket).remove();
    countItem--;
    $("#item-count").html(countItem);

    let sum = 0;
    let item = document.querySelectorAll("#item-basket-shop .item-price");
    item.forEach(el => {
        sum += Number(el.innerText);
        $("#sum").text(sum);
        $("#discount").text('Скидка ' + percent + '%:');
        let discSum = sum * percent / 100;
        $("#discSum").text(discSum);
        $("#final-sum").text(sum - discSum);
    });
 };

 







