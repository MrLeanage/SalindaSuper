/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Supplier;

import DBConnect.DBConnection;
import Supplier.InfoView.SupplyView;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
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
 * @author nimesh :)
 */
public class SupplierupdateController implements Initializable {
    
    private Integer sID;
    private SupplyView SupplyID = new SupplyView();
    SupplyView supplier;
    private DBConnection dbcon;
    private PreparedStatement ps;
    private ObservableList<SupplyView> data;
    
    @FXML
    private void goSupplierView(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("supplierinfoview.fxml"));
        rootpane.getChildren().setAll(pane);
    }

    @FXML
    private void goSupplierDelete(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("supplierdelete.fxml"));
        rootpane.getChildren().setAll(pane);
    }

    @FXML
    private void goSupplierHome(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("supplierhome.fxml"));
        rootpane.getChildren().setAll(pane);
    }

    @FXML
    private void goSupplierAdd(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("supplieradd.fxml"));
        rootpane.getChildren().setAll(pane);
    }

    @FXML
    private void goSupplierUpdate(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("supplierupdate.fxml"));
        rootpane.getChildren().setAll(pane);
    }


    @FXML
    private AnchorPane rootpane;
    @FXML
    private TextField Fname;
    @FXML
    private TextField Lname;
    @FXML
    private TextField SAddress1;
    @FXML
    private TextField SAddress2;
    @FXML
    private TextField SCity;
    @FXML
    private TextField SProvince;
    @FXML
    private TextField SPhone1;
    @FXML
    private TextField SPhone2;
    @FXML
    private TextField SEmail;
    
    @FXML
    private TableView<SupplyView> SupplyViewTable;
    @FXML
    private TableColumn<SupplyView, Integer> SIDColumn;
    @FXML
    private TableColumn<SupplyView, String> SNameColumn;
    @FXML
    private TableColumn<SupplyView, String> SPhone1Column;
    @FXML
    private TableColumn<SupplyView, String> SEmailColumn;
    
    //Validation Labels
    @FXML
    private Label SNameLabel;
    @FXML
    private Label SLastNameLabel;
    @FXML
    private Label SAddress1Lable;
    @FXML
    private Label SAddress2Lable;
    @FXML
    private Label SCityLable;
    @FXML
    private Label SProvinceLable;
    @FXML
    private Label SPhone1Lable;
    @FXML
    private Label SPhone2Lable;
    @FXML
    private Label SEmailLable;

    

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
      // Connection conn = dbcon.Connect(); 
    } 
        
    @FXML
    private void loadview(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("supplierinfoview.fxml"));
        rootpane.getChildren().setAll(pane);
         
    }
    @FXML
    private void ClearForm(){
        Fname.clear();
        Lname.clear();
        SAddress1.clear();
        SAddress2.clear();
        SCity.clear();
        SProvince.clear();
        SPhone1.clear();
        SPhone2.clear();
        SEmail.clear();
   
    }
     
    @FXML
    private void loadDatafromDB(ActionEvent event) {
        
       try {
            Connection conn = dbcon.Connect();
            data = FXCollections.observableArrayList();
            // Execute query and store result in a resultset
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM supplier");
            while (rs.next()) {
                data.add(new SupplyView(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getInt(9), rs.getString(10), rs.getString(11)));
                //SID              FirstName        SecondName         Address1         Address2        City            Province        Phone1          Phone2          Email           RegDate     ////
            }

        } catch (SQLException ex) {
            System.err.println("Error Occured:" + ex);
        }

        //Setting cell value factory to table view
        SIDColumn.setCellValueFactory(new PropertyValueFactory<>("SID"));
        SNameColumn.setCellValueFactory(new PropertyValueFactory<>("SFirstName"));
        SPhone1Column.setCellValueFactory(new PropertyValueFactory<>("SPhone1"));
        SEmailColumn.setCellValueFactory(new PropertyValueFactory<>("SEmail"));

        SupplyViewTable.setItems(null);
        SupplyViewTable.setItems(data);
    }
    @FXML
    public void refresh(){
        data.clear();
        try {
            Connection conn = dbcon.Connect();
            data = FXCollections.observableArrayList();
            // Execute query and store result in a resultset
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM supplier");
            while (rs.next()) {
                data.add(new SupplyView(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getInt(9), rs.getString(10), rs.getString(11)));
                //SID              FirstName        SecondName         Address1         Address2        City            Province        Phone1          Phone2          Email           RegDate     ////
            }

        } catch (SQLException ex) {
            System.err.println("Error Occured:" + ex);
        }

        //Setting cell value factory to table view
        SIDColumn.setCellValueFactory(new PropertyValueFactory<>("SID"));
        SNameColumn.setCellValueFactory(new PropertyValueFactory<>("SFirstName"));
        SPhone1Column.setCellValueFactory(new PropertyValueFactory<>("SPhone1"));
        SEmailColumn.setCellValueFactory(new PropertyValueFactory<>("SEmail"));

        SupplyViewTable.setItems(null);
        SupplyViewTable.setItems(data);

    }
   @FXML 
    public void loadSelectdDatafromDatabase() throws ParseException{
        
         try {
            SupplyID = SupplyViewTable.getSelectionModel().getSelectedItem();

            sID = SupplyID.getSID();
            System.out.println(sID);
            //searchButton.setText(eID.toString());
        } catch (Exception e) {
            System.out.println("Exception in mouseclick : " + e);
        }
        int ID = sID;

        String setSFirstName = null;
        String setSLastName = null;
        String setSAddress1 = null;
        String setSAddress2 = null;
        String setSCity = null;
        String setSProvince = null;
        Integer setSPhone1 = 0;
        Integer setSPhone2 = 0;
        String setSEmail = null;

        String query = "SELECT * FROM supplier where SID = '" + ID + "'";

        try {
            Connection conn = dbcon.Connect();
            data = FXCollections.observableArrayList();
            // Execute query and store result in a resultset
            ResultSet rs = conn.createStatement().executeQuery(query);
            while (rs.next()) {

                data.add(new SupplyView(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getInt(9), rs.getString(10), rs.getString(11)));
                //SID              FirstName        SecondName         Address1         Address2        City            Province        Phone1          Phone2          Email           RegDate     ////

                setSFirstName = rs.getString(2);
                setSLastName = rs.getString(3);
                setSAddress1 = rs.getString(4);
                setSAddress2 = rs.getString(5);
                setSCity = rs.getString(6);
                setSProvince = rs.getString(7);
                setSPhone1 = rs.getInt(8);
                setSPhone2 = rs.getInt(9);
                setSEmail = rs.getString(10);
                
            }
          
            Fname.setText(setSFirstName);
            Lname.setText(String.valueOf(setSLastName));
            SAddress1.setText(String.valueOf(setSAddress1));
            SAddress2.setText(String.valueOf(setSAddress2));
            SCity.setText(String.valueOf(setSCity));
            SProvince.setText(String.valueOf(setSProvince));
            SPhone1.setText(String.valueOf(setSPhone1));
            SPhone2.setText(String.valueOf(setSPhone2));
            SEmail.setText(String.valueOf(setSEmail));

           // data.add(new ProductView(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getFloat(5), rs.getFloat(6), rs.getFloat(7), rs.getFloat(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15), rs.getString(16), rs.getString(17)));
                   // public ProductView(String pID, String pName, Integer pUnits, Integer pBlocks, Float pWeight, Float pSDiscounts, Float pBPrice, Float pSPrice, String pMDate, String pExpDate, String pDADate, String pModDate, String pADate) {
                   
            
         } catch (SQLException ex) {
            System.err.println("Error Occured:" + ex);
        } finally {
            // ps.execute();
            //ps.close();
        }

        
    }
    
    @FXML
    private void UpdateProductsToDatabase(ActionEvent event) throws SQLException {
                if (Validation.DataValidation.TextFieldNotEmpty(Fname, SNameLabel, "Last Name Req.")
                || Validation.DataValidation.TextFieldNotEmpty(Lname, SLastNameLabel, " First Name Req.")
                || Validation.DataValidation.TextFieldNotEmpty(SAddress1, SAddress1Lable, "Address1 Req.")
                || Validation.DataValidation.TextFieldNotEmpty(SAddress2, SAddress2Lable, "Address2 Req.")
                || Validation.DataValidation.TextFieldNotEmpty(SCity, SCityLable, "City Req.")
                || Validation.DataValidation.TextFieldNotEmpty(SProvince, SProvinceLable, "Province Req.")
                || Validation.DataValidation.TextFieldNotEmpty(SPhone1, SPhone1Lable, "LandPhone no. Req.")
                || Validation.DataValidation.TextFieldNotEmpty(SPhone2, SPhone2Lable, "CellPhone no. Req.")
                || Validation.DataValidation.TextFieldNotEmpty(SEmail, SEmailLable, "Email Req.")) 
        
                {

            String SFName = Fname.getText();
            String SLName = Lname.getText();
            String SAdd1 = SAddress1.getText();
            String SAdd2 = SAddress2.getText();
            String sCity = SCity.getText();
            String Sprovince = SProvince.getText();
            Integer Sphone1 = Integer.parseInt(SPhone1.getText());
            Integer Sphone2 = Integer.parseInt(SPhone2.getText());
            String Semail = SEmail.getText();
            //LocalDate pMDate = SRegDate.getValue();
            //String SsRegDate = pMDate.toString();
        
        
            String query = "UPDATE supplier set(SFirstName=?,SLastName=?,SAddress1=?,SAddress2=?,SCity=?,SProvince=?,SPhone1=?,SPhone2=?,SEmail=?,SRegistrationDate=?)";
            ps = null;
            try {
                Connection conn = dbcon.Connect();
                ps = conn.prepareStatement(query);
                ps.setString(1, SFName);
                ps.setString(2, SLName);
                ps.setString(3, SAdd1);
                ps.setString(4, SAdd2);
                ps.setString(5, sCity);
                ps.setString(6, Sprovince);
                ps.setInt(7, Sphone1);
                ps.setInt(8, Sphone2);
                ps.setString(9, Semail);
                //ps.setString(10, SsRegDate);

                JOptionPane.showMessageDialog(null, "Data Updated Successfuly");
                refresh();

            } catch (SQLException ex) {
                System.err.println("Error Occured:" + ex);
            } finally {
                ps.execute();
                ps.close();
            }
            ClearForm();
        }
    }
    
}
    

