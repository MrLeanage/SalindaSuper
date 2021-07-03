/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserAndEmployee;

import DBConnect.DBConnection;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author Ashika
 */
public class LoginController implements Initializable {
    
    private Label label;
    @FXML
    private Button SubmitLogin;
    @FXML
    private TextField UserNameLogin;
    @FXML
    private PasswordField PasswordLogin;
    @FXML
    private Rectangle lol;
    
    private DBConnection con;
    //Connection con =null;
        PreparedStatement ps=null;
        ResultSet rs=null;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
   
        con = new DBConnection();
        
    }    
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @FXML
    private void handlingLoginInterface(ActionEvent event) throws IOException {
        
        
         
        if(UserNameLogin.getText().equals("Admin")&&PasswordLogin.getText().equals("admin")){
            //LogIn();
           
          //JOptionPane.showMessageDialog(null, "Correct");
         AnchorPane home_page = (AnchorPane)FXMLLoader.load(getClass().getResource("/AppHome/adminhome.fxml"));
        
        Scene scene = new Scene(home_page);
        Stage app=(Stage)((Node) event.getSource()).getScene().getWindow();
        app.setScene(scene);
        app.show();
       
        }
        else if(UserNameLogin.getText().equals("User")&&PasswordLogin.getText().equals("user")){
            AnchorPane home_page = (AnchorPane)FXMLLoader.load(getClass().getResource("/BillingAndIncome/First_Window_1.fxml"));
        
        Scene scene = new Scene(home_page);
        Stage app=(Stage)((Node) event.getSource()).getScene().getWindow();
        app.setScene(scene);
        app.show();
       
            
        }else{
            JOptionPane.showMessageDialog(null,"Incorrect Login");
        }
        
        

    
        
    }
    
        
        
//    private void LogIn() throws IOException{
//        
//        String UserName = UserNameLogin.getText().toString();
//        String PassWord = PasswordLogin.getText().toString();
//        
//        String sql = "SELECT Euser,Epassword From employee WHERE  ENo=? ";
//        
//        try {
//            ps =con.prepareCall(sql);
//            ps.setString(1, UserName);
//            ps.setString(2, PassWord);
//            rs =ps.executeQuery();
//            if(!rs.next()){
//                
//                 JOptionPane.showMessageDialog(null, "Wrong Login");  
//            }else{
//                
//                JOptionPane.showMessageDialog(null, "Success Login"); 
//                Scene scene = new Scene(FXMLLoader.load(getClass().getResource("OfferManagement.fxml")));
//            }
//        } catch (SQLException ex) {
//            System.out.println("hiiiiiiiiiiiiii");
//            Logger.getLogger(OfferLoginController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//    }

    @FXML
    private void handlingback1(ActionEvent event) {
    }
}
