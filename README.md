
# 👨‍💼 Employee Management System

A clean and interactive **Java Swing-based GUI application** for managing employee data. Built with 💚 for ease of use, professional aesthetics, and dynamic control.

---

## 🧠 Features

- 🎨 User-friendly GUI built with **Java Swing**
- 📅 Date picker for DOB using **JDateChooser**
- 📄 Add, Edit, and Manage employee details like:
  - Name
  - Father's Name
  - DOB
  - Salary
  - Designation
  - Address
  - Contact Info
  - Education
  - Aadhar Number
  - Employee ID (Auto-generated)
- 🧩 Connected with **MySQL Database** for real-time data storage
- 🔐 Modular and well-structured codebase

---

## 🛠️ Technologies Used

- 🧬 Java
- 🖥️ Java Swing
- 🗃️ MySQL
- 🌿 NetBeans / IntelliJ / VS Code (Your choice of IDE)
- 📦 JDBC Connector

---

## 🖼️ UI Preview

| Add Employee Page |
|-------------------|
| ![Add Employee](https://github.com/Tusharxhub/Employee-Management-System/blob/main/Add%20Employee%20Page.png?raw=true) |

---

## 🚀 Getting Started

1. Clone the repository  
   ```bash
   git clone https://github.com/Tusharxhub/Employee-Management-System.git
   ```

2. Import into your favorite IDE

3. Connect your **MySQL Database**  
   - Create a table named `employee`
   - Structure:
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

4. Add your DB credentials in the `conn.java` file

5. Run `AddEmployee.java` or `Main_class.java`

---

## ⚙️ How It Works

- 🎯 Generates a random Employee ID
- 📝 Captures input from GUI
- 📡 Sends data to MySQL DB via `JDBC`
- 🖼️ Displays confirmation and clears the form

---

## 👨‍💻 Author

**Tushar Dey**  
📧 [*Email*](mailto:t.k.d.dey2033929837@gmail.com)  
🔗 [*GitHub*](https://github.com/Tusharxhub)  
📸 [*Instagram*](https://www.instagram.com/tushardevx01/)

---

## 🌟 Star this repo if it helped you!

---

Would you like me to:
- Add the `.gif` or image preview directly?
- Help write the `conn.java` DB class?
- Assist with packaging it into a `.jar` or `.exe`?

Let me know and I got you, bro 💻🔥


