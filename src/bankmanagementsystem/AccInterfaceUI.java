package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;


public class AccInterfaceUI extends JFrame  {
    
    private JFrame Acc;
    private ImageIcon BgColor, iconImage;
    private JPanel panel1;
    private JLabel label1, Depo;
    
    public AccInterfaceUI() {
        //frame
        Acc = new JFrame();
        Acc.setTitle("BANK MANAGEMENT SYSTEM");
        Acc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Acc.setResizable(false);
        Acc.setSize(700, 500);
        
        // logo
        BgColor = new ImageIcon("C:\\Users\\mhace\\OneDrive\\Desktop\\OOP\\12.jpg");
        Acc.setIconImage(BgColor.getImage());
        Acc.setLayout(new BorderLayout());
        Acc.getContentPane().setBackground(new Color(169, 217, 186));
    
        //label "bank of bsit"
        ImageIcon iconImage = new ImageIcon("C:\\Users\\mhace\\OneDrive\\Desktop\\OOP\\logo.png");
        Image sizeImage = iconImage.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(sizeImage);
        label1 = new JLabel("BOB - BANK OF BSIT");
        label1.setForeground(Color.BLACK);
        label1.setFont(new Font("Courier New", Font.BOLD, 35));
        label1.setHorizontalAlignment(JLabel.CENTER);
        label1.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        label1.setIcon(image);
        Acc.add(label1, BorderLayout.NORTH);
    
        // panel at the bg of the icons
        panel1 = new JPanel();
        panel1.setBackground(new Color(233, 227, 200));
        panel1.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
        Acc.add(panel1, BorderLayout.CENTER);
        
        //Deposit Click!!
        Depo = new JLabel("Make A Deposit");
        Depo.setBounds(200, 200, 100, 100);
        Depo.setPreferredSize(new Dimension(100, 50)); 
        Depo.setBackground(Color.blue);
        Depo.setOpaque(true);
        Depo.addMouseListener(new Deposit());
        panel1.add(Depo);
        
        
        Acc.setVisible(true);
    }


}
