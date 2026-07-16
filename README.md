<div align="center">

# 👨‍💼 Employee Management System

A desktop-based **Employee Management System** built with **Java Swing** and **MySQL**. The application provides an intuitive interface for managing employee records, making it suitable for learning desktop application development and database integration using Java.

</div>

---

## ✨ Features

- 👨‍💼 Add new employee records
- ✏️ Update employee information
- 🗂️ Manage employee details efficiently
- 🆔 Automatically generate Employee IDs
- 📅 Integrated date picker using **JDateChooser**
- 💾 Store employee records in **MySQL**
- 🔗 JDBC-based database connectivity
- 🖥️ Clean and responsive Java Swing interface
- 📦 Modular and organized project structure

---

## 🛠️ Tech Stack

| Technology | Purpose |
|------------|---------|
| Java | Core Programming Language |
| Java Swing | Desktop GUI |
| MySQL | Database |
| JDBC | Database Connectivity |
| JDateChooser | Date Picker Component |

---

## 📂 Project Structure

```text
Employee-Management-System/
├── src/
│   ├── employee/
│   ├── database/
│   └── resources/
├── images/
├── lib/
├── README.md
└── employee.sql
```

---

## 🖼️ Application Preview

<div align="center">

![Add Employee Page](https://github.com/tushardevx01/Employee-Management-System/blob/main/Add%20Employee%20Page.png?raw=true)

</div>

---

## 🚀 Getting Started

### Clone the Repository

```bash
git clone https://github.com/tushardevx01/Employee-Management-System.git
```

### Navigate to the Project

```bash
cd Employee-Management-System
```

### Database Setup

Create a database and execute the following SQL:

```sql
CREATE TABLE employee (
    name VARCHAR(100),
    fname VARCHAR(100),
    dob VARCHAR(50),
    salary VARCHAR(20),
    address VARCHAR(255),
    phone VARCHAR(20),
    email VARCHAR(100),
    education VARCHAR(100),
    designation VARCHAR(100),
    aadhar VARCHAR(20),
    empid VARCHAR(20)
);
```

### Configure Database

Update your MySQL credentials inside the database connection file (`conn.java`).

### Run the Application

Compile and run the project from your preferred IDE, or launch:

```text
Main_class.java
```

or

```text
AddEmployee.java
```

---

## ⚙️ How It Works

1. Enter employee information through the Swing interface.
2. The system automatically generates a unique Employee ID.
3. Data is validated and stored in the MySQL database using JDBC.
4. A confirmation message is displayed after successful insertion.

---

## 🤝 Contributing

Contributions are welcome.

1. Fork the repository.
2. Create a feature branch.
3. Commit your changes.
4. Push your branch.
5. Open a Pull Request.

---

## 📬 Connect With Me

- **GitHub:** https://github.com/tushardevx01
- **Portfolio:** https://tushardevx01.tech
- **LinkedIn:** https://www.linkedin.com/in/tushardevx01
- **Instagram:** https://www.instagram.com/tushardevx01
- **Email:** t.k.d.dey2033929837@gmail.com

---

<div align="center">

Made with ❤️ by **Tushar Kanti Dey**

⭐ If you found this project helpful, consider giving it a star.

</div>
