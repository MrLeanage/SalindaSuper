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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Hansini
 */
public class CustomerupdateController implements Initializable {
//      
    private Integer CID;
    private CustomerView CustomerID = new CustomerView();
    CustomerView Customer;
    private DBConnection dbcon;
    private ObservableList<CustomerView> data;
    private PreparedStatement ps;


    @FXML
    private AnchorPane rootpane;
    @FXML
    private TextField CEmail;
    @FXML
    private TextField CAddress1;
    @FXML
    private DatePicker CRegDate;
    @FXML
    private TextField CPhone1;
    @FXML
    private TextField Fname;
    @FXML
    private TextField Lname;
   // private TextField CProvince;
    @FXML
    private TextField CAddress2;
    //private TextField CPhone2;
    @FXML
    private Button cancle;
    

    @FXML
    private TextField CC;
    @FXML
    private TextField CProvi;
//    @FXML
//    private Text SearchtableBox;
    @FXML
    private Label CUpdateLabelFName;
    @FXML
    private Label CUpdateLabelAddress1;
    @FXML
    private Label CUpdateLabelCity;
    @FXML
    private Label CUpdateLabelLname;
    @FXML
    private Label CUpdateLabelAddress2;
    @FXML
    private Label CUpdateLabelprovince;
    @FXML
    private Label CUpdateLabelPhone1;
    @FXML
    private Label CUpdateLabelEmail;
    @FXML
    private Text SearchtableBox;
  

    /**
     * Initializes the controller class.
     */
    
    @FXML
     private void goCustomerView(ActionEvent event) throws IOException{
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Customerinfoview.fxml"));
        rootpane.getChildren().setAll(pane);
        
    }@FXML     
     private void goCustomerDelete(ActionEvent event) throws IOException{
        AnchorPane pane = FXMLLoader.load(getClass().getResource("CustomerDelete.fxml"));
        rootpane.getChildren().setAll(pane);
    }    
     @FXML
     private void goCustomerHome(ActionEvent event) throws IOException{
        AnchorPane pane = FXMLLoader.load(getClass().getResource("CustomerHome.fxml"));
        rootpane.getChildren().setAll(pane);
    }   
     @FXML
    private void goCustomerAdd(ActionEvent event) throws IOException{
        AnchorPane pane = FXMLLoader.load(getClass().getResource("CustomerAdd.fxml"));
        rootpane.getChildren().setAll(pane);
    }     
    @FXML
    private void goCustomerUpdate(ActionEvent event) throws IOException{
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Customerupdate2.fxml"));
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
  @FXML
    private TableColumn<CustomerView, String> CRegDateColumn;
  
  
    //  private ObservableList<CustomerView> data;
    private DBConnection db;
@Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODOprivate DBConnection dbcon;
        
       dbcon = new DBConnection(); 
     
    } 
    
    
    private void ClearForm(){
        Fname.clear();
        Lname.clear();
        CAddress1.clear();
        CAddress2.clear();
        CC.clear();
        CProvi.clear();
        CPhone1.clear();
        CEmail.clear();
        CRegDate.getEditor().clear();
       
        
    }
    

// @Override
//    public void initialize(URL url, ResourceBundle rb) {
//        // TODOprivate DBConnection dbcon;
//        
//       dbcon = new DBConnection(); 
//     
//    } 
//    
    
