package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class View_Employee extends JFrame implements ActionListener {

    JTable table; // Table to display employee data
    Choice choiceEMP; // Dropdown to select employee ID
    JButton searchBtn, printBtn, updateBtn, backBtn; // Buttons for various actions

    View_Employee() {
        // Set background color and layout
        getContentPane().setBackground(new Color(225, 131, 122));
        setLayout(null);

        // Label for search functionality
        JLabel searchLabel = new JLabel("Search by Employee ID:");
        searchLabel.setBounds(20, 20, 200, 25);
        add(searchLabel);

        // Dropdown to select employee ID
        choiceEMP = new Choice();
        choiceEMP.setBounds(180, 20, 150, 20);
        add(choiceEMP);

        // Populate dropdown with employee IDs from the database
        try {
            conn c = new conn();
            ResultSet rs = c.statement.executeQuery("SELECT empid FROM employee");
            while (rs.next()) {
                choiceEMP.add(rs.getString("empid"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Table to display employee data
        table = new JTable();
        try {
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("SELECT * FROM employee");
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Scroll pane to make the table scrollable
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0, 100, 900, 600);
        add(scrollPane);

        // Button to search for an employee by ID
        searchBtn = new JButton("Search");
        searchBtn.setBounds(20, 70, 80, 20);
        searchBtn.addActionListener(this);
        add(searchBtn);

        // Button to print the table data
        printBtn = new JButton("Print");
        printBtn.setBounds(120, 70, 80, 20);
        printBtn.addActionListener(this);
        add(printBtn);

        // Button to update employee details
        updateBtn = new JButton("Update");
        updateBtn.setBounds(220, 70, 80, 20);
        updateBtn.addActionListener(this);
        add(updateBtn);

        // Button to go back to the previous screen
        backBtn = new JButton("Back");
        backBtn.setBounds(320, 70, 80, 20);
        backBtn.addActionListener(this);
        add(backBtn);

        // Set frame size, location, and visibility
        setSize(900, 700);
        setLocation(300, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == searchBtn) {
            // Query to fetch employee details based on selected ID
            String query = "SELECT * FROM employee WHERE empid = '" + choiceEMP.getSelectedItem() + "'";
            try {
                conn c = new conn();
                ResultSet resultSet = c.statement.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(resultSet));
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        } else if (e.getSource() == printBtn) {
            // Print the table data
            try {
                table.print();
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        } else if (e.getSource() == updateBtn) {
            // Navigate to the UpdateEmployee class (if implemented)
            setVisible(false);
            // Add logic to navigate to UpdateEmployee class if exists
            // new UpdateEmployee(choiceEMP.getSelectedItem());

        } else if (e.getSource() == backBtn) {
            // Navigate back to the main class or home screen
            setVisible(false);
            new Main_class();
            // Add logic to go back to home page or previous screen
            // new Home();
        }
    }

    public static void main(String[] args) {
        new View_Employee(); // Launch the View_Employee frame
    }
}
