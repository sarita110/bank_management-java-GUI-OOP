package BankSystem.components;
import javax.swing.*;
import java.awt.*;

// Define a custom button class that extends the JButton class
public class MyCustomButton extends JButton {

    // Constructor that takes a string as a parameter
    public MyCustomButton(String text) {
        super(text);
        // Disable the focus border around the button when it is selected
        setFocusPainted(false);
        // Set the font of the button to Calisto MT with a plain style and size 25
        setFont(new java.awt.Font("Calisto MT", Font.PLAIN, 25));
        // Set the foreground color of the button to white
        setForeground(new java.awt.Color(255, 255, 255));
        // Set the background color of the button to a dark greenish-gray color
        setBackground(new java.awt.Color(47,79,79));
        // Set the margin of the button to 10 pixels on all sides
        setMargin(new java.awt.Insets(10, 10, 10, 10));
    }
}

