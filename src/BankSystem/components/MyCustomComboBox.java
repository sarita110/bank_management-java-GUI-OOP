package BankSystem.components;

import javax.swing.*;

public class MyCustomComboBox extends JComboBox {

    // Constructor that takes an array of strings as a parameter
    public MyCustomComboBox(String[] items){
        super(items);
        setFont(new java.awt.Font("Arial", 0, 20));
        setForeground(new java.awt.Color(0, 0, 0));
        setBackground(new java.awt.Color(255, 255, 255));
        // Set the maximum number of visible rows in the drop-down list to 5
        setMaximumRowCount(5);
    }
}
