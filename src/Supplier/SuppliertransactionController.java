/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Supplier;

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
 * @author nimesh :)
 */
public class SuppliertransactionController implements Initializable {

    @FXML
    private AnchorPane rootpane;

    /**
     * Initializes the controller class.
     */
    @FXML
     private void goSupplierHome(ActionEvent event) throws IOException{
        Parent supplyInfo = FXMLLoader.load(getClass().getResource("supplierhome.fxml"));
        Scene supplyInfoScene = new Scene(supplyInfo);
        Stage supplyStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        supplyStage.setScene(supplyInfoScene);
        supplyStage.show();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
