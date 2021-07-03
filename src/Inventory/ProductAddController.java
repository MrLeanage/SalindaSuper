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
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author dulshan
 */
public class ProductAddController implements Initializable {
        
    private DBConnection dbcon;
    private ObservableList<ProductView> data;
    private PreparedStatement ps;

    @FXML
    private AnchorPane rootpane;
    //Text Boxes
    @FXML
    private TextField pAddName;
    @FXML
    private TextField pAddBlocks;
    @FXML
    private TextField pAddUnits;
    @FXML
    private TextField pAddDiscounts;
    @FXML
    private TextField pAddSellingPrice;
    @FXML
    private TextField pAddBuyingPrice;
    @FXML
    private TextField pAddWeight;
    @FXML
    private DatePicker pAddMDate;
    @FXML
    private DatePicker pAddExpDate;
   // LocalDate pLDate = pAddMDate.getValue();
   // String pSDate = pLDate.toString();
    //@FXML
    //private TextField pVSMDate.(pVSMDate);
   // pVSMDate.setText(pSDate);
    
    
    //Combo boxes
    @FXML
    private ComboBox<String> pAddSupplier;

    @FXML
    private ComboBox<String> pAddBrand;

    @FXML
    private ComboBox<String> pAddCategory;
    
    //Text boxes to add Data
    @FXML
    private Label pLableBlocks;

    @FXML
    private Label pLableSDiscount;

    @FXML
    private Label pLableSellingPrice;

    @FXML
    private Label pLableMDate;

    @FXML
    private Label pLableUnits;

    @FXML
    private Label pLableWeight;

    @FXML
    private Label pLableBuyingPrice;

    @FXML
    private Label pLableExpDate;

    @FXML
    private Label pLableName;
    
    
      //  LocalDate VMDate = pAddMDate.getValue();
     //   String VSMDate = VMDate.toString();
       //LocalDate VExpDate = pAddExpDate.getValue();
      //  String VSExpDate = VExpDate.toString();
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        dbcon = new DBConnection();
        pAddSupplier.getItems().addAll("Supplier 1", "Supplier 2");
        pAddCategory.getItems().addAll("Category 1", "Category 2");
        pAddBrand.getItems().addAll("Brand 1", "Brand 2");
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
        pAddName.clear();
        pAddBlocks.clear();
        pAddUnits.clear();
        pAddDiscounts.clear();
        pAddWeight.clear();
        pAddSellingPrice.clear();
        pAddBuyingPrice.clear();
        pAddMDate.getEditor().clear();
        pAddExpDate.getEditor().clear();
        
    }
    @FXML
    public void clearName(){
        pLableName.setText("");
    }
    @FXML
    public void clearBlocks(){
        pLableBlocks.setText("");
    }
    @FXML
    public void clearUnits(){
        pLableUnits.setText("");
    }
    @FXML
    public void clearWeight(){
        pLableWeight.setText("");
    }
    @FXML
    public void clearSellingPrice(){
        pLableSellingPrice.setText("");
    }
    @FXML
    public void clearBuyingPrice(){
        pLableBuyingPrice.setText("");
    }
    
    
    
    @FXML
    private void AddProductsToDatabase(ActionEvent event) throws SQLException {
         if(Validation.DataValidation.TextFieldNotEmpty(pAddName, pLableName, "Name is required..")
        
   || Validation.DataValidation.TextFieldNotEmpty(pAddBlocks, pLableBlocks, "Block Amount Required")
   || Validation.DataValidation.TextFieldNotEmpty(pAddUnits, pLableUnits, "Block Amount Required")
   || Validation.DataValidation.TextFieldNotEmpty(pAddWeight, pLableWeight, "Weight or Volume Required")
   || Validation.DataValidation.TextFieldNotEmpty(pAddSellingPrice, pLableSellingPrice, "Selling Price Required")
   || Validation.DataValidation.TextFieldNotEmpty(pAddBuyingPrice, pLableBuyingPrice, "Buying Price Required")
        ){
        if((pAddName.getText().length()>0)
           &&(pAddBlocks.getText().length()>0)
           &&(pAddUnits.getText().length()>0)
           &&(pAddWeight.getText().length()>0)
           &&(pAddSellingPrice.getText().length()>0)
           &&(pAddBuyingPrice.getText().length()>0))
          {
             
          
        
        String pName = pAddName.getText();
        Integer pBlocks = Integer.parseInt(pAddBlocks.getText());
        Integer pUnits = Integer.parseInt(pAddUnits.getText());
        Float pDiscount = Float.parseFloat(pAddDiscounts.getText());
        Float pWeight = Float.parseFloat(pAddWeight.getText());
        Float pMaxSellingPrice = Float.parseFloat(pAddSellingPrice.getText());
        Float pBuyingPrice = Float.parseFloat(pAddBuyingPrice.getText());
        LocalDate pMDate = pAddMDate.getValue();
        String pSMDate = pMDate.toString();
        LocalDate pExpDate = pAddExpDate.getValue();
        String pSExpDate = pExpDate.toString();
      
       //if((pName || pBlocks || pUnits || pDiscount ||pWeight ||pMaxSellingPrice || pBuyingPrice || pSMDate || pSExpDate) = null)
       
      // if((pAddName.getText() != null)||(pAddBlocks.getText() != null)||(pAddUnits.getText() != null)||(pAddName.getText() != null)||(pAddMDate.getValue() != null)|| (pAddExpDate.getValue() != null)){
        
        String query = "INSERT INTO product (PName, PUnitsPerBlock, PNoOfBlocks, PWeightPerBlock, PSupplierDiscounts, PBuyingPricePerUnit, PMaxSellingPricePerUnit, PManufacturingDate, PExpireDate) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
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
            ps.execute();
            
            
            //JOptionPane.showMessageDialog(null, "Data Inserted");
            Alert successMsg = new Alert(Alert.AlertType.INFORMATION);
                successMsg.setTitle("SuccessFul");
                successMsg.setHeaderText(null);
                successMsg.setContentText("You Added a Category Successfully");
                successMsg.showAndWait();
        } catch (SQLException ex) {
            
            Alert successMsg = new Alert(Alert.AlertType.INFORMATION);
                successMsg.setTitle("Error!..");
                successMsg.setHeaderText(null);
                successMsg.setContentText("Data  not Inserted, Try Again! SQL Exception in : "+ ex );
                successMsg.showAndWait();
        }
        
        
        
        finally{
            
            ps.close();
        }
        ClearForm();
         }else{
            if(pAddName.getText().length()==0){
                     pLableName.setText("Name is required..");
                 }
                 if(pAddBlocks.getText().length()==0){
                     pLableBlocks.setText("Block Amount Required");
                 }
                 if(pAddUnits.getText().length()==0){
                     pLableUnits.setText("Unit Amount Required");
                 }
                 if(pAddWeight.getText().length()==0){
                     pLableWeight.setText("Weight or Volume Required");
                 }
                 if(pAddSellingPrice.getText().length()==0){
                     pLableSellingPrice.setText("Selling Price Required");
                 }
                 if(pAddBuyingPrice.getText().length()==0){
                     pLableBuyingPrice.setText("Buying Price Required");
                 }
        }
        
             
    }
         
    }
    }

