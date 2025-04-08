package employee.management.system;

import javax.swing.*;
import java.awt.*; // Don't forget this for Color and Font

public class AddEmployee extends JFrame {
    JTextField tname, tfname, taddress, tphone, taadhar, temail , tsalary , tdesignation;

    AddEmployee() {
        getContentPane().setBackground(new Color(163, 255, 188));
        setLayout(null); // Important for absolute positioning

        JLabel heading = new JLabel("Add Employee Detail");
        heading.setBounds(320, 30, 300, 50);
        heading.setFont(new Font("Serif", Font.BOLD, 25));
        add(heading);

        JLabel name = new JLabel("Name");
        name.setBounds(50, 150, 150, 30);
        name.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(name);

        tname = new JTextField();
        tname.setBounds(200, 150, 150, 30);
        tname.setBackground(new Color(177, 252, 197));
        add(tname);

        setSize(900, 700);
        setLocation(300, 50);
        setVisible(true);
    }

    public static void main(String[] args) {
        new AddEmployee(); // Everything is handled inside constructor now
    }
}
