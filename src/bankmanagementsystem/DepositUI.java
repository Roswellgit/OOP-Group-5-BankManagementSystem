package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;

public class DepositUI extends JFrame {

    private JFrame Acc;
    private ImageIcon BgColor, iconImage;
    private JPanel panel1, panel2;
    private JLabel Depolbl, Datelbl, AccNamelbl, AccNumlbl, Accbalancelbl, balanceImg, depamntlbl;
    private JTextField tfBlank, Datetf, AccNametf, AccNumtf, Accbalancetf, depamnttf;
    private JButton DepoBtn, ExitBtn;

    public DepositUI() {
        //frame
        Acc = new JFrame();
        Acc.setTitle("BANK MANAGEMENT SYSTEM");
        Acc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Acc.setResizable(false);
        Acc.setSize(600, 360);
        
        // logo
        BgColor = new ImageIcon("logo.png");
        Acc.setIconImage(BgColor.getImage());
        Acc.getContentPane().setBackground(new Color(100,50,78));
        Acc.setLayout(new BorderLayout());
        
        //panelinc
        panel1 = new JPanel();
        panel1.setBackground(new Color(100, 50, 78));
        panel1.setLayout(null); 
        Acc.add(panel1, BorderLayout.CENTER);
        
        panel2 = new JPanel();
        panel2.setLayout(null);
        panel2.setBackground(new Color(220, 190, 200));
        panel2.setBounds(20, 20, 545, 280);
        panel1.add(panel2);
        

        Depolbl = new JLabel("DEPOSIT ");
        Depolbl.setBounds(10,0,100,30);
        Font font = new Font("Aptos", Font.BOLD, 15);
        Depolbl.setFont(font);
        
        // withdraw
        tfBlank = new JTextField();
        tfBlank.setBounds(0,0,0,0);
        
        Datelbl = new JLabel ("Date:");
        Datelbl.setBounds (40, 50, 100, 40);
        Datetf = new JTextField();
        Datetf.setBounds(170, 60, 150, 20);
        Datetf.setHorizontalAlignment(JTextField.CENTER);
        
        AccNamelbl = new JLabel ("Account Name:");
        AccNamelbl.setBounds (40, 80, 100, 40);
        AccNametf = new JTextField();
        AccNametf.setBounds(170, 90, 150, 20);
        AccNametf.setHorizontalAlignment(JTextField.CENTER);
        
        AccNumlbl = new JLabel ("Account Number:");
        AccNumlbl.setBounds(40, 110, 140, 40);
        AccNumtf = new JTextField();
        AccNumtf.setBounds(170, 120, 150, 20);
        AccNumtf.setHorizontalAlignment(JTextField.CENTER);
        
        
        Accbalancelbl = new JLabel ("Account Balance:");
        Accbalancelbl.setBounds(40, 140, 140, 40);
        Accbalancetf = new JTextField();
        Accbalancetf.setBounds(170, 150, 150, 20);
        Accbalancetf.setHorizontalAlignment(JTextField.CENTER);
        
        
        
        DepoBtn = new JButton("DEPOSIT");
        DepoBtn.setBounds(370, 50, 125, 30);
        balanceImg = new JLabel();
        balanceImg.setBounds(380, 90, 130, 100);
        ImageIcon wdrawImage = new ImageIcon("dep.png");
        Image picsize = wdrawImage.getImage().getScaledInstance(110, 110, Image.SCALE_SMOOTH);
        ImageIcon drawpic = new ImageIcon(picsize);
        balanceImg.setIcon(drawpic);
        
        
        depamntlbl = new JLabel ("Please Enter Amount to Deposit");
        depamntlbl.setBounds (40, 180, 250, 40);
        depamntlbl.setFont(new Font("Aptos", Font.BOLD, 15));
        depamnttf = new JTextField();
        depamnttf.setBounds(40, 220, 300, 30);
        depamnttf.setHorizontalAlignment(JTextField.CENTER);
        
        // ExitButton
        ExitBtn = new JButton("EXIT");
        ExitBtn.setBounds(470, 255, 70, 20);
        ExitBtn.setFont(new Font("Aptos", Font.BOLD, 10));
        
        
        panel2.add(Depolbl);
        panel2.add(Datelbl);
        panel2.add(Datetf);
        panel2.add(AccNamelbl);
        panel2.add(AccNumlbl);
        panel2.add(AccNametf);
        panel2.add(AccNumtf);
        panel2.add(Accbalancelbl);
        panel2.add(Accbalancetf);
        panel2.add(DepoBtn);
        panel2.add(balanceImg);
        panel2.add(depamntlbl);
        panel2.add(depamnttf);
        panel2.add(ExitBtn);
        Acc.setVisible(true);

    }

}
