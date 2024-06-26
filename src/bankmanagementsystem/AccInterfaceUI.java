package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class AccInterfaceUI implements ActionListener  {
    
    private JFrame Acc;
    private ImageIcon BgColor, iconImage, Depic, depImage;
    private JPanel panel1, depanel, deposit;
    private JLabel label1, lblInfo, AccNamelbl, AccNumlbl, balancelbl, depoLbl, withLbl, transLbl, pinLbl ;
    private JTextField tfBlank, AccNametf, AccNumtf, balancetf, depotf;
    private JButton depoBtn, WdrawBtn, transBtn, pinBtn, ReturnBtn;
    private Connection conn;
    private String accountNumber = "123456";
    
   
    
    public AccInterfaceUI() {
        //frame
        Acc = new JFrame();
        Acc.setTitle("USER ACCOUNT INTERFACE");
        Acc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Acc.setResizable(false);
        Acc.setSize(600, 510);
        Acc.setLocationRelativeTo(null);
        
        // logo
        BgColor = new ImageIcon("logo.png");
        Acc.setIconImage(BgColor.getImage());
        Acc.getContentPane().setBackground(new Color(100,50,78));
        Acc.setLayout(new BorderLayout());
        
        //label "bank of bsit"
        ImageIcon iconImage = new ImageIcon("logo1.png");
        Image sizeImage = iconImage.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(sizeImage);
        label1 = new JLabel("BOB - BANK OF BSIT");
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("Courier New", Font.BOLD, 35));
        label1.setHorizontalAlignment(JLabel.CENTER);
        label1.setIcon(image);
        Acc.add(label1, BorderLayout.NORTH);
        
        //panel at the bg of the icons
        panel1 = new JPanel();
        panel1.setBackground(new Color(100,50,78));
        panel1.setBounds(50, 50, 500, 400);
        Acc.add(panel1, BorderLayout.CENTER); 
        
        depanel = new JPanel();
        depanel.setLayout(null);  
        depanel.setBackground(new Color(220, 190, 200));
        depanel.setPreferredSize(new Dimension(550, 330));
        panel1.add(depanel, BorderLayout.CENTER);
        
        // textfields
        lblInfo = new JLabel("ACCOUNT INFORMATION");
        lblInfo.setBounds(170,0,300,50);
        Font font = new Font("Aptos", Font.BOLD, 20);
        lblInfo.setFont(font);
        
        //AccInfo
        tfBlank = new JTextField();
        tfBlank.setBounds(0,0,0,0);
        
        AccNamelbl = new JLabel ("Account Name:");
        AccNamelbl.setBounds (40, 50, 100, 40);
        AccNametf = new JTextField();
        AccNametf.setBounds(170, 60, 150, 20);
        AccNametf.setHorizontalAlignment(JTextField.CENTER);
        
        AccNumlbl = new JLabel ("Account Number:");
        AccNumlbl.setBounds (40, 80, 140, 40);
        AccNumtf = new JTextField();
        AccNumtf.setBounds(170, 90, 150, 20);
        AccNumtf.setHorizontalAlignment(JTextField.CENTER);
        
        //Balance
        balancelbl = new JLabel ("Balance");
        balancelbl.setBounds (420, 50, 100, 30);
        balancetf = new JTextField();
        balancetf.setBounds(370, 82, 150, 25);
        balancetf.setHorizontalAlignment(JTextField.CENTER);

        //Deposit btn
        depoBtn = new JButton();
        depImage = new ImageIcon("dep.png");
        Image depsize = depImage.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        depoBtn.setIcon(new ImageIcon(depsize));
        depoBtn.setBounds(25, 150, 115, 120);
        depoBtn.addActionListener(this);
        
        //Deposit Lbl
        depoLbl = new JLabel("DEPOSIT");
        depoLbl.setBounds(25, 275, 115, 20);
        depoLbl.setHorizontalAlignment(SwingConstants.CENTER);
        depoLbl.setFont(new Font("Arial Black", Font.BOLD, 12));
        
        //Withdraw Btn
        WdrawBtn = new JButton();
        ImageIcon WdraImage = new ImageIcon("Wdraw.png");
        Image Wdrawsize = WdraImage.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        WdrawBtn.setIcon(new ImageIcon(Wdrawsize));
        WdrawBtn.setBounds(150, 150, 115, 120);
        WdrawBtn.addActionListener(this);
        
        //withdraw Lbl
        withLbl = new JLabel("WITHDRAW");
        withLbl.setBounds(150, 275, 115, 20);
        withLbl.setHorizontalAlignment(SwingConstants.CENTER);
        withLbl.setFont(new Font("Arial Black", Font.BOLD, 12));
        
        //Transactions Btn
        transBtn = new JButton();
        ImageIcon transImage = new ImageIcon("Transfer.png");
        Image transize = transImage.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        transBtn .setIcon(new ImageIcon(transize));
        transBtn.setBounds(275, 150, 115, 120);
        transBtn.addActionListener(this);
        
        //Transaction Lbl
        transLbl = new JLabel("TRANSACTION");
        transLbl.setBounds(275, 275, 115, 20);
        transLbl.setHorizontalAlignment(SwingConstants.CENTER);
        transLbl.setFont(new Font("Arial Black", Font.BOLD, 12));
        
        
        //Change Pin
        pinBtn = new JButton();
        ImageIcon pinImage = new ImageIcon("Pin.png");
        Image pinsize = pinImage.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        pinBtn.setIcon(new ImageIcon(pinsize));
        pinBtn.setBounds(400, 150, 115, 120);
        pinBtn.addActionListener(this);
        
        //cHANGE PIN Lbl
        pinLbl = new JLabel("CHANGE PIN");
        pinLbl.setBounds(400, 275, 115, 20);
        pinLbl.setHorizontalAlignment(SwingConstants.CENTER);
        pinLbl.setFont(new Font("Arial Black", Font.BOLD, 12));
        
        //Return
        ReturnBtn = new JButton("RETURN");
        ReturnBtn.setBounds(400, 275, 100, 20);
        ReturnBtn.setFont(new Font("Arial", Font.BOLD, 10));
        ReturnBtn.setFocusable(false);
        ReturnBtn.addActionListener(this);
        
        
        depanel.add(lblInfo);
        depanel.add(AccNamelbl);
        depanel.add(AccNumlbl);
        depanel.add(AccNametf);
        depanel.add(AccNumtf);
        depanel.add(balancelbl);
        depanel.add(balancetf);
        depanel.add(depoBtn);
        depanel.add(depoLbl);
        depanel.add(WdrawBtn);
        depanel.add(withLbl);
        depanel.add(transBtn );
        depanel.add(transLbl );
        depanel.add(pinBtn);
        depanel.add(pinLbl);
        panel1.add(ReturnBtn);

        
        Acc.setVisible(true);
        
         try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_bank", "root", "root");
            fetchAccountData(accountNumber);
        } catch (Exception e) {
            System.out.print(e);
        }
    }
    
    @Override 
    public void actionPerformed(ActionEvent openclass) {
        
        if(openclass.getSource()==ReturnBtn) { 
            Acc.dispose();
            BankMainMenu bankmainmenu = new BankMainMenu();
        }
        else if(openclass.getSource()==depoBtn) { 
            Acc.dispose();
            DepositUI depositui = new DepositUI();
        }
        else if(openclass.getSource()==WdrawBtn) { 
              Acc.dispose();
            WithdrawUI withdrawui = new WithdrawUI();
        }
        else if(openclass.getSource()==transBtn) { 
              Acc.dispose();
            TransactionUI transactionui = new TransactionUI();
        }
        else if(openclass.getSource()==pinBtn) { 
              Acc.dispose();
            ChangePinUI changepinui = new ChangePinUI();
        }
    }
  
   private void fetchAccountData(String accNumber) {
        try {
            String query = "SELECT acc_name, acc_bal FROM transactions WHERE acc_number = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, accNumber);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                String accName = rs.getString("acc_name");
                String accBal = rs.getString("acc_bal");
                System.out.println("Account Name: " + accName); 
                System.out.println("Account Balance: " + accBal);
                AccNametf.setText(accName);
                balancetf.setText(accBal);
                AccNumtf.setText(accNumber);
            } 
            
        } catch (Exception e) {
           System.out.println(e);
        }
        
    }
}
