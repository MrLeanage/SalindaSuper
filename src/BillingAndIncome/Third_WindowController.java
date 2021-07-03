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
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
//import net.sf.jasperreports.engine.JRException;
//import net.sf.jasperreports.engine.JasperCompileManager;
//import net.sf.jasperreports.engine.JasperReport;

/**
 * FXML Controller class
 *
 * @author Danushi Pathirana
 */
public class Third_WindowController implements Initializable {

    @FXML
    private Button button3;
    @FXML
    private TextField Bill_Total;
    private TextField Bill_Discount;
    private TextField Bill_Amount;
    private TextField CBO;
    private DBConnection dbcon;
    @FXML
    private Button add3;
    @FXML
    private DatePicker date3;
    
    
    private Connection conn=null;
    private PreparedStatement ppst=null;

    String docNo; 
    @FXML
    private Label Date_error;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        dbcon = new DBConnection();
        //conn=DB_connector.Connection();
        
    }    
    @FXML
    private void handleUserBack(ActionEvent event) throws IOException {
        
        AnchorPane home_page = (AnchorPane)FXMLLoader.load(getClass().getResource("/BillingAndIncome/Second_Window_1.fxml"));
        
        Scene scene = new Scene(home_page);
        Stage app=(Stage)((Node) event.getSource()).getScene().getWindow();
        app.setScene(scene);
        app.show();
        
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
    private void handleBack(ActionEvent event) throws IOException {
        /*
        AnchorPane home_page_parent=(AnchorPane)FXMLLoader.load(getClass().getResource("/javafxapplication5/Second_Window.fxml"));
        Scene home_page_scene=new Scene(home_page_parent);
        Stage app_stage=(Stage)((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        app_stage.show();
        */
        AnchorPane home_page = (AnchorPane)FXMLLoader.load(getClass().getResource("/BillingAndIncome/Second_Window.fxml"));
        
        Scene scene = new Scene(home_page);
        Stage app=(Stage)((Node) event.getSource()).getScene().getWindow();
        app.setScene(scene);
        app.show();
        
    }
    
    private void handleAddEvent(ActionEvent event) throws SQLException {
        
      
            
        LocalDate Bdate=date3.getValue();
        double BTotal=Double.valueOf(Bill_Total.getText());

        
        String sql="Insert into billing(BDate,BTotal,Document_no)values(?,?,?)";
    
        
        try{
            Connection conn = dbcon.Connect();
        ppst=(PreparedStatement) conn.prepareStatement(sql);
        ppst.setDate(1, Date.valueOf(Bdate));
        ppst.setDouble(2, BTotal);
        ppst.setString(3, docNo);
        
        int x=ppst.executeUpdate();
        if(x==1){
             AlertDialog.display("Sale succeed", "Alert");
        }
        }catch(Exception e){
            System.out.println(e);
        }
        
        finally{
            ppst.close();
        }
        
    }
    
    
    
    
      public void getTo(float Tot,String docNo){
    
          this.docNo=docNo;
          Bill_Total.setText(String.valueOf(Tot));
    }

//    @FXML
//    private void Printbill(ActionEvent event) {
//        
//        String souceFile="C:\\Users\\Danushi Pathirana\\Documents\\NetBeansProjects\\JavaFXApplication5\\src\\Ireport\\Invoice.jrxml";
//        try {
//            JasperReport jr=JasperCompileManager.compileReport(souceFile);
//        } catch (JRException ex) {
//            Logger.getLogger(Third_WindowController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//    }
//    
    
}