     @FXML
    private void loadDataFromDB(ActionEvent event) {
        try {
            Connection conn = dbcon.Connect();
            data = FXCollections.observableArrayList();
            // Execute query and store result in a resultset
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM customer");
            while (rs.next()) {
                data.add(new CustomerView(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getInt(9), rs.getString(10), rs.getString(11)));
                                        //CID              FirstName        SecondName         Address1         Address2        City            Province        Phone1          Phone2          Email           RegDate     ////
            }
 //JOptionPane.showMessageDialog(null, "Data load successfully !");
        } catch (SQLException ex) {
            System.err.println("Error Occured:" + ex);
        }

        //Setting cell value factory to table view
        CIDColumn.setCellValueFactory(new PropertyValueFactory<>("CID"));
        CFirstNameColumn.setCellValueFactory(new PropertyValueFactory<>("CFirstName"));
        CCityColumn.setCellValueFactory(new PropertyValueFactory<>("CCity"));
        CPhone1Column.setCellValueFactory(new PropertyValueFactory<>("CPhone1"));
        CEmailColumn.setCellValueFactory(new PropertyValueFactory<>("CEmail"));
        CRegDateColumn.setCellValueFactory(new PropertyValueFactory<>("CRegistrationDate"));
 
        CustomerViewTable.setItems(null);
        CustomerViewTable.setItems(data);

    }
    public void refresh(){
        data.clear();
        try {
            Connection conn = dbcon.Connect();
            data = FXCollections.observableArrayList();
            // Execute query and store result in a resultset
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM customer");
            while (rs.next()) {
               data.add(new CustomerView(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getInt(9), rs.getString(10), rs.getString(11)));
                                        //CID              FirstName        SecondName         Address1         Address2        City            Province        Phone1          Phone2          Email           RegDate     ////
            }
            
        } catch (SQLException ex) {
            System.err.println("Error Occured:" +ex);
        }
          //Setting cell value factory to table view
        CIDColumn.setCellValueFactory(new PropertyValueFactory<>("CID"));
        CFirstNameColumn.setCellValueFactory(new PropertyValueFactory<>("CFirstName"));
        CCityColumn.setCellValueFactory(new PropertyValueFactory<>("CCity"));
        CPhone1Column.setCellValueFactory(new PropertyValueFactory<>("CPhone1"));
        CEmailColumn.setCellValueFactory(new PropertyValueFactory<>("CEmail"));
        CRegDateColumn.setCellValueFactory(new PropertyValueFactory<>("CRegistrationDate"));
        
        
        CustomerViewTable.setItems(null);
        CustomerViewTable.setItems(data);
    }
      @FXML 
    public void loadSelectdDatafromDatabase() throws ParseException{
        
        try{
         CustomerID = CustomerViewTable.getSelectionModel().getSelectedItem();
        
         CID = CustomerID.getCID();
          System.out.println(CID);
         //searchButton.setText(eID.toString());
        }catch(Exception e){
            System.out.println("Exception in mouseclick : " + e );
        }  
        int ID = CID;
        
        //String setCID = null;
        String setCFirstName = null;
        String setCLirstName = null;
        String setCAddress1 = null;
        String setCAddress2 = null;
        String setCCity = null;
        String setCProvi = null;
        String setCPhone1 = null;
        String setCEmail = null;
        String setCRegistrationDate = null;
//        float set = 0;
//        String set = null;
//        String set = null;
//        
        
        String query = "SELECT * FROM customer where CID = '"+ID+"'";
        
        try {
            Connection conn = dbcon.Connect(); 
            data = FXCollections.observableArrayList();
            // Execute query and store result in a resultset
            ResultSet rs = conn.createStatement().executeQuery(query);
           while (rs.next()) {
               
               data.add(new CustomerView(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getInt(9), rs.getString(10), rs.getString(11)));
                                        //CID              FirstName        SecondName         Address1         Address2        City            Province        Phone1          Phone2          Email           RegDate     ////
            
               
               // setCID = rs.getString(1);
                
                setCFirstName = rs.getString(2);
                setCLirstName = rs.getString(3);
                setCAddress1 = rs.getString(4);
                setCAddress2 = rs.getString(5);
                setCCity = rs.getString(6);
                setCProvi = rs.getString(7);
                setCPhone1 = rs.getString(8);
                setCEmail = rs.getString(10);
                setCRegistrationDate = rs.getString(11);
//                setPSDiscounts = rs.getFloat(6);
//                setPMDate = rs.getString(9);
//                setPExpDate = rs.getString(10);
//                
            }
           //LocalDate pMDate = LocalDate.parse(setPMDate);
           LocalDate CRegistrationDate = LocalDate.parse(setCRegistrationDate);
           
           Fname.setText(String.valueOf(setCFirstName));
           Lname.setText(String.valueOf(setCLirstName));
           CAddress1.setText(String.valueOf(setCAddress1));
           CAddress2.setText(String.valueOf(setCAddress2));
           CC.setText(String.valueOf(setCCity));
           CProvi.setText(String.valueOf(setCProvi));
           CPhone1.setText(String.valueOf(setCPhone1));
           CEmail.setText(String.valueOf(setCEmail));
           CRegDate.setValue(CRegistrationDate);
           // data.add(new ProductView(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getFloat(5), rs.getFloat(6), rs.getFloat(7), rs.getFloat(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15), rs.getString(16), rs.getString(17)));
                   // public ProductView(String pID, String pName, Integer pUnits, Integer pBlocks, Float pWeight, Float pSDiscounts, Float pBPrice, Float pSPrice, String pMDate, String pExpDate, String pDADate, String pModDate, String pADate) {
                   
            
        } catch (SQLException ex) {
            System.err.println("Error Occured:" +ex);
        }
           
            
        finally{
           // ps.execute();
            //ps.close();
        }
            
        
        
    }
//     
    @FXML
     void updateCustomer(ActionEvent event) throws SQLException {
         
          if(Validation.DataValidation.TextFieldNotEmpty(Fname, CUpdateLabelFName, " First Name is required..")
        
  || Validation.DataValidation.TextFieldNotEmpty(Lname, CUpdateLabelLname, "Last name Required")
  || Validation.DataValidation.TextFieldNotEmpty(CAddress1, CUpdateLabelAddress1, "Address  Required")
   || Validation.DataValidation.TextFieldNotEmpty(CAddress2, CUpdateLabelAddress2, " Address Required")
   || Validation.DataValidation.TextFieldNotEmpty(CC, CUpdateLabelCity, "City  Required")
   || Validation.DataValidation.TextFieldNotEmpty(CProvi, CUpdateLabelprovince, "Province Required")
  || Validation.DataValidation.TextFieldNotEmpty(CPhone1, CUpdateLabelPhone1, " Phone number Required")
     || Validation.DataValidation.TextFieldNotEmpty(CEmail, CUpdateLabelEmail, "Email Address Required")

)
  if(this.CPhone1.getText().length()!=9)
       {
          JOptionPane.showMessageDialog(null, "Invalid Phone number !");

       }else  
       
          
          {

 
        // int ID = CID;
        String CFName = Fname.getText();
        String CLName = Lname.getText();
        String CAdd1 = CAddress1.getText();
        String CAdd2 = CAddress2.getText();
        String CCity =  CC.getText();
        String Cprovince = CProvi.getText();
        Integer Cphone1 = Integer.parseInt(CPhone1.getText());
        String Cemail = CEmail.getText();
         LocalDate CExpDate = CRegDate.getValue();
         String CcRegDate = CExpDate.toString();
//     
        
//         //CPhone2 = ?
        String query = "UPDATE customer SET CFirstName = ?, CLastName = ?, CAddress1 = ?, CAddress2 = ?, CCity = ?, CProvince = ?, CPhone1 = ?, CEmail = ? , CRegistrationDate = ?  WHERE CID =?";
          ps = null;
        try {
            Connection conn = dbcon.Connect();
            ps = conn.prepareStatement(query);
            ps.setString(1, CFName);
            ps.setString(2, CLName);
            ps.setString(3, CAdd1);
            ps.setString(4, CAdd2);
            ps.setString(5, CCity);
            ps.setString(6, Cprovince);
            ps.setInt(7, Cphone1);
         // ps.setInt(8, Cphone1);
            ps.setString(8, Cemail);
            ps.setString(9, CcRegDate);
             ps.setInt(10, CID);
           
            ps.execute();
            
         
         
          
          JOptionPane.showMessageDialog(null, "Data Updated Successfully");
         refresh();
     } catch (SQLException ex) {
         System.err.println("Error Occured:" +ex);
         JOptionPane.showMessageDialog(null, "Data  not Updated, Try Again");
        }
        
        
        finally{
            
            ps.close();
        }
       ClearForm();
    }
         
    }
}

     
    

    

