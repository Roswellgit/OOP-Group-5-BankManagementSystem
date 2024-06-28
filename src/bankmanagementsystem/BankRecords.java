/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bankmanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author win10
 */
public class BankRecords implements ActionListener {
    
    //frames
    private JFrame f = new JFrame("USER RECORDS");
    private JPanel header, footer,table;
    private ImageIcon Logo;
    private JLabel lblLogo, lblBankName;
    private JTable records;
    private JButton btnReturn, btnViewOne, btnViewTwo;
    
    
    
    BankRecords(){
        f.setSize(480, 750);
        f.setLayout(null);
        f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
        f.getContentPane().setBackground(new java.awt.Color(220, 190, 200));
        f.setLocationRelativeTo(null);
        
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

        
        //add date to table
        
        String [][] data = {
            {"Jan Dow", "3422A12"},
            {"Beatrice", "32RE213"},
                 
        };
        
        String[] columnName = { "Name", "Account Number"};
        //create table
        records = new JTable(data,columnName);
        records.setBounds(25,200,350,350);
        
        //make a scroll pane
        JScrollPane tscroll = new JScrollPane(records);
      
        
        //Add the scroll to the Panel
        table = new JPanel();
        table.setLayout(new BorderLayout());
        table.add(tscroll, BorderLayout.CENTER);
        
        
        //buttons
        btnReturn = new JButton ("Return");
        btnReturn.setBounds (180, 570, 100, 30);
        btnReturn.setFont(new Font("Arial", Font.BOLD, 15));
        btnReturn.setFocusable(false);
        btnReturn.addActionListener(this);
        
        btnViewOne = new JButton ("...");
        btnViewOne.setBounds(385,201,25,12);
        btnViewOne.setFocusable(false);
        btnViewOne.addActionListener(this);
        
        btnViewTwo = new JButton("...");
        btnViewTwo.setBounds(385,217,25,12);
        btnViewTwo.setFocusable(false);
        btnViewTwo.addActionListener(this);
        
        
        
        f.add(table);
        f.add(header);
        f.add(footer);
        f.add(tscroll);
        f.add(records);
        f.add(btnReturn);
        f.add(btnViewOne);
        f.add(btnViewTwo);
        
        header.add(lblLogo);
        header.add(lblBankName, BorderLayout.NORTH);
        
        f.setVisible(true);
        f.setResizable(false);
    }
    
    @Override 
    public void actionPerformed(ActionEvent openclass) {
        if(openclass.getSource()==btnReturn) {
            f.dispose();
            BankMainMenu bankmainmenu = new BankMainMenu();
        }
        
        else if(openclass.getSource()==btnViewOne){
            UserOne jandow = new UserOne();
        }
        
        else if(openclass.getSource()==btnViewTwo){
            UserTwo beatrice = new UserTwo();
        }
    }
    
}
