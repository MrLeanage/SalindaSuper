/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBConnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dulshan
 */
public class DBConnection {
    
    public Connection Connect(){
        try {
            String url = "jdbc:mysql://localhost:3306/salindasuper?useSSL=false";
            String user = "root";
            String password = "uthpala";
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, password);
            return conn;
            
            
            
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Where is your Mysql jdbc Driver??");
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    
}
