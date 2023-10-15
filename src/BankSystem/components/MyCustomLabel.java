package BankSystem.components;

import javax.swing.*;
import java.awt.*;

// Define a custom label class that extends the JLabel class
public class MyCustomLabel extends JLabel {

    // Constructor that takes a string as a parameter
    public MyCustomLabel(String text){
        super(text);
        // Set the font of the label to Calisto MT with a plain style and size 25
        setFont(new java.awt.Font("Calisto MT", Font.PLAIN, 25));
    }

}
