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
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javax.swing.JOptionPane;


/**
 * FXML Controller class
 *
 * @author dulshan
 */
public class ProductupdateController implements Initializable {

    
    private Integer pID = 0;
    private ProductView ProductID = new ProductView();
    ProductView product;
    private DBConnection dbcon;
    private ObservableList<ProductView> data;
    private PreparedStatement ps;
//    Connection conn = dbcon.Connect(); 
   // private ProductView ProductList = new ProductView();
    
    
    
    //Table IDs
    

 
///////////////////
    @FXML
    private AnchorPane rootpane;
    
    @FXML
    private TextField pUpdateName;
    
    @FXML
    private TextField pUpdateBlocks;

    @FXML
    private TextField pUpdateUnits;

    @FXML
    private TextField pUpdateSDiscounts;

    @FXML
    private TextField pUpdateSellingPrice;

    @FXML
    private TextField pUpdateBuyingPrice;

    @FXML
    private TextField pUpdateWeight;

    @FXML
    private DatePicker pUpdateMDate;

    @FXML
    private DatePicker pUpdateExpDate;
    
    
   

    

    @FXML
    private TableView<ProductView> pUpdateColumnTable;

    @FXML
    private TableColumn<ProductView, Integer> pUpdateColumnID;

    @FXML
    private TableColumn<ProductView, String> pUpdateColumnName;

    @FXML
    private TableColumn<ProductView, Integer> pUpdateColumnUnits;
    
    @FXML
    private TableColumn<ProductView, Integer> pUpdateColumnBlocks;

    @FXML
    private TableColumn<ProductView, Float> pUpdateColumnWeight;

    @FXML
    private TableColumn<ProductView, String> pUpdateColumnSupplier;
    
    @FXML
    private TableColumn<ProductView, Float> pUpdateColumnDiscounts;

    @FXML
    private TableColumn<ProductView, Float> pUpdateColumnMPrice;

    @FXML
    private TableColumn<ProductView, String> pUpdateColumnExpDate;
    
    //Validation Labels
    @FXML
    private Label pUpdateLabelBlocks;

    @FXML
    private Label pUpdateLabelUnits;

    @FXML
    private Label pUpdateLabelSDiscounts;

    @FXML
    private Label pUpdateLabelWeight;

    @FXML
    private Label pUpdateLabelMDate;

    @FXML
    private Label pUpdateLabelExpDate;

      @FXML
    private Label pUpdateLabelName;

    @FXML
    private Label pUpdateLabelBPrice;

    @FXML
    private Label pUpdateLabelSPrice;
    

    @FXML
    private Text SearchtableBox;
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODOprivate DBConnection dbcon;
        
       dbcon = new DBConnection(); 
       loadAutomatically();
      // Connection conn = dbcon.Connect(); 
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
    private void ClearForm(){
        pUpdateName.clear();
        pUpdateBlocks.clear();
        pUpdateUnits.clear();
        pUpdateSDiscounts.clear();
        pUpdateWeight.clear();
        pUpdateSellingPrice.clear();
        pUpdateBuyingPrice.clear();
        pUpdateMDate.getEditor().clear();
        pUpdateExpDate.getEditor().clear();
        
    }
     @FXML
    private void EmptyForm(ActionEvent event){
        pUpdateName.clear();
        pUpdateBlocks.clear();
        pUpdateUnits.clear();
        pUpdateSDiscounts.clear();
        pUpdateWeight.clear();
        pUpdateSellingPrice.clear();
        pUpdateBuyingPrice.clear();
        pUpdateMDate.getEditor().clear();
        pUpdateExpDate.getEditor().clear();
        
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
                successMsg.setContentText("Exception in mouseclick : "+ ex );
                successMsg.showAndWait();
        }
        
        
        
