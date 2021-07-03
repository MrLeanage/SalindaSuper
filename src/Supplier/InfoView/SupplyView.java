/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Supplier.InfoView;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.transformation.SortedList;

/**
 *
 * @author nimesh :)
 */
public class SupplyView {

    public static void setItems(SortedList<SupplyView> sortedList) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static Object getSelectionModel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private IntegerProperty SID = null;
    private StringProperty SFirstName = null;
    private StringProperty SLastName = null;
    private StringProperty SAddress1 = null;
    private StringProperty SAddress2 = null;
    private StringProperty SCity = null;
    private StringProperty SProvince = null;
    private IntegerProperty SPhone1 = null;
    private IntegerProperty SPhone2 = null;
    private StringProperty SEmail = null;
    private SimpleStringProperty SRegistrationDate = null;

    public SupplyView() {
    }

    public SupplyView(Integer SID, String SFirstName, String SLastName, String SAddress1, String SAddress2, String SCity, String SProvince, Integer SPhone1, Integer SPhone2, String SEmail, String SRegistrationDate) {

        this.SID = new SimpleIntegerProperty(SID);
        this.SFirstName = new SimpleStringProperty(SFirstName);
        this.SLastName = new SimpleStringProperty(SLastName);
        this.SAddress1 = new SimpleStringProperty(SAddress1);
        this.SAddress2 = new SimpleStringProperty(SAddress2);
        this.SCity = new SimpleStringProperty(SCity);
        this.SProvince = new SimpleStringProperty(SProvince);
        this.SPhone1 = new SimpleIntegerProperty(SPhone1);
        this.SPhone2 = new SimpleIntegerProperty(SPhone2);
        this.SEmail = new SimpleStringProperty(SEmail);
        this.SRegistrationDate = new SimpleStringProperty(SRegistrationDate);
    }

    //Getters
    public Integer getSID() {
        return SID.get();
    }

    public String getSFirstName() {
        return SFirstName.get();
    }

    public String getSLastName() {
        return SLastName.get();
    }

    public String getSAddress1() {
        return SAddress1.get();
    }

    public String getSAddress2() {
        return SAddress2.get();
    }

    public String getSCity() {
        return SCity.get();
    }

    public String getSprovince() {
        return SProvince.get();
    }

    public int getSPhone1() {
        return SPhone1.get();
    }

    public int getSPhone2() {
        return SPhone2.get();
    }

    public String getSEmail() {
        return SEmail.get();
    }

    public String getSRegistrationDate() {
        return SRegistrationDate.get();
    }

    //Setters
    public void setSID(Integer value) {
        SID.set(value);
    }

    public void setSFirstName(String value) {
        SFirstName.set(value);
    }

    public void setSLastName(String value) {
        SLastName.set(value);
    }

    public void setSAddress1(String value) {
        SAddress1.set(value);
    }

    public void setSAddress2(String value) {
        SAddress2.set(value);
    }

    public void setSCity(String value) {
        SCity.set(value);
    }

    public void setSProvince(String value) {
        SProvince.set(value);
    }

    public void setSPhone1(Integer value) {
        SPhone1.set(value);
    }

    public void setSPhone2(Integer value) {
        SPhone2.set(value);
    }

    public void setSEmail(String value) {
        SEmail.set(value);
    }

    public void setSRegistrationDate(String value) {
        SRegistrationDate.set(value);
    }

    //Property values
    public IntegerProperty SIDProperty() {
        return SID;
    }

    public StringProperty SFirstNameProperty() {
        return SFirstName;
    }

    public StringProperty SLastNameProperty() {
        return SLastName;
    }

    public StringProperty SAddress1Property() {
        return SAddress1;
    }

    public StringProperty SAddress2Property() {
        return SAddress2;
    }

    public StringProperty SCityProperty() {
        return SCity;
    }

    public StringProperty SProvinceProperty() {
        return SProvince;
    }

    public IntegerProperty SPhone1Property() {
        return SPhone1;
    }

    public IntegerProperty SPhone2Property() {
        return SPhone2;
    }

    public StringProperty SEmailProperty() {
        return SEmail;
    }

    public SimpleStringProperty SRegistrationDateProperty() {
        return SRegistrationDate;
    }

    public Integer getID() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    

}
