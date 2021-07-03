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
import javafx.collections.ObservableList;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author nimesh :)
 */
public class SupplieraddController implements Initializable {

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
    private DatePicker SRegDate;
    
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
    /*@FXML
    private Label SRegDateLable;*/

    @FXML
    private void goSupplierView(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("supplierinfoview.fxml"));
        rootpane.getChildren().setAll(pane);
    }

    @FXML
    private void goSupplierUpdate(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("supplierupdate.fxml"));
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
    void loadview(ActionEvent event) {

    }
    private DBConnection dbcon;
    private ObservableList<SupplyView> data;
    private PreparedStatement ps;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        dbcon = new DBConnection();
    }

    @FXML
    void AddSupplier(ActionEvent event) throws SQLException {

        if (Validation.DataValidation.TextFieldNotEmpty(Fname, SNameLabel, "Last Name Req.")
                || Validation.DataValidation.TextFieldNotEmpty(Lname, SLastNameLabel, " First Name Req.")
                || Validation.DataValidation.TextFieldNotEmpty(SAddress1, SAddress1Lable, "Address1 Req.")
                || Validation.DataValidation.TextFieldNotEmpty(SAddress2, SAddress2Lable, "Address2 Req.")
                || Validation.DataValidation.TextFieldNotEmpty(SCity, SCityLable, "City Req.")
                || Validation.DataValidation.TextFieldNotEmpty(SProvince, SProvinceLable, "Province Req.")
                || Validation.DataValidation.TextFieldNotEmpty(SPhone1, SPhone1Lable, "LandPhone no. Req.")
                || Validation.DataValidation.TextFieldNotEmpty(SPhone2, SPhone2Lable, "CellPhone no. Req.")
                || Validation.DataValidation.TextFieldNotEmpty(SEmail, SEmailLable, "Email Req.")
                
                ) {
            
            String SFName = Fname.getText();
            String SLName = Lname.getText();
            String SAdd1 = SAddress1.getText();
            String SAdd2 = SAddress2.getText();
            String sCity = SCity.getText();
            String Sprovince = SProvince.getText();
            Integer Sphone1 = Integer.parseInt(SPhone1.getText());
            Integer Sphone2 = Integer.parseInt(SPhone2.getText());
            String Semail = SEmail.getText();
            LocalDate pMDate = SRegDate.getValue();
            String SsRegDate = pMDate.toString();

            String query = "INSERT INTO supplier(SFirstName,SLastName,SAddress1,SAddress2,SCity,SProvince,SPhone1,SPhone2,SEmail,SRegistrationDate) VALUES(?,?,?,?,?,?,?,?,?,?)";
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
                ps.setString(10, SsRegDate);

                JOptionPane.showMessageDialog(null, "Data Inserted Successfuly");

            } catch (SQLException ex) {
                System.err.println("Error Occured:" + ex);
            } finally {
                ps.execute();
                ps.close();
            }
        }
    }
    

 }
