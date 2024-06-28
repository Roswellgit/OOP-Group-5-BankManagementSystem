package bankmanagementsystem;

import java.awt.*;
import java.awt.event.*;
import java.awt.font.TextAttribute;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;
    
public class BankMainMenu implements ActionListener {

    //frame
    private JFrame f = new JFrame ("MAIN MENU");
    private JPanel header, middle, UserLogo, UserInfo, UserTransac;
    private ImageIcon Logo, Profile, Info, Transactions;;
    private JLabel lblLogo, lblBankName, lblDescription, lblProfile, lblUserInfo, lblTransactions;
    private JButton btnNewAcc, btnUserInfo, btnTransactions, btnReturn;
    
    BankMainMenu(){
        
        f.setSize(600,510);
        f.setLayout(null);
        f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
        f.getContentPane().setBackground(new java.awt.Color(100,50,78));
        f.setLocationRelativeTo(null);
        
        header = new JPanel();
        header.setBackground(new java.awt.Color(100,50,78));
        header.setBounds(0, 0, 600, 100);
        
        middle = new JPanel();
        middle.setBackground(new Color(220, 190, 200));
        middle.setBounds(25,100,535, 330);
        
        //bank logo
        Logo = new ImageIcon("BlackLogo.png");
        Image ResizedLogo = Logo.getImage().getScaledInstance( 90, 90, Image.SCALE_SMOOTH);
        ImageIcon FinalLogo = new ImageIcon(ResizedLogo);   
        lblLogo = new JLabel(FinalLogo);
       
        //bank title
        lblBankName = new JLabel("BANK OF BSIT");
        lblBankName.setForeground(Color.WHITE);
        lblBankName.setFont(new Font("Courier New", Font.BOLD, 40));
        lblBankName.setHorizontalAlignment(JLabel.CENTER);
        
        //Where do u want to go label
        lblDescription = new JLabel("Where would you like to go?");
        lblDescription.setBounds(50,130,200,30);
        lblDescription.setFont(new Font("Aptos", Font.BOLD, 15));
        lblDescription.setVisible(true);
        
        
        // Set layout of the frame to null layout
        f.getContentPane().setLayout(null);

        // Add the label to the frame
        f.getContentPane().add(lblLogo);
        
        //button logos
        Profile = new ImageIcon("PROFILELOGO.png");
        lblProfile = new JLabel(Profile);
        lblProfile.setBounds(0,0,40,40);
        
        UserLogo = new JPanel();
        UserLogo.setBounds(100,295,40,45);
        UserLogo.setBackground(new Color(0, 0, 0, 0));

        //Info logo for button
        Info = new ImageIcon("userinfo.png");
        lblUserInfo = new JLabel(Info);
        lblUserInfo.setBounds(0,0,40,40);
        
        UserInfo = new JPanel();
        UserInfo.setBounds(100,355,40,45);
        UserInfo.setBackground(new Color(0, 0, 0, 0));
        
        //Transac logo for button
        Transactions = new ImageIcon("transactions.png");
        lblTransactions = new JLabel(Transactions);
        lblTransactions.setBounds(0,0,40,40);
        
        UserTransac = new JPanel();
        UserTransac.setBounds(99,415,43,45);
        UserTransac.setBackground(new Color(0, 0, 0, 0));

        //buttons
        btnNewAcc = new JButton("Create New User Account");
        btnNewAcc.setBounds(220,210, 215,40);
        btnNewAcc.setFont(new Font("Arial", Font.BOLD, 14));
        btnNewAcc.setFocusable(false);
        btnNewAcc.addActionListener(this);
        
        btnUserInfo = new JButton("View User Information");
        btnUserInfo.setBounds(220,270, 215,40);
        btnUserInfo.setFont(new Font("Arial", Font.BOLD, 15));
        btnUserInfo.setFocusable(false);
        btnUserInfo.addActionListener(this);
        
        btnTransactions = new JButton("Process Transactions");
        btnTransactions.setBounds(220,330, 215,40);
        btnTransactions.setFont(new Font("Arial", Font.BOLD, 15));
        btnTransactions.setFocusable(false);
        btnTransactions.addActionListener(this);
        
        btnReturn = new JButton("RETURN");
        btnReturn.setBounds(240, 437, 100, 25);
        btnReturn.setFont(new Font("Arial", Font.BOLD, 11));
        btnReturn.setFocusable(false);
        btnReturn.addActionListener(this);
        
        
        f.add(header);
        f.add(middle);
        
        header.add(lblLogo);
        header.add(lblBankName, BorderLayout.NORTH);
        f.add(lblDescription);
        
        middle.add(UserLogo);
        middle.add(UserInfo);
        middle.add(UserTransac);
        f.add(btnNewAcc);
        f.add(btnUserInfo);
        f.add(btnTransactions);
        f.add(btnReturn);
        f.add(middle);
        f.setVisible(true);
        f.setResizable(false);
    }
    
    @Override 
    public void actionPerformed(ActionEvent openclass) {
        
        if(openclass.getSource()==btnNewAcc) {
            f.dispose();
            BankManagementCredentials bankmanagementcredentials = new BankManagementCredentials();
        }
        
        else if(openclass.getSource()==btnUserInfo) {
            f.dispose();
            BankRecords bankrecords = new BankRecords();
        }
        
        else if(openclass.getSource()==btnTransactions) {
            f.dispose();
            AccInterfaceUI accinterfaceUI = new AccInterfaceUI();
        }
        else if(openclass.getSource()==btnReturn) {
            f.dispose();
            UserLogin userlogin = new UserLogin();
        }
        
    }
}



