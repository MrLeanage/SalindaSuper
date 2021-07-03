/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BillingAndIncome;

/**
 *
 * @author Danushi Pathirana
 */
public class databaseloadtable {
    
    String PName;
    int PID;
    float PBuyingPricePerUnit;

    public databaseloadtable(String PName, int PID, float PBuyingPricePerUnit) {
        this.PName = PName;
        this.PID = PID;
        this.PBuyingPricePerUnit = PBuyingPricePerUnit;
    }

    public String getPName() {
        return PName;
    }

    public void setPName(String PName) {
        this.PName = PName;
    }

    public int getPID() {
        return PID;
    }

    public void setPID(int PID) {
        this.PID = PID;
    }

    public float getPBuyingPricePerUnit() {
        return PBuyingPricePerUnit;
    }

    public void setPBuyingPricePerUnit(float PBuyingPricePerUnit) {
        this.PBuyingPricePerUnit = PBuyingPricePerUnit;
    }
    
    
}
