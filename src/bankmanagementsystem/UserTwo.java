
package bankmanagementsystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class UserTwo implements ActionListener {
    
    private JFrame f;
    private JPanel panel1, depanel;
    private JLabel label1, lblEmail, lblPassword, lblFullName, lblStatus, lblAge, lblSex, lblBirthday, lblLogo, lblBankName;
    private ImageIcon BgColor, Logo;
    private JTextField tfEmail, tfPassword, tfFullName, tfStatus, tfAge, tfSex, tfBirthday;
    private JButton btnClose;
    
    UserTwo(){
        //frame
        f = new JFrame();
        f.setTitle("Beatrice");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(false);
        f.setSize(600, 510);
        f.setLocationRelativeTo(null);
        
        // logo
        BgColor = new ImageIcon("logo.png");
        f.setIconImage(BgColor.getImage());
        f.getContentPane().setBackground(new Color(100,50,78));
        f.setLayout(new BorderLayout());
        
        //label "bank of bsit"
        ImageIcon iconImage = new ImageIcon("logo1.png");
        Image sizeImage = iconImage.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(sizeImage);
        label1 = new JLabel("BOB - BANK OF BSIT");
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("Courier New", Font.BOLD, 35));
        label1.setHorizontalAlignment(JLabel.CENTER);
        label1.setIcon(image);
        f.add(label1, BorderLayout.NORTH);
        
        //panel at the bg of the icons
        panel1 = new JPanel();
        panel1.setBackground(new Color(100,50,78));
        panel1.setBounds(50, 50, 500, 400);
        f.add(panel1, BorderLayout.CENTER); 
        
        depanel = new JPanel();
        depanel.setLayout(null);  
        depanel.setBackground(new Color(220, 190, 200));
        depanel.setPreferredSize(new Dimension(550, 330));
        panel1.add(depanel, BorderLayout.CENTER);
        
        //fullname
        lblFullName = new JLabel("Full Name:");
        lblFullName.setBounds(80,20,100,30);
        lblFullName.setFont(new Font("Arial",Font.BOLD,15));
        depanel.add(lblFullName);
        
        tfFullName = new JTextField("Beatrice F. Doe");
        tfFullName.setBounds (180, 20, 300, 30);
        tfFullName.setFont(new Font("Arial", Font.PLAIN,15));
        tfFullName.setFocusable(false);
        tfFullName.setEditable(false);
        depanel.add(tfFullName);
        
        //email
        lblEmail = new JLabel("Email:");
        lblEmail.setBounds(40,160,100,30);
        lblEmail.setFont(new Font("Arial", Font.BOLD, 15));
        depanel.add(lblEmail);
        tfEmail = new JTextField("doe.beatrice@yahoo.com");
        lblEmail.setBounds(80,60,100,30);
        tfEmail.setBounds(180, 60, 300, 30);
        tfEmail.setFont(new Font("Arial",Font.PLAIN,15));
        tfEmail.setFocusable(false);
        tfEmail.setEditable(false);
        depanel.add(tfEmail);
        
        //pass
        lblPassword = new JLabel("Password:");
        lblPassword.setBounds(80, 100, 100, 30);
        lblPassword.setFont(new Font("Arial", Font.BOLD,15));
        depanel.add(lblPassword);
        tfPassword = new JTextField("lovePUPp13$");
        tfPassword.setBounds(180, 100, 300, 30);
        tfPassword.setFont(new Font("Arial", Font.PLAIN,15));
        tfPassword.setFocusable(false);
        tfPassword.setEditable(false);
        depanel.add(tfPassword);
        
        //age
        lblAge = new JLabel("Age:");
        lblAge.setBounds(80, 140, 100, 30);
        lblAge.setFont(new Font("Arial", Font.BOLD, 15));
        depanel.add(lblAge);
        tfAge = new JTextField("45");
        tfAge.setBounds(180, 140, 300, 30);
        tfAge.setFont(new Font("Arial", Font.PLAIN,15));
        tfAge.setFocusable(false);
        tfAge.setEditable(false);
        depanel.add(tfAge);
        //bday
        lblBirthday = new JLabel("Birth Date:");
        lblBirthday.setBounds(80,180,100,30);
        lblBirthday.setFont(new Font("Arial", Font.BOLD, 15));
        depanel.add(lblBirthday);
        tfBirthday = new JTextField("December 12, 1987");
        tfBirthday.setBounds(180,180,300,30);
        tfBirthday.setFont(new Font("Arial", Font.PLAIN,15));
        tfBirthday.setFocusable(false);
        tfBirthday.setEditable(false);
        depanel.add(tfBirthday);
        
        //seggs
        lblSex = new JLabel("Sex:");
        lblSex.setBounds(80, 220, 100, 30);
        lblSex.setFont(new Font("Arial", Font.BOLD, 15));
        depanel.add(lblSex);
        
        tfSex = new JTextField("Female");
        tfSex.setBounds(180, 220, 300, 30);
        tfSex.setFont(new Font("Arial", Font.PLAIN,15));
        tfSex.setFocusable(false);
        tfSex.setEditable(false);
        depanel.add(tfSex);
        
        //status
        lblStatus = new JLabel("Civil Status:");
        lblStatus.setBounds(80, 260, 100, 30);
        lblStatus.setFont(new Font("Arial", Font.BOLD, 15));
        depanel.add(lblStatus);
        tfStatus = new JTextField("Married");
        tfStatus.setBounds(180,260,300,30);
        tfStatus.setFont(new Font("Arial", Font.PLAIN,15));
        tfStatus.setFocusable(false);
        tfStatus.setEditable(false);
        depanel.add(tfStatus);
        
        //button
        btnClose = new JButton ("Close");
        btnClose.setBounds (200, 0, 100, 30);
        btnClose.setFont(new Font("Arial", Font.BOLD, 15));
        btnClose.setFocusable(false);
        btnClose.addActionListener(this);
        panel1.add(btnClose);
        
        f.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent Beatrice) {
        if(Beatrice.getSource()==btnClose)
            f.dispose();
    }
    
}
