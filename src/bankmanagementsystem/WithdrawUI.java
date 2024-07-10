package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;
import java.text.SimpleDateFormat;

public class WithdrawUI extends JFrame implements ActionListener {

    private JFrame Acc;
    private ImageIcon BgColor, iconImage;
    private JPanel panel1, depanel;
    private JLabel Withdrawlbl, Datelbl, AccNamelbl, AccNumlbl, Accbalancelbl, balanceImg, withdrawlbl;
    private JTextField tfBlank, Datetf, AccNametf, AccNumtf, Accbalancetf, tfWithdraw;
    private JButton WdrawBtn, ExitBtn;

    private Connection conn;

    public WithdrawUI() {
        //frame
        Acc = new JFrame("BANK MANAGEMENT SYSTEM");
        Acc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Acc.setResizable(false);
        Acc.setSize(600, 360);
        Acc.setLocationRelativeTo(null);

        //logo
        BgColor = new ImageIcon("logo.png");
        Acc.setIconImage(BgColor.getImage());
        Acc.getContentPane().setBackground(new Color(100, 50, 78));
        Acc.setLayout(new BorderLayout());

        //panel
        panel1 = new JPanel();
        panel1.setBackground(new Color(100, 50, 78));
        panel1.setLayout(null);
        Acc.add(panel1, BorderLayout.CENTER);

        depanel = new JPanel();
        depanel.setLayout(null);
        depanel.setBackground(new Color(220, 190, 200));
        depanel.setBounds(20, 20, 545, 280);
        panel1.add(depanel);

        //lbl & tf
        Withdrawlbl = new JLabel("WITHDRAW");
        Withdrawlbl.setBounds(10, 0, 100, 30);
        Withdrawlbl.setFont(new Font("Aptos", Font.BOLD, 15));

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

        //withdraw
        WdrawBtn = new JButton("WITHDRAW");
        WdrawBtn.setBounds(370, 50, 125, 30);
        WdrawBtn.addActionListener(this);

        balanceImg = new JLabel();
        balanceImg.setBounds(380, 90, 130, 100);
        ImageIcon wdrawImage = new ImageIcon("Wdraw.png");
        Image picsize = wdrawImage.getImage().getScaledInstance(110, 110, Image.SCALE_SMOOTH);
        ImageIcon drawpic = new ImageIcon(picsize);
        balanceImg.setIcon(drawpic);

        //exit
        withdrawlbl = new JLabel("Please Enter Amount to Withdraw");
        withdrawlbl.setBounds(40, 180, 250, 40);
        withdrawlbl.setFont(new Font("Aptos", Font.BOLD, 15));
        tfWithdraw = new JTextField();
        tfWithdraw.setBounds(40, 220, 300, 30);
        tfWithdraw.setHorizontalAlignment(JTextField.CENTER);

        //exit
        ExitBtn = new JButton("EXIT");
        ExitBtn.setBounds(470, 255, 70, 20);
        ExitBtn.setFont(new Font("Aptos", Font.BOLD, 10));
        ExitBtn.addActionListener(this);

        depanel.add(Withdrawlbl);
        depanel.add(Datelbl);
        depanel.add(Datetf);
        depanel.add(AccNamelbl);
        depanel.add(AccNametf);
        depanel.add(AccNumlbl);
        depanel.add(AccNumtf);
        depanel.add(Accbalancelbl);
        depanel.add(Accbalancetf);
        depanel.add(WdrawBtn);
        depanel.add(balanceImg);
        depanel.add(withdrawlbl);
        depanel.add(tfWithdraw);
        depanel.add(ExitBtn);
        Acc.setVisible(true);

   
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_bank", "root", "root");
        } catch (Exception e) {
            System.out.print(e);
        }
    }

    @Override
    public void actionPerformed(ActionEvent close) {
        if (close.getSource() == ExitBtn) {
            
            BankMainMenu bankmainmenu = new BankMainMenu();
            Acc.dispose();
            
        } else if (close.getSource() == WdrawBtn) {
            Withdraw();
        }
    }

    private void Withdraw() {
        String accNum = AccNumtf.getText();
        if (accNum.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter an account number.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            String query = "SELECT acc_name, acc_bal FROM transactions WHERE acc_number = ?";
            PreparedStatement withdrawPs = conn.prepareStatement(query);
            withdrawPs.setString(1, accNum);
            ResultSet withdrawrs = withdrawPs.executeQuery();

            if (withdrawrs.next()) {
                String accName = withdrawrs.getString("acc_name");
                double balance = withdrawrs.getDouble("acc_bal");

                AccNametf.setText(accName);
                Accbalancetf.setText(String.valueOf(balance));

                double withdrawAmount = Double.parseDouble(tfWithdraw.getText());
                if (withdrawAmount > balance) {
                    JOptionPane.showMessageDialog(this, "Insufficient balance.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    double newBalance = balance - withdrawAmount;
                    String updateQuery = "UPDATE transactions SET acc_bal = ? WHERE acc_number = ?";
                     
                String insertQuery = "INSERT INTO history VALUES(?,?,?,?,?)";
                PreparedStatement in = conn.prepareStatement(insertQuery);
                in.setString(1,accNum);
                in.setString(2,Datetf.getText());
                in.setString(3,"Withdraw");
                in.setDouble(4,Double.parseDouble(tfWithdraw.getText()));
                in.setDouble(5,newBalance);
                in.executeUpdate();
                    PreparedStatement updatePs = conn.prepareStatement(updateQuery);
                    updatePs.setDouble(1, newBalance);
                    updatePs.setString(2, accNum);
                    updatePs.executeUpdate();

                    JOptionPane.showMessageDialog(this, "Withdrawal successful.", "Success", JOptionPane.INFORMATION_MESSAGE);
                    Accbalancetf.setText(String.valueOf(newBalance));
                    
                    
                }
            } else {
                JOptionPane.showMessageDialog(this, "Account not found.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e, "Error", JOptionPane.ERROR_MESSAGE);
        } 
    }

}
