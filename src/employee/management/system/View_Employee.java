package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class View_Employee extends JFrame implements ActionListener {

    JTable table;
    Choice choiceEMP;
    JButton searchBtn, printBtn, updateBtn, backBtn;

    View_Employee() {
        getContentPane().setBackground(new Color(225, 131, 122));
        setLayout(null);

        JLabel searchLabel = new JLabel("Search by Employee ID:");
        searchLabel.setBounds(20, 20, 200, 25);
        add(searchLabel);

        choiceEMP = new Choice();
        choiceEMP.setBounds(180, 20, 150, 20);
        add(choiceEMP);

        try {
            conn c = new conn();
            ResultSet rs = c.statement.executeQuery("SELECT empid FROM employee");
            while (rs.next()) {
                choiceEMP.add(rs.getString("empid"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        table = new JTable();
        try {
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("SELECT * FROM employee");
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception e) {
            e.printStackTrace();
        }

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0, 100, 900, 600);
        add(scrollPane);

        searchBtn = new JButton("Search");
        searchBtn.setBounds(20, 70, 80, 20);
        searchBtn.addActionListener(this);
        add(searchBtn);

        printBtn = new JButton("Print");
        printBtn.setBounds(120, 70, 80, 20);
        printBtn.addActionListener(this);
        add(printBtn);

        updateBtn = new JButton("Update");
        updateBtn.setBounds(220, 70, 80, 20);
        updateBtn.addActionListener(this);
        add(updateBtn);

        backBtn = new JButton("Back");
        backBtn.setBounds(320, 70, 80, 20);
        backBtn.addActionListener(this);
        add(backBtn);

        setSize(900, 700);
        setLocation(300, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == searchBtn) {
            String query = "SELECT * FROM employee WHERE empid = '" + choiceEMP.getSelectedItem() + "'";
            try {
                conn c = new conn();
                ResultSet resultSet = c.statement.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(resultSet));
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        } else if (e.getSource() == printBtn) {
            try {
                table.print();
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        } else if (e.getSource() == updateBtn) {
            setVisible(false);
            // Add logic to navigate to UpdateEmployee class if exists
            // new UpdateEmployee(choiceEMP.getSelectedItem());

        } else if (e.getSource() == backBtn) {
            setVisible(false);
            new Main_class();
            // Add logic to go back to home page or previous screen
            // new Home();
        }
    }

    public static void main(String[] args) {
        new View_Employee();
    }
}
