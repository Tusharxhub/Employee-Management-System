package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main_class extends JFrame {

    // Constructor for the Main_class
    Main_class() {

        // Load and set the background image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1120, 630, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(0, 0, 1120, 630);
        add(img);

        // Add heading label
        JLabel heading = new JLabel("Employee Management System");
        heading.setBounds(340, 155, 400, 40);
        heading.setFont(new Font("Raleway", Font.BOLD, 25));
        img.add(heading);

        // Add Employee button
        JButton add = new JButton("Add Employee");
        add.setBounds(335, 270, 150, 40);
        add.setForeground(Color.WHITE);
        add.setBackground(Color.BLACK);
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open AddEmployee screen
                new AddEmployee();
                // Hide the current frame
                setVisible(false);
            }
        });
        img.add(add);

        // View Employee button
        JButton view = new JButton("View Employee");
        view.setBounds(565, 270, 150, 40);
        view.setForeground(Color.WHITE);
        view.setBackground(Color.BLACK);
        view.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open View_Employee screen
                new View_Employee();
                // Hide the current frame
                setVisible(false);
            }
        });
        img.add(view);

        // Remove Employee button
        JButton rem = new JButton("Remove Employee");
        rem.setBounds(440, 370, 150, 40);
        rem.setForeground(Color.WHITE);
        rem.setBackground(Color.BLACK);
        rem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open RemoveEmployee screen
                new RemoveEmployee();
                // Hide the current frame
                setVisible(false);
            }
        });
        img.add(rem);

        // Set frame properties
        setSize(1120, 630); // Set frame size
        setLocation(250, 100); // Set frame location on the screen
        setLayout(null); // Use null layout for custom positioning
        setVisible(true); // Make the frame visible
    }

    // Main method to launch the application
    public static void main(String[] args) {
        new Main_class(); // Create and display the main frame
    }
}