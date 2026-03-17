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