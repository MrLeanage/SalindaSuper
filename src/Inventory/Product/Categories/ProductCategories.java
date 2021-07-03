/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inventory.Product.Categories;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author dulshan
 */
public class ProductCategories {
    private IntegerProperty pCatID = null;
    private StringProperty pCatType = null;
    public StringProperty pCatSubType = null;
    
    
    public ProductCategories(){
        //default constructor
    }
    public ProductCategories(Integer pCatID, String pCatType, String pCatSubType) {
        
        this.pCatID = new SimpleIntegerProperty(pCatID);
        this.pCatType = new SimpleStringProperty(pCatType);
        this.pCatSubType = new SimpleStringProperty(pCatSubType);
    }
        //getters
    public Integer getPCatID() {
        return pCatID.get();
    }

    public String getPCatType() {
        return pCatType.get();
    }

    public String getPCatSubType() {
        return pCatSubType.get();
    
    }
    //setters
    public void setPCatID(Integer value) {
        pCatID.set(value);
    }

    public void setPCatType(String value) {
        pCatType.set(value);
    }

    public void setPCatSubType(String value) {
        pCatSubType.set(value);
    }
    
     //Property values
    public IntegerProperty pCatIDProperty() {
        return pCatID;
    }

    public StringProperty pCatTypeProperty() {
        return pCatType;
    }

    public StringProperty pCatSubTypeProperty() {
        return pCatSubType;
    }

    
}
