// You can use this JS later to trigger animation when scrolling
// or interact with sections dynamically
document.addEventListener("DOMContentLoaded", function () {
  const elements = document.querySelectorAll(".animate");
  elements.forEach((el) => {
    el.style.opacity = "1";
    el.style.transform = "translateY(0)";
  });
});