const show = () => {
  const signUp = document.querySelector("#sign_up");
  signUp.style.display = "block";
  document.querySelector(".layer").style.display = "block";
};
// thêm onclick="show()" vô button create account
const hide = () => {
  const signUp = document.querySelector("#sign_up");
  signUp.style.display = "none";
  document.querySelector(".layer").style.display = "none";
};

// show password
function showPassword() {
  var passwordInput = document.getElementById("password");
  if (passwordInput.type === "password") {
      passwordInput.type = "text";
  } else {
      passwordInput.type = "password";
  }
}
