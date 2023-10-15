package BankSystem.views;

//different classes are imported from their packages so they can used in this class
import BankSystem.BankCard;
import BankSystem.DebitCard;

//different packages containing inbuilt classes of java is imported
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.util.ArrayList;

//DisplayDebitCards class inherits attributes and methods of JFrame class
public class DisplayDebitCards extends JFrame {

    JTable displalyDebitCardtable;

    //The constructor asks BankCard arraylist as its parameter
    public DisplayDebitCards(ArrayList<BankCard> bankCards){
        super("Display Debit Cards");
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(1350, 700);
        setLocationRelativeTo(null);
        //RESIZEABLE
        setResizable(true);
        setVisible(true);

        JPanel panel = new JPanel();
        Border border = BorderFactory.createLineBorder(new Color(142, 68, 173), 2); // create border with custom color
        // Set panel border
        panel.setBorder(BorderFactory.createCompoundBorder(
                border,
                BorderFactory.createEmptyBorder(5, 10, 5, 10) // add padding
        ));

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // create an array of column names for the JTable
        String[] columnNames = {"Card Id", "Bank Account", "Balance", "Client Name", "Card Type", "Pin", "Has Withdrawn"};

        // create an ArrayList to hold all DebitCard objects from bankCards
        ArrayList<DebitCard> debitCards = new ArrayList<>();
        for (BankCard bankCard : bankCards) {
            if (bankCard instanceof DebitCard) {
                debitCards.add((DebitCard) bankCard);
            }
        }

        // create a 2D array of data for the JTable based on the ArrayList of DebitCard objects
        String[][] data = new String[debitCards.size()][8];
        for (int i = 0; i < debitCards.size(); i++) {
            data[i][0] = String.valueOf(debitCards.get(i).getCardId());
            data[i][1] = String.valueOf(debitCards.get(i).getBankAccount());
            data[i][2] = String.valueOf(debitCards.get(i).getBalanceAmount());
            data[i][3] = String.valueOf(debitCards.get(i).getClientName());
            data[i][4] =  "Debit Card";
            data[i][5] = String.valueOf(debitCards.get(i).getPinNumber());
            data[i][6] = String.valueOf(debitCards.get(i).getHasWithdrawn());
        }
        // create a new JTable using the data and column names
        displalyDebitCardtable = new JTable(data, columnNames);

        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                // cast the component to JComponent before calling setBorder()
                ((JComponent) c).setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // set the padding
                return c;
            }
        };


        displalyDebitCardtable.setFont(new Font("Calisto MT", Font.PLAIN, 22));
        displalyDebitCardtable.getTableHeader().setFont(new Font("Calisto MT", Font.PLAIN, 20));

        // apply the custom renderer to all columns
        for (int i = 0; i < displalyDebitCardtable.getColumnCount(); i++) {
            displalyDebitCardtable.getColumnModel().getColumn(i).setCellRenderer(renderer);
        }

        JScrollPane scrollPane = new JScrollPane(displalyDebitCardtable);
        scrollPane.setPreferredSize(new Dimension(1100, 600));
        panel.add(scrollPane);
        add(panel);
    }
}
