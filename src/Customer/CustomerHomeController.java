/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Customer;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author Hansini
 */
public class CustomerHomeController implements Initializable {
    
     @FXML
    private AnchorPane rootpane;
    @FXML
    private ComboBox combo1;
    
    @FXML
    private void loadAdminHome(ActionEvent event) throws IOException {
        Parent productView = FXMLLoader.load(getClass().getResource("/AppHome/adminhome.fxml"));
        Scene productViewScene = new Scene(productView);
        Stage productStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        productStage.setScene(productViewScene);
        productStage.show();
    }
    @FXML
    private void goInfoView(ActionEvent event) throws IOException{
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Customerinfoview.fxml"));
        rootpane.getChildren().setAll(pane);
    }
    @FXML
     private void goTransaction(ActionEvent event) throws IOException{
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Customertransaction.fxml"));
        rootpane.getChildren().setAll(pane);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        // combo1.getItems().addAll("Employee Management", "Offer Managemnet","Customer Management", "Payaroll Management", "Supplier Management", "Inventory Management", "Billing & Income Management", "Finance & Expence Management"); 
       // Data=FXCollections.observableArrayList();
    }    
    
}