        //Setting cell value factory to table view
        pUpdateColumnID.setCellValueFactory(new PropertyValueFactory<>("pID"));
        pUpdateColumnName.setCellValueFactory(new PropertyValueFactory<>("pName"));
        pUpdateColumnUnits.setCellValueFactory(new PropertyValueFactory<>("pUnits"));
        pUpdateColumnBlocks.setCellValueFactory(new PropertyValueFactory<>("pBlocks"));
        pUpdateColumnWeight.setCellValueFactory(new PropertyValueFactory<>("pWeight"));
        pUpdateColumnSupplier.setCellValueFactory(new PropertyValueFactory<>("pSupplier"));
        pUpdateColumnDiscounts.setCellValueFactory(new PropertyValueFactory<>("pSDiscounts"));
        pUpdateColumnMPrice.setCellValueFactory(new PropertyValueFactory<>("pSPrice"));
        pUpdateColumnExpDate.setCellValueFactory(new PropertyValueFactory<>("pExpDate"));
        
        
        pUpdateColumnTable.setItems(null);
        pUpdateColumnTable.setItems(data);
        
        
    }
    @FXML
    private void loadAutomatically() {
        
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
                successMsg.setContentText("Exception in mouseclick : "+ ex );
                successMsg.showAndWait();
        }
        
        
        
        //Setting cell value factory to table view
        pUpdateColumnID.setCellValueFactory(new PropertyValueFactory<>("pID"));
        pUpdateColumnName.setCellValueFactory(new PropertyValueFactory<>("pName"));
        pUpdateColumnUnits.setCellValueFactory(new PropertyValueFactory<>("pUnits"));
        pUpdateColumnBlocks.setCellValueFactory(new PropertyValueFactory<>("pBlocks"));
        pUpdateColumnWeight.setCellValueFactory(new PropertyValueFactory<>("pWeight"));
        pUpdateColumnSupplier.setCellValueFactory(new PropertyValueFactory<>("pSupplier"));
        pUpdateColumnDiscounts.setCellValueFactory(new PropertyValueFactory<>("pSDiscounts"));
        pUpdateColumnMPrice.setCellValueFactory(new PropertyValueFactory<>("pSPrice"));
        pUpdateColumnExpDate.setCellValueFactory(new PropertyValueFactory<>("pExpDate"));
        
        
        pUpdateColumnTable.setItems(null);
        pUpdateColumnTable.setItems(data);
        
        
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
                successMsg.setContentText("Exception in mouseclick : "+ ex );
                successMsg.showAndWait();
        }
        
        
        
        //Setting cell value factory to table view
        pUpdateColumnID.setCellValueFactory(new PropertyValueFactory<>("pID"));
        pUpdateColumnName.setCellValueFactory(new PropertyValueFactory<>("pName"));
        pUpdateColumnUnits.setCellValueFactory(new PropertyValueFactory<>("pUnits"));
        pUpdateColumnBlocks.setCellValueFactory(new PropertyValueFactory<>("pBlocks"));
        pUpdateColumnWeight.setCellValueFactory(new PropertyValueFactory<>("pWeight"));
        pUpdateColumnSupplier.setCellValueFactory(new PropertyValueFactory<>("pSupplier"));
        pUpdateColumnDiscounts.setCellValueFactory(new PropertyValueFactory<>("pSDiscounts"));
        pUpdateColumnMPrice.setCellValueFactory(new PropertyValueFactory<>("pSPrice"));
        pUpdateColumnExpDate.setCellValueFactory(new PropertyValueFactory<>("pExpDate"));
        
        
        pUpdateColumnTable.setItems(null);
        pUpdateColumnTable.setItems(data);
        
        
    }
   @FXML 
    public void loadSelectdDatafromDatabase() throws ParseException{
        
        try{
         ProductID = pUpdateColumnTable.getSelectionModel().getSelectedItem();
        
         pID = ProductID.getPID();
          //System.out.println(pID);
         //searchButton.setText(eID.toString());
        }catch(Exception ex){
            
            Alert successMsg = new Alert(Alert.AlertType.INFORMATION);
                successMsg.setTitle("Error!..");
                successMsg.setHeaderText(null);
                successMsg.setContentText("Exception in mouseclick : "+ ex );
                successMsg.showAndWait();
        }  
        int ID =0;
        ID = pID;
        
        String setPName = null;
        Integer setPUnits = null;
        Integer setPBlocks = null;
        float setPWeight = 0;
        float setPBPrice = 0;
        float setPSPrice = 0;
        float setPSDiscounts = 0;
        String setPMDate = null;
        String setPExpDate = null;
        
        
        String query = "SELECT * FROM product where PID = '"+ID+"'";
        
        try {
            Connection conn = dbcon.Connect(); 
            data = FXCollections.observableArrayList();
            // Execute query and store result in a resultset
            ResultSet rs = conn.createStatement().executeQuery(query);
           while (rs.next()) {
               
               data.add(new ProductView(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getFloat(5), rs.getFloat(6), rs.getFloat(7), rs.getFloat(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15), rs.getString(16), rs.getString(17)));
                   // public ProductView(String pID, String pName, Integer pUnits, Integer pBlocks, Float pWeight, Float pSDiscounts, Float pBPrice, Float pSPrice, String pMDate, String pExpDate, String pDADate, String pModDate, String pADate) {

               
                setPName = rs.getString(2);
                setPUnits = rs.getInt(3);
                setPBlocks = rs.getInt(4);
                setPWeight = rs.getFloat(5);
                setPBPrice = rs.getFloat(7);
                setPSPrice = rs.getFloat(8);
                setPSDiscounts = rs.getFloat(6);
                setPMDate = rs.getString(9);
                setPExpDate = rs.getString(10);
                
            }
           LocalDate pMDate = LocalDate.parse(setPMDate);
           LocalDate pExpDate = LocalDate.parse(setPExpDate);
           
           pUpdateName.setText(setPName);
           pUpdateUnits.setText(String.valueOf(setPUnits));
           pUpdateBlocks.setText(String.valueOf(setPBlocks));
           pUpdateWeight.setText(String.valueOf(setPWeight));
           pUpdateBuyingPrice.setText(String.valueOf(setPBPrice));
           pUpdateSellingPrice.setText(String.valueOf(setPSPrice));
           pUpdateSDiscounts.setText(String.valueOf(setPSDiscounts));
           pUpdateMDate.setValue(pMDate);
           pUpdateExpDate.setValue(pExpDate);
           // data.add(new ProductView(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getFloat(5), rs.getFloat(6), rs.getFloat(7), rs.getFloat(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15), rs.getString(16), rs.getString(17)));
                   // public ProductView(String pID, String pName, Integer pUnits, Integer pBlocks, Float pWeight, Float pSDiscounts, Float pBPrice, Float pSPrice, String pMDate, String pExpDate, String pDADate, String pModDate, String pADate) {
                   
            
        } catch (SQLException ex) {
            
            Alert successMsg = new Alert(Alert.AlertType.INFORMATION);
                successMsg.setTitle("Error!..");
                successMsg.setHeaderText(null);
                successMsg.setContentText("Exception in mouseclick : "+ ex );
                successMsg.showAndWait();
        }
           
            
        finally{
           // ps.execute();
            //ps.close();
        }
            
        
        
    }
    
    @FXML
    private void UpdateProductsToDatabase(ActionEvent event) throws SQLException {
        
         if(Validation.DataValidation.TextFieldNotEmpty(pUpdateName, pUpdateLabelName, "Name is required..")
        
   || Validation.DataValidation.TextFieldNotEmpty(pUpdateBlocks, pUpdateLabelBlocks, "Block Amount Required")
   || Validation.DataValidation.TextFieldNotEmpty(pUpdateUnits, pUpdateLabelUnits, "Block Amount Required")
   || Validation.DataValidation.TextFieldNotEmpty(pUpdateWeight, pUpdateLabelWeight, "Weight or Volume Required")
   || Validation.DataValidation.TextFieldNotEmpty(pUpdateSellingPrice, pUpdateLabelSPrice, "Selling Price Required")
   || Validation.DataValidation.TextFieldNotEmpty(pUpdateBuyingPrice, pUpdateLabelBPrice, "Buying Price Required")
   || Validation.DataValidation.TextFieldNotEmpty(pUpdateSDiscounts, pUpdateLabelSDiscounts, "Supplier Discounts Required")
   
        ){
             if((pUpdateName.getText().length()>0)
           &&(pUpdateBlocks.getText().length()>0)
           &&(pUpdateUnits.getText().length()>0)
           &&(pUpdateWeight.getText().length()>0)
           &&(pUpdateSellingPrice.getText().length()>0)
           &&(pUpdateBuyingPrice.getText().length()>0)
           &&(pUpdateSDiscounts.getText().length()>0))
          {
              
          
         
        
        String pName = pUpdateName.getText();
        Integer pBlocks = Integer.parseInt(pUpdateBlocks.getText());
        Integer pUnits = Integer.parseInt(pUpdateUnits.getText());
        Float pDiscount = Float.parseFloat(pUpdateSDiscounts.getText());
        Float pWeight = Float.parseFloat(pUpdateWeight.getText());
        Float pMaxSellingPrice = Float.parseFloat(pUpdateSellingPrice.getText());
        Float pBuyingPrice = Float.parseFloat(pUpdateBuyingPrice.getText());
        LocalDate pMDate = pUpdateMDate.getValue();
        String pSMDate = pMDate.toString();
        LocalDate pExpDate = pUpdateExpDate.getValue();
        String pSExpDate = pExpDate.toString();
        
        String query = "UPDATE product SET PName = ?, PUnitsPerBlock = ?, PNoOfBlocks = ?, PWeightPerBlock = ?, PSupplierDiscounts = ?, PBuyingPricePerUnit = ?, PMaxSellingPricePerUnit = ?, PManufacturingDate = ?, PExpireDate = ?  WHERE PID =?";
        ps = null;
        try {
            Connection conn = dbcon.Connect();
            ps = conn.prepareStatement(query);
            ps.setString(1, pName);
            ps.setInt(2, pUnits);
            ps.setInt(3, pBlocks);
            ps.setFloat(4, pWeight);
            ps.setFloat(5, pDiscount);
            ps.setFloat(6, pBuyingPrice);
            ps.setFloat(7, pMaxSellingPrice);
            ps.setString(8, pSMDate);
            ps.setString(9, pSExpDate);
            ps.setInt(10, pID);
            
            ps.execute();
            
            
            
            Alert successMsg = new Alert(Alert.AlertType.INFORMATION);
                successMsg.setTitle("SuccessFull..");
                successMsg.setHeaderText(null);
                successMsg.setContentText("Data Updated Successfully");
                successMsg.showAndWait();
            refresh();
        } catch (SQLException ex) {
            System.err.println("Error Occured:" +ex);
            JOptionPane.showMessageDialog(null, "Data  not Updated, Try Again");
        }
        
        
        
        finally{
            
            ps.close();
        }
        ClearForm();
         }else {
                 
                 if(pUpdateName.getText().length()==0){
                     pUpdateLabelName.setText("Name is required..");
                 }
                 if(pUpdateBlocks.getText().length()==0){
                     pUpdateLabelBlocks.setText("Block Amount Required");
                 }
                 if(pUpdateUnits.getText().length()==0){
                     pUpdateLabelUnits.setText("Unit Amount Required");
                 }
                 if(pUpdateWeight.getText().length()==0){
                     pUpdateLabelWeight.setText("Weight or Volume Required");
                 }
                 if(pUpdateSellingPrice.getText().length()==0){
                     pUpdateLabelSPrice.setText("Selling Price Required");
                 }
                 if(pUpdateBuyingPrice.getText().length()==0){
                     pUpdateLabelBPrice.setText("Buying Price Required");
                 }
             }
    }
         
    }
    @FXML
    public void clearName(){
        pUpdateLabelName.setText("");
    }
    @FXML
    public void clearBlocks(){
        pUpdateLabelBlocks.setText("");
    }
    @FXML
    public void clearUnits(){
        pUpdateLabelUnits.setText("");
    }
    @FXML
    public void clearWeight(){
        pUpdateLabelWeight.setText("");
    }
    @FXML
    public void clearSellingPrice(){
        pUpdateLabelSPrice.setText("");
    }
    @FXML
    public void clearBuyingPrice(){
        pUpdateLabelBPrice.setText("");
    }
    
}
    
