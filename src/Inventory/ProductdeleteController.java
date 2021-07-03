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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author dulshan
 */
public class ProductdeleteController implements Initializable {

    private Integer pID = 0;
    private ProductView ProductID = new ProductView();
    private DBConnection dbcon;
    private ObservableList<ProductView> data;
    private PreparedStatement ps;
    @FXML
    private AnchorPane rootpane;
    @FXML
    private TableView<ProductView> pDTable;
    @FXML
    private TableColumn<ProductView, Integer> pDTableID;
    @FXML
    private TableColumn<ProductView, String> pDTableName;
    @FXML
    private TableColumn<ProductView, String> pDTableUnits;
    @FXML
    private TableColumn<ProductView, String> pDTableSupplier;
    @FXML
    private TableColumn<ProductView, String> pDTableBrand;

    /**
     * Initializes the controller class.
     */
    //Initialize observable list to hold out database data
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        dbcon = new DBConnection();
        AutoLoadData();
    }  
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
    private void LoadDatafromDatabaseToDelete(ActionEvent event) {
        
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
                successMsg.setContentText("SQL Exception occured : "+ ex );
                successMsg.showAndWait();
        }
        
        
        
        //Setting cell value factory to table view
        pDTableID.setCellValueFactory(new PropertyValueFactory<>("pID"));
        pDTableName.setCellValueFactory(new PropertyValueFactory<>("pName"));
        pDTableUnits.setCellValueFactory(new PropertyValueFactory<>("pUnits"));
        pDTableSupplier.setCellValueFactory(new PropertyValueFactory<>("pSupplier"));
        pDTableBrand.setCellValueFactory(new PropertyValueFactory<>("pBrand"));
        
        
        pDTable.setItems(null);
        pDTable.setItems(data);
        
        
    }
    @FXML
    public void refresh(){
        data.clear();
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
                successMsg.setContentText("SQL Exception occured : "+ ex );
                successMsg.showAndWait();
        }
        
        
        
        //Setting cell value factory to table view
        pDTableID.setCellValueFactory(new PropertyValueFactory<>("pID"));
        pDTableName.setCellValueFactory(new PropertyValueFactory<>("pName"));
        pDTableUnits.setCellValueFactory(new PropertyValueFactory<>("pUnits"));
        pDTableSupplier.setCellValueFactory(new PropertyValueFactory<>("pSupplier"));
        pDTableBrand.setCellValueFactory(new PropertyValueFactory<>("pBrand"));
        
        
        pDTable.setItems(null);
        pDTable.setItems(data);
        
        
    }
    @FXML
    public void AutoLoadData(){
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
                successMsg.setContentText("SQL Exception occured : "+ ex );
                successMsg.showAndWait();
        }
        
        
        
        //Setting cell value factory to table view
        pDTableID.setCellValueFactory(new PropertyValueFactory<>("pID"));
        pDTableName.setCellValueFactory(new PropertyValueFactory<>("pName"));
        pDTableUnits.setCellValueFactory(new PropertyValueFactory<>("pUnits"));
        pDTableSupplier.setCellValueFactory(new PropertyValueFactory<>("pSupplier"));
        pDTableBrand.setCellValueFactory(new PropertyValueFactory<>("pBrand"));
        
        
        pDTable.setItems(null);
        pDTable.setItems(data);
        
        
    }
    @FXML 
    public void getID(){
        
        try{
         ProductID = pDTable.getSelectionModel().getSelectedItem();
         pID = ProductID.getPID();
         //searchButton.setText(eID.toString());
        }catch(Exception ex){
            Alert successMsg = new Alert(Alert.AlertType.INFORMATION);
                successMsg.setTitle("Error!..");
                successMsg.setHeaderText(null);
                successMsg.setContentText("Exception in mouseclick :Please Select a Valid Row");
                successMsg.showAndWait();
        }
    }
    
   
    @FXML
    public void deleteDataFromDatabase(ActionEvent event) throws IOException{
        
        int ID = 0;
        ID = pID;
        if(ID != 0){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirm Your Selected Deleting");
        alert.setHeaderText(null);
        alert.setContentText("Do you want to delete selected Item??...");
        Optional <ButtonType> action = alert.showAndWait();
        
        if(action.get() == ButtonType.OK){
            
            ps = null;
            ResultSet rs = null;    
            Connection conn = dbcon.Connect();
                   
            
            //int ID = catID;
            //System.out.println(catID);
        
            try{
           
            ps = conn.prepareStatement("DELETE FROM product WHERE PID = ? ");
            ps.setInt(1, ID);
         
                ps.executeUpdate();
                //JOptionPane.showMessageDialog(null, "Data Deleted");
                Alert successMsg = new Alert(Alert.AlertType.INFORMATION);
                successMsg.setTitle("SuccessFul");
                successMsg.setHeaderText(null);
                successMsg.setContentText("Product Deleted Successfully");
                successMsg.showAndWait();
                
        
          }catch (Exception ex) {
            Alert successMsg = new Alert(Alert.AlertType.INFORMATION);
                successMsg.setTitle("Error!..");
                successMsg.setHeaderText("Error Occured" +ex);
                successMsg.setContentText("Exception in Deleting : " + ex );
                successMsg.showAndWait();
            
            
        }finally{
           // ps.execute();
            //ps.close();
        }
            refresh();
            
        }
    }else{
            //JOptionPane.showMessageDialog(null, "Please Select the row from tha table to delete!.."); 
            Alert successMsg = new Alert(Alert.AlertType.INFORMATION);
                
                successMsg.setTitle("Select a row..");
                successMsg.setHeaderText(null);
                successMsg.setContentText("Please Select a row from Table to Delete....");
                
                successMsg.showAndWait();
        }
    }
    
    
}
