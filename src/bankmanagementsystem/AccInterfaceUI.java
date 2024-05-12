package bankmanagementsystem;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.*;


public class AccInterfaceUI {
    
    private JFrame Acc;
    private ImageIcon BgColor;
    private JLabel label1;
    private JPanel panel1;
    
    
    
    AccInterfaceUI(){
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
    label1 = new JLabel("BOB - BANK OF BSIT");
    label1.setForeground(Color.BLACK);
    label1.setFont(new Font("Courier New", Font.BOLD, 30));
    label1.setHorizontalAlignment(JLabel.CENTER);
    label1.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
    Acc.add(label1, BorderLayout.NORTH);
   

    // panel at the bg of the icons
    panel1 = new JPanel();
    panel1.setBackground(new Color(233, 227, 200));
    panel1.setPreferredSize(new Dimension(10, 50)); 
    panel1.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
    Acc.add(panel1, BorderLayout.CENTER); 
    
    
    Acc.setVisible(true);
    
 
    }
}
