package employee.management.system;

import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame {

    // Constructor for the Splash class
    Splash(){

        // Load the image from the resources folder
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/front.gif"));
        // Scale the image to fit the frame
        Image i2 = i1.getImage().getScaledInstance(1170,650, Image.SCALE_DEFAULT);
        // Convert the scaled image back to an ImageIcon
        ImageIcon i3 = new ImageIcon(i2);
        // Create a JLabel to hold the image
        JLabel image = new JLabel(i3);
        // Set the position and size of the image
        image.setBounds(0,0,1170,650);
        // Add the image to the frame
        add(image);

        // Set the size of the frame
        setSize(1170,650);
        // Set the location of the frame on the screen
        setLocation(200,50);
        // Disable default layout manager
        setLayout(null);
        // Make the frame visible
        setVisible(true);

        try{
            // Pause the splash screen for 5 seconds
            Thread.sleep(5000);
            // Hide the splash screen
            setVisible(false);
            // Open the Login screen
            new Login();
        }catch (Exception e){
            // Print any exceptions that occur
            e.printStackTrace();
        }

    }

    // Main method to run the Splash screen
    public static void main(String[] args) {
        new Splash();
    }
}