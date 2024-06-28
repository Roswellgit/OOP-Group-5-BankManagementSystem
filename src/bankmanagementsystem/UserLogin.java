package bankmanagementsystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
    
public class UserLogin implements ActionListener {
    
    private JFrame f = new JFrame("BOB - BANK OF BSIT");
    private JLabel  lblTitle, lblWelcome, lblLogin, lblUsername, lblPassword, lblLoginResults, lbLogo;
    private JTextField txtfldUsername = new JTextField();
    private JPasswordField psswrdfldPassword = new JPasswordField();
    private JButton btnLogin, btnReset;
    private ImageIcon logo;
    private JPanel header, footer;
    
    UserLogin(){
    
    //Jframe dimensions & details
    f.setSize(480, 750);
    f.setLayout(null);
    f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
    f.getContentPane().setBackground(new java.awt.Color(220, 190, 200));
    f.setLocationRelativeTo(null);
    
    //bank logo
    logo = new ImageIcon("BlackLogo.png");
    Image ResizedLogo = logo.getImage().getScaledInstance( 90, 90, Image.SCALE_SMOOTH);
    ImageIcon FinalLogo = new ImageIcon(ResizedLogo);   
    lbLogo = new JLabel(FinalLogo);
    
    //color panels design
    header = new JPanel();
    header.setBackground(new java.awt.Color(100,50,78));
    header.setBounds(0, 0, 480, 110);
        
    footer = new JPanel();
    footer.setBackground(new java.awt.Color(100,50,78));
    footer.setBounds(0, 670, 480, 80);
    
    //bank title
    lblTitle = new JLabel("BANK OF BSIT");
    lblTitle.setForeground(Color.WHITE);
    lblTitle.setFont(new Font("Courier New", Font.BOLD, 40));
    lblTitle.setHorizontalAlignment(JLabel.LEFT);
    
    //Welcome & pls login txt lbls
    lblWelcome = new JLabel("Welcome Back Admin!");
    lblWelcome.setBounds(40, 160, 220, 30);
    lblWelcome.setFont(new Font("Arial", Font.BOLD, 20));
    
    lblLogin = new JLabel("Please log in to continue.");
    lblLogin.setBounds(40, 200, 190, 30);
    lblLogin.setFont(new Font("Arial", Font.PLAIN, 15));
    
    //username & password text labels
    lblUsername = new JLabel("Username:");
    lblUsername.setBounds(80, 300, 120, 30);
    lblUsername.setFont(new Font("Arial", Font.BOLD, 15));
    
    lblPassword = new JLabel("Password:");
    lblPassword.setBounds(80, 350,120, 30);
    lblPassword.setFont(new Font("Arial", Font.BOLD, 15));
    
    //usn & pw boxes na pagttype-an
    txtfldUsername.setBounds(170, 300, 190,30);
    txtfldUsername.setFont(new Font("Arial", Font.PLAIN, 15));
    
    psswrdfldPassword.setBounds(170, 350, 190,30);
    psswrdfldPassword.setFont(new Font("Arial", Font.PLAIN, 15));
    
    //enter & clear buttons
    btnLogin = new JButton("Enter");
    btnLogin.setBounds(115, 440, 100, 30);
    btnLogin.setFont(new Font("Arial", Font.PLAIN, 15));
    btnLogin.addActionListener(this);
   
    btnReset = new JButton("Clear");
    btnReset.setBounds(225, 440, 100, 30);
    btnReset.setFont(new Font("Arial", Font.PLAIN, 15));
    btnReset.addActionListener(this);
    
    
    //if login failed or is successful
    lblLoginResults = new JLabel("");
    lblLoginResults.setBounds(40, 530, 480, 30);
    lblLoginResults.setFont(new Font("Arial", Font.PLAIN, 15));
    lblLoginResults.setForeground(new java.awt.Color(250,20,50));
    
    header.add(lblTitle, BorderLayout.NORTH);
    header.add(lbLogo);
    
    f.add(header);
    f.add(footer);
    f.add(lblWelcome);
    f.add(lblLogin);
    f.add(lblUsername);
    f.add(lblPassword);
    f.add(txtfldUsername);
    f.add(psswrdfldPassword);
    f.add(btnLogin);
    f.add(btnReset);
    f.add(lblLoginResults);
    f.setVisible(true);
    f.setResizable(false);
        

    }
    
    @Override
    public void actionPerformed(ActionEvent Login){
        if(Login.getSource() == btnLogin){
           String username = txtfldUsername.getText();
           String password = psswrdfldPassword.getText();
           lblLoginResults.setText("Login Successful!");
           
           f.dispose();
           BankMainMenu bankmainmenu = new BankMainMenu();
           
        }else if(Login.getSource() == btnReset){
           txtfldUsername.setText("");
           psswrdfldPassword.setText("");
           lblLoginResults.setText("");     
           
           lblLoginResults.setText("Login Failed. Please try again.");
        }      
    }
    
}
