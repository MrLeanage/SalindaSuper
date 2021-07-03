/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinanceAndExpenses.Expenses;

 
import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ExpensesView {




    private IntegerProperty EID  = null;
    private StringProperty ETitle = null;
    private FloatProperty EAmount = null;
    private StringProperty EDate = null ;
    private StringProperty EDescription = null;
   
    
    public ExpensesView(){}
   

    //default constructor
    public ExpensesView(Integer EID, String ETitle, Float EAmount, String EDate, String EDescription) {
        
        this.EID = new SimpleIntegerProperty(EID);
        this.ETitle = new SimpleStringProperty(ETitle);
        this.EAmount = new SimpleFloatProperty(EAmount);
        this.EDate = new SimpleStringProperty(EDate);
        this.EDescription = new SimpleStringProperty(EDescription);
       
    }

    //getters
    public Integer getEID() {
        return EID.get();
    }

    public String getETitle() {
        return ETitle.get();
    }
    

    public String getEDate() {
        return EDate.get();
    }

    public Float getEAmount() {
        return EAmount.get();
    }
    public String getEDescription() {
        return EDescription.get();
    }
    public void setEID(Integer value) {
        EID.set(value);
    }

    public void setETitle(String value) {
       ETitle.set(value);
    }

    public void setEDate(String value) {
        EDate.set(value);
    }

    public void setEAmount(Float value) {
        EAmount.set(value);
    }

    public void setEDescription(String value) {
        EDescription.set(value);
    }

    public IntegerProperty EIDProperty() {
        return EID;
    }

    public StringProperty ETitleProperty() {
        return ETitle;
    }
    
    public StringProperty EDateProperty() {
        return EDate;
    }

    public StringProperty EDescriptionProperty() {
        return EDescription;
    }

    public FloatProperty EAmountProperty() {
        return EAmount;
    }


}