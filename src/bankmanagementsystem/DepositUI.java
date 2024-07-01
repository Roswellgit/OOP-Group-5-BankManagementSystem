package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;


public class DepositUI extends JFrame implements ActionListener {

    private JFrame Acc;
    private ImageIcon BgColor, iconImage;
    private JPanel panel1, panel2;
    private JLabel Depolbl, Datelbl, AccNamelbl, AccNumlbl, Accbalancelbl, balanceImg, depamntlbl;
    private JTextField tfBlank, Datetf, AccNametf, AccNumtf, Accbalancetf, depamnttf;
    private JButton DepoBtn, ExitBtn;

    private Connection conn;

    public DepositUI() {
        // Frame setup
        Acc = new JFrame("BANK MANAGEMENT SYSTEM");
        Acc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Acc.setResizable(false);
        Acc.setSize(600, 360);
        Acc.setLocationRelativeTo(null);

        // Logo
        BgColor = new ImageIcon("logo.png");
        Acc.setIconImage(BgColor.getImage());
        Acc.getContentPane().setBackground(new Color(100, 50, 78));
        Acc.setLayout(new BorderLayout());

        // Panel setup
        panel1 = new JPanel();
        panel1.setBackground(new Color(100, 50, 78));
        panel1.setLayout(null);
        Acc.add(panel1, BorderLayout.CENTER);

        panel2 = new JPanel();
        panel2.setLayout(null);
        panel2.setBackground(new Color(220, 190, 200));
        panel2.setBounds(20, 20, 545, 280);
        panel1.add(panel2);

        // Labels and Text Fields
        Depolbl = new JLabel("DEPOSIT");
        Depolbl.setBounds(10, 0, 100, 30);
        Depolbl.setFont(new Font("Aptos", Font.BOLD, 15));

        tfBlank = new JTextField();
        tfBlank.setBounds(0, 0, 0, 0);

        Datelbl = new JLabel("Date:");
        Datelbl.setBounds(40, 50, 100, 40);
        Datetf = new JTextField();
        Datetf.setBounds(170, 60, 150, 20);
        Datetf.setHorizontalAlignment(JTextField.CENTER);
        Datetf.setEditable(false);
        Datetf.setText(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        

        AccNamelbl = new JLabel("Account Name:");
        AccNamelbl.setBounds(40, 80, 100, 40);
        AccNametf = new JTextField();
        AccNametf.setBounds(170, 90, 150, 20);
        AccNametf.setHorizontalAlignment(JTextField.CENTER);
        AccNametf.setEditable(false);

        AccNumlbl = new JLabel("Account Number:");
        AccNumlbl.setBounds(40, 110, 140, 40);
        AccNumtf = new JTextField();
        AccNumtf.setBounds(170, 120, 150, 20);
        AccNumtf.setHorizontalAlignment(JTextField.CENTER);

        Accbalancelbl = new JLabel("Account Balance:");
        Accbalancelbl.setBounds(40, 140, 140, 40);
        Accbalancetf = new JTextField();
        Accbalancetf.setBounds(170, 150, 150, 20);
        Accbalancetf.setHorizontalAlignment(JTextField.CENTER);
        Accbalancetf.setEditable(false);

        // Deposit button
        DepoBtn = new JButton("DEPOSIT");
        DepoBtn.setBounds(370, 50, 125, 30);
        DepoBtn.addActionListener(this);

        balanceImg = new JLabel();
        balanceImg.setBounds(380, 90, 130, 100);
        ImageIcon depoImage = new ImageIcon("dep.png");
        Image picsize = depoImage.getImage().getScaledInstance(110, 110, Image.SCALE_SMOOTH);
        ImageIcon depopic = new ImageIcon(picsize);
        balanceImg.setIcon(depopic);

        depamntlbl = new JLabel("Please Enter Amount to Deposit");
        depamntlbl.setBounds(40, 180, 250, 40);
        depamntlbl.setFont(new Font("Aptos", Font.BOLD, 15));
        depamnttf = new JTextField();
        depamnttf.setBounds(40, 220, 300, 30);
        depamnttf.setHorizontalAlignment(JTextField.CENTER);

        // Exit button
        ExitBtn = new JButton("EXIT");
        ExitBtn.setBounds(470, 255, 70, 20);
        ExitBtn.setFont(new Font("Aptos", Font.BOLD, 10));
        ExitBtn.addActionListener(this);

        panel2.add(Depolbl);
        panel2.add(Datelbl);
        panel2.add(Datetf);
        panel2.add(AccNamelbl);
        panel2.add(AccNametf);
        panel2.add(AccNumlbl);
        panel2.add(AccNumtf);
        panel2.add(Accbalancelbl);
        panel2.add(Accbalancetf);
        panel2.add(DepoBtn);
        panel2.add(balanceImg);
        panel2.add(depamntlbl);
        panel2.add(depamnttf);
        panel2.add(ExitBtn);
        Acc.setVisible(true);

        // Database connection
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_bank", "root", "root");
        } catch (Exception e) {
            System.out.print(e);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ExitBtn) {
            BankMainMenu bankmainmenu = new BankMainMenu();
        } else if (e.getSource() == DepoBtn) {
            Deposit();
        }
    }

    private void Deposit() {
        String accNum = AccNumtf.getText();
        if (accNum.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter an account number.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            String query = "SELECT acc_name, acc_bal FROM transactions WHERE acc_number = ?";
            PreparedStatement depositPs = conn.prepareStatement(query);
            depositPs.setString(1, accNum);
            ResultSet depositRs = depositPs.executeQuery();

            if (depositRs.next()) {
                String accName = depositRs.getString("acc_name");
                double balance = depositRs.getDouble("acc_bal");

                AccNametf.setText(accName);
                Accbalancetf.setText(String.valueOf(balance));

                double depositAmount = Double.parseDouble(depamnttf.getText());
                double newBalance = balance + depositAmount;
                String updateQuery = "UPDATE transactions SET acc_bal = ? WHERE acc_number = ?";
                String insertQuery = "INSERT INTO history VALUES(?,?,?,?,?)";
                PreparedStatement in = conn.prepareStatement(insertQuery);
                in.setString(1,accNum);
                in.setString(2,Datetf.getText());
                in.setString(3,"Deposit");
                in.setDouble(4,Double.parseDouble(depamnttf.getText()));
                in.setDouble(5,newBalance);
                in.executeUpdate();
                PreparedStatement updatePs = conn.prepareStatement(updateQuery);
                
                updatePs.setDouble(1, newBalance);
                updatePs.setString(2, accNum);
                updatePs.executeUpdate();
                

                JOptionPane.showMessageDialog(this, "Deposit successful.", "Success", JOptionPane.INFORMATION_MESSAGE);
                Accbalancetf.setText(String.valueOf(newBalance));
            } else {
                JOptionPane.showMessageDialog(this, "Account not found.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
