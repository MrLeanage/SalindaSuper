/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ireport;

/**
 *
 * @author Danushi Pathirana
 */
public class reportEmployee {
    
    private String pname;
    private String docno;
    private String qty;
    private String amount;
    private String fullamount;

    public reportEmployee(String pname, String docno, String qty, String amount, String fullamount) {
        this.pname = pname;
        this.docno = docno;
        this.qty = qty;
        this.amount = amount;
        this.fullamount = fullamount;
    }

    /**
     * @return the pname
     */
    public String getPname() {
        return pname;
    }

    /**
     * @param pname the pname to set
     */
    public void setPname(String pname) {
        this.pname = pname;
    }

    /**
     * @return the docno
     */
    public String getDocno() {
        return docno;
    }

    /**
     * @param docno the docno to set
     */
    public void setDocno(String docno) {
        this.docno = docno;
    }

    /**
     * @return the qty
     */
    public String getQty() {
        return qty;
    }

    /**
     * @param qty the qty to set
     */
    public void setQty(String qty) {
        this.qty = qty;
    }

    /**
     * @return the amount
     */
    public String getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(String amount) {
        this.amount = amount;
    }

    /**
     * @return the fullamount
     */
    public String getFullamount() {
        return fullamount;
    }

    /**
     * @param fullamount the fullamount to set
     */
    public void setFullamount(String fullamount) {
        this.fullamount = fullamount;
    }
    
    
    
    
}
