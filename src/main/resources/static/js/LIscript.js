document.addEventListener('DOMContentLoaded', () => {
    const submitBtn = document.getElementById('submitBtn');
  
    submitBtn.addEventListener('click', async (e) => {
      e.preventDefault(); // no page reload
  
      const email = document.getElementById('Email').value;
      const password = document.getElementById('Password').value;
  
      try {
        const response = await fetch('/api/user/login', {
          method: 'POST',
          headers: { 'Content-Type': 'application/json' },
          body: JSON.stringify({ email, password }),
        });
  
        if (!response.ok) {
          const errorData = await response.json();
          alert(errorData.message || 'Login failed');
          return;
        }
  
        const user = await response.json();
  
        localStorage.setItem('username', user.userName);
        localStorage.setItem('email', user.email);
  
        window.location.assign('/LoginSuccess.html');
      } catch (error) {
        console.error('Login error:', error);
        alert('Something went wrong. Try again.');
      }
    });
  });
  