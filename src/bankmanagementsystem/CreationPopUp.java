package bankmanagementsystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CreationPopUp
{

    private JFrame f = new JFrame();
    private JLabel lblLoad;
    private JProgressBar lbLoad = new JProgressBar();
    
    CreationPopUp()
    {
        //frame settings
        f.setSize(400,100);
        f.setLayout(null);
        f.setDefaultCloseOperation(f.DISPOSE_ON_CLOSE);
        f.getContentPane().setBackground(new java.awt.Color(220, 190, 200));
        f.setLocationRelativeTo(null);
                
        //Loading Bar
        lblLoad = new JLabel("Account created successfully!");
        lblLoad.setBounds(50,20,500,40);
        lblLoad.setFont((new Font("Arial", Font.BOLD, 20)));
        
        lbLoad.setValue(0);
        lbLoad.setStringPainted(true);
        lbLoad.setBounds(185,350,500,30);
        
        f.add(lblLoad);
        fill();
        f.setVisible(true);
        f.setResizable(false);
        
        
    }

    private void fill()
    {
        int i = 0;
        try
        {
            while (i<100)
            {
                lbLoad.setValue(i);
                Thread.sleep(300);
                i += 53;
            }
        }
        catch(Exception e)
        {
        }
        
        f.dispose();
        BankMainMenu log = new BankMainMenu();
    }
}