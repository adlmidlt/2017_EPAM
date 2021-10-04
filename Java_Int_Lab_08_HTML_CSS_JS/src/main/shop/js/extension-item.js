const container = document.querySelector('.main-section');
const items = container.querySelectorAll('.item');
let previousIndex = 0;

for (let i = 0; i < items.length; i++) {
    items[i].addEventListener('click', (ev) => {
        items[previousIndex].classList.remove('visible');
        items[i].classList.add('visible');
        previousIndex = i;
    });
}
