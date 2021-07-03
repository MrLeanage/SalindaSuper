/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Supplier;

import DBConnect.DBConnection;
import Supplier.InfoView.SupplyView;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author nimesh :)
 */
public class SupplierinfoviewController implements Initializable {

    @FXML
    private AnchorPane rootpane;

    /*public SupplierinfoviewController() {
        this.supplierhomeController = FXCollections.ObservableArrayList();
    }*/

    /**
     * Initializes the controller class.
     */
    @FXML
    private void goSupplierHome(ActionEvent event) throws IOException {
        
        AnchorPane pane = FXMLLoader.load(getClass().getResource("supplierhome.fxml"));
        rootpane.getChildren().setAll(pane);
    }

    @FXML
    private void goSupplierUpdate(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("supplierupdate.fxml"));
        rootpane.getChildren().setAll(pane);
    }

    @FXML
    private void goSupplierDelete(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("supplierdelete.fxml"));
        rootpane.getChildren().setAll(pane);
    }

    @FXML
    private void goSupplierAdd(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("supplieradd.fxml"));
        rootpane.getChildren().setAll(pane);
    }

    @FXML
    private void goSupplierView(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("supplierinfoview.fxml"));
        rootpane.getChildren().setAll(pane);
    }

    @FXML
    private TextField searchBox;
    ObservableList<SupplyView> supplierhomeController;

    @FXML
    private TableView<SupplyView> SupplyViewTable;
    @FXML
    private TableColumn<SupplyView, Integer> SIDColumn;
    @FXML
    private TableColumn<SupplyView, String> SFirstNameColumn;
    @FXML
    private TableColumn<SupplyView, String> SCityColumn;
    @FXML
    private TableColumn<SupplyView, Integer> SPhone1Column;
    @FXML
    private TableColumn<SupplyView, String> SEmailColumn;

    //initialize observable list to hold out database data
    private ObservableList<SupplyView> data;
    private DBConnection dbcon;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        dbcon = new DBConnection();
        Connection conn = dbcon.Connect();
    }

    @FXML
    private void loadDataFromDB(ActionEvent event) {
        try {
            Connection conn = dbcon.Connect();
            data = FXCollections.observableArrayList();
            // Execute query and store result in a resultset
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM supplier");
            while (rs.next()) {
                data.add(new SupplyView(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getInt(9), rs.getString(10), rs.getString(11)));
                //SID              FirstName        SecondName         Address1         Address2        City            Province        Phone1          Phone2          Email           RegDate     ////
            }

        } catch (SQLException ex) {
            System.err.println("Error Occured:" + ex);
        }

        //Setting cell value factory to table view
        SIDColumn.setCellValueFactory(new PropertyValueFactory<>("SID"));
        SFirstNameColumn.setCellValueFactory(new PropertyValueFactory<>("SFirstName"));
        SCityColumn.setCellValueFactory(new PropertyValueFactory<>("SCity"));
        SPhone1Column.setCellValueFactory(new PropertyValueFactory<>("SPhone1"));
        SEmailColumn.setCellValueFactory(new PropertyValueFactory<>("SEmail"));

        SupplyViewTable.setItems(null);
        SupplyViewTable.setItems(data);

    }
    

  
}
