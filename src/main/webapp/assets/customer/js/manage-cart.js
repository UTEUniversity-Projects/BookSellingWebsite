// Remove cart item
document.querySelectorAll('.remove-item').forEach((button) => {
    button.addEventListener('click', function () {
    const row = this.closest('tr');
    if (row) {
        row.remove();
    }
    });
});