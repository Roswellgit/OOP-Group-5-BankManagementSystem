package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import static java.awt.Color.black;
import java.awt.event.*;
import java.sql.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.*;
        
public class AdminRecords implements ActionListener
{
    
    private JFrame f;
    private ImageIcon BgColor;
    private JPanel panel1, depanel;
    private JLabel label1;
    private JButton ReturnBtn;
    private JTable records;
    private JScrollPane spScroll;
    private DefaultTableModel ColumnHeaders;
    private JTableHeader tableheader;
   
    
    public AdminRecords()
    {
        
        //frame
        f = new JFrame();
        f.setTitle("USER RECORDS");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(false);
        f.setSize(1000, 600);
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
        panel1.setBounds(0,100,1000,600);
        f.add(panel1, BorderLayout.CENTER); 
        
        depanel = new JPanel();
        depanel.setPreferredSize(new Dimension(920,415));
        depanel.setLayout(null);
        depanel.setBackground(new Color(220, 190, 200));
        panel1.add(depanel, BorderLayout.CENTER);
        
        //create table
        ColumnHeaders = new DefaultTableModel(new Object[]{"UserName","Password"}, 0);
        records = new JTable(ColumnHeaders);
        records.setOpaque(false);

        tableheader = records.getTableHeader();
        records.getTableHeader().setBackground(new Color(181,103,110));
        records.getTableHeader().setForeground(black);
        records.getTableHeader().setFont(new Font("Aptos", Font.PLAIN, 12));
        
        //Add the scroll to the Panel
        spScroll = new JScrollPane(records);
        spScroll.setBounds(40,30,840,350);
        spScroll.setBorder(new LineBorder(Color.BLACK, 1));
        depanel.add(spScroll);
        

        try
        {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_bank","root","root");
    
            Statement st = con.createStatement();
    
            String q =  "SELECT * FROM admin";
            ResultSet rs = st.executeQuery(q);
    
            while(rs.next())
            {
                String UM = rs.getString("username");
                String PW = rs.getString("password");
        
                String tbData[] = {UM,PW};
                DefaultTableModel record = (DefaultTableModel)records.getModel();
        
                record.addRow(tbData);
            }
            con.close();
        }
        
        catch(Exception ex)
        {
            System.out.println(ex);
        }

        
        //Return
        ReturnBtn = new JButton("RETURN");
        ReturnBtn.setBounds(200, 705, 100, 15);
        ReturnBtn.setFont(new Font("Arial", Font.BOLD, 10));
        ReturnBtn.setFocusable(false);
        ReturnBtn.addActionListener(this);
        panel1.add(ReturnBtn);

        
        f.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==ReturnBtn)
        {
            f.dispose();
            BankMainMenu bankmainmenu = new BankMainMenu();
        }
    }
}
