function authorAction(authorId, action) {
    fetch(`${contextPath}/owner/session-author-info`, {
    method: "POST",
    headers: {
      "Content-Type": "application/json"
    },
    body: JSON.stringify({
      authorId: authorId,
      authorAction: action
    })
  })
      .then(response => response.json())
      .then(data => {
        if (data.status === "success") {
          if (action === "view") {
            window.location.href = `${contextPath}/owner/author-profile`;
          } else if (action === "update") {
            window.location.href = `${contextPath}/owner/author-update`;
          } else if (action === "delete") {
            window.location.href = `${contextPath}/owner/author-list`;
          }
        } else {
          alert("Có lỗi xảy ra khi chuyển hướng.");
        }
      })
      .catch(error => console.error("Error:", error));
}

document.addEventListener("DOMContentLoaded", function () {
  const tableBody = document.querySelector(".author-data-table tbody");

  if (tableBody) {
    tableBody.addEventListener("click", function (event) {
      const row = event.target.closest(".author-row");

      if (row && !event.target.closest("button") && !event.target.closest(".dropdown-menu")) {
        const authorId = row.getAttribute("data-id");
        authorAction(authorId, "view");
      }
    });
  }
});
