package bankmanagementsystem;

import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.*;
import java.awt.*;

public class AccountInfoUI extends JFrame implements ActionListener {
    
    private ImageIcon BgColor;
    private JPanel panel1, depanel;
    private JLabel label1;
    private JButton ReturnBtn;
    private JTable records;
    private JScrollPane spScroll;
    private DefaultTableModel ColumnHeaders;
    private JTableHeader tableheader;
    
    AccountInfoUI() {
        setTitle("ACCOUNT INFORMATION");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(1000, 600);
        setLocationRelativeTo(null);
        
        // logo
        BgColor = new ImageIcon("logo.png");
        setIconImage(BgColor.getImage());
        getContentPane().setBackground(new Color(100,50,78));
        setLayout(new BorderLayout());
        
        //label "bank of bsit"
        ImageIcon iconImage = new ImageIcon("logo1.png");
        Image sizeImage = iconImage.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(sizeImage);
        
        label1 = new JLabel("BANK OF BSIT");
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("Courier New", Font.BOLD, 40));
        label1.setHorizontalAlignment(JLabel.CENTER);
        label1.setIcon(image);
        add(label1, BorderLayout.NORTH);
        
        //panel at the bg of the icons
        panel1 = new JPanel();
        panel1.setBackground(new Color(100,50,78));
        panel1.setBounds(0,100,1000,600);
        add(panel1, BorderLayout.CENTER); 
        
        depanel = new JPanel();
        depanel.setPreferredSize(new Dimension(920,415));
        depanel.setLayout(null);
        depanel.setBackground(new Color(220, 190, 200));
        panel1.add(depanel, BorderLayout.CENTER);
        
        //create table
        ColumnHeaders = new DefaultTableModel(new Object[]{"Account Name", "Account Number", "Account Balance"}, 0);
        records = new JTable(ColumnHeaders);
        records.setOpaque(false);

        tableheader = records.getTableHeader();
        records.getTableHeader().setBackground(new Color(181,103,110));
        records.getTableHeader().setForeground(Color.BLACK);
        records.getTableHeader().setFont(new Font("Aptos", Font.PLAIN, 12));
        
        //Add the scroll to the Panel
        spScroll = new JScrollPane(records);
        spScroll.setBounds(40,30,840,350);
        spScroll.setBorder(new LineBorder(Color.BLACK, 1));
        depanel.add(spScroll);
        
        try{
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_bank","root","root");
    
    Statement st = con.createStatement();
    
    String q =  "SELECT * FROM transactions";
    ResultSet rs = st.executeQuery(q);
    
    while(rs.next()){
        String acc_name = rs.getString("acc_name");
        String acc_number = rs.getString("acc_number");
        String acc_bal = rs.getString("acc_bal");
        
        String tbData[] = {acc_name, acc_number, acc_bal};
        DefaultTableModel record = (DefaultTableModel)records.getModel();
        
        record.addRow(tbData);
        
    }
    con.close();
}
catch(Exception ex){
    System.out.println(ex);
}
    
        //Return
        ReturnBtn = new JButton("RETURN");
        ReturnBtn.setBounds(200, 705, 100, 15);
        ReturnBtn.setFont(new Font("Arial", Font.BOLD, 10));
        ReturnBtn.setFocusable(false);
        ReturnBtn.addActionListener(this);
        panel1.add(ReturnBtn);

        
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==ReturnBtn) {
            dispose();
            AccInterfaceUI accinterfaceui = new AccInterfaceUI();
        }
    }
}
