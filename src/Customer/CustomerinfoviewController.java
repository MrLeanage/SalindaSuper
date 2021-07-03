/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Customer;

import DBConnect.DBConnection;
import Customer.InfoView.CustomerView;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Hansini
 */
public class CustomerinfoviewController implements Initializable {

@FXML
private AnchorPane rootpane;
//    private TableColumn<?, ?> CIDColumn;
//    private TableColumn<?, ?> CFirstNameColumn;
//    private TableColumn<?, ?> CCityColumn;
//    private TableColumn<?, ?> CPhone1Column;
//    private TableColumn<?, ?> CEmailColumn;*/

    /**
     * Initializes the controller class.
     */
    @FXML
    private void goCustomerHome(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("CustomerHome.fxml"));
        rootpane.getChildren().setAll(pane);
    }
 @FXML
    private void goCustomerUpdate(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Customerupdate2.fxml"));
        rootpane.getChildren().setAll(pane);
    }
 @FXML
    private void goCustomerDelete(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("CustomerDelete.fxml"));
        rootpane.getChildren().setAll(pane);
    }
 @FXML
    private void goCustomerAdd(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("CustomerAdd.fxml"));
        rootpane.getChildren().setAll(pane);
    }
 @FXML
    private void goCustomerView(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Customerinfoview.fxml"));
        rootpane.getChildren().setAll(pane);
    }
    
    @FXML
    private TableView<CustomerView> CustomerViewTable;
    @FXML
    private TableColumn<CustomerView, Integer> CIDColumn;
    @FXML
    private TableColumn<CustomerView, String> CFirstNameColumn;
    @FXML
    private TableColumn<CustomerView, String> CCityColumn;
    @FXML
    private TableColumn<CustomerView, Integer> CPhone1Column;
    @FXML
    private TableColumn<CustomerView, String> CEmailColumn;

    //initialize observable list to hold out database data
    private ObservableList<CustomerView> data;
    private DBConnection db;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        db = new DBConnection();
        Connection conn = db.Connect();
    }
    @FXML
    private void loadDataFromDB(ActionEvent event) {
        try {
            Connection conn = db.Connect();
            data = FXCollections.observableArrayList();
            // Execute query and store result in a resultset
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM customer");
            while (rs.next()) {
                data.add(new CustomerView(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getInt(9), rs.getString(10), rs.getString(11)));
                                        //CID              FirstName        SecondName         Address1         Address2        City            Province        Phone1          Phone2          Email           RegDate     ////
            }

        } catch (SQLException ex) {
            System.err.println("Error Occured:" + ex);
        }

        //Setting cell value factory to table view
        CIDColumn.setCellValueFactory(new PropertyValueFactory<>("CID"));
        CFirstNameColumn.setCellValueFactory(new PropertyValueFactory<>("CFirstName"));
        CCityColumn.setCellValueFactory(new PropertyValueFactory<>("CCity"));
        CPhone1Column.setCellValueFactory(new PropertyValueFactory<>("CPhone1"));
        CEmailColumn.setCellValueFactory(new PropertyValueFactory<>("CEmail"));

        CustomerViewTable.setItems(null);
        CustomerViewTable.setItems(data);

    }
}
