User Validator

Simple Java Spring Boot app with frontend for user registration and login.
Passwords hashed with BCrypt.

Features:
- User registration & login
- Password hashing with BCrypt
- Login success page showing username and email
- Frontend: HTML, CSS, JS
- Backend: Java, Spring Boot, Spring Security
- Database: MySQL

Tech stack:
- Java 21+
- Spring Boot, Security
- Maven
- MySQL
- HTML/CSS/JS

How to run:
1. Clone repo:
   git clone https://github.com/yourusername/user-validator.git
2. Configure MySQL connection in src/main/resources/application.properties
3. Run app:
   mvn spring-boot:run
4. Open browser at:
   http://localhost:8080/LI.html
5. Register, then login

Project structure:  

- src  
  - main  
    - java  
      - com  
        - ffryczek  
          - user_validator  
            - Controller  
            - DTO  
            - Entity  
            - Repository  
            - Service  
            - config  
    - resources  
      - static  
        - css  
        - js  
        - LI.html  
        - SI.html  
        - LoginSuccess.html 

Video demo:
https://youtu.be/0BE-HTmPjmw

Author:
Filip Fryczek
