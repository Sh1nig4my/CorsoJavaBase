// script.js

// Toggle dei form 
const container = document.getElementById('container');
const registerBtn = document.getElementById('register');
const loginBtn = document.getElementById('login');

registerBtn.addEventListener('click', () => {
  container.classList.add("active");
});

loginBtn.addEventListener('click', () => {
  container.classList.remove("active");
});

// Gestione della registrazione
document.getElementById("register-form").addEventListener("submit", async function(event) {
  event.preventDefault();
  const username = event.target.username.value;
  const email = event.target.email.value;
  const password = event.target.password.value;

  try {
    const response = await fetch("/register", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ username, email, password })
    });
    const result = await response.json();
    if (response.ok) {
      alert("Registration successful: " + JSON.stringify(result));
    } else {
      alert("Registration error: " + result.detail);
    }
  } catch (error) {
    alert("Connection error: " + error);
  }
});

// Gestione del login
document.getElementById("login-form").addEventListener("submit", async function(event) {
  event.preventDefault();
  const email = event.target.email.value;
  const password = event.target.password.value;

  try {
    const response = await fetch("/login", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ email, password })
    });
    const result = await response.json();
    if (response.ok) {
      alert("Login successful: " + JSON.stringify(result));
    } else {
      alert("Login error: " + result.detail);
    }
  } catch (error) {
    alert("Connection error: " + error);
  }
});
