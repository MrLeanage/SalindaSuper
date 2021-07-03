/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BillingAndIncome;

import Alert.AlertDialog;
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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Danushi Pathirana
 */
public class Second_WindowController implements Initializable {

    @FXML
    private Button submit;
    @FXML
    private Button back2;
    @FXML
    private TextField Phone_Number;
    @FXML
    private Label Phone_error;
    
    private Connection conn=null;
    private PreparedStatement pst=null;
    private DBConnection dbcon;
    
    @FXML
    private Button Add;
    @FXML
    private TextField Discount_Presentage;
    @FXML
    private Label Outstanding_error;
    @FXML
    private Label Discount_error;
    @FXML
    private Button view;
    @FXML
    private TextField BillTotal;
    @FXML
    private TextField Cus_outstanding;
    float newCusout;
    String docNo;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //conn=DB_connector.Connection();
        dbcon = new DBConnection();
//         String cout=Customer_outstanding.getText();
        
//        FXMLLoader loader=new FXMLLoader();
//        First_WindowController Fcontroller=loader.getController();
//        Fcontroller.totalpass();
        
        
        
    }    
@FXML
    private void handleLogoutEvent(ActionEvent event) throws Exception  {
        
        
             AnchorPane home_page = (AnchorPane)FXMLLoader.load(getClass().getResource("/UserAndEmployee/login.fxml"));
        
        Scene scene = new Scene(home_page);
        Stage app=(Stage)((Node) event.getSource()).getScene().getWindow();
        app.setScene(scene);
        app.show();
        
}
    @FXML
    private void handleSubmitEvent(ActionEvent event) throws IOException, SQLException {
        
        try{
            ((Node)event.getSource()).getScene().getWindow().hide();
            FXMLLoader loader =new FXMLLoader(getClass().getResource("/BillingAndIncome/Third_Window.fxml"));
             Parent root =(Parent)loader.load();
            
             Third_WindowController s2=loader.getController();
             s2.getTo(Float.valueOf(BillTotal.getText()),docNo);
             Stage stage=new Stage();
             stage.setScene(new Scene(root));
             stage.show();
        
}
catch(IOException e){
 e.printStackTrace();
}
        
    }
@FXML
    private void handleUserSubmitEvent(ActionEvent event) throws IOException, SQLException {
        
        
            ((Node)event.getSource()).getScene().getWindow().hide();
            FXMLLoader loader =new FXMLLoader(getClass().getResource("/BillingAndIncome/Third_Window_1.fxml"));
             Parent root =(Parent)loader.load();
            
             Third_WindowController s2=loader.getController();
             s2.getTo(Float.valueOf(BillTotal.getText()),docNo);
             Stage stage=new Stage();
             stage.setScene(new Scene(root));
             stage.show();
        

        
    }
    @FXML
    private void handleback(ActionEvent event) throws IOException {
        /*
        AnchorPane home_page_parent=(AnchorPane)FXMLLoader.load(getClass().getResource("/BillingAndIncome/First_Window.fxml"));
        Scene home_page_scene=new Scene(home_page_parent);
        Stage app_stage=(Stage)((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        app_stage.show();
        */
        AnchorPane home_page = (AnchorPane)FXMLLoader.load(getClass().getResource("/BillingAndIncome/First_Window.fxml"));
        
        Scene scene = new Scene(home_page);
        Stage app=(Stage)((Node) event.getSource()).getScene().getWindow();
        app.setScene(scene);
        app.show();
        
    }
    @FXML
    private void handleUserBack(ActionEvent event) throws IOException {
        
        AnchorPane home_page = (AnchorPane)FXMLLoader.load(getClass().getResource("/BillingAndIncome/First_Window_1.fxml"));
        
        Scene scene = new Scene(home_page);
        Stage app=(Stage)((Node) event.getSource()).getScene().getWindow();
        app.setScene(scene);
        app.show();
        
    }

    @FXML
    private void handleAddEvent(ActionEvent event) throws SQLException, IOException {
        
        
        boolean isphoneCheck=Validation.TextValidation.isTextFieldTypePhoneNumber(Phone_Number,Phone_error , "Phone Number Should be a 10 digit Number");
        
        if(isphoneCheck){
            
            
             String sql1="Update customer set Customer_outstanding="+newCusout+" Where CPhone1="+Phone_Number.getText()+"";        
             int PhoneNumber=Integer.valueOf(Phone_Number.getText());  
            
                        try {
            Connection conn = dbcon.Connect();  
            pst=conn.prepareStatement(sql1);
          
            
                int x=pst.executeUpdate();
        if(x==1){
        
            AlertDialog.display("Customer Outstanding Updated","info");
            cleartext();
        }
                }catch(SQLException ex){
                         Logger.getLogger(First_WindowController.class.getName()).log(Level.SEVERE, null, ex);
                            }
        
         finally{
            pst.close();
        }
            
            
   
    }
        
    
        
    }
    
    private void cleartext(){
        
        Phone_Number.clear();
        
    }
    
    

    @FXML
    private void handleCustomerViewOutstanding(ActionEvent event) {
        String remcus;
        float remcusFloat;
        //float newCusout;
        float cusrem;
        float dis;
        float billtot=Float.valueOf(BillTotal.getText());
        
        First_WindowController nm = new First_WindowController();
        
        int ph=Integer.valueOf(Phone_Number.getText());
        
        String sql="select Customer_outstanding from customer where CPhone1="+Phone_Number.getText()+"";
        
        try {
            Connection conn = dbcon.Connect();
            pst=conn.prepareStatement(sql);
            
            ResultSet rs = pst.executeQuery();
            
             while(rs.next()){
                  remcus = rs.getString("Customer_outstanding");
                  remcusFloat=Float.valueOf(remcus);
                  dis=remcusFloat*2/100;
                  Discount_Presentage.setText(String.valueOf(dis));
               // System.out.println("kk");
                  Cus_outstanding.setText(remcus);
                  newCusout=remcusFloat+billtot;
          
                 
                  
                  
                  
            }   
            
            

        } catch (SQLException ex) {
            Logger.getLogger(Second_WindowController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    
    public void getTot(float Tot,String docNo){
    
    BillTotal.setText(String.valueOf(Tot));
    this.docNo=docNo;
    
    }
    
}
