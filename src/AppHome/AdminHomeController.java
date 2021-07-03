/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AppHome;

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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author dulshan
 */
public class AdminHomeController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private AnchorPane rootpane;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    @FXML
    private void loadinventory(ActionEvent event) throws IOException{
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/Inventory/inventoryhome.fxml"));
        rootpane.getChildren().setAll(pane);
        
        
    }
    @FXML
    private void loadsupplier(ActionEvent event) throws IOException{
        
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/Supplier/supplierhome.fxml"));
        rootpane.getChildren().setAll(pane);
        
        
    }
    @FXML
    private void loadFinanceAndExpenses(ActionEvent event) throws IOException{
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/FinanceAndExpenses/fehome.fxml"));
        rootpane.getChildren().setAll(pane);
        
        
    }
    @FXML
    private void loadCustomer(ActionEvent event) throws IOException{
        
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/Customer/CustomerHome.fxml"));
        rootpane.getChildren().setAll(pane);
        
        
    }
    @FXML
    private void loadUserAndEmployee(ActionEvent event) throws IOException{
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/UserAndEmployee/employee.fxml"));
        rootpane.getChildren().setAll(pane);
        
    }
    @FXML
    private void loadOffer(ActionEvent event) throws IOException{
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/Offer/offer.fxml"));
        rootpane.getChildren().setAll(pane);
        
    }
    @FXML
    private void LogoutSession(ActionEvent event) throws IOException {
        
        AnchorPane home_page = (AnchorPane)FXMLLoader.load(getClass().getResource("/UserAndEmployee/login.fxml"));
        
        Scene scene = new Scene(home_page);
        Stage app=(Stage)((Node) event.getSource()).getScene().getWindow();
        app.setScene(scene);
        app.show();
    }
    @FXML
    private void loadBilling(ActionEvent event) throws IOException {
    
    AnchorPane home_page = (AnchorPane)FXMLLoader.load(getClass().getResource("/BillingAndIncome/First_Window.fxml"));
        
        Scene scene = new Scene(home_page);
        Stage app=(Stage)((Node) event.getSource()).getScene().getWindow();
        app.setScene(scene);
        app.show();
       
        }
}
