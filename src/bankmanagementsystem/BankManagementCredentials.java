package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BankManagementCredentials {
    
    //combobox
    private String[] MonthOptions = {"Month", "January", "February", "March", "April",
    "May", "June", "July", "August", "September", "October", "November", "December"};
    private String[] DayOptions = {"Day", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15",
    "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
    private String[] SexOptions = {" ", "Male", "Female", "Attack Helicopter"};
    private String[] StatusOptions = {" ", "Single", "Married", "Widowed", "Legally Separated"};

    //frame
    private JFrame f = new JFrame ("Account Creation");
    private JPanel header, footer;
    private JComboBox<String> cbMonth = new JComboBox<>(MonthOptions);
    private JComboBox<String> cbDay = new JComboBox<>(DayOptions);
    private JComboBox<String> cbSex = new JComboBox<>(SexOptions);
    private JComboBox<String> cbStatus = new JComboBox<>(StatusOptions);
    private JLabel lblLastName, lblFirstName, lblMiddleName,lblSuffix, lblAge, lblStatus, lblBDay, lblYear, lblSex;
    private JTextField tfBlank = new JTextField();
    private JTextField tfLastName = new JTextField();
    private JTextField tfFirstName = new JTextField();
    private JTextField tfMiddleName = new JTextField();
    private JTextField tfSuffix = new JTextField();
    private JTextField tfAge = new JTextField();
    private JTextField tfYear = new JTextField();
    private JButton btnNextPage, btnReset;
    
    
    
    BankManagementCredentials(){
        f.setSize(480, 750);
        f.setLayout(null);
        f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
        f.getContentPane().setBackground(new java.awt.Color(214, 214, 214));
        
        header = new JPanel();
        header.setBackground(Color.GRAY);
        header.setBounds(0, 0, 480, 80);
     
        footer = new JPanel();
        footer.setBackground(Color.GRAY);
        footer.setBounds(0, 670, 480, 80);
        
        //Full Name
        tfBlank.setBounds(0,0,0,0);
        
        lblLastName = new JLabel ("Last Name");
        lblLastName.setBounds (60, 130, 100, 30);
        tfLastName.setBounds(40, 160, 105, 30);
        tfLastName.setHorizontalAlignment(JTextField.CENTER);

        lblFirstName = new JLabel ("First Name");
        lblFirstName.setBounds (170, 130, 100, 30);
        tfFirstName.setBounds(150, 160, 105, 30);
        tfFirstName.setHorizontalAlignment(JTextField.CENTER);

        lblMiddleName = new JLabel ("Middle Name");
        lblMiddleName.setBounds (270, 130, 100, 30);
        tfMiddleName.setBounds(260, 160, 105, 30);
        tfMiddleName.setHorizontalAlignment(JTextField.CENTER);

        lblSuffix = new JLabel ("Suffix");
        lblSuffix.setBounds (375, 130, 100, 30);
        tfSuffix.setBounds(370, 160, 50, 30);
        tfSuffix.setHorizontalAlignment(JTextField.CENTER);

        //Age
        lblAge = new JLabel ("Age");
        lblAge.setBounds (90, 245, 50, 30);
        tfAge.setBounds(40, 280, 120, 30);
        tfAge.setHorizontalAlignment(JTextField.CENTER);

        //Birthday
        lblBDay = new JLabel ("Date of Birth");
        lblBDay.setBounds (275, 245, 120, 30);
        
        cbMonth.setBounds(180, 280, 110, 30);
        
        cbDay.setBounds(300, 280, 60, 30);
        
        lblYear = new JLabel ("YYYY");
        lblYear.setBounds (378, 300, 50, 30);
        lblYear.setFont(new Font("Arial", Font.PLAIN, 11));
        tfYear.setBounds (370, 280, 50, 30);
        tfYear.setHorizontalAlignment(JTextField.CENTER);
        
        //Sex
        lblSex = new JLabel ("Sex ");
        lblSex.setBounds (118, 370, 120, 30);
        cbSex.setBounds(40, 400, 180, 30);
        
        //Civil Status
        lblStatus = new JLabel ("Civil Status");
        lblStatus.setBounds (300, 370, 120, 30);
        cbStatus.setBounds(240, 400, 180, 30);

        //Buttons
        btnNextPage = new JButton ("Next");
        btnNextPage.setBounds(250,550, 140, 40);
        btnNextPage.setBackground(new Color(155,155,155));
        btnNextPage.setForeground(Color.WHITE);
        btnNextPage.setFocusPainted(false);
        btnNextPage.setFont(new Font("Arial", Font.PLAIN, 18));
        
        btnReset = new JButton ("Reset");
        btnReset.setBounds (70, 550, 140, 40);
        btnReset.setFont(new Font("Arial", Font.PLAIN, 18));
        
        f.add(header);
        f.add(footer);
        f.add(tfBlank);
        f.add(lblLastName);
        f.add(lblFirstName);
        f.add(lblMiddleName);
        f.add(lblSuffix);
        f.add(lblAge);
        f.add(lblStatus);
        f.add(lblBDay);
        f.add(lblYear);
        f.add(lblSex);
        f.add(tfLastName);
        f.add(tfFirstName);
        f.add(tfMiddleName);
        f.add(tfSuffix);
        f.add(tfAge);
        f.add(tfYear);
        f.add(btnNextPage);
        f.add(btnReset);
        f.add(cbStatus);
        f.add(cbSex);
        f.add(cbMonth);
        f.add(cbDay);

        f.setVisible(true);
        f.setResizable(false);
    }
}
