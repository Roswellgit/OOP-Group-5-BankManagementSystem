package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BankAccountCreation implements ActionListener {
    
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
    private ImageIcon BgColor, Logo;
    private JLabel lblLogo, lblBankName, lblInfo, lblUserName, lblAccNum;
    private JTextField tfBlank = new JTextField();
    private JTextField tfUserName = new JTextField("");
    private JTextField tfAccNum = new JTextField("");
    private JButton btnNextPage, btnReset, btnReturn;
    
    
    
    BankAccountCreation(){
        f.setSize(600,510);
        f.setLayout(null);
        f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
        f.getContentPane().setBackground(new java.awt.Color(100,50,78));
        f.setLocationRelativeTo(null);
        
        // logo
        BgColor = new ImageIcon("logo.png");
        f.setIconImage(BgColor.getImage());
        f.getContentPane().setBackground(new Color(100,50,78));
        f.setLayout(new BorderLayout());
        
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
        lblInfo = new JLabel("Account Information:");
        lblInfo.setBounds(30,100,300,50);
        Font font = new Font("Aptos", Font.BOLD, 18);
        lblInfo.setFont(font);
        
        //Username - FIRST ROW
        tfBlank.setBounds(0,0,0,0);
        
        lblUserName = new JLabel ("Username");
        lblUserName.setBounds (66, 170, 100, 30);
        lblUserName.setFont(new Font("Arial", Font.PLAIN,10));
        tfUserName.setBounds(40, 195, 300, 30);
        tfUserName.setHorizontalAlignment(JTextField.CENTER);
        
        
        //Account Number - SECOND ROW
        lblAccNum = new JLabel ("Account Number");
        lblAccNum.setBounds (66, 235, 150, 30);
        lblAccNum.setFont(new Font("Arial", Font.PLAIN,10));
        tfAccNum.setBounds(40, 260, 150, 30);
        tfAccNum.setFocusable(false);
        tfAccNum.setEditable(false);


        //BUTTONS
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
        f.add(lblUserName);
        f.add(lblAccNum);
        f.add(tfUserName);
        f.add(tfAccNum);
        f.add(btnNextPage);
        f.add(btnReset);
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
            tfUserName.setText("");
        }
        else if(openclass.getSource()==btnNextPage)
        {
            if(openclass.getSource()==btnNextPage)
            {
                int rng = (int)(Math.random()*999999)+5;
            
            try
            {
                String query = "INSERT INTO `transactions`(`acc_name`,`acc_number`,`acc_bal`) VALUES (?,?,?)";
          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_bank","root","root");
          PreparedStatement pr = con.prepareStatement(query);
          
              pr.setString(1,tfUserName.getText());
              pr.setInt(2,rng);
              pr.setString(3,"0")
;
              
              pr.executeUpdate();
              
              JOptionPane.showMessageDialog(null,"Registered Successfully");
              JOptionPane.showMessageDialog(null,"Redirecting to Admin Main Menu...");
            }
            catch(Exception ex)
            {
                System.out.println(ex);
            }
       
      
      
      }
    }
            
            f.dispose();
            BankMainMenu load = new BankMainMenu();

        }
    }
