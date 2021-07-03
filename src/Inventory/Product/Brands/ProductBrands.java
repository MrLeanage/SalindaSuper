/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inventory.Product.Brands;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author dulshan
 */
public class ProductBrands {
    private IntegerProperty pBID = null;
    private StringProperty pBName = null;
    public StringProperty pBDiscription = null;
    
    
    public ProductBrands(){
        //default constructor
    }
    public ProductBrands(Integer pBID, String pBName, String pBDiscription) {
        
        this.pBID = new SimpleIntegerProperty(pBID);
        this.pBName = new SimpleStringProperty(pBName);
        this.pBDiscription = new SimpleStringProperty(pBDiscription);
    }
        //getters
    public Integer getPBID() {
        return pBID.get();
    }

    public String getPBName() {
        return pBName.get();
    }

    public String getPBDescription() {
        return pBDiscription.get();
    
    }
    //setters
    public void setPBID(Integer value) {
        pBID.set(value);
    }

    public void setPBName(String value) {
        pBName.set(value);
    }

    public void setPBDescription(String value) {
        pBDiscription.set(value);
    }
    
     //Property values
    public IntegerProperty pBIDProperty() {
        return pBID;
    }

    public StringProperty pBNameProperty() {
        return pBName;
    }

    public StringProperty pBDiscriptionProperty() {
        return pBDiscription;
    }
}

