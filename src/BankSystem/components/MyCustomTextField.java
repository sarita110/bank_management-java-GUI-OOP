package BankSystem.components;
import javax.swing.*;
import java.awt.*;

// Define a custom text field class that extends the JTextField class
public class MyCustomTextField extends JTextField {

    public MyCustomTextField(String text){
        super(text);
        // Set the number of columns to 15, which determines the preferred width of the text field
        setColumns(15);
        // Set the foreground color of the text field to dark gray
        setForeground(Color.darkGray);
        // Set the margin of the text field to 10 pixels on all sides
        setMargin(new java.awt.Insets(10, 10, 10, 10));
    }
}