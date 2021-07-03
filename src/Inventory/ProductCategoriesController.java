/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inventory;

import DBConnect.DBConnection;
import Inventory.Product.Categories.ProductCategories;
import Inventory.Product.ProductDetails.ProductView;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author dulshan
 */
public class ProductCategoriesController implements Initializable {

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    
    //Initialize observable list to hold out database data
    private DBConnection dbcon;
    private ObservableList<ProductCategories> data;
    private PreparedStatement ps;
   // private Integer catID = 0;
    private ProductCategories CategoryID = new ProductCategories();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        dbcon = new DBConnection();
        loadCategory();
    }  
     @FXML
    private AnchorPane rootpane;
//Start Table components to view/delete
    @FXML
    private TableView<ProductCategories> ViewProductCategoryTable;

    @FXML
    private TableColumn<ProductCategories, Integer> PCategoryIDColumn;

    @FXML
    private TableColumn<ProductCategories, String> PCategoryTypeColumn;

    @FXML
    private TableColumn<ProductCategories, String> PCategorySubTypeColumn;
//End Table components to view/delete
//Start Textbox/Label components to add/Update
    @FXML
    private TextField pCategoryTextboxType;
    @FXML
    private TextField pCategoryTextboxSubType;
    
    @FXML
    private Label pCategoryLabelType;

    @FXML
    private Label pCategoryLabelSubType;
  //End Textbox/Label components to add/Update  
  //Search Box Components
     @FXML
    private TextField pCategoryTextBoxSearch;
     
     
     
    
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
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM category");
            while (rs.next()) {
                data.add(new ProductCategories(rs.getInt(1), rs.getString(2), rs.getString(3)));
                        // public ProductView(String pCID, String pCType, String pCSubType) 

            }
            
        } catch (SQLException ex) {
            Alert successMsg = new Alert(Alert.AlertType.INFORMATION);
                successMsg.setTitle("Error!..");
                successMsg.setHeaderText(null);
                successMsg.setContentText("SQL Exception in : "+ ex );
                successMsg.showAndWait();
        }
        
        
        
        //Setting cell value factory to table view
        PCategoryIDColumn.setCellValueFactory(new PropertyValueFactory<>("pCatID"));
        PCategoryTypeColumn.setCellValueFactory(new PropertyValueFactory<>("pCatType"));
        PCategorySubTypeColumn.setCellValueFactory(new PropertyValueFactory<>("pCatSubType"));
        
        ViewProductCategoryTable.setItems(null);
        ViewProductCategoryTable.setItems(data);
        
        
    }
    @FXML
    private void loadCategory() {
        
        try {
            Connection conn = dbcon.Connect();
            data = FXCollections.observableArrayList();
            // Execute query and store result in a resultset
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM category");
            while (rs.next()) {
                data.add(new ProductCategories(rs.getInt(1), rs.getString(2), rs.getString(3)));
                        // public ProductView(String pCID, String pCType, String pCSubType) 

            }
            
        } catch (SQLException ex) {
            Alert successMsg = new Alert(Alert.AlertType.INFORMATION);
                successMsg.setTitle("Error!..");
                successMsg.setHeaderText(null);
                successMsg.setContentText("SQL Exception in : "+ ex );
                successMsg.showAndWait();
        }
        
        
        
        //Setting cell value factory to table view
        PCategoryIDColumn.setCellValueFactory(new PropertyValueFactory<>("pCatID"));
        PCategoryTypeColumn.setCellValueFactory(new PropertyValueFactory<>("pCatType"));
        PCategorySubTypeColumn.setCellValueFactory(new PropertyValueFactory<>("pCatSubType"));
        
        ViewProductCategoryTable.setItems(null);
        ViewProductCategoryTable.setItems(data);
        
        
    }
     
    private void refresh() {
        data.clear();
        try {
            Connection conn = dbcon.Connect();
            data = FXCollections.observableArrayList();
            // Execute query and store result in a resultset
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM category");
            while (rs.next()) {
                data.add(new ProductCategories(rs.getInt(1), rs.getString(2), rs.getString(3)));
                        // public ProductView(String pCID, String pCType, String pCSubType) 

            }
            
        } catch (SQLException ex) {
            
            Alert successMsg = new Alert(Alert.AlertType.INFORMATION);
                successMsg.setTitle("Error!..");
                successMsg.setHeaderText(null);
                successMsg.setContentText("SQL Exception in : "+ ex );
                successMsg.showAndWait();
        }
        
        
        
        //Setting cell value factory to table view
        PCategoryIDColumn.setCellValueFactory(new PropertyValueFactory<>("pCatID"));
        PCategoryTypeColumn.setCellValueFactory(new PropertyValueFactory<>("pCatType"));
        PCategorySubTypeColumn.setCellValueFactory(new PropertyValueFactory<>("pCatSubType"));
        
        ViewProductCategoryTable.setItems(null);
        ViewProductCategoryTable.setItems(data);
        
        
    }
    //End View Data from DataBase
    
    //Clearing Fields
    private void ClearForm(){
        pCategoryTextboxType.clear();
        pCategoryTextboxSubType.clear();
        
    }
    private void ClearLabel(){
        pCategoryLabelType.setText("");
        pCategoryLabelSubType.setText("");
    }
    @FXML
    public void clearType(){
        pCategoryLabelType.setText("");
    }
    @FXML
    public void clearSubType(){
        pCategoryLabelSubType.setText("");
    }
    @FXML
    private void loadCategories(ActionEvent event) throws IOException {
        //AnchorPane pane = FXMLLoader.load(getClass().getResource("productcategories.fxml"));
        //rootpane.getChildren().setAll(pane);
        //dialogStage.close();
         
    }
    //Add data to DataBase
    @FXML
    private void AddCategoriesToDatabase(ActionEvent event) throws SQLException {
        if(Validation.DataValidation.TextFieldNotEmpty(pCategoryTextboxType, pCategoryLabelType, "Category Type Name is required..")
        || Validation.DataValidation.TextFieldNotEmpty(pCategoryTextboxSubType, pCategoryLabelSubType, "Category SubType Name is required..")){
             
         
        if((pCategoryTextboxType.getText().length()>0)
           && (pCategoryTextboxSubType.getText().length()>0))
          {
            
        
        String pCatType = pCategoryTextboxType.getText();
        String pCatSubType = pCategoryTextboxSubType.getText();
      
        String query = "INSERT INTO category (CatType, CatSubType) VALUES( ?, ?)";
        ps = null;
        try {
            Connection conn = dbcon.Connect();
            ps = conn.prepareStatement(query);
            ps.setString(1, pCatType);
            ps.setString(2, pCatSubType);
            ps.execute();
            
            
            Alert successMsg = new Alert(Alert.AlertType.INFORMATION);
                successMsg.setTitle("Successful..");
                successMsg.setHeaderText(null);
                successMsg.setContentText("Category Added Successfully.. ");
        } catch (SQLException ex) {
            
            Alert successMsg = new Alert(Alert.AlertType.INFORMATION);
                successMsg.setTitle("Error!..");
                successMsg.setHeaderText(null);
                successMsg.setContentText("Data  not Inserted, Try Again!..SQL Exception in : "+ ex );
        }
        
        
        
        finally{
            
            ps.close();
            
        }
        refresh();
        ClearForm();
        ClearLabel();
    
        }else{
            if(pCategoryTextboxType.getText().length()==0){
                     pCategoryLabelType.setText("Category Type Name is required..");
                 }
                 if(pCategoryTextboxSubType.getText().length()==0){
                     pCategoryLabelSubType.setText("Category SubType Name is required..");
                 }
                
        }
     }
    }
    
    //Update Functionct
    
    @FXML 
    int getID(){
        int CatID =0;
        try{
         CategoryID = ViewProductCategoryTable.getSelectionModel().getSelectedItem();
         CatID = CategoryID.getPCatID();
         //searchButton.setText(eID.toString());
        }catch(Exception ex){
            Alert successMsg = new Alert(Alert.AlertType.INFORMATION);
                successMsg.setTitle("Error!..");
                successMsg.setHeaderText(null);
                successMsg.setContentText("Exception in Mouseclick: "+ ex );
            
        }
        return CatID;
    }
    @FXML 
    public void loadSelectdDatafromDatabase() throws ParseException{
        int catID = 0;
        try{
         CategoryID = ViewProductCategoryTable.getSelectionModel().getSelectedItem();
         catID = CategoryID.getPCatID();
          //System.out.println(catID);
         //searchButton.setText(eID.toString());
        }catch(Exception ex){
            
            Alert successMsg = new Alert(Alert.AlertType.INFORMATION);
                successMsg.setTitle("Error!..");
                successMsg.setHeaderText(null);
                successMsg.setContentText("Exception in Mouseclick: "+ ex );
            
        } 
        
        
        
        String setPCatType = null;
        String setPCatSubType = null;
        
        
        
        String query = "SELECT * FROM category where CatID = '"+catID+"'";
        
        try {
            Connection conn = dbcon.Connect(); 
            data = FXCollections.observableArrayList();
            // Execute query and store result in a resultset
            ResultSet rs = conn.createStatement().executeQuery(query);
           while (rs.next()) {
               
               data.add(new ProductCategories(rs.getInt(1), rs.getString(2), rs.getString(3)));

               
                setPCatType = rs.getString(2);
                setPCatSubType = rs.getString(3);
                //System.out.println(setPCatType);
                //System.out.println(setPCatSubType);
            }
           
           
           pCategoryTextboxType.setText(setPCatType);
           pCategoryTextboxSubType.setText(String.valueOf(setPCatSubType));
           
        } catch (SQLException ex) {
            
            Alert successMsg = new Alert(Alert.AlertType.INFORMATION);
                successMsg.setTitle("Error!..");
                successMsg.setHeaderText(null);
                successMsg.setContentText("Exception in Mouseclick: "+ ex );
            
        }
           
            
        finally{
           // ps.execute();
            //ps.close();
        }
           
        
        
    }
    
     @FXML
    private void UpdateCategoriesToDatabase(ActionEvent event) throws SQLException {
        if(Validation.DataValidation.TextFieldNotEmpty(pCategoryTextboxType, pCategoryLabelType, "Category Type Name is required..")
        || Validation.DataValidation.TextFieldNotEmpty(pCategoryTextboxSubType, pCategoryLabelSubType, "Category SubType Name is required..")){
            
         int ID = getID();
         
        //System.out.println(id);
        String pCatType = pCategoryTextboxType.getText();
        String pCatSubType = pCategoryTextboxSubType.getText();
        
        String query = "UPDATE category SET CatType = ?, CatSubType = ? WHERE CatID = '"+ID+"'";
        ps = null;
        try {
            Connection conn = dbcon.Connect();
            ps = conn.prepareStatement(query);
            ps.setString(1, pCatType);
            ps.setString(2, pCatSubType);
            
            ps.execute();
            
            
            
            
            //JOptionPane.showMessageDialog(null, "Category Updated Successfully");
            Alert successMsg = new Alert(AlertType.INFORMATION);
                successMsg.setTitle("SuccessFul");
                successMsg.setHeaderText(null);
                successMsg.setContentText("Product Added Successfully");
                successMsg.showAndWait();
            refresh();
        } catch (SQLException ex) {
            System.err.println("Error Occured:" +ex);
            //JOptionPane.showMessageDialog(null, "Category  not Updated, Try Again");
            Alert successMsg = new Alert(AlertType.ERROR);
                successMsg.setTitle("Error..");
                successMsg.setHeaderText(null);
                successMsg.setContentText("Category  not Updated, Try Again");
                successMsg.showAndWait();
            
        }
        
        
        
        finally{
            
            ps.close();
        }
        refresh();
        ClearForm();
        ClearLabel();
    }
         
    }
    //Parent root;
    //Scene scene = new Scene(root);
    Stage dialogStage = new Stage();
    @FXML
    public void verifyDelete() throws IOException{
        
        int ID = getID();
        if(ID != 0){
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confitm Your Selected Deleting");
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
           
            ps = conn.prepareStatement("DELETE FROM category WHERE CatID = ? ");
            ps.setInt(1, ID);
         
                ps.executeUpdate();
                //JOptionPane.showMessageDialog(null, "Data Deleted");
                Alert successMsg = new Alert(AlertType.INFORMATION);
                successMsg.setTitle("SuccessFul");
                successMsg.setHeaderText(null);
                successMsg.setContentText("You deleted a Category Successfully");
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
        }
    }else{
            Alert successMsg = new Alert(AlertType.INFORMATION);
                
                successMsg.setTitle("Select a row..");
                successMsg.setHeaderText(null);
                successMsg.setContentText("Please Select a row from Table to Delete");
                
                successMsg.showAndWait();
        }
    }
}
