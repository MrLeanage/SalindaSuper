/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BillingAndIncome;

import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleStringProperty;


/**
 *
 * @author Danushi Pathirana
 */
public class ItemTable {
    
    private int DocumentT;
    private String Item_NameT;
    private Float Unit_PriceT;
    private Float QuantityT;
    private Float Total_amountT;
    
    public ItemTable(int DocumentT,String Item_NameT,float Unit_PriceT,float QuantityT,float Total_amountT ){
        
        this.DocumentT=DocumentT;
        this.Item_NameT=Item_NameT;
        this.Unit_PriceT=Unit_PriceT;
        this.QuantityT=QuantityT;
        this.Total_amountT=Total_amountT;
        
        
    }

    public int getDocumentT() {
        return DocumentT;
    }

    public void setDocumentT(int DocumentT) {
        this.DocumentT = DocumentT;
    }

    public String getItem_NameT() {
        return Item_NameT;
    }

    public Float getUnit_PriceT() {
        return Unit_PriceT;
    }

    public Float getQuantityT() {
        return QuantityT;
    }

    public Float getTotal_amountT() {
        return Total_amountT;
    }

    public void setItem_NameT(String Item_NameT) {
        this.Item_NameT=Item_NameT;
    }

    public void setUnit_PriceT(Float Unit_PriceT) {
        this.Unit_PriceT=Unit_PriceT;
    }

    public void setQuantityT(Float QuantityT) {
        this.QuantityT=QuantityT;
    }

    public void setTotal_amountT(Float Total_amountT) {
        this.Total_amountT=Total_amountT;
    }
    
}
