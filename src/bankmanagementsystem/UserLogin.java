package bankmanagementsystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
    
public class UserLogin implements ActionListener {
    
    private JFrame f = new JFrame("BOB - BANK OF BSIT");
    private JLabel logoLabel, lblTitle, lblUsername, lblPassword, lblLoginResults;
    private JTextField txtfldUsername = new JTextField();
    private JPasswordField psswrdfldPassword = new JPasswordField();
    private JButton btnLogin, btnReset;
    private ImageIcon logo;
    private JPanel design, design2;
    
    UserLogin(){
    
    //Jframe dimensions & details
    f.setSize(470, 750);
    f.setLayout(null);
    f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
    f.getContentPane().setBackground(Color.LIGHT_GRAY);
    
    //bank logo
    logo = new ImageIcon("‪E:/Users/malen/Pictures/Lance/jenshin/fave/20240507175307.png");
    logoLabel = new JLabel(logo);
    logoLabel.setBounds(10,10,100,100);
    
    //color panels design
    design = new JPanel();
    design.setBounds(0,0,470,120);
    design.setBackground(Color.GRAY);
    
    design2 = new JPanel();
    design2.setBounds(0,640,470,80);
    design2.setBackground(Color.GRAY);
    
    //bank title
    lblTitle = new JLabel("BANK OF BSIT");
    lblTitle.setFont(new Font("Bookman Old Style", Font.BOLD, 37));
    lblTitle.setForeground(Color.BLACK);
    lblTitle.setBounds(100,30,100,250);

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
    btnLogin.setBounds(115, 400, 100, 30);
    btnLogin.setFont(new Font("Arial", Font.PLAIN, 15));
    btnLogin.addActionListener(this);
   
    btnReset = new JButton("Clear");
    btnReset.setBounds(225, 400, 100, 30);
    btnReset.setFont(new Font("Arial", Font.PLAIN, 15));
    btnReset.addActionListener(this);
    
    //if login failed or is successful
    lblLoginResults = new JLabel("");
    lblLoginResults.setBounds(20, 200, 480, 30);
    lblLoginResults.setFont(new Font("Arial", Font.PLAIN, 15));
    
    design.add(lblTitle);
    f.add(logoLabel);
    f.add(design);
    f.add(design2);
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
        }else if(Login.getSource() == btnReset){
           txtfldUsername.setText("");
           psswrdfldPassword.setText("");
           lblLoginResults.setText("");     
        }      
    }
}
