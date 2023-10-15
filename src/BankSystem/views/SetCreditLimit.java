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

//SetCreditLimit class inherits attributes and methods of JFrame class
public class SetCreditLimit extends JFrame {
    //Declaring all the labels, text fields, button to be used by creating instance of classes of components
    MyCustomButton setBtn, clearBtn;
    MyCustomLabel  setCreditLimitLabel, cardIdLabel, newCreditLimitLabel, newGracePeriodLabel;
    MyCustomTextField cardIdTf, newCreditLimitTf, newGracePeriodTf;

    //The constructor asks BankCard arraylist as its parameter
    public SetCreditLimit(ArrayList<BankCard> bankCards){
        super("Set Credit Limit");
        setVisible(true);
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setLocationRelativeTo(null);

        Font calistoLabel = new Font("Calisto MT", Font.PLAIN, 33);

        JPanel panel = new JPanel();
        panel.setBackground(Color.lightGray);

        //All the UI components are now initialized
        setCreditLimitLabel = new MyCustomLabel("Set Credit Limit");
        setCreditLimitLabel.setHorizontalAlignment(MyCustomLabel.CENTER);
        setCreditLimitLabel.setFont(calistoLabel);

        cardIdLabel= new MyCustomLabel("Card Id");
        newCreditLimitLabel = new MyCustomLabel("New Credit Limit");
        newGracePeriodLabel = new MyCustomLabel("New Grace Period");

        cardIdTf = new MyCustomTextField("");
        newCreditLimitTf = new MyCustomTextField("");
        newGracePeriodTf = new MyCustomTextField("");

        setBtn = new MyCustomButton("Set");
        clearBtn = new MyCustomButton("Clear");

        setBtn.addActionListener(e -> {
            String cardId = cardIdTf.getText();
            String newCreditLimit = newCreditLimitTf.getText();
            String newGracePeriod = newGracePeriodTf.getText();

            try{
                // Check if all fields are filled
                if (cardId.equals("") || newCreditLimitTf.equals("") || newGracePeriodTf.equals("")) {
                    JOptionPane.showMessageDialog(null, "!!! Please fill all the fields !!!");
                } else {
                    // Parse input values
                    int card = Integer.parseInt(cardId);
                    double creditLimit = Double.parseDouble(newCreditLimit);
                    int gracePeriod = Integer.parseInt(newGracePeriod);
                    boolean foundCard = false;
                    CreditCard creditCard = null;
                    // Search for the credit card with the given card id
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
                        // Set the credit limit and grace period for the credit card
                        creditCard.setCreditLimit(creditLimit, gracePeriod);
                        JOptionPane.showMessageDialog(null, "You have successfully set the credit limit");
                        clear();
                    } else {
                        JOptionPane.showMessageDialog(null, "!!! Card not found !!!");
                    }
                }
            }catch (Exception exception){
                JOptionPane.showMessageDialog(null, "!!! Please enter valid input: Integer value only for Card Id and Grace Period, Decimal Value for Credit Limit !!!");
            }
        });

        clearBtn.addActionListener(e -> {
            clear();
        });

        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.setLayout(gbl);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(setCreditLimitLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        panel.add(cardIdLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(cardIdTf, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(newCreditLimitLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(newCreditLimitTf, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(newGracePeriodLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        panel.add(newGracePeriodTf, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(setBtn, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        panel.add(clearBtn, gbc);

        add(panel);
    }

    public void clear(){
        cardIdTf.setText("");
        newCreditLimitTf.setText("");
        newGracePeriodTf.setText("");
    }
}

