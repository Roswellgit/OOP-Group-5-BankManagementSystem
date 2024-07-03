package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class TransactionUI extends JFrame implements ActionListener {

    private JFrame Acc;
    private ImageIcon BgColor, iconImage;
    private JPanel panel1, transpanel;
    private JLabel label1, lblInfo, AccNamelbl, AccNumlbl, balancelbl;
    private JTextField tfBlank, depotf;
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
        Acc.setLocationRelativeTo(null);

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
        
       
        // Account Number
        AccNumlbl = new JLabel("Account Number:");
        AccNumlbl.setBounds(10, 70, 150, 25);
        
        

        // Account Balance 
        balancelbl = new JLabel("Account Balance: ₱ ");
        balancelbl.setBounds(265, 40, 150, 25);
        
        
//
//        // Table
//        String[] columnNames = {"Transaction ID", "Date", "Type", "Amount", "Balance"};
//        Object[][] data = {
//            {"1", "", "", "", ""},
//            {"2", "", "", "", ""},
//            {"3", "", "", "", ""},
//            {"4", "", "", "", ""},
//            {"5", "", "", "", ""}
//        };
//        transTable = new JTable(new DefaultTableModel(data, columnNames));
//        transtable = new JScrollPane(transTable);
//        transtable.setBounds(30, 120, 450, 200);
//        transpanel.add(transtable);
// transTable = new JTable();
//        transtable = new JScrollPane(transTable);
//        transTable.setBounds(30, 120, 450, 200); 
//        transpanel.add(transTable); 
//        transpanel.add(transtable);
//        transTable.setModel(new javax.swing.table.DefaultTableModel(
//        new Object[][]{
//            
//        },
//        new String[]{"Transaction ID", "Date", "Type", "Amount", "Balance"}
//        ));
//        try{
//    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_bank","root","root");
//    
//    Statement st = con.createStatement();
//    
//    String q =  "SELECT * FROM history";
//    ResultSet rs = st.executeQuery(q);
//    
//    while(rs.next()){
//        String accnum = rs.getString("acc_num");
//        String date = rs.getString("date");
//        String type = rs.getString("type");
//        String amnt = rs.getString("amnt");
//        String accbal= rs.getString("acc_bal");
//        
//        
//        String tbData[] = {accnum,date,type,amnt,accbal};
//        DefaultTableModel record = (DefaultTableModel)transTable.getModel();
//        
//        record.addColumn("Account Number");
//        record.addRow(tbData);
//      
//        
//    }
//    con.close();
//}
//catch(Exception ex){
//    System.out.println(ex);
//}
        transTable = new JTable();
        transtable = new JScrollPane(transTable);
        transTable.setBounds(30, 120, 450, 200);
        transpanel.add(transTable);
        transpanel.add(transtable);
        transTable.setModel(new javax.swing.table.DefaultTableModel(
        
        new Object[][]{},
        new String[]{"Transaction ID", "Date", "Type", "Amount", "Balance"}
        ));

        try {
 
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_bank", "root", "root");
        Statement st = con.createStatement();

        String q = "SELECT * FROM history";
        ResultSet rs = st.executeQuery(q);

        DefaultTableModel model = (DefaultTableModel) transTable.getModel();

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
        
        transpanel.add(AccNamelbl);
        transpanel.add(AccNumlbl);
        transpanel.add(balancelbl);
        
        
        Acc.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent close) {
        if(close.getSource() == ExitBtn) {
            Acc.dispose();
        }
    }
}