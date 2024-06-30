package bankmanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BankRecords implements ActionListener {
    
    private JFrame f;
    private ImageIcon BgColor;
    private JPanel panel1, depanel;
    private JLabel label1;
    private JButton ReturnBtn;
    private JTable records;
    private JScrollPane spScroll;
   
    
    public BankRecords() {
        
        //frame
        f = new JFrame();
        f.setTitle("USER RECORDS");
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
        
        label1 = new JLabel("BANK OF BSIT");
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("Courier New", Font.BOLD, 40));
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
        depanel.setPreferredSize(new Dimension(540, 330));
        panel1.add(depanel, BorderLayout.CENTER);
        
        //add data to table
        String [][] data = {
            {"Jan Dow", "3422A12", "21", "03-01-1999", "Male", "Married"},
            {"Beatrice", "32RE213", "34", "04-17-1986", "Female", "Divorced"},
                 
        };
        
        String[] columnName = { "Full Name", "Account Number", "Age", "Birthday", "Sex", "Civil Status"};
        
        //create table
        records = new JTable(data,columnName);
        records.setBounds(20,30, 500, 270);
        
        //Add the scroll to the Panel
        spScroll = new JScrollPane(records);
        
        depanel.add(spScroll, BorderLayout.CENTER);
        
        depanel.add(records);

        //Return
        ReturnBtn = new JButton("RETURN");
        ReturnBtn.setBounds(400, 275, 100, 20);
        ReturnBtn.setFont(new Font("Arial", Font.BOLD, 10));
        ReturnBtn.setFocusable(false);
        ReturnBtn.addActionListener(this);
        panel1.add(ReturnBtn);

        
        f.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==ReturnBtn) {
            f.dispose();
            BankMainMenu bankmainmenu = new BankMainMenu();
        }
    }
}
