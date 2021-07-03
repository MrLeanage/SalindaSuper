/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Offer.InforView;

/**
 *
 * @author Ashika
 */
public class OfferView {
    private String OfferId;
    private String OfferRate;
    private String OfferName;
    private String StartDate;
    private String EndDate;
    private String Discription;
    
    
    public OfferView(){
    
        
}

    public OfferView(String OfferId, String OfferRate, String OfferName, String StartDate, String EndDate, String Discription) {
        this.OfferId = OfferId;
        this.OfferRate = OfferRate;
        this.OfferName = OfferName;
        this.StartDate = StartDate;
        this.EndDate = EndDate;
        this.Discription = Discription;
    }

    /**
     * @return the OfferId
     */
    public String getOfferId() {
        return OfferId;
    }

    /**
     * @param OfferId the OfferId to set
     */
    public void setOfferId(String OfferId) {
        this.OfferId = OfferId;
    }

    /**
     * @return the OfferRate
     */
    public String getOfferRate() {
        return OfferRate;
    }

    /**
     * @param OfferRate the OfferRate to set
     */
    public void setOfferRate(String OfferRate) {
        this.OfferRate = OfferRate;
    }

    /**
     * @return the OfferName
     */
    public String getOfferName() {
        return OfferName;
    }

    /**
     * @param OfferName the OfferName to set
     */
    public void setOfferName(String OfferName) {
        this.OfferName = OfferName;
    }

    /**
     * @return the StartDate
     */
    public String getStartDate() {
        return StartDate;
    }

    /**
     * @param StartDate the StartDate to set
     */
    public void setStartDate(String StartDate) {
        this.StartDate = StartDate;
    }

    /**
     * @return the EndDate
     */
    public String getEndDate() {
        return EndDate;
    }

    /**
     * @param EndDate the EndDate to set
     */
    public void setEndDate(String EndDate) {
        this.EndDate = EndDate;
    }

    /**
     * @return the Discription
     */
    public String getDiscription() {
        return Discription;
    }

    /**
     * @param Discription the Discription to set
     */
    public void setDiscription(String Discription) {
        this.Discription = Discription;
    }
    
}
