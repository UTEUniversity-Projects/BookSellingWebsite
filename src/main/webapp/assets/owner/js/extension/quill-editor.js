document.addEventListener("DOMContentLoaded", function() {
    const quill = new Quill('#editor', {
        theme: 'snow'
    });

    document.getElementById('review-btn').addEventListener('click', function(event) {
        event.preventDefault();
        document.getElementById('review-content').innerHTML = quill.root.innerHTML;
        document.getElementById('review-container').style.display = 'block';
    });

    document.getElementById('save-btn').addEventListener('click', function() {
        const editorContent = quill.root.innerHTML;

        // Gửi nội dung qua Fetch API (AJAX) mà không reload trang
        fetch('/save-content', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({
                content: editorContent,
            }),
        })
            .then(response => response.json())
            .then(data => {
                alert('Content saved successfully!');
            })
            .catch((error) => {
                console.error('Error:', error);
                alert('Error saving content!');
            });
    });
});
