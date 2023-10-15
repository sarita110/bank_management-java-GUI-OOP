package BankSystem.views;

//different classes are imported from their packages so they can used in this class
import BankSystem.BankCard;

//different packages containing inbuilt classes of java is imported
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;

//DisplayCardDetails class inherits attributes and methods of JFrame class
public class DisplayCardDetails extends JFrame {
    //Declaring an instance of JTable
    JTable displayCardDetailsTable;

    //The constructor asks BankCard arraylist as its parameter
    public DisplayCardDetails(ArrayList<BankCard> bankCards){
        super("Display Card Details");
        setVisible(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(1200, 700);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        Border border = BorderFactory.createLineBorder(new Color(142, 68, 173), 2); // create border with custom color

        // Set panel border
        panel.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(5, 10, 5, 10) // add padding
        ));

        String[] columnNames = {"Card Id", "Bank Account", "Balance", "Client Name", "Card Type"};
        // Creating a 2D array to store the data to be displayed in the JTable
        String[][] data = new String[bankCards.size()][5];

        // Looping through each bank card in the list and populating the 2D array with the card's data
        for (int i = 0; i < bankCards.size(); i++) {
            data[i][0] = String.valueOf(bankCards.get(i).getCardId());
            data[i][1] = String.valueOf(bankCards.get(i).getBankAccount());
            data[i][2] = String.valueOf(bankCards.get(i).getBalanceAmount());
            data[i][3] = String.valueOf(bankCards.get(i).getClientName());
            // Card Type: "Debit Card" if the bank card is an instance of DebitCard, otherwise "Credit Card"
            data[i][4] = bankCards.get(i) instanceof BankSystem.DebitCard ? "Debit Card" : "Credit Card";
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

        displayCardDetailsTable = new JTable(data, columnNames);
        displayCardDetailsTable.setFont(new Font("Calisto MT", Font.PLAIN, 22));
        displayCardDetailsTable.getTableHeader().setFont(new Font("Calisto MT", Font.PLAIN, 20));

        // apply the custom renderer to all columns
        for (int i = 0; i < displayCardDetailsTable.getColumnCount(); i++) {
            displayCardDetailsTable.getColumnModel().getColumn(i).setCellRenderer(renderer);
        }

        JScrollPane scrollPane = new JScrollPane(displayCardDetailsTable);
        scrollPane.setPreferredSize(new Dimension(1100, 600));
        panel.add(scrollPane);
        add(panel);
    }
}


