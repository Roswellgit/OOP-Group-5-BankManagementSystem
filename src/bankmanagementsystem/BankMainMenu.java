/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bankmanagementsystem;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
    
public class BankMainMenu implements ActionListener {
    
       //frame
        private JFrame f = new JFrame("Main Menu");
        private JPanel header, footer, UserLogo, UserInfo, UserTransac;
        private ImageIcon Logo, Profile, Info, Transactions;
        private JLabel lblLogo , lblBankName, lblInfo, lblProfile, lblUserInfo, lblTransactions;
        private JButton btnNewAcc, btnUserInfo, btnTransactions;
        
        
    BankMainMenu(){
        
        f.setSize(480, 750);
        f.setLayout(null);
        f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
        f.getContentPane().setBackground(new java.awt.Color(220, 190, 200));
        
        header = new JPanel();
        header.setBackground(new java.awt.Color(100,50,78));
        header.setBounds(0, 0, 480, 110);
        
        footer = new JPanel();
        footer.setBackground(new java.awt.Color(100,50,78));
        footer.setBounds(0, 670, 480, 80);
        
        //bank logo
        Logo = new ImageIcon("BlackLogo.png");
        Image ResizedLogo = Logo.getImage().getScaledInstance( 90, 90, Image.SCALE_SMOOTH);
        ImageIcon FinalLogo = new ImageIcon(ResizedLogo);   
        lblLogo = new JLabel(FinalLogo);
        
        //bank title
        lblBankName = new JLabel("BANK OF BSIT");
        lblBankName.setForeground(Color.WHITE);
        lblBankName.setFont(new Font("Courier New", Font.BOLD, 40));
        lblBankName.setHorizontalAlignment(JLabel.LEFT);
        
        // Set layout of the frame to null layout
        f.getContentPane().setLayout(null);
    
        // Add the label to the frame
        f.getContentPane().add(lblLogo);
        
         // User Personal Information
        lblInfo = new JLabel("ADMIN MAIN MENU");
        lblInfo.setBounds(155,150,300,50);
        Font font = new Font("Aptos", Font.BOLD, 18);
        lblInfo.setFont(font);
        
        
        //Main Menu buttons
        btnNewAcc = new JButton("Create New User Account");
        btnNewAcc.setBounds(147,300, 215,40);
        btnNewAcc.setFont(new Font("Arial", Font.BOLD, 14));
        btnNewAcc.setFocusable(false);
        btnNewAcc.addActionListener(this);
        
        btnUserInfo = new JButton("View User Information");
        btnUserInfo.setBounds(147,360, 215,40);
        btnUserInfo.setFont(new Font("Arial", Font.BOLD, 15));
        btnUserInfo.setFocusable(false);
        btnUserInfo.addActionListener(this);
        
        btnTransactions = new JButton("Process Transactions");
        btnTransactions.setBounds(147,420, 215,40);
        btnTransactions.setFont(new Font("Arial", Font.BOLD, 15));
        btnTransactions.setFocusable(false);
        btnTransactions.addActionListener(this);
        
        
        //Profile logo for button
        Profile = new ImageIcon("C:\\Users\\myk_b\\OneDrive - JUOFDWSPR\\Documents\\AY 2022-2023\\2nd sem\\Comp prog\\OOP-Group-5-BankManagementSystem\\OOP-Group-5-BankManagementSystem\\OOP-Group-5-BankManagementSystem\\OOP-Group-5-BankManagementSystem\\OOP-Group-5-BankManagementSystem\\test\\PROFILELOGO.png");
        lblProfile = new JLabel(Profile);
        lblProfile.setBounds(0,0,40,40);
        
        UserLogo = new JPanel();
        UserLogo.setBounds(100,295,40,45);
        UserLogo.setBackground(new Color(0, 0, 0, 0));

        //Info logo for button
        Info = new ImageIcon("C:\\Users\\myk_b\\OneDrive - JUOFDWSPR\\Documents\\AY 2022-2023\\2nd sem\\Comp prog\\OOP-Group-5-BankManagementSystem\\OOP-Group-5-BankManagementSystem\\OOP-Group-5-BankManagementSystem\\OOP-Group-5-BankManagementSystem\\OOP-Group-5-BankManagementSystem\\test\\userinfo.png");
        lblUserInfo = new JLabel(Info);
        lblUserInfo.setBounds(0,0,40,40);
        
        UserInfo = new JPanel();
        UserInfo.setBounds(100,355,40,45);
        UserInfo.setBackground(new Color(0, 0, 0, 0));
        
        //Transac logo for button
        Transactions = new ImageIcon("C:\\Users\\myk_b\\OneDrive - JUOFDWSPR\\Documents\\AY 2022-2023\\2nd sem\\Comp prog\\OOP-Group-5-BankManagementSystem\\OOP-Group-5-BankManagementSystem\\OOP-Group-5-BankManagementSystem\\OOP-Group-5-BankManagementSystem\\OOP-Group-5-BankManagementSystem\\test\\transactions.png");
        lblTransactions = new JLabel(Transactions);
        lblTransactions.setBounds(0,0,40,40);
        
        UserTransac = new JPanel();
        UserTransac.setBounds(99,415,43,45);
        UserTransac.setBackground(new Color(0, 0, 0, 0));

        
        
        f.add(header);
        f.add(footer);
        
        header.add(lblLogo);
        header.add(lblBankName, BorderLayout.NORTH);
        
        
        f.add(lblInfo);
        f.add(btnNewAcc);
        f.add(btnUserInfo);
        f.add(btnTransactions);
        f.add(UserLogo);
        f.add(UserInfo);
        f.add(UserTransac);
        
        UserLogo.add(lblProfile);
        UserInfo.add(lblUserInfo);
        UserTransac.add(lblTransactions);

        
        f.setVisible(true);
        f.setResizable(false);
        f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);

       
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
    }
    
    }


