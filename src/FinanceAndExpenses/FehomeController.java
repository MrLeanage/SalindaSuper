










/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinanceAndExpenses;

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
 * FXML Controller class
 *
 * @author N
 */
public class FehomeController implements Initializable {
    @FXML
    private ComboBox<String> gofunction;
    
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
    private void goExpense(ActionEvent event) throws IOException {
        /*
        Parent expenseView = FXMLLoader.load(getClass().getResource("expenseview.fxml"));
        Scene expenseViewScene = new Scene(expenseView);
        Stage expenseStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        expenseStage.setScene(expenseViewScene);
        expenseStage.show();
*/
        AnchorPane pane = FXMLLoader.load(getClass().getResource("expenseview.fxml"));
        rootpane.getChildren().setAll(pane);
    }    
    @FXML
    private void goProfit(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("financeview.fxml"));
        rootpane.getChildren().setAll(pane);
    }    @Override
    
    public void initialize(URL url, ResourceBundle rb) {
         //    gofunction.getItems().addAll("Employee Management", "Offer Managemnet","Customer Management", "Payaroll Management", "Supplier Management", "Inventory Management", "Billing & Income Management", "Finance & Expence Management"); 

    }    
    
}
