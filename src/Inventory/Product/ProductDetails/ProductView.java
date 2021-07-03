//Model class hoslding getters, setters and properties for products
package Inventory.Product.ProductDetails;


import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author dulshan
 */
public class ProductView {

    private IntegerProperty pID = null;
    private StringProperty pName = null;
    public IntegerProperty pUnits = null;
    private IntegerProperty pBlocks = null;
    private FloatProperty pWeight = null;
    private FloatProperty pSDiscounts = null;
    private FloatProperty pBPrice = null;
    private FloatProperty pSPrice = null;
    private StringProperty pMDate = null;
    private StringProperty pExpDate = null;
    private StringProperty pDADate = null;
    private StringProperty pModDate = null;
    private StringProperty pADate = null;
    private StringProperty pSerial = null;
    private StringProperty pSupplier = null;
    private StringProperty pCategory = null;
    private StringProperty pBrand = null;
    private FloatProperty pTotal = null;
    
    
   
    public ProductView(){
        
    }
    //default constructor
    public ProductView(Integer pID, String pName, Integer pUnits, Integer pBlocks, Float pWeight, Float pSDiscounts, Float pBPrice, Float pSPrice, String pMDate, String pExpDate, String pDADate, String pModDate, String pADate,String pSerial, String pSupplier, String pCategory, String pBrand) {
        
        this.pID = new SimpleIntegerProperty(pID);
        this.pName = new SimpleStringProperty(pName);
        this.pUnits = new SimpleIntegerProperty(pUnits);
        this.pBlocks = new SimpleIntegerProperty(pBlocks);
        this.pWeight = new SimpleFloatProperty(pWeight);
        this.pSDiscounts = new SimpleFloatProperty(pSDiscounts);
        this.pBPrice = new SimpleFloatProperty(pBPrice);
        this.pSPrice = new SimpleFloatProperty(pSPrice);
        this.pMDate = new SimpleStringProperty(pMDate);
        this.pExpDate = new SimpleStringProperty(pExpDate);
        this.pDADate = new SimpleStringProperty(pDADate);
        this.pModDate = new SimpleStringProperty(pModDate);
        this.pADate = new SimpleStringProperty(pADate);
        this.pSerial = new SimpleStringProperty(pSerial);
        this.pSupplier = new SimpleStringProperty(pSupplier);
        this.pCategory = new SimpleStringProperty(pCategory);
        this.pBrand = new SimpleStringProperty(pBrand);
        
       /*
        this.pMDate = pMDate;
        this.pExpDate = pExpDate;
        this.pDADate = pDADate;
        this.pModDate = pModDate;
        this.pADate = pADate;
        */
    }

    
    

    //getters
    public Integer getPID() {
        return pID.get();
    }

    public String getPName() {
        return pName.get();
    }

    public Integer getPUnits() {
        return pUnits.get();
    }

    public Integer getPBlocks() {
        return pBlocks.get();
    }
    public Float getPWeight() {
        return pWeight.get();
    }
    public Float getPSDiscounts() {
        return pSDiscounts.get();
    }

    public Float getPBPrice() {
        return pBPrice.get();
    }

    public Float getPSPrice() {
        return pSPrice.get();
    }

    public String getPMDate() {
        return pMDate.get();
    }

    public String getPExpDate() {
        return pExpDate.get();
    }

    public String getPDADate() {
        return pDADate.get();
    }

    public String getPModDate() {
        return pModDate.get();
    }

    public String getPADate() {
        return pADate.get();
    }
    public String getPSerial() {
        return pSerial.get();
    }
    public String getPSupplier() {
        return pSupplier.get();
    }
    public String getPCategory() {
        return pCategory.get();
    }
    public String getPBrand() {
        return pBrand.get();
    }
    

    //setters
    public void setPID(Integer value) {
        pID.set(value);
    }

    public void setPName(String value) {
        pName.set(value);
    }

    public void setPUnits(Integer value) {
        pUnits.set(value);
    }

    public void setPBlocks(Integer value) {
        pBlocks.set(value);
    }

    public void setPWeight(Float value) {
        pWeight.set(value);
    }
    
    public void setPSDiscounts(Float value) {
        pSDiscounts.set(value);
    }

    public void setPBPrice(Float value) {
        pBPrice.set(value);
    }

    public void setPSPrice(Float value) {
        pSPrice.set(value);
    }

    public void setPMDate(String value) {pMDate.set(value);}

    public void setPExpDate(String value) {pExpDate.set(value);}

    public void setPDADate(String value) {pDADate.set(value);}

    public void setPModDate(String value) {pModDate.set(value);}

    public void setPADate(String value) {pADate.set(value);}
    public void setPSerial(String value) {pSerial.set(value);}
    public void setPSupplier(String value) {pSupplier.set(value);}
    public void setPCategory(String value) {pCategory.set(value);}
    public void setPBrand(String value) {pBrand.set(value);}
    
    public void setTotal() {
        
        
        //pTotal = pUnits * pBlocks;}
    }
    
    
    
    

 /*   
    public void setPMDate(Date value) {pMDate.set(value);}

    public void setPExpDate(Date value) {pExpDate.set(value);}

    public void setPDADate(Date value) {pDADate.set(value);}

    public void setPModDate(Date value) {pModDate.set(value);}

    public void setPADate(Date value) {pADate.set(value);}
*/
    //Property values
    public IntegerProperty pIDProperty() {
        return pID;
    }

    public StringProperty pNameProperty() {
        return pName;
    }

    public IntegerProperty pUnitsProperty() {
        return pUnits;
    }

    public IntegerProperty pBlocksProperty() {
        return pBlocks;
    }

    public FloatProperty pWeightProperty() {
        return pWeight;
    }
    
    public FloatProperty pSDiscountsProperty() {
        return pSDiscounts;
    }

    public FloatProperty pBPriceProperty() {
        return pBPrice;
    }

    public FloatProperty pSPriceProperty() {
        return pSPrice;
    }

    public StringProperty pMDateProperty() {
        return pMDate;
    }

    public StringProperty pExpDateProperty() {
        return pExpDate;
    }

    public StringProperty pDADateProperty() {
        return pDADate;
    }

    public StringProperty pModDateProperty() {
        return pModDate;
    }

    public StringProperty pADateProperty() {
        return pADate;
    }
    public StringProperty pSerialProperty() {
        return pSerial;
    }
    public StringProperty pSupplierProperty() {
        return pSupplier;
    }
    public StringProperty pCategoryProperty() {
        return pCategory;
    }
    public StringProperty pBrandProperty() {
        return pBrand;
    }

    
}
