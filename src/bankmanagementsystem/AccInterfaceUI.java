package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;


public class AccInterfaceUI extends JFrame  {
    
    private JFrame Acc;
    private ImageIcon BgColor, iconImage, Depic, depImage;
    private JPanel panel1, depanel, deposit;
    private JLabel label1, lblInfo, AccNamelbl, AccNumlbl, balancelbl;
    private JTextField tfBlank, AccNametf, AccNumtf, balancetf;
    private JButton depoBtn, WdrawBtn, transBtn, pinBtn, ExitBtn;
    
    public AccInterfaceUI() {
        //frame
        Acc = new JFrame();
        Acc.setTitle("BANK MANAGEMENT SYSTEM");
        Acc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Acc.setResizable(false);
        Acc.setSize(600, 480);
        
        // logo
        BgColor = new ImageIcon("logo.png");
        Acc.setIconImage(BgColor.getImage());
        Acc.getContentPane().setBackground(new Color(100,50,78));
        Acc.setLayout(new BorderLayout());
        
        //label "bank of bsit"
        ImageIcon iconImage = new ImageIcon("logo1.png");
        Image sizeImage = iconImage.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(sizeImage);
        label1 = new JLabel("BOB - BANK OF BSIT");
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("Courier New", Font.BOLD, 35));
        label1.setHorizontalAlignment(JLabel.CENTER);
        label1.setIcon(image);
        Acc.add(label1, BorderLayout.NORTH);
        
        //panel at the bg of the icons
        panel1 = new JPanel();
        panel1.setBackground(new Color(100,50,78));
        panel1.setBounds(50, 50, 500, 350);
        Acc.add(panel1, BorderLayout.CENTER); 
        
        depanel = new JPanel();
        depanel.setLayout(null);  
        depanel.setBackground(new Color(220, 190, 200));
        depanel.setPreferredSize(new Dimension(550, 300));
        panel1.add(depanel, BorderLayout.CENTER);
        
        // textfields
        lblInfo = new JLabel("ACCOUNT INFORMATION");
        lblInfo.setBounds(170,0,300,50);
        Font font = new Font("Aptos", Font.BOLD, 20);
        lblInfo.setFont(font);
        
        //AccInfo
        tfBlank = new JTextField();
        tfBlank.setBounds(0,0,0,0);
        
        AccNamelbl = new JLabel ("Account Name:");
        AccNamelbl.setBounds (40, 50, 100, 40);
        AccNametf = new JTextField();
        AccNametf.setBounds(170, 60, 150, 20);
        AccNametf.setHorizontalAlignment(JTextField.CENTER);
        
        AccNumlbl = new JLabel ("Account Number:");
        AccNumlbl.setBounds (40, 80, 140, 40);
        AccNumtf = new JTextField();
        AccNumtf.setBounds(170, 90, 150, 20);
        AccNumtf.setHorizontalAlignment(JTextField.CENTER);
        
        //Balance
        balancelbl = new JLabel ("Balance");
        balancelbl.setBounds (420, 50, 100, 30);
        balancetf = new JTextField();
        balancetf.setBounds(370, 82, 150, 25);
        balancetf.setHorizontalAlignment(JTextField.CENTER);

        //Deposit btn
        depoBtn = new JButton();
        depImage = new ImageIcon("dep.png");
        Image depsize = depImage.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        depoBtn.setIcon(new ImageIcon(depsize));
        depoBtn.setBounds(25, 150, 115, 120);  
        
        //Withdraw
        WdrawBtn = new JButton();
        ImageIcon WdraImage = new ImageIcon("Wdraw.png");
        Image Wdrawsize = WdraImage.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        WdrawBtn.setIcon(new ImageIcon(Wdrawsize));
        WdrawBtn.setBounds(150, 150, 115, 120);
        
        //Transactions
        transBtn = new JButton();
        ImageIcon transIcon = new ImageIcon("Transfer.png");
        Image transScaledImage = transIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        transBtn .setIcon(new ImageIcon(transScaledImage));
        transBtn.setBounds(275, 150, 115, 120);
        
        //Change Pin
        pinBtn = new JButton();
        ImageIcon pinIcon = new ImageIcon("Pin.png");
        Image pinScaledImage = pinIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        pinBtn.setIcon(new ImageIcon(pinScaledImage));
        pinBtn.setBounds(400, 150, 115, 120);
        
        //Exit
        ExitBtn = new JButton("EXIT");
        ExitBtn.setBounds(400, 275, 100, 20);
        ExitBtn.setFont(new Font("Arial", Font.BOLD, 10));

        depanel.add(lblInfo);
        depanel.add(AccNamelbl);
        depanel.add(AccNumlbl);
        depanel.add(AccNametf);
        depanel.add(AccNumtf);
        depanel.add(balancelbl);
        depanel.add(balancetf);
        depanel.add(depoBtn);
        depanel.add(WdrawBtn);
        depanel.add(transBtn );
        depanel.add(pinBtn);
        panel1.add(ExitBtn);

        Acc.setVisible(true);
    }


}
