/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bankmanagementsystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
    
public class BankMainMenu {
    
    
       //frame
        private JFrame f = new JFrame("Main Menu");
        private JPanel header, footer;
        private ImageIcon Logo;
        private JLabel lblLogo , lblBankName,lblInfo;
        private JButton btnNewAcc, btnTrans;
        
        
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
        lblInfo = new JLabel("Main Menu:");
        lblInfo.setBounds(30,150,300,50);
        Font font = new Font("Aptos", Font.BOLD, 18);
        lblInfo.setFont(font);
        
        
        //Main Menu buttons
        
        btnNewAcc = new JButton("Create New Account");
        btnNewAcc.setBounds(20,300,300,100);
        btnNewAcc.setFont(new Font("Arial", Font.PLAIN, 15));
        
        btnTrans = new JButton("Process Transaction");
        btnTrans.setBounds(20,450,300,100);
        btnTrans.setFont(new Font("Arial", Font.PLAIN, 15));
        
        f.add(header);
        f.add(footer);
        
        header.add(lblLogo);
        header.add(lblBankName, BorderLayout.NORTH);
        
        
        f.add(lblInfo);
        f.add(btnNewAcc);
        f.add(btnTrans);
        
        f.setVisible(true);
        f.setResizable(false);
        
}
        
    }

