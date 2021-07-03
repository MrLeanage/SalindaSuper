/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inventory;

import DBConnect.DBConnection;
import Inventory.Product.ProductDetails.ProductView;
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
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author dulshan
 */
public class ProductController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private AnchorPane rootpane;
    

    @FXML
    private void loadview(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("product.fxml"));
        rootpane.getChildren().setAll(pane);
    }
    @FXML
    private void loadadd(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("productadd.fxml"));
        rootpane.getChildren().setAll(pane);
    }
    @FXML
    private void loadupdate(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("productupdate.fxml"));
        rootpane.getChildren().setAll(pane);
    }
    @FXML
    private void loaddelete(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("productdelete.fxml"));
        rootpane.getChildren().setAll(pane);
    }
    @FXML
    private void loadInventoryHome(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("inventoryhome.fxml"));
        rootpane.getChildren().setAll(pane);
    }
    
    @FXML
    private TableView<ProductView> ViewProductTable;
    @FXML
    private TableColumn<ProductView, Integer> PIDColumn;
    @FXML
    private TableColumn<ProductView, String> PNameColumn;
    @FXML
    private TableColumn<ProductView, Integer> PUnitsBlocksColumn;
    @FXML
    private TableColumn<ProductView, Integer> PWeightColumn;
    @FXML
    private TableColumn<ProductView, Float> PBPriceColumn;
    @FXML
    private TableColumn<ProductView, Float> PMPriceColumn;
    @FXML
    private TableColumn<ProductView, String> PMDateColumn;
    @FXML
    private TableColumn<ProductView, String> PExpDateColumn;
    

    //Initialize observable list to hold out database data
    private DBConnection dbcon;
    private ObservableList<ProductView> data;
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        dbcon = new DBConnection();
        AutoLoadData();
    } 
    
    
    @FXML
    private void loadDatafromDatabase(ActionEvent event) {
        
        try {
            Connection conn = dbcon.Connect();
            data = FXCollections.observableArrayList();
            // Execute query and store result in a resultset
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM product");
            while (rs.next()) {
                data.add(new ProductView(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getFloat(5), rs.getFloat(6), rs.getFloat(7), rs.getFloat(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15), rs.getString(16), rs.getString(17)));
                   // public ProductView(String pID, String pName, Integer pUnits, Integer pBlocks, Float pWeight, Float pSDiscounts, Float pBPrice, Float pSPrice, String pMDate, String pExpDate, String pDADate, String pModDate, String pADate) {

            }
            
        } catch (SQLException ex) {
            
            Alert successMsg = new Alert(Alert.AlertType.INFORMATION);
                successMsg.setTitle("Error!..");
                successMsg.setHeaderText(null);
                successMsg.setContentText("Data  not Inserted, Try Again! SQL Exception in : "+ ex );
                successMsg.showAndWait();
        
        }
        
        
        
        //Setting cell value factory to table view
        PIDColumn.setCellValueFactory(new PropertyValueFactory<>("pID"));
        PNameColumn.setCellValueFactory(new PropertyValueFactory<>("pName"));
        PUnitsBlocksColumn.setCellValueFactory(new PropertyValueFactory<>("pUnits"));
        PWeightColumn.setCellValueFactory(new PropertyValueFactory<>("pWeight"));
        PBPriceColumn.setCellValueFactory(new PropertyValueFactory<>("pBPrice"));
        PMPriceColumn.setCellValueFactory(new PropertyValueFactory<>("pSPrice"));
        PMDateColumn.setCellValueFactory(new PropertyValueFactory<>("pMDate"));
        PExpDateColumn.setCellValueFactory(new PropertyValueFactory<>("pExpDate"));
        
        
        ViewProductTable.setItems(null);
        ViewProductTable.setItems(data);
        
        
    }
    @FXML
    private void AutoLoadData() {
        
        try {
            Connection conn = dbcon.Connect();
            data = FXCollections.observableArrayList();
            // Execute query and store result in a resultset
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM product");
            while (rs.next()) {
                data.add(new ProductView(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getFloat(5), rs.getFloat(6), rs.getFloat(7), rs.getFloat(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15), rs.getString(16), rs.getString(17)));
                   // public ProductView(String pID, String pName, Integer pUnits, Integer pBlocks, Float pWeight, Float pSDiscounts, Float pBPrice, Float pSPrice, String pMDate, String pExpDate, String pDADate, String pModDate, String pADate) {

            }
            
        } catch (SQLException ex) {
            
            Alert successMsg = new Alert(Alert.AlertType.INFORMATION);
                successMsg.setTitle("Error!..");
                successMsg.setHeaderText(null);
                successMsg.setContentText("SQL Exception in : "+ ex );
                successMsg.showAndWait();
        
        }
        
        
        
        //Setting cell value factory to table view
        PIDColumn.setCellValueFactory(new PropertyValueFactory<>("pID"));
        PNameColumn.setCellValueFactory(new PropertyValueFactory<>("pName"));
        PUnitsBlocksColumn.setCellValueFactory(new PropertyValueFactory<>("pUnits"));
        PWeightColumn.setCellValueFactory(new PropertyValueFactory<>("pWeight"));
        PBPriceColumn.setCellValueFactory(new PropertyValueFactory<>("pBPrice"));
        PMPriceColumn.setCellValueFactory(new PropertyValueFactory<>("pSPrice"));
        PMDateColumn.setCellValueFactory(new PropertyValueFactory<>("pMDate"));
        PExpDateColumn.setCellValueFactory(new PropertyValueFactory<>("pExpDate"));
        
        
        ViewProductTable.setItems(null);
        ViewProductTable.setItems(data);
        
        
    }
 
}
