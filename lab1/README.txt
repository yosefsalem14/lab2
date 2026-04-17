# User Validation System (Java)

This project was developed as part of a Software Engineering course.

## 📌 Description

The application allows a user to log in using an email and password.
It loads valid accounts from a file and checks the user input against stored data.

If the login is correct → a success screen is displayed.
If incorrect → an error message is shown.

## ✅ Features

JavaFX graphical user interface (FXML-based)
Login screen with email and password fields
File-based user loading (Accounts.txt)
Validation using a custom User class
Stores users in an ArrayList
Event-driven programming (button click handling)
Scene switching (Login → Success screen)
Logout support (optional if implemented)
Input validation and error messages

## ▶️ How to Run

in intelij terminal
mvn clean javafx:run

🧠 How It Works
Program starts with login.fxml
Controller.initialize() loads users from Accounts.txt
User enters email + password
Clicking "Login" triggers handleLogin()
System checks credentials:
If valid → load Success.fxml
If invalid → show error label

## 📂 Input Format

Each line in `users.txt`:

```
username password
```

## 📤 Output

✅ Correct login → Success screen displayed
❌ Wrong login → “User not found” message

## 🛠 Technologies

* JavaFX
* FXML
* Maven
* Java
* OOP principles
* File I/O
* Collections (ArrayList, Comparator)

## 👩‍💻 Authors
Fadi kais   
Yosef Salem
