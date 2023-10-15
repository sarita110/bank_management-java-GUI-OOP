package BankSystem.views;

//different classes are imported from their packages so they can used in this class
import BankSystem.BankCard;
import BankSystem.DebitCard;
import BankSystem.components.MyCustomButton;
import BankSystem.components.MyCustomComboBox;
import BankSystem.components.MyCustomLabel;
import BankSystem.components.MyCustomTextField;

//different packages containing inbuilt classes of java is importedv
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

//WithdrawFromDebitCard class inherits attributes and methods of JFrame class
public class WithdrawFromDebitCard extends JFrame {
    //Declaring all the labels, text fields, button and combo box to be used by creating instance of classes of components
    MyCustomButton withdrawBtn, clearBtn;
    MyCustomTextField cardIdTf, withdrawalAmountTf, pinNumberTf;
    MyCustomLabel withdrawFromDebitCardLabel, cardIdLabel, withdrawalAmountLabel, dateOfWithdrawalLabel, pinNumberLabel;
    MyCustomComboBox yearsComboBox, monthsComboBox, daysComboBox;

    //The constructor asks BankCard arraylist as its parameter
    public WithdrawFromDebitCard(ArrayList<BankCard> bankCards) {
        super("Withdraw from Debit Card");
        setVisible(true);
        setSize(650, 600);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setLocationRelativeTo(null);

        Font calistoLabel = new Font("Calisto MT", Font.PLAIN, 33);

        JPanel panel = new JPanel();
        panel.setBackground(Color.lightGray);

        //All the UI components are now initialized
        withdrawFromDebitCardLabel = new MyCustomLabel("Withdraw from Debit Card");
        withdrawFromDebitCardLabel.setHorizontalAlignment(MyCustomLabel.CENTER);
        withdrawFromDebitCardLabel.setFont(calistoLabel);

        cardIdLabel = new MyCustomLabel("Card Id");
        withdrawalAmountLabel = new MyCustomLabel("Withdrawal Amount");
        dateOfWithdrawalLabel = new MyCustomLabel("Date of Withdrawal");
        pinNumberLabel = new MyCustomLabel("PIN Number");

        cardIdTf = new MyCustomTextField("");
        withdrawalAmountTf = new MyCustomTextField("");
        pinNumberTf = new MyCustomTextField("");

        yearsComboBox = new MyCustomComboBox(new String[]{"select year", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2024", "2025"});
        monthsComboBox = new MyCustomComboBox(new String[]{"select month", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10","11","12"});
        daysComboBox = new MyCustomComboBox(new String[]{"select day", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10","11","12","13","14","15","16","17","18","19","20", "21","22","23","24","25","26","27","28","29","30","31"});

        withdrawBtn = new MyCustomButton("Withdraw");
        clearBtn = new MyCustomButton("Clear");

        withdrawBtn.addActionListener(e -> {
            String cardId = cardIdTf.getText();
            String withdrawalAmount = withdrawalAmountTf.getText();
            String pinNumber = pinNumberTf.getText();
            String dateOfWithdrawal = yearsComboBox.getSelectedItem().toString() + "- " + monthsComboBox.getSelectedItem().toString() + "-" + daysComboBox.getSelectedItem().toString();

            try{
                if (cardId.equals("") || withdrawalAmount.equals("") || pinNumber.equals("")) {
                    JOptionPane.showMessageDialog(null, "!!! Please fill all the fields !!!");
                } else if (yearsComboBox.getSelectedIndex() == 0 || monthsComboBox.getSelectedIndex() == 0 || daysComboBox.getSelectedIndex() == 0) {
                    JOptionPane.showMessageDialog(null, "!!! Select all year, month and day. !!!");
                } else {
                    // Convert input values to their respective data types
                    int card = Integer.parseInt(cardId);
                    double withdrawal = Double.parseDouble(withdrawalAmount);
                    int pin = Integer.parseInt(pinNumber);
                    boolean foundCard = false;
                    DebitCard debitCard = null;
                    // Loop through all bank cards to find the correct debit card
                    for (BankCard bankCard : bankCards) {
                        if (bankCard instanceof DebitCard) {
                            debitCard = (DebitCard) bankCard;
                            if (debitCard.getCardId() == card) {
                                foundCard = true;
                                break;
                            }
                        }
                    }

                    if (foundCard) {
                        // If the debit card is found, call the withdraw method with the given parameter
                        withdraw(debitCard, pin, withdrawal, dateOfWithdrawal);
                    } else {
                        JOptionPane.showMessageDialog(null, "!!! Card not found. Enter registered CardId !!!");
                    }
                }
            }catch (Exception exception){
                JOptionPane.showMessageDialog(null, "!!! Please enter valid input: Integer value only for Card Id and Pin Number, Decimal Value for Withdrawal Amount !!!");
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
        panel.add(withdrawFromDebitCardLabel, gbc);

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
        panel.add(pinNumberLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        panel.add(pinNumberTf, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        panel.add(withdrawalAmountLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        panel.add(withdrawalAmountTf, gbc);


        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        panel.add(dateOfWithdrawalLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        panel.add(yearsComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        panel.add(monthsComboBox, gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        panel.add(daysComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 1;
        panel.add(clearBtn, gbc);

        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.gridwidth = 1;
        panel.add(withdrawBtn, gbc);

        add(panel);
    }

    public void withdraw(DebitCard debitCard, int pin, double withdrawal, String dateOfWithdrawal) {
        try{
            if (debitCard.getPinNumber() == pin) {
                if (debitCard.getBalanceAmount() < withdrawal) {
                    JOptionPane.showMessageDialog(null, "!!! Insufficient Funds !!!");
                    return;
                }
                debitCard.withDraw(withdrawal, dateOfWithdrawal, pin);
                JOptionPane.showMessageDialog(null, "Withdrawal Successful");
                clear();
            } else {
                JOptionPane.showMessageDialog(null, "!!! Incorrect Pin Number !!!");
            }
        }catch (Exception exception){
            JOptionPane.showMessageDialog(null, "!!! Error occurred !!!");
        }
    }

    public void clear() {
        cardIdTf.setText("");
        withdrawalAmountTf.setText("");
        pinNumberTf.setText("");
        yearsComboBox.setSelectedIndex(0);
        monthsComboBox.setSelectedIndex(0);
        daysComboBox.setSelectedIndex(0);
    }

}
