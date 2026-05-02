document.addEventListener('DOMContentLoaded', function() {
    const form = document.getElementById('rotForm');
    const btn = document.getElementById('submitBtn');

    if (form) {
        form.addEventListener('submit', function(event) {
            btn.classList.add('is-loading');
            btn.disabled = true;
        });
    }
});

document.querySelectorAll('.map-pair input').forEach((input, index, inputs) => {
    input.addEventListener('input', () => {
        if (input.value.length === 1 && index < inputs.length - 1) {
            inputs[index + 1].focus(); // Auto-focus next box
        }
    });

    // Allow backspacing to go to previous box
    input.addEventListener('keydown', (e) => {
        if (e.key === 'Backspace' && input.value === '' && index > 0) {
            inputs[index - 1].focus();
        }
    });
});