document.addEventListener('DOMContentLoaded', () => {
    const submitBtn = document.getElementById('submitBtn');

    submitBtn.addEventListener('click', async (e) => {
        e.preventDefault(); // zapobiega przeładowaniu strony

        const username = document.getElementById('SETusername').value;
        const email = document.getElementById('SETemail').value;
        const password = document.getElementById('SETpassword').value;
        const password2 = document.getElementById('SETpassword2').value;

        if (password !== password2) {
            alert("Passwords do not match!");
            return;
        }

        try {
            const response = await fetch('/api/user', {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify({
                    userName: username,
                    email: email,
                    passwordHash: password  // backend i tak zahashuje
                })
            });

            if (response.ok) {
                // sukces – przekierowujemy do logowania
                window.location.href = "LI.html";
            } else {
                const err = await response.text();
                alert("Registration failed: " + err);
            }
        } catch (error) {
            console.error("Error:", error);
            alert("Something went wrong");
        }
    });
});
