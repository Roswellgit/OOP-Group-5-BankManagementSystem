package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import static java.awt.Color.black;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import javax.swing.border.LineBorder;
import javax.swing.table.*;

public class TransactionUI extends JFrame implements ActionListener {

    private JFrame Acc;
    private ImageIcon BgColor;
    private JPanel panel1, transpanel;
    private JLabel label1;
    private JButton  ExitBtn;
    private Icon image;
    private JTable tblRecords;
    private JScrollPane spScroll;
    private DefaultTableModel ColumnHeaders;
    private JTableHeader TableHeader;

    public TransactionUI() {

        // Frame
        Acc = new JFrame();
        Acc.setTitle("BANK MANAGEMENT SYSTEM");
        Acc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Acc.setResizable(false);
        Acc.setSize(600, 510);
        Acc.setLocationRelativeTo(null);

        // BG
        BgColor = new ImageIcon("logo.png");
        Acc.setIconImage(BgColor.getImage());
        Acc.getContentPane().setBackground(new Color(100, 50, 78));
        Acc.setLayout(new BorderLayout());
        label1 = new JLabel(" Bank Transactions");
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
        
        //table & scroll
        ColumnHeaders = new DefaultTableModel(new Object[] {"Transaction ID", "Date", "Type", "Amount", "Balance"}, 0);
        tblRecords = new JTable(ColumnHeaders);
        tblRecords.setOpaque(false);
        
        TableHeader = tblRecords.getTableHeader();
        tblRecords.getTableHeader().setBackground(new Color(181,103,110));
        tblRecords.getTableHeader().setForeground(black);
        tblRecords.getTableHeader().setFont(new Font("Aptos", Font.PLAIN, 12));
        
        spScroll = new JScrollPane(tblRecords);
        spScroll.setBounds(30, 40, 450, 300);
        spScroll.setBorder(new LineBorder(Color.BLACK, 1));
        transpanel.add(spScroll);

        try {
 
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_bank", "root", "root");
        Statement st = con.createStatement();

        String q = "SELECT * FROM history";
        ResultSet rs = st.executeQuery(q);

        DefaultTableModel model = (DefaultTableModel) tblRecords.getModel();

        while (rs.next()) {
            String accnum = rs.getString("acc_num");
            String date = rs.getString("date");
            String type = rs.getString("type");
            String amnt = rs.getString("amnt");
            String accbal = rs.getString("acc_bal");
            String tbData[] = {accnum, date, type, amnt, accbal};
            model.addRow(tbData);
        }
        con.close();
    }
catch(Exception ex){
    System.out.println(ex);
}

        //Exit
        ExitBtn = new JButton("EXIT");
        ExitBtn.setBounds(400, 275, 100, 20);
        ExitBtn.setFont(new Font("Arial", Font.BOLD, 10));
        ExitBtn.addActionListener(this);
        panel1.add(ExitBtn);       
        
        Acc.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent close) {
        if(close.getSource() == ExitBtn) {
           
            Acc.dispose();
            BankMainMenu u = new BankMainMenu();
        }
    }
}