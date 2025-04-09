package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class RemoveEmployee extends JFrame implements ActionListener {
    Choice choiceEMPID; // Dropdown to select employee ID
    JButton delete, back; // Buttons for delete and back actions

    RemoveEmployee() {
        // Label for Employee ID
        JLabel label = new JLabel("Employee ID");
        label.setBounds(50, 50, 100, 30);
        label.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(label);

        // Dropdown to display employee IDs
        choiceEMPID = new Choice();
        choiceEMPID.setBounds(200, 50, 150, 30);
        add(choiceEMPID);

        // Fetch employee IDs from the database and populate the dropdown
        try {
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("select * from employee");
            while (resultSet.next()) {
                choiceEMPID.add(resultSet.getString("empId"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Labels and placeholders for employee details
        JLabel labelName = new JLabel("Name");
        labelName.setBounds(50, 100, 100, 30);
        labelName.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(labelName);

        JLabel textName = new JLabel(); // Placeholder for employee name
        textName.setBounds(200, 100, 100, 30);
        add(textName);

        JLabel labelPhone = new JLabel("Phone");
        labelPhone.setBounds(50, 150, 100, 30);
        labelPhone.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(labelPhone);

        JLabel textPhone = new JLabel(); // Placeholder for employee phone
        textPhone.setBounds(200, 150, 100, 30);
        add(textPhone);

        JLabel labelemail = new JLabel("Email");
        labelemail.setBounds(50, 200, 100, 30);
        labelemail.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(labelemail);

        JLabel textEmail = new JLabel(); // Placeholder for employee email
        textEmail.setBounds(200, 200, 100, 30);
        add(textEmail);

        // Fetch and display details of the selected employee
        try {
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("select * from employee where empId = '" + choiceEMPID.getSelectedItem() + "'");
            while (resultSet.next()) {
                textName.setText(resultSet.getString("name"));
                textPhone.setText(resultSet.getString("phone"));
                textEmail.setText(resultSet.getString("email"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Update employee details when a new ID is selected
        choiceEMPID.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try {
                    conn c = new conn();
                    ResultSet resultSet = c.statement.executeQuery("select * from employee where empId = '" + choiceEMPID.getSelectedItem() + "'");
                    while (resultSet.next()) {
                        textName.setText(resultSet.getString("name"));
                        textPhone.setText(resultSet.getString("phone"));
                        textEmail.setText(resultSet.getString("email"));
                    }
                } catch (Exception E) {
                    E.printStackTrace();
                }
            }
        });

        // Delete button to remove the selected employee
        delete = new JButton("Delete");
        delete.setBounds(80, 300, 100, 30);
        delete.setBackground(Color.black);
        delete.setForeground(Color.WHITE);
        delete.addActionListener(this);
        add(delete);

        // Back button to return to the previous screen
        back = new JButton("Back");
        back.setBounds(220, 300, 100, 30);
        back.setBackground(Color.black);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        // Add an image icon for delete
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/delete.png"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(700, 80, 200, 200);
        add(img);

        // Add a background image
        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("icons/rback.png"));
        Image i22 = i11.getImage().getScaledInstance(1120, 630, Image.SCALE_DEFAULT);
        ImageIcon i33 = new ImageIcon(i22);
        JLabel image = new JLabel(i33);
        image.setBounds(0, 0, 1120, 630);
        add(image);

        // Set frame properties
        setSize(1000, 400);
        setLocation(300, 150);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == delete) {
            // Delete the selected employee from the database
            try {
                conn c = new conn();
                String query = "delete from employee where empId = '" + choiceEMPID.getSelectedItem() + "'";
                c.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Employee Deleted Successfully");
                setVisible(false);
                new Main_class(); // Navigate to the main class
            } catch (Exception E) {
                E.printStackTrace();
            }
        } else {
            // Close the current window
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new RemoveEmployee(); // Launch the RemoveEmployee frame
    }
}