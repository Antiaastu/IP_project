const loginText = document.querySelector(".title-text .login");
const loginForm = document.querySelector("form.login");
const loginBtn = document.querySelector("label.login");
const signupBtn = document.querySelector("label.signup");
const signupLink = document.querySelector("form .signup-link a");
signupBtn.onclick = (()=>{
  loginForm.style.marginLeft = "-50%";
  loginText.style.marginLeft = "-50%";
});
loginBtn.onclick = (()=>{
  loginForm.style.marginLeft = "0%";
  loginText.style.marginLeft = "0%";
});
signupLink.onclick = (()=>{
  signupBtn.click();
  return false;
});

(function () {
    const registeredUsers = [];
  
    // Function to check if the email is registered
    const isEmailRegistered = (email) => {
      return registeredUsers.some(user => user.email === email);
    };
  
    // Function to handle login form submission
    const handleLogin = (event) => {
      event.preventDefault();
      const emailInput = document.querySelector("form.login input[type='text']");
      const passwordInput = document.querySelector("form.login input[type='password']");
  
      const userEmail = emailInput.value.trim();
      const userPassword = passwordInput.value.trim();
  
      if (isEmailRegistered(userEmail)) {
        // Perform login logic (e.g., check password, redirect, etc.)
        console.log(`Logged in successfully with email: ${userEmail}`);
      } else {
        alert("You should be registered first. Please go to the signup page.");
      }
    };
  
    // Function to handle signup form submission
    const handleSignup = (event) => {
      event.preventDefault();
      const nameInput = document.querySelector("form.signup input[placeholder='Name']");
      const emailInput = document.querySelector("form.signup input[placeholder='Email Address']");
      const passwordInput = document.querySelector("form.signup input[placeholder='Password']");
      const confirmPasswordInput = document.querySelector("form.signup input[placeholder='Confirm password']");
  
      const userName = nameInput.value.trim();
      const userEmail = emailInput.value.trim();
      const userPassword = passwordInput.value.trim();
      const confirmPassword = confirmPasswordInput.value.trim();
  
      if (isEmailRegistered(userEmail)) {
        alert("Email is already registered. Please use another email or login.");
      } else {
        // Store user information
        registeredUsers.push({ name: userName, email: userEmail, password: userPassword });
        alert("Signup successful. You can now login with your credentials.");
      }
    };
  
    // Attach event listeners to login and signup forms
    const loginForm = document.querySelector("form.login");
    const signupForm = document.querySelector("form.signup");
  
    if (loginForm) {
      loginForm.addEventListener("submit", handleLogin);
    }
  
    if (signupForm) {
      signupForm.addEventListener("submit", handleSignup);
    }
  })();
  