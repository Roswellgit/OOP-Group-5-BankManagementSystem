
import javax.swing.*;
import java.awt.*;


public class AccInterfaceUI extends JFrame  {
    
    private JFrame Acc;
    private ImageIcon BgColor, iconImage, Depic;
    private JPanel depanel;
    private JLabel label1, Depo;
    private Jpanel panel2,
    
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
      
        //Deposit Click Panel!!
        depanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        depanel.setBackground(new Color(233, 227, 200));
        depanel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
        Acc.add(depanel, BorderLayout.CENTER);
        
        Depo = new JLabel("Make A Deposit");
        Depo.setForeground(Color.BLACK);
        Depo.setPreferredSize(new Dimension(150, 50));
        Depo.setBackground(new Color(233, 227, 200));
        Depo.setHorizontalAlignment(JLabel.CENTER);
        Depo.setOpaque(true);
        Depo.addMouseListener(new Deposit());
        
        ImageIcon depImage = new ImageIcon("C:\\Users\\mhace\\OneDrive\\Desktop\\OOP\\dep.png");
        Image picsize = depImage.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon Depic = new ImageIcon(picsize);
        Depo.setIcon(Depic);
        depanel.add(Depo, BorderLayout.NORTH);
        
        panel2 = new JPanel();
    depanel.add(panel2, BorderLayout.CENTER);
    panel2.setBackground(new Color(220, 190, 200));
    panel2.setPreferredSize(new Dimension(670,350));
    Acc.setVisible(true);
        
        Acc.setVisible(true);
    }


}
