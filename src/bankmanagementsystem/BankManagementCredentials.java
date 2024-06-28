package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BankManagementCredentials implements ActionListener {
    
    //combobox
    private String[] MonthOptions = {"Month", "January", "February", "March", "April",
    "May", "June", "July", "August", "September", "October", "November", "December"};
    private String[] DayOptions = {"Day", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15",
    "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
    private String[] SexOptions = {" ", "Male", "Female"};
    private String[] StatusOptions = {" ", "Single", "Married", "Widowed", "Legally Separated"};

    //frame
    private JFrame f = new JFrame ("ACCOUNT CREATION");
    private JPanel header, middle, OMenu, IMenu;
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
    private JButton btnNextPage, btnReset, btnReturn;
    
    
    
    BankManagementCredentials(){
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
        
        OMenu = new JPanel();
        OMenu.setBackground(new Color(100,50,78));
        OMenu.setBounds(450,160,100,100);
        
        IMenu = new JPanel();
        IMenu.setBackground(new Color(220, 190, 200));
        IMenu.setBounds(454,164,92,92);
        
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
        
        // Set layout of the frame to null layout
        f.getContentPane().setLayout(null);

        // Add the label to the frame
        f.getContentPane().add(lblLogo);
        
        // User Personal Information
        lblInfo = new JLabel("User Personal Information:");
        lblInfo.setBounds(30,100,300,50);
        Font font = new Font("Aptos", Font.BOLD, 18);
        lblInfo.setFont(font);
        
        //Full Name - FIRST ROW
        tfBlank.setBounds(0,0,0,0);
        
        lblLastName = new JLabel ("Last Name");
        lblLastName.setBounds (66, 135, 100, 30);
        lblLastName.setFont(new Font("Arial", Font.PLAIN,10));
        tfLastName.setBounds(40, 160, 105, 30);
        tfLastName.setHorizontalAlignment(JTextField.CENTER);
        
        lblFirstName = new JLabel ("First Name");
        lblFirstName.setBounds (178, 135, 100, 30);
        lblFirstName.setFont(new Font("Arial", Font.PLAIN,10));
        tfFirstName.setBounds(152, 160, 105, 30);
        tfFirstName.setHorizontalAlignment(JTextField.CENTER);
        
        lblMiddleName = new JLabel ("Middle Name");
        lblMiddleName.setBounds (284, 135, 100, 30);
        lblMiddleName.setFont(new Font("Arial", Font.PLAIN,10));
        tfMiddleName.setBounds(264, 160, 105, 30);
        tfMiddleName.setHorizontalAlignment(JTextField.CENTER);
        
        lblSuffix = new JLabel ("Suffix");
        lblSuffix.setBounds (386, 135, 100, 30);
        lblSuffix.setFont(new Font("Arial", Font.PLAIN,10));
        tfSuffix.setBounds(376, 160, 50, 30);
        tfSuffix.setHorizontalAlignment(JTextField.CENTER);
        
        //Age - SECOND ROW
        lblAge = new JLabel ("Age");
        lblAge.setBounds (92, 235, 50, 30);
        lblAge.setFont(new Font("Arial", Font.PLAIN,10));
        tfAge.setBounds(40, 260, 125, 30);
        tfAge.setHorizontalAlignment(JTextField.CENTER);

        //Birthday
        lblBDay = new JLabel ("Date of Birth");
        lblBDay.setBounds (275, 235, 120, 30); 
        lblBDay.setFont(new Font("Arial", Font.PLAIN,10));
        cbMonth.setBounds(180, 260, 110, 30);
        cbMonth.setFont(new Font("Arial", Font.PLAIN,10));
        cbDay.setBounds(300, 260, 60, 30);
        cbDay.setFont(new Font("Arial", Font.PLAIN,10));
        
        lblYear = new JLabel ("YYYY");
        lblYear.setBounds (385, 283, 50, 30);
        lblYear.setFont(new Font("Arial", Font.PLAIN, 10));
        tfYear.setBounds (370, 260, 57, 30);
        tfYear.setHorizontalAlignment(JTextField.CENTER);
        
        //Sex - THIRD ROW
        lblSex = new JLabel ("Sex ");
        lblSex.setBounds (123, 335, 120, 30);
        lblSex.setFont(new Font("Arial", Font.PLAIN,10));
        cbSex.setBounds(40, 360, 189, 30);
        
        //Civil Status
        lblStatus = new JLabel ("Civil Status");
        lblStatus.setBounds (305, 335, 120, 30);
        lblStatus.setFont(new Font("Arial", Font.PLAIN,10));
        cbStatus.setBounds(240, 360, 189, 30);

        //buttons
        btnNextPage = new JButton ("Create");
        btnNextPage.setBounds(454,164, 92, 30);
        btnNextPage.setFont(new Font("Arial", Font.BOLD, 15));
        btnNextPage.setBackground(new Color(100,50,78));
        btnNextPage.setForeground(Color.WHITE);
        btnNextPage.addActionListener(this);
        
        btnReset = new JButton ("Reset");
        btnReset.setBounds (454, 195, 92, 30);
        btnReset.setFont(new Font("Arial", Font.BOLD, 15));
        btnReset.setBackground(new Color(100,50,78));
        btnReset.setForeground(Color.WHITE);
        btnReset.addActionListener(this);
        
        btnReturn = new JButton ("Return");
        btnReturn.setBounds (454, 226, 92, 30);
        btnReturn.setFont(new Font("Arial", Font.BOLD, 15));
        btnReturn.setBackground(new Color(100,50,78));
        btnReturn.setForeground(Color.WHITE);
        btnReturn.setFocusable(false);
        btnReturn.addActionListener(this);
        
        
        f.add(header);
        f.add(middle);
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
        f.add(btnReturn);
        
        f.add(IMenu);
        f.add(OMenu);
        f.add(middle);
        f.setVisible(true);
        f.setResizable(false);
    }
    
    @Override 
    public void actionPerformed(ActionEvent openclass) {
        
        if(openclass.getSource()==btnReturn)
        {
            f.dispose();
            BankMainMenu bankmainmenu = new BankMainMenu();
        }
        else if(openclass.getSource()==btnReset)
        {
            tfLastName.setText("");
            tfFirstName.setText("");
            tfMiddleName.setText("");
            tfSuffix.setText("");
            tfAge.setText("");
            tfYear.setText("");
            cbMonth.setSelectedIndex(0);
            cbDay.setSelectedIndex(0);
            cbSex.setSelectedIndex(0);
            cbStatus.setSelectedIndex(0);
        }
        else if(openclass.getSource()==btnNextPage)
        {
            
            CreationPopUp load = new CreationPopUp();
            f.dispose();
        }
    }
}