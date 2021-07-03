/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Customer.InfoView;

//import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Hansini
 */


public class CustomerView {

    public static Object getSelectionModel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private  IntegerProperty CID=null;
    private  StringProperty CFirstName=null;
    private  StringProperty CLastName=null;
    private  StringProperty CAddress1=null;
    private  StringProperty CAddress2=null;
    private  StringProperty CCity=null;
    private  StringProperty CProvince=null;
    private  IntegerProperty CPhone1=null;
    private  IntegerProperty CPhone2=null;
    private  StringProperty CEmail=null;
    private  StringProperty CRegistrationDate=null;
//    private  FloatProperty  CDisscount=null;
//    private  FloatProperty  COutStand=null;
    
public  CustomerView( ){

}
    public CustomerView(Integer CID, String CFirstName, String CLastName, String CAddress1, String CAddress2, String CCity, String CProvince, Integer CPhone1, Integer CPhone2, String CEmail, String CRegistrationDate) {

        this.CID = new SimpleIntegerProperty(CID);
        this.CFirstName = new SimpleStringProperty(CFirstName);
        this.CLastName = new SimpleStringProperty(CLastName);
        this.CAddress1 = new SimpleStringProperty(CAddress1);
        this.CAddress2 = new SimpleStringProperty(CAddress2);
        this.CCity = new SimpleStringProperty(CCity);
        this.CProvince = new SimpleStringProperty(CProvince);
        this.CPhone1 = new SimpleIntegerProperty(CPhone1);
        this.CPhone2 = new SimpleIntegerProperty(CPhone2);
        this.CEmail = new SimpleStringProperty(CEmail);
        this.CRegistrationDate = new SimpleStringProperty(CRegistrationDate);
        
    }

    public CustomerView(int aInt, String string, String string0, String string1, String string2, String string3, String string4, int aInt0, String string5, String string6) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public CustomerView(int aInt, String string, String string0, String string1, String string2, String string3, String string4, int aInt0, String string5, String string6, float aFloat, float aFloat0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   

    //Getters
    public Integer getCID() {
        return CID.get();
    }

    public String getCFirstName() {
        return CFirstName.get();
    }

    public String getCLastName() {
        return CLastName.get();
    }

    public String getCAddress1() {
        return CAddress1.get();
    }

    public String getCAddress2() {
        return CAddress2.get();
    }

    public String getCCity() {
        return CCity.get();
    }

    public String getCprovince() {
        return CProvince.get();
    }

    public int getCPhone1() {
        return CPhone1.get();
    }

    public int getCPhone2() {
        return CPhone2.get();
    }

    public String getCEmail() {
        return CEmail.get();
    }

    public String getCRegistrationDate() {
        return CRegistrationDate.get();
    }

    //Setters
    public void setCID(Integer value){
        CID.set(value);
    }
    
    public void setCFirstName(String value){
        CFirstName.set(value);
    }
    
    public void setCLastName(String value){
        CLastName.set(value);
    }
    
    public void setCAddress1(String value){
        CAddress1.set(value);
    }
    
    public void setCAddress2(String value){
        CAddress2.set(value);
    }
    
    public void setCCity(String value){
        CCity.set(value);
    }
    
    public void setCProvince(String value){
        CProvince.set(value);
    }
    
    public void setCPhone1(Integer value){
        CPhone1.set(value);
    }
    
    public void setCPhone2(Integer value){
        CPhone2.set(value);
    }
    
    public void setCEmail(String value){
        CEmail.set(value);
    }
    
    public void setCRegistrationDate(String value){
        CRegistrationDate.set(value);
    }
    
    //Property values
    public IntegerProperty CIDProperty(){
        return CID;
    }
    
    public StringProperty CFirstNameProperty(){
        return CFirstName;
    }
    
    public StringProperty CLastNameProperty(){
        return CLastName;
    }
    
    public StringProperty CAddress1Property(){
        return CAddress1;
    }
    
    public StringProperty CAddress2Property(){
        return CAddress2;
    }
    
    public StringProperty CCityProperty(){
        return CCity;
    }
    
    public StringProperty CProvinceProperty(){
        return CProvince;
    }
    
    public IntegerProperty CPhone1Property(){
        return CPhone1;
    }
    
    public IntegerProperty CPhone2Property(){
        return CPhone2;
    }
    
    public StringProperty CEmailProperty(){
        return CEmail;
    }
    
    public StringProperty CRegistrationDateProperty(){
        return CRegistrationDate;
    }
    
    
}
