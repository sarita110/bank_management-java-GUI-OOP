package BankSystem.views;

//different classes are imported from their packages so they can used in this class
import BankSystem.BankCard;
import BankSystem.CreditCard;
import BankSystem.components.MyCustomButton;
import BankSystem.components.MyCustomLabel;
import BankSystem.components.MyCustomTextField;
import BankSystem.components.MyCustomComboBox;

//different packages containing inbuilt classes of java is imported
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
//AddCreditCard class inherits attributes and methods of JFrame class
public class AddCreditCard extends JFrame {
    //Declaring all the labels, text fields, button and combo box to be used by creating instance of classes of components
    MyCustomLabel addCreditCardLabel, cardIdLabel, clientNameLabel, issuerBankLabel, bankAccountLabel, balanceAmountLabel, cvcNumberLabel, interestRateLabel, expirationDateLabel;
    MyCustomTextField cardIdTf, clientNameTf, issuerBankTf, bankAccountTf, balanceAmountTf, cvcNumberTf, interestRateTf;
    MyCustomButton addBtn, clearBtn, displayBtn;
    MyCustomComboBox yearsComboBox, monthsComboBox, daysComboBox;

    //The constructor asks BankCard arraylist as its parameter
    public AddCreditCard(ArrayList<BankCard> bankCards){
        //Changing specific properties of the window
        super("Add Credit Card");
        setVisible(true);
        setSize(750, 750);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        //A custom font named calistoLabel is declared to design the main label of the UI
        Font calistoLabel = new Font("Calisto MT", Font.PLAIN, 33);

        //Panel background color is set to the consistent lightGray
        JPanel addCreditCardPanel = new JPanel();
        addCreditCardPanel.setBackground(Color.lightGray);

        //All the UI components are now initialized
        addCreditCardLabel = new MyCustomLabel("Add Credit Card");

        //Brings the label to the centre
        addCreditCardLabel.setHorizontalAlignment(MyCustomLabel.CENTER);
        addCreditCardLabel.setFont(calistoLabel);

        cardIdLabel = new MyCustomLabel("Card Id");
        clientNameLabel = new MyCustomLabel("Client Name");
        issuerBankLabel = new MyCustomLabel("Issuer Bank");
        bankAccountLabel = new MyCustomLabel("Bank Account");
        balanceAmountLabel = new MyCustomLabel("Balance Amount");
        cvcNumberLabel = new MyCustomLabel("CVC Number");
        interestRateLabel = new MyCustomLabel("Interest Rate");
        expirationDateLabel = new MyCustomLabel("Expiration Date");

        cardIdTf = new MyCustomTextField("");
        clientNameTf = new MyCustomTextField("");
        issuerBankTf = new MyCustomTextField("");
        bankAccountTf = new MyCustomTextField("");
        balanceAmountTf = new MyCustomTextField("");
        cvcNumberTf = new MyCustomTextField("");
        interestRateTf = new MyCustomTextField("");

        addBtn = new MyCustomButton("Add");
        clearBtn = new MyCustomButton("Clear");
        displayBtn = new MyCustomButton("Display");

        yearsComboBox = new MyCustomComboBox(new String[]{"select year", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025"});
        //months
        monthsComboBox = new MyCustomComboBox(new String[]{"select month", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10","11","12"});
        //days
        daysComboBox = new MyCustomComboBox(new String[]{"select day", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10","11","12","13","14","15","16","17","18","19","20", "21","22","23","24","25","26","27","28","29","30","31"});
        //action listener is added for add button
        addBtn.addActionListener(e -> {
            //All the  input from text field are extracted
            String cardId = cardIdTf.getText();
            String clientName = clientNameTf.getText();
            String issuerBank = issuerBankTf.getText();
            String bankAccount = bankAccountTf.getText();
            String balanceAmount = balanceAmountTf.getText();
            String cvcNumber = cvcNumberTf.getText();
            String interestRate = interestRateTf.getText();
            String expirationDate=yearsComboBox.getSelectedItem().toString() + "- " + monthsComboBox.getSelectedItem().toString() + "-" + daysComboBox.getSelectedItem().toString();

            //If any field is empty or all the combo box are not selected alert message is shown.
            //JOptionPane class is used to display alert messages in case of input errors or successful operations.
            try{
                if (cardId.equals("") || clientName.equals("") || issuerBank.equals("") || bankAccount.equals("") || balanceAmount.equals("") || cvcNumber.equals("") || interestRate.equals("")) {
                    JOptionPane.showMessageDialog(null, "!!! Please fill all the fields !!!");
                }else if(yearsComboBox.getSelectedIndex() == 0 || monthsComboBox.getSelectedIndex() == 0 || daysComboBox.getSelectedIndex() == 0) {
                    JOptionPane.showMessageDialog(null, "!!! Select all year, month and day. !!!");
                //If no field is empty and combo boxes are all selected this checks if the card with entered cardId exists or not. If card already exists error alert is displayed
                }else {
                    //Converting the values to required type
                    int card = Integer.parseInt(cardId);
                    double balance = Double.parseDouble(balanceAmount);
                    int cvc = Integer.parseInt(cvcNumber);
                    double interest = Double.parseDouble(interestRate);
                    boolean cardExists = false;
                    CreditCard creditCard = null;
                    //Check if a credit card with the same card id already exists
                    for (BankCard bankCard : bankCards) {
                        if (bankCard instanceof CreditCard) {
                            creditCard = (CreditCard) bankCard;
                            if (creditCard.getCardId() == card) {
                                cardExists = true;
                                break;
                            }
                        }
                    }

                    if (cardExists == false) {
                        // Create a new credit card object and add it to the bank cards list
                        creditCard = new CreditCard(card, clientName, issuerBank, bankAccount, balance, cvc, interest, expirationDate);
                        bankCards.add(creditCard);
                        JOptionPane.showMessageDialog(null, "Credit Card added successfully.");
                        clear();
                    } else {
                        JOptionPane.showMessageDialog(null, "!!! Credit Card with this Card Id already exists !!!");
                    }

                }
            //When an exception occurs an alert message is dispalyed instead of crashing the whole program
            }catch(Exception exception){
                JOptionPane.showMessageDialog(null, "!!! Please enter valid input only: Integer Value for Card Id and CVC number, Decimal Value for Balance Amount and Interest Rate !!!");
            }
        });
        //action listener for clear button is created that calls clear method
        clearBtn.addActionListener(e -> {
            clear();
        });
        //action listener for display button is created to open addCreditCard dialog box
        displayBtn.addActionListener(e -> {
            new DisplayCreditCards(bankCards);
        });
        //Layout, insets and anchor is set for JPanel
        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;

        addCreditCardPanel.setLayout(gbl);
        //With the help of gridbagconstraints, positioning of each component is done and arranged with gridbag layout
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 4;
        addCreditCardPanel.add(addCreditCardLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        addCreditCardPanel.add(cardIdLabel, gbc);

        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        addCreditCardPanel.add(cardIdTf, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        addCreditCardPanel.add(clientNameLabel, gbc);

        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        addCreditCardPanel.add(clientNameTf, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        addCreditCardPanel.add(issuerBankLabel, gbc);

        gbc.gridx = 2;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        addCreditCardPanel.add(issuerBankTf, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        addCreditCardPanel.add(bankAccountLabel, gbc);

        gbc.gridx = 2;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        addCreditCardPanel.add(bankAccountTf, gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        addCreditCardPanel.add(balanceAmountLabel, gbc);

        gbc.gridx = 2;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        addCreditCardPanel.add(balanceAmountTf, gbc);

        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.gridwidth = 1;
        addCreditCardPanel.add(cvcNumberLabel, gbc);

        gbc.gridx = 2;
        gbc.gridy = 6;
        gbc.gridwidth = 1;
        addCreditCardPanel.add(cvcNumberTf, gbc);

        gbc.gridx = 1;
        gbc.gridy = 7;
        gbc.gridwidth = 1;
        addCreditCardPanel.add(interestRateLabel, gbc);

        gbc.gridx = 2;
        gbc.gridy = 7;
        gbc.gridwidth = 1;
        addCreditCardPanel.add(interestRateTf, gbc);

        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 1;
        addCreditCardPanel.add(expirationDateLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 8;
        gbc.gridwidth = 1;
        addCreditCardPanel.add(yearsComboBox, gbc);

        gbc.gridx = 2;
        gbc.gridy = 8;
        gbc.gridwidth = 1;
        addCreditCardPanel.add(monthsComboBox, gbc);

        gbc.gridx = 3;
        gbc.gridy = 8;
        gbc.gridwidth = 1;
        addCreditCardPanel.add(daysComboBox, gbc);

        gbc.gridx = 1;
        gbc.gridy = 9;
        gbc.gridwidth = 1;
        addCreditCardPanel.add(clearBtn, gbc);

        gbc.gridx = 2;
        gbc.gridy = 9;
        gbc.gridwidth = 1;
        addCreditCardPanel.add(addBtn, gbc);

        gbc.gridx = 1;
        gbc.gridy = 10;
        gbc.gridwidth = 2;
        addCreditCardPanel.add(displayBtn, gbc);
        //the panel is then added to the frame
        add(addCreditCardPanel);
    }

    // clear method sets all the values in text field to empty string and changes the index of combo box to 0
    public void clear(){
        cardIdTf.setText("");
        clientNameTf.setText("");
        issuerBankTf.setText("");
        bankAccountTf.setText("");
        balanceAmountTf.setText("");
        cvcNumberTf.setText("");
        interestRateTf.setText("");
        yearsComboBox.setSelectedIndex(0);
        monthsComboBox.setSelectedIndex(0);
        daysComboBox.setSelectedIndex(0);
    }
}
