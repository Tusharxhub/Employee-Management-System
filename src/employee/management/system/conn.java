package employee.management.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * The `conn` class is responsible for establishing a connection to the MySQL database
 * and creating a statement object for executing SQL queries.
 * 
 * <p>This class uses the MySQL JDBC driver to connect to the database. Ensure that the
 * MySQL JDBC driver is included in the project's classpath.</p>
 * 
 * <p>Database connection details:
 * <ul>
 *   <li>URL: jdbc:mysql://localhost:3306/employeemanagement</li>
 *   <li>Username: root</li>
 *   <li>Password: Hi,Tushar29@35</li>
 * </ul>
 * </p>
 * 
 * <p>Usage:
 * <pre>
 * conn databaseConnection = new conn();
 * Statement statement = databaseConnection.statement;
 * </pre>
 * </p>
 * 
 * <p>Note: Handle sensitive information like database credentials securely in a real-world application.</p>
 */
public class conn {

    Connection connection;
    Statement statement;

    // Fix: Constructor name matches the class name
    public conn() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemanagement", "root", "Hi,Tushar29@35");
            statement = connection.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}