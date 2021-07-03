/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inventory;

import DBConnect.DBConnection;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author dulshan
 */
public class inventoryhomeController implements Initializable {
    @FXML
    private AnchorPane rootpane;
    @FXML
    private void loadAdminHome(ActionEvent event) throws IOException {
        Parent productView = FXMLLoader.load(getClass().getResource("/AppHome/adminhome.fxml"));
        Scene productViewScene = new Scene(productView);
        Stage productStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        productStage.setScene(productViewScene);
        productStage.show();
    }
    @FXML
    private void loadproduct(ActionEvent event) throws IOException{
        AnchorPane pane = FXMLLoader.load(getClass().getResource("product.fxml"));
        rootpane.getChildren().setAll(pane);
        
    }
    @FXML
    private void loadCategory(ActionEvent event) throws IOException{
        AnchorPane pane = FXMLLoader.load(getClass().getResource("productcategories.fxml"));
        rootpane.getChildren().setAll(pane);  
    }
    @FXML
    private void loadBrand(ActionEvent event) throws IOException{
        AnchorPane pane = FXMLLoader.load(getClass().getResource("productbrand.fxml"));
        rootpane.getChildren().setAll(pane);  
    }
    @FXML
    private void loadADList(ActionEvent event) throws IOException{
        AnchorPane pane = FXMLLoader.load(getClass().getResource("adlisthome.fxml"));
        rootpane.getChildren().setAll(pane);  
    }
    @FXML
    private void goProduct(ActionEvent event) throws IOException {
        Parent productView = FXMLLoader.load(getClass().getResource("product.fxml"));
        Scene productViewScene = new Scene(productView);
        Stage productStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        productStage.setScene(productViewScene);
        productStage.show();
    }
    
    @FXML
    private void goBackInventory(ActionEvent event) throws IOException {
        Parent productView = FXMLLoader.load(getClass().getResource("new1.fxml"));
        Scene productViewScene = new Scene(productView);
        Stage productStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        productStage.setScene(productViewScene);
        productStage.show();
    }
    DBConnection myConn;
    Statement myStat = null;
    ResultSet myRs = null;
    private DBConnection dbcon;
    String data;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        dbcon = new DBConnection();
    } 
    
       
    
}
