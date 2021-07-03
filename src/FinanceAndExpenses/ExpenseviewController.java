/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinanceAndExpenses;

import DBConnect.DBConnection;
import FinanceAndExpenses.Expenses.ExpensesView;


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
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
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
 * @author N
 */
public class ExpenseviewController implements Initializable {

    @FXML
    private AnchorPane rootpane;
    //view table
    @FXML
    private TableView<ExpensesView> ExpenseView;

    @FXML
    private TableColumn<ExpensesView, Integer> IDColumn;

    @FXML
    private TableColumn<ExpensesView, String> TitleColumn;

    @FXML
    private TableColumn<ExpensesView, String> DateColumn;

    @FXML
    private TableColumn<ExpensesView, Float> AmountColumn;

    @FXML
    private TableColumn<ExpensesView, String> DescriptionColumn;
    
    @FXML
    private Button LoadView;
    //Delete Button
    

    @FXML
    private Button deleteButton;

    @FXML
    private TextField searchButton;
    
    //textboxes
    @FXML
    private DatePicker updateDateBtn;

    @FXML
    private TextField updateAddAmountBtn;

    @FXML
    private TextArea updateAddescriptionBtn;

    @FXML
    private TextField updateEntertitleexpenses;

    
   //add button   
   @FXML
    private Button addbtn;

    @FXML
    private Button CancelBtn;

    @FXML
    private TextField AddAmountBtn;

    @FXML
    private TextArea AddescriptionBtn;
    
    
    @FXML
    private Label titleLabel;

    @FXML
    private Label dataLabel;

    @FXML
    private Label amountLabel;

   // @FXML
    //private ComboBox<String> Uresha;
    
    @FXML
    private DatePicker AddDateBtn;
   // @FXML
    //private ComboBox<String> combomainMenu8;
    @FXML
    private TextField Entertitleexpenses;
    
    private ExpensesView expenses = new ExpensesView();
    
    private Integer eID;
    
