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
import static java.time.Clock.system;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Hansini
 */
public class CustomerdeleteController implements Initializable {

    
    private DBConnection dbcon;
    private ObservableList<CustomerView> data;
    private PreparedStatement ps;
     private CustomerView customer= new CustomerView();
     private int CID;
     
    
    @FXML
    private AnchorPane rootpane;
    @FXML
    private TextField cid;
    @FXML
    private TextField CPhone1;

    @FXML
    private CheckBox CDelete;

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
//    @FXML
//    private TableColumn<CustomerView, String> CCityColumn;
    @FXML
    private TableColumn<CustomerView, Integer> CPhone1Column;
//    @FXML
//    private TableColumn<CustomerView, String> CEmailColumn;
 // private ObservableList<CustomerView> data;
    private DBConnection db;
    
   void loadview(ActionEvent event) {
       
       System.out.println("jjj");

    }
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
          db = new DBConnection();
        Connection conn = db.Connect();
         dbcon = new DBConnection();
         System.out.println("fff");
         LoadCustomerData();
    }  
    
       @FXML
    private void LoadCustomerData() {
        
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
            System.err.println("Error Occured:" +ex);
        }
        
        
        
        //Setting cell value factory to table view
        CIDColumn.setCellValueFactory(new PropertyValueFactory<>("CID"));
        CFirstNameColumn.setCellValueFactory(new PropertyValueFactory<>("CFirstName"));
        //CCityColumn.setCellValueFactory(new PropertyValueFactory<>("CCity"));
        CPhone1Column.setCellValueFactory(new PropertyValueFactory<>("CPhone1"));
        //CEmailColumn.setCellValueFactory(new PropertyValueFactory<>("CEmail"));

        CustomerViewTable.setItems(null);
        CustomerViewTable.setItems(data);
        
        
    }
    /*
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
 JOptionPane.showMessageDialog(null, "Data  Deleted Successfully !!");
        } catch (SQLException ex) {
            System.err.println("Error Occured:" + ex);
        }

        //Setting cell value factory to table view
        CIDColumn.setCellValueFactory(new PropertyValueFactory<>("CID"));
        CFirstNameColumn.setCellValueFactory(new PropertyValueFactory<>("CFirstName"));
        //CCityColumn.setCellValueFactory(new PropertyValueFactory<>("CCity"));
        CPhone1Column.setCellValueFactory(new PropertyValueFactory<>("CPhone1"));
        //CEmailColumn.setCellValueFactory(new PropertyValueFactory<>("CEmail"));

        CustomerViewTable.setItems(null);
        CustomerViewTable.setItems(data);

    }
    */
    /*
    @FXML 
    public void getID(){
        
        try{
            CustomerView CustomerID = CustomerViewTable.getSelectionModel().getSelectedItem();
            Integer CID = CustomerID.getCID();
            //searchButton.setText(eID.toString());
        }catch(Exception e){
            System.out.println("Exception in mouseclick : " + e );
        }
    }
    */
    /*
    @FXML
    void deleteDataFromDatabase(ActionEvent event){
       //ExpenseView.getItems().removeAll(ExpenseView.getSelectionModel().getSelectedItem());
      
            ps = null;
            ResultSet rs = null;
            //Float eAmount = Float.parseFloat(AddAmountBtn.getText());
           
                   //String eTitle = Entertitleexpenses.getText();

                 
            Connection conn = dbcon.Connect();
        int CID = 0;
                   
            
            int ID = CID;
        
            try{
           
            ps = conn.prepareStatement("DELETE FROM product WHERE CID = ? ");
            ps.setInt(1, ID);
         
                ps.executeUpdate();
                
          }catch (SQLException ex) {
            System.out.println( "Exception in Deleting : " + ex );
            System.err.println("Error Occured:" +ex);
            
            
        }finally{
            //ps.execute();
            //ps.close();
        } 
    }
    */
    ////////////////////////////////////////////////////
    
    
        @FXML
    private void LoadDatafromDatabaseToDelete(ActionEvent event) {
        
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
            System.err.println("Error Occured:" +ex);
        }
        
        
        
        //Setting cell value factory to table view
        CIDColumn.setCellValueFactory(new PropertyValueFactory<>("CID"));
        CFirstNameColumn.setCellValueFactory(new PropertyValueFactory<>("CFirstName"));
        //CCityColumn.setCellValueFactory(new PropertyValueFactory<>("CCity"));
        CPhone1Column.setCellValueFactory(new PropertyValueFactory<>("CPhone1"));
        //CEmailColumn.setCellValueFactory(new PropertyValueFactory<>("CEmail"));

        CustomerViewTable.setItems(null);
        CustomerViewTable.setItems(data);
        
        
    }
    @FXML 
    public void getID(){
        
        try{
         customer = CustomerViewTable.getSelectionModel().getSelectedItem();
         CID = customer.getCID();
         //searchButton.setText(eID.toString());
        }catch(Exception e){
            System.out.println("Exception in mouseclick : " + e );
        }
    }
     @FXML
    public void deleteDataFromDatabase(ActionEvent event){
       //ExpenseView.getItems().removeAll(ExpenseView.getSelectionModel().getSelectedItem());
       
         int ID = 0;
                   
            
             ID = CID;
             
       if(ID>0)
             {
                Alert alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Confirmation");
                alert.setHeaderText(null);
                alert.setContentText("Do you want to delete selected customer ??...");
                Optional <ButtonType> action = alert.showAndWait();

                 if(action.get() == ButtonType.OK){
                       ps = null;
                    ResultSet rs = null;

                    Connection conn = dbcon.Connect();


                          try{

                    ps = conn.prepareStatement("DELETE FROM customer WHERE CID = ? ");
                    ps.setInt(1, ID);

                        ps.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Data Deleted Successfully !!");
                  }catch (Exception ex) {
                    System.out.println( "Exception in Deleting : " + ex );
                    System.err.println("Error Occured:" +ex);

            
        }finally{
           // ps.execute();
            //ps.close();
        }
            refresh();
            
         
             }
            
         }
        else
             {
                 JOptionPane.showMessageDialog(null, "Please select a customer !");

             }
        
          
    }
    @FXML
    public void refresh(){
        data.clear();
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
            System.err.println("Error Occured:" +ex);
        }
        
        
        
        //Setting cell value factory to table view
        CIDColumn.setCellValueFactory(new PropertyValueFactory<>("CID"));
        CFirstNameColumn.setCellValueFactory(new PropertyValueFactory<>("CFirstName"));
        //CCityColumn.setCellValueFactory(new PropertyValueFactory<>("CCity"));
        CPhone1Column.setCellValueFactory(new PropertyValueFactory<>("CPhone1"));
        //CEmailColumn.setCellValueFactory(new PropertyValueFactory<>("CEmail"));

        CustomerViewTable.setItems(null);
        CustomerViewTable.setItems(data);
        
    }
    
}
    


        
        
        
    
    

