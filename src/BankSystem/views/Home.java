package BankSystem.views;
//different classes are imported from their packages so they can used in this class
import BankSystem.BankCard;
import BankSystem.components.MyCustomButton;
import BankSystem.components.MyCustomLabel;

//different packages containing inbuilt classes of java is imported
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

//Home class inherits attributes and methods of JFrame class
public class Home extends JFrame {
    //different attributes are declared
    //bankCards array stores objects of DebitCard and CreditCard class
    ArrayList<BankCard> bankCards = new ArrayList<>();
    MyCustomButton addCreditCardBtn, addDebitCardBtn, withdrawFromDebitCardBtn, setCreditLimitBtn, cancelCreditCardBtn, displayCardDetailsBtn;
    MyCustomLabel homeLabel;
    public Home(){
        //since JFrame is its parent class different properties of Frame is set by directly calling JFrames methods
        super("Home");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 700);
        setLocationRelativeTo(null);
//        setResizable(true);

        //Desired fonts is created for the label and buttons
        Font calistoLabel = new Font("Calisto MT", Font.PLAIN, 50);
        Font calistoBtn = new Font("Calisto MT", Font.PLAIN, 30);

        //A panel for home screen is created
        JPanel homePanel = new JPanel();
        GridBagLayout homeLayout = new GridBagLayout();
        GridBagConstraints homeGbc = new GridBagConstraints();

        //Layout, insets and anchor is set for JPanel
        homeGbc.fill = GridBagConstraints.BOTH;
        homeGbc.insets = new Insets(15, 20, 15, 20);
        homeGbc.anchor = GridBagConstraints.CENTER;
        homePanel.setLayout(homeLayout);
        homePanel.setForeground(Color.BLACK);
        homePanel.setBackground(Color.lightGray);
        homePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        homeLabel = new MyCustomLabel("Banking Services");
        homeLabel.setFont(calistoLabel);
        homeLabel.setHorizontalAlignment(MyCustomLabel.CENTER);

        addCreditCardBtn = new MyCustomButton("Add Credit Card");
        addCreditCardBtn.setFont(calistoBtn);

        addDebitCardBtn = new MyCustomButton("Add Debit Card");
        addDebitCardBtn.setFont(calistoBtn);

        withdrawFromDebitCardBtn = new MyCustomButton("Withdraw from Debit Card");
        withdrawFromDebitCardBtn.setFont(calistoBtn);

        setCreditLimitBtn = new MyCustomButton("Set the credit limit");
        setCreditLimitBtn.setFont(calistoBtn);

        cancelCreditCardBtn = new MyCustomButton("Cancel Credit Card");
        cancelCreditCardBtn.setFont(calistoBtn);

        displayCardDetailsBtn = new MyCustomButton("Display Card Details");
        displayCardDetailsBtn.setFont(calistoBtn);

        //action listener is added to CreditCardBtn to open AddCreditCard dialog box
        addCreditCardBtn.addActionListener(e -> {
            new AddCreditCard(bankCards);
        });

        //action listener is added to addDebitCardBtn to open AddDebitCard dialog box
        addDebitCardBtn.addActionListener(e -> {
            new AddDebitCard(bankCards);
        });

        //action listener is added to withdrawnFromDebitCardBtn to open WithdrawFromDebitCard dialog box
        withdrawFromDebitCardBtn.addActionListener(e -> {
            new WithdrawFromDebitCard(bankCards);
        });

        //action listener is added to setCreditLimitBtn to open SetCreditLimit dialog box
        setCreditLimitBtn.addActionListener(e -> {
            new SetCreditLimit(bankCards);
        });

        //action listener is added to cancelCreditCardBtn to open CancelCreditCard dialog box
        cancelCreditCardBtn.addActionListener(e -> {
            new CancelCreditCard(bankCards);
        });

        //action listener is added to displayCardDetailsBtn to open DisplayCardDetails dialog box
        displayCardDetailsBtn.addActionListener(e -> {
            new DisplayCardDetails(bankCards);
        });

        //the components are added in the desired region using gridBagConstrains with gridbag Layout
        homeGbc.gridx=0;
        homeGbc.gridy=0;
        homeGbc.gridwidth=2;
        homePanel.add(homeLabel, homeGbc);

        homeGbc.gridx=0;
        homeGbc.gridy=1;
        homeGbc.gridwidth=1;
        homePanel.add(addCreditCardBtn, homeGbc);

        homeGbc.gridx=1;
        homeGbc.gridy=1;
        homeGbc.gridwidth=1;
        homePanel.add(addDebitCardBtn, homeGbc);

        homeGbc.gridx=0;
        homeGbc.gridy=2;
        homeGbc.gridwidth=2;
        homePanel.add(withdrawFromDebitCardBtn, homeGbc);

        homeGbc.gridx=0;
        homeGbc.gridy=3;
        homeGbc.gridwidth=2;
        homePanel.add(setCreditLimitBtn, homeGbc);

        homeGbc.gridx=0;
        homeGbc.gridy=4;
        homeGbc.gridwidth=1;
        homePanel.add(cancelCreditCardBtn, homeGbc);

        homeGbc.gridx=1;
        homeGbc.gridy=4;
        homeGbc.gridwidth=1;
        homePanel.add(displayCardDetailsBtn, homeGbc);

        //the panel is then added to the frame
        add(homePanel);
    }
}

