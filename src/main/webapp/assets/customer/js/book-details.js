document.querySelectorAll('.price-value').forEach(el => {
    const rawValue = el.textContent.trim();

    const value = parseFloat(rawValue);

    if (!isNaN(value)) {
        const formattedValue = value.toLocaleString('vi-VN');
        if (el.classList.contains('minus-value')) {
            el.innerHTML = `-${formattedValue}<span class="currency-symbol">₫</span>`;
        } else {
            el.innerHTML = `${formattedValue}<span class="currency-symbol">₫</span>`;
        }
    }
});