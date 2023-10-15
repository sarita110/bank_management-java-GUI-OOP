package BankSystem.views;
//different classes are imported from their packages so they can used in this class
import BankSystem.BankCard;
import BankSystem.CreditCard;
import BankSystem.components.MyCustomButton;
import BankSystem.components.MyCustomLabel;
import BankSystem.components.MyCustomTextField;

//different packages containing inbuilt classes of java is imported
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

//CancelCreditCard class inherits attributes and methods of JFrame class
public class CancelCreditCard extends JFrame {
    //Declaring all the labels, text fields, button to be used by creating instance of classes of components
    MyCustomLabel cancelCreditCardLabel, cardIdLabel;
    MyCustomTextField cardIdTf;
    MyCustomButton submitBtn, clearBtn;

    //The constructor asks BankCard arraylist as its parameter
    public CancelCreditCard(ArrayList<BankCard> bankCards){
        super("Cancel Credit Card");
        setVisible(true);
        setSize(450, 450);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        Font calistoLabel = new Font("Calisto MT", Font.PLAIN, 30);

        JPanel panel = new JPanel();
        panel.setBackground(Color.lightGray);

        //All the UI components are now initialized
        cancelCreditCardLabel = new MyCustomLabel("Cancel Credit Card");
        cancelCreditCardLabel.setHorizontalAlignment(MyCustomLabel.CENTER);
        cancelCreditCardLabel.setFont(calistoLabel);

        cardIdLabel = new MyCustomLabel("Card Id");

        cardIdTf = new MyCustomTextField("");

        submitBtn = new MyCustomButton("Submit");
        clearBtn = new MyCustomButton("Clear");

        //add listener for submitBtn to cancel credit card details of specific cardId
        submitBtn.addActionListener(e -> {
            String cardId = cardIdTf.getText();
            try{
                if (cardId.equals("")) {
                    JOptionPane.showMessageDialog(null, "!!! Please fill the field of Card Id !!!");
                } else {
                    int card = Integer.parseInt(cardId);
                    boolean foundCard = false;
                    CreditCard creditCard = null;
                    for (BankCard bankCard : bankCards) {
                        if (bankCard instanceof CreditCard) {
                            creditCard = (CreditCard) bankCard;
                            if (creditCard.getCardId() == card) {
                                foundCard = true;
                                break;
                            }
                        }
                    }

                    if (foundCard) {
                        // If the card ID is valid and exists, it cancels the CreditCard and displays a success message.
                        creditCard.cancelCreditCard();
                        JOptionPane.showMessageDialog(null, "Your Credit Card is Successfully Canceled");
                        clear();
                    } else {
                        // If the card ID entered is invalid or does not exist, it displays a message saying the card was not found.
                        JOptionPane.showMessageDialog(null, "!!! Card not found !!!");
                    }
                }
            }catch (Exception exception){
                JOptionPane.showMessageDialog(null, "!!! Please enter valid input: Integer value only for Card Id !!!");
            }
        });

        clearBtn.addActionListener(e -> {
            clear();
        });

        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        panel.setLayout(gbl);

        // Adding the components to the panel with GridBagConstraints
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(cancelCreditCardLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        panel.add(cardIdLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        panel.add(cardIdTf, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        panel.add(submitBtn, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        panel.add(clearBtn, gbc);

        add(panel);
    }

    public void clear(){
        cardIdTf.setText("");
    }

}

