function filterItems(category) {
    const boxes = document.querySelectorAll('.box');

    boxes.forEach(box => {
        const boxCategory = box.getAttribute('data-category');
        if (category === 'all' || boxCategory === category) {
            box.style.display = 'block';
        } else {
            box.style.display = 'none';
        }
    });
}
