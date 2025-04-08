package employee.management.system;

import javax.swing.*;
import java.awt.*; // Don't forget this for Color and Font

public class AddEmployee extends JFrame {

    AddEmployee() {
        getContentPane().setBackground(new Color(163, 255, 188));
        setLayout(null); // Important for absolute positioning

        JLabel heading = new JLabel("Add Employee Detail");
        heading.setBounds(320, 30, 300, 50);
        heading.setFont(new Font("Serif", Font.BOLD, 25));
        add(heading);

        setSize(900, 700);
        setLocation(300, 50);
        setVisible(true);
    }

    public static void main(String[] args) {
        new AddEmployee(); // Everything is handled inside constructor now
    }
}
