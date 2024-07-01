/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bankmanagementsystem;

import java.awt.EventQueue;
import java.sql.*;

/**
 *
 * @author win10
 */
public class BankManagementSystem {
    
    public static void main(String[] args) {
       
//        BankMainMenu mainmenu = new BankMainMenu();
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                BankMainMenu mn = new BankMainMenu();
                mn.setVisible(true);
            }
        });

     
    }
    
}
// comment