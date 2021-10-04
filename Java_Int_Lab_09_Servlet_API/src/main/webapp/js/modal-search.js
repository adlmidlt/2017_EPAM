const modalSearch = document.getElementById('search-modal');
const btnSearch = document.getElementById('btn-search');
const spanSearch = document.getElementsByClassName("close-search")[0];

btnSearch.onclick = function () {
    modalSearch.style.display = "block";
};

spanSearch.onclick = function () {
    modalSearch.style.display = "none";
};

window.onclick = function (event) {
    if(event.target === modalSearch) {
        modalSearch.style.display = "none";
    }
};