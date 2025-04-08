package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

    // Declare UI components
    JTextField tusername;
    JPasswordField tpassword;
    JButton login, back;

    // Constructor to initialize the Login frame
    Login() {
        // Username Label and Field
        JLabel username = new JLabel("Username");
        username.setBounds(40, 20, 100, 30);
        add(username);

        tusername = new JTextField();
        tusername.setBounds(150, 20, 150, 30);
        add(tusername);

        // Password Label and Field
        JLabel password = new JLabel("Password");
        password.setBounds(40, 70, 150, 30);
        add(password);

        tpassword = new JPasswordField();
        tpassword.setBounds(150, 70, 150, 30);
        add(tpassword);

        // Login Button
        login = new JButton("LOGIN");
        login.setBounds(150, 140, 150, 30);
        login.setBackground(Color.black);
        login.setForeground(Color.WHITE);
        login.addActionListener(this); // Add action listener for login button
        add(login);

        // Back Button
        back = new JButton("BACK");
        back.setBounds(150, 180, 150, 30);
        back.setBackground(Color.black);
        back.setForeground(Color.WHITE);
        back.addActionListener(this); // Add action listener for back button
        add(back);

        // Background Image
        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i22 = i11.getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT);
        ImageIcon i33 = new ImageIcon(i22);
        JLabel imgg = new JLabel(i33);
        imgg.setBounds(350, 10, 600, 400);
        add(imgg);

        // Login Background Image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/LoginB.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(0, 0, 600, 300);
        add(img);

        // Frame settings
        setSize(600, 300); // Set frame size
        setLocation(450, 200); // Set frame location on screen
        setLayout(null); // Use null layout for custom positioning
        setVisible(true); // Make frame visible
    }

    // Handle button click events
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == login) { // If login button is clicked
            try {
                // Get username and password from input fields
                String username = tusername.getText();
                String password = new String(tpassword.getPassword());

                // Create a connection object
                conn c = new conn();

                // Use PreparedStatement to prevent SQL injection
                String query = "SELECT * FROM employees WHERE name = ? AND password = ?";
                PreparedStatement pstmt = c.connection.prepareStatement(query);
                pstmt.setString(1, username);
                pstmt.setString(2, password);

                // Execute the query
                ResultSet resultSet = pstmt.executeQuery();

                // Check if user exists
                if (resultSet.next()) {
                    setVisible(false); // Close login frame
                    new Main_class(); // Open main application (replace with your main class)
                } else {
                    // Show error message if credentials are invalid
                    JOptionPane.showMessageDialog(null, "Invalid username or password");
                }

            } catch (Exception ex) {
                ex.printStackTrace(); // Print exception details
            }
        } else if (e.getSource() == back) { // If back button is clicked
            System.exit(0); // Exit the application
        }
    }

    // Main method to launch the application
    public static void main(String[] args) {
        new Login(); // Create and display the login frame
    }
}
