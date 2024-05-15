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
    private ImageIcon Logo;
    private JComboBox<String> cbMonth = new JComboBox<>(MonthOptions);
    private JComboBox<String> cbDay = new JComboBox<>(DayOptions);
    private JComboBox<String> cbSex = new JComboBox<>(SexOptions);
    private JComboBox<String> cbStatus = new JComboBox<>(StatusOptions);
    private JLabel lblLogo, lblBankName, lblInfo, lblLastName, lblFirstName, lblMiddleName,lblSuffix, lblAge, lblStatus, lblBDay, lblYear, lblSex;
    private JTextField tfBlank = new JTextField();
    private JTextField tfLastName = new JTextField("");
    private JTextField tfFirstName = new JTextField("");
    private JTextField tfMiddleName = new JTextField("");
    private JTextField tfSuffix = new JTextField("");
    private JTextField tfAge = new JTextField("");
    private JTextField tfYear = new JTextField("");
    private JButton btnNextPage, btnReset;
    
    
    
    BankManagementCredentials(){
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
        lblInfo = new JLabel("User Personal Information:");
        lblInfo.setBounds(30,150,300,50);
        Font font = new Font("Aptos", Font.BOLD, 18);
        lblInfo.setFont(font);
        
        //Full Name - FIRST ROW
        tfBlank.setBounds(0,0,0,0);
        
        lblLastName = new JLabel ("Last Name");
        lblLastName.setBounds (63, 235, 100, 30);
        tfLastName.setBounds(40, 260, 105, 30);
        tfLastName.setHorizontalAlignment(JTextField.CENTER);
        
        lblFirstName = new JLabel ("First Name");
        lblFirstName.setBounds (173, 235, 100, 30);
        tfFirstName.setBounds(150, 260, 105, 30);
        tfFirstName.setHorizontalAlignment(JTextField.CENTER);
        
        lblMiddleName = new JLabel ("Middle Name");
        lblMiddleName.setBounds (275, 235, 100, 30);
        tfMiddleName.setBounds(260, 260, 105, 30);
        tfMiddleName.setHorizontalAlignment(JTextField.CENTER);
        
        lblSuffix = new JLabel ("Suffix");
        lblSuffix.setBounds (378, 235, 100, 30);
        tfSuffix.setBounds(370, 260, 50, 30);
        tfSuffix.setHorizontalAlignment(JTextField.CENTER);
        
        //Age - SECOND ROW
        lblAge = new JLabel ("Age");
        lblAge.setBounds (90, 305, 50, 30);
        tfAge.setBounds(40, 330, 120, 30);
        tfAge.setHorizontalAlignment(JTextField.CENTER);

        //Birthday
        lblBDay = new JLabel ("Date of Birth");
        lblBDay.setBounds (275, 305, 120, 30);        
        cbMonth.setBounds(180, 330, 110, 30);
        cbDay.setBounds(300, 330, 60, 30);
        
        lblYear = new JLabel ("YYYY");
        lblYear.setBounds (378, 360, 50, 30);
        lblYear.setFont(new Font("Arial", Font.PLAIN, 11));
        tfYear.setBounds (370, 330, 50, 30);
        tfYear.setHorizontalAlignment(JTextField.CENTER);
        
        //Sex - THIRD ROW
        lblSex = new JLabel ("Sex ");
        lblSex.setBounds (118, 385, 120, 30);
        cbSex.setBounds(40, 410, 180, 30);
        
        //Civil Status
        lblStatus = new JLabel ("Civil Status");
        lblStatus.setBounds (300, 385, 120, 30);
        cbStatus.setBounds(240, 410, 180, 30);

        //buttons
        btnNextPage = new JButton ("Next");
        btnNextPage.setBounds(240,570, 100, 30);
        btnNextPage.setFont(new Font("Arial", Font.PLAIN, 15));
        
        btnReset = new JButton ("Reset");
        btnReset.setBounds (110, 570, 100, 30);
        btnReset.setFont(new Font("Arial", Font.PLAIN, 15));
        
        f.add(header);
        f.add(footer);
        f.add(tfBlank);
        
        header.add(lblLogo);
        header.add(lblBankName, BorderLayout.NORTH);
        
        f.add(lblInfo);
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
