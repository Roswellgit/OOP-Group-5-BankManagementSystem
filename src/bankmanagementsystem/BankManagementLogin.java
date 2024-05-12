/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bankmanagementsystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 *
 * @author win10
 */
public class BankManagementLogin implements ActionListener {
    
    private JFrame log = new JFrame("Bank of Ed");
    private JLabel Uname, Pass,logo;
    private JTextField inp = new JTextField();
    private JPasswordField pa = new JPasswordField();
    private JButton btnLog;
    private JTextArea logres = new JTextArea();
    
    
    
    BankManagementLogin(){
        
        //Background
        
        log.setSize (480,750);
        log.setLayout(null);
        log.setDefaultCloseOperation(log.EXIT_ON_CLOSE);
        
        Uname = new JLabel("Username: ");
        Uname.setBounds(80, 300, 120, 30);
        
        Pass = new JLabel("Password");
        Pass.setBounds(80, 350, 120, 30);
        
        
        inp.setBounds(170,300,190,30);
        
        pa.setBounds(170,350,190,30);
        
        btnLog = new JButton("Login");
        btnLog.setBounds(115,400,100,30);
        btnLog.addActionListener(this);
        
        logres.setBounds(20,300,400,200);
        logres.setEditable(false);
        logres.setLineWrap(true);
        
        log.add(Uname);
        log.add(Pass);
        log.add(inp);
        log.add(pa);
        log.add(btnLog);
        log.add(logres);
        
        log.setVisible(true);
        log.setResizable(false);
        
        
    }
    @Override
    public void actionPerformed(ActionEvent a){
        if(a.getSource()== btnLog){
            String username = inp.getText();
            String password = pa.getText();
            
            logres.setText("Hello");
        }
    }
    
}
