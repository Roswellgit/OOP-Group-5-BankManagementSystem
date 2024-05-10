package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;

public class BankManagementCredentials {
    
    //combobox
    private String[] MonthOptions = {"Month", "January", "February", "March", "April",
    "May", "June", "July", "August", "September", "October", "November", "December"};
    private String[] DayOptions = {"Day", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15",
    "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
    private String[] SexOptions = {" ", "Male", "Female"};
    private String[] StatusOptions = {" ", "Single", "Married", "Widowed", "Legally Separated"};

    //frame
    private JFrame f = new JFrame ("Account Creation");
    private JPanel header, footer;
    private JComboBox<String> cbMonth = new JComboBox<>(MonthOptions);
    private JComboBox<String> cbDay = new JComboBox<>(DayOptions);
    private JComboBox<String> cbSex = new JComboBox<>(SexOptions);
    private JComboBox<String> cbStatus = new JComboBox<>(StatusOptions);
    private JLabel lblLastName, lblFirstName, lblMiddleName,lblSuffix, lblAge, lblStatus, lblBDay, lblYear, lblSex;
    private JTextField tfLastName = new JTextField();
    private JTextField tfFirstName = new JTextField();
    private JTextField tfMiddleName = new JTextField();
    private JTextField tfSuffix = new JTextField();
    private JTextField tfAge = new JTextField();
    private JTextField tfStatus = new JTextField();
    private JTextField tfYear = new JTextField();
    private JTextField tfSex = new JTextField();
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
        lblLastName = new JLabel ("Last Name");
        lblLastName.setBounds (60, 130, 100, 30);
        tfLastName.setBounds(40, 160, 100, 30);
        
        lblFirstName = new JLabel ("First Name");
        lblFirstName.setBounds (170, 130, 100, 30);
        tfFirstName.setBounds(150, 160, 100, 30);
        
        lblMiddleName = new JLabel ("Middle Name");
        lblMiddleName.setBounds (270, 130, 100, 30);
        tfMiddleName.setBounds(260, 160, 100, 30);
        
        lblSuffix = new JLabel ("Suffix");
        lblSuffix.setBounds (375, 130, 100, 30);
        tfSuffix.setBounds(370, 160, 50, 30);
        
        //Age
        lblAge = new JLabel ("Age:");
        lblAge.setBounds (40, 220, 400, 30);
        tfAge.setBounds(120, 220, 50, 30);

        //Birthday
        lblBDay = new JLabel ("Date of Birth: ");
        lblBDay.setBounds (40, 270, 120, 30);
        cbMonth.setBounds(125, 270, 100, 30);
        cbDay.setBounds(235, 270, 50, 30);
        lblYear = new JLabel ("YYYY");
        tfYear.setBounds (295, 270, 40, 30);
        
        //Sex
        lblSex = new JLabel ("Sex: ");
        lblSex.setBounds (40, 335, 120, 30);
        cbSex.setBounds(85, 335, 80, 30);
        
        //Civil Status
        lblStatus = new JLabel ("Civil Status:");
        lblStatus.setBounds (40, 390, 120, 30);
        cbStatus.setBounds(120, 390, 130, 30);

        //buttons
        btnNextPage = new JButton ("Next");
        btnNextPage.setBounds(250,450, 100, 30);
        
        btnReset = new JButton ("Reset");
        btnReset.setBounds (100, 450, 100, 30);
        
        f.add(header);
        f.add(footer);
        f.add(lblLastName);
        f.add(lblFirstName);
        f.add(lblMiddleName);
        f.add(lblSuffix);
        f.add(lblAge);
        f.add(lblStatus);
        f.add(lblBDay);
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
