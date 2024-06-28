package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WithdrawUI extends JFrame implements ActionListener {

    private JFrame Acc;
    private ImageIcon BgColor, iconImage;
    private JPanel panel1, depanel;
    private JLabel Withdrawlbl, Datelbl, AccNamelbl, AccNumlbl, Accbalancelbl, balanceImg, Winputlbl;
    private JTextField tfBlank, Datetf, AccNametf, AccNumtf, Accbalancetf, Winputtf;
    private JButton WdrawBtn, ExitBtn;

    public WithdrawUI() {
        //frame
        Acc = new JFrame();
        Acc.setTitle("BANK MANAGEMENT SYSTEM");
        Acc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Acc.setResizable(false);
        Acc.setSize(600, 360);
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
        depanel.setBounds(20, 20, 545, 280);
        panel1.add(depanel);
        

        Withdrawlbl = new JLabel("WITHDRAW ");
        Withdrawlbl.setBounds(10,0,100,30);
        Font font = new Font("Aptos", Font.BOLD, 15);
        Withdrawlbl.setFont(font);
        
        // withdraw info 
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
        
        //AccBalance
        Accbalancelbl = new JLabel ("Account Balance:");
        Accbalancelbl.setBounds(40, 140, 140, 40);
        Accbalancetf = new JTextField();
        Accbalancetf.setBounds(170, 150, 150, 20);
        Accbalancetf.setHorizontalAlignment(JTextField.CENTER);
        
        
        //image
        WdrawBtn = new JButton("WITHDRAW");
        WdrawBtn.setBounds(370, 50, 125, 30);
        balanceImg = new JLabel();
        balanceImg.setBounds(380, 90, 130, 100);
        ImageIcon wdrawImage = new ImageIcon("Wdraw.png");
        Image picsize = wdrawImage.getImage().getScaledInstance(110, 110, Image.SCALE_SMOOTH);
        ImageIcon drawpic = new ImageIcon(picsize);
        balanceImg.setIcon(drawpic);
        
        //Withdraw Input
        Winputlbl = new JLabel ("Please Enter Amount to Withdraw");
        Winputlbl.setBounds (40, 180, 250, 40);
        Winputlbl.setFont(new Font("Aptos", Font.BOLD, 15));
        Winputtf = new JTextField();
        Winputtf.setBounds(40, 220, 300, 30);
        Winputtf.setHorizontalAlignment(JTextField.CENTER);
        
        // ExitButton
        ExitBtn = new JButton("EXIT");
        ExitBtn.setBounds(470, 255, 70, 20);
        ExitBtn.setFont(new Font("Aptos", Font.BOLD, 10));
        ExitBtn.addActionListener(this);
        
        depanel.add(Withdrawlbl);
        depanel.add(Datelbl);
        depanel.add(Datetf);
        depanel.add(AccNamelbl);
        depanel.add(AccNumlbl);
        depanel.add(AccNametf);
        depanel.add(AccNumtf);
        depanel.add(Accbalancelbl);
        depanel.add(Accbalancetf);
        depanel.add(WdrawBtn);
        depanel.add(balanceImg);
        depanel.add(Winputlbl);
        depanel.add(Winputtf);
        depanel.add(ExitBtn);
        Acc.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent close) {
        if(close.getSource() == ExitBtn) {
            Acc.dispose();
        }
    }
}
