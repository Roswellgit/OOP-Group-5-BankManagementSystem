package bankmanagementsystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
    
public class AdminRegister extends JFrame implements ActionListener {
    
    private JFrame f = new JFrame ("BANK OF BSIT");
    private JPanel header, middle;
    private ImageIcon BgColor, Logo;
    private JLabel lblLogo, lblBankName, lblWelcome, lblLogin, lblUsername, lblPassword, lblLoginResults;
    private JTextField txtfldUsername;
    private JPasswordField pwfPassword;
    private JButton btnCreate, btnReset, btnBack;
    private JCheckBox chShow;
    
    AdminRegister(){
        
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
        
        //Welcome & pls login txt lbls
        lblWelcome = new JLabel("Create a new account.", SwingConstants.CENTER);
        lblWelcome.setBounds(0,130,610,30);
        lblWelcome.setFont(new Font("Arial", Font.BOLD, 18));
        lblWelcome.setVisible(true);
        f.add(lblWelcome);
        
        lblLogin = new JLabel("Please enter a username and password.");
        lblLogin.setBounds(50,160,400,30);
        lblLogin.setFont(new Font("Arial", Font.PLAIN, 15));
        lblLogin.setVisible(true);
        f.add(lblLogin);
                  
        //username & password text labels
        lblUsername = new JLabel("Username:");
        lblUsername.setBounds(145, 220, 120, 30);
        lblUsername.setFont(new Font("Arial", Font.BOLD, 15));
        f.add(lblUsername);
        
        lblPassword = new JLabel("Password:");
        lblPassword.setBounds(145, 270, 120, 30);
        lblPassword.setFont(new Font("Arial", Font.BOLD, 15));
        f.add(lblPassword);
        
        //usn & pw txtfields
        txtfldUsername = new JTextField();
        txtfldUsername.setBounds(235, 220, 190,30);
        txtfldUsername.setFont(new Font("Arial", Font.PLAIN, 14));
        f.add(txtfldUsername);
        
        pwfPassword = new JPasswordField();
        pwfPassword.setBounds(235, 270, 190,30);
        pwfPassword.setFont(new Font("Arial", Font.PLAIN, 14));
        f.add(pwfPassword);
        
        
        
        //enter & clear buttons
        btnCreate = new JButton("Create");
        btnCreate.setBounds(150, 370, 80, 20);
        btnCreate.setFont(new Font("Arial", Font.PLAIN, 13));
        btnCreate.addActionListener(this);
        f.add(btnCreate);
   
        btnReset = new JButton("Clear");
        btnReset.setBounds(250, 370, 80, 20);
        btnReset.setFont(new Font("Arial", Font.PLAIN, 13));
        btnReset.addActionListener(this);
        f.add(btnReset);
        
        btnBack = new JButton("Back");
        btnBack.setBounds(350, 370, 80, 20);
        btnBack.setFont(new Font("Arial", Font.PLAIN, 13));
        btnBack.addActionListener(this);
        f.add(btnBack);
        
        chShow = new JCheckBox();
        chShow.setBounds(430,275,30,20);
        chShow.setBackground(new Color(220, 190, 200));
        chShow.addActionListener(this);
        f.add(chShow);

        //if login failed or is successful
        lblLoginResults = new JLabel("");
        lblLoginResults.setBounds(205, 320, 200, 30);
        lblLoginResults.setFont(new Font("Arial", Font.PLAIN, 12));
        lblLoginResults.setForeground(new java.awt.Color(250,20,50));
        f.add(lblLoginResults);

        //adding components (wag ilipat tong mga to)
        f.setVisible(true);
        f.setResizable(false);
        f.add(header);
        f.add(middle);
        header.add(lblLogo);
        header.add(lblBankName);
    
    }
    
    @Override
    public void actionPerformed(ActionEvent Login) 
    {
        if(Login.getSource() == btnCreate)
        {
            if(Login.getSource()==btnCreate)
            {
                
                try
                {
                    String query = "INSERT INTO `admin`(`username`,`password`) VALUES (?,?)";
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_bank","root","root");
                    PreparedStatement pr = con.prepareStatement(query);
          
                    pr.setString(1,txtfldUsername.getText());
                    pr.setString(2,pwfPassword.getText());
                    pr.executeUpdate();
              
                    JOptionPane.showMessageDialog(null,"Registered Successfully.");
              
                    f.dispose();
                    UserLogin log = new UserLogin();
                }
            
                catch(Exception ex)
                {
                    System.out.println(ex);
                }
            }
        
            else
            {
                lblLoginResults.setText("Account Creation Failed. Please Try Again.");
            }
           
           
        }
        
        else if(Login.getSource() == btnReset)
        {
            txtfldUsername.setText("");
            pwfPassword.setText("");
            lblLoginResults.setText("");     
           
        }      
        
        else if(Login.getSource()==chShow)
        {
            if(chShow.isSelected())
            {
                pwfPassword.setEchoChar((char)0);
            }
            else
            {
                pwfPassword.setEchoChar('•');
            }
        }
    }
}
