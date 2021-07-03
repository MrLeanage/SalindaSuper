/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inventory;

import DBConnect.DBConnection;
import Inventory.Product.Brands.ProductBrands;
import Inventory.Product.Categories.ProductCategories;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Optional;
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
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author dulshan
 */
public class ProductBrandController implements Initializable {
    /*
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    
    //Initialize observable list to hold out database data
    private DBConnection dbcon;
    private ObservableList<ProductBrands> data;
    private PreparedStatement ps;
   // private Integer catID = 0;
    private ProductBrands brandID = new ProductBrands();
    private ProductBrands brandName = new ProductBrands();
    private ProductBrands brandDescription = new ProductBrands();
    
     @FXML
    private AnchorPane rootpane;

    @FXML
    private TableView<ProductBrands> ViewProductBrandTable;

    @FXML
    private TableColumn<ProductBrands, Integer> PBrandIDColumn;

    @FXML
    private TableColumn<ProductBrands, String> PBrandNameColumn;

    @FXML
    private TableColumn<ProductBrands, String> PBrandDescriptionColumn;

    @FXML
    private TextField pBrandTextBoxName;

    @FXML
    private TextField pBrandTextBoxSearch;

    @FXML
    private Label pBrandLabelName;

    @FXML
    private Label pBrandLabelDescription;

    @FXML
    private TextArea pBrandTextBoxDescription;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        dbcon = new DBConnection();
        AutoReload();
    } 
    @FXML
    private void loadInventoryHome(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("inventoryhome.fxml"));
        rootpane.getChildren().setAll(pane);
    }
    // View Data from DataBase
    @FXML
    private void loadDatafromDatabase(ActionEvent event) {
        
        try {
            Connection conn = dbcon.Connect();
            data = FXCollections.observableArrayList();
            // Execute query and store result in a resultset
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM productbrand");
            while (rs.next()) {
                data.add(new ProductBrands(rs.getInt(1), rs.getString(2), rs.getString(3)));
                        // public BrandView(String pBID, String pBName, String pBDiscription) 

            }
            
        } catch (SQLException ex) {
            
            Alert successMsg = new Alert(Alert.AlertType.INFORMATION);
                successMsg.setTitle("Error!..");
                successMsg.setHeaderText(null);
                successMsg.setContentText("SQL ,Exception in Retrieving Data: "+ ex );
        }
        
        
        
        //Setting cell value factory to table view
        PBrandIDColumn.setCellValueFactory(new PropertyValueFactory<>("pBID"));
        PBrandNameColumn.setCellValueFactory(new PropertyValueFactory<>("pBName"));
        PBrandDescriptionColumn.setCellValueFactory(new PropertyValueFactory<>("pBDiscription"));
        
        ViewProductBrandTable.setItems(null);
        ViewProductBrandTable.setItems(data);
        
        
    }
    private void refresh() {
        data.clear();
        try {
            Connection conn = dbcon.Connect();
            data = FXCollections.observableArrayList();
            // Execute query and store result in a resultset
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM productbrand");
            while (rs.next()) {
                data.add(new ProductBrands(rs.getInt(1), rs.getString(2), rs.getString(3)));
                        // public BrandView(String pBID, String pBName, String pBDiscription) 

            }
            
        } catch (SQLException ex) {
            
            Alert successMsg = new Alert(Alert.AlertType.INFORMATION);
                successMsg.setTitle("Error!..");
                successMsg.setHeaderText(null);
                successMsg.setContentText("Error Occured,Exception in Refreshing: "+ ex );
        }
        
        
        
        //Setting cell value factory to table view
        PBrandIDColumn.setCellValueFactory(new PropertyValueFactory<>("pBID"));
        PBrandNameColumn.setCellValueFactory(new PropertyValueFactory<>("pBName"));
        PBrandDescriptionColumn.setCellValueFactory(new PropertyValueFactory<>("pBDiscription"));
        
        ViewProductBrandTable.setItems(null);
        ViewProductBrandTable.setItems(data);
        
        
        
        
    }
    private void AutoReload() {
        try {
            Connection conn = dbcon.Connect();
            data = FXCollections.observableArrayList();
            // Execute query and store result in a resultset
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM productbrand");
            while (rs.next()) {
                data.add(new ProductBrands(rs.getInt(1), rs.getString(2), rs.getString(3)));
                        // public BrandView(String pBID, String pBName, String pBDiscription) 

            }
            
        } catch (SQLException ex) {
            
            Alert successMsg = new Alert(Alert.AlertType.INFORMATION);
                successMsg.setTitle("Error!..");
                successMsg.setHeaderText(null);
                successMsg.setContentText("Error Occured,Exception in Refreshing: "+ ex );
        }
        
        
        
        //Setting cell value factory to table view
        PBrandIDColumn.setCellValueFactory(new PropertyValueFactory<>("pBID"));
        PBrandNameColumn.setCellValueFactory(new PropertyValueFactory<>("pBName"));
        PBrandDescriptionColumn.setCellValueFactory(new PropertyValueFactory<>("pBDiscription"));
        
        ViewProductBrandTable.setItems(null);
        ViewProductBrandTable.setItems(data);
        
        
        
        
    }
    //End View Data from DataBase
     //Clearing Fields
    private void ClearForm(){
        pBrandTextBoxName.clear();
        pBrandTextBoxDescription.clear();
        
    }
    private void ClearLabel(){
        pBrandLabelName.setText("");
        pBrandLabelDescription.setText("");
    }
    @FXML
    public void clearName(){
        pBrandLabelName.setText("");
    }
    @FXML
    public void clearDescription(){
        pBrandLabelDescription.setText("");
    }
    
     //Add data to DataBase
    @FXML
    private void AddBrandToDatabase(ActionEvent event) throws SQLException {
        if(Validation.DataValidation.TextFieldNotEmpty(pBrandTextBoxName, pBrandLabelName, "Brand Name is required..")
        || Validation.DataValidation.TextAreaNotEmpty(pBrandTextBoxDescription, pBrandLabelDescription, "Brand Description is required..")){
         
         
        if((pBrandTextBoxName.getText().length()>0)
           &&(pBrandTextBoxDescription.getText().length()>0))
          {
              
        String pBName = pBrandTextBoxName.getText();
        String pBDescription = pBrandTextBoxDescription.getText();
        System.out.println(pBName);
        String query = "INSERT INTO productbrand (PBName, PBDescription) VALUES( ?, ?)";
        ps = null;
        try {
            Connection conn = dbcon.Connect();
            ps = conn.prepareStatement(query);
            ps.setString(1, pBName);
            ps.setString(2, pBDescription);
            ps.execute();
            
            
           
            Alert successMsg = new Alert(Alert.AlertType.INFORMATION);
                successMsg.setTitle("Successful..");
                successMsg.setHeaderText(null);
                successMsg.setContentText("Brand Added Successfully.. ");
        } catch (SQLException ex) {
            
            Alert successMsg = new Alert(Alert.AlertType.INFORMATION);
                successMsg.setTitle("Error!..");
                successMsg.setHeaderText(null);
                successMsg.setContentText("Error Occured,Exception in Inserting: "+ ex );
        }
        
        
        
        finally{
            
            ps.close();
        }
        refresh();
        ClearForm();
        ClearLabel();
          }else {
                if(pBrandTextBoxName.getText().length()==0){
                     pBrandLabelName.setText("Brand Name is required..");
                 }
                 if(pBrandTextBoxDescription.getText().length()==0){
                     pBrandLabelDescription.setText("Brand Description is required..");
                 }
        }
    }
    
   }
     //Update Functionct
    
    @FXML 
    int getID(){
        int productID =0;
        try{
         brandID = ViewProductBrandTable.getSelectionModel().getSelectedItem();
         productID = brandID.getPBID();
         //searchButton.setText(eID.toString());
        }catch(Exception ex){
            
            Alert successMsg = new Alert(Alert.AlertType.INFORMATION);
                successMsg.setTitle("Error!..");
                successMsg.setHeaderText(null);
                successMsg.setContentText("Exception in Mouse Click: "+ ex );
        }
        return productID;
    }
    @FXML 
    public void loadSelectdDatafromDatabase() throws ParseException{
        int productID = 0;
        try{
         brandID = ViewProductBrandTable.getSelectionModel().getSelectedItem();
         productID = brandID.getPBID();
          //System.out.println(catID);
         //searchButton.setText(eID.toString());
        }catch(Exception ex){
            Alert successMsg = new Alert(Alert.AlertType.INFORMATION);
                successMsg.setTitle("Error!..");
                successMsg.setHeaderText(null);
                successMsg.setContentText("Exception in Mouse Click: "+ ex );
        } 
        
        
        
        String setPBName = null;
        String setPBDescription = null;
        
        
        
        String query = "SELECT * FROM productbrand where PBID = '"+productID+"'";
        
        try {
            Connection conn = dbcon.Connect(); 
            data = FXCollections.observableArrayList();
            // Execute query and store result in a resultset
            ResultSet rs = conn.createStatement().executeQuery(query);
           while (rs.next()) {
               
               data.add(new ProductBrands(rs.getInt(1), rs.getString(2), rs.getString(3)));

               
                setPBName = rs.getString(2);
                setPBDescription = rs.getString(3);
                //System.out.println(setPCatType);
                //System.out.println(setPCatSubType);
            }
           
           pBrandTextBoxName.setText(setPBName);
           pBrandTextBoxDescription.setText(String.valueOf(setPBDescription));
           
        } catch (SQLException ex) {
            
            Alert successMsg = new Alert(Alert.AlertType.INFORMATION);
                successMsg.setTitle("Error!..");
                successMsg.setHeaderText(null);
                successMsg.setContentText("Error Occured,Exception in Deleting: "+ ex );
        }
           
            
        finally{
           // ps.execute();
            //ps.close();
        }
           
        
        
    }
    
     @FXML
    private void UpdateBrandToDatabase(ActionEvent event) throws SQLException {
        if(Validation.DataValidation.TextFieldNotEmpty(pBrandTextBoxName, pBrandLabelName, "Brand Name is required..")
        || Validation.DataValidation.TextAreaNotEmpty(pBrandTextBoxDescription, pBrandLabelDescription, "Brand Description is required..")){
            
         int ID = getID();
         
        //System.out.println(id);
        String pBName = pBrandTextBoxName.getText();
        String pBDescription = pBrandTextBoxDescription.getText();
        
        String query = "UPDATE productbrand SET PBName = ?, PBDescription = ? WHERE PBID = '"+ID+"'";
        ps = null;
        try {
            Connection conn = dbcon.Connect();
            ps = conn.prepareStatement(query);
            ps.setString(1, pBName);
            ps.setString(2, pBDescription);
            
            ps.execute();
            
            
            Alert successMsg = new Alert(Alert.AlertType.INFORMATION);
                successMsg.setTitle("SuccessFul");
                successMsg.setHeaderText(null);
                successMsg.setContentText("Brand Updated Successfully");
                successMsg.showAndWait();
            refresh();
        } catch (SQLException ex) {
            
            Alert successMsg = new Alert(Alert.AlertType.INFORMATION);
                successMsg.setTitle("Error!..");
                successMsg.setHeaderText(null);
                successMsg.setContentText("SQL Exception in Occured: "+ ex );
            
            
        }
        
        
        
        finally{
            
            ps.close();
        }
        refresh();
        ClearForm();
        ClearLabel();
    }
         
    }
    
    @FXML
    public void deleteDataFromDatabase(ActionEvent event){
        int ID = getID();
        if(ID != 0){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confitm Your Selected Deleting");
        alert.setHeaderText(null);
        alert.setContentText("Do you want to delete selected Item??...");
        Optional <ButtonType> action = alert.showAndWait();
        
        if(action.get() == ButtonType.OK){
             ps = null;
            ResultSet rs = null;    
            Connection conn = dbcon.Connect();
            try{
           
            ps = conn.prepareStatement("DELETE FROM productbrand WHERE PBID = ? ");
            ps.setInt(1, ID);
         
                ps.executeUpdate();
                
                
                Alert successMsg = new Alert(Alert.AlertType.INFORMATION);
                successMsg.setTitle("SuccessFul");
                successMsg.setHeaderText(null);
                successMsg.setContentText("Brand Deleted Successfully");
                successMsg.showAndWait();
                
          }catch (Exception ex) {
              
            Alert successMsg = new Alert(Alert.AlertType.INFORMATION);
                successMsg.setTitle("Error!..");
                successMsg.setHeaderText(null);
                successMsg.setContentText("Error Occured,Exception in Deleting: "+ ex );
            
            
        }finally{
           // ps.execute();
            //ps.close();
        }
            refresh();
            ClearForm();
            
    }else{
            Alert successMsg = new Alert(Alert.AlertType.INFORMATION);
                successMsg.setTitle("Error!..");
                successMsg.setHeaderText(null);
                successMsg.setContentText("Please Select the row from tha table to delete!..");
        }
        
    }else{
            Alert successMsg = new Alert(Alert.AlertType.INFORMATION);
                
                successMsg.setTitle("Select a row..");
                successMsg.setHeaderText(null);
                successMsg.setContentText("Please Select a row from Table to Delete");
                
                successMsg.showAndWait();
        }
            
    }
}
