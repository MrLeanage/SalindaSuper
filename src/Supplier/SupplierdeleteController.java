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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author nimesh :)
 */
public class SupplierdeleteController implements Initializable {

    @FXML
    private AnchorPane rootpane;

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private void goSupplierAdd(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("supplieradd.fxml"));
        rootpane.getChildren().setAll(pane);
    }

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
    private void goSupplierView(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("supplierinfoview.fxml"));
        rootpane.getChildren().setAll(pane);
    }

    @FXML
    private void goSupplierDelete(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("supplierdelete.fxml"));
        rootpane.getChildren().setAll(pane);
    }
    
    private Integer sID;
    private SupplyView SupplyID = new SupplyView();
    private DBConnection dbcon;
    private ObservableList<SupplyView> data;
    private PreparedStatement ps;
    
    @FXML
    private TableView<SupplyView> DelSTable;
    @FXML
    private TableColumn<SupplyView, Integer> SIDColumn;
    @FXML
    private TableColumn<SupplyView, String> SNameColumn;
    @FXML
    private TableColumn<SupplyView, Integer> SPhone1Column;
    @FXML
    private TableColumn<SupplyView, String> SEmailColumn;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        dbcon = new DBConnection();
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
        SNameColumn.setCellValueFactory(new PropertyValueFactory<>("SFirstName"));
        SPhone1Column.setCellValueFactory(new PropertyValueFactory<>("SPhone1"));
        SEmailColumn.setCellValueFactory(new PropertyValueFactory<>("SEmail"));

        DelSTable.setItems(null);
        DelSTable.setItems(data);

    }

    @FXML
    public void getID() {

        try {
            SupplyID = DelSTable.getSelectionModel().getSelectedItem();
            sID = SupplyID.getSID();
            //searchButton.setText(eID.toString());
        } catch (Exception e) {
            System.out.println("Exception in mouseclick : " + e);
        }
    }

    @FXML
    public void deleteDataFromDatabase(ActionEvent event) {
        //ExpenseView.getItems().removeAll(ExpenseView.getSelectionModel().getSelectedItem());

        ps = null;
        ResultSet rs = null;
        //Float eAmount = Float.parseFloat(AddAmountBtn.getText());

        //String eTitle = Entertitleexpenses.getText();
        Connection conn = dbcon.Connect();
        

        int ID = sID;

        try {

            ps = conn.prepareStatement("DELETE FROM supplier WHERE SID = ? ");
            ps.setInt(1, ID);

            ps.executeUpdate();
        } catch (Exception ex) {
            System.out.println("Exception in Deleting : " + ex);
            System.err.println("Error Occured:" + ex);

        } finally {
            //ps.execute();
            //ps.close();
        }
        
        refresh();
        
    }

    @FXML
    public void refresh() {
        data.clear();
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
        SNameColumn.setCellValueFactory(new PropertyValueFactory<>("SFirstName"));
        SPhone1Column.setCellValueFactory(new PropertyValueFactory<>("SPhone1"));
        SEmailColumn.setCellValueFactory(new PropertyValueFactory<>("SEmail"));

        DelSTable.setItems(null);
        DelSTable.setItems(data);
        
        JOptionPane.showMessageDialog(null, "Data Deleted Successfuly");
    }
    
}
