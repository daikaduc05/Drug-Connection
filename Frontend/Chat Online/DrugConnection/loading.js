// sự kiện load trang
window.addEventListener("load", () => {
    const preloader = document.querySelector(".preloader");
    setTimeout(() => {
      preloader.classList.add("unactive");
    }, 900);
  });