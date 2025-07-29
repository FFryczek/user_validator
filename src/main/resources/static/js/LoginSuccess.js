document.addEventListener("DOMContentLoaded", () => {
    const username = localStorage.getItem("username");
    const email = localStorage.getItem("email");
    document.getElementById("displayUsername").textContent = username || "No username";
    document.getElementById("displayEmail").textContent = email || "No email";
  });
  