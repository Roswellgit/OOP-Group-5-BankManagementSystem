package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.JOptionPane;

public class ChangePinUI implements ActionListener {
    private JFrame Acc;
    private ImageIcon BgColor, iconImage;
    private JPanel panel1, depanel;
    private JLabel ChangePinlbl, EntPasslbl, EntPassNewlbl, EntPassAgainlbl, Passlbl, Passlbl1;
    private JTextField tfBlank, EntPasstf, EntPassNewtf, EntPassAgaintf;
    private JButton SaveBtn, ExitBtn;
    private String strOldPin, strNewPin, strConfirmNewPin;
    
    private Connection conn;
    
    public ChangePinUI(){
        
        //frame
        Acc = new JFrame();
        Acc.setTitle("BANK MANAGEMENT SYSTEM");
        Acc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Acc.setResizable(false);
        Acc.setSize(500, 360);
        Acc.setLocationRelativeTo(null);
        
        // logo
        BgColor = new ImageIcon("logo.png");
        Acc.setIconImage(BgColor.getImage());
        
        Acc.getContentPane().setBackground(new Color(100,50,78));
        Acc.setLayout(new BorderLayout());
        
        //panel at the bg of the icons
        panel1 = new JPanel();
        panel1.setBackground(new Color(100, 50, 78));
        panel1.setLayout(null); 
        Acc.add(panel1, BorderLayout.CENTER);
        
        depanel = new JPanel();
        depanel.setLayout(null);
        depanel.setBackground(new Color(220, 190, 200));
        depanel.setBounds(20, 20, 445, 280);
        panel1.add(depanel);
        
        ChangePinlbl = new JLabel("Change PIN ");
        ChangePinlbl.setBounds(10,0,150,30);
        Font font = new Font("Aptos", Font.BOLD, 15);
        ChangePinlbl.setFont(font);
        
        // Change pin info 
        tfBlank = new JTextField();
        tfBlank.setBounds(0,0,0,0);
        
        EntPasslbl = new JLabel ("Enter Your Old Pin:");
        EntPasslbl.setBounds (40, 50, 200, 40);
        EntPasstf = new JTextField();
        EntPasstf.setBounds(210, 60, 200, 20);
        EntPasstf.setHorizontalAlignment(JTextField.CENTER);
        
        EntPassNewlbl = new JLabel ("Enter Your New Pin:");
        EntPassNewlbl.setBounds (40, 80, 200, 40);
        EntPassNewtf = new JTextField();
        EntPassNewtf.setBounds(210, 90, 200, 20);
        EntPassNewtf.setHorizontalAlignment(JTextField.CENTER);
        
        EntPassAgainlbl = new JLabel ("Enter Your New Pin Again:");
        EntPassAgainlbl.setBounds (40, 110, 200, 40);
        EntPassAgaintf = new JTextField();
        EntPassAgaintf.setBounds(210, 120, 200, 20);
        EntPassAgaintf.setHorizontalAlignment(JTextField.CENTER);
        
        Passlbl = new JLabel ("Password must contain:");
        Passlbl.setBounds (40, 150, 200, 40);
        Font font1 = new Font("Aptos", Font.BOLD, 15);
        Passlbl.setFont(font);
        
        Passlbl1 = new JLabel (" **4-digit PIN ");
        Passlbl1.setBounds (40, 170, 200, 40);
        
        // Save & ExitButton SaveBtn
        SaveBtn = new JButton("SAVE");
        SaveBtn.setBounds(150, 230, 70, 30);
        SaveBtn.setFont(new Font("Aptos", Font.BOLD, 10));
        SaveBtn.addActionListener(this);
        
        ExitBtn = new JButton("EXIT");
        ExitBtn.setBounds(230, 230, 70, 30);
        ExitBtn.setFont(new Font("Aptos", Font.BOLD, 10));
        ExitBtn.addActionListener(this);
        
        
   
        
        depanel.add(ChangePinlbl);
        depanel.add(tfBlank);
        depanel.add(EntPasslbl);
        depanel.add(EntPasstf);
        depanel.add(EntPassNewlbl);
        depanel.add(EntPassNewtf);
        depanel.add(EntPassAgainlbl);
        depanel.add(EntPassAgaintf);
        depanel.add(Passlbl);
        depanel.add(Passlbl1);
        depanel.add(SaveBtn);
        depanel.add(ExitBtn);
        Acc.setVisible(true);
        
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_bank", "root", "root");
        } catch (Exception e) {
            System.out.print(e);
        }
}

    @Override
    public void actionPerformed(ActionEvent close) {
        if(close.getSource() == ExitBtn) {
            Acc.dispose();
            AccInterfaceUI accinterfaceui = new AccInterfaceUI();
        }
        else if (close.getSource() == SaveBtn) {
            ChangePin();
        }
    }
    
    public void ChangePin(){
        
        strOldPin = EntPasstf.getText();
        strNewPin = EntPassNewtf.getText();
        strConfirmNewPin = EntPassAgaintf.getText();
        
        if (strOldPin.isEmpty() || strNewPin.isEmpty() || strConfirmNewPin.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill in every required field.", "WARNING", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (!strNewPin.equals(strConfirmNewPin)) {
            JOptionPane.showMessageDialog(null, "Your new pin and re-entered new pin do not match. Please try again.", "WARNING", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (!strNewPin.matches("\\d{4}")) {
        JOptionPane.showMessageDialog(null, "New pin must be a 4-digit number.");
        return;
        }
        
        try{
            String pinUpdate = "UPDATE bank_table SET pin = ? WHERE pin = ?";
            PreparedStatement up = conn.prepareStatement(pinUpdate);
            up.setString(1,strNewPin);
            up.setString(2,strOldPin);
            up.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"Change Pin Successful","Success",JOptionPane.INFORMATION_MESSAGE);
            
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
