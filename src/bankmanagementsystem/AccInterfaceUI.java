package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;


public class AccInterfaceUI extends JFrame  {
    
    private JFrame Acc;
    private ImageIcon BgColor, iconImage, Depic;
    private JPanel depanel, panel2;
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
        Acc.getContentPane().setBackground(new Color(169, 217, 186));
        Acc.setLayout(new BorderLayout());
        
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
      
      
        //buttons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        buttonPanel.setBackground(new Color(233, 227, 200));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
        Acc.add(buttonPanel, BorderLayout.CENTER);

//Withdraw
        JButton withdrawButton = new JButton();
        ImageIcon withdrawIcon = new ImageIcon("C:\\Users\\Sarvin\\Downloads\\withdraw-money-icon-free-vector-removebg-preview.png");
        Image withdrawScaledImage = withdrawIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        withdrawButton.setIcon(new ImageIcon(withdrawScaledImage));
        buttonPanel.add(withdrawButton); // Add "Withdraw" button to the panel

        //Deposit
        JButton depoButton = new JButton();
        ImageIcon depositIcon = new ImageIcon("C:\\Users\\Sarvin\\Downloads\\images-removebg-preview (1).png");
        Image depositScaledImage = depositIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        depoButton.setIcon(new ImageIcon(depositScaledImage));
        buttonPanel.add(depoButton); // Add "Deposit" button to the panel

        //Transactions
        JButton transButton = new JButton();
        ImageIcon transIcon = new ImageIcon("C:\\Users\\Sarvin\\Downloads\\kisspng-checks-bank-account-clip-art-transaction-account-5cf31ba193e545.0629072015594361936058-removebg-preview (1).png");
        Image transScaledImage = transIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        transButton.setIcon(new ImageIcon(transScaledImage));
        buttonPanel.add(transButton);

        //Pin
        JButton pinButton = new JButton();
        ImageIcon pinIcon = new ImageIcon("C:\\Users\\Sarvin\\Downloads\\istockphoto-927672636-612x612-removebg-preview.png");
        Image pinScaledImage = pinIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        pinButton.setIcon(new ImageIcon(pinScaledImage));
        buttonPanel.add(pinButton);

        
        Acc.setVisible(true);
    }


}