   @FXML
       private void goAddExpense(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("expenseadd.fxml"));
        rootpane.getChildren().setAll(pane);
    } 
       @FXML
    private void goDeleteExpense(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("expensedelete.fxml"));
        rootpane.getChildren().setAll(pane);
    }  
    @FXML
    private void goUpdateExpense(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("expenseupdate.fxml"));
        rootpane.getChildren().setAll(pane);
    }
     @FXML
     private void goBack(ActionEvent event) throws IOException {
         
        AnchorPane pane = FXMLLoader.load(getClass().getResource("fehome.fxml"));
        rootpane.getChildren().setAll(pane);
    }
      @FXML
     private void goViewExpense(ActionEvent event) throws IOException {
         AnchorPane pane = FXMLLoader.load(getClass().getResource("expenseview.fxml"));
        rootpane.getChildren().setAll(pane);
    }
    
     //Initialize observable list to hold out database data
    private ObservableList<ExpensesView> data;
    private DBConnection dbcon;
        private PreparedStatement ps;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         dbcon = new DBConnection();
       // Uresha.getItems().addAll("Current Bill", "Water Bill","Utility Bill", "Other Bill"); 
      // combomainMenu8.getItems().addAll("Employee Management", "Offer Managemnet","Customer Management", "Payaroll Management", "Supplier Management", "Inventory Management", "Billing & Income Management", "Finance & Expence Management"); 
      
    }    
    //view
    @FXML
    void loadDatafromDatabase(ActionEvent event) {
        try {
            Connection conn = dbcon.Connect();
            data = FXCollections.observableArrayList();
            // Execute query and store result in a resultset
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM expenses");
            while (rs.next()) {
                data.add(new ExpensesView(rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getString(4), rs.getString(5)));
            }
            
        } catch (SQLException ex) {
            System.err.println("Error Occured:" +ex);
        }
        
        //Setting cell value factory to table view
        IDColumn.setCellValueFactory(new PropertyValueFactory<>("EID"));
        TitleColumn.setCellValueFactory(new PropertyValueFactory<>("ETitle"));
        AmountColumn.setCellValueFactory(new PropertyValueFactory<>("EAmount"));
        DateColumn.setCellValueFactory(new PropertyValueFactory<>("EDate"));
        DescriptionColumn.setCellValueFactory(new PropertyValueFactory<>("EDescription"));
     
        
        
        ExpenseView.setItems(null);
        ExpenseView.setItems(data);
    }
  
    
    

    //insert
    @FXML
    void addDataFromDatabase(ActionEvent event)throws SQLException  { 
          
         
      if(Validation.DataValidation.TextFieldNotEmpty(updateEntertitleexpenses, titleLabel, "Title Required")
        
   ||Validation.DataValidation.TextFieldNotEmpty(updateAddAmountBtn, amountLabel, "Amount Required")
        ){
        //if(this.AddAmountBtn.getText().matches("[a-zA-Z]+"))
       // {
       //     JOptionPane.showMessageDialog(null,"Invalid AMount !");
        
       String eTitle = Entertitleexpenses.getText();
        
        Float eAmount = Float.parseFloat(AddAmountBtn.getText());
       
        LocalDate eDate = AddDateBtn.getValue();
        String eSDate = eDate.toString();
       
        String eDescription = AddescriptionBtn.getText();
       String query = "INSERT INTO expenses(ETitle, EAmount, EDate, EDescription) VALUES(?, ?, ?, ?)";
        ps = null;
        try {
            Connection conn = dbcon.Connect();
            ps = conn.prepareStatement(query);
          
            
            ps.setString(1, eTitle);
            ps.setFloat(2,eAmount );
            ps.setString(3, eSDate);
            ps.setString(4, eDescription);
 
            
            
            
                JOptionPane.showMessageDialog(null, "Data Inserted");
            
        } catch (SQLException ex) {
             //JOptionPane.showMessageDialog(null, "Data  not Inserted");
            System.err.println("Error Occured:" +ex);
            
            
        }finally{
            ps.execute();
            ps.close();
        }
        ClearForm();
      }else{
          
        
      }
}
    /*
    private void ClearForm() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    */
    @FXML 
    public int getID(){
        int wID = 0;
        try{
         expenses = ExpenseView.getSelectionModel().getSelectedItem();
         wID = expenses.getEID();
         System.out.println(wID);
         //searchButton.setText(eID.toString());
        }catch(Exception e){
            System.out.println("Exception in mouseclick : " + e );
        }
        return wID;
    }
    @FXML 
    public void loadSelectdDatafromDatabase() throws ParseException{
        int expensesID;
        String expensestitle;
        Float expensesAmount;
        String expensesDate;
        String expensesDescription;
        try{
         expenses = ExpenseView.getSelectionModel().getSelectedItem();
         expensesID = expenses.getEID();
         expenses = ExpenseView.getSelectionModel().getSelectedItem();
         expensestitle = expenses.getETitle();
         expenses = ExpenseView.getSelectionModel().getSelectedItem();
         expensesAmount = expenses.getEAmount();
         expenses = ExpenseView.getSelectionModel().getSelectedItem();
         expensesDate = expenses.getEDate();
         LocalDate pMDate = LocalDate.parse(expensesDate);
         expenses = ExpenseView.getSelectionModel().getSelectedItem();
         expensesDescription = expenses.getEDescription();
         
         
          
    
         updateEntertitleexpenses.setText(expensestitle);
         updateAddAmountBtn.setText(String.valueOf(expensesAmount));
         updateAddescriptionBtn.setText(expensesDescription);
         updateDateBtn.setValue(pMDate);
         //searchButton.setText(eID.toString());
        }catch(Exception e){
            System.out.println("Exception in mouseclick : " + e );
        }  
        
         
            
        
           
            
        finally{
           // ps.execute();
            //ps.close();
        }
            
        
        
    }
    @FXML 
    private void ClearForm() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  
         updateEntertitleexpenses.clear();
        updateAddAmountBtn.clear();
        updateDateBtn.setValue(null);
        updateAddescriptionBtn.clear();
    }
     @FXML
   public void refreshDataFromDatabase(){
       data.clear();
        try {
            Connection conn = dbcon.Connect();
            data = FXCollections.observableArrayList();
            // Execute query and store result in a resultset
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM expenses");
            while (rs.next()) {
                data.add(new ExpensesView(rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getString(4), rs.getString(5)));
            }
            
        } catch (SQLException ex) {
            System.err.println("Error Occured:" +ex);
        }
        
        //Setting cell value factory to table view
        IDColumn.setCellValueFactory(new PropertyValueFactory<>("EID"));
        TitleColumn.setCellValueFactory(new PropertyValueFactory<>("ETitle"));
        AmountColumn.setCellValueFactory(new PropertyValueFactory<>("EAmount"));
        DateColumn.setCellValueFactory(new PropertyValueFactory<>("EDate"));
        DescriptionColumn.setCellValueFactory(new PropertyValueFactory<>("EDescription"));
     
        
        
        ExpenseView.setItems(null);
        ExpenseView.setItems(data);
    }

    @FXML
    void updateDataFromDatabase(ActionEvent event) throws SQLException {
        
        if(Validation.DataValidation.TextFieldNotEmpty(updateEntertitleexpenses, titleLabel, "Title Required")
        
   ||Validation.DataValidation.TextFieldNotEmpty(updateAddAmountBtn, amountLabel, "Amount Required")
        ){
             if(this.AddAmountBtn.getText().matches("[a-zA-Z]+"))
        {
            JOptionPane.showMessageDialog(null,"Invalid AMount !");
        

        String eTitle = updateEntertitleexpenses.getText();
        //System.out.println(eTitle);
        Float eAmount = Float.parseFloat(updateAddAmountBtn.getText());
       //System.out.println(eAmount);
        LocalDate eDate = updateDateBtn.getValue();
        String eSDate = eDate.toString();
       
        String eDescription = updateAddescriptionBtn.getText();  
 
       
   
     int id = getID();
     
     
     //System.out.println(eSDate);
     //System.out.println(eDescription);
  
      
        String query = "UPDATE expenses SET ETitle = ?, EAmount = ?, EDate = ?, EDescription = ? WHERE EID =?";
        ps = null;
        
        try {
            Connection conn = dbcon.Connect();
            ps = conn.prepareStatement(query);
           ps.setString(1, eTitle);
            ps.setFloat(2,eAmount );
            ps.setString(3, eSDate);
            ps.setString(4, eDescription);
            ps.setInt(5, id);
 
            
            ps.execute();
            
            
               //  JOptionPane.showMessageDialog(null, "Data Updated Successfully");
            
            JOptionPane.showMessageDialog(null, "Data Updated Successfully");
           refreshDataFromDatabase();
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
    @FXML
    public void deleteDataFromDatabase(ActionEvent event) throws IOException{
        
        int ID = eID;
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
           
            ps = conn.prepareStatement("DELETE FROM expenses WHERE EID = ?");
            ps.setInt(1, ID);
         
                ps.executeUpdate();
                //JOptionPane.showMessageDialog(null, "Data Deleted");
                Alert successMsg = new Alert(Alert.AlertType.INFORMATION);
                successMsg.setTitle("SuccessFul");
                successMsg.setHeaderText(null);
                successMsg.setHeaderText("Expense Deleted SuccessFully..");
                successMsg.showAndWait();
                
        
          }catch (Exception ex) {
            System.out.println( "Exception in Deleting : " + ex );
            System.err.println("Error Occured:" +ex);
            
            
        }finally{
           // ps.execute();
            //ps.close();
        }
            
            
        }
    }else{
            //JOptionPane.showMessageDialog(null, "Please Select the row from tha table to delete!.."); 
            Alert successMsg = new Alert(Alert.AlertType.INFORMATION);
                
                successMsg.setTitle("Select a row..");
                successMsg.setHeaderText("Haven't Selected a row to Delete");
                successMsg.setContentText("Please Select a row from Table to Delete");
                
                successMsg.showAndWait();
        }
        refreshDataFromDatabase();
    }
    
    
     @FXML
    void getDataFromDatabase(ActionEvent event) {
         //Connection conn = dbcon.Connect();
        // ps = conn.prepareStatement(CommonConstants.QUERY_UPDATE_ExpensesView_DETAILS)
        //Entertitleexpenses.setText(eID.toString());
        //AddAmountBtn.getText();
         
        try{
         expenses = ExpenseView.getSelectionModel().getSelectedItem();
            String eTitle = expenses.getETitle();
         Entertitleexpenses.setText(eTitle.toString());
        }catch(Exception e){
            System.out.println("Exception in mouseclick : " + e );
        }
    }
    /*
     @FXML 
    public void loadSelectdDatafromDatabase() throws ParseException{
        
        try{
         expenses = ExpenseView.getSelectionModel().getSelectedItem();
         eID = expenses.getEID();
          System.out.println(eID);
         //searchButton.setText(eID.toString());
        }catch(Exception e){
            System.out.println("Exception in mouseclick : " + e );
        } 
        
        int ID = eID;
        
        String setETitle = null;
        String setEAmount = null;
        String setEDate = null;
        String setEDescription = null;
        
        
        
        String query = "SELECT * FROM expenses where EID = '"+ID+"'";
        
        try {
            Connection conn = dbcon.Connect(); 
            data = FXCollections.observableArrayList();
            // Execute query and store result in a resultset
            ResultSet rs = conn.createStatement().executeQuery(query);
           while (rs.next()) {
               
               data.add(new ExpensesView(rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getString(4), rs.getString(5)));

               
                setETitle = rs.getString(2);
                setEAmount = rs.getString(3);
                setEDate = rs.getString(4);
                setEDescription = rs.getString(5);
                System.out.println(setETitle);
                System.out.println(setEAmount);
            }
        LocalDate eDate = LocalDate.parse(setEDate);
        
        updateEntertitleexpenses.setText(setETitle);
        updateAddAmountBtn.setText(String.valueOf(setEAmount));
        updateDateBtn.setValue(eDate);
        updateAddescriptionBtn.setText(setEDescription);
           
        } catch (SQLException ex) {
            System.err.println("Error Occured:" +ex);
        }
           
            
        finally{
           // ps.execute();
            //ps.close();
        }
           
        
        
    }
*/
    private void initComponents() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}



              
    

