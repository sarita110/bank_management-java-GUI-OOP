package BankSystem.views;

//different classes are imported from their packages so they can used in this class
import BankSystem.BankCard;
import BankSystem.CreditCard;

//different packages containing inbuilt classes of java is imported
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.util.ArrayList;

//DisplayCreditCards class inherits attributes and methods of JFrame class
public class DisplayCreditCards extends JFrame {

    JTable displayCreditCardTable;

    //The constructor asks BankCard arraylist as its parameter
    public DisplayCreditCards(ArrayList<BankCard> bankCards){
        super("Display Credit Cards");
        setForeground(Color.darkGray);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(1250, 700);
        setLocationRelativeTo(null);
        //RESIZEABLE
        setResizable(true);
        setVisible(true);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        Border border = BorderFactory.createLineBorder(new Color(142, 68, 173), 2); // create border with custom color

        // Set panel border
        panel.setBorder(BorderFactory.createCompoundBorder(
                border,
                BorderFactory.createEmptyBorder(5, 10, 5, 10) // add padding
        ));


// Create an array of column names for the credit card table
        String[] columnNames = {"CardId","ClientName","CreditLimit","GracePeriod","IsGranted","CardType","CVCNumber","InterestRate","ExpirationDate"};

        // Create an ArrayList to store all the credit cards in the bank
        ArrayList<CreditCard> creditCards = new ArrayList<>();

        // Loop through all bank cards and add credit cards to the creditCards
        for (BankCard bankCard : bankCards) {
            if (bankCard instanceof CreditCard) {
                creditCards.add((CreditCard) bankCard);
            }
        }
        String[][] data = new String[creditCards.size()][9];

        // Loop through all credit cards and add their data to the data array
        for (int i = 0; i <creditCards.size(); i++) {
            data[i][0] = String.valueOf(creditCards.get(i).getCardId());
            data[i][1] = String.valueOf(creditCards.get(i).getClientName());
            data[i][2] = String.valueOf(creditCards.get(i).getCreditLimit());
            data[i][3] = String.valueOf(creditCards.get(i).getGracePeriod());
            data[i][4] = String.valueOf(creditCards.get(i).getIsGranted());
            data[i][5] =  "Credit Card";
            data[i][6] = String.valueOf(creditCards.get(i).getCvcNumber());
            data[i][7] = String.valueOf(creditCards.get(i).getInterestRate());
            data[i][8] = String.valueOf(creditCards.get(i).getExpirationDate());
        }
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                // cast the component to JComponent before calling setBorder()
                ((JComponent) c).setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // set the padding
                return c;
            }
        };

        displayCreditCardTable = new JTable(data, columnNames);
        displayCreditCardTable.setFont(new Font("Calisto MT", Font.PLAIN, 22));
        displayCreditCardTable.getTableHeader().setFont(new Font("Calisto MT", Font.PLAIN, 20));

        // apply the custom renderer to all columns
        for (int i = 0; i < displayCreditCardTable.getColumnCount(); i++) {
            displayCreditCardTable.getColumnModel().getColumn(i).setCellRenderer(renderer);
        }


        JScrollPane scrollPane = new JScrollPane(displayCreditCardTable);
        scrollPane.setPreferredSize(new Dimension(1100, 600));
        panel.add(scrollPane);
        add(panel);
    }
}