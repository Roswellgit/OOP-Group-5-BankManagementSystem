
package bankmanagementsystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class UserTwo implements ActionListener {
    
    private JFrame f = new JFrame("Beatrice");
    private JPanel header, footer;
    private JLabel lblEmail, lblPassword, lblFullName, lblStatus, lblAge, lblSex, lblBirthday, lblLogo, lblBankName;
    private ImageIcon BgColor, Logo;
    private JTextField tfEmail, tfPassword, tfFullName, tfStatus, tfAge, tfSex, tfBirthday;
    private JButton btnClose;
    
    UserTwo(){
        
        //frame
        f.setSize(480,600);
        f.setLayout(null);
        f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
        f.getContentPane().setBackground(new java.awt.Color(220, 190, 200));
        f.setLocationRelativeTo(null);
        
        // logo
        BgColor = new ImageIcon("logo.png");
        f.setIconImage(BgColor.getImage());
        f.getContentPane().setBackground(new Color(100,50,78));
        f.setLayout(new BorderLayout());
        
        header = new JPanel();
        header.setBounds(0,0,480,110);
        header.setBackground(new java.awt.Color(100,50,78));
        
        footer = new JPanel();
        footer.setBounds(0,520,480,110);
        footer.setBackground(new java.awt.Color(100,50,78));
        
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
        
        //fullname
        lblFullName = new JLabel("Full Name:");
        lblFullName.setBounds(40,120,100,30);
        lblFullName.setFont(new Font("Arial",Font.BOLD,15));
        
        tfFullName = new JTextField("Beatrice F. Doe");
        tfFullName.setBounds (130, 120, 300, 30);
        tfFullName.setFont(new Font("Arial", Font.PLAIN,15));
        tfFullName.setFocusable(false);
        tfFullName.setEditable(false);
        
        //email
        lblEmail = new JLabel("Email:");
        lblEmail.setBounds(40,160,100,30);
        lblEmail.setFont(new Font("Arial", Font.BOLD, 15));
        
        tfEmail = new JTextField("doe.beatrice@yahoo.com");
        tfEmail.setBounds(130, 160, 300, 30);
        tfEmail.setFont(new Font("Arial",Font.PLAIN,15));
        tfEmail.setFocusable(false);
        tfEmail.setEditable(false);
        
        //pass
        lblPassword = new JLabel("Password:");
        lblPassword.setBounds(40, 200, 100, 30);
        lblPassword.setFont(new Font("Arial", Font.BOLD,15));
        
        tfPassword = new JTextField("lovePUPp13$");
        tfPassword.setBounds(130, 200, 300, 30);
        tfPassword.setFont(new Font("Arial", Font.PLAIN,15));
        tfPassword.setFocusable(false);
        tfPassword.setEditable(false);
        
        //age
        lblAge = new JLabel("Age:");
        lblAge.setBounds(40, 240, 100, 30);
        lblAge.setFont(new Font("Arial", Font.BOLD, 15));
        
        tfAge = new JTextField("45");
        tfAge.setBounds(130, 240, 300, 30);
        tfAge.setFont(new Font("Arial", Font.PLAIN,15));
        tfAge.setFocusable(false);
        tfAge.setEditable(false);
        
        //bday
        lblBirthday = new JLabel("Birth Date:");
        lblBirthday.setBounds(40,280,100,30);
        lblBirthday.setFont(new Font("Arial", Font.BOLD, 15));
        
        tfBirthday = new JTextField("December 12, 1987");
        tfBirthday.setBounds(130,280,300,30);
        tfBirthday.setFont(new Font("Arial", Font.PLAIN,15));
        tfBirthday.setFocusable(false);
        tfBirthday.setEditable(false);
        
        //seggs
        lblSex = new JLabel("Sex:");
        lblSex.setBounds(40, 320, 100, 30);
        lblSex.setFont(new Font("Arial", Font.BOLD, 15));
        
        tfSex = new JTextField("Female");
        tfSex.setBounds(130, 320, 300, 30);
        tfSex.setFont(new Font("Arial", Font.PLAIN,15));
        tfSex.setFocusable(false);
        tfSex.setEditable(false);
        
        //status
        lblStatus = new JLabel("Civil Status:");
        lblStatus.setBounds(40, 360, 100, 30);
        lblStatus.setFont(new Font("Arial", Font.BOLD, 15));
        
        tfStatus = new JTextField("Married");
        tfStatus.setBounds(130,360,300,30);
        tfStatus.setFont(new Font("Arial", Font.PLAIN,15));
        tfStatus.setFocusable(false);
        tfStatus.setEditable(false);
        
        //button
        btnClose = new JButton ("Close");
        btnClose.setBounds (180, 470, 100, 30);
        btnClose.setFont(new Font("Arial", Font.BOLD, 15));
        btnClose.setFocusable(false);
        btnClose.addActionListener(this);
        
        
        f.add(header);
        f.add(footer);
        
        f.add(lblFullName);
        f.add(lblEmail);
        f.add(lblPassword);
        f.add(lblAge);
        f.add(lblBirthday);
        f.add(lblSex);
        f.add(lblStatus);
        
        f.add(tfFullName);
        f.add(tfEmail);
        f.add(tfPassword);
        f.add(tfAge);
        f.add(tfBirthday);
        f.add(tfSex);
        f.add(tfStatus);
        
        f.add(btnClose);
        
        header.add(lblLogo);
        header.add(lblBankName, BorderLayout.NORTH);
        
        f.setVisible(true);
        f.setResizable(false);
        f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent Beatrice) {
        if(Beatrice.getSource()==btnClose)
            f.dispose();
    }
    
}
