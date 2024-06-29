/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bankmanagementsystem;

import java.sql.*;

/**
 *
 * @author win10
 */
public class BankManagementSystem {
    
    public static void main(String[] args) {
       
        UserLogin userlogin = new UserLogin();

      try{
        
          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_bank","root","root");
 
          PreparedStatement pr = con.prepareStatement("SELECT * FROM bank_table");
          
       ResultSet res = pr.executeQuery();
       
          while(res.next()){
              String id = res.getString("idBank_Table");
               String n = res.getString("CustomerName");
                String a = res.getString("BankAmount");
                
                System.out.println(id);
                         System.out.println(n);
                                  System.out.println(a);
          }
       

          }
      
      catch(Exception ex){
          System.out.println(ex);
      }
    }
    
}
// comment