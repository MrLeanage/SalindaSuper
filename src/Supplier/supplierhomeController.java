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
 *
 * @author nimesh
 */
public class supplierhomeController implements Initializable {
    @FXML
    private void loadAdminHome(ActionEvent event) throws IOException {
        
        Parent productView = FXMLLoader.load(getClass().getResource("/AppHome/adminhome.fxml"));
        Scene productViewScene = new Scene(productView);
        Stage productStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        productStage.setScene(productViewScene);
        productStage.show();
    }
     @FXML
    private AnchorPane rootpane;
    
    @FXML
    private void goInfoView(ActionEvent event) throws IOException{
        AnchorPane pane = FXMLLoader.load(getClass().getResource("supplierinfoview.fxml"));
        rootpane.getChildren().setAll(pane);
    }
    @FXML
     private void goTransaction(ActionEvent event) throws IOException{
        AnchorPane pane = FXMLLoader.load(getClass().getResource("suppliertransaction.fxml"));
        rootpane.getChildren().setAll(pane);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
