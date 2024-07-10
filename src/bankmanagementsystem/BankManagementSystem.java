package bankmanagementsystem;

import java.awt.EventQueue;

public class BankManagementSystem {
    
    public static void main(String[] args) {
       
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                UserLogin ul = new UserLogin();
            }
        });

     
    }
    
}
// comment