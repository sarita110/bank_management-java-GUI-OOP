package BankSystem.views;

//different classes are imported from their packages so they can used in this class
import BankSystem.BankCard;
import BankSystem.DebitCard;
import BankSystem.components.MyCustomButton;
import BankSystem.components.MyCustomLabel;
import BankSystem.components.MyCustomTextField;

//different packages containing inbuilt classes of java is imported
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

//AddDebitCard class inherits attributes and methods of JFrame class
public class AddDebitCard extends JFrame {
    //Declaring all the labels, text fields, button and combo box to be used by creating instance of classes of components
    MyCustomLabel addDebitCardLabel, balanceAmountLabel, cardIdLabel, bankAccountLabel, issuerBankLabel, clientNameLabel, pinNumberLabel;
    MyCustomTextField balanceAmountTf, cardIdTf, bankAccountTf, issuerBankTf, clientNameTf, pinNumberTf;
    MyCustomButton addBtn, clearBtn, displayBtn;

    //The constructor asks BankCard arraylist as its parameter
    public AddDebitCard(ArrayList<BankCard> bankCards){
        //Changing specific properties of the window
        super("Add Debit Card");
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(600, 800);
        setLocationRelativeTo(null);
        setResizable(false);

        Font calistoLabel = new Font("Calisto MT", Font.PLAIN, 33);


        JPanel addDebitCardPanel = new JPanel();
        addDebitCardPanel.setBackground(Color.lightGray);

        //All the UI components are now initialized
        addDebitCardLabel = new MyCustomLabel("Add Debit Card");
        addDebitCardLabel.setHorizontalAlignment(MyCustomLabel.CENTER);
        addDebitCardLabel.setFont(calistoLabel);

        balanceAmountLabel = new MyCustomLabel("Balance Amount");
        cardIdLabel = new MyCustomLabel("Card Id");
        bankAccountLabel = new MyCustomLabel("Bank Account");
        issuerBankLabel = new MyCustomLabel("Issuer Bank");
        clientNameLabel = new MyCustomLabel("Client Name");
        pinNumberLabel = new MyCustomLabel("Pin Number");

        balanceAmountTf = new MyCustomTextField("");
        cardIdTf = new MyCustomTextField("");
        bankAccountTf = new MyCustomTextField("");
        issuerBankTf = new MyCustomTextField("");
        clientNameTf = new MyCustomTextField("");
        pinNumberTf = new MyCustomTextField("");

        addBtn = new MyCustomButton("Add");
        clearBtn = new MyCustomButton("Clear");
        displayBtn = new MyCustomButton("Display");

        //action listener is added for add button
        addBtn.addActionListener(e -> {

            String balanceAmount = balanceAmountTf.getText();
            String cardId = cardIdTf.getText();
            String bankAccount = bankAccountTf.getText();
            String issueBank = issuerBankTf.getText();
            String clientName = clientNameTf.getText();
            String pinNumber = pinNumberTf.getText();

            try{
                // Check if any required field is empty
                if (balanceAmount.equals("") || cardId.equals("") || bankAccount.equals("") || issueBank.equals("") || clientName.equals("") || pinNumber.equals("")) {
                    JOptionPane.showMessageDialog(null, "!!! Please fill all the fields !!!");
                } else {
                    // Parse values from input fields
                    double balance = Double.parseDouble(balanceAmount);
                    int card = Integer.parseInt(cardId);
                    int pin = Integer.parseInt(pinNumber);
                    boolean cardExists = false;
                    DebitCard debitCard = null;
                    // Check if a debit card with the given card id already exists
                    for (BankCard bankCard : bankCards) {
                        if (bankCard instanceof DebitCard) {
                            debitCard = (DebitCard) bankCard;
                            if (debitCard.getCardId() == card) {
                                cardExists = true;
                                break;
                            }
                        }
                    }

                    if (cardExists==false) {
                        // Create a new debit card object and add it to the bank cards list
                        debitCard = new DebitCard(balance, card, bankAccount, issueBank, clientName, pin);
                        bankCards.add(debitCard);
                        JOptionPane.showMessageDialog(null, "Debit Card added successfully.");
                        clear();
                    } else {
                        JOptionPane.showMessageDialog(null, "!!! Debit Card with this Card Id already exists !!!");
                    }
                }
            }catch(Exception exception){
                // Show an error message if invalid input is entered
                JOptionPane.showMessageDialog(null, "!!! Please enter valid input: Integer value only for Card Id and Pin Number, Decimal value for Balance Amount. !!!");
            }
        });

        clearBtn.addActionListener(e -> {
            clear();
        });

        //action listener is added to displayBtn to open DisplayDebitCards dialog box
        displayBtn.addActionListener(e -> {
            new DisplayDebitCards(bankCards);
        });

        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();

        addDebitCardPanel.setLayout(gbl);

        //With the help of gridbagconstraints, positioning of each component is done and arranged with gridbag layout
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        addDebitCardPanel.add(addDebitCardLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        addDebitCardPanel.add(cardIdLabel, gbc);

        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        addDebitCardPanel.add(cardIdTf, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        addDebitCardPanel.add(clientNameLabel, gbc);

        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        addDebitCardPanel.add(clientNameTf, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        addDebitCardPanel.add(issuerBankLabel, gbc);

        gbc.gridx = 2;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        addDebitCardPanel.add(issuerBankTf, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        addDebitCardPanel.add(bankAccountLabel, gbc);

        gbc.gridx = 2;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        addDebitCardPanel.add(bankAccountTf, gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        addDebitCardPanel.add(balanceAmountLabel, gbc);

        gbc.gridx = 2;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        addDebitCardPanel.add(balanceAmountTf, gbc);

        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.gridwidth = 1;
        addDebitCardPanel.add(pinNumberLabel, gbc);

        gbc.gridx = 2;
        gbc.gridy = 6;
        gbc.gridwidth = 1;
        addDebitCardPanel.add(pinNumberTf, gbc);

        gbc.gridx = 1;
        gbc.gridy = 7;
        gbc.gridwidth = 1;
        addDebitCardPanel.add(clearBtn, gbc);


        gbc.gridx = 2;
        gbc.gridy = 7;
        gbc.gridwidth = 1;
        addDebitCardPanel.add(addBtn, gbc);

        gbc.gridx = 1;
        gbc.gridy = 8;
        gbc.gridwidth = 2;
        addDebitCardPanel.add(displayBtn, gbc);

        add(addDebitCardPanel);
    }

    public void clear() {
        balanceAmountTf.setText("");
        cardIdTf.setText("");
        bankAccountTf.setText("");
        issuerBankTf.setText("");
        clientNameTf.setText("");
        pinNumberTf.setText("");
    }
}

