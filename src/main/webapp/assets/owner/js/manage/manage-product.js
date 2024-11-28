// Function to handle table row click events
function initializeTableRowClickHandler() {
    const tableBody = document.querySelector(".item-data-table tbody");

    if (tableBody) {
        tableBody.addEventListener("click", function (event) {
            const row = event.target.closest(".item-row");

            if (row && !event.target.closest("button") && !event.target.closest(".dropdown-menu")) {
                const authorId = row.getAttribute("data-id");
                //  rowAction(authorId, "view"); // Trigger "view" action
                window.location.href = `${contextPath}/owner/product-details?id=${authorId}`;
            }
        });
    }
}

// Function to initialize Lottie animations
function initializeLottieAnimations() {
    const animations = [
        { containerId: 'lottie-danger', jsonPath: '/assets/owner/json/danger.json' },
        { containerId: 'lottie-success', jsonPath: '/assets/owner/json/success.json' },
        { containerId: 'lottie-fail', jsonPath: '/assets/owner/json/fail.json' },
    ];

    animations.forEach(animation => {
        lottie.loadAnimation({
            container: document.getElementById(animation.containerId), // Animation container
            renderer: 'svg', // Render type: SVG
            loop: true, // Loop the animation
            autoplay: true, // Start automatically
            path: `${contextPath}${animation.jsonPath}` // Path to the animation JSON file
        });
    });
}

// Wait for the DOM content to be fully loaded
document.addEventListener("DOMContentLoaded", function () {
    initializeTableRowClickHandler();
    initializeLottieAnimations();
});