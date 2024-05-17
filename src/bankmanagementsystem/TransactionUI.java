package bankmanagementsystem;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class TransactionUI extends JFrame {

    private JFrame Acc;
    private ImageIcon BgColor, iconImage;
    private JPanel panel1, transpanel;
    private JLabel label1, lblInfo, AccNamelbl, AccNumlbl, balancelbl;
    private JTextField tfBlank, AccNametf, AccNumtf, balancetf, depotf;
    private JButton  ExitBtn;
    private Icon image;
    private JTable transTable;
    private final JScrollPane transtable;

    public TransactionUI() {

        // Frame
        Acc = new JFrame();
        Acc.setTitle("BANK MANAGEMENT SYSTEM");
        Acc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Acc.setResizable(false);
        Acc.setSize(600, 510);

        // BG
        BgColor = new ImageIcon("logo.png");
        Acc.setIconImage(BgColor.getImage());
        Acc.getContentPane().setBackground(new Color(100, 50, 78));
        Acc.setLayout(new BorderLayout());
        label1 = new JLabel("Bank Transaction");
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("ARIAL BLACK", Font.BOLD, 20));
        label1.setHorizontalAlignment(JLabel.LEFT);
        label1.setIcon(image);
        Acc.add(label1, BorderLayout.NORTH);

        panel1 = new JPanel();
        panel1.setBackground(new Color(100,50,78));
        panel1.setBounds(100, 50, 520, 380);
        Acc.add(panel1, BorderLayout.CENTER); 

        transpanel = new JPanel();
        transpanel.setLayout(null);
        transpanel.setBackground(new Color(220, 190, 200));
        transpanel.setPreferredSize(new Dimension(520, 380));
        panel1.add(transpanel, BorderLayout.CENTER);

        // Account Name 
        AccNamelbl = new JLabel("Account Name:");
        AccNamelbl.setBounds(10, 30, 150, 25);
        AccNametf = new JTextField();
        AccNametf.setBounds(110, 30, 150, 25);
       
        // Account Number
        AccNumlbl = new JLabel("Account Number:");
        AccNumlbl.setBounds(10, 70, 150, 25);
        AccNumtf = new JTextField();
        AccNumtf.setBounds(110, 70, 150, 25);
        

        // Account Balance 
        balancelbl = new JLabel("Account Balance: ₱ ");
        balancelbl.setBounds(265, 40, 150, 25);
        balancetf = new JTextField();
        balancetf.setBounds(375, 40, 100, 25);
        

        // Table
        String[] columnNames = {"Transaction ID", "Date", "Type", "Amount", "Balance"};
        Object[][] data = {
            {"1", "", "", "", ""},
            {"2", "", "", "", ""},
            {"3", "", "", "", ""},
            {"4", "", "", "", ""},
            {"5", "", "", "", ""}
        };
        transTable = new JTable(new DefaultTableModel(data, columnNames));
        transtable = new JScrollPane(transTable);
        transtable.setBounds(30, 120, 450, 200);
        transpanel.add(transtable);

        //Exit
        ExitBtn = new JButton("EXIT");
        ExitBtn.setBounds(400, 275, 100, 20);
        ExitBtn.setFont(new Font("Arial", Font.BOLD, 10));
        panel1.add(ExitBtn);
        
        transpanel.add(AccNamelbl);
        transpanel.add(AccNametf);
        transpanel.add(AccNumlbl);
        transpanel.add(AccNumtf);
        transpanel.add(balancelbl);
        transpanel.add(balancetf);
        
        Acc.setVisible(true);
    }

}