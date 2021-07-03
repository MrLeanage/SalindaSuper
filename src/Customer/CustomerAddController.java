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
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import java.sql.PreparedStatement;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
//import java.time.LocalDate;
import javafx.collections.ObservableList;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Hansini
 */
public class CustomerAddController implements Initializable {

    @FXML
    private AnchorPane rootpane;

    /**
     * Initializes the controller class.
     */
    @FXML
    private TextField Fname;
    @FXML
    private TextField Lname;
    @FXML
    private TextField CAddress1;
    @FXML
    private TextField CAddress2;
    @FXML
    private TextField CC;
    @FXML
    private TextField CProvi;
    @FXML
    private TextField CPhone1;
 @FXML
    private TextField CPh;
    @FXML
    private TextField CEmail;
    @FXML
    private DatePicker CRegDate;
    //Validation Labels
     @FXML
    private Label CAddLabelFName;

    @FXML
    private Label CAddLabelLName;

    @FXML
    private Label CAddLabelAddress1;

    @FXML
    private Label CAddLabelAddress2;

    @FXML
    private Label CAddLabelRegDate;

    @FXML
    private Label CAddLabelCity;

    @FXML
    private Label CAddLabelProvince;

    @FXML
    private Label CAddLabelPhone;

    @FXML
    private Label CAddLabelEmail;
    /*@FXML
    private Button add;*/
    
    @FXML
    private void goCustomerView(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Customerinfoview.fxml"));
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
    private void goCustomerHome(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("CustomerHome.fxml"));
        rootpane.getChildren().setAll(pane);
    }
    @FXML
    private void goCustomerAdd(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("CustomerAdd.fxml"));
        rootpane.getChildren().setAll(pane);
    }
    
    
    private DBConnection dbcon;
    private ObservableList<CustomerView> data;
    private PreparedStatement ps;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        dbcon = new DBConnection();
    }

    @FXML
    public void AddCustomer(ActionEvent event) throws SQLException {
        
//if(this.CPhone1.getText().length()<10)
//       {
//          JOptionPane.showMessageDialog(null, "Invalid Phone number !");
//
//       }   
//if(this.CPh.getText().length()<10)
//       {
//          JOptionPane.showMessageDialog(null, "Invalid Phone number !");
//
//       }   

//if(this.CEmail.getText().charAt(i== @)){
           //   JOptionPane.showMessageDialog(null, "Invalid Email Address !");

//}

///Validation.DataValidation.TextFieldNotEmpty(AddDateBtn, dataLabel, "Date Is Required");


//if(Validation.ValidationPart.TextFieldNotEmpty(Fname, Fname, "First Name Required"))

         if(Validation.DataValidation.TextFieldNotEmpty(Fname, CAddLabelFName, " First Name is required..")
        
   || Validation.DataValidation.TextFieldNotEmpty(Lname, CAddLabelLName, " Last Name is required..")
   || Validation.DataValidation.TextFieldNotEmpty(CAddress1, CAddLabelAddress1, "Address 01 Required")
   || Validation.DataValidation.TextFieldNotEmpty(CAddress2, CAddLabelAddress2, "Address 02 Required")
   || Validation.DataValidation.TextFieldNotEmpty(CC, CAddLabelCity, "City  Required")
   || Validation.DataValidation.TextFieldNotEmpty(CProvi, CAddLabelProvince, "Province  Required")
   || Validation.DataValidation.TextFieldNotEmpty(CPhone1, CAddLabelPhone, "Phone number  Required")
     || Validation.DataValidation.TextFieldNotEmpty(CEmail, CAddLabelEmail, " Email  Required")
                 )
      if((this.CPhone1.getText().length()!=10)||(this.CPh.getText().length()!=10))
       {
          JOptionPane.showMessageDialog(null, "Invalid Phone number !");

       } 
         else
      {
     
       
      

         {
             
              if(Fname.getText().length()>0)
              {

      String CFName = Fname.getText();
        String CLName = Lname.getText();
        String CAdd1 = CAddress1.getText();
        String CAdd2 = CAddress2.getText();
        String CCity =  this.CC.getText();
        String Cprovince = this.CProvi.getText();
        int Cphone1 = Integer.parseInt(this.CPhone1.getText());
        int Cphone2 = Integer.parseInt(this.CPh.getText());
        String Cemail = CEmail.getText();
        //String SsRegDate =CRegDate.getText();
       LocalDate pMDate = CRegDate.getValue();
       String CcRegDate = pMDate.toString();
       
      

       if(this.CPhone1.getText().length()!=10)
       {
          JOptionPane.showMessageDialog(null, "Invalid Phone number !");

       }
       else
       {
           
           if(Cemail.contains("@"))
           {
       
        String query ="INSERT INTO customer(CFirstName,CLastName,CAddress1,CAddress2,CCity,CProvince,CPhone1,CPhone2,CEmail,CRegistrationDate) VALUES(?,?,?,?,?,?,?,?,?,?)";
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
            ps.setInt(8, Cphone2);
            ps.setString(9, Cemail);
            //ps.setString(10, SsRegDate);
           ps.setString(10, CcRegDate);
                 int i=ps.executeUpdate();
                if(i==1){
                    System.out.println("Data inserted successfully");
                      Fname.setText("");
                     Lname.clear();
                     CAddress1.clear();
                     CAddress2.clear();
                     CC.clear();
                     CProvi.clear();
                     CPhone1.clear();
                     CPh.clear();
                     CEmail.clear();
                    

                  JOptionPane.showMessageDialog(null, "Added a new customer successfully !");
                        setCustomerTable();
                     loadDataFromDataBase();
                     
                
                }
                //JOptionPane.showMessageDialog(null, "Data inserted successfully !");
        }  catch (SQLException ex) {
            System.err.println("Error Occured:" + ex);
        } finally {
            ps.execute();
            ps.close();
        }
       }
           else
           {
                                 JOptionPane.showMessageDialog(null, "Invalid Email !");
           }
         }
              }
         }
      }
    }

    /*private void setCustomerTable() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/

    /*private void loadDataFromDataBase() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/
    private void loadDataFromDataBase() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    private void setCustomerTable() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    }
